package organizmy.zwierzeta;
import java.util.Random;
import organizmy.Organizm;
import organizmy.rosliny.Roslina;


public abstract class Zwierze extends Organizm
{
	@Override
	public void akcja()
	{
		int poprzXPozycja = getPozycjaX();
		int poprzYPozycja = getPozycjaY();
		Random generator = new Random();
		
		if(swiat.getRodzajRozgrywkiHex() == false)
		{
			do {
				int random = generator.nextInt(100) + 1;
	
				if (random <= 25 && getPozycjaX() > 1)
				{
					setPozycjaX(getPozycjaX() - 1);
					break;
				}
				else if (random > 25 && random <= 50 && getPozycjaX() < swiat.getRozmiarX())
				{
					setPozycjaX(getPozycjaX() + 1);
					break;
				}
				else if (random > 50 && random <= 75 && getPozycjaY() > 1)
				{
					setPozycjaY(getPozycjaY() - 1);
					break;
				}
				else if (random > 75 && getPozycjaY() < swiat.getRozmiarY())
				{
					setPozycjaY(getPozycjaY() + 1);
					break;
				}
			} while (true);
		}
		else
		{
			do {
				int random = generator.nextInt(100) + 1;
	
				if (random <= 17 && getPozycjaY() > 1)
				{
					setPozycjaY(getPozycjaY() - 1);
					break;
				}
				else if (random > 83 && getPozycjaY() < swiat.getRozmiarY())
				{
					setPozycjaY(getPozycjaY() + 1);
					break;
				}
				else if(getPozycjaX() % 2 == 1)
				{
					if (random > 17 && random <= 33 && getPozycjaX() > 1 && getPozycjaY() > 1)
					{
						setPozycjaX(getPozycjaX() - 1);
						setPozycjaY(getPozycjaY() - 1);
						break;
					}
					else if (random > 33 && random <= 50 && getPozycjaX() < swiat.getRozmiarX() && getPozycjaY() > 1)
					{
						setPozycjaX(getPozycjaX() + 1);
						setPozycjaY(getPozycjaY() - 1);
						break;
					}
					else if(random > 50 && random <= 66 && getPozycjaX() > 1)
					{
						setPozycjaX(getPozycjaX() - 1);
						break;
					}
					else if(random > 66 && random <= 83 && getPozycjaX() < swiat.getRozmiarX())
					{
						setPozycjaX(getPozycjaX() + 1);
						break;
					}
				}
				else
				{
					if (random > 17 && random <= 33 && getPozycjaX() > 1)
					{
						setPozycjaX(getPozycjaX() - 1);
						break;
					}
					else if (random > 33 && random <= 50 && getPozycjaX() < swiat.getRozmiarX())
					{
						setPozycjaX(getPozycjaX() + 1);
						break;
					}
					else if(random > 50 && random <= 66 && getPozycjaX() > 1 && getPozycjaY() < swiat.getRozmiarY())
					{
						setPozycjaX(getPozycjaX() - 1);
						setPozycjaY(getPozycjaY() + 1);
						break;
					}
					else if(random > 66 && random <= 83 && getPozycjaX() < swiat.getRozmiarX() && getPozycjaY() < swiat.getRozmiarY()) 
					{
						setPozycjaX(getPozycjaX() + 1);
						setPozycjaY(getPozycjaY() + 1);
						break;
					}
				}
			} while (true);
		}
		
		if(getPozycjaX() < 1 || getPozycjaX() > swiat.getRozmiarX() || getPozycjaY() < 1 || getPozycjaY() > swiat.getRozmiarY())
		{
			setPozycjaX(poprzXPozycja);
			setPozycjaY(poprzYPozycja);
		}
	}
	
