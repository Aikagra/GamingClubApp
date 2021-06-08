package com.example.firstmultiscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {

    private ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        listView1 = findViewById(R.id.listView1);


        FirebaseDatabase.getInstance().getReference().child("Wins");

        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter adapter1 = new ArrayAdapter<String>(this, R.layout.activity_main7 , list);
        listView1.setAdapter(adapter1);

        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("Wins");
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                list.clear();
                for (DataSnapshot snapshot1 : dataSnapshot.getChildren()){
                    list.add(snapshot1.getValue().toString());
                    findViewById(R.id.progressBar69).setVisibility(View.INVISIBLE);
                }
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


            }
    }
