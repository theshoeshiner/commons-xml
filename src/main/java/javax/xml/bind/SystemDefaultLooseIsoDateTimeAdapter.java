package javax.xml.bind;

import java.time.ZoneId;

public class SystemDefaultLooseIsoDateTimeAdapter extends LooseIsoDateTimeAdapter {

	public SystemDefaultLooseIsoDateTimeAdapter() {
		super(ZoneId.systemDefault());
	}

}
