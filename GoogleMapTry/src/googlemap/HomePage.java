package googlemap;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HomePage extends JFrame implements ActionListener {
	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;
	
	private JTextField desitinationNameField;
	

	private JLabel desitinationNameLabel;
	private JLabel cityLabel;
	private JLabel discountLabel;

	private JButton searchButton;
	private JButton recommendButton;
	
	private JComboBox jcombobox;
	String text;
	
	

	private JLabel background;

	public HomePage() {
		getContentPane().setLayout(null);
		
		background = new JLabel();
		ImageIcon background_image = new ImageIcon("background.jpg");
		
		background.setBounds(0, 0, WIDTH, HEIGHT);	
		
		background.setLayout(null);
		background.setIcon(background_image);
		getContentPane().add(background);
		
		desitinationNameLabel = new JLabel("Category: ");
		getContentPane().add(desitinationNameLabel);
		desitinationNameLabel.setBounds(60, 109, 200, 20);
		desitinationNameLabel.setFont(new Font("Courier New", Font.ITALIC, 100));
		desitinationNameLabel.setForeground(Color.white);
		background.add(desitinationNameLabel);
		
		jcombobox = new JComboBox(new String[]{"Parks","Theaters","Universities", "Libraries", "Museums","Historical Sites"});
		getContentPane().add(jcombobox);
		jcombobox.setBounds(200, 109, 250, 20);
		desitinationNameLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		background.add(jcombobox);
								
										
		searchButton = new JButton("Search");
		getContentPane().add(searchButton);
		searchButton.addActionListener(this);
		searchButton.setBounds(133, 205, 350, 20);
		searchButton.setFont(new Font("Courier New", Font.BOLD, 16));
		background.add(searchButton);
												
		recommendButton = new JButton("Recommend");
		getContentPane().add(recommendButton);
		recommendButton.addActionListener(this);
		recommendButton.setBounds(133, 237, 350, 20);
		recommendButton.setFont(new Font("Courier New", Font.BOLD, 16));
		background.add(recommendButton);
		
		actionListener();
		
		setTitle("Philly Children");
		setResizable(false);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionListener(){
		jcombobox.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() ==ItemEvent.SELECTED){
					text = (String)jcombobox.getSelectedItem();
				}
				
			}
			
		});
		searchButton.addActionListener(this);
		recommendButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchButton){
			this.setVisible(false);
			new SearchPage(text);
		}
		
	}
	public static void main(String[] args) {
		new HomePage();
//		hp.display();
	}
}

	
