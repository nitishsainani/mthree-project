package com.mthree.usercontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.users.Dealer;
import com.mthree.users.Trader;
import com.mthree.users.User;
import com.mthree.userservices.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userservice;
    
	@PostMapping("/registerdealer")
	public Model userRegister(@RequestBody Dealer dealer,Model m)
	{


		if(userservice.addUser(dealer))
		{
			m.addAttribute("registerdealerstatus", "User added");
		return m;
		}
		else
		{
			m.addAttribute("registerdealerstatus", "User not add there may be similarity in username or email added");
			return m;	
		}
		
	}
	@PostMapping("/registertrader")
	public Model userRegister(@RequestBody Trader trader,Model m)
	{
		

		if(userservice.addUser(trader))
		{
			m.addAttribute("registertraderstatus", "User added");
		return m;
		}
		else
		{
			m.addAttribute("registertraderstatus", "User not add there may be similarity in username or email added");
			return m;	
		}
		
	}

	@PostMapping("/login")
	public Model userLogin(@RequestParam("username") String name,@RequestParam("password") String pass,Model m)
	{
		
	User u=userservice.Login(name,pass);
	if(u!=null)
	{   m.addAttribute("user",u);
		return m;
	}
	else
	{
		m.addAttribute("user","user not found");
		return m;
	}
	}
	@PutMapping("/userdealer")
	public Model userEdit(@RequestBody Dealer dealer,Model m)
	{   
		if(userservice.updateUser(dealer)==1)
		{    
			m.addAttribute("DealerupdateStatus", "Dealer User Updated");
			return m;
		}
		else
		{
			m.addAttribute("DealerupdateStatus", "Dealer User Updated");
			return m;
		}
	}
	@PutMapping("/usertrader")
	public Model userEdit(@RequestBody Trader trader,Model m)
	{   
		if(userservice.updateUser(trader)==1)
		{
			m.addAttribute("traderupdateStatus", "Trader User Updated");
			return m;
		}
		else
		{   
			m.addAttribute("traderupdateStatus", "Trader User not Updated");
			return m;
		}
	}
	@GetMapping("/user")
	public  Model userDisplayToEdit(@RequestParam("userId") int userId,Model m)
	{
		Optional<User> u=userservice.getUserById(userId);
		if(u.isPresent())
		{
			m.addAttribute("user",u);
			return m;
		}
		else

		{
			m.addAttribute("user","user is null");
			return m;
		}
	}
	@DeleteMapping("/user")
	public Model deleteUser(@RequestParam("userId") int userId,Model m)
	{
		if(userservice.deleteUser(userId))
		{   m.addAttribute("userDeleteStatus","User deleted");
			return m;
		}
		else
		{
			m.addAttribute("userDeleteStatus","User not deleted");
			return m;
		}


	}
	@GetMapping("/getalluser")
	public Model getUsers(Model m)
	
	{   
		List<User> u=userservice.getUsers();
		m.addAttribute("UserList", u);
		return m;
		 
	}

}
