package com.example.dadabhagwan.studentinformationsystemcrud;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dadabhagwan.studentinformationsystemcrud.pojo.StudentModel;

public class SecondActivity extends Activity {

    EditText fn,ln,std,div,res,per;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialize();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                StudentModel student=new StudentModel();
                student.setFirstName(fn.getText().toString());
                student.setLasttName(ln.getText().toString());
                student.setDiv(div.getText().toString());
                student.setStd(std.getText().toString());
                student.setResult(res.getText().toString());
                student.setPercentage(per.getText().toString());
                Intent my=new Intent(SecondActivity.this,FirstActivity.class);
                my.putExtra("newStu",student);
                //       my.putExtra("pos1",position);
                setResult(RESULT_OK,my);
                finish();




            }
        });


    }
    public void initialize()
    {
       fn= (EditText) findViewById(R.id.etFirstName);
        ln= (EditText) findViewById(R.id.etLastName);
        std= (EditText) findViewById(R.id.etStd);
        div= (EditText) findViewById(R.id.etDiv);
        res= (EditText) findViewById(R.id.etResult);
        per= (EditText) findViewById(R.id.etPercentage);
        save= (Button) findViewById(R.id.btnSave);
    }
}
