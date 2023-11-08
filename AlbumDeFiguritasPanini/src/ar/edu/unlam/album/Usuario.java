package ar.edu.unlam.album;

public abstract class Usuario {

	private String usuario;
	private String contrasena;

	public Usuario(String usuario, String contrasena) {
		super();
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public abstract Boolean agregarFigurita(Figurita nueva) throws CodigoExistente;

	public abstract Boolean pegarFigurita(Figurita actual) throws FiguritaRepetida;

	public abstract Boolean cambiarFigurita(Figurita aCambiar, Figurita aRecibir) throws FiguritaNoDisponible; 

}
