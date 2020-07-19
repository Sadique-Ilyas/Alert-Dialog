package com.example.alertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MyCheckBoxDialogFragment extends DialogFragment
{
    List<String> mySelectedItems;

    String []fruits = {"Apple","Mango","Grapes","Orange"};
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        mySelectedItems = new ArrayList<>();
        builder.setTitle("Pick a Fruit");
        builder.setMultiChoiceItems(fruits, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked)
            {
                if (isChecked)
                {
                    mySelectedItems.add(fruits[which]);
                }
                else if (mySelectedItems.contains(fruits[which]))
                {
                    mySelectedItems.remove(fruits[which]);
                }
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String finalSelection = "";
                for (String item:mySelectedItems)
                {
                    finalSelection = finalSelection +"\n"+ item;
                }
                Toast.makeText(getActivity(),"Nice Choice"+finalSelection,Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Cancelled",Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
}
