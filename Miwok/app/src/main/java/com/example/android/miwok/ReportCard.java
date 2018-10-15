package com.example.android.miwok;

public class ReportCard {

    int historyGrade=0;
    int chemistryGrade = 0;
    int mathsGrade = 0;
    int englishGrade = 0;
    String name;

    public ReportCard(int historyGrade, int chemistryGrade, int mathsGrade, int englishGrade, String name) {
        this.historyGrade = historyGrade;
        this.chemistryGrade = chemistryGrade;
        this.mathsGrade = mathsGrade;
        this.englishGrade = englishGrade;
        this.name = name;
    }

    public int getHistoryGrade() {
        return historyGrade;
    }

    public void setHistoryGrade(int historyGrade) {
        this.historyGrade = historyGrade;
    }

    public int getChemistryGrade() {
        return chemistryGrade;
    }

    public void setChemistryGrade(int chemistryGrade) {
        this.chemistryGrade = chemistryGrade;
    }

    public int getMathsGrade() {
        return mathsGrade;
    }

    public void setMathsGrade(int mathsGrade) {
        this.mathsGrade = mathsGrade;
    }

    public int getEnglishGrade() {
        return englishGrade;
    }

    public void setEnglishGrade(int englishGrade) {
        this.englishGrade = englishGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String reportCard = "Name: " + getName() + "; History grade: " +  getHistoryGrade()
                + "; English grade: " +  getEnglishGrade() + "; Maths grade: " +  getMathsGrade()
                + "; Chemistry grade: " +  getChemistryGrade();
        return reportCard;
    }
}
