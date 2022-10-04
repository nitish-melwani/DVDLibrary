package com.wileyedge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wileyedge.Columns;
import com.wileyedge.DVD;
import com.wileyedge.dao.DVDDao;
import com.wileyedge.dao.IDao;

@Component(value = "service")
public class DVDService implements IService {

	@Autowired
	private IDao dao; 
	
	public DVDService() {

	}
	

	@Override
	public void addDVD(List<DVD> dvd) {
		for(DVD d:dvd) {
			dao.addDVD(d);
		}

		
	}

	@Override
	public void removeDVD(List<String> titles) {
		for(String t:titles) {
			dao.removeDVD(t);
		}
	}
	@Override
	public void editDVD(List<String> dvd, List<Columns> c, List<String> input) {
		int i = 0;
		for (String d:dvd) {
			dao.editDVD(d, c.get(i), input.get(i));
			i++;
		}
		
	}

	@Override
	public void searchDVD(List<String> title) {
		for (String t:title) {
			dao.searchDVD(t);
		}
		
	}
	@Override
	public List<DVD> loadDVD() {
		return dao.loadDVD();
		
	}
	@Override
	public void saveDVD(List<DVD> dvds) {
		dao.saveDVD(dvds); 
		
	}
	@Override
	public void displayDVD(List<Columns> c, List<String> input) {
		int i = 0;
		for (String n:input) {
			dao.displayDVD(c.get(i), n);
		}
	}
	@Override
	public void listDVD() {
		dao.listDVD();
		
	}



}
