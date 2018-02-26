/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;


//import jpos.*;
/**
 *
 * @author ETDelacruz
 */
public class POSDeviceManager {
    
    private boolean EFTConnected;
    private boolean printerConnected;
    private boolean cashDrawerConnected;

    public boolean isEFTConnected() {
        return EFTConnected;
    }

    public void setEFTConnected(boolean EFTConnected) {
        this.EFTConnected = EFTConnected;
    }

    public boolean isPrinterConnected() {
        return printerConnected;
    }

    public void setPrinterConnected(boolean printerConnected) {
        this.printerConnected = printerConnected;
    }

    public boolean isCashDrawerConnected() {
        return cashDrawerConnected;
    }

    public void setCashDrawerConnected(boolean cashDrawerConnected) {
        this.cashDrawerConnected = cashDrawerConnected;
    }
    
    
    
    
}
