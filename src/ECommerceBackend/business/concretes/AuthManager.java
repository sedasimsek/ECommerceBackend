package ECommerceBackend.business.concretes;

import java.util.List;

import ECommerceBackend.business.abstracts.AuthService;
import ECommerceBackend.business.abstracts.UserService;
import ECommerceBackend.entities.concretes.User;

public class AuthManager implements AuthService{
	
	UserService userService;
	
	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void register(User user) {
		if(userService.add(user)) {
			System.out.println( user.getFirstName() + " " + user.getLastName() + " registered");	
			System.out.println("Check your gmail");
		}
	}

	@Override
	public void login(User user) {
		List<User> users = userService.getAll();
		
		for (User registeredUser : users) {
			if(registeredUser.getPassword().equals(user.getPassword()) && registeredUser.getEmail().equals(user.getEmail())) {
				System.out.println("Hi " + user.getFirstName() + "login Ok!");
			}
		}
		System.out.println("Wrong email or password");
	}

}
