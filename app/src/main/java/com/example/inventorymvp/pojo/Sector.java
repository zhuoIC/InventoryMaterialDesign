package com.example.inventorymvp.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 30/10/17.
 */

public class Sector implements Parcelable{

    private int ID;
    private String name;
    private String sortname;
    private String description;
    private int dependencyID;
    private boolean enabled;
    private boolean _default;

    protected Sector(Parcel in) {
        ID = in.readInt();
        name = in.readString();
        sortname = in.readString();
        description = in.readString();
        dependencyID = in.readInt();
        enabled = in.readByte() != 0;
        _default = in.readByte() != 0;
    }

    public static final Creator<Sector> CREATOR = new Creator<Sector>() {
        @Override
        public Sector createFromParcel(Parcel in) {
            return new Sector(in);
        }

        @Override
        public Sector[] newArray(int size) {
            return new Sector[size];
        }
    };

    public boolean is_default() {
        return _default;
    }

    public void set_default(boolean _default) {
        this._default = _default;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDependencyID() {
        return dependencyID;
    }

    public void setDependencyID(int dependencyID) {
        this.dependencyID = dependencyID;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public Sector(int ID, String name, String sortname, String description, int dependencyID, boolean enabled, boolean _default) {
        this.ID = ID;
        this.name = name;
        this.sortname = sortname;
        this.description = description;
        this.dependencyID = dependencyID;
        this.enabled = enabled;
        this._default = _default;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", sortname='" + sortname + '\'' +
                ", description='" + description + '\'' +
                ", dependencyID=" + dependencyID +
                ", enabled=" + enabled +
                ", _default=" + _default +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ID);
        parcel.writeString(name);
        parcel.writeString(sortname);
        parcel.writeString(description);
        parcel.writeInt(dependencyID);
        parcel.writeByte((byte) (enabled ? 1 : 0));
        parcel.writeByte((byte) (_default ? 1 : 0));
    }
}
