package ittalents.couchshare.model.POJO;

import java.time.LocalDate;
import java.util.*;

public class MessageBox extends Post{
	private User receiver;


	private MessageBox(String content, User author) {
		super(content, author);
	}


	public MessageBox(String content, User author, User receiver) {
		super(content, author);
		this.receiver = receiver;
	}


	public User getReceiver() {
		return receiver;
	}


	@Override
	public String toString() {
		return super.getAuthor()+"\n"+ super.getContent()+ "\n" +  ".";
	}

	
	
}
