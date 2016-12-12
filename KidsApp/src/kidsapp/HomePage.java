package kidsapp;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

/**
 * 
 * 
 * */
@SuppressWarnings("serial")
public class HomePage extends JFrame implements ActionListener {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	private JLabel desitinationNameLabel;

	private JButton searchButton;
	private JButton recommendButton;
	private JButton blogButton;
	
	private JComboBox<String> jcombobox;
	String text;
	
	

	private JLabel background;

	public HomePage() {
		getContentPane().setLayout(null);
		
		// background
		background = new JLabel();
		ImageIcon background_image = new ImageIcon("background.jpg");
		
		background.setBounds(0, 0, WIDTH, HEIGHT);	
		background.setLayout(null);
		background.setIcon(background_image);
		getContentPane().add(background);
		
		// label "Category"
		desitinationNameLabel = new JLabel("Category: ");
		getContentPane().add(desitinationNameLabel);
		desitinationNameLabel.setBounds(150, 130, 280, 35);
		desitinationNameLabel.setFont(new Font("Courier New", Font.BOLD, 30));
		desitinationNameLabel.setForeground(Color.white);
		background.add(desitinationNameLabel);
		
		// combo box
		jcombobox = new JComboBox<String>(new String[]{"Parks","Theaters","Universities", "Libraries", "Museums","Historical Sites"});
		getContentPane().add(jcombobox);
		jcombobox.setFont(new Font("Courier New", Font.PLAIN, 22));
		jcombobox.setBounds(330, 136, 250, 30);
//		jcombobox.addItemListener(new ItemListener(){
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				if(e.getStateChange() ==ItemEvent.SELECTED){
//					text = (String)jcombobox.getSelectedItem();
//				}
//			}
//		});
		
		background.add(jcombobox);
								
		// searchButton								
		searchButton = new JButton("Search");
		getContentPane().add(searchButton);
		searchButton.addActionListener(this);
		searchButton.setBounds(190, 230, 350, 30);
		searchButton.setFont(new Font("Courier New", Font.BOLD, 20));
		background.add(searchButton);
		
		//recommendButton
		recommendButton = new JButton("Recommend");
		getContentPane().add(recommendButton);
		recommendButton.addActionListener(this);
		recommendButton.setBounds(190, 280, 350, 30);
		recommendButton.setFont(new Font("Courier New", Font.BOLD, 20));
		background.add(recommendButton);
		
		//blogButton
		blogButton = new JButton("Blogs");
		getContentPane().add(blogButton);				
		blogButton.addActionListener(this);
		blogButton.setBounds(190, 330, 350, 30);
		blogButton.setFont(new Font("Courier New", Font.BOLD, 20));
		background.add(blogButton);
		
		setTitle("Philly Children");
		setResizable(false);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchButton){
			this.setVisible(false);
			text = (String)jcombobox.getSelectedItem();
			Manager m = new Manager();
			new SearchPage(text, m);
		}else if(e.getSource() == recommendButton){
			this.setVisible(false);
			text = (String)jcombobox.getSelectedItem();
			Manager m = new Manager();
			new RecommendPage(text, m);
		}else if(e.getSource() == blogButton){
			this.setVisible(false);
			new Blog1();
		}
		
	}
}

	
