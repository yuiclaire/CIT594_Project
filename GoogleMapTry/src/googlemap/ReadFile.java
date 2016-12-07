package googlemap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadFile {
	

    public static final int MIN_ZOOM = 4;
    public static final int MAX_ZOOM = 100;

    private static int zoomValue = 4;
    
	public static void main(String[] args){
		Browser browser = new Browser();
		BrowserView view = new BrowserView(browser);

        JButton zoomInButton = new JButton("Zoom In");
        zoomInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (zoomValue < MAX_ZOOM) {
                    browser.executeJavaScript("map.setZoom(" + ++zoomValue + ")");
                }
            }
        });

        JButton zoomOutButton = new JButton("Zoom Out");
        zoomOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (zoomValue > MIN_ZOOM) {
                    browser.executeJavaScript("map.setZoom(" + --zoomValue + ")");
                }
            }
        });
        
		Map<Integer, Parks> parks = new HashMap<Integer, Parks>();
		loadParks("parks.csv", parks);
		
		 JButton setMarkerButton = new JButton("Set Marker");
	        setMarkerButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	for(int i:parks.keySet()){
	            		double x = parks.get(i).x;
		            	double y = parks.get(i).y;
		            	Parks p = parks.get(i);
		            	browser.executeJavaScript("var myLatlng"+i+" = new google.maps.LatLng("+y+"," + x+ ");\n" +
		                        "var marker"+i+" = new google.maps.Marker({\n" +
		                        "    position: myLatlng"+i+",\n" +
		                        "    map: map,\n" +
		                        "    title: '********MORE INFO********\\rname: "+p.name +"\\raddress: "+p.address+"\\rphone: "+p.phone +"'\n" +
		                        "});");
	            	}       
	            }
	        });

		
        JPanel toolBar = new JPanel();
        toolBar.add(zoomInButton);
        toolBar.add(zoomOutButton);
        toolBar.add(setMarkerButton);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(view, BorderLayout.CENTER);
        frame.add(toolBar, BorderLayout.SOUTH);
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Provide the correct full path to the map.html file, e.g. D:\\map.html
        browser.loadURL("file:///Users/Adele/Documents/workspace/GoogleMapTry/myMap.html");
	}
	
	public static void loadParks(String fileName, Map<Integer, Parks> parks){
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
				parks.put(objectID,p);
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
