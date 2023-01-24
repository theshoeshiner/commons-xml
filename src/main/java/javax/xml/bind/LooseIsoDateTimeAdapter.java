package javax.xml.bind;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

/**
 * This can parse ISO dates that do/dont have a timezone, to match some XSD types
 * If the timezone is missing it uses UTC or uses the parameter passed in constructor
 *
 */
public class LooseIsoDateTimeAdapter extends TemporalAdapter<ZonedDateTime> {
	
	protected ZoneId defaultZone;
	
	public LooseIsoDateTimeAdapter() {
		this(ZoneId.of("Z"));
	}
	
	public LooseIsoDateTimeAdapter(ZoneId defaultZone) {
		super(DateTimeFormatter.ISO_OFFSET_DATE_TIME,ZonedDateTime::from);
		this.defaultZone = defaultZone;
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
