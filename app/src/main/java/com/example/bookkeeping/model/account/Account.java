package com.example.bookkeeping.model.account;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//(直接使用類別名作為表名，可自定義(tableName = "xxxxxx")
@Entity
public class Account {
    //標註為主鍵
    @PrimaryKey
//    @ColumnInfo (name = "bk_num") //欄位名也可自定義
    private String ac_num;
    private String ac_name;
    private String ac_type;

}
