package com;

public class note {
    long id;
    String title;
    String contnet;
    String date;
    String time;
    note(){}
   public note( String title, String contnet,String date,String time){
        this.contnet=contnet;
        this.time=time;
        this.date=date;
        this.title=title;
    }

    public note(long id, String title, String contnet,String date,String time){
        this.id=id;
        this.contnet=contnet;
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
    public void setContnet(String contnet) {
        this.contnet = contnet;
    }


    public String getContnet() {
        return contnet;
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
