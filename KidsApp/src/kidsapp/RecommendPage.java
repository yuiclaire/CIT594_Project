package kidsapp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

/**
 * 
 * This class defines the recommend page of our application.
 * Put a marker on the map and all qualifying locations close to 
 * that marker will be shown on the map
 * A user can also clear all markers with one click to start a new search.
 */
@SuppressWarnings("serial")
public class RecommendPage extends JFrame implements ActionListener {
	// size of the frame
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public static final int MIN_ZOOM = 0;
	public static final int MAX_ZOOM = 100;
	private static int zoomValue = 12;
	
	// Set the Customer Search Mode to be false by default 
	boolean customerSearch = false;

	Map<Integer, Destinations> location;

	private JButton zoomInButton;
	private JButton zoomOutButton;
	private JButton setMarkerButton;
	private JButton clearMarkerButton;
	private JButton recommendButton;
	private JButton returnButton;

	Browser browser;
	
	/**
	 * Constructor, initialize all components in the frame
	 * @param text
	 * 				determines what kinds of destination to use
	 * @param m
	 * 				Manager object provides the data needed in searching
	 */
	public RecommendPage(String text, Manager m) {
		
		// determine which kinds of destination to search
		if (text.equals("Parks")) {
			location = m.Parks;
		} else if (text.equals("Museums")) {
			location = m.Museums;
		} else if (text.equals("Libraries")) {
			location = m.Libraries;
		} else if (text.equals("Universities")) {
			location = m.Universities;
		} else if (text.equals("Theaters")) {
			location = m.HistoricSites;
		} else if (text.equals("Historical Sites")) {
			location = m.HistoricSites;
		}

		browser = new Browser();
		BrowserView view = new BrowserView(browser);

		zoomInButton = new JButton("Zoom In");
		zoomInButton.addActionListener(this);

		zoomOutButton = new JButton("Zoom Out");
		zoomOutButton.addActionListener(this);

		setMarkerButton = new JButton("Place A Marker");
		setMarkerButton.addActionListener(this);

		clearMarkerButton = new JButton("Clear All Markers");
		clearMarkerButton.addActionListener(this);

		recommendButton = new JButton("Recommend");
		recommendButton.addActionListener(this);
		recommendButton.setEnabled(false);

		returnButton = new JButton("Return");
		returnButton.addActionListener(this);

		JPanel toolBar = new JPanel(new GridLayout(2, 3));
		toolBar.add(zoomInButton);
		toolBar.add(zoomOutButton);
		toolBar.add(clearMarkerButton);
		toolBar.add(setMarkerButton);
		toolBar.add(recommendButton);
		toolBar.add(returnButton);

		add(view, BorderLayout.CENTER);
		add(toolBar, BorderLayout.SOUTH);
		
		setTitle("Philly");
		setResizable(false);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Initialize the web page embedded in the frame
		String html = "<!DOCTYPE html>" + "<html>" + "<head>"
				+ "<meta name='viewport' content='initial-scale=1.0, user-scalable=no' />" + "<style type='text/css'>"
				+ "html { height: 100% }" + "body { height: 100%; margin: 0; padding: 0 }"
				+ "#map-canvas { height: 100% }" + "</style>" + "<script type='text/javascript'"
				+ "src='https://maps.googleapis.com/maps/api/js?key=AIzaSyB7J1zsErb9_7jxNu5KU5kIENFObAQEbl0&sensor=false'>"
				+ "</script>" + "<script type='text/javascript'>" + "var map;" + "function initialize() {"
				+ "var mapOptions = {" + "center: new google.maps.LatLng(39.957206, -75.171911)," + "zoom: 12" + "};"
				+ "map = new google.maps.Map(document.getElementById('map-canvas')," + "mapOptions);" + "}"
				+ "google.maps.event.addDomListener(window, 'load', initialize);" + "</script>" + "</head>" + "<body>"
				+ "<div id='map-canvas'/>" + "</body>" + "</html>";
		browser.loadHTML(html);
	}
	
