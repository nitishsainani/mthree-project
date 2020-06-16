package com.mthree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mthree.userrepositories.UserRepository;
import com.mthree.users.Dealer;
import com.mthree.users.Trader;
import com.mthree.users.User;
import com.mthree.userservices.UserService;

@SpringBootTest
class MthreeProjectApplicationTests {

	
		@Autowired
		private UserRepository userrepo;
		Trader t;
		Dealer d;
		@Autowired
		private UserService userservice;
@BeforeEach
public void setUp()throws Exception 
{ 
	t=new Trader();

t.setUserName("TraderName");
t.setPassword("1234");
t.setFullName("TraderName Surname");
t.setEmail("tns@gmail.com");
t.setDateOfBirth("21/07/1999");
userrepo.save(t);
d=new Dealer();
d.setUserName("DealerName");
d.setPassword("1234");
d.setFullName("DealerName Surname");
d.setEmail("dns@gmail.com");
d.setDateOfBirth("21/07/1999");
d.setCompanyName("TestCompany");
userrepo.save(d);

System.out.println("Shutdown executed");
}
@AfterEach
public void tearDown()throws Exception 
{  
	if(userrepo.existsById(t.getUserId()))
	{
	userrepo.delete(t);
	System.out.println("Teardown trader executed");
	}
	if(userrepo.existsById(d.getUserId()))
	{
	userrepo.delete(d);
	System.out.println("Teardown dealer executed");
	}
	System.out.println("Teardown executed");
}
	
	@Test
	void register1() {
		boolean actual=userservice.addUser(t);
		assertFalse(actual);
		t.setEmail("test1@gmail.com");
		 actual=userservice.addUser(t);
			assertFalse(actual);
			actual=userservice.addUser(d);
			assertFalse(actual);
			d.setEmail("test2@gmail.com");
			 actual=userservice.addUser(d);
				assertFalse(actual);
		
	}
	@Test
	void register2()
	{
		t.setUserName("TestName1");
		boolean actual=userservice.addUser(t);
		assertFalse(actual);
		t.setEmail("test1@gmail.com");
		 actual=userservice.addUser(t);
		assertTrue(actual);
		d.setUserName("TestName2");
		actual=userservice.addUser(t);
		assertFalse(actual);
		d.setEmail("test2@gmail.com");
		 actual=userservice.addUser(d);
		assertTrue(actual);
		
	}
	@Test
	void testLogin()
	{
		User actual=userservice.Login(t.getUserName(),t.getPassword());
		assertNotNull(actual);
		System.out.println("trader"+actual);
		actual=userservice.Login(t.getUserName(),t.getPassword()+10);
		assertNull(actual);
		System.out.println("trader"+actual);
		actual=userservice.Login(d.getUserName(),d.getPassword());
		assertNotNull(actual);
		System.out.println("dealer"+actual);
		actual=userservice.Login(d.getUserName(),d.getPassword()+10);
		assertNull(actual);
		System.out.println("dealer"+actual);
	}
	@Test
	void testGetUserById()
	{

		Optional<User>
		actual=userservice.getUserById(t.getUserId()+10);
		assertFalse(actual.isPresent());
		actual=userservice.getUserById(t.getUserId());
		assertTrue(actual.isPresent());
		actual=userservice.getUserById(d.getUserId());
		assertTrue(actual.isPresent());
		actual=userservice.getUserById(d.getUserId()+10);
		assertFalse(actual.isPresent());
		
	}
@Test
void testDeleteById()
{
	boolean status=userservice.deleteUser(t.getUserId());
			assertTrue(status);
	status=userservice.deleteUser(t.getUserId()+10);
			assertFalse(status);
	status=userservice.deleteUser(d.getUserId());
			assertTrue(status);
	status=userservice.deleteUser(d.getUserId()+10);
			assertFalse(status);
	}
@Test
void testUpdate()
{
	t.setEmail("testupdate@gmail.com");	
int actual=userservice.updateUser(t);
assertEquals(1, actual);
actual=userservice.updateUser(t);
assertEquals(1, actual);
d.setEmail("testupdate2@gmail.com");
actual=userservice.updateUser(d);
assertEquals(1, actual);
actual=userservice.updateUser(d);
assertEquals(1, actual);
}

}
