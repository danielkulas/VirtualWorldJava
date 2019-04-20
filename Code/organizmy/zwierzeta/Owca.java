package organizmy.zwierzeta;
import java.awt.Color;
import java.util.Random;
import main.Swiat;
import organizmy.Organizm;


public class Owca extends Zwierze
{
	public Owca(Swiat swiat)
	{
		this.swiat = swiat;
		Random generator = new Random();
		setPozycjaX(generator.nextInt(swiat.getRozmiarX()) + 1);
		setPozycjaY(generator.nextInt(swiat.getRozmiarY()) + 1);
		setSila(4);
		setInicjatywa(4);
		setWiek(1);
		nazwa = "Owca";
		skrot = "O";
		kolor = new Color(206, 196, 185);
	}
	
	@Override
	public Organizm getObiekt() 
	{
		return new Owca(swiat);
	}
}