package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ((TextView) findViewById(R.id.detail_tv)).setText(getIntent().getStringExtra("content"));
    }
}
