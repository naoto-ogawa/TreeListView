package com.example.dnd01.com.example.list;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by ogawanaoto on 2015/11/23.
 */
public class TreeListView extends ListView implements AdapterView.OnItemClickListener {

    public TreeListView(Context context) {
        super(context);
        setOnItemClickListener(this);
    }

    public TreeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnItemClickListener(this);
    }

    public TreeListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnItemClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TreeListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        invalidateViews();
        TreeAdapter ta = (TreeAdapter)adapterView.getAdapter();
        ta.expandOrCollapse(i);

    }

}
