package com.project.ichwan.recyclernested;

import java.util.ArrayList;
import java.util.List;

public class Parents {

    private String txtitle;
    private ArrayList<Childs> listChild;

    public Parents(String txtitle, ArrayList<Childs> listChild) {
        this.txtitle = txtitle;
        this.listChild = listChild;
    }

    public String getTxtitle() {
        return txtitle;
    }

    public void setTxtitle(String txtitle) {
        this.txtitle = txtitle;
    }

    public ArrayList<Childs> getListChild() {
        return listChild;
    }

    public void setListChild(ArrayList<Childs> listChild) {
        this.listChild = listChild;
    }
}
