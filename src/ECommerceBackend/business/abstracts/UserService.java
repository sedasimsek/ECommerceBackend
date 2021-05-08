package ECommerceBackend.business.abstracts;

import java.util.List;

import ECommerceBackend.entities.concretes.User;


public interface UserService {
	void add(User user);
	List<User> getAll();
}
