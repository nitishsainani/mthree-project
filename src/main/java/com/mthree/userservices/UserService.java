package com.mthree.userservices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.userrepositories.UserRepository;
import com.mthree.users.Dealer;
import com.mthree.users.User;
@Service
public class UserService {
	@Autowired
	private UserRepository userrepo;

	public boolean addUser(User u)
	{ 


		if(userrepo.existsByUserName(u.getUserName())|| userrepo.existsByEmail(u.getEmail()))
		{
			return false;
		}
		else
		{
		 userrepo.save(u);
		 return true;
		}
		
		
	}
	public User Login(String username,String password)
	{
		if(userrepo.existsByUserName(username))
		{
			if(userrepo.getPassword(username).equals(password))
			{
				return userrepo.findByUserName(username);
			}
			return null;
		}
		return null;
	}
	public int updateUser(User user)
	{   String companyName=null; 
		int id=user.getUserId();
	String name=user.getUserName();
	String password=user.getPassword();
	String fullname=user.getFullName();
	String email=user.getEmail();
	String dob=user.getDateOfBirth();

	if(user instanceof Dealer)
	{   Dealer d=(Dealer)user;
		companyName=d.getCompanyName();

		return userrepo.updateUserById(id,name,password,fullname,email,dob,companyName);
	}
	
		return userrepo.updateUserById(id,name,password,fullname,email,dob,companyName);
	}
	public Optional<User> getUserById(int id)
	{
		return userrepo.findById(id);
	}
	public boolean  deleteUser(int id)
	{   
		if(userrepo.existsById(id))
		{
		userrepo.deleteById(id);
		return true;
		}
		else
			return false;
	}
	public List<User> getUsers()
	{
		return userrepo.findAll();
	}

}
