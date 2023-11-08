package ar.edu.unlam.album;

import java.util.*;

public class Final extends Usuario {
	
	private List<Figurita> stockDisponible;
	private Set<Figurita> figuritasPegadas;

	public Final(String usuario, String contrasena) {
		super(usuario, contrasena);
		this.stockDisponible = new ArrayList<Figurita>();
		this.figuritasPegadas = new TreeSet<Figurita>(); 
	}

	@Override
	public Boolean agregarFigurita(Figurita nueva) {
		
		return stockDisponible.add(nueva);
	}

	@Override
	public Boolean pegarFigurita(Figurita actual) throws FiguritaRepetida {
		Boolean sePudoPegar = false;
		
		Figurita buscada = buscarFiguritaEnAlbum(actual);
		if(buscada != null) {
			throw new FiguritaRepetida();
		}else {
			figuritasPegadas.add(actual);
			stockDisponible.remove(actual);
			sePudoPegar = true;
		}
		return sePudoPegar;
	}

	private Figurita buscarFiguritaEnAlbum(Figurita actual) {
		for (Figurita figurita : figuritasPegadas) {
			if(figurita.equals(actual)) {
				return figurita;
			}
		}
		return null;
	}

	@Override
	public Boolean cambiarFigurita(Figurita aCambiar, Figurita aRecibir) throws FiguritaNoDisponible {
		
		Boolean sePudoCambiar = false;
		Figurita buscada = buscarFiguritaEnStock(aCambiar);
		
		if(buscada == null) {
			throw new FiguritaNoDisponible();
		}else {
			stockDisponible.remove(aCambiar);
			stockDisponible.add(aRecibir);
			sePudoCambiar = true;
		}
		
		return sePudoCambiar;
	}

	private Figurita buscarFiguritaEnStock(Figurita aCambiar) {
		for (Figurita figurita : stockDisponible) {
			if(figurita.equals(aCambiar)) {
				return figurita;
			}
			
		}
		return null;
	}

}
