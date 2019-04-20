package okienka;
import main.Swiat;
import zdarzenia.EventPrzyciskPlansza;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;


@SuppressWarnings("serial")
public class PlanszaZwykla extends Plansza
{	
	public PlanszaZwykla(JFrame okno, Swiat swiat)
	{
		this.swiat = swiat;
		this.okno = ((Okno) okno);
		setLocation(0, 0);
		setSize(new Dimension((int)(this.okno.getWysokosc() * this.okno.getStosunek()), (int)(this.okno.getWysokosc() * this.okno.getStosunek())));
		setBackground(Color.WHITE);
		setLayout(null);
		repaint(); 
		
		
		pole = new JButton[swiat.getRozmiarX() * swiat.getRozmiarY()];
		int rozmiarXKomorki = (int)((this.okno.getWysokosc() * this.okno.getStosunek())/swiat.getRozmiarX());
		int rozmiarYKomorki = (int)((this.okno.getWysokosc() * this.okno.getStosunek())/swiat.getRozmiarY());
		for(int i = 0; i < swiat.getRozmiarX() * swiat.getRozmiarY(); i++)
		{
			int x = (i % swiat.getRozmiarX()) + 1;
			int y = (int)(i / swiat.getRozmiarX()) + 1;
			pole[i] = new JButton("");
			pole[i].setLocation(((x - 1) * rozmiarXKomorki) + 1, ((y - 1) * rozmiarYKomorki) + 1);
			pole[i].setBackground(Color.WHITE);
			pole[i].setMargin(new Insets(0,0,0,0));
			pole[i].setSize(new Dimension(rozmiarXKomorki, rozmiarYKomorki));
			EventPrzyciskPlansza eventPlansza = new EventPrzyciskPlansza(swiat, x, y);
			pole[i].addActionListener(eventPlansza);
			pole[i].setFocusable(false);
			add(pole[i]);
		}
	}
}