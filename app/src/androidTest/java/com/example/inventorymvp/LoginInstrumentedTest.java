package com.example.inventorymvp;

import android.support.annotation.StringRes;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 * 1. El usuario introduce un usuario/email
 * 2. El usuario introduce una contraseña
 * 3. La contraseña tiene al menos 6 carácteres
 * 4. Doble comprobación de la contraseña.
 */
@RunWith(AndroidJUnit4.class)
public class LoginInstrumentedTest {
    /**
     * Caso que comprueba que el campo usuer está vacío
     */
    @Test
    public void isUserEmpty(){
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnakBarDisplayByMessage(R.string.errorUserEmpty);
    }

    /**
     * Caso que comprueba que el campo email está vacío
     */
    @Test
    public void isEmailEmpty(){
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnakBarDisplayByMessage(R.string.errorUserEmpty);
    }
    /**
     * Caso que comprueba que el campo password está vacío
     */
    @Test
    public void isPasswordEmpty(){
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnakBarDisplayByMessage(R.string.errorUserEmpty);
    }

    /**
     * Caso que comprueba que la longitud de la contraseña sea correcta
     */
    @Test
    public void passwordLenght_isCorrect(){
        onView(withId(R.id.edtUser)).perform(typeText("Nicolas"), closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText("nico"), closeSoftKeyboard());
        onView(withId(R.id.btnSignIn)).perform(click());
        checkSnakBarDisplayByMessage(R.string.errorPasswordLenght);
    }


    /**
     * Caso que comprueba que las dos contraseñas introducidas son iguales
     */
    @Test
    public void passwordDoubleCheck() {

    }

    public void checkSnakBarDisplayByMessage (@StringRes int message){
        onView(withText(message)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
}
