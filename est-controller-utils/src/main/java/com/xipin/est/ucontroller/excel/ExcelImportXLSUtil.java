package com.xipin.est.ucontroller.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.eventusermodel.FormatTrackingHSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.eventusermodel.MissingRecordAwareHSSFListener;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelImportXLSUtil implements HSSFListener {
	private SSTRecord sstrec;

	private List<String[]> list = new ArrayList<String[]>();
	
	private int totalCol = 0;
	
	private int sheetNum = 0;
	
	private FormatTrackingHSSFListener formatListener;
	
	private boolean isComplete = false;
	
	public ExcelImportXLSUtil(int totalCol){
		this.totalCol = totalCol;
	}
	/**
	 * This method listens for incoming records and handles them as required.
	 * 
	 * @param record
	 *            The record that was found while reading.
	 */
	public void processRecord(Record record) {
		if(sheetNum > 1){
			return;
		}
		if(isComplete){
			return;
		}
		switch (record.getSid()) {
		// the BOFRecord can represent either the beginning of a sheet or the
		// workbook
		case BOFRecord.sid:
			BOFRecord bof = (BOFRecord) record;
			if (bof.getType() == bof.TYPE_WORKBOOK) {
				System.out.println("Encountered workbook");
				// assigned to the class level member
			} else if (bof.getType() == bof.TYPE_WORKSHEET) {
				System.out.println("Encountered s");
				sheetNum++;
			}
			break;
		case NumberRecord.sid:
			NumberRecord numrec = (NumberRecord) record;
			if(get(numrec.getRow()).length <= numrec.getColumn()){
				break;
			}
			if("m/d/yy".equals(formatListener.getFormatString(numrec))){
				Date date=HSSFDateUtil.getJavaDate(numrec.getValue());
				get(numrec.getRow())[numrec.getColumn()] = formateDateToString(date);
			} else{
				int val = new Double(numrec.getValue()).intValue();
				if(numrec.getValue() == val){
					get(numrec.getRow())[numrec.getColumn()] = val+"";
				} else{
					get(numrec.getRow())[numrec.getColumn()] = numrec.getValue()+"";
				}
			}
			break;
		case SSTRecord.sid:
			sstrec = (SSTRecord) record;
			break;
		case BlankRecord.sid:
			BlankRecord b = (BlankRecord) record;
			if(b.getColumn() == 0){
				isComplete = true;
				return;
			}
			if(get(b.getRow()).length <= b.getColumn()){
				break;
			}
			get(b.getRow())[b.getColumn()] = "";
			break;
		case LabelSSTRecord.sid:
			LabelSSTRecord lrec = (LabelSSTRecord) record;
			if(get(lrec.getRow()).length <= lrec.getColumn()){
				break;
			}
			get(lrec.getRow())[lrec.getColumn()] = sstrec.getString(lrec.getSSTIndex()).toString();
			break;
		}
	}

	private String formateDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化日期
		return sdf.format(date);
	}
	
	private String[] get(int i){
		if(this.list.size() < i + 1){
			System.out.println(i);
			this.list.add(new String[this.totalCol]);
		}
		return this.list.get(i);
	}
	
	/**
	 * Read an excel file and spit out what we find.
	 *
	 * @param args
	 *            Expect one argument that is the file to read.
	 * @throws IOException
	 *             When there is an error processing the file.
	 */
	public static List<String[]> readerExcel(InputStream fin, int totalCol) throws IOException {
		// create a new file input stream with the input file specified
		// at the command line
		// create a new org.apache.poi.poifs.filesystem.Filesystem
		ExcelImportXLSUtil lsnr = new ExcelImportXLSUtil(totalCol);  
        
        MissingRecordAwareHSSFListener listener = new MissingRecordAwareHSSFListener(lsnr);  
        lsnr.formatListener = new FormatTrackingHSSFListener(listener);
		POIFSFileSystem poifs = new POIFSFileSystem(fin);
		// get the Workbook (excel part) stream in a InputStream
		InputStream din = poifs.createDocumentInputStream("Workbook");
		// construct out HSSFRequest object
		HSSFRequest req = new HSSFRequest();
		// lazy listen for ALL records with the listener shown above
		
		{
			req.addListenerForAllRecords(lsnr.formatListener);
		}
		// create our event factory
		HSSFEventFactory factory = new HSSFEventFactory();
		// process our events based on the document input stream
		factory.processEvents(req, din);
		// once all the events are processed close our file input stream
		fin.close();
		// and our document input stream (don't want to leak these!)
		din.close();
		return lsnr.list;
	}
	
	private static void print(List<String[]> list){
		for(String[] l : list){
			for(String s : l){
				System.out.print(s + " ->");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<String[]> list = ExcelImportXLSUtil.readerExcel(new FileInputStream(new File("F:\\希品工作文档\\EST\\EST模板\\PZ.xls")), 9);
		print(list);
	}
}
