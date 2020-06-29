package com.example.bookkeeping.book_keep;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.annotation.Nullable;

import com.example.bookkeeping.BaseFragment;
import com.example.bookkeeping.R;
import com.example.bookkeeping.add_keep.AddKeepActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BookKeepFragment extends BaseFragment {

    private static BookKeepFragment instance;

    private static final String TAG = "BookKeepFragment";
    private static final int BookKeepToAddKeep = 0;
    private static final int ADD_SUCCESS = 1;
    private static final int ADD_FAIL = 2;

    private FloatingActionButton fab;

    public static BookKeepFragment newInstance() {
        if (instance == null) {
            instance = new BookKeepFragment();
        }
        return instance;
    }


    @Override
    protected int getContenView() {
        return R.layout.fragment_book_keep;
    }

    @Override
    protected void initLayoutView(View view) {
        fab = getActivity().findViewById(R.id.fab_add);
        fab.setScaleType(ImageView.ScaleType.CENTER); //fab的圖標大小会自动调整成24dp,在这另外手动调整。
        fab.setOnClickListener(v ->
                jump()
        );
    }

    private void jump(){
        Intent intent = new Intent(getActivity(), AddKeepActivity.class);
        startActivityForResult(intent,BookKeepToAddKeep);
    }

    @Override
    protected void initViewData() {


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(resultCode){
            case ADD_SUCCESS:
                Log.d(TAG, "onActivityResult: ADD_SUCCESS");
                break;
            case ADD_FAIL:
                Log.d(TAG, "onActivityResult: ADD_FAIL");
                break;
        }

    }
}
