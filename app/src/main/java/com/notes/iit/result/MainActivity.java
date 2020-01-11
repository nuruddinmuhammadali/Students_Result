package com.notes.iit.result;

import android.content.Intent;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.notes.iit.result.R;
import com.notes.iit.result.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    Button btnal,btnSrc,btnLg;
    FloatingActionButton flt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);


        btnal = (Button)  findViewById(R.id.btnAll);
        btnSrc = (Button)  findViewById(R.id.btnSearch);
        btnLg = (Button)  findViewById(R.id.btnLog);
        btnLg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });
        btnSrc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(i);
            }
        });
        btnal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), StudentsList.class);
                startActivity(i);
                StudentsList studentsList= new StudentsList();
                //studentsList.noteEditOpenButton.setVisibility(View.GONE);

                //  FloatingActionButton floatingActionButton = ((StudentsList) getActivity()).getFloatingActionButton();

//                if (floatingActionButton != null) {
//                    floatingActionButton.hide();
//                }
            }
        });



    }
}
