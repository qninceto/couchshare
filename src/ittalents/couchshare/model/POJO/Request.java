package ittalents.couchshare.model.POJO;

import java.time.LocalDate;

public class Request extends Post {
	private final LocalDate startDate;
	private final LocalDate endDate;
	private final User receiver;
	private final int numberOfTravellers;

}
