package com.wileyedge.controller;

import java.util.List;

import com.wileyedge.DVD;

public interface IController {
	void addDVD();
	void removeDVD();
	void editDVD();
	void listDVD();
	void displayDVD();
	void searchDVD();
	List<DVD> loadDVD();
	void saveDVD(List<DVD> dvds);
}
