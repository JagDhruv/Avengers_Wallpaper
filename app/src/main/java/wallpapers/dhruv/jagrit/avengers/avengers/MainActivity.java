package wallpapers.dhruv.jagrit.avengers.avengers;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
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


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;

    protected static final String EXTRA_ID="pos";
    static ArrayList<Integer> avengers = new ArrayList<>(Arrays.asList(
            R.drawable.ultron01,R.drawable.group01,R.drawable.ultron02,R.drawable.group02,R.drawable.ultron03,
            R.drawable.group03,R.drawable.ultron04,R.drawable.group04,R.drawable.ultron05,R.drawable.quick01,R.drawable.group_1,R.drawable.group_2,R.drawable.group_3,R.drawable.group_4));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        Fragment_1 drawerFragment =(Fragment_1)getSupportFragmentManager().findFragmentById(R.id.navigation);

        drawerFragment.setUp(R.id.navigation,(DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        GridView gridView = (GridView) findViewById(R.id.gridView);

        Intent intent = getIntent();
        if(intent.getIntegerArrayListExtra("ültron")!=null){
            gridView.setAdapter(new ImageAdapter(this,avengers));
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l4) {
                    Intent intent = new Intent(MainActivity.this,FullImageActivity.class);
                    intent.putExtra(EXTRA_ID,(int) l4);
                    startActivity(intent);
                }
            });
        }


        //Dhruv
        gridView.setAdapter(new ImageAdapter(this,avengers));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,FullImageActivity.class);
                intent.putExtra(EXTRA_ID,(int) l);
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
        if(id == R.id.navigation)
        {
            startActivity(new Intent(this, NextActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
