package javax.xml.bind;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class IsoDateTimeAdapter extends TemporalAdapter<ZonedDateTime>{

	public IsoDateTimeAdapter() {
		super(DateTimeFormatter.ISO_DATE_TIME,ZonedDateTime::from);
	}


}