package bubble.fesso.com.fessobubble.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import bubble.fesso.com.fessobubble.R;
import bubble.fesso.com.fessobubble.adapter.CustomList;

/**
 * Created by Abhimanoj on 9/11/16.
 */
public class ListViewActivity  extends AppCompatActivity {



    //List View Object
    private ListView     listView;


    //for Set Content In listView
    CustomList              customList;

    String                      webUrl;

    //Event Names
    private String       names1[] = {
            "TechnoFest",
            "Technorion",
            "Workshop-Morphogenesis",
            "Workshop-Waterbiotics",
            "Workshop-Multibotics",
            "Palacio De Karderio",
    };
    //Load Content of Event
    private String       desc1[] = {
            "The technical festival of IIT-Bombay.",// We offer you various domains to show your skills. Come and be a part of India's biggest festival to explore what has been under the covers for years.",
            "Technorion presents to you the electrical events presented by the Electrical Engineering Department.",
            "A parametric design and digital fabrication workshop. Prototyping with virtual machines.",// Handmade Lightweight structures and jury",
            "Know more about the world of development.A new technology to reckon. Be a part of exploration",
            "A robotics workshop involving multiple features. It will take the robotics to a new level.",//A workshop based on Intelligence Multibotics, basic electronics and micro-controller based robots.",
            "A game involving all the imagination you have stored. Break it if you can."
    };


    //Event Names
    private String       names2[] = {
            "Bunk the funk",
            "Battle fiesta",
            "Workshop-Cloud Computing",
            "Workshop-Drop IN",
            "Workshop-Pop Out",
            "Pictography",
    };
    //Load Content of Event
    private String       desc2[] = {
            "A special event to help the students in distress",// We offer you various domains to show your skills. Come and be a part of India's biggest festival to explore what has been under the covers for years.",
            "The fest involving basketball players from around India",
            "A cloud computing workshop to help students get deep knowledge about clous.",// Handmade Lightweight structures and jury",
            "Drop In- a new initiative by the college to help save nature",
            "A service to provide the nuisances of the upcoming bank services",//A workshop based on Intelligence Multibotics, basic electronics and micro-controller based robots.",
            "a competition on photography which will involve pictures from a real world."
    };


    //Event Names
    private String       names3[] = {
            "Festo-Mania",
            "Beat The Heat",
            "Lets Go",
            "The Matrix",
            "Workshop-Multics",
            "Creation- Gone",
    };
    //Load Content of Event
    private String       desc3[] = {
            "The festival involving many competions on handicraft",// We offer you various domains to show your skills. Come and be a part of India's biggest festival to explore what has been under the covers for years.",
            "A baatle of bands to make the loudness reach new ends.",
            "A traffic management event to find a new way of liking rules",// Handmade Lightweight structures and jury",
            "Use your brainy powers to solve the puzzles created by genuises",
            "A multics workshop to mike the level of knowledge in multics.",//A workshop based on Intelligence Multibotics, basic electronics and micro-controller based robots.",
            "Taking creation to another level of imagination and power."
    };


    //Event Names
    private String       names4[] = {
            "Argo",
            "Mission Fiesta",
            "A way into future",
            "Looking into the mind",
            "Workshop-Genetic Info",
            "Bending legs",
    };
    //Load Content of Event
    private String       desc4[] = {
            "The world go wrong when you have tasks performed in total finnesse.Make the same with more creativity.",// We offer you various domains to show your skills. Come and be a part of India's biggest festival to explore what has been under the covers for years.",
            "A fest involving a lot of events on automobiles",
            "Make the future predictable..design new buildings with futuristic approach",// Handmade Lightweight structures and jury",
            "A game involving the politics learnt all this while. ",
            "A workshop on the increasing development in the field of genetics.",//A workshop based on Intelligence Multibotics, basic electronics and micro-controller based robots.",
            "Physical fitness would be tested for all the right reasons"
    };


    //Event Names
    private String       names5[] = {
            "May be there",
            "Brain Teasers",
            "Sophisticated connection",
            "Making the chip",
            "Workshop-Router configuration",
            "Leave the blank",
    };
    //Load Content of Event
    private String       desc5[] = {
            "The way into a new world",// We offer you various domains to show your skills. Come and be a part of India's biggest festival to explore what has been under the covers for years.",
            "The involvement of mind with creation",
            "A game of buiding chips on set with the logics inbuilt.",// Handmade Lightweight structures and jury",
            "Know more about the chip knowledge",
            "A workshop on the new algorithms of router configuration",//A workshop based on Intelligence Multibotics, basic electronics and micro-controller based robots.",
            "Fing the bugs in a program in a limited time"
    };

