package kidsapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class Blog2 extends JFrame implements ActionListener {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	private int chromeShown = 1;

	private JTextArea titleArea;
	private JTextArea p1Area;

	private JButton returnButton;
	private JButton nextButton;
	private JButton prevButton;

	private Timer timer;

	private JLabel background;
	private JLabel topPic;

	public Blog2() {
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
				}
				else if (chromeShown % 5 == 2) {

					ImageIcon icon = new ImageIcon("1.jpg");
					Image image = icon.getImage();
					Image newing = getScaledImage(image, 300, 300);
					icon = new ImageIcon(newing);
					topPic.setIcon(icon);
					chromeShown++;
				}
				else if (chromeShown % 5 == 3) {

					ImageIcon icon = new ImageIcon("2.jpg");
					Image image = icon.getImage();
					Image newing = getScaledImage(image, 300, 300);
					icon = new ImageIcon(newing);
					topPic.setIcon(icon);
					chromeShown++;
				}
				else if (chromeShown % 5 == 4) {

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
		titleArea.append("\nThe Philadelphia Zoo \n\tAmerica's first zoo!");

		titleArea.setFont(new Font("monospaced", Font.BOLD, 17));
		
		titleArea.setOpaque(true);
		getContentPane().add(titleArea);
		titleArea.setForeground(Color.RED);
		
		
		p1Area = new JTextArea(60, 50);
		p1Area.setOpaque(true);
		p1Area.setEditable(false);
		p1Area.setLineWrap(true);
		p1Area.append("\n\n\tAmerica’s first zoo, the Philadelphia Zoo "
				+ "is home to nearly 1,300 animals, many rare and endangered. "
				+ "Kids will love Zoo360, an animal travel and exploration system "
				+ "that enables tigers, orangutans, lemurs and other animals to "
				+ "move right above visitors' heads. Don't miss the KidZooU: "
				+ "Hamilton Family Children’s Zoo & Faris Family Education Center,"
				+ " including a barnyard where kids can pet and brush sheep, "
				+ "mini-horses and goats, and an indoor education center teeming with "
				+ "coral reef fish, colorful parakeets and more.");

		
		p1Area.setFont(new Font("monospaced", Font.PLAIN, 15));
		
		
//		JScrollPane scroll = new JScrollPane(p1Area);
		p1Area.setBounds(350, 90, 400, 275);
//		scroll.setBounds(350, 80, 400, 230);
		getContentPane().add(p1Area);
		
		nextButton = new JButton("Next >>");
		nextButton.setBounds(550, 370, 100, 50);
		nextButton.setForeground(Color.DARK_GRAY);
		nextButton.setFont(new Font("Courier New", Font.BOLD, 16));
		nextButton.addActionListener(this);
		getContentPane().add(nextButton);
		
		prevButton = new JButton("<< Prev");
		prevButton.setBounds(450, 370, 100, 50);
		prevButton.setForeground(Color.DARK_GRAY);
		prevButton.setFont(new Font("Courier New", Font.BOLD, 16));
		prevButton.addActionListener(this);
		getContentPane().add(prevButton);
		
		returnButton = new JButton("Return");
		returnButton.setBounds(650, 370, 100, 50);
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
		if(e.getSource() == prevButton) {
			
			this.setVisible(false);
			
			new Blog1();
			
		}
		
		if(e.getSource() == returnButton) {
			this.setVisible(false);
			new HomePage();
		}
		if(e.getSource() == nextButton){
			this.setVisible(false);
			new Blog3();
		}

	}

}
