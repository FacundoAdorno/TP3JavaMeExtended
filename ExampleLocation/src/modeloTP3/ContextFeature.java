package modeloTP3;

public class ContextFeature {

	private String nombre;
	private Object valor;
	
	public ContextFeature(String nombre, Object valor){
		setNombre(nombre);
		setValor(valor);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Object getValor() {
		return valor;
	}
	public void setValor(Object valor) {
		this.valor = valor;
	}
}
