package modeloTP3;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.TextBox;
import javax.microedition.location.Criteria;
import javax.microedition.location.Location;
import javax.microedition.location.LocationException;
import javax.microedition.location.LocationProvider;
import javax.microedition.location.QualifiedCoordinates;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Application extends MIDlet  implements ObserverLocation{
	private LocationListenerCollaborator locationListenerCol = new LocationListenerCollaborator();
	private User user = new User();
	
	
	public LocationListenerCollaborator getLocationListenerCol() {
		return locationListenerCol;
	}
	public void setLocationListenerCol(
			LocationListenerCollaborator locationListenerCol) {
		this.locationListenerCol = locationListenerCol;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void notifyLocationUpdated(Location location) {
		// Aca va a estar el comportamiento que actualiza al contexto del usuario y a la pantalla
		if(!(location == null)){
			user.setContextFeature("position", location);
			
			QualifiedCoordinates coordinates = location.getQualifiedCoordinates();
			String textCoordinate = "Latitud: " + coordinates.getLatitude() + " Longitud: " + coordinates.getLongitude();
			//Textbox(title,text,maxSizeTextBox,constraintsTextBox); constraintsTextBox dice si el TextBox a crear se va a limitar a recibir ciertos carácteres en particular, por ejemplo, caracteres numéricos. El "0" en este parámetro, indica que no se aplicará ninguna restriccion al texto ingresado.
			setLocationDescriptor(new TextBox("Location",textCoordinate, 400, 0));
			Display.getDisplay(this).setCurrent(getLocationDescriptor());
		}
	}
	
	//////////////////////////// MIDLET  /////////////////////////////////////////////
	private TextBox locationDescriptor;
	private LocationProvider locationProvider;
	
	public Application() throws LocationException{
		setLocationProvider(LocationProvider.getInstance(new Criteria()));
		getLocationProvider().setLocationListener(getLocationListenerCol(), 1, -1, -1);
		getLocationListenerCol().addObserver(this);

	}
	
	public void setLocationDescriptor(TextBox locationDescriptor) {
		this.locationDescriptor = locationDescriptor;
	}
	public TextBox getLocationDescriptor() {
		return locationDescriptor;
	}
	public void setLocationProvider(LocationProvider locationProvider) {
		this.locationProvider = locationProvider;
	}
	public LocationProvider getLocationProvider() {
		return locationProvider;
	}
	
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
