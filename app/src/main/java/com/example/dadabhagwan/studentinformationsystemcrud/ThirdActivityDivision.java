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

public class ThirdActivityDivision extends Activity {

    DataBaseHandler db;
    ListView list;
    Button A,B,C,D,E;
    SimpleCursorAdapter sca;
    Cursor cursorA,cursorB,cursorC,cursorD,cursorE,cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_division);
        initialize();
        db=new DataBaseHandler(this);

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             cursorA = db.getDivA();
             cursor=cursorA;
            displayAllData();
            }
        });
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            cursorB=db.getDivB();
            cursor=cursorB;
            displayAllData();
            }
        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            cursorC=db.getDivC();
            cursor=cursorC;
            displayAllData();
            }
        });
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursorD=db.getDivD();
                cursor=cursorD;
                displayAllData();
            }
        });
        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursorE=db.getDivE();
                cursor=cursorE;
                displayAllData();
            }
        });

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
            list.setAdapter(sca);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e+"", Toast.LENGTH_SHORT).show();
        }
    }
    private void initialize()
    {
        list= (ListView) findViewById(R.id.lv1);
        A= (Button) findViewById(R.id.btnLessThna35);
        B= (Button) findViewById(R.id.btnEqual50);
        C= (Button) findViewById(R.id.btnC);
        D= (Button) findViewById(R.id.btnD);
        E= (Button) findViewById(R.id.btngrater90);
    }
}
