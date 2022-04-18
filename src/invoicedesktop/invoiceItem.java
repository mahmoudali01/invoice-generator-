package invoicedesktop;

import java.util.ArrayList;

public class invoiceItem   {
    //private static String invoiceHeader =invoice.getInvoiceHeader();
      //private   String invoiceLine ;

    csvReadWrite csvRW = new csvReadWrite();
    public static ArrayList<invoiceItem> invoiceItems = new ArrayList<invoiceItem>();
    public static ArrayList<ArrayList<invoiceItem>> invoiceItemsLists = new ArrayList<ArrayList<invoiceItem>>();

    public static ArrayList<invoice> invoices = new ArrayList<invoice>();



    private String itemName;
    private int itemCount;
    private double itemPrice;
    private invoice invoice;
    public invoiceItem() {
        // loadFromFile();
    }
    public invoiceItem(String itemName,  double itemPrice,int itemCount, invoice invoice) {
        this.itemName = itemName;
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
        this.invoice = invoice;
    }



    public String getItemName() {
        return itemName;
    }

    public int getItemCount() {
        return itemCount;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public invoice getInvoice() {
        return invoice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemCount(int itemNum) {
        this.itemCount = itemNum;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setInvoice(invoice invoice) {
        this.invoice = invoice;
    }

    public double calTotalItemPrice(){
        return this.itemPrice*this.itemCount;
    }

    private String getItemData() {
        return invoice.getInvoiceNO() + "," + this.itemName + "," + this.itemPrice + "," + this.itemCount;
    }

    public void saveItemsToFile(ArrayList<invoiceItem>item) {
        invoiceItems=item;
        csvRW.clearTheFile(invoice.getInvoiceLine());

        for (int i = 0; i < invoiceItems.size(); i++) {
            csvRW.write(invoiceItems.get(i).getItemData(), invoice.getInvoiceLine());
        }
    }

//    @Override
//    public String toString() {
//        return  invoice.getInvoiceNO() + " " + itemName +  " " + itemCount + "  " + itemPrice + "  " + calTotalItemPrice() +"\n" ;
//    }

}