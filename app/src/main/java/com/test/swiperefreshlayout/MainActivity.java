package com.test.swiperefreshlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private TextView tv_simple;
    private SwipeRefreshLayout srl_simple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_simple = (TextView) findViewById(R.id.tv_simple);
        srl_simple = (SwipeRefreshLayout) findViewById(R.id.srl_simple);
        srl_simple.setOnRefreshListener(this);

        srl_simple.setColorSchemeResources(R.color.red);

    }

    @Override
    public void onRefresh() {
        tv_simple.setText("正在刷新");
        mHandler.postDelayed(mRefresh, 2000);
    }

    private Handler mHandler = new Handler();
    private Runnable mRefresh = new Runnable() {
        @Override
        public void run() {
            tv_simple.setText("刷新完成");
            srl_simple.setRefreshing(false);
        }
    };

}

