package com.example.bookkeeping.book_keep;

import android.content.Context;

import com.example.bookkeeping.Config;
import com.example.bookkeeping.model.LocalDataBase;

import static com.google.common.base.Preconditions.checkNotNull;

public class BookKeepPresenter implements BookKeepContract.Presenter {

    private LocalDataBase localDataBase;
    private BookKeepContract.View mBookKeepView;

    BookKeepPresenter(BookKeepContract.View mBookKeepView , Context context){
        this.mBookKeepView = checkNotNull(mBookKeepView);
        localDataBase = LocalDataBase.buildDatabase(context);
        mBookKeepView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void addNewkeep() {
        mBookKeepView.showAddKeep();
    }
}
