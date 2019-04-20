package zdarzenia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import main.Swiat;
import organizmy.rosliny.*;
import organizmy.zwierzeta.*;


public class EventDolnePrzyciski implements ActionListener
{
	private Swiat swiat;
	
	public EventDolnePrzyciski(Swiat swiat)
	{
		this.swiat = swiat;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String akcja = e.getActionCommand();
		if(akcja == "WykonajTure")
		{
			swiat.wykonajTure();
		}
		else if(akcja == "Wyjscie")
		{
			System.exit(0);
		}
		else if(akcja == "UmiejetnoscSpecjalna")
		{
			int cIndex = 1;
			for(int i = 0; i < swiat.organizm.size(); i++)
			{
				if(swiat.organizm.get(i) instanceof Czlowiek)
				{
					cIndex = i;
					break;
				}
			}
			
			swiat.organizm.get(cIndex).specjalnaUmiejetnosc();
		}
		else if(akcja == "ZapiszGre")
		{
			PrintWriter save = null;
			try 
			{
				if(swiat.getRodzajRozgrywkiHex() == false)
					save = new PrintWriter("save.txt", "UTF-8");
				else
					save = new PrintWriter("saveHex.txt", "UTF-8");
				
				save.println(swiat.getRozmiarX());
				save.println(swiat.getRozmiarY());
				save.println(swiat.getRunda());
				save.println(swiat.organizm.size());
				
				for (int i = 0; i < swiat.organizm.size(); i++)
				{
					save.println(swiat.organizm.get(i).getNazwa());
					save.println(swiat.organizm.get(i).getPozycjaX());
					save.println(swiat.organizm.get(i).getPozycjaY());
					save.println(swiat.organizm.get(i).getInicjatywa());
					save.println(swiat.organizm.get(i).getWiek());
					save.println(swiat.organizm.get(i).getSila());
				}
				save.close();
			}
			catch (FileNotFoundException | UnsupportedEncodingException e1) 
			{
				//e1.printStackTrace();
			}
		}
		else if(akcja == "WczytajGre")
		{
			String slowo = null;
			int rozmiar = 0;
			Scanner save = null;
			try 
			{
				if(swiat.getRodzajRozgrywkiHex() == false)
					save = new Scanner(new File("save.txt"));
				else
					save = new Scanner(new File("saveHex.txt"));
			
				slowo = save.next();
				swiat.setRozmiarX(Integer.parseInt(slowo));
				slowo = save.next();
				swiat.setRozmiarY(Integer.parseInt(slowo));
				slowo = save.next();
				swiat.setRunda(Integer.parseInt(slowo));
				slowo = save.next();
				rozmiar = Integer.parseInt(slowo);
				
				swiat.wczytajGre();
				//Wczytywanie swiat.organizmow
				for (int i = 0; i < rozmiar; i++)
				{
					slowo = save.next();
					if (slowo.equals("Czlowiek"))
						swiat.organizm.add(new Czlowiek(swiat));
					else if (slowo.equals("Wilk"))
						swiat.organizm.add(new Wilk(swiat));
					else if (slowo.equals("Owca"))
						swiat.organizm.add(new Owca(swiat));
					else if (slowo.equals("Lis"))
						swiat.organizm.add(new Lis(swiat));
					else if (slowo.equals("Zolw"))
						swiat.organizm.add(new Zolw(swiat));
					else if (slowo.equals("Antylopa"))
						swiat.organizm.add(new Antylopa(swiat));
					else if (slowo.equals("Trawa"))
						swiat.organizm.add(new Trawa(swiat));
					else if (slowo.equals("Mlecz"))
						swiat.organizm.add(new Mlecz(swiat));
					else if (slowo.equals("Guarana"))
						swiat.organizm.add(new Guarana(swiat));
					else if (slowo.equals("WilczeJagody"))
						swiat.organizm.add(new WilczeJagody(swiat));
					else if (slowo.equals("BarszczSosnowskiego"))
						swiat.organizm.add(new BarszczSosnowskiego(swiat));

					slowo = save.next();
					swiat.organizm.get(i).setPozycjaX(Integer.parseInt(slowo));
					slowo = save.next();
					swiat.organizm.get(i).setPozycjaY(Integer.parseInt(slowo));
					slowo = save.next();
					swiat.organizm.get(i).setInicjatywa(Integer.parseInt(slowo));
					slowo = save.next();
					swiat.organizm.get(i).setWiek(Integer.parseInt(slowo));
					slowo = save.next();
					swiat.organizm.get(i).setSila(Integer.parseInt(slowo));
				}
				save.close();
				
				swiat.rysuj();
			}
			catch (FileNotFoundException e1) 
			{
				//e1.printStackTrace();
			}
		}
	}
}