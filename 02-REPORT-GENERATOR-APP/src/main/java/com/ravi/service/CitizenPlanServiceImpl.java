package com.ravi.service;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.ravi.binding.SearchCriteria;
import com.ravi.entity.CitizenPlan;
import com.ravi.repository.CitizenPlanRepository;
import com.ravi.util.EmailUtils;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CitizenPlanServiceImpl implements CitizenPlanService {

	@Autowired
	private CitizenPlanRepository citizenPlanRepository;

	@Autowired
	private EmailUtils emailUtils;

	@Override
	public List<String> getPlanNames() {
		return citizenPlanRepository.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return citizenPlanRepository.getPlanStatus();
	}

	// Implementation of Dynamic Search Functionality.
	@Override
	public List<CitizenPlan> searchCitizens(SearchCriteria criteria) {

		CitizenPlan search = new CitizenPlan();

		if (StringUtils.isNotBlank(criteria.getPlanName())) {
			search.setPlanName(criteria.getPlanName());
		}
		if (StringUtils.isNotBlank(criteria.getPlanStatus())) {
			search.setPlanStatus(criteria.getPlanStatus());
		}
		if (StringUtils.isNotBlank(criteria.getGender())) {
			search.setGender(criteria.getGender());
		}
		if (criteria.getPlanStartDate() != null) {
			search.setPlanStartDate(criteria.getPlanStartDate());
		}
		if (criteria.getPlanEndDate() != null) {
			search.setPlanEndDate(criteria.getPlanEndDate());
		}
		return citizenPlanRepository.findAll(Example.of(search));
	}

	// Implementation of generating excel sheet functionality..

	@Override
	public void generateExcelReport(HttpServletResponse response) throws IOException {

		List<CitizenPlan> citizens = citizenPlanRepository.findAll();

		try (HSSFWorkbook workbook = new HSSFWorkbook();) {
			HSSFSheet sheet = workbook.createSheet("CitizebPlan Info");
			HSSFRow row = sheet.createRow(0);

			row.createCell(0).setCellValue("Name");
			row.createCell(1).setCellValue("Email");
			row.createCell(2).setCellValue("Phone No.");
			row.createCell(3).setCellValue("SSN");
			row.createCell(4).setCellValue("Gender");
			row.createCell(5).setCellValue("Plan Name");
			row.createCell(6).setCellValue("Plan Status");

			int dataRowIndex = 1;

			for (CitizenPlan citizen : citizens) {
				HSSFRow dataRow = sheet.createRow(dataRowIndex);
				dataRow.createCell(0).setCellValue(citizen.getName());
				dataRow.createCell(1).setCellValue(citizen.getEmail());
				dataRow.createCell(2).setCellValue(citizen.getPhone());
				dataRow.createCell(3).setCellValue(citizen.getSsn());
				dataRow.createCell(4).setCellValue(citizen.getGender());
				dataRow.createCell(5).setCellValue(citizen.getPlanName());
				dataRow.createCell(6).setCellValue(citizen.getPlanStatus());
				dataRowIndex++;
			}

			// to send file as a attachment in email.
			File file = new File("data.xls");
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			emailUtils.sendEmial(file);

			// to download file in browser.
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
			outputStream.close();
		}
	}

	// Implementation of generating PDF functionality..

	@Override
	public void generatePdf(HttpServletResponse response)  {
		
		File file = new File("data.pdf");
		try(FileOutputStream out = new FileOutputStream(file);
				Document document1 = new Document();
				Document document2 = new Document();
				){
			
			List<CitizenPlan> citizens = citizenPlanRepository.findAll();

			// Creating object for Document.
			
			// Getting instance of pdfWriter to send PDF to browser
			PdfWriter.getInstance(document1, response.getOutputStream());

			// Getting instance of pdfWriter to send PDF to email.
			PdfWriter.getInstance(document2, out);

			// Opening created document to change it.
			document1.open();
			document2.open();

			// Creating Font and Setting Font style and size.
			Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			fontTitle.setSize(20);

			// Creating Paragraph
			Paragraph paragraph = new Paragraph("List of the Citizens", fontTitle);
			// Aligning the paragraph in the document.
			paragraph.setAlignment(Element.ALIGN_CENTER);

			// Adding the created paragraph in the document.
			document1.add(paragraph);
			document2.add(paragraph);

			// Creating table for 7 Column.
			PdfPTable table = new PdfPTable(7);

			// Setting Width of the table it's column and spacing
			table.setWidthPercentage(100);
			table.setWidths(new int[] { 3, 3, 3, 3, 3, 3, 3 });
			table.setSpacingBefore(7);

			// Creating table cell for table header.
			PdfPCell cell = new PdfPCell();
			// Setting background color and padding of the table cell.
			cell.setBackgroundColor(Color.BLUE);
			cell.setPadding(6);

			// Creating Font and setting font style.
			Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			font.setColor(Color.WHITE);

			// Adding heading in the created table cell
			// Adding cell to table.
			cell.setPhrase(new Phrase("Name", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Email", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Phone No.", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("SSN", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Gender", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Plan Name", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Plan Status", font));
			table.addCell(cell);

			// Iterating the list of citizens
			for (CitizenPlan citizenPlan : citizens) {
				// Adding Citizen name.
				table.addCell(citizenPlan.getName());
				// Adding Citizen email
				table.addCell(citizenPlan.getEmail());
				// Adding Citizen phone No.
				table.addCell(String.valueOf(citizenPlan.getPhone()));
				// Adding Citizen SSN.
				table.addCell(String.valueOf(citizenPlan.getSsn()));
				// Adding Citizen Gender
				table.addCell(citizenPlan.getGender());
				// Adding Citizen Plan Name.
				table.addCell(citizenPlan.getPlanName());
				// Adding Citizen Plan status
				table.addCell(citizenPlan.getPlanStatus());
			}

			// Adding the created table into document.
			document1.add(table);
			document2.add(table);
			emailUtils.sendEmial(file);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
