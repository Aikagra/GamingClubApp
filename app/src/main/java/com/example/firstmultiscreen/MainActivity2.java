package com.example.firstmultiscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ListView listView6969;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView6969 = findViewById(R.id.listView6969);

        FirebaseDatabase.getInstance().getReference().child("Home");

        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter adapter1 = new ArrayAdapter<String>(this, R.layout.activity_main7 , list);
        listView6969.setAdapter(adapter1);

        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("Home");
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                list.clear();
                for (DataSnapshot snapshot1 : dataSnapshot.getChildren()){
                    list.add(snapshot1.getValue().toString());
                    findViewById(R.id.progressBar202).setVisibility(View.INVISIBLE);
                }
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    public void openActivity5(View v) {
        Toast.makeText(this, "Redirecting to Member's Page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }

    public void loginactivity(View view) {
        Toast.makeText(this, "Logging Out ", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void openActivity6(View view) {
        Toast.makeText(this, "Redirecting to Wins Page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);

    }
    public void openActivity101(View v) {
        Toast.makeText(this, "Redirecting to Schedule's Page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity8.class);
        startActivity(intent);

    }
}