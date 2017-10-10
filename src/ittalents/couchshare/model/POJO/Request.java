package ittalents.couchshare.model.POJO;

import java.sql.Date;

import ittalents.couchshare.model.interfaces.IPost;

public class Request extends Post implements IPost {
	private static final String DEFAULT_ACCEPTED_STATUS = "pending";

	private Date startDate;
	private Date endDate;
	private User receiver;
	private int numberOfTravellers;
	private boolean isExpired = false;
	private String acceptedStatus;
	private int id;

	public Request(String content, User author, Date startDate, Date endDate, User receiver, int numberOfTravellers,
			String acceptedStatus, boolean isExpired,int id) {
		this(content, author, startDate, endDate, receiver, numberOfTravellers);
		this.isExpired = isExpired;
		this.acceptedStatus = acceptedStatus;
		this.setId(id);
	}

	public Request(String content, User author, Date startDate, Date endDate, User receiver, int numberOfTravellers) {
		super(content, author);
		this.startDate = startDate;
		this.endDate = endDate;
		this.receiver = receiver;
		this.numberOfTravellers = numberOfTravellers;
		this.acceptedStatus = DEFAULT_ACCEPTED_STATUS;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public int getNumberOfTravellers() {
		return numberOfTravellers;
	}

	public void setNumberOfTravellers(int numberOfTravellers) {
		this.numberOfTravellers = numberOfTravellers;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	public String getAcceptedStatus() {
		return acceptedStatus;
	}

	public void setAcceptedStatus(String acceptedStatus) {
		this.acceptedStatus = acceptedStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
