package javax.xml.bind;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateTimeTest {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(DateTimeTest.class);
	
	@Test
	public void parseTest() {
		
		String v = "2016-11-22T21:08:36";
		//String v = "2016-11-22T21:08:36";
		//ZonedDateTime.parse(v,DateTimeFormatter.ISO_DATE_TIME);
		//LocalDateTime dt = LocalDateTime.parse(v, DateTimeFormatter.ISO_DATE_TIME);
		//ZonedDateTime zdt;
		
		TemporalAccessor ta = DateTimeFormatter.ISO_DATE_TIME.parse(v);
		ZonedDateTime zdt = ta.query(q -> {
			LOGGER.info("offset: {}",q.isSupported(ChronoField.OFFSET_SECONDS));
			if(q.isSupported(ChronoField.OFFSET_SECONDS)) {
				return ZonedDateTime.from(q);
			}
			else {
				return ZonedDateTime.of(LocalDateTime.from(q),ZoneId.of("Z"));
			}
		});
		LOGGER.info("Datetime: {}",zdt);
		//ZonedDateTime.from(ta);
	}

}
