package zdarzenia;
import okienka.OknoWczytywania;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class EventSuwakX implements ChangeListener
{
	private OknoWczytywania oknoWczytywania;
	
	public EventSuwakX(OknoWczytywania oknoWczytywania)
	{
		this.oknoWczytywania = oknoWczytywania;
	}
	
	public void stateChanged(ChangeEvent e)
	{
		int wartosc = oknoWczytywania.suwakX.getValue();
		oknoWczytywania.infoRozmiarX.setText("Rozmiar planszy X: " + wartosc);
	}
}