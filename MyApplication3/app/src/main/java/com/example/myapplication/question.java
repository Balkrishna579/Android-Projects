package com.example.myapplication;

public class question {
    String ques;
    int num;
    String option1;
    String option2;
    String option3;
    String option4;
    String answer;
    question(){}
    public  question( int num,String ques,String option1,String option2 ,String option3,String option4,String answer){
        this.num=num;
        this.ques=ques;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;
        this.answer=answer;
    }

    public int getNum() {
        return num;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getQues() {
        return ques;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
