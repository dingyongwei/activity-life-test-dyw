package cn.edu.pku.dingyongwei.activitylifetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by crazy on 2016-10-21-0021.
 */

public class Activity3 extends Activity implements View.OnClickListener{

    private final static String TAG = "Activity3" ;

    private Button btn_Act3_back;
    private EditText fanhui_Act3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        initView();
    }
    private void initView(){
        btn_Act3_back = (Button)findViewById(R.id.btn_Act3_back);


        btn_Act3_back.setOnClickListener(this);
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
        intent = new Intent(Activity3.this,Activity1.class);
        String str ;
        fanhui_Act3= (EditText) findViewById(R.id.fanhui_Act3);
        str = fanhui_Act3.getText().toString();
        intent.putExtra("msg",str);
        setResult(RESULT_OK ,intent);
        finish();

    }

}
