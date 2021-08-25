package com.example.hsmicrofinance.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class LatestTransaction implements Parcelable {
    private String TrxID;
    private int Amount;
    private int Balance;
    private int Fee;
    private String Type;
    private String Status;
    private String date;

    public LatestTransaction() {
    }

    public LatestTransaction(String trxID, int amount, int balance, int fee, String type, String status, String date) {
        this.TrxID = trxID;
        this.Amount = amount;
        this.Balance = balance;
        this.Fee = fee;
        this.Type = type;
        this.Status = status;
        this.date = date;
    }

    protected LatestTransaction(Parcel in) {
        TrxID = in.readString();
        Amount = in.readInt();
        Balance = in.readInt();
        Fee = in.readInt();
        Type = in.readString();
        Status = in.readString();
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
        return TrxID;
    }

    public void setTrxID(String trxID) {
        TrxID = trxID;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public int getFee() {
        return Fee;
    }

    public void setFee(int fee) {
        Fee = fee;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
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
                "TrxID='" + TrxID + '\'' +
                ", Amount=" + Amount +
                ", Balance=" + Balance +
                ", Fee=" + Fee +
                ", Type='" + Type + '\'' +
                ", Status='" + Status + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(TrxID);
        dest.writeInt(Amount);
        dest.writeInt(Balance);
        dest.writeInt(Fee);
        dest.writeString(Type);
        dest.writeString(Status);
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
