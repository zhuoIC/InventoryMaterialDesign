package com.example.inventorymaterial.pojo;

/**
 * Created by usuario on 25/10/17.
 */

public class Dependency {
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
}
