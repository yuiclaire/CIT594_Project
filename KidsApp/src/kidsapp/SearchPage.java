package kidsapp;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

@SuppressWarnings("serial")
public class SearchPage extends JFrame implements ActionListener {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public static final int MIN_ZOOM = 0;
	public static final int MAX_ZOOM = 100;
	private static int zoomValue = 12;

	boolean customerSearch = false;

	Map<Integer, Destinations> location;
	// Manager manager;
	private JLabel wordSearchLabel;
	private JTextField wordSearchField;
	private JButton searchButton;
	private JButton stopButton;
	private JButton zoomInButton;
	private JButton zoomOutButton;
	private JButton setMarkerButton;
	private JButton clearMarkerButton;
	private JButton returnButton;

	Browser browser;

	public SearchPage(String text, Manager m) {
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

		setMarkerButton = new JButton("Show All Locations");
		setMarkerButton.addActionListener(this);

		clearMarkerButton = new JButton("Clear All Markers");
		clearMarkerButton.addActionListener(this);

		returnButton = new JButton("Return");
		returnButton.addActionListener(this);

		JPanel searchBar = new JPanel(new GridLayout(4, 1));
		wordSearchLabel = new JLabel("Enter key word ");
		wordSearchField = new JTextField();
		wordSearchField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				if (customerSearch) {
					re_search(wordSearchField.getText());
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (customerSearch) {
					re_search(wordSearchField.getText());
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				if (customerSearch) {
					re_search(wordSearchField.getText());
				}
			}

		});
		searchButton = new JButton("Search");
		searchButton.addActionListener(this);

		stopButton = new JButton("Stop");
		stopButton.addActionListener(this);

		searchBar.add(wordSearchLabel);
		searchBar.add(wordSearchField);
		searchBar.add(searchButton);
		searchBar.add(stopButton);

		JPanel toolBar = new JPanel(new GridLayout(2, 3));
		toolBar.add(zoomInButton);
		toolBar.add(zoomOutButton);
		toolBar.add(new JPanel());
		toolBar.add(setMarkerButton);
		toolBar.add(clearMarkerButton);
		toolBar.add(returnButton);

		add(view, BorderLayout.CENTER);
		add(toolBar, BorderLayout.SOUTH);
		add(searchBar, BorderLayout.WEST);

		setTitle("Philly");
		setResizable(false);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		browser.loadURL("file:///Users/Adele/Documents/workspace/KidsApp/myMap.html");
	}

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
			for (int i : location.keySet()) {
				double x = location.get(i).x;
				double y = location.get(i).y;
				Destinations p = location.get(i);
				browser.executeJavaScript("var contentString = '<div id=1>'+" + "'<div id=2>'+"
						+ "'<p><b>*************** MORE INFO ***************</b></p>'+" + "'<p><b>&nbsp&nbspname: " + p.name
						+ "</b></p>'+" + "'<p><b>&nbsp&nbspaddress: " + p.address + "</b></p>'+"
						+ "'<p><b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
						+ "Philadelphia, PA " + p.zip + "</b></p>'+" + "'<p><b>&nbsp&nbspphone: " + p.phone + "</b></p>'+"
						+ "'</div>'+" + "'</div>';" + "var infowindow = new google.maps.InfoWindow({"
						+ "content: contentString});\n" + "var myLatlng" + i + " = new google.maps.LatLng(" + y + ","
						+ x + ");\n" + "var marker" + i + " = new google.maps.Marker({\n" + "    position: myLatlng" + i
						+ ",\n" + "    map: map,\ndraggable: false, animation: google.maps.Animation.DROP,"
						+ "    title: '**********MORE INFO**********\\rname: " + p.name + "\\raddress: " + p.address
						+ "\\rphone: " + p.getPhone() + "'\n" + "});\n" + "marker" + i
						+ ".addListener('click', function() {" + "infowindow.open(map, marker" + i + ");" + "});");
			}
		} else if (e.getSource() == clearMarkerButton) {
			for (int i : location.keySet()) {
				browser.executeJavaScript("marker" + i + ".setMap(null);");
			}
		} else if (e.getSource() == returnButton) {
			this.setVisible(false);
			new HomePage();
		} else if (e.getSource() == searchButton) {
			customerSearch = true;
			re_search(wordSearchField.getText());
		} else if (e.getSource() == stopButton) {
			customerSearch = false;
		}

	}

	public ArrayList<Integer> searchKeyWords(String s) {
		ArrayList<Integer> find = new ArrayList<Integer>();
		for (int id : location.keySet()) {
			String name = location.get(id).getName().toLowerCase();
			if (name.lastIndexOf(s.toLowerCase()) >= 0) {
				find.add(id);
			}
		}
		return find;

	}

	public void re_search(String s) {
		ArrayList<Integer> find = searchKeyWords(s);
		for (int i : location.keySet()) {
			browser.executeJavaScript("marker" + i + ".setMap(null);");
		}
		for (int i : find) {
			double x = location.get(i).x;
			double y = location.get(i).y;
			Destinations p = location.get(i);
			browser.executeJavaScript("var contentString = '<div id=1>'+" + "'<div id=2>'+"
					+ "'<p><b>*************** MORE INFO ***************</b></p>'+" + "'<p><b>&nbsp&nbspname: " + p.name
					+ "</b></p>'+" + "'<p><b>&nbsp&nbspaddress: " + p.address + "</b></p>'+"
					+ "'<p><b>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
					+ "Philadelphia, PA " + p.zip + "</b></p>'+" + "'<p><b>&nbsp&nbspphone: " + p.phone + "</b></p>'+"
					+ "'</div>'+" + "'</div>';" + "var infowindow = new google.maps.InfoWindow({"
					+ "content: contentString});\n" + "var myLatlng" + i + " = new google.maps.LatLng(" + y + ","
					+ x + ");\n" + "var marker" + i + " = new google.maps.Marker({\n" + "    position: myLatlng" + i
					+ ",\n" + "    map: map,\ndraggable: false, animation: google.maps.Animation.DROP,"
					+ "    title: '**********MORE INFO**********\\rname: " + p.name + "\\raddress: " + p.address
					+ "\\rphone: " + p.getPhone() + "'\n" + "});\n" + "marker" + i
					+ ".addListener('click', function() {" + "infowindow.open(map, marker" + i + ");" + "});");
		}
	}
}
