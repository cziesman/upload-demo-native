package com.redhat;

import java.util.ArrayList;
import java.util.List;

public class ExamList {

    private List<String> list = new ArrayList<>();

    public int getRowCount() {

        return list.size();
    }

    public void setRowCount(int rowCount) {

    }

    public List<String> getList() {

        return list;
    }

    public void setList(List<String> list) {

        this.list = list;
    }

    public void addToList(String exam) {

        this.list.add(exam);
    }

}
