package invoicedesktop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class csvReadWrite {

    public boolean write(String data, String filePath) {
        //List<List<String>> rows = Arrays.asList();
        //  String [] rows =new String[data.length];
        File file = new File(filePath);

        // ArrayList<invoice> invoice = new ArrayList<invoice>();
        try {
            if (!file.exists())
                file.createNewFile();
            BufferedWriter  csvWriter = new BufferedWriter(new FileWriter(filePath, true) );
            csvWriter.write(data);
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return false;
    }

    public void clearTheFile(String filePath)  {
        try{ BufferedWriter pwOb = new BufferedWriter(new FileWriter(filePath, false));
            pwOb.flush();
            pwOb.close();}
        catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
    public ArrayList<invoice> read(String header ,String line) {
//        Scanner  csvReader = null;
//            Scanner reader = null;

        try {
            ArrayList<invoice> invoices = new ArrayList<invoice>();
            //ArrayList<invoiceItem> items =new ArrayList<invoiceItem>();

            Scanner  csvReader = new Scanner(new File(header));
//            invoice invoice =null;

            while (csvReader.hasNext() ) {
                invoice invoice =null;

                invoice = new invoice();
                String Line = csvReader.nextLine();
                String[] seprated = Line.split(",");
                invoice.setInvoiceNO(Integer.parseInt(seprated[0]));
                invoice.setDate(seprated[1]);
                invoice.setClientName(seprated[2]);
                Scanner  reader = new Scanner(new File(line));
//                invoiceItem item = null;
                ArrayList<invoiceItem> items =new ArrayList<invoiceItem>();

                while (reader.hasNext()){

                    invoiceItem item = null;

                    item =new invoiceItem();
                    String itemLine = reader.nextLine();
                    String[] separator = itemLine.split(",");
                    if(seprated[0].equals(separator[0])){

                        item.setItemName(separator[1]);
                        item.setItemPrice(Double.parseDouble(separator[2]));
                        item.setItemCount(Integer.parseInt(separator[3]));
                        item.setInvoice(invoice);
                        items.add(item);
                    }
                }
                reader.close();
                invoice.setInvoiceItems(items);
                invoices.add(invoice);
            }
            csvReader.close();
            return  invoices;


        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }finally {
            //csvReader.close();
            //reader.close();

        }

        return null;
    }
}