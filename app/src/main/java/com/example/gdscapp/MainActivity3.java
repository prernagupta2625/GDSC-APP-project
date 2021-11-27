package com.example.gdscapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity3 extends AppCompatActivity {
private FirebaseAuth auth;
private EditText email1,pass,repass;
private Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        email1=findViewById(R.id.emailreg);
        pass=findViewById(R.id.passreg);
        repass=findViewById(R.id.repassreg);
        auth=FirebaseAuth.getInstance();
        b2=findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email2 = email1.getText().toString();
                String pass1= pass.getText().toString();
                String repass1=repass.getText().toString();
                if (TextUtils.isEmpty(email2) || TextUtils.isEmpty(pass1)||TextUtils.isEmpty(repass1) ) {
                    Toast.makeText(MainActivity3.this,"Enter amail and password correctly",Toast.LENGTH_LONG).show();

                } else if(pass1.equals(repass1)) {
                    auth.createUserWithEmailAndPassword(email2,pass1).addOnSuccessListener(MainActivity3.this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(MainActivity3.this,"register Successful",Toast.LENGTH_LONG).show();
            }});}
            else{
                            Toast.makeText(MainActivity3.this,"rassword and repassword must be same",Toast.LENGTH_LONG).show();}
                    }
        });

    }
}