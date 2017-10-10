package ittalents.couchshare.demo;

import java.util.List;

import ittalents.couchshare.model.DAO.RequestDAO;
import ittalents.couchshare.model.POJO.Request;
import ittalents.couchshare.model.exceptions.PostException;
import ittalents.couchshare.model.exceptions.RequestException;
import ittalents.couchshare.model.exceptions.UserException;

public class RequestUserDemo {
public static void main(String[] args) throws RequestException, PostException, UserException {
	
	//show all requests of a user 
	List<Request> list =new RequestDAO().getListOfRequestsReceivedByUser(2);
	for(Request r: list) {
		System.out.println("REQUEST:");
		System.out.println("To: "+r.getReceiver());
		System.out.println("From: "+r.getAuthor());
		System.out.println("--------");
		System.out.println("Message: "+r.getContent());
		System.out.println("Number of travelers: "+r.getNumberOfTravellers());
		System.out.println("Date of Arrival: "+r.getStartDate());
		System.out.println("Date of Leaving: "+r.getEndDate());
		System.out.println("Status: "+r.getAcceptedStatus());
		System.out.println("----------------------------------");
		
	}
	//user send request to user
	
	//user approve
	
	//user deny
	new RequestDAO().updateRequstToDenied(new RequestDAO().getRequestById(3));
}

}
