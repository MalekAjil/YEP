package com.undp.aep.Model;

import java.util.ArrayList;

public class City {
    public int ID = 0;
    public String Name = "";

    public City(int ID, String name) {
        this.ID = ID;
        this.Name = name;
    }

    @Override
    public String toString() {
        return this.ID +
                " - " + this.Name;
    }
    
    public static ArrayList<City> getData() {
        ArrayList data = new ArrayList();
        data.add(new City(1, "حلب"));
        data.add(new City(2, "دمشق"));
        data.add(new City(3, "حمص"));
        data.add(new City(4, "حماة"));
        data.add(new City(5, "ادلب"));
        data.add(new City(6, "اللاذقية "));
        data.add(new City(6, "اللاذقية "));
        return data;
    }
}
