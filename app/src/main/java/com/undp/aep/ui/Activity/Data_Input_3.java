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
import com.undp.aep.Model.City;
import com.undp.aep.Model.Disability;
import com.undp.aep.Model.Form;
import com.undp.aep.Model.Person;
import com.undp.aep.R;

import java.util.ArrayList;

public class Data_Input_3 extends AppCompatActivity {

    Form form = null;

    ArrayList<String> data1;

    SwitchMaterial switchDisability;

    TextInputEditText txtOther;

    AutoCompleteTextView txtDisabilityType;

    Spinner spnrDisabilityType;

    FloatingActionButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__input_3);
        try {
            TextInputLayout lbl1 = findViewById(R.id.lbl1);
            TextInputLayout lbl2 = findViewById(R.id.lbl2);
            form = Form.getInstance(false);

            switchDisability = findViewById(R.id.switchDisability);
            switchDisability.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        txtDisabilityType.setVisibility(View.VISIBLE);
                        spnrDisabilityType.setSelection(0);
                        lbl1.setVisibility(View.VISIBLE);
                    } else {
                        lbl1.setVisibility(View.GONE);
                        lbl2.setVisibility(View.GONE);
                    }
                }
            });
            txtOther = findViewById(R.id.txtOther);

            btnNext = findViewById(R.id.btnNext);

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToNextPage();
                }
            });

            txtDisabilityType = findViewById(R.id.txtDisabilityType);

            txtDisabilityType.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    spnrDisabilityType.performClick();
                }
            });

            spnrDisabilityType = findViewById(R.id.spnrDisabilityType);
            spnrDisabilityType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String type = ((Disability) parent.getItemAtPosition(position)).Name;
                    txtDisabilityType.setText(type);
                    if (type.equals("أخرى")) {
                        txtOther.setVisibility(View.VISIBLE);
                    } else {
                        txtOther.setVisibility(View.INVISIBLE);
                        txtOther.setHeight(0);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            //data1 = new ArrayList<>();

            ArrayAdapter<Disability> adapter1;
            adapter1 = new ArrayAdapter<Disability>(this, android.R.layout.simple_spinner_dropdown_item, Disability.getData());
            spnrDisabilityType.setAdapter(adapter1);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    /*
        private void load_data() {
            data1.add("حركية");
            data1.add("عقلية");
            data1.add("سمعية");
            data1.add("بصرية");
            data1.add("أخرى");
        }
     */
    private void goToNextPage() {

        try {
            //Toast.makeText(this, person.getCenter(), Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, Data_Input_4.class));
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
}