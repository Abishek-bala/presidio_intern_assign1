package day15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;

import jxl.write.*;
import jxl.write.Number;
import jxl.Workbook;



public class CreateInvoice {
	public static void main(String[] args) throws Exception {
		Customer c= new Customer("Abishek", "aaa,\nbbb,\nccc-123456");
		Item iphone = new Phone("iPhone", 2);
		Item lenovo= new Laptop("Laptop",1);
		ArrayList<Item> cart = new ArrayList<Item>();
		cart.add(lenovo);
		cart.add(iphone);
		c.buy(cart);
	}
}

class Customer{
	String name,address;

	public Customer(String name, String address) {
//		super();
		this.name = name;
		this.address = address;
	}
	
	public void buy(ArrayList<Item> cart) throws Exception {
		Shop shop = new Shop("Walmart",cart);
		shop.checkout(this);
	}
	
}

interface Invoice{
	public void createExcel();
	public void createPDF(Customer customer) throws Exception;
}

abstract class Item{
	Integer price;
	String name;
	Integer qty;
}

class Phone extends Item{
	
	
	public Phone(String name,Integer qty) {
		super();
		this.name = name;
		this.price = 40000;
		this.qty = qty;
	}
	
}

class Laptop extends Item{
//	String name;
	
	public Laptop(String name,Integer qty) {
		super();
		this.name = name;
		this.price = 50000;
		this.qty = qty;
	}
	
}

class Shop implements Invoice{
	
	ArrayList<Item> cart;
	
	String name;
	
	public Shop(String name,ArrayList<Item> cart) {
		super();
		this.cart = cart;
		this.name = name;
	}
	
	public void checkout(Customer customer) throws Exception {
		createExcel();
		createPDF(customer);
	}
	
	
	@Override
	public void createExcel() {
		// TODO Auto-generated method stub
		WritableWorkbook myInvoicebook = null;
        try {

            myInvoicebook = Workbook.createWorkbook(new File("E:\\Invoicebook.xls"));

            // create an Excel sheet
            WritableSheet InvoiceSheet = myInvoicebook.createSheet("Sheet 1", 0);
            Label label = new Label(0, 2, "Item");
	        InvoiceSheet.addCell(label);
	
	          
	
	          label = new Label(1, 2, "Quantity");
	          InvoiceSheet.addCell(label);
	
	          label = new Label(2, 2, "Unit Price");
	          InvoiceSheet.addCell(label);
	          label = new Label(3, 3, "Total Price	");
	          InvoiceSheet.addCell(label);

            
            int i=3;
//            System.out.println(cart);
            float subTotal = 0;
            for(Item item:cart) {
            	
//            	System.out.println(item);
            	label = new Label(0,i,item.name);
            	InvoiceSheet.addCell(label);
            	Number number =new Number(1,i,item.qty);
            	InvoiceSheet.addCell(number);
            	number =new Number(2,i,item.price);
            	InvoiceSheet.addCell(number);
            	number =new Number(3,i,item.qty*item.price);
            	InvoiceSheet.addCell(number);
            	subTotal+=item.qty*item.price;

            	
            	i++;
            	
            	
            }
            label = new Label(2,i,"Sub total");
        	InvoiceSheet.addCell(label);
        	Number number =new Number(3,i,subTotal);
        	InvoiceSheet.addCell(number);
        	i++;
        	
        	label = new Label(2,i,"State gst 9%");
        	InvoiceSheet.addCell(label);
        	subTotal+=subTotal*0.09;
        	number =new Number(3,i,(subTotal));
        	InvoiceSheet.addCell(number);
        	i++;
        	
        	label = new Label(2,i,"Nation Gst 9%");
        	InvoiceSheet.addCell(label);
        	subTotal+=subTotal*0.09;
        	number =new Number(3,i,subTotal);
        	InvoiceSheet.addCell(number);
        	i++;
        	
        	label = new Label(2,i,"Total");
        	InvoiceSheet.addCell(label);
        	number =new Number(3,i,subTotal);
        	InvoiceSheet.addCell(number);
//
            myInvoicebook.write();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } finally {

            if (myInvoicebook != null) {
                try {
                    myInvoicebook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }


        }

		
	}
	@Override
	public void createPDF(Customer customer) throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(new File("E:/Invoice.pdf")));
		document.open();
		
		 Paragraph preface;// = new Paragraph();
	     document.add(new Paragraph());
	        // Lets write a big header
	     Font titleFont = new Font(FontFamily.TIMES_ROMAN,20);
	    preface = new Paragraph(this.name,titleFont); 
	    preface.setAlignment(Element.ALIGN_CENTER);
	    document.add(preface);
	    document.add(new Paragraph());
		
		Paragraph para = new Paragraph("Shipping address");
		document.add(para);
		para = new Paragraph(customer.name+",");
		document.add(para);
		para = new Paragraph(customer.address);
		document.add(para);
		para = new Paragraph("\n");
		document.add(para);
		
		PdfPTable table = new PdfPTable(4);
		PdfPCell c1 = new PdfPCell(new Phrase("Item"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Quantity"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("UnitPrice"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("total Price"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        
        table.addCell(c1);
        table.setHeaderRows(1);
        Integer total = 0;
        for(Item item:cart) {
        c1 = new PdfPCell(new Phrase(item.name));
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase(item.qty.toString()));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase(item.price.toString()));
        table.addCell(c1);
        Integer total_price = item.qty*item.price; 
        c1 = new PdfPCell(new Phrase(total_price.toString()));
        table.addCell(c1);
        total+=total_price;
        }
        document.add(table);
        
        Paragraph summary = new Paragraph();
        Paragraph sub = new Paragraph("Total = "+total.toString());
        sub.setAlignment(Element.ALIGN_RIGHT);
        summary.add(sub);
        
        sub = new Paragraph("After state GST = "+(total+(total*0.09f)));
        sub.setAlignment(Element.ALIGN_RIGHT);
        summary.add(sub);
        
        sub = new Paragraph("After National GST = "+(total+(total*0.09f)));
        sub.setAlignment(Element.ALIGN_RIGHT);
        summary.add(sub);
        
        
        summary.setAlignment(Element.ALIGN_RIGHT);
        
        document.add(summary);
        
        
        document.close();
	}
		
}


