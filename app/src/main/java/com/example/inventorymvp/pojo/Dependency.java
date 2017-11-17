package com.example.inventorymvp.pojo;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by usuario on 25/10/17.
 */

public class Dependency implements Comparable{
    private int _ID;
    private String name;
    private String shortname;
    private String description;



    public Dependency(int _ID, String name, String shortname, String description) {
        this._ID = _ID;
        this.name = name;
        this.shortname = shortname;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String shortname) {
        this.name = shortname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }


    @Override
    public String toString() {
        return shortname;
    }

    @Override
    public int compareTo(@NonNull Object o){
        return name.toUpperCase().compareTo(((Dependency) o).getName().toUpperCase());
    }

    public static class DependencyOrderByShortName implements Comparator<Dependency>{

        @Override
        public int compare(Dependency d1, Dependency d2) {
            return d1.getShortname().toUpperCase().compareTo(d2.getShortname().toUpperCase());
        }
    }
}
