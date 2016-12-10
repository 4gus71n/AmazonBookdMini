package com.amazon.amazonbooksmini;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static final String GET_BOOKS_URL = "http://de-coding-test.s3.amazonaws.com/books.json";
    public static final String BUNDLE_BOOKS = "bundle_books";

    private ProgressBar vProgressBar;
    private RecyclerView vRecyclerView;
    private BooksAdapter mAdapter;
    private ArrayList<Book> mBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        vRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new BooksAdapter();


        vRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        vRecyclerView.setAdapter(mAdapter);

        requestBooks();

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putParcelableArrayList(BUNDLE_BOOKS, mBooks);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mBooks = savedInstanceState.getParcelableArrayList(BUNDLE_BOOKS);
        if (mBooks != null) {
            mAdapter.setBooks(mBooks);
            mAdapter.notifyDataSetChanged();
        }
    }

    /**
     * Sends the HTTP GET request to get the books
     */
    private void requestBooks() {
        Ion.with(getApplicationContext()).load(GET_BOOKS_URL)
                .progressBar(vProgressBar)
                .asString().withResponse().setCallback(new FutureCallback<Response<String>>() {
            @Override
            public void onCompleted(Exception e, Response<String> result) {
                String jsonResponse = result.getResult();
                Book[] booksArray = new Gson().fromJson(jsonResponse, Book[].class);
                mBooks = new ArrayList<>(Arrays.asList(booksArray));
                mAdapter.setBooks(mBooks);
                mAdapter.notifyDataSetChanged();
            }
        });

    }
}
