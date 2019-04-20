package okienka;
import main.Swiat;
import organizmy.zwierzeta.Czlowiek;
import zdarzenia.EventDolnePrzyciski;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;


@SuppressWarnings("serial")
public class Okno extends JFrame implements KeyListener
{
	private static final int szerokosc = 840*4/3; //840
	private static final int wysokosc = 720*4/3; //720
	private static final float stosunek = 0.8f; //Stosunek wielkosci miedzy panelami - szerokosci planszy i legendy, oraz wysokosci planszy i panelu dolnego
	private JTextPane panelKomentarz;
	public JButton[] dolnePrzyciski;
	private Swiat swiat;
	private JPanel plansza;
	
	
	public Okno(Swiat swiat)
	{
		this.swiat = swiat;
		addKeyListener(this);
		setFocusable(true);
		
		//Glowne okno programu
		this.setTitle("Daniel Kulas, 168813");
		this.setPreferredSize(new Dimension(szerokosc, wysokosc));
		this.setMinimumSize(new Dimension(szerokosc, wysokosc));
		this.setMaximumSize(new Dimension(szerokosc, wysokosc));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		
		//Panel z komentarzem
		int margines = 20;
		panelKomentarz = new JTextPane();
		panelKomentarz.setEnabled(false);
		panelKomentarz.setLocation((int)(wysokosc * stosunek), margines/2);
		panelKomentarz.setSize(new Dimension(szerokosc - (int)(wysokosc * stosunek) - margines, (int)(wysokosc * stosunek) - margines));
		panelKomentarz.setLayout(new BoxLayout(panelKomentarz, BoxLayout.Y_AXIS));
		panelKomentarz.setBackground(Color.LIGHT_GRAY);
		panelKomentarz.setDisabledTextColor(new Color(0,0,0));
		panelKomentarz.setText("");
		
		
		//Panel dolny
		JPanel panelDolny = new JPanel();
		panelDolny.setLocation(0, (int)(wysokosc * stosunek));
		panelDolny.setSize(new Dimension(szerokosc, (int)(wysokosc * (1 - stosunek))));
		panelDolny.setLayout(new FlowLayout(FlowLayout.CENTER, (int)(wysokosc * 0.05), (int)(wysokosc * 0.05)));
		//panelDolny.setBackground(Color.LIGHT_GRAY);

		//Przyciski w panelu dolnym
		dolnePrzyciski = new JButton[] { new JButton("Zapisz gre"), new JButton("Wczytaj gre"), new JButton("Nastepna tura"), new JButton("Umiejetnosc wylaczona"), new JButton("Wyjscie") };
		
		for(int i = 0; i < dolnePrzyciski.length; i++)
		{
			dolnePrzyciski[i].setPreferredSize(new Dimension((int)((wysokosc * stosunek)/4.5) - 10, 40));
			dolnePrzyciski[i].setBackground(Color.WHITE);
			dolnePrzyciski[i].setFocusable(false);
			panelDolny.add(dolnePrzyciski[i]);
		}
		
		//Przycisk zapisz gre
		EventDolnePrzyciski eventDolnePrzyciski = new EventDolnePrzyciski(swiat);
		dolnePrzyciski[0].setActionCommand("ZapiszGre");
		//EventPrzyciskZapiszGre eventZapiszGre = new EventPrzyciskZapiszGre(swiat);
		dolnePrzyciski[0].addActionListener(eventDolnePrzyciski);
		
		//Przycisk wczytaj gre
		dolnePrzyciski[1].setActionCommand("WczytajGre");
		//EventPrzyciskWczytajGre eventWczytajGre = new EventPrzyciskWczytajGre(swiat);
		dolnePrzyciski[1].addActionListener(eventDolnePrzyciski);
		
		//Przycisk nastepna tura
		dolnePrzyciski[2].setActionCommand("WykonajTure");
		//EventPrzyciskNastTura eventNastTura = new EventPrzyciskNastTura(swiat);
		dolnePrzyciski[2].addActionListener(eventDolnePrzyciski);
		
		//Przycisk umiejetnosc specjalna
		dolnePrzyciski[3].setActionCommand("UmiejetnoscSpecjalna");
		//EventPrzyciskUmiejetnoscSpecjalna eventUmiejetnosc = new EventPrzyciskUmiejetnoscSpecjalna(swiat);
		dolnePrzyciski[3].setEnabled(false);
		dolnePrzyciski[3].addActionListener(eventDolnePrzyciski);
		
		//Przycisk wyjscia
		dolnePrzyciski[4].setActionCommand("Wyjscie");
		//EventPrzyciskWyjscie eventWyjscie = new EventPrzyciskWyjscie();
		dolnePrzyciski[4].addActionListener(eventDolnePrzyciski);	
		
		if(swiat.getRodzajRozgrywkiHex() == false)
			plansza = new PlanszaZwykla(this, swiat);
		else
			plansza = new PlanszaHex(this, swiat);
		
		add(panelKomentarz);
		add(panelDolny);
		add(plansza);
		pack();
		setVisible(true);
	}
	
	public int getSzerokosc()
	{
		return szerokosc;
	}
	
	public int getWysokosc()
	{
		return wysokosc;
	}
	
	public float getStosunek()
	{
		return stosunek;
	}
	
	public void rysuj()
	{
		((Plansza) plansza).rysuj();
		panelKomentarz.setText("");
		panelKomentarz.setText(swiat.getInfo());
		swiat.setInfo("");
	}

	public void wczytajPlansze()
	{
		this.remove(plansza);
		plansza = null;
		
		if(swiat.getRodzajRozgrywkiHex() == false)
			plansza = new PlanszaZwykla(this, swiat);
		else
			plansza = new PlanszaHex(this, swiat);
		
		this.add(plansza);
		pack();
	}
	
	@Override
	public void keyPressed(KeyEvent k) 
	{
		int cIndex = 1;
		for(int i = 0; i < swiat.organizm.size(); i++)
		{
			if(swiat.organizm.get(i) instanceof Czlowiek)
			{
				cIndex = i;
				break;
			}
		}
		
		swiat.organizm.get(cIndex).setInput(k.getKeyCode());	
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{

	}
	@Override
	public void keyTyped(KeyEvent e) 
	{
	}
}