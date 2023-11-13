package com.undp.aep.Model;

import java.util.ArrayList;

public class Certificate {
    public int ID = 0;
    public String Name = "";

    public Certificate(int ID, String name) {
        this.ID = ID;
        this.Name = name;
    }

    @Override
    public String toString() {
        return this.Name;
    }

    public static ArrayList<Certificate> getData() {
        ArrayList data = new ArrayList();
        data.add(new City(1, "أمي"));
        data.add(new City(2, "ابتدائي"));
        data.add(new City(3, "إعدادي"));
        data.add(new City(4, "ثانوي"));
        data.add(new City(5, "معهد"));
        data.add(new City(6, "جامعي"));
        data.add(new City(7, "دراسات عليا "));
        return data;
    }
}
