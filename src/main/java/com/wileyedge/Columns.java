package com.wileyedge;

public enum Columns {
	TITLES, RELASEDATE,DIRECTOR,STUDIO,USERNOTES,RATING;
	
	
	public Columns fromString(String n) {
		if(n.equalsIgnoreCase("titles")) {
			return Columns.TITLES;
		} else if(n.equalsIgnoreCase("relasedate")) {
			return Columns.RELASEDATE;
		} else if(n.equalsIgnoreCase("director")) {
			return Columns.DIRECTOR;
		} else if(n.equalsIgnoreCase("studio")) {
			return Columns.STUDIO;
		} else if(n.equalsIgnoreCase("usernotes")) {
			return Columns.USERNOTES;
		} else if(n.equalsIgnoreCase("rating")) {
			return Columns.RATING;
		} 
		else {
			return null;
		}
	}
}
