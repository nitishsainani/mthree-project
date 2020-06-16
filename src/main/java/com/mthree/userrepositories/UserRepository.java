package com.mthree.userrepositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.users.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	@Query("select password from User where userName=:uname")
	public String getPassword(@Param("uname")String username);
	
	public boolean existsByUserName(String username);
	public boolean existsByEmail(String email);
	public User findByUserName(String username);
	
	
	@Query(value="update user set user_name=:uname,password=:password,full_name=:fullname,email=:email,date_of_birth=:dob,company_name=:companyName where user_id=:id",nativeQuery=true)
	@Modifying
	@Transactional
	public int updateUserById(@Param("id")int id,@Param("uname")String username,@Param("password")String password,@Param("fullname")String fullname,@Param("email")String email,@Param("dob")String DOB,@Param("companyName")String companyName);
}