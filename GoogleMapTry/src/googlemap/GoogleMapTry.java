package googlemap;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

//import com.teamdev.jxbrowser.chromium.BrowserFactory;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GoogleMapTry {

	public static void main(String[] args) {
		Browser browser = new Browser();
		BrowserView view = new BrowserView(browser);
		JFrame frame = new JFrame("JxBrowser Google Maps");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(view, BorderLayout.CENTER);
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		 browser.executeJavaScript("var myLatlng = new google.maps.LatLng(-25.363, 131.044);\n" +
                 "var marker = new google.maps.Marker({\n" +
                 "    position: myLatlng,\n" +
                 "    map: map,\n" +
                 "    title: 'Hello World!'\n" +
                 "});");
		browser.loadHTML(loadweb(30.0, 13.044));
	}

	public static String loadweb(double lat, double lng) {

		// double lat = -25.363;
		// double lng = 131.044;
		// browser.loadURL("http://maps.google.com");
		// browser.loadURL("file:///Users/Adele/Documents/workspace/GoogleMapTry/myMap.html");
		String html = "<!DOCTYPE html>\n" + 
		"<html>\n" + 
			"<head>\n" + 
				"<title>Simple click event</title>\n" + 
				"<meta name='viewport' content='initial-scale=1.0, user-scalable=no'>\n" + 
				"<meta charset='utf-8'>\n" + 
				"<style>\n" + 
					" #map {\n" + " height: 100%;\n" + 
					"}\n" + 
					"html, body {\n" + 
					"height: 100%;\n"+ 
					"margin: 0;\n" + 
					"padding: 0;\n" + 
				    "}\n" + 
				"</style>\n" + 
			"</head>\n" + 
			"<body>\n" + 
				"<div id='map'></div>\n" + 
				"<script>\n" + 
					"function initMap() {\n" + 
						"var myLatlng = {lat:" + lat + ", lng: " + lng + "};\n" + 
						"var map = new google.maps.Map(document.getElementById('map'), {\n"+ 
						"zoom: 4,\n" + " center: myLatlng\n" + "});\n" +
						"var marker = new google.maps.Marker({\n" + 
							"position: myLatlng,\n" + "map: map,\n" + 
							"title: 'Click to zoom'\n" + "});\n" +
						"map.addListener('center_changed', function() {\n" + 
								"window.setTimeout(function() {\n"+ 
									"map.panTo(marker.getPosition());\n" + "}, 3000);\n" + 
						"});\n" +
					"}\n" + 
				"</script>\n" +
				"<script async defer\n"+ 
					"src='https://maps.googleapis.com/maps/api/js?key=AIzaSyDjBnYo_3KJ-Fw24_U5BkNgjc8TBCQAFG8&callback=initMap'>\n"
				+ "</script>\n" + 
			"</body>\n" +
		"</html>";
		return html;
	}
}