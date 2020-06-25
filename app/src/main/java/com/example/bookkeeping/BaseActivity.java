package com.example.bookkeeping;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContenView());
        //设置状态列颜色
        setStatusBarColor(Color.TRANSPARENT);
        initLayoutView();
        initViewData();
    }

    protected abstract int getContenView();

    protected void initLayoutView() {
        //設定ToolBar
        initToolBar();
    }

    ;

    protected abstract void initViewData();

    protected void initToolBar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    ;


    //設置透明狀態列
    public void setStatusBarColor(int color) {
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); // 確認取消半透明設置。
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN // 全螢幕顯示，status bar 不隱藏，activity 上方 layout 會被 status bar 覆蓋。
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE); // 配合其他 flag 使用，防止 system bar 改變後 layout 的變動。
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); // 跟系統表示要渲染 system bar 背景。
        window.setStatusBarColor(color);
    }
}


