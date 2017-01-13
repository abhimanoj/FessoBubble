package bubble.fesso.com.fessobubble.transactions.localstorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 15/10/16.
 */
public class CacheStudentProfileData extends SQLiteOpenHelper {

    private static String TAG = "CacheStudentsProfileData";

    // LOCAL APPLICATION DATABASE Details ....
    public static final  int    DATABASE_VERSION     = 1;
    public static final  String  DATABASE_NAME        = "ScoolBunnyLocalDatabase";

    String TABLE_CACHE_STUDENTS_PROFILE                = "students_profile";


    public CacheStudentProfileData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
