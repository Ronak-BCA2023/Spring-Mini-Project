package com.ronaksoft.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ronaksoft.controller.MainController;
import com.ronaksoft.vo.StudentVo;

public class NestedApplicationTest {
	public static void main(String[] args) throws Exception {

		//parent ioc container
		ApplicationContext parentioc, childioc= null;
		parentioc = new ClassPathXmlApplicationContext("com/ronaksoft/resources/parentctx.xml");
		
		//child ioc conainer
		childioc = new ClassPathXmlApplicationContext(new String[]  {"com/ronaksoft/resources/childctx.xml"}, parentioc) ;
		
		//get controller
		MainController controller = childioc.getBean("controller", MainController.class);
		List<StudentVo> studentRecord = controller.getStudentRecord("java", "css");
		for(StudentVo record : studentRecord) {
			String id = record.getId();
			String name = record.getName();
			String course = record.getCourse();
			String batch = record.getBatch();
			String fee = record.getFee();
			
			System.out.println("Student Id: " + id);
			System.out.println("String Name: " + name);
			System.out.println("String Course: " + course);
			System.out.println("String Batch: " + batch);
			System.out.println("String Fee: " + fee);
			System.out.println("===================================");
		}
	}
}