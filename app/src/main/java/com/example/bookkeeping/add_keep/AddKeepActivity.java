package com.example.bookkeeping.add_keep;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookkeeping.BaseActivity;
import com.example.bookkeeping.Config;
import com.example.bookkeeping.R;
import com.example.bookkeeping.book_keep.BookKeepFragment;
import com.example.bookkeeping.model.keep_class.KeepClass;

import java.util.List;

public class AddKeepActivity extends BaseActivity {

    private Spinner accountSp;
    private RecyclerView classRv;
    private List<KeepClass> classList;

    @Override
    protected int getContenView() {
        return R.layout.activity_add_keep;
    }

    @Override
    protected void initLayoutView() {
        super.initLayoutView();
        accountSp = findViewById(R.id.sp_accountlist);
        classRv = findViewById(R.id.rv_class);
    }

    @Override
    protected void initViewData() {
        //設定帳戶的Spinner
        ArrayAdapter<CharSequence> aAdapter =
                ArrayAdapter.createFromResource(this, R.array.account_array, R.layout.support_simple_spinner_dropdown_item);
        accountSp.setAdapter(aAdapter);

        //測試回傳到BookKeep頁面的訊息
        setResult(BookKeepFragment.ADD_SUCCESS);


        Runnable mRunnable = () -> {
            classList = Config.getInstance().getDataBase().keepClassDao().getAll();
            classRv.setAdapter(new ClassAdapter(classList));
        };
        new Thread(mRunnable).start();

        classRv.setHasFixedSize(true);
        classRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

    }


    private class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder> {

        private List<KeepClass> classList;
        private int selectedItem = -1;

        public ClassAdapter(List<KeepClass> classList) {
            this.classList = classList;
        }

        @NonNull
        @Override
        public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_class_item, parent, false);
            return new ClassViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
            final KeepClass kc = classList.get(position);
            holder.className.setText(kc.getKc_name());
            if (kc.getIcon() != 0) {
                holder.classIcon.setImageResource(kc.getIcon());
            } else {
                holder.classIcon.setImageResource(R.drawable.ic_logo_money);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.classIcon.setBackground(getDrawable(R.drawable.bg_item_select));
///////////////////////////////////////////////////////////////////
                    if (selectedItem == position) {
                        ClassViewHolder vhNew = (ClassViewHolder) classRv.findViewHolderForLayoutPosition(selectedItem);
                        vhNew.classIcon.setImageResource(R.drawable.bg_item_select);
                        selectedItem = -1;
                    } else if (selectedItem != -1) {
                        ClassViewHolder couponVH = (ClassViewHolder) classRv.findViewHolderForLayoutPosition(selectedItem);
                        if (couponVH != null) {//还在屏幕里
                            couponVH.classIcon.setImageResource(R.drawable.bg_item_not_select);
                        } else {
                            //些极端情况，holder被缓存在Recycler的cacheView里，
                            //此时拿不到ViewHolder，但是也不会回调onBindViewHolder方法。所以add一个异常处理
                            notifyItemChanged(selectedItem);
                        }
                        //设置新Item的勾选状态
                        selectedItem = position;
                        ClassViewHolder vhNew = (ClassViewHolder) classRv.findViewHolderForLayoutPosition(selectedItem);
                        vhNew.classIcon.setImageResource(R.drawable.bg_item_select);
                    } else if (selectedItem == -1) {
                        ClassViewHolder couponVH = (ClassViewHolder) classRv.findViewHolderForLayoutPosition(position);
                        //设置新Item的勾选状态
                        selectedItem = position;
                        couponVH.classIcon.setImageResource(R.drawable.bg_item_not_select);
                    }
                    ///////////////////////////////////////////////////////////////////
                }
            });

        }

        @Override
        public int getItemCount() {
            return classList.size();
        }

        class ClassViewHolder extends RecyclerView.ViewHolder {

            private TextView className;
            private ImageView classIcon;

            public ClassViewHolder(@NonNull View itemView) {
                super(itemView);
                className = itemView.findViewById(R.id.tv_class_name);
                classIcon = itemView.findViewById(R.id.iv_class_icon);
            }
        }
    }
}
