package com.example.user.corrections;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Luiz Felipe on 26/11/2015.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shopaliftdb.db";
    public static final String COLUMN_ID = "_id";
    public static final String TABLE_SHOPPING_LISTS = "shopping_lists",
            COLUMN_LIST_NAME = "items_list", COLUMN_SHOP_PLACE = "shop_place",
            COLUMN_DUE_DATE = "due_date";
    public static final String TABLE_ITEMS = "items", COLUMN_ITEM = "item";
    public static final String TABLE_ITEMS_IN_LIST = "items_in_list", COLUMN_LIST_ID = "list_id",
            COLUMN_ITEM_ID = "item_id";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_SHOPPING_LISTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_LIST_NAME + " VARCHAR(20) NOT NULL, " +
                COLUMN_SHOP_PLACE + " VARCHAR(20) NOT NULL, " +
                COLUMN_DUE_DATE + " VARCHAR(20) " +
                ");" +
                "\n" +
                "CREATE TABLE " + TABLE_ITEMS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ITEM + " VARCHAR(20) NOT NULL, " +
                ");" +
                "\n" +
                "CREATE TABLE " + TABLE_ITEMS_IN_LIST + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_LIST_ID + " INTEGER NOT NULL, " +
                COLUMN_ITEM_ID + " INTEGER NOT NULL, " +
                "FOREIGN KEY(" + COLUMN_LIST_ID + ") REFERENCES " + TABLE_SHOPPING_LISTS + " (" + COLUMN_ID + ")," +
                "FOREIGN KEY(" + COLUMN_ITEM_ID + ") REFERENCES " + TABLE_ITEMS + " (" + COLUMN_ID + ")" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOPPING_LISTS + ";" +
                "DROP TABLE IF EXISTS " + TABLE_ITEMS + ";" +
                "DROP TABLE IF EXISTS " + TABLE_ITEMS_IN_LIST + ";");
        onCreate(db);

    }

    public void addShoppingList(ShoppingList list) {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        values.put(COLUMN_LIST_NAME, list.getListName());
        values.put(COLUMN_SHOP_PLACE, list.getListName());
        values.put(COLUMN_DUE_DATE, list.getListName());
        db.insert(TABLE_SHOPPING_LISTS, null, values);
        db.close();
    }

    public void addItem(Item item) {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        values.put(COLUMN_ITEM, item.getItem());
        db.insert(TABLE_ITEMS, null, values);
        db.close();
    }

    public void addItemsInList(ShoppingList list) {
        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
//        values.put();
        db.insert(TABLE_ITEMS_IN_LIST, null, values);
        db.close();

    }

    public void deleteShoppingList(String listName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SHOPPING_LISTS + " WHERE " + COLUMN_LIST_NAME +
                "=\"" + listName + "\";");

    }

    public void deleteItem() {
        SQLiteDatabase db = getWritableDatabase();

    }

    public void deleteItemsInList() {
        SQLiteDatabase db = getWritableDatabase();

    }

    public String itemToString() {
        String dbStr = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("item")) != null) {
                dbStr += c.getString(c.getColumnIndex("item"));
                dbStr += "\n";
            }
        }
        db.close();
        return dbStr;
    }










}
