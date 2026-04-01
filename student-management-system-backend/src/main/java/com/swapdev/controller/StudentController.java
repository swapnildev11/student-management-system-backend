package com.swapdev.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swapdev.entity.Student;
import com.swapdev.services.StudentServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

	@Autowired
	StudentServices services;

	// 1. Create (Add Student)
	@PostMapping()
	public ResponseEntity<String> createStudent(@Validated @RequestBody Student student) {
		
		services.addStudent(student);
		return new ResponseEntity<>("Data Submit Sucessfully✅✅", HttpStatus.CREATED);
	}
	
	@PostMapping("/bulk")
	public ResponseEntity<String> AddMutiple(@RequestBody List<Student> students){
		services.addAll(students);
		return new ResponseEntity<>("Data Submit Sucessfully✅✅", HttpStatus.CREATED);
	}

	// 2. Read APIs (Fetch Data)
	@GetMapping
	public ResponseEntity<List<Student>> getAll() {
		return new ResponseEntity<>(services.findAll(), HttpStatus.OK);
	}

	// ✅ FILTER (Better than separate APIs)
    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String address) {

        return ResponseEntity.ok(
                services.searchStudents(firstName, lastName, address)
        );
    }

	// 3. Update APIs
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
			return new ResponseEntity<>(services.updateStudent(id, student), HttpStatus.CREATED);
	}


	// 4. Delete APIs
     @DeleteMapping("/{id}")
	 public ResponseEntity<String> deleteById(@PathVariable Integer id){
		 return new ResponseEntity<>(services.deleteById(id),HttpStatus.OK);
	 }

     @GetMapping("/{id}")
     public ResponseEntity<Student> getById(@PathVariable Integer id){
         return ResponseEntity.ok(services.getStudentByid(id));
     }
     
     @PatchMapping("/{id}")
     public ResponseEntity<Student> partialUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
         return ResponseEntity.ok(services.updateStudentPartial(id, updates));
     }
     
     @GetMapping("/page")
     public ResponseEntity<org.springframework.data.domain.Page<Student>> getStudents(
             @RequestParam int page,
             @RequestParam int size) {

         return ResponseEntity.ok(services.getStudentsWithPagination(page, size));
     }
}
