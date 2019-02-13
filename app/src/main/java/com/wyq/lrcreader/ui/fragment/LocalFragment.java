package com.wyq.lrcreader.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.wyq.lrcreader.R;
import com.wyq.lrcreader.db.entity.SongEntity;
import com.wyq.lrcreader.model.viewmodel.LocalSongsViewModel;
import com.wyq.lrcreader.model.viewmodel.ViewModelFactory;
import com.wyq.lrcreader.ui.fragment.base.BaseLazyLoadFragment;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @author Uni.W
 * @date 2019/1/20 11:58
 */
public class LocalFragment extends BaseLazyLoadFragment {

    @BindView(R.id.local_fragment_recycler_view)
    public RecyclerView recyclerView;


    public static LocalFragment newInstance() {
        return new LocalFragment();
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewModelFactory factory = new ViewModelFactory(getActivity().getApplication());

        LocalSongsViewModel localSongsViewModel = ViewModelProviders.of(this, factory).get(LocalSongsViewModel.class);

        localSongsViewModel.getObservableLocalSong()
                .observe(this, new Observer<List<SongEntity>>() {
                    @Override
                    public void onChanged(List<SongEntity> songs) {

                    }
                });

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void retry() {

    }

    @Override
    public int attachLayoutRes() {
        return R.layout.local_fragment_layout;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(View view) {

    }
}
