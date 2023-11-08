package ar.edu.unlam.album;

import java.util.*;

public class Administrador extends Usuario {

	private Set<Figurita> baseDeDatos;
	
	public Administrador(String usuario, String contrasena) {
		super(usuario, contrasena);
		this.baseDeDatos = new TreeSet<Figurita>();

	}

	@Override
	public Boolean agregarFigurita(Figurita nueva) throws CodigoExistente {
		Boolean sePudoAgregar = false;
		Figurita buscada = buscarFigurita(nueva.getCodigo(), nueva.getSeleccion());
		if(buscada != null) {
			throw new CodigoExistente();
		}else {
			baseDeDatos.add(nueva);
			sePudoAgregar = true;
		}
		
		return sePudoAgregar;
		
		
	}

	private Figurita buscarFigurita(Integer codigo, String seleccion) {
		for (Figurita figurita : baseDeDatos) {
			if(figurita.getCodigo().equals(codigo) && figurita.getSeleccion().equals(seleccion)) {
				return figurita;
			}
			
		}
		return null;
	}

	@Override
	public Boolean pegarFigurita(Figurita actual) {
		
		return false;
	}

	@Override
	public Boolean cambiarFigurita(Figurita aCambiar, Figurita aRecibir) {
		// TODO Auto-generated method stub
		return false;
	}



}
