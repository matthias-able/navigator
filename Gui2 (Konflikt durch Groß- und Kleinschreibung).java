import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class gui2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtStartort;
	private JTextField txtZielort;
	private JButton btnStreckeBerechnen;
	/*private JScrollBar scrollBar;
	private JTextArea textArea;*/
	private JScrollPane scrollPane;
	private JPanel text;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui2 frame = new gui2();
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
	public gui2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 450);
		
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		text = new JPanel(new BorderLayout());
		text.setBorder(new EmptyBorder(730, 60, 20, 330));
		text.add(new JLabel("Dies ist ein viel zu langer Text für dieses " +
                "kleine Fenster, so dass man horizontal " +
                "scrollen muss, um ihn komplett zu lesen."));
		
		txtStartort = new JTextField();
		txtStartort.setText("Startort");
		txtStartort.setBounds(10, 8, 200, 30);
		contentPane.add(txtStartort);
		txtStartort.setColumns(10);
		
		txtZielort = new JTextField();
		txtZielort.setText("Zielort");
		txtZielort.setBounds(260, 8, 200, 30);
		contentPane.add(txtZielort);
		txtZielort.setColumns(10);
		
		btnStreckeBerechnen = new JButton();
		btnStreckeBerechnen.setText("Strecke berechnen");
		btnStreckeBerechnen.setBounds(510, 8, 200, 30);
		contentPane.add(btnStreckeBerechnen);
		
		/*scrollBar = new JScrollBar(1);
		scrollBar.setBounds(730, 60, 20, 330);
		contentPane.add(scrollBar);			
		scrollBar.setAutoscrolls(true);
		
		
		textArea = new JTextArea("text");
		textArea.setBounds(10, 60, 710, 330);
		textArea.setEditable(true);
		contentPane.add(textArea);*/
		
		scrollPane = new JScrollPane (text, 
	            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
	            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 60, 710, 330);
		scrollPane.add(text);
		contentPane.add(scrollPane);
		
	}

}
