package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayAlertDialog(View view)
    {
        new MyDialogFrament().show(getSupportFragmentManager(),"Alert Dialog");
    }

    public void displayListAlertDialog(View view)
    {
        new MyListDialogFragment().show(getSupportFragmentManager(),"List Alert Dialog");
    }

    public void displayCheckBoxAlertDialog(View view)
    {
        new MyCheckBoxDialogFragment().show(getSupportFragmentManager(),"Check Box Alert Dialog");
    }

    public void displayRadioButtonAlertDialog(View view)
    {
        new RadioButtonDialogFragment().show(getSupportFragmentManager(),"Radio Button Alert Dialog");
    }

    public void displayCustomAlertDialog(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        view = getLayoutInflater().inflate(R.layout.custom_alert_dialog, null);

        final EditText email = view.findViewById(R.id.email);
        final EditText password = view.findViewById(R.id.password);

        builder.setView(view);
        builder.setPositiveButton("Sign-in", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Signed-in as:\n"+email.getText().toString()+"\n"+password.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Cancelled",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();
    }
}
