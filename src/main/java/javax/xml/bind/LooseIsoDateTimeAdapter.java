package javax.xml.bind;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * This can parse ISO dates that do/dont have a timezone, to match some XSD types
 * If the timezone is missing it uses the system default timezone
 * @author daniel.watson
 *
 */
public class LooseIsoDateTimeAdapter extends XmlAdapter<String,ZonedDateTime> {
	
	protected ZoneId defaultZone;
	
	public LooseIsoDateTimeAdapter() {
		this(ZoneId.of("Z"));
	}
	
	public LooseIsoDateTimeAdapter(ZoneId defaultZone) {
		this.defaultZone = defaultZone;
	}

	@Override
	public String marshal(ZonedDateTime v) throws Exception {
		if(v==null) return null;
		else return DateTimeFormatter.ISO_DATE_TIME.format(v);
	}
	
	@Override
	public ZonedDateTime unmarshal(String v) throws Exception {
		
		if(v==null) return null;
		v = v.trim();
		TemporalAccessor ta = DateTimeFormatter.ISO_DATE_TIME.parse(v);
		ZonedDateTime zdt = ta.query(q -> {
			if(q.isSupported(ChronoField.OFFSET_SECONDS))return ZonedDateTime.from(q);
			else return ZonedDateTime.of(LocalDateTime.from(q),defaultZone);
		});
		return zdt;
	}
	
}
