package com.example.dnd01.com.example.data;

import java.util.ArrayList;
import java.util.List;

public class Node{

    private long id = -1;

    private boolean isExpand = false;

    private int level = -1;

    private String text = "";

    private List<Node> children = new ArrayList<Node>();

    private Node parent = null;

    public void setText(String s) {
        text = s;
    }

    public String getText() {
        return text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public boolean isCollapse() {
        return !isExpand();
    }

    public boolean isRoot() {
        return parent == null;
    }

    public int getLevel() {
        return level;
    }

    public Node addChild(Node child) {
        children.add(child);
        child.parent = this;
        calLevel(child);
        return this;
    }

    public boolean hasChildren() {
        return children.size() > 0;
    }


    public boolean expand() {
        isExpand = true;
        return isExpand;
    }

    public boolean collapse() {
        isExpand = false;
        return isExpand;
    }

    public List<Node> getChildren() {
        List<Node> ret = new ArrayList<Node>();
        for(Node c : children) {
            ret.add(c);
            if (c.isExpand()){
                List<Node> cRet = c.getChildren();
                ret.addAll(cRet);
            }
        }
        return ret;
    }

    private void calLevel(Node node) {
        if (node.parent == null) {
            node.level = 0;
        }else {
            Node p = node.parent;
            int l = 0;
            while(p != null) {
                l++;
                p = p.parent;
            }
            node.level = l;
        }
    }

}
