package com.example.bookkeeping.book_keep;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookkeeping.BaseFragment;
import com.example.bookkeeping.R;
import com.example.bookkeeping.add_keep.AddKeepActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.google.common.base.Preconditions.checkNotNull;

public class BookKeepFragment extends BaseFragment implements BookKeepContract.View {

    private static BookKeepFragment instance;
    private BookKeepContract.Presenter mPresenter;

    public static final int AddKeep = 10;
    public static final int ADD_SUCCESS = 11;
    public static final int ADD_FAIL = 12;

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
                mPresenter.addNewkeep()
        );
    }

    @Override
    protected void initViewData() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode != AddKeep) {
            return;
        }
        switch (resultCode) {
            case ADD_SUCCESS:

                break;
            case ADD_FAIL:

                break;
        }

    }

    @Override
    public void setPresenter(@NonNull BookKeepContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showAddKeep() {
        Intent intent = new Intent(getActivity(), AddKeepActivity.class);
        startActivityForResult(intent, AddKeep);
    }
}
