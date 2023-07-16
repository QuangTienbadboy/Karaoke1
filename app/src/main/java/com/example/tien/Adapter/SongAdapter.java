package com.example.tien.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tien.R;
import com.example.tien.Song;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    private List<Song> songList;

    public SongAdapter(List<Song> songList) {
        this.songList = songList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songList.get(position);

        holder.textViewSongNumber.setText(String.valueOf(song.getSongNumber()));
        holder.textViewSongInfo.setText(song.getSongInfo());
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSongNumber;
        TextView textViewSongInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSongNumber = itemView.findViewById(R.id.text_view_song_number);
            textViewSongInfo = itemView.findViewById(R.id.text_view_song_info);
        }
    }
}