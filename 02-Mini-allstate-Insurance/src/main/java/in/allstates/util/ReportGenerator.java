package in.allstates.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.allstates.bindings.InsurancePlanCustomers;
import in.allstates.dto.CustomerDto;

@Component
public class ReportGenerator{
	
	
	public String downloadToExcel(List<InsurancePlanCustomers> insurancePlanCustomers, HttpServletResponse response) throws IOException
	{	
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet("InsurancePlanCustomers");
		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("EMAIL");
		row.createCell(3).setCellValue("PHONE_NUMBER");
		row.createCell(4).setCellValue("GENDER");
		row.createCell(5).setCellValue("SSN");
		row.createCell(6).setCellValue("PLAN_NAME");
		row.createCell(7).setCellValue("PLAN_STATUS");
		
		int dataRowIndex=1;
		for(InsurancePlanCustomers entry: insurancePlanCustomers )
		{
			XSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(entry.getCustomerId());
			dataRow.createCell(1).setCellValue(entry.getCustomerName());
			dataRow.createCell(2).setCellValue(entry.getCustomerEmail());
			dataRow.createCell(3).setCellValue(entry.getCustomerPhoneNumber());
			dataRow.createCell(4).setCellValue(entry.getCustomerGender());
			dataRow.createCell(5).setCellValue(entry.getCustomerSSN());
			dataRow.createCell(6).setCellValue(entry.getPlanName());
			dataRow.createCell(7).setCellValue(entry.getPlanStatus());
			dataRowIndex++;
			
			
		}
		
		ServletOutputStream ops = response.getOutputStream();
		workBook.write(ops);
		workBook.close();
		ops.close();
		
		
		return "Successfully Downloaded";
	}
	
	public String downloadToPdf(List<InsurancePlanCustomers> insurancePlanCustomers) {
				return null;
	}
	
	

}
