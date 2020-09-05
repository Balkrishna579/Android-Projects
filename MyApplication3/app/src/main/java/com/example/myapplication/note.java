package com.example.myapplication;

import java.util.List;

public class note {
    long id;
    String title;

    List<question> ques ;

    String date;
    String time;
    note(){}
   public note(String title, List<question> ques, String date, String time ){
       this.title=title;
       this.ques=ques;
        this.time=time;
        this.date=date;



    }

    public note(long id, String title, List<question> ques, String date, String time){
        this.id=id;
        this.ques=ques;
        this.time=time;
        this.date=date;
        this.title=title;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
   


    

    public List<question> getQues() {
        return ques;
    }

    public void setQues(List<question> ques) {
        this.ques = ques;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }


    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
