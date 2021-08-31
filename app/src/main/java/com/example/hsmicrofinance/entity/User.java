package com.example.hsmicrofinance.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class User implements  Parcelable{
    private String name;
    private String email;
    private String phone_number;
    private String kra;
    private String password;
    private String image;
    private String term_condition;

   /* 'name'
            'email'
            'phone_number' (Structure this in a way that user first selects country code and enters phone nom)
            'kra'
            'password'
            'image'
            'term_condition'*/

    public User() {
    }

    public User(String name, String email, String phone_number, String kra, String password, String image, String term_condition) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.kra = kra;
        this.password = password;
        this.image = image;
        this.term_condition = term_condition;
    }

    protected User(Parcel in) {
        name = in.readString();
        email = in.readString();
        phone_number = in.readString();
        kra = in.readString();
        password = in.readString();
        image = in.readString();
        term_condition = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String  getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getKra() {
        return kra;
    }

    public void setFee(String kra) {
        this.kra = kra;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String type) {
        this.image = image;
    }

    public String getTerm_condition() {
        return term_condition;
    }

    public void setTerm_condition(String term_condition) {
        this.term_condition = term_condition;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return getName() == that.getName() &&
                getEmail() == that.getEmail() &&
                getPhone_number() == that.getPhone_number() &&
                getKra().equals(that.getKra()) &&
                getPassword().equals(that.getPassword()) &&
                getImage().equals(that.getImage()) &&
                getTerm_condition().equals(that.getTerm_condition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), getPhone_number(), getKra(), getPassword(), getImage(), getTerm_condition());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email=" + email +
                ", phone_number=" + phone_number +
                ", kra=" + kra +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", term_condition=" + term_condition +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(phone_number);
        dest.writeString(kra);
        dest.writeString(password);
        dest.writeString(image);
        dest.writeString(term_condition);
    }

    public static DiffUtil.ItemCallback<User>sItemCallback = new DiffUtil.ItemCallback<User>() {
        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.getEmail().equals(newItem.getEmail());
        }

        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.equals(newItem);
        }
    };
}
