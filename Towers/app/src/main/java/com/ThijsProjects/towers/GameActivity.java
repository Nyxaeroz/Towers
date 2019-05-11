package com.ThijsProjects.towers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.FrameLayout;

public class GameActivity extends AppCompatActivity {

    private GameView view;
    private GameHandler handler;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        view = new GameView(this, getIntent().getExtras().getInt("nr"));
        handler = new GameHandler();
        handler.start(view);


        FrameLayout frame = new FrameLayout(this);
        frame.addView(view);
        setContentView(frame);



    }

}
