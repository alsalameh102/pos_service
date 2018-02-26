/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author ETDelacruz
 */

import javax.comm.*;
import java.util.*;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.PrinterName;

/** Check each port to see if it is open. **/
public class OpenPort {

    
    public void cashdrawerOpen(String PrinterName) {
        
        byte[] open = {27, 112, 48, 55, 121};
//        byte[] cutter = {29, 86,49};
        String printer = PrinterName;
        PrintServiceAttributeSet printserviceattributeset = new HashPrintServiceAttributeSet();
        printserviceattributeset.add(new PrinterName(printer,null));
        PrintService[] printservice = PrintServiceLookup.lookupPrintServices(null, printserviceattributeset);
        if(printservice.length!=1){
            System.out.println("Printer not found");
        }
        PrintService pservice = printservice[0];
        DocPrintJob job = pservice.createPrintJob();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(open,flavor,null);
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        try {
            job.print(doc, aset);
        } catch (PrintException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public static void main (String [] args) {
        Enumeration port_list = CommPortIdentifier.getPortIdentifiers ();

        while (port_list.hasMoreElements ()) { //This part in the diving, why not you?
        // Get the list of ports
            CommPortIdentifier port_id =
            (CommPortIdentifier) port_list.nextElement ();

            // Find each ports type and name
            if (port_id.getPortType () == CommPortIdentifier.PORT_SERIAL)
            {
            System.out.println ("Serial port: " + port_id.getName ());
            }
            else if (port_id.getPortType () == CommPortIdentifier.PORT_PARALLEL)
            {
            System.out.println ("Parallel port: " + port_id.getName ());
            } else
            System.out.println ("Other port: " + port_id.getName ());

            // Attempt to open it
            try {
            CommPort port = port_id.open ("PortListOpen",20);
            System.out.println (" Opened successfully");
            port.close ();
            }
            catch (PortInUseException pe)
            {
            System.out.println (" Open failed");
            String owner_name = port_id.getCurrentOwner ();
            if (owner_name == null)
            System.out.println (" Port Owned by unidentified app");
            else
            // The owner name not returned correctly unless it is
            // a Java program.
            System.out.println (" " + owner_name);
            }
        }
    } //main
} // PortListOpen
