package com.example.dnd01;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleExpandableListAdapter;
import android.widget.ListView;

import com.example.dnd01.com.example.data.Node;
import com.example.dnd01.com.example.list.TreeAdapter;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView)findViewById(R.id.listView);
        TreeAdapter ta = new TreeAdapter(this, makeDefaultTree());
        lv.setAdapter(ta);
        lv.setVisibility(View.VISIBLE);

    }

    private Node makeDefaultTree() {

        // x
        //  x-a
        //  x-b
        //  x-c
        // y
        //  y-a
        //  y-b
        //      y-b-l
        //      y-b-m
        //           y-b-m
        //           y-b-m
        //      y-b-m
        //      y-b-n
        //  y-c
        // z

        Node root = makeNode(1,"root");

        Node x = makeNode(2,"- x -");
        Node y = makeNode(3,"- y -");
        Node z = makeNode(4,"- z -");
        root.addChild(x).addChild(y).addChild(z);

        x.addChild(makeNode(21,"- x-a -")).addChild(makeNode(22,"- x-b -")).addChild(makeNode(23,"- x-c -"));

        Node ya = makeNode(31,"- y-a -");
        Node yb = makeNode(32,"- y-b -");
        Node yc = makeNode(33,"- y-c -");
        y.addChild(ya).addChild(yb).addChild(yc);

        Node ybl = makeNode(321,"- y-b-l -");
        Node ybm = makeNode(322,"- y-b-m -");
        Node ybn = makeNode(323,"- y-b-n -");
        yb.addChild(ybl).addChild(ybm).addChild(ybn);

        Node ybms = makeNode(3222,"- y-b-m-s -");
        Node ybmt = makeNode(3222,"- y-b-m-t -");
        Node ybmu = makeNode(3222,"- y-b-m-u -");
        ybm.addChild(ybms).addChild(ybmt).addChild(ybmu);


        root.expand();
        return root;
    }

    private Node makeNode(long l, String s) {
        Node n = new Node();
        n.setId(l);
        n.setText(s);
        return n;
    }

}
