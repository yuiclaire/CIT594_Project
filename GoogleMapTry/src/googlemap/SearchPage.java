package googlemap;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

public class SearchPage extends JFrame implements ActionListener {
	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;

	public static final int MIN_ZOOM = 0;
	public static final int MAX_ZOOM = 100;
	private static int zoomValue = 4;

	//JPanel googleMap = new JPanel();
	private JLabel wordSearchLabel;
	private JTextField wordSearchField;

	public SearchPage(String text) {
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
				for (int i : parks.keySet()) {
					double x = parks.get(i).x;
					double y = parks.get(i).y;
					Parks p = parks.get(i);
					browser.executeJavaScript("var myLatlng" + i + " = new google.maps.LatLng(" + y + "," + x + ");\n"
							+ "var marker" + i + " = new google.maps.Marker({\n" + "    position: myLatlng" + i + ",\n"
							+ "    map: map,\n" + "    title: '********MORE INFO********\\rname: " + p.name
							+ "\\raddress: " + p.address + "\\rphone: " + p.phone + "'\n" + "});");
				}
			}
		});
		JPanel searchBar = new JPanel(new GridLayout(2, 1));
		wordSearchLabel = new JLabel("Enter key word ");
		wordSearchField = new JTextField();
		searchBar.add(wordSearchLabel);
		searchBar.add(wordSearchField);
		
		
		

		JPanel toolBar = new JPanel();
		toolBar.add(zoomInButton);
		toolBar.add(zoomOutButton);
		toolBar.add(setMarkerButton);
		
        add(view, BorderLayout.CENTER);
        add(toolBar, BorderLayout.SOUTH);
        add(searchBar, BorderLayout.WEST);

		setTitle("Philly");
		setResizable(false);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		 browser.loadURL("file:///Users/Adele/Documents/workspace/GoogleMapTry/myMap.html");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void loadParks(String fileName, Map<Integer, Parks> parks) {
		File file = new File(fileName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				String[] tokens = line.split(",");
				int objectID = Integer.parseInt(tokens[2]);
				double x = Double.parseDouble(tokens[0]);
				double y = Double.parseDouble(tokens[1]);
				String name = tokens[3];
				String address = tokens[4];
				String zip = tokens[5];
				String phone = tokens[6];
				Parks p = new Parks(objectID, x, y, name, address, zip, phone);
				parks.put(objectID, p);
			}
			System.out.println("finish");
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SearchPage("");
//		hp.display();
	}
}
