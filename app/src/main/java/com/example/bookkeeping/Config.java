package com.example.bookkeeping;

import android.text.TextUtils;

import com.example.bookkeeping.model.LocalDataBase;
import com.example.bookkeeping.model.keep_class.KeepClass;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.orhanobut.logger.Logger;


public class Config {

    private LocalDataBase localDataBase;

    private static Config Instence;

    private Config() {

    }

    //Model相關的預設值
    public final static int ID_MEALS = 101;
    public final static int ID_SNACK = 102;
    public final static int ID_CLOTHING = 103;
    public final static int ID_RESIDENCE = 104;
    public final static int ID_TRAFFIC = 105;
    public final static int ID_SHOPPING = 106;
    public final static int ID_TRAVEL = 107;
    public final static int ID_MEDICAL = 108;
    public final static int ID_PHONE = 109;
    public final static int ID_DEBT = 110;
    public final static int ID_GIFT = 111;
    public final static int ID_BAD_ACCOUNT = 112;
    public final static int ID_SALARY = 201;
    public final static int ID_BONUS = 202;
    public final static int ID_RECEIVE_GIFT = 203;




    public static Config getInstance() {
        if (Instence == null) {
            Instence = new Config();
        }
        return Instence;
    }

    public LocalDataBase getDataBase(){
        if (localDataBase == null){
            localDataBase = LocalDataBase.buildDatabase(AppMain.getApp().getApplicationContext());
        }
        return localDataBase;
    }

    void setKeepClassFromJson(String jsonFuncStr) {

        if (TextUtils.isEmpty(jsonFuncStr)) {
            return;
        }
//        JSONArray kcJsonArray = null;
//            JSONObject jsonObject = new JSONObject(jsonFuncStr);
//            kcJsonArray = jsonObject.optJSONArray("keepclass");
//            if (kcJsonArray != null) {
//                for (int i = 0; i < kcJsonArray.length(); i++) {
//                    JSONObject keepClass = (JSONObject) kcJsonArray.opt(i);
//                    KeepClass keepitem = new KeepClass(keepClass.optLong("kc_num"),keepClass.getString("kc_name"),keepClass.getInt("kc_type"));
//                    Log.d(TAG, "getKeepClassFromJson: " + gson.toJson(keepitem));
//                }
//            }
        Gson gson = new Gson();
        JsonObject gsonObject = gson.fromJson(jsonFuncStr, JsonObject.class);
        JsonArray garr = gsonObject.getAsJsonArray("keepclass");
        KeepClass[] kcArray = gson.fromJson(garr, KeepClass[].class);

        for (KeepClass kc : kcArray) {
            Runnable mRunnable = () -> {
                kc.manualSetIcon(kc.getKc_num());
                Logger.d(new Gson().toJson(kc));
                getDataBase().keepClassDao().insert(kc);
            };
            new Thread(mRunnable).start();
        }
//        Callable<String> callable = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                 localDataBase.keepClassDao().insert(kcArray[0]);
//                 return "";
//            }
//        };
//        Future<String> future = Executors.newSingleThreadExecutor().submit(callable);
//        try {
//            future.get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
