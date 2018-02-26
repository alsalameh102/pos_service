package fr.asip.mss.transverse.interceptors;

import net.sf.appstatus.core.services.IServiceMonitor;
import net.sf.appstatus.core.services.ServiceMonitorLocator;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 * 
 * @author JCORTES
 * 
 */
public class LogOutTimeInterceptor extends AbstractPhaseInterceptor<Message> {

    /**
     * constructeur.
     */
    public LogOutTimeInterceptor() {
        super(Phase.SEND);
    }

    @Override
    public void handleMessage(final Message message) throws Fault {
        IServiceMonitor monitor = ServiceMonitorLocator
                .getCurrentServiceMonitor();
        if (monitor != null) {
            monitor.endCall();
        }
    }

}
