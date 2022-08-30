package javax.xml.ws.handler.soap;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class SLF4JLoggingHandler implements SOAPHandler<SOAPMessageContext> {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SLF4JLoggingHandler.class);
	
	protected Logger logger;

	public SLF4JLoggingHandler() {
		this(LOGGER);
	}
	
	public SLF4JLoggingHandler(Logger l) {
		logger = l;
	}
	
    public Set<QName> getHeaders() {
        return null;
    }

    public boolean handleMessage(SOAPMessageContext context) {
    	
    	if(logger.isDebugEnabled()) {
    	
	        Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
	        logger.debug(isRequest?"REQUEST":"RESPONSE");
	  
	        SOAPMessage message = context.getMessage();
	        try {

	            	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            	message.writeTo(baos);
	         
	            	StringWriter sw = new StringWriter();
	            	PrintWriter pw = new PrintWriter(sw);
	            	pw.flush();
	            	IOUtils.copy(new ByteArrayInputStream(baos.toByteArray()), pw,Charset.forName("UTF-8"));
	            	
	            	String s = sw.toString();
	            	
	            	logger.debug(s);

	            
	        } 
	        catch (SOAPException | IOException e) {
	        	logger.warn("Could not log",e);
	        }
        
    	}
        return true;
    }

    public boolean handleFault(SOAPMessageContext smc) {
        return true;
    }


    public void close(MessageContext messageContext) {}
    
    @SuppressWarnings("rawtypes")
    public static void addToBindingProvider(BindingProvider bp,Logger logger) {
    	List<Handler> handlerChain = bp.getBinding().getHandlerChain();
		handlerChain.add(new SLF4JLoggingHandler(logger));
		(bp).getBinding().setHandlerChain(handlerChain);
    }
    
    public static void addToBindingProvider(BindingProvider bp) {
    	addToBindingProvider(bp,LOGGER);
    }

}