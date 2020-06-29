package com.example.bookkeeping.model.account;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.bookkeeping.R;

@Entity
public class Account {
    @PrimaryKey
    @NonNull
    private Long ac_num;

    @NonNull
    private String ac_name;

    @NonNull
    // 1.銀行 2.現金 3.信用卡
    private int ac_type;

    @Ignore
    private int ac_icon;

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

    public int getAc_type() {
        return ac_type;
    }

    public void setAc_type(int ac_type) {
        this.ac_type = ac_type;
    }

    public Account(Long ac_num, String ac_name, int ac_type) {
        this.ac_num = ac_num;
        this.ac_name = ac_name;
        this.ac_type = ac_type;

        switch (ac_type) {
            case 1:
                ac_icon = R.drawable.ic_account_balance;
                break;
            case 2:
                ac_icon = R.drawable.ic_logo_money;
                break;
            case 3:
                ac_icon = R.drawable.ic_credit_card;
                break;
        }
    }
}