	/**
	 * Define what action will be performed after an action happens
	 * Clicking on the zoomInButton will drag the map closer.
	 * Clicking on the zoomOutButton will push the map farther.
	 * Clicking on the setMarkerButton will put a draggable marker on the map.
	 * Clicking on the clearMarkerButton will clean all locations.
	 * Clicking on the returnButton will return to homepage.
	 * Clicking on the recommendButton will show all locations close to the customer_put marker
	 * then the map will also be updated and show all qualifying locations.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == zoomInButton) {
			if (zoomValue < MAX_ZOOM) {
				browser.executeJavaScript("map.setZoom(" + ++zoomValue + ")");
			}
		} else if (e.getSource() == zoomOutButton) {
			if (zoomValue > MIN_ZOOM) {
				browser.executeJavaScript("map.setZoom(" + --zoomValue + ")");
			}
		} else if (e.getSource() == setMarkerButton) {
			for (int i : location.keySet()) {
				browser.executeJavaScript("marker" + i + ".setMap(null);");
			}
			
			// initial position of the draggable user_put marker
			double x = -75.160635355809347;
			double y = 39.981066480611737;
			
			//clean old markers and put new markers on the map
			browser.executeJavaScript("myMarker.setMap(null);");
			browser.executeJavaScript("var myLatlng = new google.maps.LatLng(" + y + "," + x + ");\n"
					+ "var myMarker = new google.maps.Marker({position: myLatlng,\n" + "icon: 'blue_MarkerA.png',"
					+ "map: map,\ndraggable: true, animation: google.maps.Animation.DROP," + "title: 'Drag Me!'\n"
					+ "});");
			recommendButton.setEnabled(true);
		} else if (e.getSource() == clearMarkerButton) {
			for (int i : location.keySet()) {
				browser.executeJavaScript("marker" + i + ".setMap(null);");
			}
		} else if (e.getSource() == returnButton) {
			this.setVisible(false);
			new HomePage();
		} else if (e.getSource() == recommendButton) {
			for (int i : location.keySet()) {
				browser.executeJavaScript("marker" + i + ".setMap(null);");
			}
			for (int i : location.keySet()) {
				double x = location.get(i).x;
				double y = location.get(i).y;
				Destinations p = location.get(i);
				
				// execute javascript code to set the markers
				browser.executeJavaScript("var distance1 = new Number(" + (x + y) + ");"
						+ "var distance2 =  myMarker.getPosition().lat() + myMarker.getPosition().lng();"
						+ "if((distance1 - distance2) * (distance1 - distance2) <= 0.00005){"
						+ "var contentString = '<div id=1>'+" + "'<div id=2>'+"
						+ "'<p><b>*************** MORE INFO ***************</b></p>'+" + "'<p><b>&nbsp&nbspname: "
						+ p.name + "</b></p>'+" + "'<p><b>&nbsp&nbspaddress: " + p.address + "</b></p>'+"
						+ "'<p><b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
						+ "Philadelphia, PA " + p.zip + "</b></p>'+" + "'<p><b>&nbsp&nbspphone: " + p.phone
						+ "</b></p>'+" + "'</div>'+" + "'</div>';" + "var infowindow = new google.maps.InfoWindow({"
						+ "content: contentString});\n" + "var myLatlng" + i + " = new google.maps.LatLng(" + y + ","
						+ x + ");\n" + "var marker" + i + " = new google.maps.Marker({\n" + "    position: myLatlng" + i
						+ ",\n" + "    map: map,\ndraggable: false, animation: google.maps.Animation.DROP,"
						+ "    title: '**********MORE INFO**********\\rname: " + p.name + "\\raddress: " + p.address
						+ "\\rphone: " + p.getPhone() + "'\n" + "});\n" + "marker" + i
						+ ".addListener('click', function() {" + "infowindow.open(map, marker" + i + ");" + "});}");
			}
		}
	}

}
