package com.example.inventorymaterial;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void signIn_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        //1. El usuario introduce un usuario
        //2. El usuario introduce una contraseña
        //3. El usuario exista en la base de datos (Repository)
        //4. La contraseña sea correcta
    }

    @Test
    public void signUp_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        //1. El usuario introduce un usuario
        //2. El usuario introduce una contraseña
        //3. El usuario introduce un email
        //5. La contraseña tiene que tener al menos 6 caractéres
        //6. El usuario NO exista en la base de datos (Repository)
        //7. El email no existe en la base de datos (Repository)
        //8. Doble comprobación de la contraseña
    }
}