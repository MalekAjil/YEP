package com.example.testtt;

public class Training {
    public String Name=""; // اسم التدريب
    public String Center=""; // جهة التدريب
    public String Date="";// تاريخ
    public String Duration=""; // المدة
    public String Successful=""; // انهيت التدريب

    public Training(){}

    @Override
    public String toString() {
        return "اسم التدريب=" + Name + "\n" +
                "الجهة المانحة=" + Center + "\n" +
                "التاريخ=" + Date + "\n" +
                "المدة=" + Duration + "\n" +
                "حصل على شهادة؟=" + Successful ;
    }
}
