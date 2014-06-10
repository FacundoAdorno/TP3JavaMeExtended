package modeloTP3;

import java.util.Vector;

import javax.microedition.location.Location;
import javax.microedition.location.LocationListener;
import javax.microedition.location.LocationProvider;

public class LocationListenerCollaborator implements LocationListener {

	private Vector observers = new Vector();
	
	public void locationUpdated(LocationProvider locationProvider, Location location) {
		for (int i = 0; i < observers.size(); i++) {
			 ((ObserverLocation) observers.elementAt(i)).notifyLocationUpdated(location);
		}
	}	

	public void providerStateChanged(LocationProvider arg0, int arg1) {
		// NADA para el ejemplo

	}
	
	public void addObserver(ObserverLocation observer){
		if(observer != null & !observers.contains(observer)){
			observers.addElement(observer);
		}
	}
	
	public void removeObserver(ObserverLocation observer){
		if(observer != null){
			observers.removeElement(observer);
		}
	}
}
