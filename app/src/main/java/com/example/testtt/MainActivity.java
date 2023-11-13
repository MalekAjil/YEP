package com.example.testtt;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public ListView lst_data;
    ExtendedFloatingActionButton fab_add;
    ExtendedFloatingActionButton bt_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst_data = findViewById(R.id.lst_data);
        fab_add = findViewById(R.id.add_training);
        bt_next = findViewById(R.id.next);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_dialog(new Training());
            }
        });

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNextPage();
            }
        });

    }

    private void goToNextPage() {
       /* Intent intent = new Intent(this, Data_Input_8.class);
        startActivity(intent);*/

    }

    private void show_dialog(Training c) {
        Dialog d = new Dialog(MainActivity.this);
        d.setContentView(R.layout.dialog);
        TextInputEditText training_name = d.findViewById(R.id.training_name);
        TextInputEditText company_name = d.findViewById(R.id.company_name);
        TextInputEditText Training_Date = d.findViewById(R.id.Date);
        TextInputEditText duration = d.findViewById(R.id.duration);
        RadioButton have_certificate = d.findViewById(R.id.have_certificate);
        RadioButton dont_have_certificate = d.findViewById(R.id.dont_have_certificate);
        Button add = d.findViewById(R.id.dialog_add);
        Button exc = d.findViewById(R.id.dialog_cancel);

        training_name.setText(c.Name);
        company_name.setText(c.Center);
        Training_Date.setText(c.Date);
        duration.setText(c.Duration);
        if (c.Successful.equals("نعم"))
            have_certificate.setChecked(true);
        else if (c.Successful.equals("لا"))
            dont_have_certificate.setChecked(true);

        d.setCancelable(false);
        exc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.dismiss();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!training_name.getText().toString().isEmpty()) {
                    c.Name = training_name.getText().toString();
                    c.Center = company_name.getText().toString();
                    c.Date = Training_Date.getText().toString();
                    c.Duration = duration.getText().toString();
                    if (have_certificate.isChecked())
                        c.Successful = "نعم";
                    else if (dont_have_certificate.isChecked())
                        c.Successful = "لا";
                    if (!Form.getInstance(false).AllCourses.contains(c))
                        Form.getInstance(false).AllCourses.add(c);
                    d.dismiss();
                    DisplayData();
                } else training_name.setError("الرجاء ملء هذا الحقل");
            }
        });
        d.show();

        Training_Date.addTextChangedListener(new TextWatcher() {
            private String current = "";
            private final String ddmmyyyy = "DDMMYYYY";
            private final Calendar cal = Calendar.getInstance();

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]", "");
                    String cleanC = current.replaceAll("[^\\d.]", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean.equals(cleanC)) sel--;

                    if (clean.length() < 8) {
                        clean = clean + ddmmyyyy.substring(clean.length());
                    } else {
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        int day = Integer.parseInt(clean.substring(0, 2));
                        int mon = Integer.parseInt(clean.substring(2, 4));
                        int year = Integer.parseInt(clean.substring(4, 8));

                        if (mon > 12) mon = 12;
                        cal.set(Calendar.MONTH, mon - 1);

                        year = (year < 1900) ? 1900 : Math.min(year, 2100);
                        cal.set(Calendar.YEAR, year);
                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012

                        day = Math.min(day, cal.getActualMaximum(Calendar.DATE));
                        clean = String.format("%02d%02d%02d", day, mon, year);
                    }

                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));

                    sel = Math.max(sel, 0);
                    current = clean;
                    Training_Date.setText(current);
                    Training_Date.setSelection(Math.min(sel, current.length()));
                }
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void DisplayData() {
        TrainingAdapter adapter = (TrainingAdapter) new TrainingAdapter(this, android.R.layout.simple_list_item_1,
                Form.getInstance(false).AllCourses);
        lst_data.setAdapter(adapter);
        lst_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                show_dialog((Training) parent.getItemAtPosition(i));
            }
        });


        lst_data.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int which_item = i;
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("هل أنت متأكد")
                        .setMessage("هل تريد حذف هذا العنصر")
                        .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Form.getInstance(false).AllCourses.remove(which_item);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("لا", null)
                        .show();

                return true;
            }
        });
    }
}