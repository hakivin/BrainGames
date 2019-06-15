package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Menu() {
		this.setUndecorated(true);
		setBackground(Color.BLACK);
		setResizable(false);
		setTitle("Brain Games");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/resource/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton exitButton = new JButton("");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBackground(Color.WHITE);
		exitButton.setIcon(new ImageIcon(Menu.class.getResource("/resource/exiticon.png")));
		exitButton.setBounds(1834, 23, 59, 61);
		contentPane.add(exitButton);
		
		JLabel backgroundImage = new JLabel("");
		
		backgroundImage.setBounds(0, 0, 1920, 1080);
		backgroundImage.setIcon(new ImageIcon(Menu.class.getResource("/resource/depan.png")));
		contentPane.add(backgroundImage);
		
		JButton playButton = new JButton("");
		playButton.setIcon(new ImageIcon(Menu.class.getResource("/resource/play.png")));
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//setVisible(false);
				dispose();
				Gameplay game = new Gameplay();
				game.setExtendedState(JFrame.MAXIMIZED_BOTH); 
				game.setVisible(true);
			}
		});
		playButton.setFont(new Font("Tahoma", Font.PLAIN, 95));
		playButton.setBounds(812, 919, 292, 82);
		contentPane.add(playButton);
	}
}
