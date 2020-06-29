package com.example.bookkeeping.model.account;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AccountDao {

    @Insert
    void insert(Account account);

    @Update
    void update(Account account);

    @Delete
    void deleate(Account account);

    @Query("SELECT * FROM Account WHERE ac_num LIKE :ac_num")
    Account findByID(Long ac_num);

    @Query("SELECT * FROM ACCOUNT")
    List<Account> getAll ();

}
