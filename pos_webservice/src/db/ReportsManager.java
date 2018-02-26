/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.tables.ProductsDB;
import db.tables.TimeKeepingDB;
import db.tables.RegisterTransactionsDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import objects.AisleOBJ;
import objects.CategoryOBJ;
import objects.HoldTransactionOBJ;
import objects.ProductOBJ;
import objects.SoldItemOBJ;
import objects.TransactionOBJ;
import objects.VendorOBJ;

import utils.POSCalendar;

/**
 *
 * @author ETDelacruz
 */
public class ReportsManager {
    
    private DBFactory dbf;
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private PreparedStatement pstmt;
    
    private ArrayList<ProductOBJ> inventory, searchResult;
    private ArrayList<AisleOBJ> aisles;
    private ArrayList<CategoryOBJ> categories;
    private ArrayList<VendorOBJ> vendors;
    
    private ArrayList<HoldTransactionOBJ> heldtransactions;
    private ArrayList<TransactionOBJ> transactions;
    private ArrayList<SoldItemOBJ> solditems;
    
    private ObservableList<ObservableList> data;
    
    public ReportsManager(){
        dbf = new DBFactory();
    }
   
    public void openSingleDatePicker(){
        
    }
    
    public ObservableList<ObservableList> returnReport(TableView tv, String reportQuery){
    
        conn = dbf.getConn();
        data = FXCollections.observableArrayList();
        
        if(conn != null){
            tv.getColumns().clear();
            tv.getItems().clear();
            try {
                stmt = conn.createStatement();
            
                rs = stmt.executeQuery(reportQuery);
                
                for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                    final int j = i;                
                    TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                            return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });

                    tv.getColumns().addAll(col); 
                    //System.out.println("Column ["+i+"] ");
                }
                
                while(rs.next()){
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                //System.out.println("Row [1] added "+row );
                data.add(row);
                    
                }
                
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            
            return data;
        }
        
        return null;
    }
    
        public ObservableList<ObservableList> returnSalesReport(TableView tv){
    
        conn = dbf.getConn();
        data = FXCollections.observableArrayList();
        
        
        double totalAmt = 0, totalBal = 0;
        
        if(conn != null){
            tv.getColumns().clear();
            tv.getItems().clear();
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(RegisterTransactionsDB.GET_SALES_REPORT_OVERALL);
                
                for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                    final int j = i;                
                    TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));

                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                            return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });

                    tv.getColumns().addAll(col); 
                    //System.out.println("Column ["+i+"] ");
                }
                
                while(rs.next()){
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                        if(i == 3){
                            totalAmt = totalAmt + rs.getDouble(i+1);
                        }else if(i == 4){
                            totalBal = totalBal + rs.getDouble(i+1);
                        }
                    
                        row.add(rs.getString(i));
                    }
                    
                    
                //System.out.println("Row [1] added "+row );
                    data.add(row);

                }
                
                //data.add(FXCollections.observableArrayList());
                ObservableList<String> totalrow = FXCollections.observableArrayList();
                    totalrow.add("");
                    totalrow.add("Total Amount : ");
                    totalrow.add(""+totalAmt);
                    totalrow.add("Total Balance : ");
                    totalrow.add(""+totalBal);
                    data.add(totalrow);
                
                /*rs.close();
                stmt.close();
                
                stmt = conn.createStatement();
                rs = stmt.executeQuery(Transactions.GET_SALES_REPORT_OVERALL_TOTAL);
                
                while(rs.next()){
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                        row.add(rs.getString(i));
                    }
                    data.add(row);
                }*/
                
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            
            return data;
        }
        
        return null;
    }
    
    
    public ObservableList<ObservableList> returnTimeKeepingReport(TableView tv, String date){
    
        conn = dbf.getConn();
        data = FXCollections.observableArrayList();
        
        if(conn != null){
            tv.getColumns().clear();
            tv.getItems().clear();
            try {
                
                pstmt = conn.prepareStatement(TimeKeepingDB.GET_TIMERECORDS_SPECIFIC_DATE.replace("{YYYYMMDD}", POSCalendar.getYYYYMMDD()));
                pstmt.setString(1, date);
                pstmt.setString(2, date);
                rs = pstmt.executeQuery();
                
                for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                    final int j = i;                
                    TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));

                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                            return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });

                    tv.getColumns().addAll(col); 
                    //System.out.println("Column ["+i+"] ");
                }
                
                while(rs.next()){
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                        row.add(rs.getString(i));
                    }

                    data.add(row);
                }
                
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
                //Main.control.showErrorMessage(InventoryManager.class.getName() +" : "+ex.toString());
            }
            
            return data;
        }
        return null;
    }
}
