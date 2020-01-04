package com.notes.iit.result;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.notes.iit.result.R;

public class StudentsListAdapter extends CursorAdapter {
    public StudentsListAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        //TextView stid = (TextView) view.findViewById(R.id.stuId);
        TextView stname = (TextView) view.findViewById(R.id.stuName);
        TextView stroll = (TextView) view.findViewById(R.id.stuRoll);
        TextView clas = (TextView) view.findViewById(R.id.stuClas);
        TextView batch = (TextView) view.findViewById(R.id.stuBatch);
        TextView dept = (TextView) view.findViewById(R.id.stuDept);
        TextView address = (TextView) view.findViewById(R.id.stuAddress);
       // String stuid = cursor.getString(cursor.getColumnIndexOrThrow(SqliteHelper.KEY_ID));
        String stuname = cursor.getString(cursor.getColumnIndexOrThrow(SqliteHelper.KEY_NAME));
        String sturoll = cursor.getString(cursor.getColumnIndexOrThrow(SqliteHelper.KEY_ROLL));
        String stuclas = cursor.getString(cursor.getColumnIndexOrThrow(SqliteHelper.KEY_CLASS));
        String stubatch=cursor.getString(cursor.getColumnIndexOrThrow(SqliteHelper.KEY_BATCH));
        String studept=cursor.getString(cursor.getColumnIndexOrThrow(SqliteHelper.KEY_DEPARTMENT));
        String stuaddres=cursor.getString(cursor.getColumnIndexOrThrow(SqliteHelper.KEY_ADDRESS));
        String preview="";

       // stid.setText(stuid);
        stname.setText(stuname);
        stroll.setText(sturoll);
        clas.setText(stuclas);
        batch.setText(stubatch);
        dept.setText(studept);
        address.setText(stuaddres);

    }
}
