package zdarzenia;
import okienka.OknoWczytywania;
import main.Swiat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventPrzyciskOK implements ActionListener
{
	private OknoWczytywania oknoWczytywania;
	private Swiat swiat;
	
	public EventPrzyciskOK(OknoWczytywania oknoWczytywania, Swiat swiat)
	{
		this.swiat = swiat;
		this.oknoWczytywania = oknoWczytywania;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(oknoWczytywania.wyborZwykla.isSelected())
			swiat.setRodzajRozgrywkiHex(false);
		else
			swiat.setRodzajRozgrywkiHex(true);

		swiat.setRozmiarX(oknoWczytywania.suwakX.getValue());
		swiat.setRozmiarY(oknoWczytywania.suwakY.getValue());
		oknoWczytywania.setVisible(false);
		swiat.inicjalizacja();
	}
}