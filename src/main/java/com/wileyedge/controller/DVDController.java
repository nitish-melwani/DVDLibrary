package com.wileyedge.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.wileyedge.Columns;
import com.wileyedge.DVD;
import com.wileyedge.service.DVDService;
import com.wileyedge.service.IService;


@Component(value = "control")
public class DVDController implements IController{
	@Autowired
	private IService service;
	public DVDController() {
	}
	
	@Override
	public void addDVD() {
		Scanner sec = new Scanner(System.in);
		List<DVD> dvds = new ArrayList<DVD>();
		int numadd;
		String title;
		LocalDate releaseDate;
		double rating;
		String directorName;
		String studio;
		String userNotes;
		String temp;
		System.out.println("How many movies would you like to add");
		numadd = Integer.parseInt(sec.nextLine());
		for(int i = 0; i<numadd; i++) {
			
			
			System.out.print("Please input the name of the movie");
			title = sec.nextLine();
			
			
			System.out.println("Please input the relase date (yyyy-mm-dd)");
			releaseDate = LocalDate.parse(sec.nextLine());
			
			System.out.println("Please input the directors name");
			directorName = sec.nextLine();
			
			
			System.out.println("Please input the rating the movie recieved");
			rating = Double.parseDouble(sec.nextLine());

			
			System.out.println("Please input the name of the studio");
			studio = sec.nextLine();
			
			
			System.out.println("Would you like to write any notes with regards to the movie? y/n");
			temp = sec.nextLine();
			
			if (temp.equalsIgnoreCase("y")) {
				System.out.println("What would you like to add");
				userNotes = sec.nextLine();
				dvds.add(new DVD(title, releaseDate, rating, directorName, studio, userNotes));
			} else {
				dvds.add(new DVD(title, releaseDate, rating, directorName, studio));
			}
		}
		service.addDVD(dvds);
	}
	
	@Override
	public void removeDVD() {
		Scanner sec = new Scanner(System.in);
		List<String> removes = new ArrayList<String>();
		int numadd;
		String title;
		System.out.println("How many movies would you like to remove");
		numadd = Integer.parseInt(sec.nextLine());
		for(int i = 0; i<numadd; i++) {
			System.out.println("Please input the name of the movie");
			title = sec.nextLine();
			removes.add(title);
		}
		service.removeDVD(removes);
	}
	@Override
	public void editDVD() {
		Scanner sec = new Scanner(System.in);
		List<String> titles = new ArrayList<String>();
		List<String> infos = new ArrayList<String>();
		List<Columns> column = new ArrayList<Columns>();
		int numadd;
		String title;
		String col;
		String info;
		Columns c = Columns.DIRECTOR;
		System.out.println("How many movies would you like to edit");
		numadd = Integer.parseInt(sec.nextLine());
		for(int i = 0; i<numadd; i++) {
			System.out.println("Please input the name of the movie");
			title = sec.nextLine();
			System.out.println("What would you like to edit");
			col = sec.nextLine();
			c = c.fromString(col);
			System.out.println("Please input the new information");
			info = sec.nextLine();
			titles.add(title);
			infos.add(info);
			column.add(c);
		}
		service.editDVD(titles, column, infos);
	}
	
	@Override
	public void displayDVD() {
		Scanner sec = new Scanner(System.in);
		List<String> infos = new ArrayList<String>();
		List<Columns> column = new ArrayList<Columns>();
		int numadd;
		String col;
		String info;
		Columns c = Columns.DIRECTOR;
		System.out.println("How many movies would you like to display for");
		numadd = Integer.parseInt(sec.nextLine());
		for(int i = 0; i<numadd; i++) {
			System.out.println("What parameter would you like to search with");
			col = sec.nextLine();
			c = c.fromString(col);
			System.out.println("Please input the search value");
			info = sec.nextLine();
			infos.add(info);
			column.add(c);
		}
		service.displayDVD(column, infos);
	}
	@Override
	public void searchDVD() {
		Scanner sec = new Scanner(System.in);
		List<String> titles = new ArrayList<String>();
		int numadd;
		String title;
		System.out.println("How many movies would you like to search for");
		numadd = Integer.parseInt(sec.nextLine());
		for(int i = 0; i<numadd; i++) {
			System.out.println("What movie would you like to search for");
			title = sec.nextLine();
			titles.add(title);
		}
		service.searchDVD(titles);
	}
	@Override
	public List<DVD> loadDVD(){
		List<DVD> dvds = new ArrayList<DVD>();
		dvds = service.loadDVD();
		return dvds;
		
	}
	@Override
	public void saveDVD(List<DVD> dvds) {
		service.saveDVD(dvds);
	}
	@Override
	public void listDVD() {
		service.listDVD();
		
	}
}
