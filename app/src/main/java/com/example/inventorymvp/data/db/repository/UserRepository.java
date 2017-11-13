package com.example.inventorymvp.data.db.repository;

import com.example.inventorymvp.data.db.model.User;

import java.util.ArrayList;

/**
 * Created by usuario on 8/11/17.
 */

public class UserRepository {
    /* Declaración*/
    private ArrayList<User> users;
    private static UserRepository userRepository;

    /* Inicialización
    /* Inicializa todos los atributos de ámbito static o de clase */
    static {
        userRepository = new UserRepository();
    }

    /**
     * El constructor ha de ser privado para garantizar que hay una sola instancia de Repository
     */
    private UserRepository(){
        this.users = new ArrayList<>();
        initialize();
    }

    /* Métodos */
    public void initialize(){
        addUser(new User(1, "Nicolás", "Nico9", "Nicolás Hernández", "nicolimonar@gmail.com", true, true));
        addUser(new User(1, "Pepe", "pepe", "Pepe Paquito", "paquito@gmail.com", false, false));
        addUser(new User(1, "Sebástian", "sebastian", "Sebástian el Grande", "sebastian@gmail.com", false, false));
    }

    /* Patrón Singleton*/
    public static UserRepository getInstance(){
        if(userRepository == null)
            userRepository = new UserRepository();
        return userRepository;
    }


    /**
     * Método que añade un usuario
     * @param user
     */
    public void addUser(User user){
        users.add(user);
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    /**
     * Método que comprueba su el usuario ya existe en la base de datos
     * @return
     */
    public boolean userAlreadyExists( User user){
        return true;
    }

    public String getPassword(User user){ return user.getPassword();}

    public boolean validateCredentials(String user, String password) {
        int i = 0;
        boolean isCorrect = false;
        while (i < users.size()){
            if(users.get(i).getUser() == user || users.get(i).getEmail() == user){
                if(users.get(i).getPassword() == password){
                    isCorrect = true;
                }
                break;
            }
            i++;
        }
        return isCorrect;
    }
}
