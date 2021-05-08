package ECommerceBackend.ui;

import ECommerceBackend.business.concretes.AuthManager;
import ECommerceBackend.business.concretes.UserManager;
import ECommerceBackend.core.adapters.GoogleAdapter;
import ECommerceBackend.dataAccess.concretes.InMemoryUserDao;
import ECommerceBackend.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		AuthManager authManager = new AuthManager(new UserManager(new InMemoryUserDao()));
        UserManager userManager = new UserManager(new InMemoryUserDao());
		GoogleAdapter googleAdapter = new GoogleAdapter();
		
		
		User user = new User(1, "Seda", "Þimþek", "sedasimsek@seda.com", "seda159");
		
		System.out.println(userManager.getByEmail(user.getEmail()));
		
		authManager.login(user);
		authManager.register(user);
		googleAdapter.login();
	}

}
