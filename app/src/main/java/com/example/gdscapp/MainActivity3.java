package com.example.gdscapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText email1, pass, repass, phone1, year1, domain1, name1;
    private Button b2;
    private ImageButton ib;
    private FirebaseFirestore firestore;
    private FirebaseDatabase database;
private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        email1 = findViewById(R.id.emailreg);
        pass = findViewById(R.id.passreg);
        repass = findViewById(R.id.repassreg);
        auth = FirebaseAuth.getInstance();
        b2 = findViewById(R.id.button2);
        phone1 = findViewById(R.id.phone);
        name1 = findViewById(R.id.name);
        ib = findViewById(R.id.imageButton);
        String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        domain1 = findViewById(R.id.domain);
        year1 = findViewById(R.id.year);
        firestore = FirebaseFirestore.getInstance();
        database = FirebaseDatabase.getInstance();

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email1.getText().toString();
                String pass1 = pass.getText().toString();
                String name = name1.getText().toString();
                String year = year1.getText().toString();
                String domain = domain1.getText().toString();
                String phone = phone1.getText().toString();
                String repass1 = repass.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass1) || TextUtils.isEmpty(repass1)
                        || TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(year) || TextUtils.isEmpty(domain)) {

                    Toast.makeText(MainActivity3.this, "Enter amail and password correctly", Toast.LENGTH_LONG).show();

                } else if (!email.matches(emailpattern)) {
                    Toast.makeText(MainActivity3.this, "Enter Valid email", Toast.LENGTH_LONG).show();
                } else if (pass1.equals(repass1)) {
                    if (pass1.length() > 5) {
                        auth.createUserWithEmailAndPassword(email, pass1).addOnSuccessListener(MainActivity3.this, new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                              /*  HashMap<String, String> v = new HashMap<>();
                                v.put("name", name1);
                                v.put("Phone", phone1);
                                v.put("domain",domain1);
                                v.put("year",year1);
                                v.put("email",email2);*/

                                user=auth.getCurrentUser();
                                userhelper helper=new userhelper(phone,name,year,domain,email);
                                database.getReference().child("users").child(user.getUid()).setValue(helper).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(MainActivity3.this, "Registration Done", Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        });



                        /*  Map<String,String> nfire=new HashMap<>();
                          nfire.put("name",name1);
                          nfire.put("email",email2);

                            Toast.makeText(MainActivity3.this,"usercreated",Toast.LENGTH_LONG).show();

                          firestore.collection("users").add(nfire).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                              @Override
                              public void onSuccess(DocumentReference documentReference) {
                                  Toast.makeText(MainActivity3.this,"register Successful",Toast.LENGTH_LONG).show();

                              }
                          }).addOnFailureListener(new OnFailureListener() {
                              @Override
                              public void onFailure(@NonNull Exception e) {
                                  String error=e.getMessage();
                                  Toast.makeText(MainActivity3.this,"Error="+error,Toast.LENGTH_LONG);
                              }
                          });

            }});}   else{ Toast.makeText(MainActivity3.this,"Password length should be greater than 5",Toast.LENGTH_LONG).show();}}
            else{
                            Toast.makeText(MainActivity3.this,"password and re-password must be same",Toast.LENGTH_LONG).show();}
                    }*/
                    }
                    else{
                        Toast.makeText(MainActivity3.this,"password should have 6 characters at least",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}