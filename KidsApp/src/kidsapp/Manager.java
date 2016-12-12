package kidsapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
This class is used for loading and managing data. 
**/
public class Manager {
	public HashMap<Integer, Destinations> HistoricSites = new HashMap<Integer, Destinations>();
	public HashMap<Integer, Destinations> Libraries = new HashMap<Integer, Destinations>();
	public HashMap<Integer, Destinations> Museums = new HashMap<Integer, Destinations>();
	public HashMap<Integer, Destinations> Parks = new HashMap<Integer, Destinations>();
	public HashMap<Integer, Destinations> Theaters = new HashMap<Integer, Destinations>();
	public HashMap<Integer, Destinations> Universities = new HashMap<Integer, Destinations>();
	
	public Manager(){
		loadMuseums("museums.txt");
		loadParks("parks.csv");
		loadLibraries("libraries.csv");
		loadUniverties("universities.csv");
		loadTheaters("theaters.csv");
		loadHistoricSites("historicSites.csv");
	}
	/*This method is used for load musuem related file*/
	public void loadMuseums(String fileName){
		File file = new File(fileName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while((line = br.readLine())!= null){
				//System.out.println(line);
				String[] tokens = line.split("\t");
				int objectID = Integer.parseInt(tokens[2]);
				double x = Double.parseDouble(tokens[0]);
				double y = Double.parseDouble(tokens[1]);
				String name = tokens[3];
				String address = tokens[4];
				String zip = tokens[5];
				String phone = tokens[6];
				Museums p = new Museums(objectID,x,y,name,address,zip,phone);
				Museums.put(objectID,p);
			}
			//System.out.println("finish");
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/*This method is used for load park related file*/
	public void loadParks(String fileName){
		File file = new File(fileName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while((line = br.readLine())!= null){
				//System.out.println(line);
				String[] tokens = line.split(",");
				int objectID = Integer.parseInt(tokens[2]);
				double x = Double.parseDouble(tokens[0]);
				double y = Double.parseDouble(tokens[1]);
				String name = tokens[3];
				String address = tokens[4];
				String zip = tokens[5];
				String phone = tokens[6];
				Parks p = new Parks(objectID,x,y,name,address,zip,phone);
				Parks.put(objectID,p);
			}
			//System.out.println("finish");
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/*This method is used for load libraries file*/
	public void loadLibraries(String fileName){
		File file = new File(fileName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while((line = br.readLine())!= null){
				//System.out.println(line);
				String[] tokens = line.split(",");
				//System.out.println(tokens.length);
				int objectID = Integer.parseInt(tokens[2]);
				double x = Double.parseDouble(tokens[0]);
				double y = Double.parseDouble(tokens[1]);
				String name = tokens[3];
				String address = tokens[4];
				String zip = tokens[5];
				String phone = tokens[6];
				Libraries p = new Libraries(objectID,x,y,name,address,zip,phone);
				Libraries.put(objectID,p);
			}
			//System.out.println("finish");
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/*This method is used for load universities file*/
	public void loadUniverties(String fileName){
		File file = new File(fileName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while((line = br.readLine())!= null){
				//System.out.println(line);
				String[] tokens = line.split(",");
				int objectID = Integer.parseInt(tokens[2]);
				double x = Double.parseDouble(tokens[0]);
				double y = Double.parseDouble(tokens[1]);
				String name = tokens[3];
				String address = tokens[4];
				String zip = tokens[5];
				String phone = tokens[6];
				Universities p = new Universities(objectID,x,y,name,address,zip,phone);
				Universities.put(objectID,p);
			}
			//System.out.println("finish");
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/*This method is used for load Theaters file*/
	public void loadTheaters(String fileName){
		File file = new File(fileName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while((line = br.readLine())!= null){
				//System.out.println(line);
				String[] tokens = line.split(",");
				int objectID = Integer.parseInt(tokens[2]);
				double x = Double.parseDouble(tokens[0]);
				double y = Double.parseDouble(tokens[1]);
				String name = tokens[3];
				String address = tokens[4];
				String zip = tokens[5];
				String phone = tokens[6];
				Theaters p = new Theaters(objectID,x,y,name,address,zip,phone);
				Theaters.put(objectID,p);
			}
			//System.out.println("finish");
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/*This method is used for load Historic Sites file*/
	public void loadHistoricSites(String fileName){
		File file = new File(fileName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while((line = br.readLine())!= null){
				//System.out.println(line);
				String[] tokens = line.split(",");
				//System.out.println(tokens.length);
				int objectID = Integer.parseInt(tokens[2]);
				double x = Double.parseDouble(tokens[0]);
				double y = Double.parseDouble(tokens[1]);
				String name = tokens[3];
				String address = tokens[4];
				String zip = tokens[5];
				String phone = tokens[6];
				HistoricSites p = new HistoricSites(objectID,x,y,name,address,zip,phone);
				HistoricSites.put(objectID,p);
			}
			//System.out.println("finish");
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
