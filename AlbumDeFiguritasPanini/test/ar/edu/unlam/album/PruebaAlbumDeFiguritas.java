package ar.edu.unlam.album;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PruebaAlbumDeFiguritas {

	
	/*queSePuedaCrearUnaFigurita	5%
	queSePuedaCrearUnAdministrador	5%
	queSePuedaCrearUnUsuarioFinal	5%
	queUnAdministradorPuedaAgregarUnaFigurita	5%
	queUnUsuarioFinalPuedaAgregarUnaFigurita	5%
	queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas	5%
	queUnAdministradorNoPuedaAgregarUnaFiguritaExistente	5%
	queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes	5%
	queUnUsuarioFinalPuedaPegarUnaFigurita	20%
	queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida	10%
	queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales	20%
	queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga	5%
	queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado	5%*/
	
	@Test
	public void queSePuedaCrearUnaFigurita() {
		//preparacion
		Integer codigo = 23;
		Character grupo = 'C';
		String seleccion = "Argentina", nombre = "Emilian Martinez";
		Double valor = 10000.0;
		
		//ejecucion
		
		Figurita nueva = new Figurita(codigo, grupo, seleccion, nombre, valor);
		
		//validacion
		
		assertNotNull(nueva);
		
	}
	
	@Test
	public void queSePuedaCrearUnAdministrador() {
		//preparacion
		
		String usuario = "usuario1", contrasena = "contrasena1";
		
		
		//ejecucion
		
		Usuario nuevo1 = new Administrador(usuario,contrasena);
		
		//validacion
		
		assertNotNull(nuevo1);
		
	}
	
	@Test
	public void queSePuedaCrearUnUsuarioFinal() {
		//preparacion
		
		String usuario = "usuario2", contrasena = "contrasena2";
		
		
		//ejecucion
		
		Usuario nuevo2 = new Final(usuario,contrasena);
		
		//validacion
		
		assertNotNull(nuevo2);
		
	}
	
	@Test
	public void queUnAdministradorPuedaAgregarUnaFigurita() throws CodigoExistente {
		//preparacion
		Integer codigo = 10;
		Character grupo = 'C';
		String seleccion = "Argentina", nombre = "Lionel Messi";
		Double valor = 10000.0;
		String usuario = "usuario1", contrasena = "contrasena1";
		
		Usuario actual = new Administrador(usuario,contrasena);
		Figurita nueva = new Figurita(codigo, grupo, seleccion, nombre, valor);
		
		
		//ejecucion
		Boolean agregadoExitoso = actual.agregarFigurita(nueva);
		
		
		//validacion
		
		assertTrue(agregadoExitoso);
		
	}
	
	@Test
	public void queUnUsuarioFinalPuedaAgregarUnaFigurita() throws CodigoExistente {
		//preparacion
		Integer codigo = 10;
		Character grupo = 'C';
		String seleccion = "Argentina", nombre = "Lionel Messi";
		Double valor = 10000.0;
		String usuario = "usuario1", contrasena = "contrasena1";
		
		Usuario actual = new Final(usuario,contrasena);
		Figurita nueva = new Figurita(codigo, grupo, seleccion, nombre, valor);
		
		
		//ejecucion
		Boolean agregadoExitoso = actual.agregarFigurita(nueva);
		
		
		//validacion
		
		assertTrue(agregadoExitoso);
		
	}
	
	@Test
	public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() throws CodigoExistente {
		//preparacion
		Integer codigo1 = 10, codigo2 = 5, codigo3 = 10, codigo4 = 9;
		Character grupo1 = 'C', grupo2 = 'G', grupo3 = 'G', grupo4 = 'C';
		String seleccion1 = "Argentina", nombre1 = "Lionel Messi",seleccion2 = "Alemania", nombre2 = "Mats Hummels", seleccion3 = "Brasil", nombre3 = "Neymar Junior", seleccion4 = "Polonia", nombre4 = "Robert Lewandowski";
		Double valor1 = 10000.0; 
		
		String usuario = "usuario1", contrasena = "contrasena1";
		
		Usuario actual = new Administrador(usuario,contrasena);
		Figurita nueva2 = new Figurita(codigo2, grupo2, seleccion2, nombre2, valor1);
		Figurita nueva1 = new Figurita(codigo1, grupo1, seleccion1, nombre1, valor1);
		Figurita nueva3 = new Figurita(codigo3, grupo3, seleccion3, nombre3, valor1);
		Figurita nueva4 = new Figurita(codigo4, grupo4, seleccion4, nombre4, valor1);
		
		
		//ejecucion
		Boolean registroExitoso1 = actual.agregarFigurita(nueva2);
		Boolean registroExitoso2 = actual.agregarFigurita(nueva1);
		Boolean registroExitoso3 = actual.agregarFigurita(nueva3);
		Boolean registroExitoso4 = actual.agregarFigurita(nueva4);
	
	//validacion
		assertTrue(registroExitoso1);
		assertTrue(registroExitoso2);
		assertTrue(registroExitoso3);
		assertTrue(registroExitoso4);
	
		
	}
	
	@Test (expected = CodigoExistente.class)
	public void queUnAdministradorNoPuedaAgregarUnaFiguritaExistente() throws CodigoExistente {
		//preparacion
		Integer codigo1 = 10;
		Character grupo1 = 'C';
		String seleccion1 = "Argentina", nombre1 = "Lionel Messi";
		Double valor1 = 10000.0; 
		
		String usuario = "usuario1", contrasena = "contrasena1";
		
		Usuario actual = new Administrador(usuario,contrasena);
		Figurita nueva1 = new Figurita(codigo1, grupo1, seleccion1, nombre1, valor1);
		Figurita nueva2 = new Figurita(codigo1, grupo1, seleccion1, nombre1, valor1);
		
		
		
		//ejecucion
		actual.agregarFigurita(nueva1);
		Boolean registroFallido = actual.agregarFigurita(nueva2);
		
	
	//validacion
		assertFalse(registroFallido);
				
	}
	
	@Test
	public void queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() throws CodigoExistente {
		//preparacion
		Integer codigo1 = 10;
		Character grupo1 = 'C';
		String seleccion1 = "Argentina", nombre1 = "Lionel Messi";
		Double valor1 = 10000.0; 
		
		String usuario = "usuario1", contrasena = "contrasena1";
		
		Usuario actual = new Final(usuario,contrasena);
		Figurita nueva1 = new Figurita(codigo1, grupo1, seleccion1, nombre1, valor1);
		Figurita nueva2 = new Figurita(codigo1, grupo1, seleccion1, nombre1, valor1);
		
		
		
		//ejecucion
		actual.agregarFigurita(nueva1);
		Boolean registroExitoso = actual.agregarFigurita(nueva2);
		
	
	//validacion
		assertTrue(registroExitoso);
				
	}
	
	@Test
	public void queUnUsuarioFinalPuedaPegarUnaFigurita() throws FiguritaRepetida, CodigoExistente {
		//preparacion
		Integer codigo1 = 10;
		Character grupo1 = 'C';
		String seleccion1 = "Argentina", nombre1 = "Lionel Messi";
		Double valor1 = 10000.0; 
		
		String usuario = "usuario1", contrasena = "contrasena1";
		
		Usuario actual = new Final(usuario,contrasena);
		Figurita nueva1 = new Figurita(codigo1, grupo1, seleccion1, nombre1, valor1);
		
		
		
		
		//ejecucion
		actual.agregarFigurita(nueva1);
		
		Boolean pegadoExitoso = actual.pegarFigurita(nueva1);
		
	
	//validacion
		assertTrue(pegadoExitoso);
				
	}
	
	@Test (expected = FiguritaRepetida.class)
	public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws FiguritaRepetida, CodigoExistente {
		//preparacion
		Integer codigo1 = 10;
		Character grupo1 = 'C';
		String seleccion1 = "Argentina", nombre1 = "Lionel Messi";
		Double valor1 = 10000.0; 
		
		String usuario = "usuario1", contrasena = "contrasena1";
		
		Usuario actual = new Final(usuario,contrasena);
		Figurita nueva1 = new Figurita(codigo1, grupo1, seleccion1, nombre1, valor1);
		Figurita nueva2 = new Figurita(codigo1, grupo1, seleccion1, nombre1, valor1);
		
		
		
		
		//ejecucion
		actual.agregarFigurita(nueva1);
		actual.agregarFigurita(nueva2);
		actual.pegarFigurita(nueva1);
		Boolean pegadoFallido = actual.pegarFigurita(nueva1);
		
	
	//validacion
		assertFalse(pegadoFallido);
				
	}
	
	@Test 
	public void queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() throws FiguritaRepetida, CodigoExistente, FiguritaNoDisponible {
		//preparacion
		Integer codigo1 = 10, codigo2 = 5;
		Character grupo1 = 'C', grupo2 = 'G';
		String seleccion1 = "Argentina", nombre1 = "Lionel Messi", seleccion2 = "Alemania", nombre2 = "Mats Hummels";
		Double valor1 = 10000.0;
		
		String usuario1 = "usuario1", contrasena1 = "contrasena1";
		String usuario2 = "usuario2", contrasena2 = "contrasena2";
		
		Usuario actual1 = new Final(usuario1,contrasena1);
		Usuario actual2 = new Final(usuario2,contrasena2);
		
		Figurita nueva1 = new Figurita(codigo1, grupo1, seleccion1, nombre1, valor1);
		Figurita nueva2 = new Figurita(codigo2, grupo2, seleccion2, nombre2, valor1);
		
		
		
		
		//ejecucion
		actual1.agregarFigurita(nueva1);
		actual2.agregarFigurita(nueva2);
		Boolean cambioExitoso = actual1.cambiarFigurita(nueva1, nueva2);
		
		
	
	//validacion
		assertTrue(cambioExitoso);
				
	}
	
	@Test (expected = FiguritaNoDisponible.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga() throws FiguritaRepetida, CodigoExistente, FiguritaNoDisponible {
		//preparacion
		Integer codigo1 = 10, codigo2 = 5, codigo3 = 10;
		Character grupo1 = 'C', grupo2 = 'G', grupo3 = 'G';
		String seleccion1 = "Argentina", nombre1 = "Lionel Messi",seleccion2 = "Alemania", nombre2 = "Mats Hummels", seleccion3 = "Brasil", nombre3 = "Neymar Junior";
		Double valor1 = 10000.0; 
		
		String usuario1 = "usuario1", contrasena1 = "contrasena1";
		String usuario2 = "usuario2", contrasena2 = "contrasena2";
		
		Usuario actual1 = new Final(usuario1,contrasena1);
		Usuario actual2 = new Final(usuario2,contrasena2);
		
		Figurita nueva1 = new Figurita(codigo1, grupo1, seleccion1, nombre1, valor1);
		Figurita nueva2 = new Figurita(codigo2, grupo2, seleccion2, nombre2, valor1);
		Figurita nueva3 = new Figurita(codigo3, grupo3, seleccion3, nombre3, valor1);
		
		
		
		
		//ejecucion
		actual1.agregarFigurita(nueva1);
		actual2.agregarFigurita(nueva2);
		Boolean cambioFallido = actual1.cambiarFigurita(nueva3, nueva2);
		
		
	
	//validacion
		assertFalse(cambioFallido);
	
	
	}
	
	@Test (expected = FiguritaNoDisponible.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado() throws FiguritaRepetida, CodigoExistente, FiguritaNoDisponible {
		//preparacion
		Integer codigo1 = 10, codigo2 = 5;
		Character grupo1 = 'C', grupo2 = 'G';
		String seleccion1 = "Argentina", nombre1 = "Lionel Messi",seleccion2 = "Alemania", nombre2 = "Mats Hummels";
		Double valor1 = 10000.0; 
		
		String usuario1 = "usuario1", contrasena1 = "contrasena1";
		String usuario2 = "usuario2", contrasena2 = "contrasena2";
		
		Usuario actual1 = new Final(usuario1,contrasena1);
		Usuario actual2 = new Final(usuario2,contrasena2);
		
		Figurita nueva1 = new Figurita(codigo1, grupo1, seleccion1, nombre1, valor1);
		Figurita nueva2 = new Figurita(codigo2, grupo2, seleccion2, nombre2, valor1);
		
		
		
		
		
		//ejecucion
		actual1.agregarFigurita(nueva1);
		actual1.pegarFigurita(nueva1);
		actual2.agregarFigurita(nueva2);
		Boolean cambioFallido = actual1.cambiarFigurita(nueva1, nueva2);
		
		
	
	//validacion
		assertFalse(cambioFallido);
	
	
	}
}
