package com.example.gdscapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    private Button b1;
    private EditText email;
    private EditText password;

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        email=findViewById(R.id.emaillog);
        password=findViewById(R.id.passlogin);
        b1 = findViewById(R.id.button);
        auth=FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();
                if (TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1)) {
                    Toast.makeText(MainActivity2.this,"Enter email and password correctly",Toast.LENGTH_LONG).show();

                } else {
                    auth.signInWithEmailAndPassword(email1,password1).addOnSuccessListener(MainActivity2.this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(MainActivity2.this,"Login Successful",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity2.this,MainActivity4.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}