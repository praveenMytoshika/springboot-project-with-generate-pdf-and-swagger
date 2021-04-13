package com.payment_terms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.payment_terms.entity.User;
import com.payment_terms.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// post user details method

	public User addUser(User user) {
		userRepository.save(user);	
		return user;
	}


	// get all user details method

	public List<User> getUsers(User user) {
		return userRepository.findAll();
	}

	// get user details by its id method

	public Optional<User> getUser(long id) {
		return userRepository.findById(id);
	}

	// find list of all users from the repository method

	public List<User> listAll() {
		return userRepository.findAll();
	}

	// delete user details by its id method

	public void deleteDetails(long id) {

		User entity=userRepository.getOne(id);
		userRepository.delete(entity); 	
	} 

	//  update user details method

	public boolean updateDetails(User user) {

		Optional<User>entityOptional=userRepository.findById(user.getId());
		if(!entityOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"ID is not valid");
		}
		userRepository.save(user);


		return true;
	}

}
