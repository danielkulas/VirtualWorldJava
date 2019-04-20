package organizmy.rosliny;
import organizmy.*;
import main.*;
import java.awt.Color;
import java.util.Random;


public class Guarana extends Roslina
{
	public Guarana(Swiat swiat)
	{
		this.swiat = swiat;
		Random generator = new Random();
		setPozycjaX(generator.nextInt(swiat.getRozmiarX()) + 1);
		setPozycjaY(generator.nextInt(swiat.getRozmiarY()) + 1);
		setSila(0);
		setInicjatywa(0);
		setWiek(1);
		nazwa = "Guarana";
		skrot = "G";
		kolor = new Color(11, 231, 255);
	}

	@Override
	public void kolizja()
	{
		for (int i = 0; i < swiat.organizm.size(); i++)
		{
			if (getPozycjaX() == swiat.organizm.get(i).getPozycjaX() && getPozycjaY() == swiat.organizm.get(i).getPozycjaY() && swiat.organizm.get(i) != this)
			{
				swiat.setInfo(swiat.getInfo() + getNazwa() + " dodaje 3pkt sily dla: " + swiat.organizm.get(i).getNazwa() + "\n");
				swiat.organizm.get(i).setSila(swiat.organizm.get(i).getSila() + 3);
			}
		}
	}
	
	@Override
	public Organizm getObiekt() 
	{
		return new Guarana(swiat);
	}
}