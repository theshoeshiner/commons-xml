package javax.xml.bind;

import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;

public class IsoOffsetTimeAdapter extends TemporalAdapter<OffsetTime>{

	public IsoOffsetTimeAdapter() {
		super(DateTimeFormatter.ISO_OFFSET_TIME,OffsetTime::from);
	}


}