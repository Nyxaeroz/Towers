package com.ThijsProjects.towers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int nr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText myEditText = (EditText) findViewById(R.id.editText);
        nr = Integer.parseInt(myEditText.getText().toString());
    }

    public void onPlus(View v){
        try {
            final EditText myEditText = (EditText) findViewById(R.id.editText);
            if(nr < 9) {
                this.nr = Integer.parseInt(myEditText.getText().toString()) + 1;
                myEditText.setText("" + nr, TextView.BufferType.EDITABLE);
            }
        } catch (Exception e){
            Toast toast = (Toast) Toast.makeText(this, "Enter a value between 3 and 9", Toast.LENGTH_SHORT);
            toast.show();

        }
    }

    public void onMinus(View v){
        try {
            final EditText myEditText = (EditText) findViewById(R.id.editText);
            if(nr > 3) {
                this.nr = Integer.parseInt(myEditText.getText().toString()) - 1;
                myEditText.setText("" + nr, TextView.BufferType.EDITABLE);
            }
        } catch (Exception e){
            Toast toast = (Toast) Toast.makeText(this, "Enter a value between 3 and 9", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onStart(View v) {
        Intent game = new Intent(this, GameActivity.class);
        game.putExtra("nr", this.nr);
        startActivity(game);
    }
}
