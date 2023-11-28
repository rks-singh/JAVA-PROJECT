package com.ravi.utils;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.ravi.binding.EligibilityDeterminationInfo;


@Component
public class PdfUtils {

	public File generatePdf(EligibilityDeterminationInfo info) {

		File file = new File("citizenEdInfo.pdf");
		try (FileOutputStream out = new FileOutputStream(file); Document document = new Document();) {

			// Getting instance of pdfWriter to send PDF to S3.
			PdfWriter.getInstance(document, out);

			// Opening created document to change it.
			document.open();

			// Creating Font and Setting Font style and size.
			Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			fontTitle.setSize(20);

			// Creating Paragraph
			Paragraph paragraph = new Paragraph("Citizen Eligibility Determination Info", fontTitle);
			// Aligning the paragraph in the document.
			paragraph.setAlignment(Element.ALIGN_CENTER);

			// Adding the created paragraph in the document.
			document.add(paragraph);

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
			cell.setPhrase(new Phrase("Case Number", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Plan Name", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Plan Status", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Plan Start Date", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Plan End Date", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Benefit Amount", font));
			table.addCell(cell);
			cell.setPhrase(new Phrase("Denial Reason", font));
			table.addCell(cell);

			// Adding Citizen case Number.
			table.addCell(String.valueOf(info.getCaseNumber()));
			// Adding Citizen plan Name.
			table.addCell(info.getPlanName());
			// Adding Citizen plan Status.
			table.addCell(info.getPlanStatus());
			// Adding Citizen Plan start date.
			table.addCell(String.valueOf(info.getPlanStartDate()));
			// Adding Citizen plan end date.
			table.addCell(String.valueOf(info.getPlanEndDate()));
			// Adding Citizen Benefit Amount.
			table.addCell(String.valueOf(info.getBenefitAmount()));
			// Adding Citizen Plan denial reason.
			table.addCell(info.getDenialReason());

			// Adding the created table into document.
			document.add(table);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;

	}
}
