package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entitites.concretes.User;

public class InMemoryUserDao implements UserDao {
	List<User> users = new ArrayList<User>();
	public InMemoryUserDao() {
		User user1 = new User(1, "Furkan", "Bulut", "abc@gmail.com", "123456");
		User user2 = new User(2, "Musa", "Hýzýr", "musa@gmail.com", "11111111");
		users.add(user1);
		users.add(user2);

	}

	@Override
	public void add(User user) {
		System.out.println("Kullanici eklendi : " + user.getFirstName() + " " + user.getLastName());
		users.add(user);
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanici silindi. " + user.getFirstName() + " " + user.getLastName());

	}

	@Override
	public void update(User user) {
		System.out.println("Kullanici güncellendi" + user.getFirstName() + " " + user.getLastName());

	}


	
	@Override
	public User getByEmail(String email) {
		for(User user : users) {
			if(user.getEmail() == email)
				return user;
		}
		return null;
		
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		for(User user : users) {
			if(user.getEmail() == email && user.getPassword() == password)
				return user;
		}
		return null;
	}
	
	@Override
	public List<User> getAll() {

		return null;
	}


}
