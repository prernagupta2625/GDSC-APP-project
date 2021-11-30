package com.example.gdscapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.okhttp.internal.DiskLruCache;

import java.net.URI;

import javax.annotation.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity4 extends AppCompatActivity {

    private CircleImageView ib;
    private FirebaseStorage storage;
    private FirebaseUser user;
    DatabaseReference database;
    String uid;
    private TextView t3,t4,t5,t6,t2;
    BottomNavigationView bview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main4);
        t3=findViewById(R.id.textView3);
        t4=findViewById(R.id.textView4);
        t5=findViewById(R.id.textView5);
        t6=findViewById(R.id.textView6);
        t2=findViewById(R.id.textView2);
bview=findViewById(R.id.bottom);
   bview.setSelectedItemId(R.id.home);
        user= FirebaseAuth.getInstance().getCurrentUser();
        database= FirebaseDatabase.getInstance().getReference("users");
        uid=user.getUid();
       //Toast.makeText(MainActivity4.this, "Something "+uid, Toast.LENGTH_LONG).show();
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot datasnapshot) {
                //User profile= snapshot.getValue(User.class);
                // Toast.makeText(MainActivity4.this, "Something ", Toast.LENGTH_LONG).show();
                //if(profile!=null)
                // {
                String name = datasnapshot.child(uid).child("name").getValue(String.class);
                Toast.makeText(MainActivity4.this, "SHere is your profile", Toast.LENGTH_LONG).show();
                    /*String year=profile.year;
                    String domain=profile.domain;
                    String email=profile.email;
                    String phone=profile.phone;*/
                String domain = datasnapshot.child(uid).child("domain").getValue(String.class);
                String phone = datasnapshot.child(uid).child("phone").getValue(String.class);
                String email = datasnapshot.child(uid).child("email").getValue(String.class);
                String year = datasnapshot.child(uid).child("year").getValue(String.class);
               t3.setText(domain);
                    t4.setText(phone);
                    t5.setText(email);
                    t6.setText(year);
                t2.setText(name);
               /* }else if(profile==null)
                { Toast.makeText(MainActivity4.this, "empty ", Toast.LENGTH_LONG).show();}
            }*/
            }
            @Override
            public void onCancelled( DatabaseError error) {
                Toast.makeText(MainActivity4.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });

        /*ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               registerForActivityResult()

            }
        });*/


    }
}