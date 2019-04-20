package organizmy.zwierzeta;
import java.awt.Color;
import java.util.Random;
import main.Swiat;
import organizmy.Organizm;


public class Wilk extends Zwierze
{
	public Wilk(Swiat swiat)
	{
		this.swiat = swiat;
		Random generator = new Random();
		setPozycjaX(generator.nextInt(swiat.getRozmiarX()) + 1);
		setPozycjaY(generator.nextInt(swiat.getRozmiarY()) + 1);
		setSila(9);
		setInicjatywa(5);
		setWiek(1);
		nazwa = "Wilk";
		skrot = "W";
		kolor = new Color(92, 64, 54);
	}
	
	@Override
	public Organizm getObiekt() 
	{
		return new Wilk(swiat);
	}
}