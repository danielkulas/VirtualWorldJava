package zdarzenia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.Swiat;
import organizmy.Organizm;
import organizmy.rosliny.*;
import organizmy.zwierzeta.*;


public class EventMenu implements ActionListener
{
	private Swiat swiat;
	private int x;
	private int y;
	
	public EventMenu(Swiat swiat, int x, int y)
	{
		this.swiat = swiat;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Organizm[] dostepneOrganizmy = new Organizm[] { new Wilk(swiat), new Owca(swiat), new Lis(swiat), new Zolw(swiat), new Antylopa(swiat),
				new Trawa(swiat), new Mlecz(swiat), new Guarana(swiat), new WilczeJagody(swiat), new BarszczSosnowskiego(swiat) };
		int index = Integer.parseInt(e.getActionCommand());
		swiat.organizm.add(dostepneOrganizmy[index].getObiekt());
		swiat.organizm.get(swiat.organizm.size() - 1).setPozycjaX(x);
		swiat.organizm.get(swiat.organizm.size() - 1).setPozycjaY(y);
		swiat.rysuj();
	}
}