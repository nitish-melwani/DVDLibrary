package com.wileyedge.service;
import com.wileyedge.*;

import java.util.List;

public interface IService {
	void addDVD(List<DVD> dvd);
	void removeDVD(List<String> condition);
	void editDVD(List<String> dvd, List<Columns> c, List<String> input);
	void listDVD();
	void displayDVD(List<Columns> c, List<String> input);
	void searchDVD(List<String> title);
	List<DVD> loadDVD();
	void saveDVD(List<DVD> dvds);
	
}
