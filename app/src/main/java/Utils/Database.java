package Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Model.LoginAnswer;

/**
 * Created by Alexsander on 03/12/2017.
 */

public class Database extends SQLiteOpenHelper{

    public static final int VERSION = 1;
    public static final String BRAZIL_FRUITS_CENTRAL="brazil_fruits_central";
    public static final String TABEL_LOGIN ="login";

    public static final String COLUMN_TOKEN = "token";
    public static final String COLUMN_IDENTIFIER = "id";

    public Database(Context context){
        super(context, BRAZIL_FRUITS_CENTRAL, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String  QUERY_COLUMN = "create table "+ TABEL_LOGIN+ " ( "+
                COLUMN_IDENTIFIER+ " INTEGER PRIMARY KEY, " +
                COLUMN_TOKEN+ " TEXT)";
        db.execSQL(QUERY_COLUMN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        //Presente apenas por compatibilidade
    }

    public void saveToken(LoginAnswer answer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_TOKEN, answer.getToken());

        db.insert(TABEL_LOGIN, null, values);
        db.close();
    }

    public String recoverToken(){
        SQLiteDatabase db = this.getReadableDatabase();
        String token = new String();
        Cursor cursor = db.rawQuery("select * from "+ TABEL_LOGIN, null);

        while(cursor.moveToNext()){
            token = cursor.getString(cursor.getColumnIndex(COLUMN_TOKEN));
        }
        return token;
    }
}
