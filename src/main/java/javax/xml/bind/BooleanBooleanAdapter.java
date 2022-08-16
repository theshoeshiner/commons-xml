package javax.xml.bind;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * This class exists to force primitive booleans to be mapped to java wrapper types
 *
 */
public class BooleanBooleanAdapter extends XmlAdapter<Boolean, Boolean>{

	@Override
	public Boolean unmarshal(Boolean v) throws Exception {
		if(v == null) return null;
		else return v;
	}

	@Override
	public Boolean marshal(Boolean v) throws Exception {
		if(v==null) return null;
		else return v;
	}


}
