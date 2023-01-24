package javax.xml.bind;

import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalQuery;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public abstract class TemporalAdapter<T extends Temporal> extends XmlAdapter<String,T> {
	
	protected DateTimeFormatter marshalFormatter;
	protected DateTimeFormatter unmarshalFormatter;
	protected TemporalQuery<T> temporalQuery;
	

	public TemporalAdapter(DateTimeFormatter marshalFormatter, DateTimeFormatter unmarshalFormatter, TemporalQuery<T> temporalQuery) {
		super();
		this.marshalFormatter = marshalFormatter;
		this.unmarshalFormatter = unmarshalFormatter;
		this.temporalQuery = temporalQuery;
	}

	public TemporalAdapter(DateTimeFormatter f,TemporalQuery<T> q) {
		this(f,f,q);
	}

	@Override
	public String marshal(T v) throws Exception {
		if(v==null) return null;
		else return marshalFormatter.format(v);
	}

	@Override
	public T unmarshal(String v) throws Exception {
		return unmarshalFormatter.parse(v, temporalQuery);
	}

}
