package com.miniproject.ReportEngine.Service;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.miniproject.ReportEngine.Model.CustomerReport;
import com.miniproject.ReportEngine.Repo.RepoCust;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class CustService 
{
	@Autowired
	RepoCust repoCust;
	

	public String generateReport()
	{
		try {
			List<Object[]> custreport = repoCust.customerReport();
			List<CustomerReport> reportList = new ArrayList<>();
			
			for(Object[] tr : custreport ) {
				
				CustomerReport report = new CustomerReport();
				
				report.setId((Long)tr[0]);
				report.setName((String)tr[1]);
				report.setAddress((String)tr[2]);
				report.setPhone((String)tr[3]);
				report.setGender((String)tr[4]);
				report.setEmail((String)tr[5]);
				report.setDateOfRegister((Date)tr[6]);
				report.setActiveAccount((Boolean)tr[7]);		
				
				reportList.add(report);
			}
			String reportPath ="E:\\miniProject\\ReportEngine\\src\\main\\resources";
					
			JasperReport jasperReport = JasperCompileManager
					.compileReport(reportPath+"\\customer_report.jrxml");
			
		
			JRBeanCollectionDataSource jrBeanCollectionDataSource = 
					new JRBeanCollectionDataSource(reportList);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("createdBy", "NH Anggraeni");

			
			JasperPrint jasperprint = JasperFillManager
					.fillReport(jasperReport, map, jrBeanCollectionDataSource);
			
			JasperExportManager.exportReportToXmlFile(jasperprint, reportPath, true);
			
			System.out.println("Done");
			
			return "jasper report successfuly generated @Path= "+reportPath;
			
		}catch (Exception e) {
			e.printStackTrace();
			return "Error--> check console log";
		}
	}
		
	}


