package com.example.bookkeeping.add_keep;

import com.example.bookkeeping.BaseActivity;
import com.example.bookkeeping.R;

public class AddKeepActivity extends BaseActivity {
    @Override
    protected int getContenView() {
        return R.layout.activity_add_keep;
    }

    @Override
    protected void initViewData() {
        setResult(1);
    }
}
