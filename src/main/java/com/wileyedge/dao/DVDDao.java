package com.wileyedge.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wileyedge.Columns;
import com.wileyedge.DVD;

@Component(value = "dao")
public class DVDDao implements IDao, Serializable {
	
	@Autowired
	private JdbcTemplate template;
	public DVDDao() { 
	}
	
	@Override
	public void addDVD(DVD d) {
		String insert = "insert into dvds(titles,relasedate,director, studio,usernotes,rating) values(?,?,?,?,?,?)";
		template.update(insert, d.getTitle(), d.getReleaseDate(), d.getDirectorName(),d.getStudio(),d.getUserNotes(),d.getRating());
	}
	@Override
	public void removeDVD(String condition) {
		String remove = "delete from dvds where titles =" + "'" + condition + "'";
		template.update(remove);
		
	}
	@Override
	public void editDVD(String d, Columns c, String input) {
		String edit = null;
		switch(c){
			case TITLES: edit = "update dvds set titles = '" + input + "'" + " where titles =" + "'" +d + "'";
					break;
			case RELASEDATE: edit = "update dvds set relasedate = '" + LocalDate.parse(input) + "'" + " where titles =" + "'" +d + "'";
					break;
			case DIRECTOR: edit = "update dvds set director = '" + input + "'" + " where titles =" + "'" +d + "'";
					break;
			case STUDIO: edit = "update dvds set studio = '" + input + "'" + " where titles =" + "'" +d + "'";
					break;
			case USERNOTES: edit = "update dvds set usernotes = '" + input + "'" + " where titles =" + "'" +d + "'";
					break;
			case RATING: edit = "update dvds set rating = '" + Double.parseDouble(input) + "'" + " where titles =" + "'" +d + "'";
		}
		template.update(edit);
	}
	
	@Override
	public void listDVD() {
		List<DVD> list = new ArrayList<>();
		String edit = "select * from dvds";
		list = template.query(edit, new DVDRowMapper());
		for(DVD d:list) {
			System.out.println(d.getTitle());
		}
	}
	
	@Override
	public void displayDVD(Columns c, String input) {
		String edit = null;
		switch(c){
			case TITLES: edit = "select * from dvds where titles = '" + input + "'";
					break;
			case RELASEDATE: edit = "select * from dvds where relasedate = '" + input + "'";
					break;
			case DIRECTOR: edit = "select * from dvds where director = '" + input + "'";
					break;			
			case STUDIO: edit = "select * from dvds where studio = '" + input + "'";
					break;
			case USERNOTES: edit = "select * from dvds where usernotes = '" + input + "'";
					break;
			case RATING: edit = "select * from dvds where rating = '" + input + "'";
		}
		List<DVD> list = new ArrayList<>();
		list = template.query(edit, new DVDRowMapper());
		for(DVD d:list) {
			System.out.println(d);
		}
	}
	@Override
	public void searchDVD(String title) {
		List<DVD> list = new ArrayList<>();
		String edit = "select * from dvds where titles = '" + title + "'";
		list = template.query(edit, new DVDRowMapper());
		for(DVD d:list) {
			System.out.println(d);
		}
	}
	@Override
	public List<DVD> loadDVD() {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		List<DVD> dvds = new ArrayList<DVD>();
		try {
			fis = new FileInputStream("C:\\C308\\DVDS");
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			Object obj = ois.readObject();
			if (obj instanceof ArrayList) {
				dvds = (ArrayList<DVD>) obj;
			}
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		} 
		catch (IOException e) {
			System.out.println("IOException1 " + e);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		finally {
			if (ois != null) {
				try {
					ois.close();
				} 
				catch (IOException e) {
					System.out.println("IOException2 " + e);
				}
				return dvds;
			}
		}
		return dvds;
		
	}
	@Override
	public void saveDVD(List<DVD> dvds) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("C:\\C308\\DVDS");
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(dvds);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException1 " + e);
		} finally {
			try {
				if(oos != null) {
				oos.close();
				}
			} catch (IOException e) {
				System.out.println("IOException2 "+ e);
			}
		}
		
	}


}
