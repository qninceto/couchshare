package ittalents.couchshare.model.POJO;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Post {
	private int id;
	private String content;
	private User author;
	private final Timestamp timeOfPosting;

	public Post(String content, User author) {

		this.content = content;
		this.author = author;
		this.timeOfPosting =  new Timestamp(System.currentTimeMillis());
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

	public Timestamp getTimeOfPosting() {
		return timeOfPosting;
	}
}
