package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;
import static java.lang.String.valueOf;

public class welcome extends SQLiteOpenHelper {
 private static int version=3;
 private static String name="notelgh";
 private static  final String databasetable="notestable" ;
    private  static final String questdata="questdata";


    private  static  String key_id="id";
    private  static  String title="title";


    private  static  String date="date";
    private  static  String time="time";
    private static String num="num";
    private static String option1="option1";
    private static String option2="option2";
    private static String option3="option3";
    private static String option4="option4";
    private static String questio="Question";
    private  static  String ans="answer";

 public welcome(Context cont){
     super(cont,name,null,version);

 }







    @Override
    public void onCreate(SQLiteDatabase db) {
     String que="CREATE TABLE " + databasetable +"(" + key_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + title + " TEXT,"  + date + " TEXT," + time + " TEXT);";
     db.execSQL(que);
     String que1="CREATE TABLE "+ questdata + "(" + key_id + " INTEGER ," + num + " INTEGER ," + questio + " TEXT," + option1 + " TEXT," + option2 + " TEXT," + option3 + " TEXT," + option4 + " TEXT, " + ans + " TEXT);";
        db.execSQL(que1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     if(oldVersion>=newVersion){
         return;
     }
     else{
         db.execSQL("Drop TABLE IF EXISTS "+databasetable);
         db.execSQL("Drop TABLE IF EXISTS "+questdata);
         onCreate(db);
         onCreate(db);
     }

    }
    public  long bddn(note nt,List<question> con,long st){

        SQLiteDatabase db=this.getWritableDatabase();
        long t=0;
        for(int i=0;i<con.size();i++){
            question s=con.get(i);
            ContentValues d=new ContentValues();
            d.put(key_id,st);
            d.put(num,s.getNum());
            d.put(questio,s.getQues());
            d.put(option1,s.getOption1());
            d.put(option2,s.getOption2());
            d.put(option3,s.getOption3());
            d.put(option4,s.getOption4());
            d.put(ans,s.getAnswer());
            t=db.insert(questdata,null,d) ;}

            return t;

    }


    public  long addn( note nt,List<question> conte,int g){
     SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(title,nt.getTitle());

        c.put(date,nt.getDate());
        c.put(time,nt.getTime());



        return db.insert(databasetable,null,c);

    }
    public List<question> getques(long ks){

        SQLiteDatabase db=this.getReadableDatabase();
        List<question> cons=new ArrayList<>();
      //  String query="SELECT * FROM "+questdata+" WHERE id = ? " +" ORDER BY "+num+" DESC ";
     //   @SuppressLint("Recycle") Cursor cr=db.rawQuery(query,new String[]{String.valueOf(ks)});
        Cursor cr=db.query(questdata,new String[]{key_id,num,questio,option1,option2,option3,option4,ans},key_id+"=?",new  String[]{String.valueOf(ks)},null,null,null);


        if( cr.moveToFirst()){
            do{
                question qs=new question();
                qs.setNum((int) cr.getLong(1));
                qs.setQues(cr.getString(2));
                qs.setOption1(cr.getString(3));
                qs.setOption2(cr.getString(4));
                qs.setOption3(cr.getString(5));
                qs.setOption4(cr.getString(6));
                qs.setAnswer(cr.getString(7));
                cons.add(qs);
            } while (cr.moveToNext());
        }
        return cons;

    }
    public  note getnote(long id){
     SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(databasetable,new  String[]{key_id,title,date,time},key_id+"=?",new String[]{String.valueOf((int) id)},null,null,null);
        if(cursor !=null){
             cursor.moveToFirst();
        }
        Log.d("count",String.valueOf(cursor.getCount()));

        note nt=new note();
        nt.setTitle(cursor.getString(1));
        nt.setId(cursor.getLong(0));

        nt.setDate(cursor.getString(2));
        nt.setTime(cursor.getString(3));
         if(cursor ==null){
             Log.d("cursi","null curs");
         }
        return  nt;


    }
    public List<note> getnotes(){
     SQLiteDatabase db=this.getReadableDatabase();
     String query="SELECT * FROM "+databasetable+" ORDER BY "+key_id+" DESC ";
     @SuppressLint("Recycle") Cursor cr=db.rawQuery(query,null);
     List<note> addnt=new ArrayList<>();
     if(cr.moveToFirst()){
         do{
             note nt=new note();
             nt.setId(cr.getLong(0));
             nt.setTitle(cr.getString(1));

             nt.setDate(cr.getString(2));
             nt.setTime(cr.getString(3));
             addnt.add(nt);

         }while (cr.moveToNext());
     }
     return  addnt;

    }
    public int editques(question ques,long ks){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();

        c.put(questio,ques.getQues());
        c.put(option1,ques.getOption1());
        c.put(option2,ques.getOption2());
        c.put(option3,ques.getOption3());
        c.put(option4,ques.getOption4());
        c.put(ans,ques.getAnswer());

        return db.update(questdata,c,key_id+" = ? and "+num+" = ? ",new String[]{String.valueOf(ks), String.valueOf(ques.getNum())});


    }
    public  int editnote(note nt){
     SQLiteDatabase db=this.getWritableDatabase();
     ContentValues c=new ContentValues();
     c.put(title,nt.getTitle());

     c.put(date,nt.getDate());
     c.put(time,nt.getTime());
     return db.update(databasetable,c,key_id +"=?",new String[]{String.valueOf(nt.getId())});

    }
    public  void deletenot(long id){
     SQLiteDatabase db=this.getWritableDatabase();
     db.delete(databasetable,key_id+"=?",new  String[]{String.valueOf(id)});
     db.close();

    }public  void  deleteque(long ks,question ques){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(questdata,key_id+" = ? and "+num+" = ? ",new  String[]{String.valueOf(ks),String.valueOf(ques.getNum())});
        db.close();
    }
}