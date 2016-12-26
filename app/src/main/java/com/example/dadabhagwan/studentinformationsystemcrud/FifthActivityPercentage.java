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

public class FifthActivityPercentage extends Activity {

    DataBaseHandler db;

    SimpleCursorAdapter sca;
    Cursor cursorLess35,cursor50,cursorAbove50,cursorAbove70,cursorAbove90,cursor;

    ListView per;

    Button btnless35,btn50,btnGra50,btnGra70,btnGra90;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_percentage);
        initialize();
        db=new DataBaseHandler(this);
        btnless35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursorLess35 = db.resultLess35();
                cursor=cursorLess35;
                displayAllData();

            }
        });
        btn50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursor50 = db.resultEql35();
                cursor=cursor50;
                displayAllData();

            }
        });
        btnGra50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursorAbove50 = db.resultGrat50();
                cursor=cursorAbove50;
                displayAllData();

            }
        });
        btnGra70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursorAbove70 = db.resultGrat70();
                cursor=cursorAbove70;
                displayAllData();

            }
        });
        btnGra90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursorAbove90 = db.resultGrater90();
                cursor=cursorAbove90;
                displayAllData();

            }
        });

    }
    public void initialize() {
        per = (ListView) findViewById(R.id.lvPer);
        btnless35 = (Button) findViewById(R.id.btnLessThna35);
        btn50 = (Button) findViewById(R.id.btnEqual50);
        btnGra50 = (Button) findViewById(R.id.btnGrater50);
        btnGra70 = (Button) findViewById(R.id.btnlessthan70);
        btnGra90 = (Button) findViewById(R.id.btngrater90);
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
            per.setAdapter(sca);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e+"", Toast.LENGTH_SHORT).show();
        }
    }


}
