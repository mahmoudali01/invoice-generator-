/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invoicedesktop;

import java.util.ArrayList;


public class main {
    public static void main(String []args){
    
    
    
    
    ArrayList<invoiceItem> items = new ArrayList<invoiceItem>();
        ArrayList<invoice> allInvoices = new ArrayList<invoice>();
    invoice in =new invoice();
    in.setInvoiceItems(items);
    in.setInvoiceHeader("C:\\Users\\IT\\Documents\\NetBeansProjects\\invoice-generator-\\src\\csv\\InvoiceHeader.csv");
    in.setInvoiceLine("C:\\Users\\IT\\Documents\\NetBeansProjects\\invoice-generator-\\src\\csv\\InvoiceLine.csv");
     allInvoices =in.returnAllInvoices();
    for(invoice x :allInvoices){
    System.out.println("the invoice head:  "+x.toString());
     items = x.getInvoiceItems();
     for(invoiceItem item :items ){
        System.out.println("item  " +item.toString());
     
    }
    }
    
    
    
    }
    
}
