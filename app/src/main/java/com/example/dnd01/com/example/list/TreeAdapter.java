package com.example.dnd01.com.example.list;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.dnd01.R;
import com.example.dnd01.com.example.data.Node;

public class TreeAdapter extends BaseAdapter {

    private Context context;
    private Node root;

    public TreeAdapter(Context context, Node root) {
        this.context = context;
        this.root = root;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int i) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return root.getChildren().size();
    }

    @Override
    public Object getItem(int i) {
        return root.getChildren().get(i);
    }

    private Node getNode(int i) {
        return (Node)getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return getNode(i).getId();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = null;

        if (view == null) {
            v =  ((Activity)context).getLayoutInflater().inflate(R.layout.row, null);
            ((TextView)v.findViewById(R.id.textView)).setTypeface(Typeface.MONOSPACE);
        } else {
            v = view;
        }

        updateView(i, v);

        return v;
    }

    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public void expand(int i) {
        getNode(i).expand();
        notifyDataSetChanged();
    }

    public boolean expandOrCollapse(int i) {
        Node n = getNode(i);
        boolean ret = n.isExpand() ? n.collapse() : n.expand();
        notifyDataSetChanged();
        return ret;
    }

    private String getNest(Node n) {
        int l = n.getLevel();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l - 1; i++) {
            sb.append("  ");
        }
        return sb.toString() + ": ";
    }

    private void updateView(int i, View v) {
        Node node = getNode(i);
        if (node == null) {
            return;
        }
        String indicator = "   ";
        if (node.hasChildren()) {
            if (node.isCollapse()) {
                indicator = "[+]";
            }else {
                indicator = "[-]";
            }
        }
        ((TextView)v.findViewById(R.id.textView))
            .setText(
                    indicator +
                            getNest(node) +
                            node.getText()
            );
    }

}
