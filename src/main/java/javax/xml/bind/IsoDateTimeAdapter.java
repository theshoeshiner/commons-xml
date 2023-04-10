package javax.xml.bind;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;


public class IsoDateTimeAdapter extends TemporalAdapter<OffsetDateTime>{

	public IsoDateTimeAdapter() {
		super(DateTimeFormatter.ISO_DATE_TIME,OffsetDateTime::from);
	}


}