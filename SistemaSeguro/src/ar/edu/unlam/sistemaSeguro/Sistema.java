package ar.edu.unlam.sistemaSeguro;

import java.util.*;

public class Sistema {
	private String nombre;
	private Set<Usuario> usuarios;
	private Integer cantidadDeIntentosFallidos;

	public Sistema(String nombre) {
		this.nombre = nombre;
		this.usuarios = new TreeSet<Usuario>();
		this.cantidadDeIntentosFallidos = 0;
	}

	public void agregarUsuario(Usuario nuevo) {
		usuarios.add(nuevo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Integer getCantidadDeUsuarios() {

		return usuarios.size();
	}

	public Boolean loguear(String usuario, String contrasena) throws UserNotFound {
		Usuario buscado = buscarUsuario(usuario);
		if (buscado != null) {
			for (Usuario usuario2 : usuarios) {
				if (usuario2.getContrasena().equals(contrasena)) {
					usuario2.setLogueado(true);
					return true;
				}else {
					cantidadDeIntentosFallidos++;
					if(cantidadDeIntentosFallidos > 3) {
					usuario2.setBloqueado(true);
					}
				}
			}
		} else {
			throw new UserNotFound();
		}
		return false;
	}

	private Usuario buscarUsuario(String usuario) {
		for (Usuario usuario3 : usuarios) {
			if (usuario3.getUsuario().equals(usuario)) {
				return usuario3;
			}
		}
		return null;
	}

}
