package bubble.fesso.com.fessobubble.threading.threadpool;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import bubble.fesso.com.fessobubble.threading.childThreads.PingToServerThread;

/**
 * Created by Rahul on 23-11-2015.
 */
public class ThreadPoolService
{
    ExecutorService threadExecutorService;

    PingToServerThread  pingToServerThreadInstance;

    private final String TAG = "ThreadPoolService";



    public void PingToServerThreadPool(Handler threadHandler , String jsonRequestDataString)
    {
        Log.d(TAG, "UpdateTeacherProfileThreadPool invoked.");

        threadExecutorService = Executors.newSingleThreadExecutor();

        // The "Handler" instance is further passed to the class implementing "Runnable".
        pingToServerThreadInstance = new PingToServerThread(threadHandler , jsonRequestDataString);
        threadExecutorService.execute(pingToServerThreadInstance);

        threadExecutorService.shutdown();  // This closes the Thread Executor Service.

        Log.d(TAG, "Executor Service ends after starting Child Thread to update Teacher Profile.");
    }






}
