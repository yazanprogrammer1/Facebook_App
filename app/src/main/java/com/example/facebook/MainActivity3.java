package com.example.facebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

public class MainActivity3 extends AppCompatActivity {

    Button com,com2,com3;
    LinearLayout comvisi,comvisi2;
    CardView post1,post2;
    BottomAppBar bottomAppBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
//..............................................................
        com = (Button) findViewById(R.id.coment1);
        comvisi = (LinearLayout) findViewById(R.id.comvisi);
        post1 =(CardView) findViewById(R.id.post1);
        com2 =(Button) findViewById(R.id.coment2);
        comvisi2 = (LinearLayout) findViewById(R.id.comvisi2);
        post2 = (CardView)  findViewById(R.id.post2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitle("Home");
        toolbar.setTitleMarginEnd(20);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        setSupportActionBar(toolbar);

        bottomAppBar = (BottomAppBar) findViewById(R.id.bottomappbar);
        bottomAppBar.setNavigationIcon(R.drawable.ic_baseline_person_24);
        setSupportActionBar(bottomAppBar);
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
            }
        });


        //.................................................

        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comvisi.getVisibility() == v.VISIBLE){
                    TransitionManager.beginDelayedTransition(post1,new AutoTransition());

                    comvisi.setVisibility(v.GONE);
                }else {
                    TransitionManager.beginDelayedTransition(post1, new AutoTransition());
                    comvisi.setVisibility(View.VISIBLE);
                }
            }
        });

        com2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comvisi2.getVisibility() == v.VISIBLE){
                    TransitionManager.beginDelayedTransition(post2 , new AutoTransition());
                    comvisi2.setVisibility(View.GONE);
                }else {
                    TransitionManager.beginDelayedTransition(post2, new AutoTransition());
                    comvisi2.setVisibility(View.VISIBLE);
                }
            }
        });

    }//end

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionitem, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.favorite:
                Toast.makeText(getApplicationContext(), "Favorite", Toast.LENGTH_SHORT).show();
                bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                break;
            case R.id.search:
                Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
                bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                break;


        }

        return true;
    }


}