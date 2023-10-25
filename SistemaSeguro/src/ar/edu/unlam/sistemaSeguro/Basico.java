package ar.edu.unlam.sistemaSeguro;

public class Basico extends Usuario implements Bloqueable, Eliminable {
	

	public Basico(String usuario, String contrasena) throws InvalidPassword {
		super(usuario, contrasena);
		
	}

	@Override
	public void setContrasena(String contrasena) throws InvalidPassword {
		Integer cantidadDeNumeros = 0, cantidadDeMinusculas = 0, cantidadDeMayusculas = 0;
		int caracterAnalizado = 0;
		char validarContrasena[] = contrasena.toCharArray();

		for (int i = 0; i < validarContrasena.length; i++) {
			caracterAnalizado = (int) validarContrasena[i];
			if (caracterAnalizado >= 48 && caracterAnalizado <= 57) {
				cantidadDeNumeros++;
			}
			if (caracterAnalizado >= 97 && caracterAnalizado <= 122) {
				cantidadDeMinusculas++;
			}
			if (caracterAnalizado >= 65 && caracterAnalizado <= 90) {
				cantidadDeMayusculas++;
			}
		}
		if (cantidadDeNumeros >= 1 && cantidadDeMinusculas >= 1 && cantidadDeMayusculas >= 1) {
			super.contrasena = contrasena;
		} else {
			throw new InvalidPassword();
		}
	}

	@Override
	public Boolean getBloqueado() {

		return bloqueado;
	}

	@Override
	public void setBloqueado(Boolean estado) {
		this.bloqueado = estado;

	}

}
