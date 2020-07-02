package com.example.bookkeeping.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bookkeeping.model.account.Account;
import com.example.bookkeeping.model.account.AccountDao;
import com.example.bookkeeping.model.bookkeep.Bookkeep;
import com.example.bookkeeping.model.bookkeep.BookkeepDao;
import com.example.bookkeeping.model.keep_class.KeepClass;
import com.example.bookkeeping.model.keep_class.KeepClassDao;

@Database(entities = {Bookkeep.class, Account.class, KeepClass.class}, version = 1)
public abstract class LocalDataBase extends RoomDatabase {

    private static LocalDataBase Instance;

    public abstract BookkeepDao bookkeepDao();

    public abstract AccountDao accountDao();

    public abstract KeepClassDao keepClassDao();

    public static LocalDataBase buildDatabase(Context context) {

        if (Instance == null) {
            Instance = Room.databaseBuilder(context.getApplicationContext(), LocalDataBase.class, "Bookkeep.db")
                    .build();
        }

        return Instance;
    }
}
