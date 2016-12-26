package com.example.dadabhagwan.studentinformationsystemcrud;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.dadabhagwan.studentinformationsystemcrud.DB.DataBaseHandler;

public class FourthActivityResult extends Activity {

    DataBaseHandler db;


    SimpleCursorAdapter sca;
    Cursor cursorPass,cursorFail,cursor;

    ListView lv2;
    Button btnPass,btnFail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_result);
        initialize();
        db=new DataBaseHandler(this);
        btnPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursorPass = db.resultPass();
                cursor=cursorPass;
                displayAllData();

            }
        });
        btnFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursorFail = db.resultFail();
                cursor=cursorFail;
                displayAllData();

            }
        });


    }

    public void initialize() {
        lv2 = (ListView) findViewById(R.id.lv2);
        btnPass = (Button) findViewById(R.id.btnPass);
        btnFail = (Button) findViewById(R.id.btnFail);

    }
    private void displayAllData()
    {
        try {
//            Cursor cursor = db.getDivA();
            if (cursor == null) {
                Toast.makeText(this, "Unable to generate Cursor", Toast.LENGTH_SHORT).show();
            }
            if (cursor.getCount() == 0) {
                Toast.makeText(this, "No record in DataBase", Toast.LENGTH_SHORT).show();
            }
            String[] coulmns = new String[]{db.STUDENT_ID,db.STUDENT_FIRST_NAME, db.STUDENT_LAST_NAME, db.STUDENT_STD, db.STUDENT_DIV, db.STUDENT_RESULT, db.STUDENT_PERCENTAGE};
            int[] boundTo = new int[]{R.id.tvId,R.id.tvFname, R.id.tvLname, R.id.tvStd, R.id.tvDiv, R.id.tvResult, R.id.tvPercentage};
            sca = new SimpleCursorAdapter(this, R.layout.show, cursor, coulmns, boundTo, 0);
            lv2.setAdapter(sca);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e+"", Toast.LENGTH_SHORT).show();
        }
    }

}