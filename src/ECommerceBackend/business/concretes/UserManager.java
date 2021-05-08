package ECommerceBackend.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import ECommerceBackend.business.abstracts.UserService;
import ECommerceBackend.dataAccess.abstracts.UserDao;
import ECommerceBackend.entities.concretes.User;

public class UserManager implements UserService{
	
	//Regex
		public static final String regex = "^[A-Z0-9.%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		public Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	
	UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public boolean add(User user) {
		if((checkUser(user) && checkEmail(user.getEmail()) && checkUserRegistered(user.getEmail()))) {
			userDao.add(user);		
			return true;
		}	
		return false;
		
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
		 
	}

	@Override
	public boolean delete(User user) {
		userDao.delete(user);
		return true;
		
	}

	@Override
	public boolean update(User user) {
		userDao.update(user);
		return true;
		
	}

	
	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
		
	}
	
	
	//Business Rules
	
	private boolean checkUser(User user) {
		if(checkFirstName(user.getFirstName()) || checkLastName(user.getLastName()) || checkEmail(user.getEmail()) || checkPassword(user.getPassword())) {
			return false;
		}
		return true;
	}
	
	private boolean checkFirstName(String firstName) {
		if(firstName.length() < 2) {
			System.out.println("User's firstname must min 2 chracters");
			return false;
		}
		return true;
	}
	
	private boolean checkLastName(String lastName) {
		if(lastName.length() < 2) {
			System.out.println("User's lastname must min 2 characters");
			return false;
		}
		return true;
	}
	
	private boolean checkEmail(String email) {
		if(pattern.matcher(email).find()) {
			return true;
		}
		System.out.println("Invalid email");
		return false;
	}
	
	private List<String> getEmails(){
		List<User> users = userDao.getAll();
		List<String> emails = new ArrayList<String>();
		for (User user : users) {
			emails.add(user.getEmail());
		}
		return emails;
	}
	
	private boolean checkPassword(String password) {
		if(password.length() < 6) {
			System.out.println("User's password must min 6 chaaracters");
			return false;
		}
		return true;
	}
	
	private boolean checkUserRegistered(String mail) {
		List<String> emails = this.getEmails();
		for(String email : emails) {
			if(email.equals(mail)) {
				System.out.println("This email is in use");
				return false;
			}
		}
		return true;
	}
}




















