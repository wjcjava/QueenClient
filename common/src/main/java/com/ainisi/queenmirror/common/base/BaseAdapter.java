package com.ainisi.queenmirror.common.base;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/3/22.
 */

public abstract class BaseAdapter<T extends BasePresenter, E extends BaseModel> {
    public abstract int getCount();

    public abstract Object getItem(int i);

    public abstract long getItemId(int i);

    public abstract View getView(int i, View convertView, ViewGroup viewGroup);
}
