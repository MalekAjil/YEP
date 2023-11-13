package com.undp.aep.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.undp.aep.Model.City;
import com.undp.aep.Model.Form;
import com.undp.aep.Model.Person;
import com.undp.aep.R;

public class Data_Input_1 extends AppCompatActivity {

    Button btnAleppo, btnDamascus, btnSuwyda, btnHama,
            btnLatakia, btnTartous, btnDeerAlzor, btnHasakah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__input_1);

        ListView lst_data = findViewById(R.id.lst_data);
        ArrayAdapter<City> adapter = new ArrayAdapter<City>(this, android.R.layout.simple_list_item_1, City.getData());
        lst_data.setAdapter(adapter);

        lst_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Form.getInstance(false).Governorate = ((City) parent.getItemAtPosition(position)).Name;
                goToNextPage();
            }
        });
    }

    private void goToNextPage() {
        try {
            startActivity(new Intent(this, Data_Input_2.class));
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}