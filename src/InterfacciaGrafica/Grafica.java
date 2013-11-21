package InterfacciaGrafica;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import MetodiGioco.*;

/** 
 * @author Jacopo C.
 *	Classe che crea l'interfaccia grafica e relativi pulsanti.
 *	Le azioni sono gestite nelle classi ascoltatrici.
 */

public class Grafica{

	JFrame home;
	JLabel titolo;
	JTextPane tentativo;
	public Partita match = new Partita();
	public MasterMind MM = new MasterMind();
	public Store salvataggi;
	public JButton controllo;
	
	JSpinner a = new JSpinner();
	JSpinner b = new JSpinner();
	JSpinner c = new JSpinner();
	JSpinner d = new JSpinner();
	JScrollPane scrollPane;
	String testo ="";
	
	public Grafica(){
		
		try {
			salvataggi=MM.readStore();
		} catch (Exception e) {
			salvataggi=new Store();
		}
		
		home= new JFrame("MasterMind");
		home.setSize(365,440);
		home.setResizable(false);
		home.setLayout(null);
		home.setLocationRelativeTo(null);
		home.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		titolo = new JLabel("MasterMind");
		titolo.setBounds(120, 25, 110, 30);
		titolo.setFont(new Font("Serif", Font.PLAIN, 20));
		home.getContentPane().add(titolo, BorderLayout.CENTER);
		
		controllo= new JButton("Controllo");
		controllo.setBounds(230, 85, 90, 25);
		home.getContentPane().add(controllo, BorderLayout.CENTER);
				
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		home.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNG = new JMenuItem("Nuova partita");
		mnFile.add(mntmNG);
		
		JMenuItem mntmResa = new JMenuItem("Abbandona");
		mnFile.add(mntmResa);
		
		JMenuItem mntStat = new JMenuItem("Statistiche");
		mnFile.add(mntStat);
		
		JMenuItem mntmEsci = new JMenuItem("Esci");
		mnFile.add(mntmEsci);
		
		JMenu menu = new JMenu("?");
		menuBar.add(menu);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		menu.add(mntmHelp);
		
		tentativo = new JTextPane();
		tentativo.setEditable(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 140, 330, 260);
		scrollPane.setViewportView(tentativo);
		home.getContentPane().add(scrollPane);
		
		a.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		a.setBounds(30, 90, 30, 20);
		home.getContentPane().add(a, BorderLayout.CENTER);
		
		b.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		b.setBounds(70, 90, 30, 20);
		home.getContentPane().add(b, BorderLayout.CENTER);
		
		c.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		c.setBounds(110, 90, 30, 20);
		home.getContentPane().add(c, BorderLayout.CENTER);
		
		d.setModel(new SpinnerNumberModel(0, 0, 9, 1));
		d.setBounds(150, 90, 30, 20);
		home.getContentPane().add(d, BorderLayout.CENTER);

		AscoltatoreBottoni aslB = new AscoltatoreBottoni(this);
		controllo.addActionListener(aslB);
		
		AscoltatoreJMenù aslM = new AscoltatoreJMenù(this);
		mntmEsci.addActionListener(aslM);
		mntmNG.addActionListener(aslM);
		mntmHelp.addActionListener(aslM);
		mntStat.addActionListener(aslM);
		mntmResa.addActionListener(aslM);
		
		home.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				try {
					MM.saveStore(salvataggi);
				} catch (Exception e1) {}
				System.exit(0);
			}
		});
		home.setVisible(true);
	}

}