    //Event Names
    private String       names6[] = {
            "Do it on your own",
            "Kitkat",
            "A snow world",
            "Interstellar",
            "Workshop-Botanical background",
            "Terminator",
    };
    //Load Content of Event
    private String       desc6[] = {
            "The technical festival of IIT-Bombay.",// We offer you various domains to show your skills. Come and be a part of India's biggest festival to explore what has been under the covers for years.",
            "Technorion presents to you the electrical events presented by the Electrical Engineering Department.",
            "A parametric design and digital fabrication workshop. Prototyping with virtual machines.",// Handmade Lightweight structures and jury",
            "Know more about the world of development.A new technology to reckon. Be a part of exploration",
            "A robotics workshop involving multiple features. It will take the robotics to a new level.",//A workshop based on Intelligence Multibotics, basic electronics and micro-controller based robots.",
            "A game involving all the imagination you have stored. Break it if you can."
    };


    //Event Names
    private String       names7[] = {
            "Questomania",
            "Wolverine",
            "Against the gravity",
            "Workshop-Tones",
            "Strange world",
            "Palace on wheels",
    };
    //Load Content of Event
    private String       desc7[] = {
            "The technical festival of IIT-Bombay.",// We offer you various domains to show your skills. Come and be a part of India's biggest festival to explore what has been under the covers for years.",
            "Technorion presents to you the electrical events presented by the Electrical Engineering Department.",
            "A parametric design and digital fabrication workshop. Prototyping with virtual machines.",// Handmade Lightweight structures and jury",
            "Know more about the world of development.A new technology to reckon. Be a part of exploration",
            "A robotics workshop involving multiple features. It will take the robotics to a new level.",//A workshop based on Intelligence Multibotics, basic electronics and micro-controller based robots.",
            "A game involving all the imagination you have stored. Break it if you can."
    };


    //Event Names
    private String       names8[] = {
            "TechoScream",
            "Dead Mind",
            "Workshop-Working brain",
            "Workshop-Made Factory",
            "Workshop-Meagastructures",
            "Vampire Academy",
    };
    //Load Content of Event
    private String       desc8[] = {
            "The technical festival of IIT-Bombay.",// We offer you various domains to show your skills. Come and be a part of India's biggest festival to explore what has been under the covers for years.",
            "Technorion presents to you the electrical events presented by the Electrical Engineering Department.",
            "A parametric design and digital fabrication workshop. Prototyping with virtual machines.",// Handmade Lightweight structures and jury",
            "Know more about the world of development.A new technology to reckon. Be a part of exploration",
            "A robotics workshop involving multiple features. It will take the robotics to a new level.",//A workshop based on Intelligence Multibotics, basic electronics and micro-controller based robots.",
            "A game involving all the imagination you have stored. Break it if you can."
    };



    //Event Names
    private String       names9[] = {
            "KODACHROME",
            "ILLUMINATI",
            "MARKET GURU",
            "FACE OFFS-SOLO",
            "ADAVENTURE",
            "HUNT THE CODE",
    };
    //Load Content of Event
    private String       desc9[] = {
            "The Photography Event of NIT-hopal.",
            "A journey into media management and share market.",
            "A parametric design and digital fabrication workshop. Prototyping with virtual machines.",// Handmade Lightweight structures and jury",
            "This is the annual Dance festival of MANIT Bhopal... ",
            "You may try to solve a problem as a team, but a specific code must be submitted only once.",//A workshop based on Intelligence Multibotics, basic electronics and micro-controller based robots.",
            "Hunt the code is an offline programming event. which tests your logical, mathematical and basic programming skills."
    };


    //Event Names
    private String       names10[] = {
            "Fortune Soldier",
            "Taboo",
            "Workshop-Animal Behaviour",
            "Workshop-Water Conservation",
            "Maze Runner",
            "Sci-fi-world",
    };
    //Load Content of Event
    private String       desc10[] = {
            "The technical festival of IIT-Bombay.",// We offer you various domains to show your skills. Come and be a part of India's biggest festival to explore what has been under the covers for years.",
            "Technorion presents to you the electrical events presented by the Electrical Engineering Department.",
            "A parametric design and digital fabrication workshop. Prototyping with virtual machines.",// Handmade Lightweight structures and jury",
            "Know more about the world of development.A new technology to reckon. Be a part of exploration",
            "A robotics workshop involving multiple features. It will take the robotics to a new level.",//A workshop based on Intelligence Multibotics, basic electronics and micro-controller based robots.",
            "A game involving all the imagination you have stored. Break it if you can."
    };




