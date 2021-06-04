package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MusicActivity extends AppCompatActivity {

    private Audio audio;
    private MediaPlayer mediaPlayer;
    private List<Audio> audioList;
    private ImageButton bt_pause_resune, bt_next, bt_back, bt_repeat;
    private TextView nameAudio;
    private ImageView imageView;
    private int pos;
    private boolean repeat = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        audio = (Audio) (getIntent().getSerializableExtra(MainActivity.AUDIO));
        audioList = (List<Audio>) (getIntent().getSerializableExtra(MainActivity.LIST));
        nameAudio = findViewById(R.id.TV_name_ms);
        nameAudio.setText(audio.getNameAudio());
        mediaPlayer = MediaPlayer.create(this, audio.getRAudio());
        imageView = findViewById(R.id.IV_ms);
        imageView.setImageResource(audio.getImage());
        pos = getIntent().getIntExtra(MainActivity.LIST, 0);
        bt_repeat = findViewById(R.id.IB_repeat);
        bt_repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (repeat) {
                    bt_repeat.setImageResource(R.drawable.ic_repeat);
                    repeat = false;
                } else {
                    bt_repeat.setImageResource(R.drawable.ic_repeat_one);
                    repeat = true;
                }
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                if (repeat) {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), audio.getRAudio());
                    nameAudio.setText(audio.getNameAudio());
                    bt_pause_resune.setImageResource(R.drawable.ic_pause);
                    imageView.setImageResource(audio.getImage());
                    start();
                } else {
                    mediaPlayer.stop();
                    if (audioList.size() - 1 == pos) {
                        pos = 0;
                        audio = audioList.get(pos);
                    } else
                        audio = audioList.get(++pos);
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), audio.getRAudio());
                    nameAudio.setText(audio.getNameAudio());
                    bt_pause_resune.setImageResource(R.drawable.ic_pause);
                    imageView.setImageResource(audio.getImage());
                    start();
                }
            }
        });
        start();

        bt_next = findViewById(R.id.IB_ms_next_track);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (repeat) {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), audio.getRAudio());
                    nameAudio.setText(audio.getNameAudio());
                    bt_pause_resune.setImageResource(R.drawable.ic_pause);
                    imageView.setImageResource(audio.getImage());
                    start();
                } else {
                    mediaPlayer.stop();
                    if (audioList.size() - 1 == pos) {
                        pos = 0;
                        audio = audioList.get(pos);
                    } else
                        audio = audioList.get(++pos);
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), audio.getRAudio());
                    nameAudio.setText(audio.getNameAudio());
                    bt_pause_resune.setImageResource(R.drawable.ic_pause);
                    imageView.setImageResource(audio.getImage());
                    start();
                }
            }
        });
        bt_back = findViewById(R.id.IB_ms_back_track);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (repeat) {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), audio.getRAudio());
                    nameAudio.setText(audio.getNameAudio());
                    bt_pause_resune.setImageResource(R.drawable.ic_pause);
                    imageView.setImageResource(audio.getImage());
                    start();
                } else {
                    mediaPlayer.stop();
                    if (pos == 0) {
                        pos = audioList.size() - 1;
                        audio = audioList.get(pos);
                    } else
                        audio = audioList.get(--pos);
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), audio.getRAudio());
                    nameAudio.setText(audio.getNameAudio());
                    bt_pause_resune.setImageResource(R.drawable.ic_pause);
                    imageView.setImageResource(audio.getImage());
                    start();
                }
            }
        });
        bt_pause_resune = findViewById(R.id.IB_ms_pause_resume);
        bt_pause_resune.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                bt_pause_resune.setImageResource(R.drawable.ic_resume);
                pause();
            } else {
                bt_pause_resune.setImageResource(R.drawable.ic_pause);
                start();
            }
        });
    }

    private void start() {
        mediaPlayer.start();
    }

    private void pause() {
        mediaPlayer.pause();
    }
}