package com.wileyedge;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component(value = "e2")
public class DVD implements Serializable{
	private String title;
	private LocalDate releaseDate;
	private double rating;
	private String directorName;
	private String studio;
	private String userNotes;
	private int id;
	
	public DVD() {
		System.out.println("Inside default constructor of DVD");
	}
	

	public DVD(String title, LocalDate releaseDate, double rating, String directorName, String studio,
			String userNotes) {
		System.out.println("Inside param constructor of DVD");
		this.title = title;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.directorName = directorName;
		this.studio = studio;
		this.userNotes = userNotes;
	}
	
	public DVD(String title, LocalDate releaseDate, double rating, String directorName, String studio) {
		System.out.println("Inside param2 constructor of DVD");
		this.title = title;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.directorName = directorName;
		this.studio = studio;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getUserNotes() {
		return userNotes;
	}

	public void setUserNotes(String userNotes) {
		this.userNotes = userNotes;
	}

	@Override
	public String toString() {
		return "DVD [title=" + title + ", releaseDate=" + releaseDate + ", rating=" + rating + ", directorName="
				+ directorName + ", studio=" + studio + ", userNotes=" + userNotes + ", id=" + id + "]";
	}

	
}
