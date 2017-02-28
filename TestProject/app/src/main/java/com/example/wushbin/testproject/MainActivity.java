package com.example.wushbin.testproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    /**
     * Clean up the media player by releasing its resources.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.ama);

        Button play = (Button) findViewById(R.id.play);

        play.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick (View view){
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this, "I am done!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });




        Button pause = (Button) findViewById(R.id.pause);
        pause.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick (View view){
                mediaPlayer.pause();
            }
        });


    }




}
