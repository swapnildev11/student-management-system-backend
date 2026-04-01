package com.swapdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swapdev.entity.College;
import com.swapdev.services.CollageServices;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/collages")
public class CollageController {

	@Autowired
	CollageServices services;
	
	@PostMapping()
	public ResponseEntity<String> createCollege(@RequestBody 
			College college){
		services.addCollage(college);
		return new ResponseEntity<>("College Data Submit Sucessfully.✅✅",HttpStatus.CREATED);
	}
	
	
	@PostMapping("/bulk")
	public ResponseEntity<String> createMultiple(@RequestBody List<College> college){
		services.addMul(college);
		return new ResponseEntity<>("College Data Submit Sucessfully.✅✅",HttpStatus.CREATED);
		
	}
	
	@GetMapping()
	public ResponseEntity<List<College>> getCollege(){
		return new ResponseEntity<>(services.getAll(),HttpStatus.OK);
	}
	
}
