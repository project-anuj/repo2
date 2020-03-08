package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int visible=0;
    int match=0;
    int match1=0;
    int match2=0;
    int draw=0;
    int a[]={2,2,2,2,2,2,2,2,2};
    int b[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int turn=0;
    Boolean gameState=true;
    public void play(View view)
    {
        ImageView imageView=(ImageView)view;
        match+=1;
        int t = Integer.parseInt(imageView.getTag().toString());
        if(a[t]==2 && gameState) {
            imageView.setTranslationY(-1000f);
            if (turn == 0) {
                imageView.setImageResource(R.drawable.star2);
                a[t] = turn;
                turn = 1;

            } else {
                imageView.setImageResource(R.drawable.star1);
                a[t] = turn;
                turn = 0;
            }
            imageView.animate().translationYBy(1000f).rotation(1800).setDuration(100);

            for(int[] win:b)
            {
                if(a[win[0]]==a[win[1]] && a[win[1]]==a[win[2]] && a[win[0]]!=2)
                {   String name="";
                    TextView textView1=(TextView)findViewById(R.id.playAgainTv1);
                    gameState=false;
                    if(a[win[0]]==0)
                    {
                        name=getIntent().getExtras().getString("Value1");
                        match1+=1;
                    }
                    else if(a[win[0]]==1)
                    {   match2+=1;
                        name=getIntent().getExtras().getString("Value2");

                    }


                    LinearLayout linearLayout=(LinearLayout)findViewById(R.id.playAgainLayout);
                    linearLayout.setVisibility(View.VISIBLE);
                    textView1.setText(name+" has Won!!");
                }
                else
                {   int c=0;
                    for(int j=0;j<a.length;j++)
                    {
                        if(a[j]<2)
                            c=c+1;
                    }
                    if(c==9)
                    {   TextView textView1=(TextView)findViewById(R.id.playAgainTv1);
                        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.playAgainLayout);
                        linearLayout.setVisibility(View.VISIBLE);
                        textView1.setText("It's  Draw");
                        draw+=1;
                    }
                }
            }

        }
    }
    public void playAgain(View view)
    {
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.playAgainLayout);
        linearLayout.setVisibility(View.INVISIBLE);

         for(int i=0;i<a.length;i++)
         {
             a[i]=2;
         }
         GridLayout gridLayout = (GridLayout)findViewById(R.id.grid1);
         for(int i=0;i<9;i++)
         {
             ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
         }
         gameState=true;
         turn=0;
    }
    public void exit(View view)
    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure want to do this");
        builder.setCancelable(true);
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater= getMenuInflater();
//        menuInflater.inflate(R.menu.main_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId())
//        {
//            case R.id.about:
//                System.out.println("about");
//                return true;
//            case R.id.winnings:
//                LinearLayout linearLayout=(LinearLayout)findViewById(R.id.aboutLayout);
//                if(visible%2==0) {
//                    linearLayout.setVisibility(View.VISIBLE);
//                    visible+=1;
//                }
//                else
//                {
//                    linearLayout.setVisibility(View.INVISIBLE);
//                    visible+=1;
//                }
//                String name1="",name2="";
//                name1=getIntent().getExtras().getString("Value1");
//                name2=getIntent().getExtras().getString("Value2");
//                TextView textView1=(TextView)findViewById(R.id.nameTv1);
//                textView1.setText(name1);
//                TextView textView6=(TextView)findViewById(R.id.nameTv6);
//                textView1.setText(name2);
//                TextView textView4=(TextView)findViewById(R.id.nameTv4);
//                textView1.setText(Integer.toString(match));
//                TextView textView5=(TextView)findViewById(R.id.nameTv5);
//                textView1.setText(Integer.toString(match1));
//                TextView textView9=(TextView)findViewById(R.id.nameTv9);
//                textView1.setText(Integer.toString(match));
//                TextView textView10=(TextView)findViewById(R.id.nameTv10);
//                textView1.setText(Integer.toString(match2));
//
//                return true;
//            default:
//                System.out.println("Default");
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
