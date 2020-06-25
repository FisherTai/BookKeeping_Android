package com.example.bookkeeping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContenView(), container, false);
        initLayoutView(view);
        initViewData();
        return view;
    }



    protected abstract int getContenView();
    protected abstract void initLayoutView(View view);  //初始化View
    protected abstract void initViewData(); //設定View的值



}
