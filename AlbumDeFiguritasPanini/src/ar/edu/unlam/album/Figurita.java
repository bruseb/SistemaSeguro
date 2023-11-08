package ar.edu.unlam.album;

public class Figurita implements Comparable<Figurita>{

	private Integer codigo;
	private Character grupo;
	private String seleccion;
	private String nombre;
	private Double valor;

	public Figurita(Integer codigo, Character grupo, String seleccion, String nombre, Double valor) {
		super();
		this.codigo = codigo;
		this.grupo = grupo;
		this.seleccion = seleccion;
		this.nombre = nombre;
		this.valor = valor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Character getGrupo() {
		return grupo;
	}

	public void setGrupo(Character grupo) {
		this.grupo = grupo;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int compareTo(Figurita o) {
		int comparadorGrupo = this.getGrupo().compareTo(o.getGrupo()); 
		int comparadorSeleccion = this.getSeleccion().compareTo(o.getSeleccion()); 
		int comparadorCodigo = this.getCodigo().compareTo(o.getCodigo()); 
		
		if(comparadorGrupo != 0){
			return comparadorGrupo;	
		}
		if (comparadorSeleccion !=0) {
			return comparadorSeleccion;
		}
		return comparadorCodigo;
	}


	
	

}
