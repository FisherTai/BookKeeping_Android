package com.example.bookkeeping;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.orhanobut.logger.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

    /**
     * 簡化的長toast
     *
     * @param context
     * @param comment
     */
    public void toastLong(Context context, String comment) {
        Toast.makeText(context, comment, Toast.LENGTH_LONG).show();
    }

    /**
     * 簡化的短toast
     *
     * @param context
     * @param comment
     */
    public void toastShort(Context context, String comment) {
        Toast.makeText(context, comment, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param context
     */
    public void initDB(Context context) {
        String jsonFuncStr = readAssetsJson(context);
        Config.getInstance().setKeepClassFromJson(jsonFuncStr);
    }


    /**
     * 讀取assets下的json數據
     *
     * @return string
     */
    private String readAssetsJson(Context context) {
        AssetManager assetManager = context.getAssets();
        InputStream is = null;
        BufferedReader br = null;
        try {
            is = assetManager.open("Func.json");
            br = new BufferedReader(new InputStreamReader(is));
            StringBuilder stringBuilder = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (br != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
