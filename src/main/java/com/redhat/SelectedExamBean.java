package com.redhat;

public class SelectedExamBean {

    private final ExamList exam = new ExamList();

    private String selectedExam;

    public SelectedExamBean() {

        exam.addToList("EXAM1");
        exam.addToList("EXAM2");
        exam.addToList("EXAM3");
        setSelectedExam("EXAM2");
    }

    public void review() {

    }

    public ExamList getExam() {

        return exam;
    }

    public String getSelectedExam() {

        return selectedExam;
    }

    public void setSelectedExam(String selectedExam) {

        this.selectedExam = selectedExam;
    }

}
