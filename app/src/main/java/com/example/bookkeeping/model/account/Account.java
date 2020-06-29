package com.example.bookkeeping.model.account;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Account {
    @PrimaryKey
    @NonNull
    private Long ac_num;

    @NonNull
    private String ac_name;

    @NonNull
    private String ac_type;

    public Long getAc_num() {
        return ac_num;
    }

    public void setAc_num(Long ac_num) {
        this.ac_num = ac_num;
    }

    public String getAc_name() {
        return ac_name;
    }

    public void setAc_name(String ac_name) {
        this.ac_name = ac_name;
    }

    public String getAc_type() {
        return ac_type;
    }

    public void setAc_type(String ac_type) {
        this.ac_type = ac_type;
    }

    public Account(Long ac_num, String ac_name, String ac_type) {
        this.ac_num = ac_num;
        this.ac_name = ac_name;
        this.ac_type = ac_type;
    }
}
