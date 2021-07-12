package com.application.trialapplicationforxd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean isVis;
    public Button btn;
    public Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.textView).setVisibility(View.GONE);
        isVis=false;
        btn = (Button)findViewById(R.id.button2);
        btn1 = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onSearchBtnClick(v);
            }
        });
        buttonTouch(btn1, R.drawable.search_touched,R.drawable.search);
        buttonTouch(btn, R.drawable.stylish_button_touched,R.drawable.stylish_button);
    }
    public void onSearchBtnClick(View view){
        if(isVis) {
            findViewById(R.id.textView).setVisibility(View.GONE);
        } else{
            findViewById(R.id.textView).setVisibility(View.VISIBLE);
        }
        isVis=!isVis;
    }
    @SuppressLint("ClickableViewAccessibility")
    private void buttonTouch(Button button, int resourceIDOnTouch, int resourceIDOnRelease){
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        v.setBackground((getDrawable(resourceIDOnRelease)));
                        break;
                    case MotionEvent.ACTION_DOWN:
                        v.setBackground((getDrawable(resourceIDOnTouch)));
                        break;
                }
                return false;
            }
        });
    }



}