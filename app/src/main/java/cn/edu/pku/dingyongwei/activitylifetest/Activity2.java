package cn.edu.pku.dingyongwei.activitylifetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by crazy on 2016-10-21-0021.
 */

public class Activity2 extends Activity implements View.OnClickListener{

    private final static String TAG = "Activity2" ;

    private Button btn_Act2_back;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        Log.i(TAG ,"onCreate");
        initView();
    }

    private void initView(){
        btn_Act2_back = (Button)findViewById(R.id.btn_Act2_back);
        btn_Act2_back.setOnClickListener(this);

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
        Log.i(TAG,"onDestroy");
    }

    public void onClick(View v){
        Intent intent ;
        intent = new Intent(Activity2.this,Activity1.class);
        startActivity(intent);
        finish();


    }
}
