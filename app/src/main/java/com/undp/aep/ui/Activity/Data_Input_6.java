package com.undp.aep.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.undp.aep.Model.Certificate;
import com.undp.aep.Model.Form;
import com.undp.aep.R;

import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;

public class Data_Input_6 extends AppCompatActivity {

    Form form=null;

    //ArrayList<String> data1;
    int CertificateIndex=0;

    TextView txtHeader;

    TextInputEditText txtCity, txtArea, txtTown, txtAddress,
             txtSpecialization, txtLastCertificateDate,txtStudyYear;

    MaterialAutoCompleteTextView txtEducation;

    Spinner spnrEducation;

    FloatingActionButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__input_6);
        try {
            form=Form.getInstance(false);

            //data1 = new ArrayList<>();

            txtCity=findViewById(R.id.txtCity);
            txtArea=findViewById(R.id.txtArea);
            txtTown=findViewById(R.id.txtTown);
            txtAddress=findViewById(R.id.txtAddress);
            txtLastCertificateDate=findViewById(R.id.txtLastCertificateDate);
            txtSpecialization=findViewById(R.id.txtSpecialization);
            txtStudyYear=findViewById(R.id.txtYear);

            spnrEducation = findViewById(R.id.spnrGender);

            txtEducation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    spnrEducation.performClick();
                }
            });

            spnrEducation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    txtEducation.setText(((Certificate)parent.getItemAtPosition(position)).toString());
                    CertificateIndex=position;
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            //load_data();
            //txtNameEN.setText(person.getGovernorate());

            ArrayAdapter<Certificate> adapter1;
            adapter1 = new ArrayAdapter<Certificate>(this, android.R.layout.simple_spinner_dropdown_item, Certificate.getData());
            spnrEducation.setAdapter(adapter1);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
/*
    private void load_data() {
        data1.add("أمي");
        data1.add("ابتدائي");
        data1.add("إعدادي");
        data1.add("ثانوي");
        data1.add("معهد");
        data1.add("جامعي");
        data1.add("دراسات عليا");
    }
*/
    private void goToNextPage() {
        //if(check()) {
        try {
            //Toast.makeText(this, person.getGovernorate(), Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, Data_Input_7.class));
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        //}
    }

    private boolean check() {
        int checked = 0;
        if (txtCity.getText().length() > 1) {
            form.City=txtCity.getText().toString();
            checked++;
        } else
            txtCity.setError("الرجاء ملء هذا الحقل");

        if (txtArea.getText().length() > 1) {
            form.Region=txtArea.getText().toString();
            //checked++;
        }
        //else
          //  txt.setError("الرجاء ملء هذا الحقل");

        if (txtTown.getText().length() > 1) {
            form.Town=txtTown.getText().toString();
            //checked++;
        }
        //else
        //  txtCity.setError("الرجاء ملء هذا الحقل");
        if (txtAddress.getText().length() > 1) {
            form.Address=txtAddress.getText().toString();
            checked++;
        }
        else
          txtAddress.setError("الرجاء ملء هذا الحقل");

        if (txtEducation.getText().length() > 1) {
            form.Certificate=CertificateIndex;
            checked++;
        }
        else
          txtEducation.setError("الرجاء اختيار التحصيل العلمي");

        if (txtSpecialization.getText().length() > 1) {
            form.AcademicSpecialization=txtSpecialization.getText().toString();
            //checked++;
        }
        //else
        //  txt.setError("الرجاء ملء هذا الحقل");

        if (txtLastCertificateDate.getText().length() > 1) {
            form.LastCertificateDate=txtLastCertificateDate.getText().toString();
            //checked++;
        }
        //else
        //  txt.setError("الرجاء ملء هذا الحقل");

        if (txtStudyYear.getText().length() > 1) {
            form.StudyYear=txtStudyYear.getText().toString();
            //checked++;
        }
        //else
        //  txt.setError("الرجاء ملء هذا الحقل");

        if(checked>1)
            return true;
        return false;
    }

}