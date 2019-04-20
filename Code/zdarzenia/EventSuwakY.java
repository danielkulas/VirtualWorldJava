package zdarzenia;
import okienka.OknoWczytywania;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class EventSuwakY implements ChangeListener
{
	private OknoWczytywania oknoWczytywania;
	
	public EventSuwakY(OknoWczytywania oknoWczytywania)
	{
		this.oknoWczytywania = oknoWczytywania;
	}
	
	public void stateChanged(ChangeEvent e)
	{
		int wartosc = oknoWczytywania.suwakY.getValue();
		oknoWczytywania.infoRozmiarY.setText("Rozmiar planszy Y: " + wartosc);
	}
}