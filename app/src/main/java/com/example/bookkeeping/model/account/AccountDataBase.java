package com.example.bookkeeping.model.account;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Account.class, version = 1)
public abstract class AccountDataBase extends RoomDatabase {

    abstract AccountDao accountDao();

}
