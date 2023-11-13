package com.undp.aep.Model;

import java.util.ArrayList;

public class Disability {
    public int ID = 0;
    public String Name = "";

    public Disability(int ID, String name) {
        this.ID = ID;
        this.Name = name;
    }

    @Override
    public String toString() {
        return this.Name;
    }

    public static ArrayList<Disability> getData() {
        ArrayList data = new ArrayList();
        data.add(new City(1, "حركية"));
        data.add(new City(2, "سمعية"));
        data.add(new City(3, "بصرية"));
        data.add(new City(4, "أخرى"));
        return data;
    }
}
