package com.example.xml.bind;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		try {
			
			Student student = new Student();
			Address adrs = new Address("Andhra Pradesh","Vijayawada","India","522503");
			
			student.setEmail("abc@gmail.com");
			student.setFirstName("bhojanapalli");
			student.setLastName("Revathi");
			student.setId(1);
			student.setAddress(adrs);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
			
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			File file = new File("src\\main\\resources\\student.xml");
			
			marshaller.marshal(student, file);

	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


}


