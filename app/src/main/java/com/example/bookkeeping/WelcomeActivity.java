package com.example.bookkeeping;

import android.content.Intent;

import com.example.bookkeeping.book_keep.BookKeepActivity;
import com.example.bookkeeping.model.LocalDataBase;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class WelcomeActivity extends BaseActivity {


    @Override
    protected int getContenView() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initViewData() {
        Logger.addLogAdapter(new AndroidLogAdapter());
        MyUtil.getInstance().initDB(getApplicationContext());
//        LocalDataBase.buildDatabase(getApplicationContext()).keepClassDao().insert();
        Intent intent = new Intent(WelcomeActivity.this, BookKeepActivity.class);
        startActivity(intent);
        finish();
    }


}
