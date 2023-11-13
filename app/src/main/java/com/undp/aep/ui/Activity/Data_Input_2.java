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

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.undp.aep.Model.Form;
import com.undp.aep.Model.Person;
import com.undp.aep.R;

import java.util.ArrayList;

public class Data_Input_2 extends AppCompatActivity {

    Form form =null;

    int genderIndex=0,maritalIndex=0;

    ArrayList<String > data1;
    ArrayList<String > data2;

    TextView txtHeader;

    TextInputEditText txtNameAR,txtNameEN,txtNationalNum,txtIdentityNum,
            txtBirthPlace,txtBirthDate,txtPlace;

    MaterialAutoCompleteTextView txtGender, txtSocialStatue;

    Spinner spnrGender,spnrSocial;

    ExtendedFloatingActionButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__input_2);
        try {
            form = Form.getInstance(false);

            data1 = new ArrayList<>();
            data2 = new ArrayList<>();

            txtHeader=findViewById(R.id.txtHeader);
            txtHeader.setText(txtHeader.getText()+" / مركز "+ form.Governorate);

            txtNameAR = findViewById(R.id.txtName_ar);
            txtNameEN = findViewById(R.id.txtName_en);
            txtNationalNum = findViewById(R.id.txtNationalNum);
            txtIdentityNum = findViewById(R.id.txtIdentityNUM);
            txtBirthPlace = findViewById(R.id.txtBirthPlace);
            txtBirthDate = findViewById(R.id.txtBirthDate);
            txtPlace = findViewById(R.id.txtPlace);

            btnNext = findViewById(R.id.btnNext);
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToNextPage();
                }
            });

            txtGender = findViewById(R.id.txtGender);
            txtSocialStatue = findViewById(R.id.txtSocialStatue);

            spnrGender=findViewById(R.id.spnrGender);
            spnrSocial=findViewById(R.id.spnrSocial);

            txtGender.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    spnrGender.performClick();
                }
            });

            txtSocialStatue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    spnrSocial.performClick();
                }
            });

            spnrGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    txtGender.setText(parent.getAdapter().getItem(position).toString());
                    genderIndex=position;
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            spnrSocial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    txtSocialStatue.setText(parent.getAdapter().getItem(position).toString());
                    form.Married=position;
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            load_data();
            //txtNameEN.setText(person.getCenter());

            ArrayAdapter<String> adapter1, adapter2;
            adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data1);
            adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data2);
            spnrGender.setAdapter(adapter1);
            spnrSocial.setAdapter(adapter2);
        }catch (Exception ex){
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void load_data(){
        data1.add("ذكر");
        data1.add("أنثى");

        data2.add("عازب(ة)");
        data2.add("متزوج(ة)");
        data2.add("أرمل(ة)");
        data2.add("مطلق(ة)");
    }

    private void goToNextPage() {
        //if(check()) {
            try {
                //Toast.makeText(this, person.getCenter(), Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, Data_Input_3.class));
            }catch (Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        //}
    }

    private boolean check() {
        int checked=0;
        if(txtNameAR.getText().length()>1){
            form.ArabicName=txtNameAR.getText().toString();
            checked++;
        }
        else
            txtNameAR.setError("الرجاء ملء هذا الحقل");

        if(txtNameEN.getText().length()>2){
            form.EnglishName=txtNameEN.getText().toString();
            checked++;
        }
        else
            txtNameEN.setError("الرجاء ملء هذا الحقل");

        if(txtNationalNum.getText().length()>7){
            form.NationalID=txtNationalNum.getText().toString();
            checked++;
        }
        else
            txtNationalNum.setError("الرجاء ملء هذا الحقل بقيمة حقيقية");
        if(txtIdentityNum.getText().length()>5){
            form.EntityID=txtIdentityNum.getText().toString();
            checked++;
        }
        else
            txtIdentityNum.setError("الرجاء ملء هذا الحقل بقيمة حقيقية");

        if(txtBirthPlace.getText().length()>1){
            form.BirthDate=txtBirthPlace.getText().toString();
            checked++;
        }
        else
            txtBirthPlace.setError("الرجاء ملء هذا الحقل");

        if(txtBirthDate.getText().length()>6){
            form.BirthDate=txtBirthDate.getText().toString();
            checked++;
        }
        else
            txtBirthDate.setError("الرجاء ملء هذا الحقل");

        if(txtPlace.getText().length()>1) {
            form.Constraint=txtPlace.getText().toString();
            checked++;
        }
        else
            txtPlace.setError("الرجاء ملء هذا الحقل");

        if(txtGender.getText().length()>2){
            //form.Gender=txtGender.getText().toString();
            form.Gender=genderIndex;
            checked++;
        }
        else
            txtGender.setError("الرجاء اختيار الجنس");

        if(txtSocialStatue.getText().length()>2){
            //form.Married=txtSocialStatue.getText().toString());
            form.Married=maritalIndex;
            checked++;
        }
        else
            txtSocialStatue.setError("الرجاء اختيار حالة");

        if (checked>8)
            return true;
        return false;
    }
}