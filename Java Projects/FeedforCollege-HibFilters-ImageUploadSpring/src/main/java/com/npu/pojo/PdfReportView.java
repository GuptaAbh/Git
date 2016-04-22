package com.npu.pojo;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

import javax.print.DocFlavor.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.GroupLayout.Alignment;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Header;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.simpleparser.TableWrapper;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfReportView extends com.npu.dao.AbstractPdfView
{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		RegisteredUser user = (RegisteredUser) session.getAttribute("user");
		System.out.println("path"+System.getProperty("catalina.home"));
		document.open();
		String RESOURCE = System.getProperty("catalina.home")+"/images/"+user.getProfilepicName();
		Paragraph p = new Paragraph("User Profile Details");
		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);
		Image img = Image.getInstance(RESOURCE);
		img.scaleAbsolute(150f, 150f);
		img.setAlignment(Element.ALIGN_CENTER);
		document.add(img);
	    
		PdfPTable table = new PdfPTable(2);
		PdfPCell firstName = new PdfPCell(new Paragraph("Fist Name"));
		PdfPCell firstNamevalue = new PdfPCell(new Paragraph(user.getFirstName()));
		PdfPCell lastName = new PdfPCell(new Paragraph("Last Name"));
		PdfPCell lastNamevalue = new PdfPCell(new Paragraph(user.getLastName()));
		PdfPCell userName = new PdfPCell(new Paragraph("User Name"));
		PdfPCell userNamevalue = new PdfPCell(new Paragraph(user.getUserName()));
		PdfPCell collegeName = new PdfPCell(new Paragraph("College Name"));
		PdfPCell collegeNamevalue = new PdfPCell(new Paragraph(user.getCollegename()));
		PdfPCell ContactNumber = new PdfPCell(new Paragraph("Contact Number"));
		PdfPCell ContactNumbervalue = new PdfPCell(new Paragraph(user.getContactNum()));
		PdfPCell email = new PdfPCell(new Paragraph("Email"));
		PdfPCell emailvalue = new PdfPCell(new Paragraph(user.getEmail()));

		table.addCell(firstName);
        table.addCell(firstNamevalue);
        table.addCell(lastName);
        table.addCell(lastNamevalue);
        table.addCell(userName);
        table.addCell(userNamevalue);
		table.addCell(collegeName);
        table.addCell(collegeNamevalue);
        table.addCell(ContactNumber);
        table.addCell(ContactNumbervalue);
        table.addCell(email);
        table.addCell(emailvalue);
        document.add(table);
        
        PdfContentByte cb = writer.getDirectContent();
        Phrase footer = new Phrase("<!----------@gupta.abh-----------!>");
        float rotation;
		ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
        		footer, (document.right()-document.left())/2, document.bottom(),0);
		
		document.close();
	}
}
