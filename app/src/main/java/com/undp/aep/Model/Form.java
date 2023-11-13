package com.undp.aep.Model;

import java.util.ArrayList;

public class Form {
    private static Form data = null;

    public static Form getInstance(boolean isNew) {
        if (isNew)
            data = new Form();
        if (data == null)
            data = new Form();
        return data;
    }

    public String Governorate = ""; // المحافظة
    public String ArabicName = "";// الاسم العربي
    public String EnglishName = "";// الاسم الانكليزي
    public String NationalID = "";//الرقم الوطني
    public String EntityID = "";//رقم الهوية
    public String BirthDate = "";//مكان وتاريخ الولادة
    public String Constraint = "";//القيد
    public int Gender = 0; // 0 male , 1 female
    public int Married = 0;// 0 single , 1 married , 2 Widower , 3 divorced
    public int disability = 0; // لا يوجد0  - 2 حركية - 3سمعية -4 بصرية - 5 غير ذلك
    public String other_disablility = "";

    public String FatherName = "";
    public String FatherWork = "";
    public int FatherAge = 0;
    public String MotherName = "";
    public String MotherWork = "";
    public int MotherAge = 0;
    public int FamilyNum = 0;
    public int Martyrs_families = 0; // 0 no , 1 yes
    public int Residence = 0; // 0 مهجر  , 1 مقيم - 2 عائد
    public int MilitaryService = 0; // 0 مؤجل  , 1 مسرح - 2 وحيد دائم - 3 وحيد مؤقت - 4 معفى
    public String HowKnowYEP = "";//كيف علمت بالمركز

    // Contact info
    public String Phone = "";
    public String Mobile = "";
    public String WhatsApp = "";
    public String Facebook = "";
    public String Email = "";

    // معلومات الاقامة
    public String City = "";
    public String Region = "";
    public String Town = "";
    public String Address = "";

    public int Certificate = 0;// 0 امي - 1 ابتدائي - 2 اعداداي - 3 ثانوي - 4 معهد - 5 جامعي - 6 دراسات عليا

    public String AcademicSpecialization = "";// الاختصاص
    public String LastCertificateDate = "";// تاريخ اخر شهادة
    public String StudyYear = "";// السنة الدراسية

    public ArrayList<Course> AllCourses = new ArrayList<>();// الدورات التدريبية

    public int English = 0;// 0 ضعيف جدا - 1 ضعيف - 2 مقبول  - 3 جيد - 4 جيد جدا
    public int otherLanguage = 0;// 0 ضعيف جدا - 1 ضعيف - 2 مقبول  - 3 جيد - 4 جيد جدا

}
