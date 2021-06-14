package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Driver {
	
	ArrayList<Cereal> cereals;
	
	
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.createCerealDB();
		try {
			driver.serializeCereal();
			driver.deserializeCereal();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.readDB();
	}
	
	public void addCereal(String name, float price) {
		cereals.add(new Cereal(name,price));
	}
	
	public void createCerealDB() {
		Cereal c1 = new Cereal("Cap'n Cranch", 4.10f);
		Cereal c2 = new Cereal("Brice Frispies", 2.17f);
		Cereal c3 = new Cereal("On-Brand Stuff", 6.10f);
		Cereal c4 = new Cereal("Fruity-O's", 3.50f);
		
		cereals = new ArrayList<>();
		cereals.add(c1);
		cereals.add(c2);
		cereals.add(c3);
		cereals.add(c4);
		
	}
	
	public void readDB() {
		System.out.println(cereals);
	}
	
	public void serializeCereal() throws IOException{
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(
					new FileOutputStream("cereals.ser"));
			oos.writeObject(cereals);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();			
		}finally {
			oos.close();
		}
	}
	public void deserializeCereal() throws IOException {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(
					new FileInputStream("cereals.ser"));
			cereals = (ArrayList<Cereal>)ois.readObject();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			ois.close();
		}
	}
	
	

}
