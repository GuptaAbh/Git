package com.npu.pojo;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfReportView extends com.npu.dao.AbstractPdfView
{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		// TODO Auto-generated method stub
		document.open();
        document.add(new Paragraph("A Hello World PDF document."));
        document.close(); // no need to close PDFwriter?
		
	}


}
