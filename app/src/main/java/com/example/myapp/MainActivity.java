package com.example.myapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void dialog(View view) {
        View layout = getLayoutInflater().inflate(R.layout.custom_activity, null);

        final EditText textName = layout.findViewById(R.id.username);
        final EditText textpass = layout.findViewById(R.id.password);
        CheckBox checkBox = layout.findViewById(R.id.checkbox1);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked)
                    textpass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                else {
                    textpass.setTransformationMethod(null);
                }
            }
        });
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Sign Up");
        alert.setView(layout);

        alert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String username = textName.getText().toString();
                String password = textpass.getText().toString();

                Toast.makeText(MainActivity.this, "UserName :" + username + "Password :" + password, Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You have pressed cencel", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setCancelable(false);

        AlertDialog dialog = alert.create();

        dialog.show();
    }
}

