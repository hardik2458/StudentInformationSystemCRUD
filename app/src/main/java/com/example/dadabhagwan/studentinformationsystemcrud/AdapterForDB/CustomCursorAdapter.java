package com.example.dadabhagwan.studentinformationsystemcrud.AdapterForDB;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dadabhagwan.studentinformationsystemcrud.DB.DataBaseHandler;
import com.example.dadabhagwan.studentinformationsystemcrud.R;

/**
 * Created by dadabhagwan on 10/27/2016.
 */

public class CustomCursorAdapter extends CursorAdapter {
   DataBaseHandler db;
    public CustomCursorAdapter(Context context, Cursor c) {
        super(context, c,0);
        db=new DataBaseHandler(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.show, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvfname = (TextView) view.findViewById(R.id.tvFname);
        TextView tvlname = (TextView) view.findViewById(R.id.tvLname);
        TextView tvstd = (TextView) view.findViewById(R.id.tvStd);
        TextView tvdiv = (TextView) view.findViewById(R.id.tvDiv);
        TextView tvresult = (TextView) view.findViewById(R.id.tvResult);
        TextView tvPercentage = (TextView) view.findViewById(R.id.tvPercentage);

        int id=cursor.getInt(cursor.getColumnIndex(db.STUDENT_ID));
        String fname = cursor.getString(cursor.getColumnIndex(db.STUDENT_FIRST_NAME));
        String lname = cursor.getString(cursor.getColumnIndex(db.STUDENT_LAST_NAME));
        String std = cursor.getString(cursor.getColumnIndex(db.STUDENT_STD));
        String div = cursor.getString(cursor.getColumnIndex(db.STUDENT_DIV));
        String res = cursor.getString(cursor.getColumnIndex(db.STUDENT_RESULT));
        String per = cursor.getString(cursor.getColumnIndex(db.STUDENT_PERCENTAGE));

        Toast.makeText(context, id, Toast.LENGTH_SHORT).show();
        tvfname.setText(fname);
        tvlname.setText(lname);
        tvstd.setText(std);
        tvdiv.setText(div);
        tvresult.setText(res);
        tvPercentage.setText(per);
    }
}
