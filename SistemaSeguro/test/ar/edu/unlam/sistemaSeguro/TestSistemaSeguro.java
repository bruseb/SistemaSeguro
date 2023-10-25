package ar.edu.unlam.sistemaSeguro;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSistemaSeguro {

	@Test
	public void queSePuedarCrearUnUsuarioBasico() throws InvalidPassword {
		//preparacion
		String usuario = "bmerlo";
		String contrasena = "Bmerlo1";
		
		//ejecucion
		Usuario nuevo = new Basico(usuario, contrasena);
		//validacion
		assertNotNull(nuevo);
	}
	
	@Test(expected = InvalidPassword.class)
	public void queSiSeCreaUnUsuarioBasicoConUnaContrasenaInvalidaLanceUnaExcepcion() throws InvalidPassword {
		//preparacion
		String usuario = "bmerlo";
		String contrasena = "12456";
		
		//ejecucion
		Usuario nuevo = new Basico(usuario, contrasena);
		//validacion
		assertNotNull(nuevo);
	}
	
	@Test(expected = InvalidPassword.class)
	public void queSiSeCreaUnUsuarioAdministradorConUnaContrasenaInvalidaLanceUnaExcepcion() throws InvalidPassword {
		//preparacion
		String usuario = "sagostena";
		String contrasena = "Sagostena1";
		
		//ejecucion
		Usuario nuevo = new Administrador(usuario, contrasena);
		//validacion
		assertNotNull(nuevo);
	}
	
	@Test
	public void queSePuedarCrearUnUsuarioAdministrador() throws InvalidPassword {
		//preparacion
		String usuario = "sagostena";
		String contrasena = "Sagostena.1";
		
		//ejecucion
		Usuario nuevo = new Administrador(usuario, contrasena);
		//validacion
		assertNotNull(nuevo);
	}
	
	@Test
	public void queSePuedaAgregarUnUsuarioBasicoAlSistema() throws InvalidPassword {
		//preparacion
		String usuario = "bmerlo", contrasena = "Bmerlo1";
		Usuario nuevo = new Basico(usuario, contrasena);
		Integer cantidadDeUsuariosEsperada = 1;
		//ejecucion
		Sistema actual = new Sistema("unlam");
		actual.agregarUsuario(nuevo);
		
		
		//validacion
		assertEquals(cantidadDeUsuariosEsperada, actual.getCantidadDeUsuarios());
	}
	
	@Test
	public void queSePuedaAgregar3UsuariosBasicosAlSistema() throws InvalidPassword {
		//preparacion
		String usuario1 = "bmerlo", contrasena1 = "Bmerlo1";
		String usuario2 = "sagostena", contrasena2 = "Bmerlo1";
		String usuario3 = "talegre", contrasena3 = "Bmerlo1";
		Usuario nuevo1 = new Basico(usuario1, contrasena1);
		Usuario nuevo2 = new Basico(usuario2, contrasena2);
		Usuario nuevo3 = new Basico(usuario3, contrasena3);
		Integer cantidadDeUsuariosEsperada = 3;
		//ejecucion
		Sistema actual = new Sistema("unlam");
		actual.agregarUsuario(nuevo1);
		actual.agregarUsuario(nuevo2);
		actual.agregarUsuario(nuevo3);
		
		
		//validacion
		assertEquals(cantidadDeUsuariosEsperada, actual.getCantidadDeUsuarios());
	}
	
	@Test
	public void queNoSePuedanAgregar2UsuarioConElMismoNombreBasicoAlSistema() throws InvalidPassword {
		//preparacion
		String usuario = "bmerlo", contrasena = "Bmerlo1";
		Usuario nuevo1 = new Basico(usuario, contrasena);
		Usuario nuevo2 = new Basico(usuario, "Agostena1");
		Integer cantidadDeUsuariosEsperada = 1;
		//ejecucion
		Sistema actual = new Sistema("unlam");
		actual.agregarUsuario(nuevo1);
		actual.agregarUsuario(nuevo2);
		
		
		//validacion
		assertEquals(cantidadDeUsuariosEsperada, actual.getCantidadDeUsuarios());
	}
	
	@Test
	public void queSePuedaLoguearUnUsuarioBasicoAlSistema() throws InvalidPassword, UserNotFound {
		//preparacion
		String usuario = "bmerlo", contrasena = "Bmerlo1";
		Usuario nuevo = new Basico(usuario, contrasena);
		Sistema actual = new Sistema("unlam");
		actual.agregarUsuario(nuevo);
		//ejecucion
		Boolean logueoExitoso = actual.loguear(usuario, contrasena);
		
		
		//validacion
		assertTrue(logueoExitoso);
	}
	
	@Test
	public void queSiSeIngreasaLaContrasenaIncorrecta3VecesElUsuarioSeBloquee() throws InvalidPassword, UserNotFound {
		//preparacion
		String usuario = "bmerlo", contrasena = "Bmerlo1";
		Usuario nuevo = new Basico(usuario, contrasena);
		Sistema actual = new Sistema("unlam");
		actual.agregarUsuario(nuevo);
		
		//ejecucion
		actual.loguear(usuario, "Agostena1");
		actual.loguear(usuario, "Agostena1");
		actual.loguear(usuario, "Agostena1");
		actual.loguear(usuario, "Agostena1");
		
		
		//validacion
		assertTrue(nuevo.getBloqueado());
	}

}
