package organizmy.rosliny;
import organizmy.*;
import main.*;
import java.awt.Color;
import java.util.Random;


public class Mlecz extends Roslina
{
	public Mlecz(Swiat swiat)
	{
		this.swiat = swiat;
		Random generator = new Random();
		setPozycjaX(generator.nextInt(swiat.getRozmiarX()) + 1);
		setPozycjaY(generator.nextInt(swiat.getRozmiarY()) + 1);
		setSila(0);
		setInicjatywa(0);
		setWiek(1);
		nazwa = "Mlecz";
		skrot = "M";
		kolor = new Color(241, 255, 13);
	}

	@Override
	public void akcja()
	{
		for (int i = 0; i < 3; i++)
			super.akcja();
	}
	
	@Override
	public Organizm getObiekt() 
	{
		return new Mlecz(swiat);
	}
}