package com.spring.basics.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIn5StepsApplication {


	public static void main(String[] args) {
		
		ApplicationContext applicationContenxt = SpringApplication.run(SpringIn5StepsApplication.class, args);
		
		/*BinarySearchImpl binarySearch = applicationContenxt.getBean(BinarySearchImpl.class);
		
		int result = binarySearch.binarySearch(new int [] { 1,2,4,3,6}, 3);
		
		System.out.println(result);*/
	}
}
