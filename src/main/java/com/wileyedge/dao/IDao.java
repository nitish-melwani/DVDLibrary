package com.wileyedge.dao;

import java.util.List;
import com.wileyedge.*;

public interface IDao {
	void addDVD(DVD dvd);
	void removeDVD(String condition);
	void editDVD(String dvd, Columns c, String input);
	void listDVD();
	void displayDVD(Columns c, String input);
	void searchDVD(String title);
	List<DVD> loadDVD();
	void saveDVD(List<DVD> dvds);
}
