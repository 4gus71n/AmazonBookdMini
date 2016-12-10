package com.amazon.amazonbooksmini;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agustin Tomas Larghi on 09/12/2016.
 * Email: agustin.tomas.larghi@gmail.com
 */
public class BooksAdapter extends RecyclerView.Adapter<BooksViewHolder> {

    private List<Book> mBooks = new ArrayList<>();

    @Override
    public BooksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_books, parent, false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BooksViewHolder holder, int position) {
        holder.loadBook(mBooks.get(position));
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    public void setBooks(List<Book> mBooks) {
        this.mBooks = mBooks;
    }
}
