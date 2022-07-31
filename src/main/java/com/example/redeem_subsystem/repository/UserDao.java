package com.example.redeem_subsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.redeem_subsystem.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	 User findByFirstnameAndLastname(@Param("firstname") String firstname,
			 		 @Param("lastname")String lastname);
}
