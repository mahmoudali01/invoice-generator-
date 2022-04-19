package invoicedesktop;

import java.util.ArrayList;

public class invoice  {
    private static   String invoiceHeader ;
    private static  String invoiceLine ;
    public String getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(String invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }



    public String getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(String invoiceLine) {
        this.invoiceLine = invoiceLine;
    }


    csvReadWrite csvRW = new csvReadWrite();

    public static ArrayList<invoice> invoices = new ArrayList<invoice>();
    private  ArrayList<invoiceItem> invoiceItems;

    private  int invoiceNO;
    private String date;
    private String clientName;



   public invoice(){

    }

    public invoice(int invoiceNO, String date, String clientName) {
        this.invoiceNO = invoiceNO;
        this.date = date;
        this.clientName = clientName;
    }

    public  int getInvoiceNO() {
        return invoiceNO;
    }

    public String getDate() {
        return date;
    }

    public String getClientName() {
        return clientName;
    }
    public ArrayList<invoiceItem> getInvoiceItems() {
        return invoiceItems;
    }




    public void setInvoiceItems(ArrayList<invoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public  void setInvoiceNO(int invoiceNO) {
        this.invoiceNO = invoiceNO;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }






    public double getItemsTotalPrice(){
        double price=0;
      if(invoiceItems.size()==0){
          return 0;
      }
           invoices =  csvRW.read(invoiceHeader,invoiceLine);

        for (int i = 0; i < invoiceItems.size(); i++){
            price+=(invoiceItems.get(i).calTotalItemPrice());
        }
        return price;
    }

    public ArrayList<invoice> returnAllInvoices() {
     invoices =  csvRW.read(invoiceHeader,invoiceLine);

        return invoices;
    }
//    public String[][] returnAllInvoicesAsArray() {
//     String [][]data = null;
//        for (int i = 0; i <= invoices.size(); i++)
//      {
//        data[i][0] = String.valueOf(invoices.get(i).getInvoiceNO());
//        data[i][1] = String.valueOf(invoices.get(i).getDate());
//        data[i][2] = String.valueOf(invoices.get(i).getClientName());
//        data[i][3] = String.valueOf(invoices.get(i).getItemsTotalPrice());
//     }
//       for (int i = 0; i <= invoices.size(); i++){
//             for (int j = 0; j <= invoices.size(); j++){
//             System.out.print(data[i][j]);
//             }
//
//        }
//       return data;
//    }
//   
    private String getInvoiceData() {
        return this.invoiceNO + "," + this.date + "," + this.clientName ;

    }
    public void saveInvoiceToFile(ArrayList<invoice>invoice) {
        invoices =invoice;
        csvRW.clearTheFile(invoiceHeader);
        for (int i = 0; i < invoices.size(); i++) {
            csvRW.write(invoices.get(i).getInvoiceData(), invoiceHeader);
        }
    }


    @Override
    public String toString() {
        return  invoiceNO + " " + date +  " " + clientName + "  " + getItemsTotalPrice() + "\n" ;
    }

}