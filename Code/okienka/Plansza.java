package okienka;
import main.Swiat;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;


@SuppressWarnings("serial")
public abstract class Plansza extends JPanel
{
	public Okno okno;
	public Swiat swiat;
	public JButton[] pole;
	
	
	public void rysuj()
	{
		for(int i = 0; i < pole.length; i++)
		{
			pole[i].setBackground(Color.WHITE);
			pole[i].setText("");
			pole[i].setEnabled(true);
		}
		
		for(int i = 0; i < swiat.organizm.size(); i++)
		{
			int j = ((swiat.organizm.get(i).pozycjaY - 1) * swiat.getRozmiarX()) + (swiat.organizm.get(i).pozycjaX - 1);
			pole[j].setBackground(swiat.organizm.get(i).getKolor());
			pole[j].setText(swiat.organizm.get(i).getSkrot());
			pole[j].setEnabled(false);
		}
	}
}