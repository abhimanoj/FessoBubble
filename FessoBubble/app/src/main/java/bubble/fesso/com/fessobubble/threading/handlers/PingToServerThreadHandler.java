package bubble.fesso.com.fessobubble.threading.handlers;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import bubble.fesso.com.fessobubble.Activity.PingToServer;
import bubble.fesso.com.fessobubble.fragment.SendQueryFragment;

/**
 * Created by Abhimanoj on 15/10/16.
 */
public class PingToServerThreadHandler extends Handler {


    // Context ....
    Context context;

    // Intents and Bundles ....
    Bundle updatePingToServerHandlerBundleData;
    Intent nextActivityIntent;

    ProgressDialog progressDialog;

    PingToServer pingToServerActivity;
    private final WeakReference<PingToServer> PingToServerWeakReference;


    // Strings ....
    private final String TAG = "PingToServerThrdHndlr";

    public PingToServerThreadHandler(Context context, PingToServer paramPingToServerReference)
    {
        this.context = context;
        PingToServerWeakReference = new WeakReference<>(paramPingToServerReference);

        // Getting reference of Activity ....
        pingToServerActivity = PingToServerWeakReference.get();
    }

    @Override
    public void handleMessage(Message inputMessageFromChildThread)
    {
        // Getting reference of Progress Dialog from the Activity ....
        progressDialog = SendQueryFragment.getDialog();

        // Getting the attached Bundle object from the Child Thread's Message ....
        updatePingToServerHandlerBundleData = inputMessageFromChildThread.getData();

        Log.d(TAG, "Data Send To Server SuccessFully: " + updatePingToServerHandlerBundleData.getString("ping_to_server_output"));




        progressDialog.dismiss();
        Toast.makeText(context, "Congrats! Your Data Send To Server SuccessFully.", Toast.LENGTH_LONG).show();

        nextActivityIntent = new Intent(context,PingToServer.class);
        pingToServerActivity.startActivity(nextActivityIntent);

    }

}
