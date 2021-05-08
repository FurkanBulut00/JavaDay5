package business.concretes;

import java.util.List;

import business.abstracts.AuthService;
import business.abstracts.EmailService;
import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entitites.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private AuthService authService;
	private EmailService emailService;

	public UserManager(UserDao userDao, AuthService authService, EmailService emailService) {
		super();
		this.userDao = userDao;
		this.authService = authService;
		this.emailService= emailService;
	}

	@Override
	public void add(User user) {
		if(userCheck(user.getEmail()) && authService.validate(user)) {
			userDao.add(user);
			System.out.println("Baþarýyla kayýt oldunuz.Doðrulama kodunuz : "+emailService.mailSend());
			System.out.println("Kodu giriniz : ");
			return;
		
		}
		System.out.println("Kullanýcý bilgilerini kontrol ediniz: ");
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);
		
		
	}

	@Override
	public void update(User user) {
		this.userDao.update(user);
		
		
	}

	@Override
	public User get(int id) {
		
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return null;
	}

	@Override
	public void userVerify(User user, int verificationCode) {
		int result=emailService.mailSend();
		if (result==verificationCode) {
			
			System.out.println("Kullanýcý doðrulandý. Üyeliðiniz Tamamlandý!!! "+user.getFirstName());
		}
		else {
			System.out.println("Doðrulama kodunuz yanlýþ!");
		}
	}
	public boolean userCheck(String mail) {
		if(userDao.getByEmail(mail)!=null) {
			System.out.println("Kullanici mevcut.");
			return false;
		}
		return true;
	}

}
