package core;

import eCommerceProject.GoogleAuthManager;

public class GoogleAuthManagerAdapater implements AuthService {

	@Override
	public void registerWithGoogle(String email, String password, String firstName, String lastName) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.register(email, password);
	}

	@Override
	public void loginWithGoogle(String email, String password) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.login(email, password);
		
		
	}


}
