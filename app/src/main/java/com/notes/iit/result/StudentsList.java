package com.notes.iit.result;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.notes.iit.result.R;

public class StudentsList extends AppCompatActivity {
    FloatingActionButton noteEditOpenButton;
    FloatingActionButton profileUpdateButton;
    ListView listView;
    SqliteHelper sqliteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);
        initalizeViews();
        noteEditOpenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentsList.this, ListEditActivity.class);
                startActivity(intent);
            }
        });
        profileUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StudentsList.this, ProfileUpdate.class);
                startActivity(intent);
            }
        });
        sqliteHelper=new SqliteHelper(this);
        Cursor cursor= sqliteHelper.retriveAllStudentsCursor();
        CursorAdapter cursorAdapter=new StudentsListAdapter(this,cursor);
        listView.setAdapter(cursorAdapter);
    }
    private void initalizeViews() {
        noteEditOpenButton=(FloatingActionButton)findViewById(R.id.fab);
        profileUpdateButton=(FloatingActionButton)findViewById(R.id.profileID);
        listView=(ListView)findViewById(R.id.list);
    }

    public FloatingActionButton getNoteEditOpenButton() {
        return noteEditOpenButton;
    }
}
