package com.example.bookkeeping;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MyUtil {

    private static MyUtil instance;

    private MyUtil() {
    }

    public static MyUtil getInstance() {

        if (null == instance) {
            instance = new MyUtil();
        }
        return instance;
    }

    public void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                      @NonNull BaseFragment fragment,
                                      int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }


    public void toastLong(Context context, String comment) {
        Toast.makeText(context, comment, Toast.LENGTH_LONG).show();
    }

    public void toastShort(Context context, String comment) {
        Toast.makeText(context, comment, Toast.LENGTH_SHORT).show();
    }

}
