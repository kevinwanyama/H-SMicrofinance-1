package com.example.hsmicrofinance.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {
    @SerializedName("loan_packages")
    @Expose
    private LoanPackages loanPackages;

    /**
     * No args constructor for use in serialization
     *
     */
    public Example() {
    }

    /**
     *
     * @param loanPackages
     */
    public Example(LoanPackages loanPackages) {
        super();
        this.loanPackages = loanPackages;
    }

    public LoanPackages getLoanPackages() {
        return loanPackages;
    }

    public void setLoanPackages(LoanPackages loanPackages) {
        this.loanPackages = loanPackages;
    }
}
