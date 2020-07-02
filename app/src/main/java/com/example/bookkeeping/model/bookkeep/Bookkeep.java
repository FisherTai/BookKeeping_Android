package com.example.bookkeeping.model.bookkeep;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Bookkeep {
    @PrimaryKey (autoGenerate = true)
    @NonNull
    private int bk_num;

    @NonNull
    private Long kc_num;

    @NonNull
    private String bk_description;

    @NonNull
    private String bk_date;

    @NonNull
    private String bk_amount;

    public int getBk_num() {
        return bk_num;
    }

    public void setBk_num(int bk_num) {
        this.bk_num = bk_num;
    }

    public Long getKc_num() {
        return kc_num;
    }

    public void setKc_num(Long kc_num) {
        this.kc_num = kc_num;
    }

    public String getBk_description() {
        return bk_description;
    }

    public void setBk_description(String bk_description) {
        this.bk_description = bk_description;
    }

    public String getBk_date() {
        return bk_date;
    }

    public void setBk_date(String bk_date) {
        this.bk_date = bk_date;
    }

    public String getBk_amount() {
        return bk_amount;
    }

    public void setBk_amount(String bk_amount) {
        this.bk_amount = bk_amount;
    }

    public Bookkeep(int bk_num, Long kc_num, String bk_description, String bk_date, String bk_amount) {
        this.bk_num = bk_num;
        this.kc_num = kc_num;
        this.bk_description = bk_description;
        this.bk_date = bk_date;
        this.bk_amount = bk_amount;
    }
}
