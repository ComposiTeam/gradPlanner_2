package br.com.caelum.vraptor.service;

import javax.persistence.NonUniqueResultException;

import br.com.caelum.vraptor.dao.UserDAO;
import br.com.caelum.vraptor.model.User;

public class UserService {
	
	private final UserDAO userDAO;
	
	public UserService()
	{
		this(null);
	}
	
	public UserService(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	public void create(User user){
		userDAO.add(user);
	}
	
	public boolean existsField(String field, String value){
		try{
				if(userDAO.find(field,value) != null){
					return false;
				}
				else
				{
					return true;
				}
		}catch (NonUniqueResultException exception) {
			return false;
			
		}
	}
	
	public void update(User user){
		userDAO.add(user);
	}
	
	public boolean existsUser(String login){
		boolean userExistence;
		if(userDAO.find("login", login) !=null ){
			userExistence = true;
		}
		else{
			userExistence = false;
		}
		
		return userExistence;
	}

	
	public User authenticate(String login, String password){

		/*User user = new User();
		user.setUsername("ADMIN");
		user.setPassword("ADMIN");*/
	
		User user = userDAO.find("username", login);
		
		
		return user;
		/*
		if(user != null)
		{
			boolean correctPassword = user.getPassword().equals(password);
			if(correctPassword){
				return user;
			}
			else
			{
				return null;
			}
		}
		else {
			return null;
		}
		*/
		
	}
}
