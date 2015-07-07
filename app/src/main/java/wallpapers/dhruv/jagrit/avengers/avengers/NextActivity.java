package wallpapers.dhruv.jagrit.avengers.avengers;

/**
 * Created by JAGRIT on 20-04-2015.
 */
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Arrays;


public class NextActivity extends ActionBarActivity {
    private Toolbar toolbar;
    static String THOR_ID="thor1";
    static String CAP_ID="cap1";
    static String IRON_ID="iron1";
    static String WIDOW_ID="widow1";
    static String HAWK_ID="hawk1";
    static String HULK_ID="hulk1";

    static ArrayList<Integer> avengers1 = new ArrayList<>(Arrays.asList(
            R.drawable.image01camerica, R.drawable.image02camerica, R.drawable.image03camerica, R.drawable.image04camerica
            , R.drawable.image05camerica, R.drawable.image06camerica, R.drawable.image07camerica, R.drawable.image08camerica));

    static ArrayList<Integer> avengers2 = new ArrayList<>(Arrays.asList(
            R.drawable.image01iron,R.drawable.image02iron,R.drawable.image03iron,R.drawable.image04iron,R.drawable.image05iron,
            R.drawable.image06iron,R.drawable.ironiron01,R.drawable.ironiron02

    ));
    static ArrayList<Integer> avengers3 = new ArrayList<>(Arrays.asList(
            R.drawable.image01thor,R.drawable.image02thor,R.drawable.image03thor,R.drawable.image04thor
            ,R.drawable.image05thor,R.drawable.thorthor01,R.drawable.thorthor02));

    static ArrayList<Integer> avengers4 = new ArrayList<>(Arrays.asList(
            R.drawable.image1hulk,R.drawable.image2hulk,R.drawable.image3hulk,R.drawable.image4hulk,R.drawable.image5hulk
            ,R.drawable.image6hulk,R.drawable.image07hulk,R.drawable.hulkhulk01,R.drawable.hulkhulk02));

    static ArrayList<Integer> avengers5 = new ArrayList<>(Arrays.asList(
            R.drawable.hawk01,R.drawable.hawk02,R.drawable.hawk03,R.drawable.hawk04,R.drawable.hawk05,R.drawable.hawk06
            ,R.drawable.hawk07));

    static  ArrayList<Integer> avengers6 = new ArrayList<>(Arrays.asList(

            R.drawable.blackwidow01,R.drawable.blackwidow02,R.drawable.blackwidow03,R.drawable.blackwidow04
            ,R.drawable.blackwidow05,R.drawable.blackwidow06,R.drawable.blackwidow07,R.drawable.blackwidow08
    ));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        GridView gridView = (GridView) findViewById(R.id.gridView1);
        Intent intent = getIntent();
        if(intent.getIntegerArrayListExtra("cap")!=null){
            gridView.setAdapter(new ImageAdapter(this,avengers1));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l1) {
                    Intent i1 = new Intent(NextActivity.this,CaptainActivity.class);
                    i1.putExtra(CAP_ID,(int) l1);
                    startActivity(i1);
                }
            });
        }

        if(intent.getIntegerArrayListExtra("iron")!=null){
            gridView.setAdapter(new ImageAdapter(this,avengers2));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l2) {
                    Intent i2 = new Intent(NextActivity.this,IronActivity.class);
                    i2.putExtra(IRON_ID,(int) l2);
                    startActivity(i2);
                }
            });
        }
        if(intent.getIntegerArrayListExtra("thor")!=null){
            gridView.setAdapter(new ImageAdapter(this,avengers3));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l3) {
                    Intent i3 = new Intent(NextActivity.this,ThorActivity.class);
                    i3.putExtra(THOR_ID,(int) l3);
                    startActivity(i3);
                }
            });
        }

        if(intent.getIntegerArrayListExtra("hulk")!=null){
            gridView.setAdapter(new ImageAdapter(this,avengers4));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l4) {
                    Intent i4 = new Intent(NextActivity.this,HulkActivity.class);
                    i4.putExtra(HULK_ID,(int) l4);
                    startActivity(i4);
                }
            });
        }

        if(intent.getIntegerArrayListExtra("hawk")!=null){
            gridView.setAdapter(new ImageAdapter(this,avengers5));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l5) {
                    Intent intent = new Intent(NextActivity.this,HawkActivity.class);
                    intent.putExtra(HAWK_ID,(int) l5);
                    startActivity(intent);
                }
            });
        }

        if(intent.getIntegerArrayListExtra("widow")!=null){
            gridView.setAdapter(new ImageAdapter(this,avengers6));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l6) {
                    Intent intent = new Intent(NextActivity.this,WidowActivity.class);
                    intent.putExtra(WIDOW_ID,(int) l6);
                    startActivity(intent);
                }
            });
        }




    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_next, menu);
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
        if(id == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }


        return super.onOptionsItemSelected(item);
    }
}
