package com.payment_terms.controller;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.payment_terms.entity.User;
import com.payment_terms.pdf.CreatePDF;
import com.payment_terms.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="User controller provider")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// API for post  the  user details
	@ApiOperation(value = "add user details")
	@PostMapping("/useradd")
	public String addUser(@RequestBody User user) {
		userService.addUser(user);
		return "User added sucessfully";			 
	}

	// API for get all users details
	@ApiOperation(value = "get all users details")
	@GetMapping("/usergets")
	public List<User> getUsers(User user) {
		return userService.getUsers(user);
	}

	// API for get user details by its id
	@ApiOperation(value = "get user details by id")
	@GetMapping("/usergets/{id}")
	public Optional<User> getUser(long id) {
		return userService.getUser(id);
	}

	// API for get PDF of users details 
	@ApiOperation(value = "get pdf of users details")
	@GetMapping("/user/create/pdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("user/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=payment_terms_users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<User> listUsers = userService.listAll();

		CreatePDF exporter = new CreatePDF(listUsers);
		exporter.export(response);

	}

	// API for delete user details
	@ApiOperation(value = "delete user details by id")
	@DeleteMapping("/user/{id}")	
	public void deleteDetails(@PathVariable String id) {

		userService.deleteDetails(Long.parseLong(id));

	}

	// API for update user details
	@ApiOperation(value = "update user details")
	@PutMapping("/users")
	public ResponseEntity<?> updateDetails(@RequestBody User user) {
		return new ResponseEntity<>( userService.updateDetails(user),HttpStatus.OK);
	}


}
