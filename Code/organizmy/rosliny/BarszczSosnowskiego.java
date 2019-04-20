package organizmy.rosliny;
import organizmy.*;
import organizmy.zwierzeta.Zwierze;
import main.*;
import java.awt.Color;
import java.util.Random;


public class BarszczSosnowskiego extends Roslina
{
	public BarszczSosnowskiego(Swiat swiat)
	{
		this.swiat = swiat;
		Random generator = new Random();
		setPozycjaX(generator.nextInt(swiat.getRozmiarX()) + 1);
		setPozycjaY(generator.nextInt(swiat.getRozmiarY()) + 1);
		setSila(10);
		setInicjatywa(0);
		setWiek(1);
		nazwa = "BarszczSosnowskiego";
		skrot = "B";
		kolor = new Color(255, 11, 17);
	}

	@Override
	public void akcja()
	{
		int flaga = 0;
		super.akcja();
		
		for (int i = 0; i < swiat.organizm.size(); i++)
		{
			//Sprawdzanie czy w poblizu barszczu sosnowskiego znajduje sie jakies zwierze
			if(swiat.getRodzajRozgrywkiHex() == false)
			{
				if (((swiat.organizm.get(i).getPozycjaX() == getPozycjaX() && swiat.organizm.get(i).getPozycjaY() == getPozycjaY() - 1) || (swiat.organizm.get(i).getPozycjaX() == getPozycjaX() && swiat.organizm.get(i).getPozycjaY() == getPozycjaY() + 1) || (swiat.organizm.get(i).getPozycjaX() == getPozycjaX() - 1 && swiat.organizm.get(i).getPozycjaY() == getPozycjaY()) || (swiat.organizm.get(i).getPozycjaX() == getPozycjaX() + 1 && swiat.organizm.get(i).getPozycjaY() == getPozycjaY())) && swiat.organizm.get(i) instanceof Zwierze)
					flaga = i;
			}
			else
			{
				if(((swiat.organizm.get(i).getPozycjaY() == getPozycjaY() - 1 && swiat.organizm.get(i).getPozycjaX() == getPozycjaX()) || (swiat.organizm.get(i).getPozycjaY() == getPozycjaY() + 1 && swiat.organizm.get(i).getPozycjaX() == getPozycjaX()) || (swiat.organizm.get(i).getPozycjaY() == getPozycjaY() && swiat.organizm.get(i).getPozycjaX() == getPozycjaX() - 1) || (swiat.organizm.get(i).getPozycjaY() == getPozycjaY() && swiat.organizm.get(i).getPozycjaX() == getPozycjaX() + 1) || 
						(getPozycjaX() % 2 == 1 && ((swiat.organizm.get(i).getPozycjaY() == getPozycjaY() - 1 && swiat.organizm.get(i).getPozycjaX() == getPozycjaX() - 1) || (swiat.organizm.get(i).getPozycjaY() == getPozycjaY() - 1 && swiat.organizm.get(i).getPozycjaX() == getPozycjaX() + 1)) || (getPozycjaX() % 2 == 0 && ((swiat.organizm.get(i).getPozycjaY() == getPozycjaY() + 1 && swiat.organizm.get(i).getPozycjaX() == getPozycjaX() - 1) || (swiat.organizm.get(i).getPozycjaY() == getPozycjaY() + 1 && swiat.organizm.get(i).getPozycjaX() == getPozycjaX() + 1))))) && swiat.organizm.get(i) instanceof Zwierze)
						flaga = i;
			}
		}
		if(flaga != 0)
		{
			swiat.setInfo(swiat.getInfo() + getNazwa() + " zabija: " + swiat.organizm.get(flaga).getNazwa() + "\n");
			swiat.organizm.remove(flaga);
		}
	}
	
	@Override
	public void kolizja()
	{
		for (int i = 0; i < swiat.organizm.size(); i++)
		{
			if (getPozycjaX() == swiat.organizm.get(i).getPozycjaX() && getPozycjaY() == swiat.organizm.get(i).getPozycjaY() && swiat.organizm.get(i) != this)
			{
				swiat.setInfo(swiat.getInfo() + getNazwa() + " zabija: " + swiat.organizm.get(i).getNazwa() + "\n");
				swiat.organizm.remove(i);
			}
		}
	}
	
	@Override
	public Organizm getObiekt() 
	{
		return new BarszczSosnowskiego(swiat);
	}
}