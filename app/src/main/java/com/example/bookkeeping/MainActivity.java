package com.example.bookkeeping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.bookkeeping.book_keep.BookKeepFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends BaseActivity {
    DrawerLayout mDreawerLayout;

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
