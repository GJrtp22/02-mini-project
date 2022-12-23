package in.allstates.util;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import in.allstates.bindings.InsurancePlanCustomers;


@Component
public class ReportGenerator {

	public String downloadToExcel(List<InsurancePlanCustomers> insurancePlanCustomers, HttpServletResponse response)
			throws IOException {
		response.setContentType("application/octet-stream");

		String headerkey = "Content-Disposition";
		String headervalue = "attachment;filename=InsurancePlanCustomers.xls";

		response.setHeader(headerkey, headervalue);

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

		int dataRowIndex = 1;
		for (InsurancePlanCustomers entry : insurancePlanCustomers) {
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

	public String downloadToPdf(List<InsurancePlanCustomers> insurancePlanCustomers,
			HttpServletResponse httpServletResponse) throws DocumentException, IOException {

		httpServletResponse.setContentType("application/pdf");

		String headerkey = "Content-Disposition";
		String headervalue = "attachment;filename=InsurancePlan_Customers.pdf";

		httpServletResponse.setHeader(headerkey, headervalue);

		// create document
		Document document = new Document();
		PdfWriter.getInstance(document, httpServletResponse.getOutputStream());

		// open document
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLUE);

		// create main heading as paragraph sentence
		Paragraph p = new Paragraph("List of Insurance Plan Customers", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		// add paragraph to document
		document.add(p);

		// create table and its styles
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 2.5f, 6.5f, 10.5f, 8.5f, 5.5f, 4.5f, 8.9f, 8.5f });
		table.setSpacingBefore(10);

		// create cell and its styles
		PdfPCell cell = new PdfPCell();
		cell.setPadding(5);
		cell.setBackgroundColor(BaseColor.BLUE);
		

		Font cellFont = FontFactory.getFont(FontFactory.HELVETICA);
		cellFont.setColor(BaseColor.WHITE);
		cellFont.setSize(12);
		

		// add table headers
		cell.setPhrase(new Phrase("ID", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("NAME", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("EMAIL", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("PHONE NUMBER", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("GENDER", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("SSN", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("PLAN NAME", cellFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("PLAN STATUS", cellFont));
		table.addCell(cell);

		// add table data
		for (InsurancePlanCustomers entry : insurancePlanCustomers) {
			table.addCell(String.valueOf(entry.getCustomerId()));
			table.addCell(entry.getCustomerName());
			table.addCell(entry.getCustomerEmail());
			table.addCell(entry.getCustomerPhoneNumber());
			table.addCell(entry.getCustomerGender());
			table.addCell(String.valueOf(entry.getCustomerSSN()));
			table.addCell(entry.getPlanName());
			table.addCell(entry.getPlanStatus());
		}

		// add table to document
		document.add(table);
		document.close();

		return null;
	}

}
