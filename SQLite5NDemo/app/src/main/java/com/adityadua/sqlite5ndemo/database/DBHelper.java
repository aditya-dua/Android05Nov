package com.adityadua.sqlite5ndemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.adityadua.sqlite5ndemo.model.BookData;
import com.adityadua.sqlite5ndemo.utils.Constants;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by AdityaDua on 16/12/17.
 *
 * Over here I will have the methods to work on DB which means ::
 * I can insert the values in DB , fetch the values from DB and update and delete
 *
 * CRUD operations , will be performed over here.
 * create read update delete
 *
 * insertion of records,
 * selection of all of the records
 * lets try delete or update
 *
 */

public class DBHelper {

    private SQLiteDatabase db;
    private final Context context;
    private final TablesClass tablesHelper;
    private static DBHelper db_helper;

    public DBHelper(Context context){
        this.context  = context;

        tablesHelper = new TablesClass(context, Constants.DATABASE_NAME,null,Constants.DB_VERSION);
    }


    public static DBHelper getInstance(Context context){
        try{
            if(db_helper == null){
                db_helper = new DBHelper(context);
                db_helper.open();
            }
        }catch (Exception e){
           e.printStackTrace();
        }

        return db_helper;
    }

    public void open() throws SQLiteException{

        try{
            db = tablesHelper.getWritableDatabase();

        }catch (Exception e){
            e.printStackTrace();
            db = tablesHelper.getReadableDatabase();
        }
    }

    public void close(){
        if(db.isOpen()){
            db.close();
        }
    }

    public long insertContentValues(String tableName, ContentValues contentValues){

        long id =0;

        try{
            db.beginTransaction();
            id =  db.insert(tableName,null,contentValues);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }


        return  id;


    }

    /**
     * give me the count
     */

    public int getFullCount(String tableName,String where){

        int rowCount =0;
        Cursor c = db.query(false,tableName,null,where,null,null,null,null,null);

        try{
            c.moveToFirst();

            if(c!=null){
                rowCount = c.getCount();
            }
        }finally{
            c.close();
        }

        return  rowCount;
    }


    public int updateRecord(String tabName,ContentValues contentValues,String where ,String [] whereArgs){

        int rowCount =0;

        try{
            db.beginTransaction();
            rowCount = db.update(tabName,contentValues,where,whereArgs);

            db.setTransactionSuccessful();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }

        return  rowCount;
    }

    public void deleteRecord(String tabName , String where, String [] whereArgs){
        try{
            db.beginTransaction();
            db.delete(tabName,where,whereArgs);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }

    }

    public List<BookData> getAllBooks(){

        List<BookData> books = new LinkedList<>();

        String query = "select * from "+Constants.BOOK_RECORD;

        Cursor c = db.rawQuery(query,null);

        BookData book = null;

        if(c.moveToFirst()){


            do{
                book = new BookData();

                book.setId(c.getString(0).toString());
                book.setBookId(c.getString(1).toString());
                book.setBookAuthor(c.getString(2).toString());
                book.setBookName(c.getString(3).toString());

                books.add(book);
            }while (c.moveToNext());



        }

        c.close();
        return  books;
    }






}
