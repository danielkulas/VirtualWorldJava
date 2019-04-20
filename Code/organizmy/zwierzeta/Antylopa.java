package organizmy.zwierzeta;
import java.awt.Color;
import java.util.Random;
import main.Swiat;
import organizmy.Organizm;


public class Antylopa extends Zwierze
{
	public Antylopa(Swiat swiat)
	{
		this.swiat = swiat;
		Random generator = new Random();
		setPozycjaX(generator.nextInt(swiat.getRozmiarX()) + 1);
		setPozycjaY(generator.nextInt(swiat.getRozmiarY()) + 1);
		setSila(4);
		setInicjatywa(4);
		setWiek(1);
		nazwa = "Antylopa";
		skrot = "A";
		kolor = new Color(166, 91, 41);
	}
	
	@Override
	public void akcja()
	{
		for (int i = 0; i < 2; i++)
			super.akcja();
	}
	
	@Override
	public boolean obrona(Organizm organizm)
	{
		Random generator = new Random();
		int random = generator.nextInt(100) + 1;
		if (random <= 50)
			return true;

		return false;
	}
	
	@Override
	public Organizm getObiekt() 
	{
		return new Antylopa(swiat);
	}
}