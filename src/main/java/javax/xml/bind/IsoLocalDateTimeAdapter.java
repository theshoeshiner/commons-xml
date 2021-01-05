package javax.xml.bind;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IsoLocalDateTimeAdapter extends TemporalAdapter<LocalDateTime>{

	public IsoLocalDateTimeAdapter() {
		super(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	@Override
	public LocalDateTime unmarshal(String v) throws Exception {
		return LocalDateTime.parse(v,DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}


}
