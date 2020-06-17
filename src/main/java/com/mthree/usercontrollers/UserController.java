package com.mthree.usercontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mthree.users.Dealer;
import com.mthree.users.Trader;
import com.mthree.users.User;
import com.mthree.userservices.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userservice;
    
   
	@PostMapping("/registerdealer")
	public ModelAndView userRegister(@RequestBody Dealer dealer)
	{   
		//m=new  ModelAndView("success","registerdealerstatus","User added");
		ModelAndView m=new  ModelAndView();

		if(userservice.addUser(dealer))
		{
			m.addObject("registerdealerstatus", "User added");
//			m=new  ModelAndView("success","registerdealerstatus","User added");
		return m;
			//return "User added";
		}
		else
		{  
			//m=new  ModelAndView("success","registerdealerstatus","User not added");
			m.addObject("registerdealerstatus", "User not add there may be similarity in username or email added");
			//return "User not add there may be similarity in username or email added";	
			return m;
		}
		
	}
	@PostMapping("/registertrader")
	public String userRegister(@RequestBody Trader trader,Model m)
	{
		

		if(userservice.addUser(trader))
		{
//			m.addAttribute("registertraderstatus", "User added");
//		return m;
			return "User added";
		}
		else
		{
//			m.addAttribute("registertraderstatus", "User not add there may be similarity in username or email added");
//			return m;	
			return "User not add there may be similarity in username or email added";
		}
		
	}

	@PostMapping("/login")
	public User userLogin(@RequestParam("username") String name,@RequestParam("password") String pass)
	{
		
	User u=userservice.Login(name,pass);
	if(u!=null)
	{   
		return u;
	}
	else
	{   u=null;
//		m.addAttribute("loginuser","user not found");
//		return m;
		return u;
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
	public  Optional<User> userDisplayToEdit(@RequestParam("userId") int userId)
	{
		Optional<User> u=userservice.getUserById(userId);
		if(u.isPresent())
		{
//			m.addAttribute("displayuserbyId",u);
//			return m;
			return u;
		}
		else

		{
//			m.addAttribute("displayuserbyId","user is null");
//			return m;
			return u;
		}
	}
	@DeleteMapping("/user")
	public boolean deleteUser(@RequestParam("userId") int userId)
	{
		if(userservice.deleteUser(userId))
		{  
//			m.addAttribute("userDeleteStatus","User deleted");
//			return m;
			return true;
		}
		else
		{
//			m.addAttribute("userDeleteStatus","User not deleted");
//			return m;
			return false;
		}


	}
	@GetMapping("/getalluser")
	public List<User> getUsers()
	
	{   
		List<User> u=userservice.getUsers();
		//m.addAttribute("UserList", u);
		return u;
		 
	}

}
