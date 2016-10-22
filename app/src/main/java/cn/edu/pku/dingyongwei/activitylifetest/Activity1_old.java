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

public class Activity1_old extends Activity implements View.OnClickListener{

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
        if(null !=  savedInstanceState)
        {
            String StrTest = savedInstanceState.getString("message");

            String saveTest = "         在onCreate中恢复了onSaveInstanceState中保存的"+ "“"+savedInstanceState.getString("message")+"”";

             Log.i(TAG, saveTest);

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
        Log.i(TAG,"onDestroy");
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("message", save.getText().toString());

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
                intent = new Intent(Activity1_old.this,Activity2.class);
                startActivityForResult(intent ,1);
 //               startActivity(intent);
                break;
            case R.id.btn_Act3:
                intent = new Intent(Activity1_old.this,Activity3.class);
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
