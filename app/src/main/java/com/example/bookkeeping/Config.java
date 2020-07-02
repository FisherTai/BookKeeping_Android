package com.example.bookkeeping;

import android.text.TextUtils;

import com.example.bookkeeping.model.LocalDataBase;
import com.example.bookkeeping.model.keep_class.KeepClass;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class Config {

    private LocalDataBase localDataBase;

    private static Config Instence;

    private Config() {

    }

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
            Runnable mRunnable = () -> getDataBase().keepClassDao().insert(kc);
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
