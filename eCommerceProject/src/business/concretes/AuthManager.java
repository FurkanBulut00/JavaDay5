package business.concretes;

import java.util.regex.Pattern;

import business.abstracts.AuthService;
import core.utils.BusinessRules;
import entitites.concretes.User;

public class AuthManager implements AuthService {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static boolean isEmailValidOnClick() {
		return true;
	}

	@Override
	public boolean validate(User user) {
		boolean result=BusinessRules.run(ifPasswordCheckLenght(user),
				ifFirstNameCheckLenght(user),
				ifLastNameCheckLenght(user),
				ifEmailFormatCheckValid(user));
		
		
		return result;
	}
	private boolean ifPasswordCheckLenght(User user) {
		if(user.getPassword().length()<6) {
			System.out.println("Þifre 6 karakterden küçük olamaz.");
			return false;
		}
		return true;
	}
	private boolean ifFirstNameCheckLenght(User user) {
		if(user.getFirstName().length()<2) {
			System.out.println("Ýsim 2 karakterden az olamaz.");
			return false;
		}
		return true;
	}
	private boolean ifLastNameCheckLenght(User user) {
		if(user.getLastName().length()<2) {
			System.out.println("Soyisim 2 karakterden az olamaz.");
			return false;
		}
		return true;
	}
	private boolean ifEmailFormatCheckValid(User email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email.getEmail()).find();
	}
	

	@Override
	public boolean login(User user) {
		boolean result = BusinessRules.run(isFirstandLastNameEmpty(user));
		
		return result;
	}
	private boolean isFirstandLastNameEmpty(User user) {
		if (user.getEmail()==null || user.getPassword()==null) {
			System.out.println("Kullanýcý adý veya parola eksik!");
			return false;
		}
		System.out.println("Sisteme giriþ yapýldý!");
		return true;
	}

}
