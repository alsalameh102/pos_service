/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author ETDelacruz
 */
public class POSFileHandler {
    
    static File bgImg;
    static OutputStream out;
    static InputStream in;
    
    public static File getBGImageFile(String name){
    
        bgImg = new File("./setup/"+name);
        return bgImg;
    }
    
    public static boolean copyDirectory(File sourceLocation , File targetLocation){

        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            for (String children1 : children) {
                copyDirectory(new File(sourceLocation, children1), new File(targetLocation, children1));
            }
        } else {

            try {
                in = new FileInputStream(sourceLocation);
                out = new FileOutputStream(targetLocation);
                // Copy the bits from instream to outstream
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }   
                
                in.close();
                out.close();
                
                return true;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(POSFileHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(POSFileHandler.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(POSFileHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return false;
    }
    
    public static boolean writePDF(TableView tv, String csvFile, String intro){
    
        
        
        return false;
    }
    
    public static boolean writeExcel(TableView tv, String csvFile, String intro){
        Writer writer = null;
        try {
            File file = new File("./reports/"+csvFile);
            writer = new BufferedWriter(new FileWriter(file));
            
            writer.write(intro);
            
            //columns
            String text = "";
            for (Iterator it = tv.getColumns().iterator(); it.hasNext();) {
                TableColumn column = (TableColumn) it.next();
                text = text + column.getText();
                text = text + ",";
            }
            text = text + "\n";
            //System.out.print(text);
            writer.write(text);
            //rows
            
            for (Iterator it = tv.getItems().iterator(); it.hasNext();) {
                ObservableList<String> item = (ObservableList<String>) it.next();
                text = "";
                for (String s : item){
                    text = text + s;
                    text = text + ",";
                }
                text = text + "\n";
                //System.out.print(text);
                writer.write(text);
            }
            
            return true;
            
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                
                Logger.getLogger(POSFileHandler.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } 
        
        
    }
    
     
}
