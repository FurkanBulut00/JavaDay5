package eCommerceProject;

import java.util.Scanner;

import business.abstracts.AuthService;
import business.abstracts.UserService;
import business.concretes.AuthManager;
import business.concretes.EmailManager;
import business.concretes.UserManager;
import core.GoogleAuthManagerAdapater;
import dataAccess.concretes.InMemoryUserDao;
import entitites.concretes.User;

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		User user1 = new User(1,"Furkan","Bulut","abc@gmail.com","123456");
		User user2 = new User(1,"Musa","Hýzýr","abcd@gmail.com","1234567");
		
		
		UserService userService = new UserManager(new InMemoryUserDao(),new AuthManager(),new EmailManager());
		userService.add(user1);
		int verificationCode=scan.nextInt();
		userService.userVerify(user2, verificationCode);
		
		core.AuthService authService = new GoogleAuthManagerAdapater();
		authService.registerWithGoogle("abcd@gmail.com","1234567", "Furkan", "Bulut");
		authService.loginWithGoogle("abcd@gmail.com", "123456");
		
		

	}

}
