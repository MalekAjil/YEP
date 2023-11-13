package com.undp.aep.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.undp.aep.Model.Form;
import com.undp.aep.R;

import java.util.ArrayList;

public class Data_Input_4 extends AppCompatActivity {
    Form form =null;

    TextInputEditText txtFatherName,txtFatherJob,txtFatherAge,
            txtMotherName,txtMotherJob,txtMotherAge,txtFamilyNum;

    FloatingActionButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__input_4);
        try{
            TextInputLayout lbl1 = findViewById(R.id.lbl1);
            TextInputLayout lbl2 = findViewById(R.id.lbl2);
            form = Form.getInstance(false);

            txtFatherName=findViewById(R.id.txtFatherName);
            txtFatherJob=findViewById(R.id.txtFatherJob);
            txtFatherAge=findViewById(R.id.txtFatherAge);
            txtMotherName=findViewById(R.id.txtMotherName);
            txtMotherJob=findViewById(R.id.txtMotherJob);
            txtMotherAge=findViewById(R.id.txtMotherAge);
            txtFamilyNum=findViewById(R.id.txtFamilyNUM);

            btnNext = findViewById(R.id.btnNext);
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToNextPage();
                }
            });

           }catch (Exception ex){
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void goToNextPage() {
        if(check()) {
            try {
                //Toast.makeText(this, person.getCenter(), Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, Data_Input_3.class));
            }catch (Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean check() {
        int checked=0;

        if(txtFatherName.getText().length()>2){
            form.FatherName=txtFatherName.getText().toString();
            checked++;
        }
        else{
            txtFatherName.setError("الرجاء ملء هذا الحقل");
        }

        if(txtFatherJob.getText().length()>2){
            form.FatherWork=txtFatherJob.getText().toString();
            checked++;
        }
        else{
            txtFatherJob.setError("الرجاء ملء هذا الحقل");
        }
        if(txtFatherAge.getText().length()>1){
            form.FatherAge=Integer.parseInt(txtFatherAge.getText().toString());
            checked++;
        }
        else{
            txtFatherAge.setError("الرجاء ملء هذا الحقل");
        }

        if(txtMotherName.getText().length()>2){
            form.MotherName=txtMotherName.getText().toString();
            checked++;
        }
        else{
            txtMotherName.setError("الرجاء ملء هذا الحقل");
        }

        if(txtMotherJob.getText().length()>2){
            form.MotherWork=txtMotherJob.getText().toString();
            checked++;
        }
        else{
            txtMotherJob.setError("الرجاء ملء هذا الحقل");
        }

        if(txtMotherAge.getText().length()>2){
            form.MotherAge=Integer.parseInt(txtMotherAge.getText().toString());
            checked++;
        }
        else{
            txtMotherAge.setError("الرجاء ملء هذا الحقل");
        }

        if(txtFamilyNum.getText().length()>0){
            form.FamilyNum = Integer.parseInt(txtFamilyNum.getText().toString());
            checked++;
        }
        else{
            txtFamilyNum.setError("الرجاء ملء هذا الحقل");
        }

        if(checked>6)
            return true;
        return false;
    }
}