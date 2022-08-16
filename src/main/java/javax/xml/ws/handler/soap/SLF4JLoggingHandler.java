package javax.xml.ws.handler.soap;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class SLF4JLoggingHandler implements SOAPHandler<SOAPMessageContext> {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SLF4JLoggingHandler.class);
	
	protected Logger logger;

	public SLF4JLoggingHandler() {
		logger = LOGGER;
	}
	
    public Set<QName> getHeaders() {
        return null;
    }

    public boolean handleMessage(SOAPMessageContext context) {
    	
    	if(LOGGER.isDebugEnabled()) {
    	
	        Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
	        LOGGER.debug(isRequest?"REQUEST":"RESPONSE");
	  
	        SOAPMessage message = context.getMessage();
	        try {

	            	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            	message.writeTo(baos);
	         
	            	StringWriter sw = new StringWriter();
	            	PrintWriter pw = new PrintWriter(sw);
	            	pw.flush();
	            	IOUtils.copy(new ByteArrayInputStream(baos.toByteArray()), pw,Charset.forName("UTF-8"));
	            	
	            	String s = sw.toString();
	            	
	            	LOGGER.debug(s);

	            
	        } 
	        catch (SOAPException | IOException e) {
	        	LOGGER.warn("Could not log",e);
	        }
        
    	}
        return true;
    }

    public boolean handleFault(SOAPMessageContext smc) {
        return true;
    }


    public void close(MessageContext messageContext) {}
    

}