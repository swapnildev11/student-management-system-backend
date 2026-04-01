package com.swapdev.services;


import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.swapdev.entity.College;
import com.swapdev.entity.Student;
import com.swapdev.repository.StudentRepository;
import org.springframework.data.domain.Pageable;

@Service
public class StudentServices {

	@Autowired
	StudentRepository repo;

	public void addStudent(Student student) {
		repo.save(student);
	}

	public void addAll(List<Student> students) {
		repo.saveAll(students);
	}

	public List<Student> findAll() {

		return repo.findAll();
	}

	public List<Student> searchStudents(String firstName, String lastName, String address) {
		if (firstName != null && !firstName.isBlank() &&
		        lastName != null && !lastName.isBlank()) {
		        return repo.findByFirstNameAndLastName(firstName, lastName);

		    }  else if (firstName != null) {
			return repo.findByFirstName(firstName);
		} else if (lastName != null) {
			return repo.findByLastName(lastName);
		} else if (address != null) {
			return repo.findByAddress(address);
		} else {
			return repo.findAll();
		}
	}

	// ✅ FULL UPDATE (PUT)
	public Student updateStudent(Integer id, Student newStudent) {
		Student existing = repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
		existing.setFirstName(newStudent.getFirstName());
		existing.setLastName(newStudent.getLastName());
		existing.setAddress(newStudent.getAddress());
		existing.setPhoneNo(newStudent.getPhoneNo());
		existing.setEmail(newStudent.getEmail());
		existing.setCourse(newStudent.getCourse());
		existing.setCollege(newStudent.getCollege());
		return repo.save(existing);
	}

	// ✅ PARTIAL UPDATE (PATCH)
	public Student updateStudentPartial(Integer id, Map<String, Object> updates) {
		Student student = repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
		updates.forEach((key, value) -> {
			switch (key) {
			case "firstName":
				student.setFirstName((String) value);
				break;
			case "lastName":
				student.setLastName((String) value);
				break;
			case "address":
				student.setAddress((String) value);
				break;
			case "phoneNo":
				student.setPhoneNo(Long.valueOf(value.toString()));
				break;
			case "email":
				student.setEmail((String) value);
				break;
			case "course":
				student.setCourse((String) value);
				break;
			case "college":
				Map<String, Object> collegeMap = (Map<String, Object>) value;
				Integer collegeId = (Integer) collegeMap.get("id");

				College college = new College();
				college.setId(collegeId);

				student.setCollege(college);
				break;
			}
		});

		return repo.save(student);
	}

	public String deleteById(Integer id) {
		if (!repo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with ID " + id + " not found");
		}
		repo.deleteById(id);
		return "Data deleted Succussfully..!";
	}

	public Student getStudentByid(Integer id) {

		if (!repo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with ID " + id + " not found");
		}

		return repo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
	}

	public Page<Student> getStudentsWithPagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return repo.findAll(pageable);
	}

}
