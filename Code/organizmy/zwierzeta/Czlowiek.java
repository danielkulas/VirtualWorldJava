package organizmy.zwierzeta;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;
import main.Swiat;
import organizmy.*;


public class Czlowiek extends Zwierze
{
	private boolean tarczaAlsura;
	private int licznikSU;
	private int input;
	
	
	public Czlowiek(Swiat swiat)
	{
		this.swiat = swiat;
		Random generator = new Random();
		setPozycjaX(generator.nextInt(swiat.getRozmiarX()) + 1);
		setPozycjaY(generator.nextInt(swiat.getRozmiarY()) + 1);
		setSila(5);
		setInicjatywa(4);
		setWiek(1);
		setLicznikSU(0);
		setTarczaAlsura(false);
		nazwa = "Czlowiek";
		skrot = "C";
		kolor = new Color(197, 169, 143);
	}

	@Override
	public void akcja()
	{
		if(swiat.getRodzajRozgrywkiHex() == false)
		{
			if (getInput() == KeyEvent.VK_LEFT && getPozycjaX() > 1)
				setPozycjaX(getPozycjaX() - 1);
			else if (getInput() == KeyEvent.VK_RIGHT && getPozycjaX() < swiat.getRozmiarX())
				setPozycjaX(getPozycjaX() + 1);
			else if (getInput() == KeyEvent.VK_UP && getPozycjaY() > 1)
				setPozycjaY(getPozycjaY() - 1);
			else if (getInput() == KeyEvent.VK_DOWN && getPozycjaY() < swiat.getRozmiarY())
				setPozycjaY(getPozycjaY() + 1);
		}
		else
		{
			if (getInput() == KeyEvent.VK_W && getPozycjaY() > 1)
				setPozycjaY(getPozycjaY() - 1);
			else if (getInput() == KeyEvent.VK_S && getPozycjaY() < swiat.getRozmiarY())
				setPozycjaY(getPozycjaY() + 1);
			else if(getPozycjaX() % 2 == 1)
			{
				if (getInput() == KeyEvent.VK_Q && getPozycjaX() > 1 && getPozycjaY() > 1)
				{
					setPozycjaX(getPozycjaX() - 1);
					setPozycjaY(getPozycjaY() - 1);
				}
				else if (getInput() == KeyEvent.VK_E && getPozycjaX() < swiat.getRozmiarX() && getPozycjaY() > 1)
				{
					setPozycjaX(getPozycjaX() + 1);
					setPozycjaY(getPozycjaY() - 1);
				}
				else if (getInput() == KeyEvent.VK_A && getPozycjaX() > 1)
					setPozycjaX(getPozycjaX() - 1);
				else if (getInput() == KeyEvent.VK_D && getPozycjaX() < swiat.getRozmiarX())
					setPozycjaX(getPozycjaX() + 1);
			}
			else
			{
				if (getInput() == KeyEvent.VK_Q && getPozycjaX() > 1)
					setPozycjaX(getPozycjaX() - 1);
				else if (getInput() == KeyEvent.VK_E && getPozycjaX() < swiat.getRozmiarX())
					setPozycjaX(getPozycjaX() + 1);
				else if (getInput() == KeyEvent.VK_A && getPozycjaX() > 1 && getPozycjaY() < swiat.getRozmiarY())
				{
					setPozycjaX(getPozycjaX() - 1);
					setPozycjaY(getPozycjaY() + 1);
				}
				else if (getInput() == KeyEvent.VK_D && getPozycjaX() < swiat.getRozmiarX() && getPozycjaY() < swiat.getRozmiarY()) 
				{
					setPozycjaX(getPozycjaX() + 1);
					setPozycjaY(getPozycjaY() + 1);
				}
			}
		}

		setInput(0);
		setLicznikSU(getLicznikSU() + 1);
		if (getLicznikSU() >= 5)
		{
			swiat.umiejetnoscMozliwoscWlaczenia();
		}
		if (getLicznikSU() == 0)
		{
			setTarczaAlsura(false);
			swiat.umiejetnoscWylacz();
		}
	}
	
	private void setLicznikSU(int licznik)
	{
		licznikSU = licznik;
	}
	
	public int getLicznikSU()
	{
		return licznikSU;
	}

	private void setTarczaAlsura(boolean tarcza)
	{
		tarczaAlsura = tarcza;
	}

	public boolean getTarczaAlsura()
	{
		return tarczaAlsura;
	}
	
	@Override
	public void setInput(int input)
	{
		this.input = input;
	}
	
	public int getInput()
	{
		return input;
	}
	
	public void specjalnaUmiejetnosc()
	{
		if(getLicznikSU() >= 5)
		{
			setLicznikSU(-5);
			setTarczaAlsura(true);
			swiat.umiejetnoscWlacz();
		}
	}

	@Override
	public boolean obrona(Organizm organizm)
	{
		return getTarczaAlsura();
	}
	
	@Override
	public Organizm getObiekt() 
	{
		return new Czlowiek(swiat);
	}
}