package cn.edu.pku.dingyongwei.activitylifetest;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by crazy on 2016-10-21-0021.
 */

public class Activity1 extends Activity implements View.OnClickListener{

    private final static String TAG = "Activity1" ;

    private Button btn_Act2;
    private Button btn_Act3;
    private EditText save ;
    private TextView fanhui;


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        Log.i(TAG ,"onCreate");


        setContentView(R.layout.activity1);
        initView();
        SharedPreferences prefs = getPreferences(0);
        String restoredText = prefs.getString("text", null);
        if (restoredText != null) {
            save.setText(restoredText);
        }

    }

    private void initView(){
        btn_Act2 = (Button)findViewById(R.id.btn_act2);
        btn_Act3 = (Button)findViewById(R.id.btn_Act3);
        save =(EditText)findViewById(R.id.save);
        save.setText("");
        fanhui = (TextView)findViewById(R.id.fanhui);
        btn_Act2.setOnClickListener(this);
        btn_Act3.setOnClickListener(this);

    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG,"onRestart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        SharedPreferences.Editor editor = getPreferences(0).edit();
        editor.clear();
        editor.commit();


        Log.i(TAG,"onDestroy");
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        SharedPreferences.Editor editor = getPreferences(0).edit();
        editor.putString("text",save.getText().toString());
        editor.commit();

        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"onRestoreInstanceState");
    }

    public void onClick(View v){
        Intent intent ;
        switch(v.getId()){
            case R.id.btn_act2 :
                intent = new Intent(Activity1.this,Activity2.class);
                startActivityForResult(intent ,1);
 //               startActivity(intent);
                break;
            case R.id.btn_Act3:
                intent = new Intent(Activity1.this,Activity3.class);
                startActivityForResult(intent ,3);
                break;
            default:
                break;
        }
    }
    protected void onActivityResult(int requestCode ,int resultCode ,Intent data){
        if(requestCode==3 && resultCode==RESULT_OK){
            String str = data.getStringExtra("msg");
            fanhui.setText(str.toCharArray(),0,str.length());
        }
    }
}
