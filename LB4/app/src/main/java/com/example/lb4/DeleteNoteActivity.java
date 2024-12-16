package com.example.lb4;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DeleteNoteActivity extends AppCompatActivity {

    private ListView listViewDeleteNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        listViewDeleteNotes = findViewById(R.id.listViewDeleteNotes);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.notesList);
        listViewDeleteNotes.setAdapter(adapter);

        listViewDeleteNotes.setOnItemClickListener((parent, view, position, id) -> {
            MainActivity.notesList.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, R.string.note_deleted, Toast.LENGTH_SHORT).show();
        });
    }
}
