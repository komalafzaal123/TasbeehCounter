package com.example.tasbeehcounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "TasbeehCounter";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "tasbeehRecord";
    private static final String ID_COL = "id";
    private static final String KALMA_COUNT = "kalma_count";
    private static final String DAROODEPAK_COUNT = "daroodepak_count";
    private static final String ASTAGFAR_COUNT = "astagfar_count";
    private static final Boolean IS_RECITED = Boolean.valueOf("isrecited");
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
                + IS_RECITED + " Boolean, "
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
        values.put(String.valueOf(IS_RECITED), tasbeehCount.getRecited());
        values.put(DATE, tasbeehCount.getDate());


        db.insert(TABLE_NAME, null, values);

//        db.close();
    }
}
