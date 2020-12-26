package com.example.thecoffeehouse.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.thecoffeehouse.model_adapter.DoUong;

import java.util.ArrayList;
import java.util.List;

public class database extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "coffee_house";

    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Khi cần cập nhật dữ liệu (CREATE, DELETE, UPDATE, INSERT)
    public void QueryData(String sql) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    //Khi cần đọc dữ liệu (SELECT)
    public Cursor GetData(String sql) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "database.onCreate ...");
        String script = "CREATE TABLE IF NOT EXISTS sanpham(Id INTEGER PRIMARY KEY AUTOINCREMENT, LOAISP TEXT, TENSP TEXT, GIASP TEXT, HINHANH TEXT)";
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "database.onUpgrade ... ");
        db.execSQL("DROP TABLE IF EXISTS sanpham");
        onCreate(db);
    }

    public int getCapheCount() {
        Log.i(TAG, "database.getCapheCount ... ");
        String countQuery = "SELECT * FROM sanpham";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void createDefaultsanphamIfNeed() {
        SQLiteDatabase db = getWritableDatabase();
        int count = this.getCapheCount();
        if (count == 0) {
            String sql = "INSERT INTO  sanpham VALUES(NULL, 'douong' , 'Cà phê đen đá', '15.000', 'cafedenda')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL, 'douong',  'Cà phê sữa đá', '17.000', 'caphesua')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,'douong', 'Nước ép cam', '20.000', 'nuocepcam')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,'douong', 'Nước ép chanh dây', '17.000', 'chanhday')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,'douong', 'Bạc xỉu', '15.000', 'bacxiu1')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,'douong', 'Trà sữa dâu tây', '17.000', 'trasuaday')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,'douong', 'Trà đào', '20.000', 'tradao')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,'douong', 'Kem dâu tươi', '15.000', 'kemdau')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,'doan', 'Macca Phủ Socola', '45.000', 'maccasocola')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,'doan', 'Mít sấy', '20.000', 'mitsay')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,'doan', 'Bông lan trứng muối', '29.000', 'bonglantrungmuoi')";
            db.execSQL(sql);
        }
    }

    public List<DoUong> getAlldouong() {
        Log.i(TAG, "database.getAlldouong ... " );

        List<DoUong> doList = new ArrayList<DoUong>();
        // Select All Query
        String selectQuery = "SELECT  * FROM sanpham WHERE LOAISP = 'douong'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DoUong douong = new DoUong(100,"abc","abc","20.000","a");
                douong.setId(cursor.getInt(0));
                douong.setLoaisp(cursor.getString(1));
                douong.setTen(cursor.getString(2));
                douong.setGia(cursor.getString(3));
                douong.setHinh(cursor.getString(4));
                // Adding note to list
                doList.add(douong);
            } while (cursor.moveToNext());
        }

        // return note list
        return doList;
    }
    public List<DoUong> getAlldoan() {
        Log.i(TAG, "database.getAlldoan ... " );

        List<DoUong> daList = new ArrayList<DoUong>();
        // Select All Query
        String selectQuery = "SELECT  * FROM sanpham WHERE LOAISP = 'doan'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DoUong da = new DoUong(100,"asdfsadfasdf","asdfsadfsadf","2223020320321","dcdcdcdcdcdcdc");
                da.setId(cursor.getInt(0));
                da.setLoaisp(cursor.getString(1));
                da.setTen(cursor.getString(2));
                da.setGia(cursor.getString(3));
                da.setHinh(cursor.getString(4));
                // Adding note to list
                daList.add(da);
            } while (cursor.moveToNext());
        }

        // return note list
        return daList;
    }

}
