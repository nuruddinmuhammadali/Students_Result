package com.notes.iit.result;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.notes.iit.result.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Student>{


    private ArrayList<Student> dataSet;
    Context mContext;
    private int lastPosition = -1;
    private static class ViewHolder {
        TextView stid,name,roll,clas,batch,dept,adres;
        TextView notePreview;
        TextView date;
    }

    public CustomAdapter(ArrayList<Student> data, Context context) {
        super(context, R.layout.list_row, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student note = getItem(position);
        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_row, parent, false);
            viewHolder.stid =  convertView.findViewById(R.id.stuId);
            viewHolder.name =  convertView.findViewById(R.id.name);
            viewHolder.roll =  convertView.findViewById(R.id.stuRoll);
            viewHolder.clas =  convertView.findViewById(R.id.stuClas);
            viewHolder.batch =  convertView.findViewById(R.id.stuBatch);
            viewHolder.dept =  convertView.findViewById(R.id.stuDept);
            viewHolder.adres =  convertView.findViewById(R.id.stuAddress);
            //viewHolder.notePreview = convertView.findViewById(R.id.notePreview);
           // viewHolder.date = convertView.findViewById(R.id.datetime);
            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

      //  String title=note.description.split("\n")[0];
        String preview="";
       // if(note.description.contains("\n")) {
       //     preview = note.description.split("\n")[1];
      //  }
        //viewHolder.stid.setText(ad);
        viewHolder.notePreview.setText(preview);

        return convertView;
    }
}

