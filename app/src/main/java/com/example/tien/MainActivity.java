package com.example.tien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tien.Adapter.SongAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Song> songList;
    private RecyclerView recyclerView;
    private SongAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo danh sách các bài hát
        songList = new ArrayList<>();
        songList.add(new Song(1, "Bài hát 1"));
        songList.add(new Song(2, "Bài hát 2"));
        songList.add(new Song(3, "Bài hát 3"));
        songList.add(new Song(4, "Bài hát 4"));
        songList.add(new Song(5, "Bài hát 5"));
        songList.add(new Song(6, "Bài hát 6"));

        // Thiết lập RecyclerView
        recyclerView = findViewById(R.id.recycler_view_songs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        songAdapter = new SongAdapter(songList);
        recyclerView.setAdapter(songAdapter);

        // Thêm bài hát mới khi người dùng nhấp vào FloatingActionButton
        FloatingActionButton fabAddSong = findViewById(R.id.fab_add_song);
        fabAddSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int songNumber = songList.size() + 1;
                String songInfo = "Bài hát " + songNumber;
                Song newSong = new Song(songNumber, songInfo);
                songList.add(newSong);
                songAdapter.notifyItemInserted(songList.size() - 1);
                recyclerView.scrollToPosition(songList.size() - 1);
            }
        });

        // Swipe To Delete
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = viewHolder.getAdapterPosition();
                        songList.remove(position);
                        songAdapter.notifyItemRemoved(position);
                    }
                });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}