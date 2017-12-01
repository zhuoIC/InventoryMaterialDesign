package com.example.inventorymvp.repository;

import com.example.inventorymvp.pojo.Dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


/**
 * Created by usuario on 26/10/17.
 */

public class DependencyRepository {

    /* Declaración*/
    private ArrayList<Dependency> dependencies;
    private static DependencyRepository dependencyRepository;

    /* Inicialización
    /* Inicializa todos los atributos de ámbito static o de clase */
     static {
        dependencyRepository = new DependencyRepository();
    }

    /**
     * El constructor ha de ser privado para garantizar que hay una sola instancia de Repository
     */
    private DependencyRepository(){
        this.dependencies = new ArrayList<>();
        initialize();
    }

    /* Métodos */
    public void initialize(){
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior", "XXXX",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(3, "1º Ciclo Formativo Grado Superior", "1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(4, "2º Ciclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(5, "1º Ciclo Formativo Grado Superior", "1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(6, "2º Ciclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(7, "1º Ciclo Formativo Grado Superior", "1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(8, "2º Ciclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(9, "1º Ciclo Formativo Grado Superior", "1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(10, "2º Ciclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
    }

    /* Patrón Singleton*/
    public static DependencyRepository getInstance(){
        if(dependencyRepository == null)
            dependencyRepository = new DependencyRepository();
        return dependencyRepository;
    }


    /**
     * Método que añade una dependencia
     * @param dependency
     */
    public void addDependency(Dependency dependency){
        dependencies.add(dependency);
    }

    public ArrayList<Dependency> getDependencies(){
        /**
         * El ArrayList() se ordena según el/los criterio/s del método compareTo
         * de la interfaz Comparable
         */
        Collections.sort(dependencies);
        return dependencies;
    }

    public boolean validateCredentials(String name, String shortName, String description) {
        int i = 0;
        boolean isCorrect = false;
        while (i < dependencies.size()){
            if(dependencies.get(i).getName() == name || dependencies.get(i).getShortname() == shortName){
                if(dependencies.get(i).getDescription() == description){
                    isCorrect = true;
                }
                break;
            }
            i++;
        }
        return isCorrect;
    }

    public void editDependency(Dependency dependency) {
        int index = 0;

        while (index < dependencies.size()) {
            if (dependency.get_ID() == dependencies.get(index).get_ID()) {
                dependencies.get(index).setDescription(dependency.getDescription());
                index = dependencies.size();
            } else
                index++;
        }
    }

    public void saveDependency(Dependency d){
        for (Dependency dependency: dependencies) {
            if(dependency.getName().equals(d.getName())) {
                dependency.setDescription(d.getDescription());
            }
        }
    }

    /*public void deleteDependency(Dependency d){
        for (Dependency dependency: dependencies) {
            if(dependency.getName().equals(d.getName())) {
                dependency.remove(d.getDescription());
            }
        }
    }*/

    public void deleteDependency(Dependency d){
        Iterator<Dependency> iterator = dependencies.iterator();
        Dependency dependency;
        while (iterator.hasNext()){
            dependency = iterator.next();
            if(dependency.get_ID() == (d.get_ID())){
                iterator.remove();
            }
        }
    }
}
