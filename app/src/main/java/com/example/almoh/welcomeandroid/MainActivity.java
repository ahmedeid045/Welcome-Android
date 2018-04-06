package com.example.almoh.welcomeandroid;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Dialog dialog;
    Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btnShowDialog);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_LEFT_ICON);
                dialog.setContentView(R.layout.layout_dialog);
                dialog.setTitle("My Dialog");
                dialog.setFeatureDrawableResource(Window.FEATURE_LEFT_ICON, R.drawable.info);
                dialog.setCancelable(true);
                dialog.show();
            }
        });

        btn2 = (Button) findViewById(R.id.btnShowDialog2 );

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LayoutAvctivity.class);
                startActivity(intent);
            }
        });

    }

    public void showAlertDialog(View view) {

        AlertDialog dialog = new AlertDialog.Builder(this).create();
        final EditText editText = new EditText(this);

        dialog.setTitle("the alert dialog");
        dialog.setView(editText);

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new  DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String result = editText.getText().toString();

                if(!TextUtils.isEmpty(result)){
                    Toast.makeText(MainActivity.this, "the result is :" + result, Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this, "No result", Toast.LENGTH_LONG).show();
                }
            }
        });

        dialog.show();
    }
}
