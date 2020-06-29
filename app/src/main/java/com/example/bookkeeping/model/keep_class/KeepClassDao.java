package com.example.bookkeeping.model.keep_class;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Update;
import androidx.sqlite.db.SupportSQLiteQuery;

import com.example.bookkeeping.model.account.Account;

import java.util.List;

@Dao
public interface KeepClassDao {

    @Insert
    void insert(KeepClass keepClass);

    @Update
    void update(KeepClass keepClass);

    @Delete
    void deleate(KeepClass keepClass);

    @Query("SELECT * FROM KeepClass WHERE kc_num LIKE :kc_num")
    KeepClass findByID(String kc_num);

    @Query("SELECT * FROM KeepClass")
    List<KeepClass> getAll();

}
