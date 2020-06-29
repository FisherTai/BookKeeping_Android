package com.example.bookkeeping.model.bookkeep;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Bookkeep {
    @PrimaryKey
    private String bk_num;
    private String bc_num;
    private String bk_description;
    private String bk_date;
    private String bk_amount;

}
