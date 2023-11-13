package com.undp.aep.ui.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.messaging.FirebaseMessaging;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.undp.aep.R;


import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class TestMaterialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_maerial);

/*
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.i(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        Log.i(TAG, "onComplete: "+token);

                    }
                });


*/

        loadData();
        MaterialAutoCompleteTextView dfgdfgdfgdfg = findViewById(R.id.auto);

        ArrayAdapter<String> sdfsdf3sdv56s4v6s5dv = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,sdfmjsdonfsdovns);
        dfgdfgdfgdfg.setAdapter(sdfsdf3sdv56s4v6s5dv);
    }
    ArrayList<String> sdfmjsdonfsdovns = new ArrayList<>();
    private void loadData() {
        sdfmjsdonfsdovns.add("Arabic");
        sdfmjsdonfsdovns.add("Aleppo Syria");
        sdfmjsdonfsdovns.add("HAMA ");
        sdfmjsdonfsdovns.add("Hello all");
        sdfmjsdonfsdovns.add("Any Text");
        sdfmjsdonfsdovns.add("123333");
        sdfmjsdonfsdovns.add("1111 2222 3333");
        sdfmjsdonfsdovns.add(";;dvd;q.we");
        sdfmjsdonfsdovns.add("====");
    }
}