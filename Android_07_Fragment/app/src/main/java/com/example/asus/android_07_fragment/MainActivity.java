package com.example.asus.android_07_fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,QuestionFragment.OnSendResult {
    private int mCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_add_fragment).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_add_fragment:
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//
//                QuestionFragment fragment = new QuestionFragment();
//                transaction.replace(R.id.frame_content, fragment);
//                transaction.commit();
                mCount++;
                QuestionFragment fragment = QuestionFragment.newInstance(mCount);
                getSupportFragmentManager().beginTransaction().add(R.id.frame_content, fragment).addToBackStack(null).commit();
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        // getBackStackEntryCount đếm số lượng fragment đc add
        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
            mCount--;
        }
        else super.onBackPressed();
    }

    @Override
    public void sendResult(int Result) {
        Toast.makeText(this, Result + "",Toast.LENGTH_SHORT).show();
    }
}
