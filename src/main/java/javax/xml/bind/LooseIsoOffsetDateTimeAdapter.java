package javax.xml.bind;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

/**
 * This can parse ISO dates that do/dont have a timezone, to match some XSD types
 * If the timezone is missing it uses UTC or uses the parameter passed in constructor
 *
 */
public class LooseIsoOffsetDateTimeAdapter extends TemporalAdapter<OffsetDateTime> {
	
	protected ZoneOffset defaultZone;
	
	public LooseIsoOffsetDateTimeAdapter() {
		this(ZoneOffset.UTC);
	}
	
	public LooseIsoOffsetDateTimeAdapter(ZoneOffset defaultZone) {
		super(DateTimeFormatter.ISO_OFFSET_DATE_TIME,OffsetDateTime::from);
		this.defaultZone = defaultZone;
	}

	@Override
	public OffsetDateTime unmarshal(String v) throws Exception {
		if(v==null) return null;
		v = v.trim();
		TemporalAccessor ta = DateTimeFormatter.ISO_DATE_TIME.parse(v);
		OffsetDateTime zdt = ta.query(q -> {
			
			if(q.isSupported(ChronoField.OFFSET_SECONDS))return OffsetDateTime.from(q);
			else return OffsetDateTime.of(LocalDateTime.from(q),defaultZone);
		});
		return zdt;
	}
	
}
