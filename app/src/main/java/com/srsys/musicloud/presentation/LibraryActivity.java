package com.srsys.musicloud.presentation;

import com.srsys.musicloud.R;
import com.srsys.musicloud.R.id;
import com.srsys.musicloud.R.layout;

import android.app.Activity;
import android.view.View;

public abstract class LibraryActivity extends Activity implements  View.OnClickListener{
    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create all the buttons
        Button one = (Button) findViewById(R.id.song1);
        one.setOnClickListener(this); // calling onClick() method

        Button two = (Button) findViewById(R.id.song2);
        two.setOnClickListener(this); // calling onClick() method

        Button three = (Button) findViewById(R.id.song3);
        three.setOnClickListener(this); // calling onClick() method

        Button four = (Button) findViewById(R.id.song4);
        four.setOnClickListener(this); // calling onClick() method

        Button five = (Button) findViewById(R.id.song5);
        five.setOnClickListener(this); // calling onClick() method
    }



    @Override
    public void onClick(View v) {
        Intent playIntent = new Intent(LibraryActivity.this, PlayActivity.class);
        switch (v.getId()) {
            case R.id.song1:
                playIntent.putExtra("position", 1);
                break;
            case R.id.song2:
                // do your code
                playIntent.putExtra("position", 2);
                break;
            case R.id.song3:
                // do your code
                playIntent.putExtra("position", 3);
                break;
            case R.id.song4:
                // do your code
                playIntent.putExtra("position", 4);
                break;
            case R.id.song5:
                // do your code
                playIntent.putExtra("position", 5);
                break;
            default:
                break;


        }
        LibraryActivity.this.startActivity(playIntent);
    } */
}