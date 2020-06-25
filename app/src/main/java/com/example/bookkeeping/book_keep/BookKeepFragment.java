package com.example.bookkeeping.book_keep;

import android.view.View;

import com.example.bookkeeping.BaseFragment;
import com.example.bookkeeping.R;

public class BookKeepFragment extends BaseFragment {

    private static BookKeepFragment instance;

    public static BookKeepFragment newInstance() {
        if (instance == null) {
            instance = new BookKeepFragment();
        }
        return instance;
    }


    @Override
    protected int getContenView() {
        return R.layout.fragment_book_keep;
    }

    @Override
    protected void initLayoutView(View view) {

    }

    @Override
    protected void initViewData() {

    }
}
