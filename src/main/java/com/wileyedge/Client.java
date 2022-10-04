package com.wileyedge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.wileyedge.controller.DVDController;
import com.wileyedge.controller.IController;
import com.wileyedge.dao.DVDDao;
import com.wileyedge.dao.IDao;
import com.wileyedge.service.DVDService;
import com.wileyedge.service.IService;

public class Client {
	@Autowired
	private IController control;
	private static List<DVD> dvds = new ArrayList<DVD>();
	public void inputLoop(ApplicationContext context) {
		Scanner sec = new Scanner(System.in);
		control = context.getBean("control", DVDController.class);
		System.out.println("Controller =  " + this.control);
		while (true) {
			System.out.println("How can I help you today?");
			String input = sec.nextLine();
			if(input.isEmpty()) {
				break;
			} else if(input.equalsIgnoreCase("Add DVD")) {
				control.addDVD();
			}  else if(input.equalsIgnoreCase("Remove DVD")) {
				control.removeDVD();
			} else if(input.equalsIgnoreCase("Edit DVD")) {
				control.editDVD();
			} else if(input.equalsIgnoreCase("List DVD")) {
				control.listDVD();
			} else if(input.equalsIgnoreCase("Display DVD")) {
				control.displayDVD();
			} else if(input.equalsIgnoreCase("Search DVD")) {
				control.searchDVD();
			} else if(input.equalsIgnoreCase("load DVD")) {
				dvds = control.loadDVD();
			} else if(input.equalsIgnoreCase("Save DVD")) {
				control.saveDVD(dvds);
			} 

		}
		sec.close();
		
		System.out.println("Goodbye.");
	}
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//		DVD d1 = new DVD("John Wick",  LocalDate.of(2020, 2, 3), 8.8, "No Clue", "Paramount"); // code to test the load and save functions
//		DVD d2 = new DVD("John Wick 2",  LocalDate.of(2022, 3, 5), 6.5, "No Clue 2", "Paramount 2");
//		dvds.add(d1);
//		dvds.add(d2);
		System.out.println("before "+dvds);
		Client c = new Client();
		c.inputLoop(context);
		System.out.println(dvds);

		
		
	}

}
