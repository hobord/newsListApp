package hu.netlab.orsi.newslistapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class NewsItem implements Parcelable {

    private String mTitle;
    private String mSectionName;
    private Date mPublishedDate;
    private String mUrl;
    private String mThumbnail;
    private String mContentText;

    public NewsItem(String title, String section_name, Date published_date, String url, String thumbnail, String content_text) {
        mTitle = title;
        mSectionName = section_name;
        mPublishedDate = published_date;
        mUrl = url;
        mThumbnail = thumbnail;
        mContentText = content_text;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public Date getPublishedDate() {
        return mPublishedDate;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public String getContentText() {
        return mContentText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Parcelable
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeString(mContentText);
        parcel.writeString(mSectionName);
        parcel.writeString(mThumbnail);
        parcel.writeLong(this.mPublishedDate.getTime());
    }

    private NewsItem(Parcel in) {
        mTitle = in.readString();
        mContentText = in.readString();
        mSectionName = in.readString();
        mThumbnail = in.readString();
        mPublishedDate = new Date(in.readLong());
    }
    public static final Parcelable.Creator<NewsItem> CREATOR
            = new Parcelable.Creator<NewsItem>() {
        public NewsItem createFromParcel(Parcel in) {
            return new NewsItem(in);
        }

        public NewsItem[] newArray(int size) {
            return new NewsItem[size];
        }
    };
}