	@Override
	public void kolizja()
	{
		int j; //Identyfikator elementu w tablicy, ktory wchodzi w kolizje: j(ten), i(przeciwny)
		for (j = 0; j < swiat.organizm.size(); j++)
		{
			if (swiat.organizm.get(j) == this)
				break;
		}
		Organizm organ = swiat.organizm.get(j);

		for (int i = 0; i < swiat.organizm.size(); i++)
		{
			if (getPozycjaX() == swiat.organizm.get(i).getPozycjaX() && getPozycjaY() == swiat.organizm.get(i).getPozycjaY() && swiat.organizm.get(i) != this)
			{
				//Rozmnazanie
				if(swiat.organizm.get(j).getNazwa() == swiat.organizm.get(i).getNazwa())
				{
					swiat.organizm.add(this.getObiekt());
					int rozmiar = swiat.organizm.size();
					przeniesDoPustego(swiat.organizm.get(j));
					swiat.organizm.get(rozmiar - 1).setPozycjaX(getPozycjaX());
					swiat.organizm.get(rozmiar - 1).setPozycjaY(getPozycjaY());
					przeniesDoPustego(swiat.organizm.get(rozmiar - 1));
					if (swiat.organizm.get(rozmiar - 1).getPozycjaX() == getPozycjaX() && swiat.organizm.get(rozmiar - 1).getPozycjaY() == getPozycjaY())
						swiat.organizm.remove(rozmiar - 1);
					else
						swiat.setInfo(swiat.getInfo() + "Rozmnazanie: " + getNazwa() + "\n");
					break;
				}

				//Kolizja
				if(swiat.organizm.get(i) instanceof Roslina)
					swiat.organizm.get(i).kolizja();

				if (organ != swiat.organizm.get(j))
					break;

				if (swiat.organizm.get(i).obrona(this) == true)
				{
					swiat.setInfo(swiat.getInfo() + "Obrona ataku przez: " + swiat.organizm.get(i).getNazwa() + "\n");
					przeniesDoPustego(swiat.organizm.get(j));
					break;
				}
				else if (getSila() > swiat.organizm.get(i).getSila())
				{
					swiat.setInfo(swiat.getInfo() + swiat.organizm.get(j).getNazwa() + " zjada " + swiat.organizm.get(i).getNazwa() + "\n");
					swiat.organizm.remove(i);
				}
				else if (getSila() == swiat.organizm.get(i).getSila())
				{
					if (j < i)
					{
						swiat.setInfo(swiat.getInfo() + swiat.organizm.get(j).getNazwa() + " zjada " + swiat.organizm.get(i).getNazwa() + "\n");
						swiat.organizm.remove(i);
					}
					else
					{
						swiat.setInfo(swiat.getInfo() + swiat.organizm.get(i).getNazwa() + " zjada " + swiat.organizm.get(j).getNazwa() + "\n");
						swiat.organizm.remove(j);
					}
				}
				else if (getSila() < swiat.organizm.get(i).getSila())
				{
					swiat.setInfo(swiat.getInfo() + swiat.organizm.get(i).getNazwa() + " zjada " + swiat.organizm.get(j).getNazwa() + "\n");
					swiat.organizm.remove(j);
				}
			}
		}
	}
	
	public void przeniesDoPustego(Organizm organ)
	{
		int flaga = 0;
		int rozmiar = swiat.getRozmiarX();
		int rozmiarTablicy = swiat.organizm.size();
		if (swiat.getRozmiarY() < swiat.getRozmiarX())
			rozmiar = swiat.getRozmiarY();

		for (int i = 1; i < rozmiar; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if (j == 0)
				{
					if (organ.getPozycjaX() - i > 1)
					{
						organ.setPozycjaX(organ.getPozycjaX() - i);
						organ.setPozycjaY(organ.getPozycjaY());
					}
				}
				else if (j == 1)
				{
					if (organ.getPozycjaX() + i < swiat.getRozmiarX())
					{
						organ.setPozycjaX(organ.getPozycjaX() + i);
						organ.setPozycjaY(organ.getPozycjaY());
					}
				}
				else if (j == 2)
				{
					if (organ.getPozycjaY() - i > 1)
					{
						organ.setPozycjaX(organ.getPozycjaX());
						organ.setPozycjaY(organ.getPozycjaY() - i);
					}
				}
				else if (j == 3)
				{
					if (organ.getPozycjaY() + i < swiat.getRozmiarY())
					{
						organ.setPozycjaX(organ.getPozycjaX());
						organ.setPozycjaY(organ.getPozycjaY() + i);
					}
				}

				flaga = 0;
				for (int k = 0; k < rozmiarTablicy; k++)
				{
					if (organ.getPozycjaX() == swiat.organizm.get(k).getPozycjaX() && organ.getPozycjaY() == swiat.organizm.get(k).getPozycjaY() && organ != swiat.organizm.get(k))
					{
						flaga = 1;
					}
				}

				if (flaga == 0)
				{
					i = 64;
					j = 64;
					break;
				}
			}
		}
	}
}