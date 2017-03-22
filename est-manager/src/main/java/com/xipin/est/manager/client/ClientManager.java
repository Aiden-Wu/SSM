package com.xipin.est.manager.client;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.xipin.est.db.bean.DetailListBean;
import com.xipin.est.db.bean.DetailListDeleteBean;
import com.xipin.est.db.bean.DetailListSubmitBean;
import com.xipin.est.db.bean.DetailListUpdateBean;
import com.xipin.est.db.bean.PackageListBean;
import com.xipin.est.db.bean.PackageUpdateBean;
import com.xipin.est.db.bean.UploadExcelBean;
import com.xipin.est.db.po.DetailListPo;
import com.xipin.est.db.po.client.DetailDataListPo;
import com.xipin.est.db.po.post.OrgJGPo;
import com.xipin.est.db.po.post.PackageListPo;
import com.xipin.est.service.vo.excel.check.CheckResultDataVO;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.rslt.type.Result;

public interface ClientManager {
	
	Result<CheckResultDataVO> handleExcel(UploadExcelBean uploadExcelBean,List<String[]> excelData);
	
	public Result<List<DetailDataListPo>> getFirstDetailList(DetailListBean detailListBean, PageBean<DetailDataListPo> page);
	
	public Result<List<DetailDataListPo>> getCommitDetailList(DetailListBean detailListBean, PageBean<DetailDataListPo> page);
	
	Result<String> deleteDetailList(DetailListDeleteBean detailListBean);
	
	public Result<String> submitDetailList(DetailListSubmitBean detailListSubmitBean);

	Result<String> insertData(UploadExcelBean bean, DetailListPo detailListPo, String dispatchNo, Set<byte[]> bagNoSet, Set<byte[]> refIdSet, Set<byte[]> sealSet, String uuid);
	
	public Map<String, Object> getDetailListForExportData(String[] dispatchNoArray, String language);
	
	public Result<String> updateCN35(PackageUpdateBean packageUpdateBean);
	
	Result<List<OrgJGPo>> toAddOrder(Long userId);
	
	Result<String> checkDispatch(String dispatchNo);
	
	Result<List<OrgJGPo>> getPostOfficeList(Long userId);

	Result<List<PackageListPo>> queryPackageList(PackageListBean initBean, PageBean<PackageListPo> initPage);

	Result<String> updateTruckingNo(DetailListUpdateBean bean); 
	
}
