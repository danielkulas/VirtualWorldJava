package organizmy.zwierzeta;
import java.awt.Color;
import java.util.Random;
import main.Swiat;
import organizmy.Organizm;


public class Lis extends Zwierze
{
	public Lis(Swiat swiat)
	{
		this.swiat = swiat;
		Random generator = new Random();
		setPozycjaX(generator.nextInt(swiat.getRozmiarX()) + 1);
		setPozycjaY(generator.nextInt(swiat.getRozmiarY()) + 1);
		setSila(3);
		setInicjatywa(7);
		setWiek(1);
		nazwa = "Lis";
		skrot = "L";
		kolor = new Color(238, 135, 22);
	}
	
	@Override
	public void akcja()
	{
		int pozX = getPozycjaX();
		int pozY = getPozycjaY();
		super.akcja();
		
		for(int i = 0; i < swiat.organizm.size(); i++)
		{
			if (getPozycjaX() == swiat.organizm.get(i).getPozycjaX() && getPozycjaY() == swiat.organizm.get(i).getPozycjaY() && getSila() < swiat.organizm.get(i).getSila() && swiat.organizm.get(i) != this)
			{
				setPozycjaX(pozX);
				setPozycjaY(pozY);
				break;
			}
		}
	}
	
	@Override
	public Organizm getObiekt() 
	{
		return new Lis(swiat);
	}
}