package com.example.hsmicrofinance.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class InvestmentHistory implements Parcelable {
    private int id;
    private String pkg;
    private int amount;
    private int percent;
    private int total;
    private String start;
    private String rdate;
    private String status;

    public InvestmentHistory() {
    }

    public InvestmentHistory(int id, String pkg, int amount, int percent, int total, String start, String rdate, String status) {
        this.id = id;
        this.pkg = pkg;
        this.amount = amount;
        this.percent = percent;
        this.total = total;
        this.start = start;
        this.rdate = rdate;
        this.status = status;
    }

    protected InvestmentHistory(Parcel in) {
        id = in.readInt();
        pkg = in.readString();
        amount = in.readInt();
        percent = in.readInt();
        total = in.readInt();
        start = in.readString();
        rdate = in.readString();
        status = in.readString();
    }

    public static final Creator<InvestmentHistory> CREATOR = new Creator<InvestmentHistory>() {
        @Override
        public InvestmentHistory createFromParcel(Parcel in) {
            return new InvestmentHistory(in);
        }

        @Override
        public InvestmentHistory[] newArray(int size) {
            return new InvestmentHistory[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InvestmentHistory{" +
                "id=" + id +
                ", pkg='" + pkg + '\'' +
                ", amount=" + amount +
                ", percent=" + percent +
                ", total=" + total +
                ", start='" + start + '\'' +
                ", rdate='" + rdate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvestmentHistory that = (InvestmentHistory) o;
        return getId() == that.getId() &&
                getAmount() == that.getAmount() &&
                getPercent() == that.getPercent() &&
                getTotal() == that.getTotal() &&
                getPkg().equals(that.getPkg()) &&
                getStart().equals(that.getStart()) &&
                getRdate().equals(that.getRdate()) &&
                getStatus().equals(that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPkg(), getAmount(), getPercent(), getTotal(), getStart(), getRdate(), getStatus());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(pkg);
        dest.writeInt(amount);
        dest.writeInt(percent);
        dest.writeInt(total);
        dest.writeString(start);
        dest.writeString(rdate);
        dest.writeString(status);
    }
    public static DiffUtil.ItemCallback<InvestmentHistory>sItemCallback = new DiffUtil.ItemCallback<InvestmentHistory>() {
        @Override
        public boolean areItemsTheSame(@NonNull InvestmentHistory oldItem, @NonNull InvestmentHistory newItem) {
            return oldItem.getId()==(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull InvestmentHistory oldItem, @NonNull InvestmentHistory newItem) {
            return oldItem.equals(newItem);
        }
    };
}
