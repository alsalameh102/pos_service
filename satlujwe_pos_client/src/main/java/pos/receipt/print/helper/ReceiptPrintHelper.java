package pos.receipt.print.helper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.PrinterName;

import config.Constant;
import config.SysProp;
import javafx.collections.ObservableSet;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimplePrintServiceExporterConfiguration;
import pos.receipt.bean.ReceiptBean;
import satlujwe_pos.Main;

public class ReceiptPrintHelper {
	 
	
	 /**
     * Retrieve a Print Service with a name containing the specified PrinterName; will return null if not found.
     * 
     * @return
     */
    private static Printer findPrintService(String printerName) {

        printerName = printerName.toLowerCase();

        Printer service = null;

        // Get array of all print services
        ObservableSet<Printer> services = Printer.getAllPrinters();
        System.out.println("All Printer Services :"+services.toString());
        // Retrieve a print service from the array
        for (Printer printer : services) {
        	if(printer.getName().equalsIgnoreCase(printerName)) {
        		service = printer;
        		System.out.println("Printer Found : "+ printerName);
        	}
		}
        if(service == null) {//fetching default printer service as could not find the properties printer
        	service = Printer.getDefaultPrinter();
        	System.out.println("Default Printer Service : "+service.getName());
        }
        // Return the print service
        return service;
    }
    
    
    private static String getPrinterNameWithJavaFX(String printerName) {
    	String returnPrinterName="";
    	ObservableSet<Printer>  name = Printer.getAllPrinters(); 
    	for (Printer printer : name) {
			if(printerName!= null && printerName.equals("")) {
				if(printer.getName().equals(printerName)) {
					returnPrinterName= printer.getName();
				}
			}else {
				returnPrinterName= Printer.getDefaultPrinter().getName();
			}
		}
    	return returnPrinterName;
    }

    public void printReportToPrinter(JasperPrint jprint) throws JRException {
        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
        printRequestAttributeSet.add(new Copies(1));
        String printerName=Main.lcontrol.getProperties().INSTANCE.getProperty("PRINTERNAME").toString();
        if(printerName == null) {
        	printerName = "Default";
        }
        Printer printer= findPrintService(printerName);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        SimpleExporterInput item = new SimpleExporterInput(jprint);
        SimpleHtmlExporterOutput htmlOutputExpo =  new SimpleHtmlExporterOutput(baos);
        HtmlExporter exporter = new HtmlExporter();
        exporter.setExporterInput(item);
        exporter.setExporterOutput(htmlOutputExpo);
        exporter.exportReport();
        
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
       
        engine.loadContent(baos.toString());
        
		javafx.print.PrinterJob printerJob= PrinterJob.createPrinterJob(printer);
		
		printerJob.getJobSettings().setJobName("Receipt Print!!!");
		
		PageLayout pageLayout   = printer.createPageLayout(Paper.A5, PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);
		
		webView.setPrefSize(pageLayout.getPrintableWidth(), pageLayout.getPrintableHeight());
        
        boolean success = printerJob.printPage(pageLayout,webView);
        if(success) {
        	printerJob.endJob();
        }
    }
    
	public void fillReceiptData(Collection<ReceiptBean> data, Map parameters) {
		InputStream inputStream = getClass().getResourceAsStream(Constant.JASPER_LOCATION);
		
		System.out.println("InputStream: "+inputStream);
		
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(data);
		try {	
			 JasperPrint jsPrintObj = JasperFillManager.fillReport(inputStream, parameters, beanColDataSource);
			if (jsPrintObj != null) {
				printReportToPrinter(jsPrintObj);
			}
		} catch (JRException e) {
			e.printStackTrace();
			
		}
	}
        
        public JasperPrint fillReceiptDataPreview(Collection<ReceiptBean> data, Map parameters) {
		InputStream inputStream = getClass().getResourceAsStream(Constant.JASPER_LOCATION);
		
		System.out.println("InputStream: "+inputStream);
		
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(data);
		try {	
			 JasperPrint jsPrintObj = JasperFillManager.fillReport(inputStream, parameters, beanColDataSource);
			if (jsPrintObj != null) {
				//printReportToPrinter(jsPrintObj);
                                return jsPrintObj;
			}
		} catch (JRException e) {
			e.printStackTrace();
			
		}
                
                return null;
	}
	
	
	
	  public void print(JasperPrint jsprint) throws JRException
	  {
            long start=0;
	    PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
	 
	    PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
	    printServiceAttributeSet.add(new PrinterName(findPrintService(SysProp.INSTANCE.getProperty(Constant.PRINTER_NAME).toString()).getName(), null));
	    JRPrintServiceExporter exporter = new JRPrintServiceExporter();
	    exporter.setExporterInput(new SimpleExporterInput(jsprint));
	    SimplePrintServiceExporterConfiguration configuration = new SimplePrintServiceExporterConfiguration();
	    configuration.setPrintRequestAttributeSet(printRequestAttributeSet);
	    configuration.setPrintServiceAttributeSet(printServiceAttributeSet);
	    configuration.setDisplayPageDialog(false);
	    configuration.setDisplayPrintDialog(false); 
	    exporter.setConfiguration(configuration);
	    exporter.exportReport();
		System.err.println("Printing time : " + (System.currentTimeMillis() - start));
	  }
	  
	  private void exportToPdf(JasperPrint print) {
		
				// export it!
				File pdf;
				try {
					pdf = File.createTempFile("output.", ".pdf");
					JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
					 Printer printer= findPrintService("");
					 javafx.print.PrinterJob printerJob= PrinterJob.createPrinterJob(printer);
						
						printerJob.getJobSettings().setJobName("Receipt Print!!!");
						PageLayout defaultLayout = printerJob.getJobSettings().getPageLayout();
				        PageLayout pageLayout = printer.createPageLayout(defaultLayout.getPaper(), defaultLayout.getPageOrientation(), 1, 1, 1, 1);
				        printerJob.getJobSettings().setPageLayout(pageLayout);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (JRException e) {
					e.printStackTrace();
				}
	  }
}
