package com.swapdev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapdev.entity.College;
import com.swapdev.repository.CollageRepository;

@Service
public class CollageServices {

	@Autowired
	CollageRepository repo;
	
	public void addCollage(College collage){
		repo.save(collage);
	}
	
	public List<College> getAll(){
		return repo.findAll();
	}

	public void addMul(List<College> collage) {
		repo.saveAll(collage);
		
	}
	
}
