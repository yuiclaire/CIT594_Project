package phily;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class Manager {
	public static HashMap<Integer, HistoricSites> HistoricSites = new HashMap<Integer, HistoricSites>();
	public static HashMap<Integer, Libraries> Libraries = new HashMap<Integer, Libraries>();
	public static HashMap<Integer, Museums> Museums = new HashMap<Integer, Museums>();
	public static HashMap<Integer, Parks> Parks = new HashMap<Integer, Parks>();
	public static HashMap<Integer, Theaters> Theaters = new HashMap<Integer, Theaters>();
	public static HashMap<Integer, Universities> Universities = new HashMap<Integer, Universities>();

	public static void loadParks(String fileName){
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
			System.out.println("finish");
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
