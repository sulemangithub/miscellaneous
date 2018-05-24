package com.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class SamplePDF {

	/**
	 * @param args
	 * @throws DocumentException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		
		/*		
		refer this link for creating PDF.
		http://www.vogella.com/articles/JavaPDF/article.html
		*/
		
		Document document=new Document();
		PdfWriter.getInstance(document, new FileOutputStream("d:\\sample.pdf"));
		document.open();
		
		document.addTitle("IRCTC");
		document.addAuthor("suleman soudagar");
		document.addCreationDate();
		
		Paragraph prefec=new Paragraph();
		
		prefec.add("THIS IS FIRST PDF...");
		prefec.setFont(new Font(FontFamily.TIMES_ROMAN,20f,Font.BOLD,BaseColor.GREEN));
		
		document.add(prefec);
				
		//document.newPage(); if needs another page.
		
		
		PdfPTable table=new PdfPTable(3);
		
		PdfPCell c1=new PdfPCell(new Phrase("1"));
		PdfPCell c2=new PdfPCell(new Phrase("2"));
		PdfPCell c3=new PdfPCell(new Phrase("3"));
		
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c2.setHorizontalAlignment(Element.ALIGN_CENTER);
		c3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
			
		table.addCell(c1);
		table.addCell(c2);
		table.addCell(c3);
		
		PdfPCell c4=new PdfPCell(new Phrase("4"));
		PdfPCell c5=new PdfPCell(new Phrase("5"));
		PdfPCell c6=new PdfPCell(new Phrase("6"));
		
		
		c4.setHorizontalAlignment(Element.ALIGN_CENTER);
		c5.setHorizontalAlignment(Element.ALIGN_CENTER);
		c6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
			
		table.addCell(c4);
		table.addCell(c5);
		table.addCell(c6);
		table.addCell(c6);
		
		
		document.add(table);		
		
		document.close();
		
		System.out.println("pdf created....");
		
		
		
		

	}

}
