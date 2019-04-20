package organizmy.rosliny;
import organizmy.*;
import main.*;
import java.awt.Color;
import java.util.Random;


public class WilczeJagody extends Roslina
{
	public WilczeJagody(Swiat swiat)
	{
		this.swiat = swiat;
		Random generator = new Random();
		setPozycjaX(generator.nextInt(swiat.getRozmiarX()) + 1);
		setPozycjaY(generator.nextInt(swiat.getRozmiarY()) + 1);
		setSila(99);
		setInicjatywa(0);
		setWiek(1);
		nazwa = "WilczeJagody";
		skrot = "J";
		kolor = new Color(99, 50, 228);
	}

	@Override
	public void kolizja()
	{
		for (int i = 0; i < swiat.organizm.size(); i++)
		{
			if (getPozycjaX() == swiat.organizm.get(i).getPozycjaX() && getPozycjaY() == swiat.organizm.get(i).getPozycjaY() && swiat.organizm.get(i) != this)
			{
				swiat.setInfo(swiat.getInfo() + getNazwa() + " zabijaja: " + swiat.organizm.get(i).getNazwa() + "\n");
				swiat.organizm.remove(i);
			}
		}
	}
	
	@Override
	public Organizm getObiekt() 
	{
		return new WilczeJagody(swiat);
	}
}