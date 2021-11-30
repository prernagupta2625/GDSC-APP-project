package com.example.gdscapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {
 FirebaseAuth auth;
 RecyclerView recview;
 FirebaseDatabase database;
 DatabaseReference reference;
 adapter adapter;
 ArrayList<userhelper> userhelperArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        recview=findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));
        recview.setAdapter(adapter);
           userhelperArrayList =new ArrayList<>();
         /*  reference.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot snapshot) {
                   for(DataSnapshot datasnapshot:snapshot.getChildren())
                       {  userhelper user=datasnapshot.getValue(userhelper.class);
                       userhelperArrayList.add(user);
               }

               @Override
               public void onCancelled( @Nullable DatabaseError error) {

               }
           })*/
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot datasnapshot : snapshot.getChildren()) {
                    userhelper user = datasnapshot.getValue(userhelper.class);
                    userhelperArrayList.add(user);
                }  adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adapter=new adapter(MainActivity5.this,userhelperArrayList);
    }
}