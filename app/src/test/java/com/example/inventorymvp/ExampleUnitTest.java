package com.example.inventorymvp;

import com.example.inventorymvp.pojo.User;
import com.example.inventorymvp.repository.UserRepository;
import com.example.inventorymvp.ui.utils.CommonUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private ArrayList<User> users;

    @Mock
    private UserRepository userRepository;

    @Before
    public void initialize() {
        userRepository =  mock(UserRepository.class);
        users = new ArrayList<>();
        users.add(new User(1, "Nicolás", "Nico00", "Nicolás Hernández", "nicolimonar@gmail.com", true, true));
        users.add(new User(1, "Manolo", "manolo", "Manolito", "manolitoGafotas@gmail.com", false, false));
        users.add(new User(1, "Sebástian", "sebastian", "Sebástian el Grande", "sebastian@gmail.com", false, false));
    }

    //1. El usuario introduce un usuario (Instrumentales)
    //2. El usuario introduce una contraseña (Instrumentales)

    //3. El usuario exista en la base de datos (Repository)
    // Para realizar esta prueba se tiene que comparar dos objetos de tipo User
    @Test
    public void userAlreadyExists_isCorrect() {
        UserRepository userRepository = mock(UserRepository.class);
        // Cuando se llame al método userAlreadyExists, devuelva un valor predeterminado.
        when(userRepository.userAlreadyExists(users.get(0))).thenReturn(true);
        assertTrue(userRepository.userAlreadyExists(users.get(0)));
    }

    @Test
    public void getUsers_isCorrect(){
        when(userRepository.getUsers()).thenReturn(users);
        assertEquals(users.get(0), userRepository.getUsers().get(0));
    }

    //4. La contraseña sea correcta (Repository)
    @Test
    public void password_isCorrect() {
        // Cuando se llame al método userAlreadyExists, devuelva un valor predeterminado.
        when(userRepository.getPassword(users.get(0))).thenReturn(users.get(0).getPassword());
        assertEquals(users.get(0).getPassword(), userRepository.getPassword(users.get(0)));
    }

    @Test
    public void signUp_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        //1. El usuario introduce un usuario (Instrumental)
        //2. El usuario introduce una contraseña (Instrumental)
        //3. El usuario introduce un email (Instrumental)
        //5. La contraseña tiene que tener al menos 6 caractéres (Instrumental
        //6. El usuario NO exista en la base de datos (Repository)
        //7. El email no existe en la base de datos (Repository)
        //8. Doble comprobación de la contraseña (Instrumental)
    }

    /**
     * Ejemplo de prueba donde vemos el conjunto de pruebas que podemos realizar
     */
    @Test
    public void testAssertions(){
        User user1 = new User(1, "Nicolás", "nicolas", "Nicolás Hernández", "nicolimonar@gmail.com", true, true);
        User user2 = null;
        User user3 = user1;

        // Comparar si dos objetos son iguales
        assertEquals(user1, users.get(0));

        // Un objeto es nulo
        assertNull(user2);

        // Un objeto no es nulo
        assertNotNull(user1);

        // Dos objetos apuntan a la misma referencia
        assertSame(user1, user3);
    }

    @Test
    public void passwordWellFormed(){
        //Solo numeros
        assertFalse(CommonUtils.isPasswordValid("000000"));

        //Sin numeros
        assertFalse(CommonUtils.isPasswordValid("aaAAAA"));

        //Solo letras minúsculas
        assertFalse(CommonUtils.isPasswordValid("aaaaaa"));

        //Sin letras minúsculas
        assertFalse(CommonUtils.isPasswordValid("AA0000"));

        //Solo letras mayúsculas
        assertFalse(CommonUtils.isPasswordValid("AAAAAA"));

        //Sin letras mayúsculas
        assertFalse(CommonUtils.isPasswordValid("00aaaa"));

        //Password corta
        assertFalse(CommonUtils.isPasswordValid("a0Aa0"));

        //Password con carácteres especiales
        assertFalse(CommonUtils.isPasswordValid("a0Aa0*"));

        //Password con espacios
        assertFalse(CommonUtils.isPasswordValid("a0A   "));

        //Password correcta con una sola minúscula
        assertTrue(CommonUtils.isPasswordValid("aAA000"));

        //Password correcta con una sola mayúscula
        assertTrue(CommonUtils.isPasswordValid("aaA000"));

        //Password correcta con un solo número
        assertTrue(CommonUtils.isPasswordValid("aAAAA0"));
    }
}