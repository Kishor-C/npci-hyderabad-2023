package com.npci.secondms.beans;

public class Wallet {
	// walletId, walletAmount, account:Account, totalAmount
	private long walletId;
	private double walletAmount = 500; // default wallet amount
	private Account accountDetails;
	private double totalAmount; // adding walletAmount + accountDetails.balance
	
	// generate setters & getters for all the properties
	public long getWalletId() {
		return walletId;
	}
	public void setWalletId(long walletId) {
		this.walletId = walletId;
	}
	public double getWalletAmount() {
		return walletAmount;
	}
	public void setWalletAmount(double walletAmount) {
		this.walletAmount = walletAmount;
	}
	public Account getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(Account accountDetails) {
		this.accountDetails = accountDetails;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
