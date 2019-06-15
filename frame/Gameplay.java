package frame;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import engine.QuestionGenerator;

public class Gameplay extends JFrame {
	
	private QuestionGenerator engine = new QuestionGenerator();
	private JPanel contentPane;
	private JLabel heart1 = null;
	private JLabel heart2 = null;
	private JLabel heart3 = null;
	private JLabel question = null;
	private JButton aBtn = null;
	private JButton bBtn = null;
	private JButton cBtn = null;
	private JButton dBtn = null;
	private JLabel scoreLabel = null;
	private int n = 0;
	private int lives = 3;
	private ArrayList<Integer> soal = engine.gener();
	/**
	 * Create the frame.
	 */
	public Gameplay() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gameplay.class.getResource("/resource/logo.png")));
		this.setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        this.setSize(xsize, ysize);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scoreLabel = new JLabel("Score = " + n);
		scoreLabel.setFont(new Font("AR CENA", Font.PLAIN, 60));
		scoreLabel.setBounds(339, 235, 397, 98);
		contentPane.add(scoreLabel);

		heart1 = new JLabel("");
		heart1.setIcon(new ImageIcon(Gameplay.class.getResource("/resource/live.png")));
		heart1.setBounds(1601, 111, 64, 64);
		contentPane.add(heart1);
		
		heart2 = new JLabel("");
		heart2.setIcon(new ImageIcon(Gameplay.class.getResource("/resource/live.png")));
		heart2.setBounds(1681, 111, 64, 64);
		contentPane.add(heart2);
		
		heart3 = new JLabel("");
		heart3.setIcon(new ImageIcon(Gameplay.class.getResource("/resource/live.png")));
		heart3.setBounds(1757, 111, 64, 64);
		contentPane.add(heart3);
		
		question = new JLabel("");
		question.setHorizontalAlignment(SwingConstants.CENTER);
		question.setFont(new Font("Tahoma", Font.PLAIN, 75));
		question.setBounds(12, 311, 1896, 315);
		contentPane.add(question);
		
		aBtn = new JButton("");
		aBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(engine.getBank().get(soal.get(n)).checkAnswer(aBtn.getText())) {
					n++;
					scoreLabel.setText("Score = " + n*10);
					print(soal.get(n));
				}
				else {
					lives--;
					lives(heart1, heart2, heart3, lives);
				}
			}
		});
		aBtn.setFont(new Font("Tahoma", Font.PLAIN, 33));
		aBtn.setBounds(527, 682, 347, 80);
		contentPane.add(aBtn);
		
		bBtn = new JButton("");
		bBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(engine.getBank().get(soal.get(n)).checkAnswer(bBtn.getText())) {
					n++;
					scoreLabel.setText("Score = " + n*10);
					print(soal.get(n));
				}
				else {
					lives--;
					lives(heart1, heart2, heart3, lives);
				}
			}
		});
		bBtn.setFont(new Font("Tahoma", Font.PLAIN, 33));
		bBtn.setBounds(527, 845, 347, 80);
		contentPane.add(bBtn);
		
		cBtn = new JButton("");
		cBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(engine.getBank().get(soal.get(n)).checkAnswer(cBtn.getText())) {
					n++;
					scoreLabel.setText("Score = " + n*10);
					print(soal.get(n));
				}
				else {
					lives--;
					lives(heart1, heart2, heart3, lives);
				}
			}
		});
		cBtn.setFont(new Font("Tahoma", Font.PLAIN, 33));
		cBtn.setBounds(1043, 682, 347, 80);
		contentPane.add(cBtn);
		
		dBtn = new JButton("");
		dBtn.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseClicked(MouseEvent e) {
				if(engine.getBank().get(soal.get(n)).checkAnswer(dBtn.getText())) {
					n++;
					scoreLabel.setText("Score = " + n*10);
					print(soal.get(n));
				}
				else {
					lives--;
					lives(heart1, heart2, heart3, lives);
				}
				
			}
		});
		dBtn.setFont(new Font("Tahoma", Font.PLAIN, 33));
		dBtn.setBounds(1043, 845, 347, 80);
		contentPane.add(dBtn);
		
		print(soal.get(n));
		//lives(heart1, heart2, heart3, lives);
		if(lives == 0) {
			GameOver frame = new GameOver();
			frame.setVisible(true);
//			dispose();
//			Menu frame = new Menu();
//			frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//			frame.setVisible(true);
		}
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setIcon(new ImageIcon(Gameplay.class.getResource("/resource/dalem.png")));
		backgroundImage.setBounds(0, 0, 1920, 1080);
		contentPane.add(backgroundImage);
	}
	
	private void print(int a) {
		if(engine.getBank().get(a).getSoal().length() > 40) {
			String x = engine.getBank().get(a).getSoal().substring(0, 41);
			String y = engine.getBank().get(a).getSoal().substring(41);
			if(y.charAt(0)==' '||y.charAt(0)=='?'||y.charAt(1)==' ')
				question.setText("<HTML>" + x + "<br>" + y +"</HTML>");
			else
				question.setText("<HTML>" + x + "-" + "<br>" + y +"</HTML>");
		}
		else
			question.setText(engine.getBank().get(a).getSoal());
		aBtn.setText(engine.getBank().get(a).getA());
		bBtn.setText(engine.getBank().get(a).getB());
		cBtn.setText(engine.getBank().get(a).getC());
		dBtn.setText(engine.getBank().get(a).getD());
	}
	
	private void lives(JLabel a, JLabel b, JLabel c, int lives) {
		JLabel[] nyawa = {a,b,c};
		for(int i = 3; i > lives; i--) {
			nyawa[i-1].setIcon(null);
		}
		if(lives == 0) {
			GameOver frame = new GameOver();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
//			dispose();
//			Menu frame = new Menu();
//			frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//			frame.setVisible(true);
		}
		else if(lives < 0) {
			System.exit(0);
		}
	}
	
	public static void music() {
		
	}
}
