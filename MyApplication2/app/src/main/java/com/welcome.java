package com;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class welcome extends SQLiteOpenHelper {
 private static int version=3;
 private static String name="notelgh";
 private static  final String databasetable="notestablesml" ;


    private  static  String key_id="id";
    private  static  String title="title";
    private  static  String content="content";
    private  static  String date="date";
    private  static  String time="time";
 public welcome(Context cont){
     super(cont,name,null,version);

 }







    @Override
    public void onCreate(SQLiteDatabase db) {
     String que="CREATE TABLE " + databasetable +"(" + key_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + title + " TEXT," + content +" TEXT," + date + " TEXT," + time + " TEXT);";
     db.execSQL(que);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     if(oldVersion>=newVersion){
         return;
     }
     else{
         db.execSQL("Drop TABLE IF EXISTS "+databasetable);
         onCreate(db);
     }

    }
    public  long addn( note nt){
     SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(title,nt.getTitle());
        c.put(content,nt.getContnet());
        c.put(date,nt.getDate());
        c.put(time,nt.getTime());

        return db.insert(databasetable,null,c);

    }
    public  note getnote(long id){
     SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(databasetable,new  String[]{key_id,title,content,date,time},key_id+"=?",new String[]{String.valueOf(id)},null,null,null);
        if(cursor !=null){
            cursor.moveToFirst();}
            note nt=new note(cursor.getLong(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
        return  nt;


    }
    public List<note> getnotes(){
     SQLiteDatabase db=this.getReadableDatabase();
     String query="SELECT * FROM "+databasetable+" ORDER BY "+key_id+" DESC ";
      Cursor cr=db.rawQuery(query,null);
     List<note> addnt=new ArrayList<>();
     if(cr !=null){
     if(cr.moveToFirst()){
         do{
             note nt=new note();
             nt.setId(cr.getLong(0));
             nt.setTitle(cr.getString(1));
             nt.setContnet(cr.getString(2));
             nt.setDate(cr.getString(3));
             nt.setTime(cr.getString(4));
              addnt.add(nt);

         }while (cr.moveToNext());
     }}
     return  addnt;

    }
    public  int editnote(note nt){
     SQLiteDatabase db=this.getWritableDatabase();
     ContentValues c=new ContentValues();
     c.put(title,nt.getTitle());
     c.put(content,nt.getContnet());
     c.put(date,nt.getDate());
     c.put(time,nt.getTime());
     return db.update(databasetable,c,key_id +"=?",new String[]{String.valueOf(nt.getId())});
    }
    public  void deletenot(long id){
     SQLiteDatabase db=this.getWritableDatabase();
     db.delete(databasetable,key_id+"=?",new  String[]{String.valueOf(id)});
     db.close();

    }
}