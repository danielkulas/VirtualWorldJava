package main;
import organizmy.*;
import organizmy.rosliny.*;
import organizmy.zwierzeta.*;
import java.util.ArrayList;
import java.util.Random;
import okienka.Okno;
import okienka.OknoWczytywania;


public class Swiat
{
	private int rozmiarX;
	private int rozmiarY;
	private int runda;
	private String info;
	private boolean rodzajRozgrywkiHex; //0 - zwykla rozgrywka, 1 - rozgrywka Hex
	private Okno okno;
	public ArrayList<Organizm> organizm;
	
	
	public static void main(String[] args)
	{
		Swiat swiat = new Swiat();
	}
	
	public void setRozmiarX(int rozmiarX)
	{
		this.rozmiarX = rozmiarX;
	}
	
	public void setRozmiarY(int rozmiarY)
	{
		this.rozmiarY = rozmiarY;
	}
	
	public void setRunda(int runda)
	{
		this.runda = runda;
	}
	
	public void setInfo(String info)
	{
		this.info = info;
	}
	
	public void setRodzajRozgrywkiHex(boolean rodzajRozgrywkiHex)
	{
		this.rodzajRozgrywkiHex = rodzajRozgrywkiHex;
	}
	
	public int getRozmiarX()
	{
		return rozmiarX;
	}
	
	public int getRozmiarY()
	{
		return rozmiarY;
	}
	
	public int getRunda()
	{
		return runda;
	}
	
	public String getInfo()
	{
		return info;
	}
	
	public boolean getRodzajRozgrywkiHex()
	{
		return rodzajRozgrywkiHex;
	}
	
	public Swiat()
	{
		organizm = new ArrayList<Organizm>();
		setRunda(1);
		setRozmiarX(10);
		setRozmiarY(10);
		OknoWczytywania oknoWczytywania = new OknoWczytywania(this);
	}
	
	public void umiejetnoscWlacz()
	{
		okno.dolnePrzyciski[3].setText("Wlaczona tarcza");
		okno.dolnePrzyciski[3].setEnabled(false);
		
	}
	
	public void umiejetnoscWylacz()
	{
		okno.dolnePrzyciski[3].setText("Umiejetnosc wylaczona");
		okno.dolnePrzyciski[3].setEnabled(false);
	}
	
	public void umiejetnoscMozliwoscWlaczenia()
	{
		okno.dolnePrzyciski[3].setText("Umiejetnosc dostepna");
		okno.dolnePrzyciski[3].setEnabled(true);
	}
	
	public void inicjalizacja()
	{
		okno = new Okno(this);
		
		//Losowanie liczby organizmow
		final int liczbaRodzajowOrganizmow = 10;
		Random generator = new Random();
		int maxLiczbaOrganizmow = ((getRozmiarX() * getRozmiarY()) / 200) * liczbaRodzajowOrganizmow; 
		if (maxLiczbaOrganizmow <= 0)
		{
			maxLiczbaOrganizmow = 1;
		}
		int liczbaOrganizmow = generator.nextInt(maxLiczbaOrganizmow) + 1;
		if (liczbaOrganizmow <= 0 || liczbaOrganizmow >= getRozmiarX() * getRozmiarY())
		{
			liczbaOrganizmow = 1;
		}
		
		//Wstawianie organizmow
		organizm.add(new Czlowiek(this));
		
		for (int k = 0; k < liczbaRodzajowOrganizmow; k++) 
		{
			for (int i = 0; i < liczbaOrganizmow; i++)
			{
				Organizm tab[] = { new Wilk(this), new Owca(this), new Lis(this), new Zolw(this), new Antylopa(this),
						new Trawa(this), new Mlecz(this), new Guarana(this), new WilczeJagody(this), new BarszczSosnowskiego(this) };

				organizm.add(tab[k]);
				int k1 = organizm.size() - 1;
				for (int j = 0; j < k1; j++)
				{
					if (organizm.get(k1).getPozycjaX() == organizm.get(j).getPozycjaX() && organizm.get(k1).getPozycjaY() == organizm.get(j).getPozycjaY())
					{
						organizm.remove(organizm.size() - 1);
						break;
					}
				}
			}
		}
		sortujTablice();
		okno.rysuj();
	}
	
	public void rysuj()
	{
		okno.rysuj();
	}
	
	public void wczytajGre()
	{
		int rozmiar = organizm.size();
		for(int i = 0; i < rozmiar; i++)
		{
			organizm.remove(organizm.get(0));
		}
		okno.wczytajPlansze();
	}
	
	private void sortujTablice()
	{
		//Sortowanie wzgl. inicjatywy, oraz wieku
		int flaga = 1;
		Organizm swap;
		
		if (organizm.size() != 0)
		{
			while (flaga == 1)
			{
				flaga = 0;
				for (int i = 1; i < organizm.size(); i++)
				{
					if (organizm.get(i - 1).getInicjatywa() < organizm.get(i).getInicjatywa() || (organizm.get(i - 1).getInicjatywa() == organizm.get(i).getInicjatywa() && organizm.get(i - 1).getWiek() < organizm.get(i).getWiek()))
					{
						swap = organizm.get(i);
						organizm.set(i, organizm.get(i - 1));
						organizm.set(i - 1, swap);
						flaga = 1;
					}
				}
			}
		}
	}
	
	private void sprawdzKoniec()
	{
		int flaga = 0;
		for (int i = 0; i < organizm.size(); i++)
		{
			if (organizm.get(i) instanceof Czlowiek)
				flaga = 1;
		}

		if (flaga == 0)
			System.exit(2);
	}
	
	public void wykonajTure()
	{
		setRunda(getRunda() + 1);
		sortujTablice();
		
		for (int i = 0; i < organizm.size(); i++)
		{
			organizm.get(i).setWiek(organizm.get(i).getWiek() + 1);
			organizm.get(i).akcja();
		}

		for (int i = 0; i < organizm.size(); i++)
			organizm.get(i).kolizja();
			
		okno.rysuj();
		sprawdzKoniec();
	}
}