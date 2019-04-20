package organizmy.rosliny;
import organizmy.*;
import main.*;
import java.awt.Color;
import java.util.Random;


public class Trawa extends Roslina
{
	public Trawa(Swiat swiat)
	{
		this.swiat = swiat;
		Random generator = new Random();
		setPozycjaX(generator.nextInt(swiat.getRozmiarX()) + 1);
		setPozycjaY(generator.nextInt(swiat.getRozmiarY()) + 1);
		setSila(0);
		setInicjatywa(0);
		setWiek(1);
		nazwa = "Trawa";
		skrot = "T";
		kolor = new Color(19, 255, 13);
	}

	@Override
	public Organizm getObiekt() 
	{
		return new Trawa(swiat);
	}
}