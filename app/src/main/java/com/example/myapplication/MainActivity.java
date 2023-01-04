package com.example.myapplication;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Button;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.google.gson.Gson;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.lang.String;
public class MainActivity extends AppCompatActivity {

    private EditText edtTitle;
    private EditText edtAuthor;
    private EditText edtPages;
    private Switch switch1;
    private Button applyTextButton;
    private Button saveButton;
    String title;
    String author;
    String pages;
    public static final String SWITCH1 = "switch1";
    private boolean switchOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTitle = findViewById(R.id.edtTitle);
        edtAuthor = findViewById(R.id.edtAuthor);
        edtPages = findViewById(R.id.edtPages);
        switch1 = findViewById(R.id.switch1);
        applyTextButton = findViewById(R.id.apply_text_button);
        saveButton = findViewById(R.id.save_button);
        title = edtTitle.getText().toString();
        author = edtAuthor.getText().toString();
        pages = edtPages.getText().toString();

        applyTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBook();
                }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });
        }

        public void saveData(){
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = prefs.edit();
            Gson gson = new Gson();
            String booksString = gson.toJson(Book.getAddBook());
            editor.putString("books", booksString);
            editor.putBoolean(SWITCH1, switch1.isChecked());
            editor.commit();
            Toast.makeText(this,"DATA SAVED", LENGTH_LONG).show();
    }

    public void addBook(){
        Book.addBook.add(new Book(title, author, pages));
        Toast.makeText(this,"BOOK ADDED", LENGTH_LONG).show();
    }

}