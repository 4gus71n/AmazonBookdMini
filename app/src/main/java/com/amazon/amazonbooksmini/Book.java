package com.amazon.amazonbooksmini;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Agustin Tomas Larghi on 09/12/2016.
 * Email: agustin.tomas.larghi@gmail.com
 */
public class Book implements Parcelable {

    @SerializedName("title")
    private String title;
    @SerializedName("author")
    private String author;
    @SerializedName("imageURL")
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeString(this.imageUrl);
    }

    public Book() {
    }

    protected Book(Parcel in) {
        this.title = in.readString();
        this.author = in.readString();
        this.imageUrl = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
