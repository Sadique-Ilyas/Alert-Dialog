package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
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

    public void displayMaterialAlertDialog(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialogTheme);
        View view1 = LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.material_dialog_layout,
                                (ConstraintLayout)findViewById(R.id.layoutDialogContainer));
        builder.setView(view1);
        builder.setCancelable(false);

        final AlertDialog dialog = builder.create();

        view1.findViewById(R.id.cancelBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Cancel !", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        view1.findViewById(R.id.okayBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Okay !", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        if (dialog.getWindow() != null)
        {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        dialog.show();
    }
}
