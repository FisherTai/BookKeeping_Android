package com.example.bookkeeping.book_keep;

import com.example.bookkeeping.BasePresenter;
import com.example.bookkeeping.BaseView;

public interface BookKeepContract {

    interface View extends BaseView<Presenter> {

        void showAddKeep();

    }


    interface Presenter extends BasePresenter {

        void addNewkeep();

    }

}
