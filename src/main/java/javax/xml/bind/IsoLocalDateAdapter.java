package javax.xml.bind;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IsoLocalDateAdapter extends TemporalAdapter<LocalDate>{

	public IsoLocalDateAdapter() {
		super(DateTimeFormatter.ISO_DATE,LocalDate::from);
	}

}

