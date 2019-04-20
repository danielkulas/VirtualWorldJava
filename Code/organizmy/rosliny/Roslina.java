package organizmy.rosliny;
import java.util.Random;
import organizmy.Organizm;


public abstract class Roslina extends Organizm
{
	private final int prawdopodobienstwo = 5;
	
	@Override
	public void akcja()
	{
		Random generator = new Random();
		int rozmiar = swiat.organizm.size();
		int random = generator.nextInt(1000) + 1; 
		
		if (random <= prawdopodobienstwo)
		{	
			random = generator.nextInt(100) + 1; 
			swiat.organizm.add(this.getObiekt());
			int k = swiat.organizm.size() - 1;

			if(swiat.getRodzajRozgrywkiHex() == false)
			{
				if (random <= 25 && getPozycjaX() - 1 > 1)
				{
					swiat.organizm.get(k).setPozycjaX(getPozycjaX() - 1);
					swiat.organizm.get(k).setPozycjaY(getPozycjaY());
				}
				else if (random > 25 && random <= 50 && getPozycjaX() + 1 < swiat.getRozmiarX())
				{
					swiat.organizm.get(k).setPozycjaX(getPozycjaX() + 1);
					swiat.organizm.get(k).setPozycjaY(getPozycjaY());
				}
				else if (random > 50 && random <= 75 && getPozycjaY() - 1 > 1)
				{
					swiat.organizm.get(k).setPozycjaX(getPozycjaX());
					swiat.organizm.get(k).setPozycjaY(getPozycjaY() - 1);
				}
				else if (random > 75 && getPozycjaY() + 1 < swiat.getRozmiarY())
				{
					swiat.organizm.get(k).setPozycjaX(getPozycjaX());
					swiat.organizm.get(k).setPozycjaY(getPozycjaY() + 1);
				}
			}
			else
			{
				if (random <= 17 && getPozycjaY() - 1 > 1)
				{
					swiat.organizm.get(k).setPozycjaX(getPozycjaX() - 1);
					swiat.organizm.get(k).setPozycjaY(getPozycjaY());
				}
				else if (random > 83 && getPozycjaY() + 1 < swiat.getRozmiarY())
				{
					swiat.organizm.get(k).setPozycjaX(getPozycjaX());
					swiat.organizm.get(k).setPozycjaY(getPozycjaY() + 1);
				}
				else if(getPozycjaX() % 2 == 1)
				{
					if (random > 17 && random <= 33 && getPozycjaX() - 1 > 1 && getPozycjaY() - 1 > 1)
					{
						swiat.organizm.get(k).setPozycjaX(getPozycjaX() - 1);
						swiat.organizm.get(k).setPozycjaY(getPozycjaY() - 1);
					}
					else if (random > 33 && random <= 50 && getPozycjaX() + 1 < swiat.getRozmiarX() && getPozycjaY() - 1 > 1)
					{
						swiat.organizm.get(k).setPozycjaX(getPozycjaX() + 1);
						swiat.organizm.get(k).setPozycjaY(getPozycjaY() - 1);
					}
					else if(random > 50 && random <= 66 && getPozycjaX() - 1 > 1)
					{
						swiat.organizm.get(k).setPozycjaX(getPozycjaX() - 1);
						swiat.organizm.get(k).setPozycjaY(getPozycjaY());
					}
					else if(random > 66 && random <= 83 && getPozycjaX() + 1 < swiat.getRozmiarX())
					{
						swiat.organizm.get(k).setPozycjaX(getPozycjaX() + 1);
						swiat.organizm.get(k).setPozycjaY(getPozycjaY());
					}		
				}
				else
				{
					if (random > 17 && random <= 33 && getPozycjaX() - 1 > 1)
					{
						swiat.organizm.get(k).setPozycjaX(getPozycjaX() - 1);
						swiat.organizm.get(k).setPozycjaY(getPozycjaY());
					}
					else if (random > 33 && random <= 50 && getPozycjaX() + 1 < swiat.getRozmiarX())
					{
						swiat.organizm.get(k).setPozycjaX(getPozycjaX() + 1);
						swiat.organizm.get(k).setPozycjaY(getPozycjaY());
					}
					else if(random > 50 && random <= 66 && getPozycjaX() - 1 > 1 && getPozycjaY() + 1 < swiat.getRozmiarY())
					{
						swiat.organizm.get(k).setPozycjaX(getPozycjaX() - 1);
						swiat.organizm.get(k).setPozycjaY(getPozycjaY() + 1);
					}
					else if(random > 66 && random <= 83 && getPozycjaX() + 1 < swiat.getRozmiarX() && getPozycjaY() + 1 < swiat.getRozmiarY()) 
					{
						swiat.organizm.get(k).setPozycjaX(getPozycjaX() + 1);
						swiat.organizm.get(k).setPozycjaY(getPozycjaY() + 1);
					}
				}
			}

			for (int i = 0; i < k; i++)
			{
				if (swiat.organizm.get(i).getPozycjaX() == swiat.organizm.get(k).getPozycjaX() && swiat.organizm.get(i).getPozycjaY() == swiat.organizm.get(k).getPozycjaY())
				{
					swiat.organizm.remove(k);
					break;
				}
			}
		}
		
		if(rozmiar < swiat.organizm.size())
			swiat.setInfo(swiat.getInfo() + "Rozprzestrzenianie: " + swiat.organizm.get(swiat.organizm.size() - 1).getNazwa() + "\n");
	}
	
	@Override
	public void kolizja()
	{
	}
}