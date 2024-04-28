package com.vivek.Api;


import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vivek.Entity.Student;

import jakarta.websocket.server.PathParam;

@RestController
public class StudentApi {
	
	Map<Integer, Student> stu = new HashMap<>();

	@PostMapping("/save")
	public ResponseEntity<String>saveData( @RequestBody Student student){
		System.out.println(student);
		stu.put(student.getId(), student);
		return new ResponseEntity<>("Data Saved",HttpStatus.CREATED);
	}
	
	@GetMapping("/student")
//	it is use to fetch data from Url (Chrome)
//	http://localhost:8080/student?std=101
//	it use when we use @requestParam
	public Student getStudent(@RequestParam("std") Integer std) {
		Student student = stu.get(std);
		return student;
	}
	
	@GetMapping("/ashish/{idI}")
//	http://localhost:8080/ashish/102/data
//	pathParam  is used when we find unique key values
	public Student getAshish(@PathVariable("idI") Integer idI) {
		Student student = stu.get(idI);
		return student;
		
		
	}

}

