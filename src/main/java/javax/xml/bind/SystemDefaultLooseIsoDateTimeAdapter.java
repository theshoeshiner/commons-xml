package javax.xml.bind;

import java.time.ZoneId;


/**
 * Extension of @javax.xml.bind.LooseIsoDateTimeAdapter that uses system default time zone
 * this may be dangerous to use since there is no guarantee that the data coming in uses the same time zone
 * In addition, the offset for any given zone changes over time
 */
public class SystemDefaultLooseIsoDateTimeAdapter extends LooseIsoZonedDateTimeAdapter {
	
	public SystemDefaultLooseIsoDateTimeAdapter() {
		super(ZoneId.systemDefault());
	}
	
}
