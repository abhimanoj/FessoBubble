package bubble.fesso.com.fessobubble.threading.childThreads;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import bubble.fesso.com.fessobubble.Activity.HomeActivity;
import bubble.fesso.com.fessobubble.Activity.PingToServer;
import bubble.fesso.com.fessobubble.fragment.SendQueryFragment;
import bubble.fesso.com.fessobubble.pojo.DataFromServer;
import bubble.fesso.com.fessobubble.pojo.SuccessStatePojo;
import bubble.fesso.com.fessobubble.threading.threadpool.ThreadPoolService;
import bubble.fesso.com.fessobubble.transactions.localstorage.CacheStudentProfileData;

/**
 * Created by Abhimanoj on 15/10/16.
 */
public class PingToServerThread implements Runnable {

    private static final String SERVER_IP ="192.168.1.19" ;

    // UI Stuff ....
    Context                      context;

    // Threads and Handlers ....
    ThreadPoolService            childThreadPoolService;


    // Handlers ....
    Handler                      handlerPingToServer;

    // Utilities ....
    CacheStudentProfileData      localCacheStudentsProfileDataInstance;


    // Message ....
    Message                      pintToServerHandlerMessageObject;


    // Dialogs ....
    ProgressDialog               progressDialog;

    // POJOs ....
    DataFromServer               dataFromServer;

    // Network Request Stuff ....
    URL                          requestURL;
    HttpURLConnection            requestURLConnection;

    // Stream Writers ....
    OutputStreamWriter           requestDataStreamWriterInstance;

    // Stream Readers ....
    InputStreamReader            serverResponseStreamReaderInstance;
    BufferedReader               serverResponseBufferedReaderInstance;

    // GSONS ....
    Gson                         localGsonObject;
    Type                         localGsonCollectionConversionType;


    // File handling ....
    FileOutputStream             localFileOutputStreamInstance;


    // Bundle ....
    Bundle                       pingToServerHandlerBundleData;


    // Strings ....
    String                      serverURL;
    String                      jsonRequestDataString;
    String                      jsonResponseDataString;

    // Integers ....
    int                         serverResponseCode;

    // POJOs ....
    SuccessStatePojo            localSuccessStatePojo;


    // Logs ....
    private static String       TAG;

    public PingToServerThread(Handler handlerPingToServer , String jsonRequestDataString)
    {

        initializeLocalVariables(context,handlerPingToServer);

        this.jsonRequestDataString = jsonRequestDataString;

        localGsonObject       =    new Gson();

        localGsonCollectionConversionType = new TypeToken<ArrayList<DataFromServer>>() {}.getType();


    }

    @Override
    public void run() {

        try {
            // Establishing URL Connection with the Server ....
            serverURL = "http://" + SERVER_IP + ":8080/FessoBubbleServer/PingToServer";
            requestURL = new URL(serverURL);
            requestURLConnection = (HttpURLConnection) requestURL.openConnection();
            requestURLConnection.setDoOutput(true);
            requestURLConnection.setRequestProperty("Content-Type", "application/json");

            Log.d(TAG, "Connection Stablish Done.");

            // Sending the data along with the request to the Server ....
            requestDataStreamWriterInstance = new OutputStreamWriter(requestURLConnection.getOutputStream());
            requestDataStreamWriterInstance.write(jsonRequestDataString);
            requestDataStreamWriterInstance.close();

            Log.d(TAG, "Data Send To server Done.");

            // Getting Response from the Server ....
            serverResponseCode = requestURLConnection.getResponseCode();
            Log.d(TAG, "serverResponseCode: " + serverResponseCode);

            // Getting reference of Progress Dialog from the Activity ....
            progressDialog = SendQueryFragment.getDialog();
            progressDialog.dismiss();

            if (serverResponseCode == HttpURLConnection.HTTP_OK) {

                Log.d(TAG, "Server responce code HTTPOK.");
                serverResponseStreamReaderInstance = new InputStreamReader(requestURLConnection.getInputStream());
                serverResponseBufferedReaderInstance = new BufferedReader(serverResponseStreamReaderInstance);

                // Reading the Response Data ....
                if (serverResponseBufferedReaderInstance != null)
                    jsonResponseDataString = serverResponseBufferedReaderInstance.readLine();

                Log.d(TAG, "Server Response: " + jsonResponseDataString);

                // Closing the Stream ....
                serverResponseBufferedReaderInstance.close();

                // Retrieving Profile Pojo from JSON ....
                localSuccessStatePojo = localGsonObject.fromJson(jsonResponseDataString,SuccessStatePojo.class);


                pingToServerHandlerBundleData.putString("ping_to_server_output",localSuccessStatePojo.getFunctionOutput());


                if(!localSuccessStatePojo.getFunctionOutput().equals("fail") && !localSuccessStatePojo.getFunctionOutput().equals("Error")
                        && !localSuccessStatePojo.getFunctionOutput().equals("Invalid Teacher Code"))
                {

                    pingToServerHandlerBundleData.putString("ping_to_server_output","Data Saved");

                    /**
                     * New we're storing the data of the newly added Parent in the SharedPreference ....
                     */
                    // Retrieving Profile Pojo from JSON String sent int the request ....
                    Log.d(TAG, "Save Query Data By User ");
                }

                // Storing the Bundle object in the Message Object ....
                pintToServerHandlerMessageObject.setData(pingToServerHandlerBundleData);



                handlerPingToServer.sendMessage(pintToServerHandlerMessageObject);
            }else
            {
                pingToServerHandlerBundleData.putString("ping_to_server_output", "Error");

                // Storing the Bundle object in the Message Object ....
                pintToServerHandlerMessageObject.setData(pingToServerHandlerBundleData);


                handlerPingToServer.sendMessage(pintToServerHandlerMessageObject);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initializeLocalVariables(Context context ,Handler handlerPingToServer)
    {
        // Intents and Bundles ....
        pingToServerHandlerBundleData = new Bundle();


        // Handlers ....
        this.handlerPingToServer      =  handlerPingToServer;



        // POJOs ....
        dataFromServer                = new DataFromServer();
        //sharedPreferenceUserProfilePojo = UserProfileLocal.getUserProfileInstance();

        // GSONS ....
        localGsonObject               = new Gson();


        // Strings ....
        TAG                           = "PingToServer";

        // UI Stuff ....
        this.context                  = context;


        localCacheStudentsProfileDataInstance = new CacheStudentProfileData(context);

     /*   // Message....
        pintToServerHandlerMessageObject = handlerPingToServer.obtainMessage();*/


    }

    }