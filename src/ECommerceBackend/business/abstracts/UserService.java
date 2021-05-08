package ECommerceBackend.business.abstracts;

import java.util.List;

import ECommerceBackend.entities.concretes.User;


public interface UserService {
	boolean add(User user);
	boolean delete(User user);
	boolean update(User user);
	User getById(int id);
	List<User> getAll();
	User getByEmail(String email);
}
