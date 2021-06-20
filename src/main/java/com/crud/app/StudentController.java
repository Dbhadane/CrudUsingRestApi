package com.crud.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/students")
public class StudentController
{
    @Autowired
    StudentService service;
    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        List<StudentEntity> list = service.getAllStudents();
 
        return new ResponseEntity<List<StudentEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	StudentEntity entity = service.getStudentById(id);
         
        return new ResponseEntity<StudentEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<StudentEntity> createOrUpdateStudent(@Validated @RequestBody StudentEntity student)
                                                    throws RecordNotFoundException {
    	StudentEntity updated = service.createOrUpdateStudent(student);
        return new ResponseEntity<StudentEntity>(updated, HttpStatus.OK);
    }
    
    @GetMapping(value={"/findByBranch/{brname}","/findByBranch"})
    public ResponseEntity<List<StudentEntity>> getAllStudentByBranch(  @PathVariable(required = false) String brname)
        
    		throws RecordNotFoundException {
    
    	if(brname==null)    	
    		{
    		System.out.println("in if");
  		  List<StudentEntity> list = service.getAllStudents();
  		  
  	      return new ResponseEntity<List<StudentEntity>>(list, new HttpHeaders(), HttpStatus.OK);
  
  	
    		
        		}
    	else
    	{
    		System.out.println("in else");
    		List<StudentEntity> list = service.getAllStudentByBranch(brname);
 
           return new ResponseEntity<List<StudentEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    	
    	}
    		
    }
}