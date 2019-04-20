package zdarzenia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import main.Swiat;


public class EventPrzyciskPlansza implements ActionListener
{
	private Swiat swiat;
	private int x;
	private int y;
	
	public EventPrzyciskPlansza(Swiat swiat, int x, int y)
	{
		this.swiat = swiat;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		EventMenu eventMenu = new EventMenu(swiat, x, y);
		JButton pole = (JButton) e.getSource();
		JPopupMenu menu = new JPopupMenu("Menu");
		JMenuItem[] elementyMenu = new JMenuItem[] {new JMenuItem("Wilk"), new JMenuItem("Owca"), new JMenuItem("Lis"), new JMenuItem("Zolw"), new JMenuItem("Antylopa"),
				new JMenuItem("Trawa"), new JMenuItem("Mlecz"), new JMenuItem("Guarana"), new JMenuItem("Wilcze jagody"), new JMenuItem("Barszcz sosnowskiego")};
		
		for(int i = 0; i < elementyMenu.length; i++)
		{
			elementyMenu[i].addActionListener(eventMenu);
			elementyMenu[i].setActionCommand(new Integer(i).toString());
			menu.add(elementyMenu[i]);
		}
		
		pole.setComponentPopupMenu(menu);
		menu.show(pole, x, y);
	}
}