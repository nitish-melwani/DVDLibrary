package com.wileyedge.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.wileyedge.DVD;

public class DVDRowMapper implements RowMapper<DVD> {

	@Override
	public DVD mapRow(ResultSet rs, int rowNum) throws SQLException {
		String titles = rs.getString("titles");
		Date date = rs.getDate("relasedate");
		LocalDate d = date.toLocalDate();
		String director = rs.getString("director");
		String studio = rs.getString("studio");
		double rating = rs.getDouble("rating");
		String notes = rs.getString("usernotes");
		if (notes == null) {
			return new DVD(titles, d, rating, director, studio);
		}
		
		return new DVD(titles, d, rating, director, studio, notes);
	}

}
