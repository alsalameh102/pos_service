package fr.asip.mss.handler;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import java.util.List;

public class DefaultHandlerResolver implements HandlerResolver {

    private List<Handler> handlerList;

    @Override
    public List<Handler> getHandlerChain(final PortInfo portInfo) {
        return handlerList;
    }

    public void setHandlerList(final List<Handler> handlerList) {
        this.handlerList = handlerList;
    }

}
