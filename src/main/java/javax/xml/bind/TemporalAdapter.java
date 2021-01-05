package javax.xml.bind;

import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public abstract class TemporalAdapter<T extends Temporal> extends XmlAdapter<String,T> {
	
	DateTimeFormatter formatter;
	
	public TemporalAdapter(DateTimeFormatter f) {
		formatter = f;
	}

	@Override
	public String marshal(T v) throws Exception {
		if(v==null) return null;
		else return formatter.format(v);
	}
	
}
