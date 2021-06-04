package com.example.mediaplayer;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class AudioAdapter extends ArrayAdapter<Audio> {
    public AudioAdapter(Context context, int resource, List<Audio> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Audio audio = getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.music_view, parent, false);
        TextView nameAudio = convertView.findViewById(R.id.TV_nameAudio);

        ImageView imageView = convertView.findViewById(R.id.image_view);
        nameAudio.setText(audio.getNameAudio());
        imageView.setImageResource(audio.getImage());
        
        return convertView;
    }

}

