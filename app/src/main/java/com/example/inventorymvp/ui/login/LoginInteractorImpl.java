package com.example.inventorymvp.ui.login;

import android.text.TextUtils;

import com.example.inventorymvp.repository.UserRepository;
import com.example.inventorymvp.ui.utils.CommonUtils;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImpl implements LoginInteractor{

    @Override
    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListener onLoginFinishedListener) {
        // Realiza todas las comprobaciones
        // Si el password es vacío
        if (TextUtils.isEmpty(user)){
            onLoginFinishedListener.onUserEmptyError();
        }
        else if (TextUtils.isEmpty(password)){
            onLoginFinishedListener.onPasswordEmptyError();
        }
        else if (!CommonUtils.isPasswordValid(password)){
            onLoginFinishedListener.onPasswordError();
        }
        else if (UserRepository.getInstance().validateCredentials(user, password)){
            onLoginFinishedListener.onSucess();
        }


        // Y es correcto
    }
}
