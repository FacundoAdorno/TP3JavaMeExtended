package modeloTP3;

import java.util.Vector;

public class User {

	private ContextFeature positionContext = new ContextFeature("position", null);
	private Vector contextFeatures = new Vector();
	

	public void setContextFeatures(Vector contextFeatures) {
		this.contextFeatures = contextFeatures;
	}

	public Object getPositionContextValue() {
		return positionContext.getValor();
	}

//	public void setPositionContextValue(Object positionContext) {
//		this.positionContext.setValor(positionContext);
//	}
	
	/*
	 * Se busca si existe un ContextFeature con el 'name' indicado. Si existe, entonces se modifica su valor.
	 */
	public void setContextFeature(String name, Object value){
		ContextFeature contextFeature = getContextFeature(name);
		if(contextFeature != null){
			//Encontramos la característica a modificar en la lista de ContextFeature's y finalizamos la búsqueda.
			contextFeature.setValor(value);
			return;
		}
		// El contextFeature a agregar no existía en la colección
		contextFeatures.addElement(new ContextFeature(name, value));
	}
	/*
	 * Se devuelve el ContextFeature que tenga el 'name' indicado.
	 */
	public ContextFeature getContextFeature(String name){
		ContextFeature contextFeature;
		for(int i = 0; i < contextFeatures.size(); i++){
			contextFeature = (ContextFeature)contextFeatures.elementAt(i);
			if(contextFeature.getNombre() == name){
				return contextFeature;
			}
		}
		return null;
	}

	
	
}
