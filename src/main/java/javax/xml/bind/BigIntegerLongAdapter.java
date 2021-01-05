package javax.xml.bind;

import java.math.BigInteger;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BigIntegerLongAdapter extends XmlAdapter<BigInteger, Long>{

	@Override
	public Long unmarshal(BigInteger v) throws Exception {
		if(v == null) return null;
		else return v.longValueExact();
	}

	@Override
	public BigInteger marshal(Long v) throws Exception {
		if(v==null) return null;
		else return BigInteger.valueOf(v);
	}

}
