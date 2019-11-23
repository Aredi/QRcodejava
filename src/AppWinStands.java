import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.google.zxing.WriterException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class AppWinStands {

	private JFrame frame;
	private JTextField textFieldX;
	private JTextField textFieldY; 
	private JTextField textFieldQR;
	private JLabel jlabelY;
	private JLabel jlabelQR;
	private int CompteurStands = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWinStands window = new AppWinStands();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppWinStands() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 854, 679);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldX = new JTextField();
		textFieldX.setBounds(30, 66, 114, 19);
		frame.getContentPane().add(textFieldX);
		textFieldX.setColumns(10);
		
		textFieldY = new JTextField();
		textFieldY.setBounds(201, 66, 114, 19);
		frame.getContentPane().add(textFieldY);
		textFieldY.setColumns(10);
		
		textFieldQR = new JTextField();
		textFieldQR.setBounds(30, 123, 379, 19);
		frame.getContentPane().add(textFieldQR);
		textFieldQR.setColumns(10);		
		
		JLabel jlabelX = new JLabel("position X:");
		jlabelX.setBounds(30, 27, 115, 15);
		frame.getContentPane().add(jlabelX);
		
		jlabelY = new JLabel("position Y:");
		jlabelY.setBounds(201, 27, 115, 15);
		frame.getContentPane().add(jlabelY);
		
		jlabelQR = new JLabel("Indiquer l'URL QR Code à générer:");
		jlabelQR.setBounds(30, 97, 159, 25);
		frame.getContentPane().add(jlabelQR);
		
		JButton btnCreateStand = new JButton("Créer Stand");
		btnCreateStand.setBounds(376, 66, 159, 25);
		frame.getContentPane().add(btnCreateStand);
		btnCreateStand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				
				try {
					Stand creer;
					creer = new Stand();
					creer.setBounds(Integer.parseInt(textFieldX.getText()),Integer.parseInt(textFieldY.getText()),200,200);
					frame.getContentPane().add(creer);
					creer.setTextQR(textFieldQR.getText());
					creer.creerImageQRcode();
				
					String CompteurString = String.valueOf(CompteurStands);
					
					ImageIcon icon = new ImageIcon("/home/administrateur/QRStock28png" + CompteurString );
					creer.setIcon(icon);
					frame.repaint();
					creer.repaint();
					CompteurStands++;
				} catch (WriterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
}