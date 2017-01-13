package bubble.fesso.com.fessobubble.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bubble.fesso.com.fessobubble.Activity.CustomListActivity;
import bubble.fesso.com.fessobubble.Activity.EventGalleryActivity;
import bubble.fesso.com.fessobubble.Activity.ListViewActivity;
import bubble.fesso.com.fessobubble.R;
import bubble.fesso.com.fessobubble.pojo.ImageItem;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * Created by Abhimanoj on 9/11/16.
 */
public class ListViewFragment extends Fragment {

    //list View Object
    ListView                       list;

    //List View Names
    String[]                       web = {
                                            "IIT-BOMBAY",
                                            "IIT-KANPUR",
                                            "IIT-ROORKEE",
                                            "IIT-DELHI",
                                            "IIT-MADRAS",
                                            "IITKHARAGPUR",
                                            "NIT-TRICHY",
                                            "NITWARANGAL",
                                            "NIT-BHOPAL",
                                            "NIT-ROURKELA",
                                            "NIT-KKR",
                                            "NIT-DURGAPUR"

                                        } ;
    //Load Images
    Integer[]                 imageId = {

                                            R.drawable.iit_bombay,
                                            R.drawable.abhi,
                                            R.drawable.iit_roorkee,
                                            R.drawable.iit_delhi,
                                            R.drawable.iit_madras,
                                            R.drawable.iit_kharagpur,
                                            R.drawable.nit_trichy,
                                            R.drawable.nit_warangal,
                                            R.drawable.nit_bhopal,
                                            R.drawable.nit_rourkela,
                                            R.drawable.nit_kkr,
                                            R.drawable.nit_durgapur
                                        };


    public ListViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Set View
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);

        super.onCreate(savedInstanceState);

        CustomListActivity adapter = new CustomListActivity(ListViewFragment.this.getActivity(), web, imageId);
        list=(ListView)view.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

               // ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                //Create intent
                Intent intent = new Intent(ListViewFragment.this.getActivity(), EventGalleryActivity.class);
                intent.putExtra("title", web[+ position]);
                //intent.putExtra("image", item.getImage());

                //Start details activity
                startActivity(intent);



                //Toast.makeText(ListViewFragment.this.getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}