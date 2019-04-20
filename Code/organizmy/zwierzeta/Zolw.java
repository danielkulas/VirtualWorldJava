package organizmy.zwierzeta;
import java.awt.Color;
import java.util.Random;
import main.Swiat;
import organizmy.Organizm;


public class Zolw extends Zwierze
{
	public Zolw(Swiat swiat)
	{
		this.swiat = swiat;
		Random generator = new Random();
		setPozycjaX(generator.nextInt(swiat.getRozmiarX()) + 1);
		setPozycjaY(generator.nextInt(swiat.getRozmiarY()) + 1);
		setSila(2);
		setInicjatywa(1);
		setWiek(1);
		nazwa = "Zolw";
		skrot = "Z";
		kolor = new Color(101, 135, 78);
	}
	
	@Override
	public void akcja()
	{
		Random generator = new Random();
		int random = generator.nextInt(100) + 1;
		
		if (random <= 25)
			super.akcja();
	}
	
	@Override
	public boolean obrona(Organizm organizm)
	{
		if(organizm.getSila() < 5)
			return true;
		
		return false;
	}
	
	@Override
	public Organizm getObiekt() 
	{
		return new Zolw(swiat);
	}
}