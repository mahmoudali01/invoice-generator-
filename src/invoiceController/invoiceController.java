/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invoiceController;

import invoicedesktop.invoice;
import invoicedesktop.invoiceItem;
import java.io.File;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mahmo
 */
public  class invoiceController {
      invoice in =new invoice();
               invoiceItem item =new invoiceItem();
                File   headerFile = new File("/");
            File headerLine = new File("/");
               ArrayList<invoice> allInvoices = new ArrayList<invoice>();
               ArrayList<ArrayList<invoiceItem>> allItems =new ArrayList<ArrayList<invoiceItem>>();
    public Object [][] showInvoices(String header ,String line){
//                     Object [][]arr;

       try{
     //  DefaultTableModel invoiceModel = (DefaultTableModel) invoicesTable.getModel();

                         in.setInvoiceHeader(header);
                        in.setInvoiceLine(line);
                        allInvoices =in.returnAllInvoices();
                        for(invoice x: allInvoices){
                        allItems.add(x.getInvoiceItems());
                        }
                      Object [][] arr = new Object[allInvoices.size()][4];
                        
                                 
                        System.out.println(allInvoices.size());
                        

              // Object []rowData =new Object[4];
               
                for (int i = 0; i < allInvoices.size(); i++)
               {
         

                arr[i][0] = String.valueOf(allInvoices.get(i).getInvoiceNO());
               // System.out.println(arr[i][0]);
                 arr[i][1] = String.valueOf(allInvoices.get(i).getDate());
                  arr[i][2] = String.valueOf(allInvoices.get(i).getClientName());
                arr[i][3] = String.valueOf(allInvoices.get(i).getItemsTotalPrice());
               // invoiceModel.addRow(rowData);
              }
                return arr;
       }catch(Exception e){
              System.out.println("some invoices has no items yet");
                            System.out.println(e.getMessage());

              }
             return null;
    }
   public  Object [][] selectedInvoiceItems(int index){
//       
//        invoiceItemModel = (DefaultTableModel) invoiceItemsTable.getModel();
//       invoiceItemModel.setRowCount(0);
      try{
            Object [][]rowData =new Object[allItems.get(index).size()][4];
                for (int i = 0; i < allItems.get(index).size(); i++)
               {
                   rowData[i][0] = String.valueOf(allItems.get(index).get(i).getItemName());
                   rowData[i][1] = String.valueOf(allItems.get(index).get(i).getItemPrice());
                   rowData[i][2] = String.valueOf(allItems.get(index).get(i).getItemCount());
                   rowData[i][3] = String.valueOf(allItems.get(index).get(i).calTotalItemPrice());
                 //  invoiceItemModel.addRow(rowData);
            
        }
                return rowData;
      }catch(Exception e){
        System.out.println("invoice has no added items yet");
        }
     return null;
   }
  public Object [] createInvoice(String date,String clientName){
       ArrayList<invoiceItem> items = new ArrayList<invoiceItem>();
           int size  =allInvoices.size() + 1;
           invoice newIn =new invoice(size,date,clientName);
           newIn.setInvoiceItems(items);        
           allInvoices.add(newIn);
           allItems.add(items);

                 Object []rowData =new Object[4];

                 rowData[0] = String.valueOf(newIn.getInvoiceNO());
                 rowData[1] = String.valueOf(newIn.getDate());
                 rowData[2] = String.valueOf(newIn.getClientName());
                 rowData[3] = String.valueOf(newIn.getItemsTotalPrice());
               
                 return rowData;
        }
   public Object [] createInvoiceItem(int index ,String itemName ,String itemPrice,String itemCount){
         int count = Integer.parseInt(itemCount);
                      double price = Double.parseDouble(itemPrice);
                      invoiceItem it =new invoiceItem(itemName,price,count,allInvoices.get(index));
                       allItems.get(index).add(it);

                 Object []rowData =new Object[4];

                 rowData[0] = String.valueOf(it.getItemName());
                 rowData[1] = String.valueOf(it.getItemPrice());
                 rowData[2] = String.valueOf(it.getItemCount());
                 rowData[3] = String.valueOf(it.calTotalItemPrice());
                 
                 return rowData;
        }
   public String updateInvoicePrice(int index){
                      String pr = String.valueOf(allInvoices.get(index).getItemsTotalPrice());
                       return pr;
   }
   
   public void deleteInvoice(int index){
      
                allInvoices.remove(index);
                  allItems.remove(index);
   }
      public void deleteInvoiceItem(int index1,int index2){
                            allItems.get(index1).remove(index2);
      }
      
     public void saveFile(){
     item.setInvoice(in);
     in.saveInvoiceToFile(allInvoices);
     ArrayList<invoiceItem> items = new ArrayList<invoiceItem>();
     for( ArrayList<invoiceItem> itemAsAL:allItems){
         for(invoiceItem x :itemAsAL){
         items.add(x);
         }
     }
     item.saveItemsToFile(items);
     }

  
}
