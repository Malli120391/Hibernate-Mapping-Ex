package com.javacodes.springboot;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javacodes.springboot.model.Gender;
import com.javacodes.springboot.model.User;
import com.javacodes.springboot.model.UserDetails;
import com.javacodes.springboot.repos.UserDetailsRepository;
import com.javacodes.springboot.repos.UserRepository;

@SpringBootApplication
public class HibernateOnoToOneApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateOnoToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		userDetailsRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();
		
		User user = new User("Malleswara","Chennu", "ch.mali120@gmail.com", "1203");
		
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(2020, 12, 12);
		
		
		UserDetails userDetails = new UserDetails("+91-9505873779", Gender.MALE, dateOfBirth.getTime(),
                "36/a", "4nd Cross", "Pipeline Road, Fathenagar", "Hyderabad",
                "Telangana", "India", "500018");

		user.setUserDetails(userDetails);
		
		userDetails.setUser(user);
		
		userRepository.save(user);
		
		
	}

}
