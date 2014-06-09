import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.Display;
import javax.microedition.location.*;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import com.sun.mmedia.protocol.LocatorParser;


public class ExampleLocationMIDlet extends MIDlet implements LocationListener{

	private TextBox locationDescriptor;
	private LocationProvider locationProvider; 
	
	
	public TextBox getLocationDescriptor() {
		return locationDescriptor;
	}

	public void setLocationDescriptor(TextBox locationDescriptor) {
		this.locationDescriptor = locationDescriptor;
	}

	public LocationProvider getLocationProvider() {
		return locationProvider;
	}

	public void setLocationProvider(LocationProvider locationProvider) {
		this.locationProvider = locationProvider;
	}

	/*
	 * Constructor del MIDlet, el cual se agrega como Listener del LocationProvider.
	 */
	public ExampleLocationMIDlet() throws LocationException{
		//This factory method is used to get an actual LocationProvider implementation based on the defined criteria. 
		setLocationProvider(LocationProvider.getInstance(new Criteria()));
		/*
		 * setLocationListener(listener, interval, timeout, maxAge)
		 * Adds a LocationListener for updates at the defined interval. The listener will be called with updated location at the defined interval. The listener also gets updates when the availablilty state of the LocationProvider changes.
		 *		Passing in -1 as the interval selects the default interval which is dependent on the used location method.
		 * http://www-users.cs.umn.edu/~czhou/docs/jsr179/lapi/javax/microedition/location/LocationProvider.html#getInstance(javax.microedition.location.Criteria)
		 */
		getLocationProvider().setLocationListener(this, 1, -1, -1);
	}
	
	 // Métodos a implementar de la interfaz LOCATION_LISTENER.
		
	/*
	 * Método invocado por LocationProvider cada vez que cambia el valor del GPS. 
	 * Es invocado por el LocationProvider al cual nos resgistramos como LISTENER.
	 */
	public void locationUpdated(LocationProvider locationProvider, Location location){
		if(!(location == null)){
			QualifiedCoordinates coordinates = location.getQualifiedCoordinates();
			String textCoordinate = "Latitud: " + coordinates.getLatitude() + " Longitud: " + coordinates.getLongitude();
			//Textbox(title,text,maxSizeTextBox,constraintsTextBox); constraintsTextBox dice si el TextBox a crear se va a limitar a recibir ciertos carácteres en particular, por ejemplo, caracteres numéricos. El "0" en este parámetro, indica que no se aplicará ninguna restriccion al texto ingresado.
			setLocationDescriptor(new TextBox("Location",textCoordinate, 400, 0));
			Display.getDisplay(this).setCurrent(getLocationDescriptor());
		}
	}
	
	public void providerStateChanged(LocationProvider arg0, int arg1){
		
	}
	//FIN LOCATION_LISTENER

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

}
