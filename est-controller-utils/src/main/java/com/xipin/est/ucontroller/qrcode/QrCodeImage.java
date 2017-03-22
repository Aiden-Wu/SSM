package com.xipin.est.ucontroller.qrcode;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QrCodeImage {
	private static final int QR_SIZE = 300;
	private static final int LOG_SZIE = 40;

	public static void createImage(HttpServletResponse response, String value,
			String imageUrl) throws Exception {
		BufferedImage image = initQrCode(value);
		Image log = createLog(imageUrl);
		outputQrImage(image, log, response);
	}

	private static BufferedImage initQrCode(String value)
			throws WriterException {
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(value,
				BarcodeFormat.QR_CODE, QR_SIZE, QR_SIZE, hintMap);
		int width = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(width, width,
				BufferedImage.TYPE_INT_RGB);

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < width; y++) {
				image.setRGB(x, y, byteMatrix.get(x, y) ? 0xFF000000
						: 0xFFFFFFFF);
			}
		}
		return image;
	}

	private static Image createLog(String imageUrl) throws IOException {
		File file = new File(imageUrl);
		Image src = ImageIO.read(file);

		Image imageLog = src.getScaledInstance(LOG_SZIE, LOG_SZIE,
				Image.SCALE_SMOOTH);

		BufferedImage image = new BufferedImage(LOG_SZIE, LOG_SZIE,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.drawImage(imageLog, 0, 0, null);
		g.dispose();
		return imageLog;
	}

	private static void outputQrImage(BufferedImage image, Image log,
			HttpServletResponse response) throws IOException {
		Graphics2D graphics = (Graphics2D) image.getGraphics();
		int x = (QR_SIZE - LOG_SZIE) / 2;
		graphics.drawImage(log, x, x, LOG_SZIE, LOG_SZIE, null);
		Shape shape = new RoundRectangle2D.Float(x, x, LOG_SZIE, LOG_SZIE, 6, 6);
		graphics.setStroke(new BasicStroke(3f));
		graphics.draw(shape);
		ImageIO.write(image, "png", response.getOutputStream());
	}
}
