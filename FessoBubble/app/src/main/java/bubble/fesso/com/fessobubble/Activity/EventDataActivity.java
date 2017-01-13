package bubble.fesso.com.fessobubble.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.EditText;
import android.widget.TextView;

import bubble.fesso.com.fessobubble.R;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by root on 9/11/16.
 */
public class EventDataActivity extends Activity {

    String              vidAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_article_detail);


        String title = getIntent().getStringExtra("title");
        String subTitle = getIntent().getStringExtra("subtitle");
        String content = getIntent().getStringExtra("content");
        String weburl = getIntent().getStringExtra("weburl");




        TextView titleTextView = (TextView) findViewById(R.id.author);
        titleTextView.setText(title);

        TextView subtitleTextView = (TextView) findViewById(R.id.quote);
        subtitleTextView.setText(subTitle);

        TextView contentEditTextView=(TextView) findViewById(R.id.content);
        contentEditTextView.setText(content);

        final TextView myClickableUrl = (TextView) findViewById(R.id.weburl);
        myClickableUrl.setText(weburl);
        Linkify.addLinks(myClickableUrl, Linkify.WEB_URLS);




        vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.manit;
        if(title.toString().equals("IIIT-BOMBAY")) {
           vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.delhi;
        }
            if(title.toString().equals("IIT-KANPUR") )
        {
            vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.kanpur;
        }
        if(title.toString().equals("IIT-ROORKEE")){
            vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.roorkee;
        }
        if(title.toString().equals("IIT-DELHI")){
            vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.delhi;
        }
        if(title.toString().equals("IIT-MADRAS")){
            vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.madras;
        }
        if(title.toString().equals("IITKHARAGPUR")){
            vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.warangal;
        }
        if(title.toString().equals("NIT-TRICHY")){
            vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.trichy;
        }
        if(title.toString().equals("NITWARANGAL")){
            vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.warangal;
        }
        if(title.toString().equals("NIT-BHOPAL")){
            vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.manit;
        }
        if(title.toString().equals("NIT-ROURKELA")){
            vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.roorkee;
        }
        if(title.toString().equals("NIT-KKR")){
            vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.madras;
        }
        if(title.toString().equals("NIT-DURGAPUR")){
            vidAddress = "android.resource://" + getPackageName() + "/" + R.raw.manit;
        }


        //Play Video

        Uri vidUri = Uri.parse(vidAddress);

        VideoView vidView = (VideoView)findViewById(R.id.myVideo);
        vidView.setVideoURI(vidUri);
        vidView.start();

        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(vidView);
        vidView.setMediaController(vidControl);



    }


}
