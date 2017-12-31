package com.adityadua.sqlite5ndemo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;

import com.adityadua.sqlite5ndemo.utils.Constants;

/**
 * Created by AdityaDua on 16/12/17.
 */

public class TablesClass extends SQLiteOpenHelper {


    Context context;
    String query = "Create table IF NOT EXISTS "+ Constants.BOOK_RECORD +" ("+
            Constants.ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Constants.BOOK_ID+" TEXT, "+
            Constants.BOOK_AUTHOR+" TEXT, "+
            Constants.BOOK_NAME+" TEXT);";


    public TablesClass(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        context.deleteDatabase(Constants.DATABASE_NAME);
        onCreate(db);
    }
}
