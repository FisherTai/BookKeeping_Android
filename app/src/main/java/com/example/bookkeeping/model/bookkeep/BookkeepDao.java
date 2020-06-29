package com.example.bookkeeping.model.bookkeep;

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
public interface BookkeepDao {

    @Insert
    void insert(Bookkeep bookkeep);

    @Update
    void update(Bookkeep bookkeep);

    @Delete
    void deleate(Bookkeep bookkeep);

    @Query("SELECT * FROM BOOKKEEP WHERE BK_NUM LIKE :bk_num")
    Bookkeep findByID(String bk_num);

    @Query("SELECT * FROM BOOKKEEP")
    List<Bookkeep> getAll();

}
