import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.Box;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.event.*;
import java.awt.event.*;

public class Fenster extends JFrame {

    private JPanel contentPane;
    private JTextField txtStartort;
    private JTextField txtZielort;
    private final JButton btnStreckeBerechnen = new JButton("Strecke Berechnen");
    private JScrollPane scroll;
    private JTextArea text = new JTextArea("");
    
    private Dijkstra routing = new Dijkstra();    
    private Adjazenzmatrix adj = new Adjazenzmatrix();
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Fenster frame = new Fenster();
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
    public Fenster() {
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 753, 438);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
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
        
        btnStreckeBerechnen.setBounds(510, 8, 200, 30);
        btnStreckeBerechnen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                btnStreckeBerechnen_ActionPerformed(evt);
            }
        });
               
        contentPane.add(btnStreckeBerechnen);
        JScrollPane scroll = new JScrollPane(text);
        scroll.setBounds(10, 60, 700, 330);
        contentPane.add(scroll);
        text.append("Dies ist ein viel zu langer Text für dieses kleine Fenster, so dass man horizontal scrollen muss, um ihn komplett zu lesen.");
        
    }
    
    public void  btnStreckeBerechnen_ActionPerformed(ActionEvent evt){
        
        // läuft alles im Graf ab
        // Graph erstellen 
        adj.GraphErstellen();
        //direkten WEg löschen
        /*int start, ziel, int kantenGewicht;
        
        start = adj.matrixGeben().knotenIndexSuchen(txtStartort.getText());
        ziel = adj.matrixGeben().knotenIndexSuchen(txtZielort.getText())
        
        int [][] tempMatrix = adj.matrixGeben();
        
        kantenGewicht = tempMatrix[start][ziel];
        
        adj.
        */
        
        // starte Dijkstra
        Knoten[] route = routing.routeStartUp(adj.matrixGeben(), adj.matrixGeben().knotenIndexSuchen(txtStartort.getText()),adj.matrixGeben().knotenIndexSuchen(txtZielort.getText()));
        // Ausgabe eintragen
        for(int i = 0; i<26; i++){
            text.append(route[i].inhaltGeben().SehenswürdigkeitenGeben());
        }
        
    }
}
