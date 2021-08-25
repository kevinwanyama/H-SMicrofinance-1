package com.example.hsmicrofinance.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class Test implements Parcelable {
    private int id;
    private String title;

    public Test(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Test() {
    }

    protected Test(Parcel in) {
        id = in.readInt();
        title = in.readString();
    }

    public static final Creator<Test> CREATOR = new Creator<Test>() {
        @Override
        public Test createFromParcel(Parcel in) {
            return new Test(in);
        }

        @Override
        public Test[] newArray(int size) {
            return new Test[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return getId() == test.getId() &&
                getTitle().equals(test.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle());
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
    }
    public static DiffUtil.ItemCallback<Test>sItemCallback = new DiffUtil.ItemCallback<Test>() {
        @Override
        public boolean areItemsTheSame(@NonNull Test oldItem, @NonNull Test newItem) {
            return oldItem.getId()==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Test oldItem, @NonNull Test newItem) {
            return oldItem.equals(newItem);
        }
    };
}


