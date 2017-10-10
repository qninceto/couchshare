package ittalents.couchshare.model.DAO;

import java.util.Collection;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import ittalents.couchshare.model.POJO.User;

public class UsersList {
	private Collection<User> users ;

	public UsersList(String city) {
		this.users = getAllUsers(city);
	}

	public List<User> getAllUsers(String city) {
		return null;
	}

	public SortedSet<User> getAllNewsByTitle()  {
		return null;
//		TreeSet<User> sortedNews = new TreeSet<User>((n1, n2) -> n1.getTitle().compareTo(n2.getTitle()));
//		sortedNews.addAll(users);
//		return sortedNews;
	}
}
