/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package satlujwe_pos;

import config.CheckProperties;
import config.Constant;
import javafx.application.Application;
import javafx.stage.Stage;
import pos.POSDeviceManager;

/**
 *
 * @author ETDelacruz
 */
public class Main extends Application implements Constant {
    
    public static InterfaceControl control;
    public static LogicControl lcontrol;
    public static POSDeviceManager posControl;
    
    public Main(){
        
        
        control = new InterfaceControl();
        lcontrol = new LogicControl();
        posControl = new POSDeviceManager();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        control.openLogin();
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        //System.out.println(Thread.currentThread().getContextClassLoader());
        
        CheckProperties checkProperty = new CheckProperties();
        checkProperty.checkPropertyFile();
        
        launch(args);
    }
    
}
