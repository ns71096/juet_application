package com.niksharma.juet;


import android.annotation.SuppressLint;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @SuppressLint("SetJavaScriptEnabled")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction frag=fm.beginTransaction();
            switch (item.getItemId()) {

                case R.id.navigation_home:
                    HomeFragment f1=new HomeFragment();
                    frag.replace(R.id.fragment_container,f1).commit();
                    f1.setImages(MainActivity.this);
                    f1.setListView();



                    return true;
                case R.id.navigation_web_view:
                    WebFragment f2=new WebFragment();
                    frag.replace(R.id.fragment_container,f2).commit();

                    return true;
                case R.id.navigation_about_us:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction frag=fm.beginTransaction();
        HomeFragment f1=new HomeFragment();
        frag.replace(R.id.fragment_container,f1).commit();
        f1.setImages(MainActivity.this);
        f1.setListView();






        }
      /*Thread t=new Thread(){
        @Override
            public void run()
        {
            while(!isInterrupted())
            {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img.setImageResource(image[i]);
                        i++;
                        if(i==image.length-1)
                            i=0;
                    }
                });
            }
        }
        };*/


}




