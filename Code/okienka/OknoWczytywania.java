package okienka;
import main.Swiat;
import zdarzenia.EventSuwakX;
import zdarzenia.EventSuwakY;
import zdarzenia.EventPrzyciskOK;
import zdarzenia.EventDolnePrzyciski;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;


@SuppressWarnings("serial")
public class OknoWczytywania extends JFrame
{
	public JSlider suwakX, suwakY;
	public JRadioButton wyborZwykla, wyborHex;
	public JLabel infoRozmiarX, infoRozmiarY;

	
	public OknoWczytywania(Swiat swiat)
	{
		final int wartoscDomyslna = 18;
		final int liczbaPolMin = 2;
		final int liczbaPolMaks = 50;
		final int szerokosc = 450;
		final int wysokosc = 280;
		final int wysokoscPanelu = (int) wysokosc/4;
		
		this.setTitle("Konfiguracja planszy");
		this.setPreferredSize(new Dimension(szerokosc, wysokosc));
		this.setMinimumSize(new Dimension(szerokosc, wysokosc));
		this.setMaximumSize(new Dimension(szerokosc, wysokosc));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		
		//Gorny panel z tekstem
		JPanel panelTekst = new JPanel();
		panelTekst.setLocation(0, 0);
		panelTekst.setSize(szerokosc, wysokoscPanelu);
		
		//Zawartosc panelu z tekstem
		JLabel info = new JLabel();
		info.setFont(new Font("MonospacedBold", Font.PLAIN, 20));
		info.setText("Wybierz rozmiar i rodzaj planszy");
		panelTekst.add(info);
		
		
		//Panel z wczytywaniem
		JPanel panelWczyt = new JPanel();
		panelWczyt.setLocation(0, wysokoscPanelu);
		panelWczyt.setSize(szerokosc, wysokoscPanelu);
		
		//Suwak X
		suwakX = new JSlider(JSlider.HORIZONTAL, liczbaPolMin, liczbaPolMaks, wartoscDomyslna); //Wczytywanie szerokosci planszy
		suwakX.setMajorTickSpacing(1);
		suwakX.setPaintTicks(true);
		panelWczyt.add(suwakX);
		
		infoRozmiarX = new JLabel("Rozmiar planszy X: " + wartoscDomyslna);
		panelWczyt.add(infoRozmiarX);
		
		EventSuwakX eventX = new EventSuwakX(this);
		suwakX.addChangeListener(eventX);
		
		//SuwakY
		suwakY = new JSlider(JSlider.HORIZONTAL, liczbaPolMin, liczbaPolMaks, wartoscDomyslna); //Wczytywanie wysokosci planszy
		suwakY.setMajorTickSpacing(1);
		suwakY.setPaintTicks(true);
		panelWczyt.add(suwakY);
		
		infoRozmiarY = new JLabel("Rozmiar planszy Y: " + wartoscDomyslna);
		panelWczyt.add(infoRozmiarY);
		
		EventSuwakY eventY = new EventSuwakY(this);
		suwakY.addChangeListener(eventY);
			
		
		//Panel z wyborem rozgrywki
		JPanel panelWybor = new JPanel();
		panelWybor.setLocation(0, 2 * wysokoscPanelu);
		panelWybor.setSize(szerokosc, wysokoscPanelu);
		
		//Pola radio
		wyborZwykla = new JRadioButton("Plansza zwykla");
		wyborZwykla.setActionCommand("Zwykla");
		wyborZwykla.setSelected(true);
		wyborHex = new JRadioButton("Plansza hexagonalna");
		wyborHex.setActionCommand("Hex");
		
		ButtonGroup grupa = new ButtonGroup();
	    grupa.add(wyborZwykla);
	    grupa.add(wyborHex);
		panelWybor.add(wyborZwykla);
		panelWybor.add(wyborHex);
		
		
		//Stopka
		JPanel stopka = new JPanel();
		stopka.setLocation(0, 3 * wysokoscPanelu);
		stopka.setSize(szerokosc, wysokoscPanelu);
		
		//Przycisk OK
		JButton przyciskOK = new JButton("OK");
		stopka.add(przyciskOK);
		
		EventPrzyciskOK eventOK = new EventPrzyciskOK(this, swiat);
		przyciskOK.addActionListener(eventOK);
		
		//Przycisk wyjscia 
		JButton przyciskWyjscie = new JButton("Wyjscie");
		stopka.add(przyciskWyjscie);
		
		EventDolnePrzyciski eventDolnePrzyciski = new EventDolnePrzyciski(swiat);
		przyciskWyjscie.setActionCommand("Wyjscie");
		przyciskWyjscie.addActionListener(eventDolnePrzyciski);
		
		
		add(panelTekst);
		add(panelWczyt);
		add(panelWybor);
		add(stopka);
		pack();
		setVisible(true);
	}
}