package ittalents.couchshare.model.POJO.userInformation;

import java.util.LinkedHashMap;
import java.util.Map;

public class HomeInformation {
/*here comes all the information about the home
	....
	....*/
	private enum DayOfTheWeek{
		MON, TUE,WEN, THU,FRI,SAT,SUN
	}
	private  Map<DayOfTheWeek,Boolean> availabelNightsToHost = new LinkedHashMap<DayOfTheWeek,Boolean>();
	/* setting default values:
	should go to a method and in the constructor:
	checkBox to set the value to t/f 
	da se ogranichi da nqma poveche ot 7 klucha!!
	*/
	{
		for(DayOfTheWeek d : DayOfTheWeek.values()) {
			availabelNightsToHost.put(d, false);
		}
	}
	
	//limited in the setter to 15!
	private int maximumNumberOfGuests;
	
	
	private  Map<Miscellaneous,Boolean> miscellaneousForSurfers = new LinkedHashMap<>();
	/* setting default values:
	should go to a method and in the constructor:
	checkBox to set the value to t/f 
	da se ogranichi da nqma poveche ot 3 klucha!!
	*/
	{
		for(Miscellaneous d : Miscellaneous.values()) {
			miscellaneousForSurfers.put(d, false);
		}
	}
	
	
	private String sleepingArrangements ="";
	private String descriptionOfSleepingArrangement ="";
	private String roommateSituation ="";
	
	private enum Miscellaneous{
		PET,KIDS,SMOKE
	}
	private  Map<Miscellaneous,Boolean> miscellaneousOfHost = new LinkedHashMap<>();
	/* setting default values:
	should go to a method and in the constructor:
	checkBox to set the value to t/f 
	da se ogranichi da nqma poveche ot 3 klucha!!
	*/
	{
		for(Miscellaneous d : Miscellaneous.values()) {
			miscellaneousOfHost.put(d, false);
		}
	}
	
	
	private String publicTransportationAccess ="";
	private String whatICanShareWithGuests ="";
	private String additionalInformation ="";
	
}
