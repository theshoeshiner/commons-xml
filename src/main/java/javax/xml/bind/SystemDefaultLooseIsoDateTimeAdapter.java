package javax.xml.bind;

import java.time.ZoneId;


/**
 * Extension of @javax.xml.bind.LooseIsoDateTimeAdapter that uses system default time zone
 * this may be dangerous to use since there is no guarantee that the data coming in uses the same time zone
 */
public class SystemDefaultLooseIsoDateTimeAdapter extends LooseIsoDateTimeAdapter {

	public SystemDefaultLooseIsoDateTimeAdapter() {
		super(ZoneId.systemDefault());
	}

}
