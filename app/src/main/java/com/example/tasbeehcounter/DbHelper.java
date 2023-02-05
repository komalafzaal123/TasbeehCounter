package com.example.tasbeehcounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "TasbeehCounter";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "tasbeehRecord";
    private static final String ID_COL = "id";
    private static final String KALMA_COUNT = "kalma_count";
    private static final String DAROODEPAK_COUNT = "daroodepak_count";
    private static final String ASTAGFAR_COUNT = "astagfar_count";
    private static final String IS_RECITED = "isRecited";
    private static final String DATE = "date";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KALMA_COUNT + " TEXT, "
                + DAROODEPAK_COUNT + " TEXT, "
                + ASTAGFAR_COUNT + " TEXT, "
                + IS_RECITED + " TEXT, "
                +  DATE + " Text )";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void saveData(Counter tasbeehCount) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KALMA_COUNT, tasbeehCount.getKalmaCount());
        values.put(DAROODEPAK_COUNT, tasbeehCount.getDaroodCount());
        values.put(ASTAGFAR_COUNT, tasbeehCount.getAstagfarCount());
        values.put(IS_RECITED, tasbeehCount.getRecited());
        values.put(DATE, tasbeehCount.getDate());


        db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<Counter> getAllData() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<Counter> dataArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            do {
                dataArrayList.add(new Counter(cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        Boolean.parseBoolean(cursor.getString(4)),
                        cursor.getString(5)));
            } while (cursor.moveToNext());

        }

        cursor.close();
        return dataArrayList;
    }
}
