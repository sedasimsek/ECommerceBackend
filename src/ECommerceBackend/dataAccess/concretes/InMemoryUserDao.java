package ECommerceBackend.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ECommerceBackend.dataAccess.abstracts.UserDao;
import ECommerceBackend.entities.concretes.User;

public class InMemoryUserDao implements UserDao{

	List<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + " added OK!");
		
	}

	@Override
	public void delete(User user) {
		users.remove(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + " deleted OK!");
		
	}

	@Override
	public void update(User user) {
		User newInfo = users.stream().filter(u -> u.getId() == user.getId()).findFirst().orElse(null);
		newInfo.setEmail(user.getEmail());
		newInfo.setPassword(user.getPassword());
		newInfo.setFirstName(user.getFirstName());
		newInfo.setLastName(user.getLastName());
		
	}


	@Override
	public List<User> getAll() {
		
		return users;
	}

	@Override
	public User getById(int id) {
		
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		for (User user : users) {
			if(user.getEmail() == email) {
				return user;
			}
		}
		return null;
	}

}
