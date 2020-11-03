package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URI;

public class info_act extends AppCompatActivity {
    private VideoView videoview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);
        videoview = (VideoView) findViewById(R.id.vd);

        String  ruta = "android.rosourse://" + getPackageName() + "/" + R.raw.videod; // ruta del video
        Uri uri = Uri.parse(ruta);
        videoview.setVideoURI(uri);
            // Control de navigacion
        MediaController media = new MediaController(this);
        videoview.setMediaController(media);

    }
    public void Maps (View v)
    {
        Intent i = new Intent(this,MapsActivity.class);
        startActivity(i);
    }

}