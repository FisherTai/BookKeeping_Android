package com.example.bookkeeping.model.keep_class;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.bookkeeping.Config;
import com.example.bookkeeping.R;

@Entity
public class KeepClass {
    private static final String TAG = "KeepClass";

    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo
    private int kc_num;

    @NonNull
    private String kc_name;

    @NonNull
    private int kc_type;

    @NonNull
    private int icon;

    public int getKc_num() {
        return kc_num;
    }

    public void setKc_num(int kc_num) {
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

    public KeepClass(@NonNull int kc_num, String kc_name, int kc_type) {
        this.kc_num = kc_num;
        this.kc_name = kc_name;
        this.kc_type = kc_type;
    }


    public void manualSetIcon(int kc_num){
        //預設類別Inser之前，需手動設置圖示
        switch (kc_num){
            case Config.ID_MEALS:
                icon = R.drawable.class_restaurant_menu_black_24dp;
                break;
            case Config.ID_SNACK:
                icon = R.mipmap.baseline_fastfood_black_48dp;
                break;
            case Config.ID_CLOTHING:
                icon = R.mipmap.class_clothing_black;
                break;
            case Config.ID_RESIDENCE:
                icon = R.drawable.class_home_black_24dp;
                break;
            case Config.ID_TRAFFIC:
                icon = R.drawable.class_directions_car_black_24dp;
                break;
            case Config.ID_SHOPPING:
                icon = R.drawable.class_shopping_cart_black_24dp;
                break;
            case Config.ID_TRAVEL:
                icon = R.mipmap.class_travel_black;
                break;
            case Config.ID_MEDICAL:
                icon = R.drawable.class_home_black_24dp;
                break;
            case Config.ID_PHONE:
                icon = R.drawable.class_phone_iphone_black_24dp;
                break;
            case Config.ID_DEBT:
                icon = R.drawable.class_payment_black_24dp;
                break;
            case Config.ID_GIFT:
                icon = R.drawable.class_card_giftcard_black_24dp;
                break;
            case Config.ID_BAD_ACCOUNT:
                icon = R.drawable.class_mode_edit_black_24dp;
                break;
            case Config.ID_SALARY:
                icon = R.drawable.class_business_black_24dp;
                break;
            case Config.ID_BONUS:
                icon = R.drawable.ic_money;
                break;
            case Config.ID_RECEIVE_GIFT:
                icon = R.drawable.class_card_giftcard_black_24dp;
                break;
        }
    }
    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }
}
