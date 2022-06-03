package service;

import java.util.List;

import dao.UserDao;
import domain.User;

public class UserService {
	private UserDao userDao = new UserDao();

	public void regist(User form)
			throws CustomException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		// check the user name
		User user = userDao.findByEmail(form.getEmail());
		if (user.getEmail() != null && user.getEmail().equals(form.getEmail()))
			throw new CustomException("This user name has been registered!");
		userDao.add(form);
	}

	public void login(User form)
			throws CustomException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = userDao.findByEmail(form.getEmail());
		if (user.getEmail() == null)
			throw new CustomException("The user is not in the database");

		String password = user.getPassword();

		if (password != null && !password.equals(form.getPassword()))
			throw new CustomException(" The password is not right");

	}

	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return userDao.findall();
	}
}
