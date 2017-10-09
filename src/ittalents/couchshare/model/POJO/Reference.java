package ittalents.couchshare.model.POJO;

import java.time.LocalDateTime;

public class Reference extends Post {

	private boolean wouldReccomend;
	private String travilingType;
//	private Post post;
	private User Reciever;
	
	private Reference(String content, User author){
		super(content, author);
	}
	
	public Reference(boolean wouldReccomend, String travilingType, User reciever,String content, User author) {
		this( content,  author);
		this.wouldReccomend = wouldReccomend;
		this.travilingType = travilingType;
//		this.post = post;
		this.Reciever = reciever;
	}
	public boolean isWouldReccomend() {
		return wouldReccomend;
	}
	public String getTravilingType() {
		return travilingType;
	}
//	public Post getPost() {
//		return post;
//	}
	public User getReciever() {
		return Reciever;
	}
}
