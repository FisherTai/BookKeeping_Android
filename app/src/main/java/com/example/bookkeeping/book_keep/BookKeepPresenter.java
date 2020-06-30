package com.example.bookkeeping.book_keep;

import static com.google.common.base.Preconditions.checkNotNull;

public class BookKeepPresenter implements BookKeepContract.Presenter {

    private BookKeepContract.View mBookKeepView;

    BookKeepPresenter(BookKeepContract.View mBookKeepView){
        this.mBookKeepView = checkNotNull(mBookKeepView);
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
