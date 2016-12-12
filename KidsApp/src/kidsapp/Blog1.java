package kidsapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Blog1 extends JFrame implements ActionListener {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	private int chromeShown = 1;

	private JTextArea titleArea;
	private JTextArea p1Area;

	private JButton returnButton;
	private JButton nextButton;
	// private JButton prevButton;

	private Timer timer;

	private JLabel background;
	private JLabel topPic;

	public Blog1() {

		JPanel panel = new JPanel();
		background = new JLabel();
		getContentPane().setLayout(null);

		ImageIcon background_image = new ImageIcon("background.png");
		background.setLayout(null);
		background.setIcon(background_image);
		background.setBounds(0, 0, WIDTH, HEIGHT);
		this.getContentPane().add(background);

		ImageIcon icon = new ImageIcon("adventure.jpg");
		Image image = icon.getImage();
		Image newing = getScaledImage(image, 300, 300);
		icon = new ImageIcon(newing);
		topPic = new JLabel(icon);

		chromeShown = 1;
		panel.setBounds(20, 40, 300, 300);
		panel.add(topPic);
		timer = new Timer(1500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chromeShown % 5 == 1) {

					ImageIcon icon = new ImageIcon("PhiladelphiaZoo.jpg");
					Image image = icon.getImage();
					Image newing = getScaledImage(image, 300, 300);
					icon = new ImageIcon(newing);
					topPic.setIcon(icon);
					chromeShown++;
				} else if (chromeShown % 5 == 2) {

					ImageIcon icon = new ImageIcon("1.jpg");
					Image image = icon.getImage();
					Image newing = getScaledImage(image, 300, 300);
					icon = new ImageIcon(newing);
					topPic.setIcon(icon);
					chromeShown++;
				} else if (chromeShown % 5 == 3) {

					ImageIcon icon = new ImageIcon("2.jpg");
					Image image = icon.getImage();
					Image newing = getScaledImage(image, 300, 300);
					icon = new ImageIcon(newing);
					topPic.setIcon(icon);
					chromeShown++;
				} else if (chromeShown % 5 == 4) {

					ImageIcon icon = new ImageIcon("3.jpg");
					Image image = icon.getImage();
					Image newing = getScaledImage(image, 300, 300);
					icon = new ImageIcon(newing);
					topPic.setIcon(icon);
					chromeShown++;
				}

				else {
					ImageIcon icon = new ImageIcon("11.jpg");
					Image image = icon.getImage();
					Image newing = getScaledImage(image, 300, 300);
					icon = new ImageIcon(newing);
					topPic.setIcon(icon);
					chromeShown++;
				}
			}
		});
		timer.start();
		this.getContentPane().add(panel);

		titleArea = new JTextArea(50, 50);
		titleArea.setBounds(350, 50, 400, 60);
		titleArea.setLineWrap(true);
		titleArea.setEditable(false);
		titleArea.append("\nPlease Touch Museum \n\tWhere kids ages 1 – 7 are boss");
		titleArea.setFont(new Font("monospaced", Font.BOLD, 17));

		titleArea.setOpaque(true);
		getContentPane().add(titleArea);
		titleArea.setForeground(Color.RED);

		p1Area = new JTextArea(50, 50);
		p1Area.setOpaque(true);
		p1Area.setEditable(false);
		p1Area.setLineWrap(true);
		p1Area.append("\n\n\tHoused in Fairmount Park’s Memorial"
				+ " Hall, the kid-centric Please Touch Museum includes tw" + "o full floors of interactive zones, "
				+ "plus a fully restored carousel that's over 100 years old. " + "Youngsters can play and pretend "
				+ "amid Alice’s Wonderland, River " + "Adventures and other hands-on exhibitions.\n\n");

		p1Area.setFont(new Font("monospaced", Font.PLAIN, 15));

		// JScrollPane scroll = new JScrollPane(p1Area);
		p1Area.setBounds(350, 90, 400, 230);
		// scroll.setBounds(350, 80, 400, 230);
		getContentPane().add(p1Area);

		nextButton = new JButton("Next >>");
		nextButton.setBounds(550, 330, 100, 50);
		nextButton.setForeground(Color.DARK_GRAY);
		nextButton.setFont(new Font("Courier New", Font.BOLD, 16));
		nextButton.addActionListener(this);
		getContentPane().add(nextButton);

		returnButton = new JButton("Return");
		returnButton.setBounds(650, 330, 100, 50);
		returnButton.setForeground(Color.DARK_GRAY);
		returnButton.setFont(new Font("Courier New", Font.BOLD, 16));
		returnButton.addActionListener(this);
		getContentPane().add(returnButton);

		setTitle("Philly Children");
		setResizable(false);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();
		return resizedImg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == nextButton) {

			this.setVisible(false);

			new Blog2();

		}

		if (e.getSource() == returnButton) {
			this.setVisible(false);
			new HomePage();
		}

	}

}
