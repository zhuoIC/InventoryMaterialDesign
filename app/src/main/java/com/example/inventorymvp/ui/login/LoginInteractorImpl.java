package com.example.inventorymvp.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImpl {

    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListener onLoginFinishedListener) {
        // Realiza todas las comprobaciones
        // Si el password es vacío
        if (onLoginFinishedListener.onPasswordEmptyError()){

        }
        else if (){

        }
        else if (){

        }
        else {
            onLoginFinishedListener.onSucess();
        }


        // Y es correcto
    }
}
