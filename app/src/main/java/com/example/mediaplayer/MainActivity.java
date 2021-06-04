package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String AUDIO = "AUDIO";
    public static final String LIST = "LIST";
    public static final String POS = "POS";
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        listView = findViewById(R.id.list_view);
        ArrayList<Audio> audioList = new ArrayList<>();
        audioList.add(new Audio(1, R.raw.overwhelmed, "Overwhelmed",R.raw.royalandtheserpent));
        audioList.add(new Audio(2,R.raw.deadwrong,"Daed Wrong",R.raw.deadwrongimage));
        AudioAdapter audioAdapter = new AudioAdapter(this, R.layout.music_view, audioList);
        listView.setAdapter(audioAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MusicActivity.class);
                intent.putExtra(AUDIO, audioList.get(position));
                intent.putExtra(LIST, audioList);
                intent.putExtra(POS, position);
                startActivity(intent);
            }
        });
        ;
    }
}