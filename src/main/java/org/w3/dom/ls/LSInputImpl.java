package org.w3.dom.ls;

import java.io.InputStream;
import java.io.Reader;

import org.w3c.dom.ls.LSInput;

public class LSInputImpl implements LSInput {

	public LSInputImpl(String publicId, String systemId, String baseURI, InputStream byteStream) {
		super();
		this.publicId = publicId;
		this.systemId = systemId;
		this.baseURI = baseURI;
		this.byteStream = byteStream;
	}

	protected String publicId = null;
	protected String systemId = null;
	protected String baseSystemId = null;
	protected String baseURI = null;
	protected InputStream byteStream = null;
	protected Reader charStream = null;
	protected String data = null;
	protected String encoding = null;
	protected Boolean certifiedText = false;

	public String getPublicId() {
		return publicId;
	}

	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getBaseSystemId() {
		return baseSystemId;
	}

	public void setBaseSystemId(String baseSystemId) {
		this.baseSystemId = baseSystemId;
	}

	public InputStream getByteStream() {
		return byteStream;
	}

	public void setByteStream(InputStream byteStream) {
		this.byteStream = byteStream;
	}

	public boolean getCertifiedText() {
		return certifiedText;
	}

	public void setCertifiedText(boolean certifiedText) {
		this.certifiedText = certifiedText;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getBaseURI() {
		return baseURI;
	}

	public void setBaseURI(String baseURI) {
		this.baseURI = baseURI;
	}

	@Override
	public Reader getCharacterStream() {
		return charStream;
	}

	@Override
	public void setCharacterStream(Reader characterStream) {
		this.charStream = characterStream;
	}

	@Override
	public String getStringData() {
		return data;
	}

	@Override
	public void setStringData(String stringData) {
		this.data = stringData;
	}

}
