package com.example.bookkeeping.model.keep_class;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class KeepClass {

    @PrimaryKey
    @NonNull
    private Long kc_num;

    @NonNull
    private String kc_name;

    @NonNull
    private String kc_type;

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

    public String getKc_type() {
        return kc_type;
    }

    public void setKc_type(String kc_type) {
        this.kc_type = kc_type;
    }

    public KeepClass(@NonNull Long kc_num, String kc_name, String kc_type) {
        this.kc_num = kc_num;
        this.kc_name = kc_name;
        this.kc_type = kc_type;
    }
}
