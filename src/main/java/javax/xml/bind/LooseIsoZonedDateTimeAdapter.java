package javax.xml.bind;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class LooseIsoZonedDateTimeAdapter extends TemporalAdapter<ZonedDateTime> {
	
	protected ZoneId defaultZone;
	
	public LooseIsoZonedDateTimeAdapter() {
		this(ZoneOffset.UTC);
	}
	
	public LooseIsoZonedDateTimeAdapter(ZoneId defaultZone) {
		super(DateTimeFormatter.ISO_DATE_TIME,ZonedDateTime::from);
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