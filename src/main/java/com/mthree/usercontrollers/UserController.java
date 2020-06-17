package com.mthree.usercontrollers;

import java.util.List;
import java.util.Optional;

import com.mthree.responses.BaseResponse;
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
	public BaseResponse userRegister(@RequestBody Dealer dealer,Model m)
	{


		if(userservice.addUser(dealer))
		{
			m.addAttribute("registerdealerstatus", "User added");
			//return "user added";
			return new BaseResponse(200, "yes", "Dealer User added");
		}
		else
		{
			m.addAttribute("registerdealerstatus", "User not add there may be similarity in username or email added");
			//return "user not added";
			return new BaseResponse(401, "User not add there may be similarity in username or email added");
		}
		
	}
	@PostMapping("/registertrader")
	public BaseResponse userRegister(@RequestBody Trader trader,Model m)
	{
		

		if(userservice.addUser(trader))
		{
			m.addAttribute("registertraderstatus", "User added");
		//return m;
			return new BaseResponse(200, "yes", "Trader User added");
		}
		else
		{
			m.addAttribute("registertraderstatus", "User not add there may be similarity in username or email added");
			//return m;	
			return new BaseResponse(401, "User not add there may be similarity in username or email added");
			
			
		}
		
	}

	@PostMapping("/login")
	public BaseResponse userLogin(@RequestParam("username") String name, @RequestParam("password") String pass, Model m)
	{
		
	User u=userservice.Login(name,pass);
	if(u!=null)
	{   m.addAttribute("loginuser",u);
		return new BaseResponse(200, "yes", u);
	}
	else
	{
		m.addAttribute("loginuser","user not found");
		return new BaseResponse(200, "user not found");
	}
	}
	@PutMapping("/userdealer")
	public BaseResponse userEdit(@RequestBody Dealer dealer,Model m)
	{   
		if(userservice.updateUser(dealer)==1)
		{    
			m.addAttribute("DealerupdateStatus", "Dealer User Updated");
			//return m;
			return new BaseResponse(200, "yes","Dealer User Updated" );
		}
		else
		{
			m.addAttribute("DealerupdateStatus", "Dealer User Updated");
			//return m;
			return new BaseResponse(422, "Dealer User not found");
		}
	}
	@PutMapping("/usertrader")
	public BaseResponse userEdit(@RequestBody Trader trader,Model m)
	{   
		if(userservice.updateUser(trader)==1)
		{
			m.addAttribute("traderupdateStatus", "Trader User Updated");
			//return m;
			return new BaseResponse(200, "yes", "Trader User Updated");
		}
		else
		{   
			m.addAttribute("traderupdateStatus", "Trader User not Updated");
			//return m;
			return new BaseResponse(422, "Trader User not found");
		}
	}
	@GetMapping("/user")
	public  BaseResponse userDisplayToEdit(@RequestParam("userId") int userId,Model m)
	{
		Optional<User> u=userservice.getUserById(userId);
		if(u.isPresent())
		{
			m.addAttribute("displayuserbyId",u);
			//return m;
			return new BaseResponse(200, "yes", u);
		}
		else

		{
			m.addAttribute("displayuserbyId","user is null");
			//return m;
			return new BaseResponse(422, "User not found");
		}
	}
	@DeleteMapping("/user")
	public BaseResponse deleteUser(@RequestParam("userId") int userId,Model m)
	{
		if(userservice.deleteUser(userId))
		{   m.addAttribute("userDeleteStatus","User deleted");
			//return m;
		return new BaseResponse(200, "yes","User deleted" );
		}
		else
		{
			m.addAttribute("userDeleteStatus","User not deleted");
			//return m;
			return new BaseResponse(422, "User not found not deleted ");
		}


	}
	@GetMapping("/getalluser")
	public BaseResponse getUsers(Model m)
	
	{   
		List<User> u=userservice.getUsers();
		m.addAttribute("UserList", u);
		//return m;
		return new BaseResponse(200, "yes", u);
		 
	}

}
