package org.w3.dom.ls;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

public class ClasspathResourceResolver implements LSResourceResolver {
	
	public static Logger LOGGER = LoggerFactory.getLogger(ClasspathResourceResolver.class);

	protected Class<?> searchClass;
	
	public ClasspathResourceResolver(Class<?> classs) {
		this.searchClass = classs;
	}
	
	@Override
	public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId,String baseURI) {

		InputStream is = searchClass.getResourceAsStream(systemId);
		if(is == null) {
			LOGGER.warn("Resource {} does not exist",systemId);
			return null;
		}
		else {
			LSInputImpl ls = new LSInputImpl(publicId, systemId, namespaceURI, is);
			return ls;
		}
		
	}

}
