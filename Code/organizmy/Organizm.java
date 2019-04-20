package organizmy;
import java.awt.Color;
import main.Swiat;

public abstract class Organizm
{
	public int pozycjaX;
	public int pozycjaY;
	public int wiek;
	public int sila;
	public int inicjatywa;
	public Color kolor;
	public String nazwa;
	public String skrot;
	public Swiat swiat;

	
	public void setPozycjaX(int x)
	{
		this.pozycjaX = x;
	}
	
	public void setPozycjaY(int y)
	{
		this.pozycjaY = y;
	}
	
	public void setWiek(int wiek)
	{
		this.wiek = wiek;
	}
	
	public void setInicjatywa(int inicjatywa)
	{
		this.inicjatywa = inicjatywa;
	}
	
	public void setSila(int sila)
	{
		this.sila = sila;
	}
	
	public int getPozycjaX()
	{
		return pozycjaX;
	}
	
	public int getPozycjaY()
	{
		return pozycjaY;
	}
	
	public int getWiek()
	{
		return wiek;
	}
	
	public int getInicjatywa()
	{
		return inicjatywa;
	}
	
	public int getSila()
	{
		return sila;
	}
	
	public String getNazwa()
	{
		return nazwa;
	}
	
	public String getSkrot()
	{
		return skrot;
	}
	
	public Color getKolor()
	{
		return kolor;
	}
	
	public boolean obrona(Organizm organizm)
	{
		return false;
	}
	
	public void setInput(int Input) {}
	public void specjalnaUmiejetnosc() {}
	public abstract void akcja();
	public abstract void kolizja();
	public abstract Organizm getObiekt();
}