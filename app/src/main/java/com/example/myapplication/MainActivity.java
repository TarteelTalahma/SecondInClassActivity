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
        Book [] books = new Book[10];
        books[0] = new Book("java", "marthen","555");
        title = edtTitle.getText().toString();
        author = edtAuthor.getText().toString();
        pages = edtPages.getText().toString();

        applyTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book.addBook.add(new Book(title, author, pages));
          //      Toast toast = Toast.makeText(this,"BOOK SAVED", LENGTH_LONG).show();
                //
                }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = prefs.edit();
                Gson gson = new Gson();
                String booksString = gson.toJson(books);
                editor.putString("books", booksString);
                editor.commit();
                //Toast toast = Toast.makeText(this,"Data Saved", LENGTH_LONG).show();
            }
        });



    }

}