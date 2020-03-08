package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class First_Page extends AppCompatActivity {
    private long backPressedTime;
    private Toast toast;
    String st1,st2;
    public void Start(View view)
    {
        EditText editText1 = (EditText)findViewById(R.id.First_et1);
        EditText editText2 = (EditText)findViewById(R.id.First_et2);

        if(!(editText1.getText().toString().isEmpty())&& !(editText2.getText().toString().isEmpty())) {
            Intent intent1 = new Intent(First_Page.this, MainActivity.class);
            st1=editText1.getText().toString();
            st2=editText2.getText().toString();
            intent1.putExtra("Value1",st1);
            intent1.putExtra("Value2",st2);
            startActivity(intent1);
        }
        else {
            if(editText1.getText().toString().isEmpty())
            {
                editText1.setError("First name is required!");
            }
            if(editText2.getText().toString().isEmpty())
            {
                editText2.setError("Second name is required!");
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__page);
    }

    @Override
    public void onBackPressed() {

        if(backPressedTime+2000>System.currentTimeMillis())
        {   toast.cancel();
            super.onBackPressed();
            return;
        }
        else
        {
           toast = Toast.makeText(First_Page.this,"Press again to exit",Toast.LENGTH_SHORT);
           toast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }
}
