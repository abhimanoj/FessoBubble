package bubble.fesso.com.fessobubble.Activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;

import bubble.fesso.com.fessobubble.R;
import bubble.fesso.com.fessobubble.adapter.GridViewAdapter;
import bubble.fesso.com.fessobubble.pojo.ImageItem;

/**
 * Created by Abhimanoj on 26/11/16.
 */
public class EventGalleryActivity  extends AppCompatActivity {

    private GridView gridView;
    private GridViewAdapter gridAdapter;
    String[] SubTitle = new String[]{"SuperSonic_101", "TechnoSearch", "LostStories", "MegaShow", "BigBang", "AeroAstro", "Hoverun_3.0", "Pavitram", "Anveshan", "ImageSubTitle10", "ImageSubTitle11", "ImageSubTitle12", "ImageSubTitle1", "ImageSubTitle2", "ImageSubTitle3", "ImageSubTitle4", "ImageSubTitle5", "ImageSubTitle6", "ImageSubTitle7", "ImageSubTitle8", "ImageSubTitle9", "ImageSubTitle10", "ImageSubTitle11", "ImageSubTitle12"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_event);


        gridView = (GridView) findViewById(R.id.gridViewGallery);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);


        // CustomList customList = new CustomList(this, names, desc, imageid);
        final String title = getIntent().getStringExtra("title");
        //  listView = (ListView) view.findViewById(R.id.listView);
        //listView.setAdapter(customList);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                //Create intent
                Intent intent = new Intent(EventGalleryActivity.this, DetailsActivity.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("image", item.getImage());

                //Start details activity
                startActivity(intent);
            }
        });


    }


    /**
     * Prepare some  data for gridview
     */
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids2);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, SubTitle[i]));
        }
        return imageItems;

    }
}