    //Event Names
    private String       names11[] = {
            "State-Fest",
            "ChamberSecret",
            "The zero Hour",
            "Life of pie",
            "Workshop-Web Analytics",
            "Independence day",
    };
    //Load Content of Event
    private String       desc11[] = {
            "The technical festival of IIT-Bombay.",// We offer you various domains to show your skills. Come and be a part of India's biggest festival to explore what has been under the covers for years.",
            "Technorion presents to you the electrical events presented by the Electrical Engineering Department.",
            "A parametric design and digital fabrication workshop. Prototyping with virtual machines.",// Handmade Lightweight structures and jury",
            "Know more about the world of development.A new technology to reckon. Be a part of exploration",
            "A robotics workshop involving multiple features. It will take the robotics to a new level.",//A workshop based on Intelligence Multibotics, basic electronics and micro-controller based robots.",
            "A game involving all the imagination you have stored. Break it if you can."
    };



    //Event Names
    private String       names12[] = {
            "Tech-Smurf",
            "Chronicles",
            "Wallstreet",
            "The day after",
            "Workshop-Cinematography",
            "Unstoppable",
    };
    //Load Content of Event
    private String       desc12[] = {
            "The technical festival of IIT-Bombay.",// We offer you various domains to show your skills. Come and be a part of India's biggest festival to explore what has been under the covers for years.",
            "Technorion presents to you the electrical events presented by the Electrical Engineering Department.",
            "A parametric design and digital fabrication workshop. Prototyping with virtual machines.",// Handmade Lightweight structures and jury",
            "Know more about the world of development.A new technology to reckon. Be a part of exploration",
            "A robotics workshop involving multiple features. It will take the robotics to a new level.",//A workshop based on Intelligence Multibotics, basic electronics and micro-controller based robots.",
            "A game involving all the imagination you have stored. Break it if you can."
    };


    //Load Images
    private Integer             imageid[] = {
            R.drawable.b1,
            R.drawable.b3,
            R.drawable.t16,
            R.drawable.t17,
            R.drawable.t18,
            R.drawable.t19,
            R.drawable.t20,
            R.drawable.t15
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        final String title = getIntent().getStringExtra("title");

        customList = new CustomList(this, names1, desc1, imageid);

        webUrl      =       "http://www.iitb.ac.in/";

        if(title.toString().equals("IIIT-BOMBAY")) {
            CustomList customList = new CustomList(this, names1, desc1, imageid);
            webUrl="http://www.iitb.ac.in/";
        }
        if(title.toString().equals("IIT-KANPUR") )
        {
            CustomList customList = new CustomList(this, names2, desc2, imageid);
            webUrl="www.iitk.ac.in";
        }
        if(title.toString().equals("IIT-ROORKEE")){
            CustomList customList = new CustomList(this, names3, desc3, imageid);
            webUrl="www.iitr.ac.in/";
        }
        if(title.toString().equals("IIT-DELHI")) {
            CustomList customList = new CustomList(this, names4, desc4, imageid);
            webUrl="http://www.iitd.ac.in/content/contact-us";
        }
        if(title.toString().equals("IIT-MADRAS")){
            CustomList customList = new CustomList(this, names5, desc5, imageid);
            webUrl="https://www.iitm.ac.in/";
        }
        if(title.toString().equals("IITKHARAGPUR")){
            CustomList customList = new CustomList(this, names6, desc6, imageid);
            webUrl="www.iitkgp.ac.in";
        }
        if(title.toString().equals("NIT-TRICHY")){
            CustomList customList = new CustomList(this, names7, desc7, imageid);
            webUrl="http://www.nitt.edu/";
        }
        if(title.toString().equals("NITWARANGAL")){
            CustomList customList = new CustomList(this, names8, desc8, imageid);
            webUrl="http://www.nitw.ac.in/main/";
        }
        if(title.toString().equals("NIT-BHOPAL")){
            CustomList customList = new CustomList(this, names9, desc9, imageid);
            webUrl="http://www.web.manit.ac.in/";
        }
        if(title.toString().equals("NIT-ROURKELA")){
            CustomList customList = new CustomList(this, names10, desc10, imageid);
            webUrl="http://www.nitrkl.ac.in/";
        }
        if(title.toString().equals("NIT-KKR")){
            CustomList customList = new CustomList(this, names11, desc11, imageid);
            webUrl="http://www.nitkkr.ac.in/";
        }
        if(title.toString().equals("NIT-DURGAPUR")){
            CustomList customList = new CustomList(this, names12, desc12, imageid);
            webUrl="http://www.nitdgp.ac.in/";
        }



        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),"You Clicked "+title+names1[i],Toast.LENGTH_SHORT).show();
                //Create intent
                Intent intent = new Intent(ListViewActivity.this, EventDataActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("subtitle", names1[i]);
                intent.putExtra("content", desc1[i]);
                intent.putExtra("weburl", webUrl);

                //Start details activity
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
