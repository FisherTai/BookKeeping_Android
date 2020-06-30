package com.example.bookkeeping.book_keep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.MenuItem;

import com.example.bookkeeping.BaseActivity;
import com.example.bookkeeping.MyUtil;
import com.example.bookkeeping.R;

public class BookKeepActivity extends BaseActivity {
    DrawerLayout mDreawerLayout;
    BookKeepPresenter bookKeepPresenter;

    @Override
    protected int getContenView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewData() {

        mDreawerLayout.setFitsSystemWindows(true); //讓狀態列符合滑出頁面的顏色
//        mDreawerLayout.setClipToPadding(false); // 這個屬性能消除狀態列上方的內距，就直接設置在XML了
        //記帳主頁面
        BookKeepFragment bkFragment = (BookKeepFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if(bkFragment == null){
            bkFragment = BookKeepFragment.newInstance();
            MyUtil.getInstance().addFragmentToActivity(getSupportFragmentManager(),bkFragment,R.id.contentFrame);
        }
        bookKeepPresenter = new BookKeepPresenter(bkFragment);
    }

    @Override
    protected void initLayoutView() {
        super.initLayoutView();
        mDreawerLayout = findViewById(R.id.drawer_layout);
    }


    @Override
    protected void initToolBar() {
        super.initToolBar();
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDreawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
