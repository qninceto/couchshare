package ittalents.couchshare.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ittalents.couchshare.model.DAO.UserDAO;
import ittalents.couchshare.model.POJO.MessageBox;
import ittalents.couchshare.model.POJO.Post;
import ittalents.couchshare.model.POJO.Reference;
import ittalents.couchshare.model.POJO.User;
import ittalents.couchshare.model.exceptions.PostException;
import ittalents.couchshare.model.exceptions.UserException;
import ittalents.couchshare.model.exceptions.ReferenceException;

public class DemoList {
	public static void main(String[] args) throws UserException, ReferenceException, PostException {
//		new UserDAO().addFriends(8, "mtest");
		System.out.println("pls enter user whitch you want to see friends");
		Scanner sc = new Scanner(System.in);
		int userIdFriend = sc.nextInt();
		List<User> friends = new DaoDemo().FriendList(userIdFriend);
		
		System.out.println("Friends");
		for(User u : friends){
			System.out.println(u);
			System.out.println("___________________________________");

		}
		
		
	System.out.println("-----------------------------------------------------");
	
//	new UserDAO().addReference(5, false, "host", new UserDAO().getUserById(8), "preform better haha");
	System.out.println("pls enter user whitch you want to see Reference");
	int userIdReference = sc.nextInt();

List<Reference> reference = new DaoDemo().referenceList(userIdReference);
		
		System.out.println("Reference");
		for(Reference p : reference){
			System.out.println(p);
			System.out.println("___________________________________");

		}



//	new UserDAO().SendMessage(8, "what do you need ", new UserDAO().getUserById(4));

		
		
		System.out.println("-----------------------------------------------------");
		System.out.println("pls enter your Id");
		int Inbox = sc.nextInt();
		List<MessageBox> inbox = new DaoDemo().inboxList(Inbox);
		
				
				System.out.println("My Inbox");
				for(MessageBox m : inbox){
					System.out.println(m);
					System.out.println("___________________________________");
				}
				
				
	
		
		
	}

}
