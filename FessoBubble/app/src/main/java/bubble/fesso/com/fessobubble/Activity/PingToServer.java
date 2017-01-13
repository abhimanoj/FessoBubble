package bubble.fesso.com.fessobubble.Activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.google.gson.Gson;
import java.io.FileOutputStream;
import bubble.fesso.com.fessobubble.R;
import bubble.fesso.com.fessobubble.pojo.DataFromServer;
import bubble.fesso.com.fessobubble.threading.handlers.PingToServerThreadHandler;
import bubble.fesso.com.fessobubble.threading.threadpool.ThreadPoolService;

/**
 * Created by Abhimanoj on 14/10/16.
 */
public class PingToServer extends AppCompatActivity {


    // Threads and Handlers ....
    ThreadPoolService       childThreadPoolService;
    PingToServerThreadHandler   pingToServerThreadHandlerInstance;



    // Activity stuff ....
    Context context;

    // Intents and Bundles ....
    Intent                      personalProfileActivityIntent;
    Intent                      nextActivityIntent;
    Bundle                      personalProfileActivityBundle;


    // POJOs ....
    DataFromServer              dataFromServer;

       // GSONS ....
    Gson                          localGsonObject;



    // Strings ....
    String                      serverURL;
    String                      jsonRequestDataString;


    // Logs ....
    private static String        TAG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "userLogInOnServer called.");


    }



    public boolean SendData(DataFromServer dataFromFragment)
    {


        // Getting INSTANCES of various UI Widgets into Local Variables ....
        initializeLocalVariables();


        // Preparing Data for Server request ....
       dataFromServer=dataFromFragment;


        // Creating JSON object containing User Profile Pojo to send in request ....
        jsonRequestDataString = localGsonObject.toJson(dataFromServer);




            childThreadPoolService.PingToServerThreadPool(pingToServerThreadHandlerInstance, jsonRequestDataString);

        return true;

    }


    public void initializeLocalVariables()
    {


         // Intents and Bundles ....
        personalProfileActivityBundle        =       new Bundle();

        // POJOs ....
        dataFromServer                       =       new DataFromServer();



        // GSONS ....
        localGsonObject                      =       new Gson();


       context                               =       this;

        // Strings ....
        TAG                                  =      "PingToServer";



        childThreadPoolService               =       new ThreadPoolService();


    }


}
