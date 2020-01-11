package com.notes.iit.result;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.notes.iit.result.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListEditActivity extends AppCompatActivity {
    private SqliteHelper sqliteHelper;
    EditText name,roll,clas,batch,dept,address;
    TextView dateModified;
    TextView characterCount;
    Button sample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_edit);
        sqliteHelper=new SqliteHelper(this);
        initializeViews();
        final TextWatcher mTextEditorWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                characterCount.setText(String.valueOf(s.length()));
            }

            public void afterTextChanged(Editable s) {
            }
        };
//        name.addTextChangedListener(mTextEditorWatcher);
//        roll.addTextChangedListener(mTextEditorWatcher);
//        batch.addTextChangedListener(mTextEditorWatcher);
//        dept.addTextChangedListener(mTextEditorWatcher);
//        clas.addTextChangedListener(mTextEditorWatcher);
//        dept.addTextChangedListener(mTextEditorWatcher);
//        address.addTextChangedListener(mTextEditorWatcher);
    }

    private void initializeViews() {
        name=(EditText)findViewById(R.id.name);
        roll=(EditText)findViewById(R.id.roll);
        clas=(EditText)findViewById(R.id.clas);
        batch=(EditText)findViewById(R.id.batch);
        dept=(EditText)findViewById(R.id.dept);
        address=(EditText)findViewById(R.id.adress);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String currentDateTime=simpleDateFormat.format(new Date());
       // dateModified.setText(currentDateTime);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.save:
                Date date=new Date();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                String currentDateTime=simpleDateFormat.format(date);
                Student student=new
                        Student(name.getText().toString(),roll.getText().toString(),clas.getText().toString(),batch.getText().toString(),dept.getText().toString(),address.getText().toString());
                if(name.getText().toString().isEmpty() || roll.getText().toString().isEmpty()  || clas.getText().toString().isEmpty()
                        || batch.getText().toString().isEmpty() || dept.getText().toString().isEmpty() || address.getText().toString().isEmpty()){
                    String warning = getString(R.string.warn);// + model.getDisplayName();
                    // TODO : initiate successful logged in experience
                    Toast.makeText(getApplicationContext(), warning, Toast.LENGTH_SHORT).show();
                }
                    else{
                            sqliteHelper.addStudent(student);
//                dateModified.setText(currentDateTime);
                name.setText("");   roll.setText("");   clas.setText("");
                batch.setText("");   dept.setText("");   address.setText("");
                name.requestFocus();
                String welcome = getString(R.string.noteSaved);// + model.getDisplayName();
                // TODO : initiate successful logged in experience
                Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();}
                break;
            case R.id.vall:

                        Intent i = new Intent(getApplicationContext(), StudentsList.class);
                        startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
