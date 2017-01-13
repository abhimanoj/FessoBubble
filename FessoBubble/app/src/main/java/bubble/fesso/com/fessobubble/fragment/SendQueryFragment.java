package bubble.fesso.com.fessobubble.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import bubble.fesso.com.fessobubble.Activity.PingToServer;
import bubble.fesso.com.fessobubble.R;
import bubble.fesso.com.fessobubble.pojo.DataFromServer;

/**
 * A simple {@link Fragment} subclass.
 */
public class SendQueryFragment extends Fragment {

    //Create view
    View                                    view;

    // Activity stuff ....
    SendQueryFragment                       context;


    // Dialogs ....
    static   ProgressDialog     progressDialog;


    // Logs ....
    private static String                   TAG;


    // POJOs ....
    DataFromServer                          dataFromServer;

    //Activity Object
    PingToServer                            pingToServer;

    boolean                                 status;

    //edittext object
    EditText                                textPersonName;
    EditText                                textPersonLastName;
    EditText                                textEmailId;
    EditText                                textQuery;


    //GetEditText Data
    String                                  editUserName;
    String                                  editUserLastName;
    String                                  editEmailId;
    String                                  editQuery;



    public SendQueryFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,   Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.ask_query, container, false);
        super.onCreate(savedInstanceState);

        // Getting INSTANCES of various UI Widgets into Local Variables ....
        initializeLocalVariables();






        Button mButton = (Button) view.findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                /******************************************************************************************************
                 *              Starting the Progress Dialog so as to Save the Data in the Background ....
                 *****************************************************************************************************/
                progressDialog = ProgressDialog.show(SendQueryFragment.this.getContext(), "Preparing to launch.", "Please wait", true, false);

              //Get Data From layout

                editUserName            =       textPersonName.getText().toString();
                editUserLastName        =       textPersonLastName.getText().toString();
                editEmailId             =       textEmailId.getText().toString();
                editQuery               =       textQuery.getText().toString();



                // Preparing Data for Server request ....

                dataFromServer.setTask("Insertion");
                dataFromServer.setUserName(editUserName);
                dataFromServer.setUserLastName(editUserLastName);
                dataFromServer.setEmailId(editEmailId);
                dataFromServer.setQuery(editQuery);

                status    =  pingToServer.SendData(dataFromServer);

                if(status)
                {


                    Toast.makeText(SendQueryFragment.this.getActivity(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();


                }


            }
        });



        return view;
    }


    public void initializeLocalVariables()
    {

        // POJOs ....
        dataFromServer  =   new DataFromServer();

        pingToServer    =   new PingToServer();

        //intiatalize context
        context         =   this;

        // Strings ....
        TAG             =   "SendQueryFrgmnt";

        textPersonName = (EditText)view.findViewById(R.id.editText1);
        textPersonLastName = (EditText)view.findViewById(R.id.editText2);
        textEmailId = (EditText)view.findViewById(R.id.editText3);
        textQuery = (EditText)view.findViewById(R.id.editText4);



    }
    /**
     * The function returns the Progress Dialog associated with this Activity ....
     * @return
     */
    public static ProgressDialog getDialog()
    {
        return progressDialog;
    }

}
