package fr.asip.mss.transverse.interceptors;

import net.sf.appstatus.core.AppStatus;
import net.sf.appstatus.core.services.IServiceMonitor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

/**
 * 
 * @author JCORTES
 * 
 */
public class LogInTimeInterceptor extends AbstractPhaseInterceptor<Message> {

    private AppStatus appStatus;

    /**
     * @param aAppStatus
     *            appStatus
     */
    public void setAppStatus(final AppStatus aAppStatus) {
        this.appStatus = aAppStatus;
    }

    /**
     * constructeur.
     */
    public LogInTimeInterceptor() {
        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(final Message message) throws Fault {
        if (appStatus != null) {
            Exchange exchange = message.getExchange();

            String appel = (String) exchange.getInMessage().get(
                    "org.apache.cxf.request.uri");

            IServiceMonitor monitor = appStatus.getServiceMonitor(appel,
                    "service");
            monitor.beginCall();
        }

    }

}
