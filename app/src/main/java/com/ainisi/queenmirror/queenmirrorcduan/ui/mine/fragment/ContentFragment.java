package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 视频列表
 *
 * @author jiangchao
 *         created at 2018/9/3 下午3:53
 */
public class ContentFragment extends Fragment {

    @Bind(R.id.rv_video_list)
    RecyclerView rvVideoList;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private View mView;

    /**
     * key值
     */
    private static final String KEY = "EXTRA";

    private String title;

    /**
     * 在这里我们提供一个静态的方法来实例化PageFragment
     * 在这里我们传入一个参数，用来得到title，然后我们拿到这个title设置给内容
     *
     * @param extra
     * @return
     */
    public static ContentFragment newInstance(String extra) {
        //利用bundle传值
        Bundle bundle = new Bundle();
        bundle.putString(KEY, extra);
        //实例化
        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    /* @Override
     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         Bundle bundle = getArguments();
         if (bundle != null) {
             title = bundle.getString(KEY);
         }
     }
 */
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            title = bundle.getString(KEY);
        }
        if (mView == null) {
            mView = inflater.inflate(R.layout.page_fragment, container, false);
        }
        initView();
        ButterKnife.bind(this, mView);
        return mView;
    }


    public void initView() {
//        mTextView = mView.findViewById(R.id.text_fragment);
//        mTextView.setText(title);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
