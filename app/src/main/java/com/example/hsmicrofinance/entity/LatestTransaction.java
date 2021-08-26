package com.example.hsmicrofinance.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class LatestTransaction implements Parcelable {
    private String trxID;

    private int amount;
    private int balance;
    private int fee;
    private String type;
    private String status;
    private String date;

    public LatestTransaction() {
    }

    public LatestTransaction(String trxID, int amount, int balance, int fee, String type, String status, String date) {
        this.trxID = trxID;
        this.amount = amount;
        this.balance = balance;
        this.fee = fee;
        this.type = type;
        this.status = status;
        this.date = date;
    }

    protected LatestTransaction(Parcel in) {
        trxID = in.readString();
        amount = in.readInt();
        balance = in.readInt();
        fee = in.readInt();
        type = in.readString();
        status = in.readString();
        date = in.readString();
    }

    public static final Creator<LatestTransaction> CREATOR = new Creator<LatestTransaction>() {
        @Override
        public LatestTransaction createFromParcel(Parcel in) {
            return new LatestTransaction(in);
        }

        @Override
        public LatestTransaction[] newArray(int size) {
            return new LatestTransaction[size];
        }
    };

    public String getTrxID() {
        return trxID;
    }

    public void setTrxID(String trxID) {
        trxID = trxID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LatestTransaction that = (LatestTransaction) o;
        return getAmount() == that.getAmount() &&
                getBalance() == that.getBalance() &&
                getFee() == that.getFee() &&
                getTrxID().equals(that.getTrxID()) &&
                getType().equals(that.getType()) &&
                getStatus().equals(that.getStatus()) &&
                getDate().equals(that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTrxID(), getAmount(), getBalance(), getFee(), getType(), getStatus(), getDate());
    }

    @Override
    public String toString() {
        return "LatestTransaction{" +
                "TrxID='" + trxID + '\'' +
                ", Amount=" + amount +
                ", Balance=" + balance +
                ", Fee=" + fee +
                ", Type='" + type + '\'' +
                ", Status='" + status + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(trxID);
        dest.writeInt(amount);
        dest.writeInt(balance);
        dest.writeInt(fee);
        dest.writeString(type);
        dest.writeString(status);
        dest.writeString(date);
    }

    public static DiffUtil.ItemCallback<LatestTransaction>sItemCallback = new DiffUtil.ItemCallback<LatestTransaction>() {
        @Override
        public boolean areItemsTheSame(@NonNull LatestTransaction oldItem, @NonNull LatestTransaction newItem) {
            return oldItem.getTrxID().equals(newItem.getTrxID());
        }

        @Override
        public boolean areContentsTheSame(@NonNull LatestTransaction oldItem, @NonNull LatestTransaction newItem) {
            return oldItem.equals(newItem);
        }
    };
}
