package ittalents.couchshare.model.POJO;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Post {
	private int id;
	private String content;
	private User author;
	private final Date timeOfPosting;

	public Post(String content, User author) {

		this.content = content;
		this.author = author;
		this.timeOfPosting = new Date(Calendar.getInstance().getTime().getTime());
	}

	public Post(int id, String content, User author) {
		this(content, author);
		this.id = id;

	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public User getAuthor() {
		return author;
	}

	public Date getTimeOfPosting() {
		return timeOfPosting;
	}
}
