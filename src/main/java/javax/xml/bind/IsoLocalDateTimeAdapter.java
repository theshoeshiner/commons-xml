package javax.xml.bind;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IsoLocalDateTimeAdapter extends TemporalAdapter<LocalDateTime>{

	public IsoLocalDateTimeAdapter() {
		super(DateTimeFormatter.ISO_LOCAL_DATE_TIME,LocalDateTime::from);
	}


}
