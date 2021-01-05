package javax.xml.bind;

import java.math.BigInteger;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BigIntegerIntegerAdapter extends XmlAdapter<BigInteger, Integer>{

	@Override
	public Integer unmarshal(BigInteger v) throws Exception {
		if(v == null) return null;
		else return v.intValueExact();
	}

	@Override
	public BigInteger marshal(Integer v) throws Exception {
		if(v==null) return null;
		else return BigInteger.valueOf(v);
	}

}

