package bubble.fesso.com.fessobubble.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.util.ArrayList;

import bubble.fesso.com.fessobubble.Activity.ListViewActivity;
import bubble.fesso.com.fessobubble.R;
import bubble.fesso.com.fessobubble.adapter.GridViewAdapter;
import bubble.fesso.com.fessobubble.pojo.ImageItem;

/**
 * Created by Abhimanoj on 9/11/16.
 */

public class GridViewFragment extends Fragment {

    private          GridView                    gridView;
    private          GridViewAdapter             gridAdapter;

    // Dialogs ....
    static ProgressDialog                        progressDialog;

    // Logs ....
    private static String                        TAG;


    // Activity stuff ....
    GridViewFragment                             context;

    //Create view
    View                                         view;

    //load images from server
    Bitmap                                       bitmap;



    //Name Of Colleges
    String[]         SubTitle       =            new String[]{"IIT-BOMBAY","IIT-KANPUR","IIT-ROORKEE","IIT-DELHI","IIT-MADRAS","IITKHARAGPUR","NIT-TRICHY","NITWARANGAL","NIT-BHOPAL","NIT-ROURKELA","NIT-KKR","NIT-DURGAPUR","IIT-BOMBAY","IIT-KANPUR","NIT-BHOPAL","NIT-TRICHY","NITWARANGAL","NIT-BHOPAL"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_grid_view, container, false);
        super.onCreate(savedInstanceState);

        // Getting INSTANCES of various UI Widgets into Local Variables ....
        initializeLocalVariables();

        gridAdapter = new GridViewAdapter(view.getContext(), R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);
                //Create intent
                Intent intent = new Intent(GridViewFragment.this.getActivity(), ListViewActivity.class);
                 intent.putExtra("title", item.getTitle());


                //Start details activity
                 startActivity(intent);
            }
        });

        return view;
    }

    /**
     * Prepare some  data for gridview
     */
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++) {


            //Decode image, "resource" is the object of image file
            bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));

            // convert decoded bitmap into well scalled Bitmap format.
            Bitmap songImage = Bitmap.createScaledBitmap(bitmap, 200 , 200 , true);

            imageItems.add(new ImageItem(songImage, SubTitle[i]));
        }
        return imageItems;
    }



    public void initializeLocalVariables()
    {
          //Set id in gridView
        gridView = (GridView) view.findViewById(R.id.gridView);

        //set adapter initialy null
        gridAdapter = new GridViewAdapter(view.getContext(), R.layout.grid_item_layout, null);

        //intiatalize context
        context     =     this;

        //set bitmap initialy null
        bitmap      =     null;

        // Strings ....
        TAG = "GridViewFragment";



    }

}