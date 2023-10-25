package ar.edu.unlam.sistemaSeguro;

import java.util.Objects;

public abstract class Usuario implements Comparable<Object> {

	protected String usuario;
	protected String contrasena;
	protected Boolean logueado;
	protected Boolean bloqueado;

	public Usuario(String usuario, String contrasena) throws InvalidPassword {
		super();
		this.usuario = usuario;
		this.setContrasena(contrasena);
		this.logueado = false;
		this.bloqueado = false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(usuario, other.usuario);
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

	public abstract void setContrasena(String contrasena) throws InvalidPassword;

	@Override
	public int compareTo(Object o) {
		Usuario aComparar = (Usuario) o;
		return this.getUsuario().compareTo(aComparar.getUsuario());
	}

	public Boolean getLogueado() {
		return logueado;
	}

	public void setLogueado(Boolean logueado) {
		this.logueado = logueado;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
}
