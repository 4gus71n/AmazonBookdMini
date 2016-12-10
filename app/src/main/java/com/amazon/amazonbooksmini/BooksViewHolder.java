package com.amazon.amazonbooksmini;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Agustin Tomas Larghi on 09/12/2016.
 * Email: agustin.tomas.larghi@gmail.com
 */
public class BooksViewHolder extends RecyclerView.ViewHolder {
    private final ImageView vThumbnail;
    private final TextView vTitle;
    private final TextView vAuthor;

    public BooksViewHolder(View itemView) {
        super(itemView);
        vThumbnail = (ImageView) itemView.findViewById(R.id.book_thumbnail);
        vTitle = (TextView) itemView.findViewById(R.id.book_name);
        vAuthor = (TextView) itemView.findViewById(R.id.book_author);
    }

    public void loadBook(Book book) {
        Glide.with(itemView.getContext()).load(book.getImageUrl()).into(vThumbnail);
        vTitle.setText(book.getTitle());
        vAuthor.setText(book.getAuthor());
    }
}
