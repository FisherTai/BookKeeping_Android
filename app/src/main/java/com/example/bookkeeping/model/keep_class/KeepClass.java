package com.example.bookkeeping.model.keep_class;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class KeepClass {
    @PrimaryKey
    private String kc_num;
    private String kc_name;
    private String kc_type;
}
