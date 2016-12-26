package com.example.dadabhagwan.studentinformationsystemcrud;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.dadabhagwan.studentinformationsystemcrud.AdapterForDB.CustomCursorAdapter;
import com.example.dadabhagwan.studentinformationsystemcrud.DB.DataBaseHandler;
import com.example.dadabhagwan.studentinformationsystemcrud.pojo.StudentModel;

public class FirstActivity extends Activity {

    ListView lv;
    Button filldata,div,result,percentage;
    DataBaseHandler db;
    SQLiteDatabase sql;
    CustomCursorAdapter adapter;
    SimpleCursorAdapter sca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initialize();
         db=new DataBaseHandler(this);
        displayAllData();
  //      getData();
        filldata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(i1,1);


            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent div=new Intent(FirstActivity.this,ThirdActivityDivision.class);
                startActivity(div);
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent res=new Intent(FirstActivity.this,FourthActivityResult.class);
                startActivity(res);

            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent per=new Intent(FirstActivity.this,FifthActivityPercentage.class);
                startActivity(per);
            }
        });


    }
    private void displayAllData()
    {
        try {
            Cursor cursor = db.getAllData();
            if (cursor == null) {
                Toast.makeText(this, "Unable to generate Cursor", Toast.LENGTH_SHORT).show();
            }
            if (cursor.getCount() == 0) {
                Toast.makeText(this, "No record in DataBase", Toast.LENGTH_SHORT).show();
            }
            String[] coulmns = new String[]{db.STUDENT_ID,db.STUDENT_FIRST_NAME, db.STUDENT_LAST_NAME, db.STUDENT_STD, db.STUDENT_DIV, db.STUDENT_RESULT, db.STUDENT_PERCENTAGE};
            int[] boundTo = new int[]{R.id.tvId,R.id.tvFname, R.id.tvLname, R.id.tvStd, R.id.tvDiv, R.id.tvResult, R.id.tvPercentage};
            sca = new SimpleCursorAdapter(this, R.layout.show, cursor, coulmns, boundTo, 0);
            lv.setAdapter(sca);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e+"", Toast.LENGTH_SHORT).show();
        }
    }


    public void initialize()
    {
       lv= (ListView) findViewById(R.id.lv);
       filldata= (Button) findViewById(R.id.btnEqual50);
       div= (Button) findViewById(R.id.btnLessThna35);
       result= (Button) findViewById(R.id.btnResult);
       percentage= (Button) findViewById(R.id.btnPercentage);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1) {
            if(data!=null) {

                StudentModel um=data.getParcelableExtra("newStu");
                db.addStudent(um);
                Toast.makeText(this, "Data Inserted..", Toast.LENGTH_SHORT).show();
                displayAllData();
//                getData();


            }
        }


    }
}
