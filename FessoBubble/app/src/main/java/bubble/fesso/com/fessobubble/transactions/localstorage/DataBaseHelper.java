package bubble.fesso.com.fessobubble.transactions.localstorage;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by SONY on 08-04-2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper
{
    private static String TAG = "DataBaseHelper";

    //The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/com.airbrushtech.scoolbunny/databases/"; // /data/data/com.example.sony.life2care/databases/

    private static String DB_NAME = "StorageDb";

    private SQLiteDatabase myDataBase;

    private Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DataBaseHelper(Context context)
    {
        super(context, DB_NAME, null, 1);
        myContext = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException
    {
        Log.d(TAG, "Function createDataBase() called");

        boolean dbExist = checkDataBase();

        if(dbExist)  // USE !dbExist in case of error before corerctng it ....
        {
            //do nothing - database already exist
            Log.d(TAG, "Database already exist");
        }
        else
        {
            //By calling this method an empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try
            {
                copyDataBase();
            } catch (Exception e)
            {
              //  throw new Error("Error copying database");
                Log.d(TAG, "Error occurred while copying Database ....");
                e.printStackTrace();
            }
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    public boolean checkDataBase()
    {
        Log.d(TAG, "Function checkDataBase() called ....");

        SQLiteDatabase checkDB = null;

        try
        {
            String myPath = DB_PATH + DB_NAME;

            File file = new File(myPath);
            if (file.exists() && !file.isDirectory())
            {
                Log.d(TAG, "Database found existing in the System. Opening Db");
                checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
            }
            else
              Log.d(TAG, "Else Part :- file.exists() && !file.isDirectory(). No Database found in the System.");

        }catch(Exception e)
        {
           Log.d(TAG, "Exception while opening Database inside checkDataBase() ....");
        }

        if(checkDB != null)
        {
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase()
    {
        Log.d(TAG, "Function copyDataBase() called ....");

        try
        {
            Log.d(TAG, "Opening Database file ....");
            //Open your local db as the input stream
            InputStream myInput = myContext.getAssets().open(DB_NAME);

            // Path to the just created empty db
            String outFileName = DB_PATH + DB_NAME;
            Log.d(TAG, "outFileName: " + outFileName);

            //Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);

            //transfer bytes from the inputfile(Asset Db) to the outputfile(Empty Db).
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer))>0)
            {
                myOutput.write(buffer, 0, length);
            }

            //Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();

        }catch(Exception e)
        {
            Log.d(TAG, "Error occurred inside copyDataBase() ....");
            e.printStackTrace();
        }

    }

    public SQLiteDatabase openDataBase() throws SQLException
    {
        Log.d(TAG, "Function openDataBase() called ....");

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        if(myDataBase == null)
        {
            Log.d(TAG, "####  myDataBase == null  ####");
        }
        return myDataBase;
    }

    @Override
    public synchronized void close()
    {
        Log.d(TAG, "Function close() called ....");

        if(myDataBase != null)
            myDataBase.close();

        super.close();
    }







    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
