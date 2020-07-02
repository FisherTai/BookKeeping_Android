package com.example.bookkeeping.model.keep_class;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class KeepClass {
    private static final String TAG = "KeepClass";

    @PrimaryKey
    @NonNull
    @ColumnInfo
    private Long kc_num;

    @NonNull
    private String kc_name;

    @NonNull
    private int kc_type;

    @Ignore
    private int icon;

    public Long getKc_num() {
        return kc_num;
    }

    public void setKc_num(Long kc_num) {
        this.kc_num = kc_num;
    }

    public String getKc_name() {
        return kc_name;
    }

    public void setKc_name(String kc_name) {
        this.kc_name = kc_name;
    }

    public int getKc_type() {
        return kc_type;
    }

    public void setKc_type(int kc_type) {
        this.kc_type = kc_type;
    }

    public KeepClass(@NonNull Long kc_num, String kc_name, int kc_type) {
        this.kc_num = kc_num;
        this.kc_name = kc_name;
        this.kc_type = kc_type;
    }
}
