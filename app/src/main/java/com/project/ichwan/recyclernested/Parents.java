package com.project.ichwan.recyclernested;

import java.util.List;

public class Parents {

    private String txtitle;
    private List<Childs> childsList;

    public Parents(String txtitle, List<Childs> childsList) {
        this.txtitle = txtitle;
        this.childsList = childsList;
    }

    public Parents() {

    }

    public String getTxtitle() {
        return txtitle;
    }

    public void setTxtitle(String txtitle) {
        this.txtitle = txtitle;
    }

    public List<Childs> getChildsList() {
        return childsList;
    }

    public void setChildsList(List<Childs> childsList) {
        this.childsList = childsList;
    }
}
