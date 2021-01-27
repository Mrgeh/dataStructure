package com.gehang.datastructure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button btn01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn01=findViewById(R.id.btn_01);
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename="file:///C:/Users/gehang/OneDrive/%E6%96%87%E6%A1%A3/WeChat%20Files/wxid_otg7hqxju0dv22/FileStorage/File/2021-01/%E7%AC%94%E8%AF%95%E9%A2%98%E7%AD%94%E6%A1%88%E6%9B%B4%E6%AD%A3.pdf";

            }
        });

    }

}
