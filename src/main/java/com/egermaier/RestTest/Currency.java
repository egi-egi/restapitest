package com.egermaier.RestTest;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Currency {
	
	private String shortName;
	private Date validFrom;
	private String name;
	private String country;
	private double amount;
	private double cnbMid;
	private double currencyBuy;
	private double currMid;
	private double currencySell;
	private double move;
	private double valBuy;
	private double valMid;
	private double valSell;
	private double version;
	
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getCnbMid() {
		return cnbMid;
	}
	public void setCnbMid(double cnbMid) {
		this.cnbMid = cnbMid;
	}
	public double getCurrencyBuy() {
		return currencyBuy;
	}
	public void setCurrencyBuy(double currencyBuy) {
		this.currencyBuy = currencyBuy;
	}
	public double getCurrMid() {
		return currMid;
	}
	public void setCurrMid(double currMid) {
		this.currMid = currMid;
	}
	public double getCurrencySell() {
		return currencySell;
	}
	public void setCurrencySell(double currencySell) {
		this.currencySell = currencySell;
	}
	public double getMove() {
		return move;
	}
	public void setMove(double move) {
		this.move = move;
	}
	public double getValBuy() {
		return valBuy;
	}
	public void setValBuy(double valBuy) {
		this.valBuy = valBuy;
	}
	public double getValMid() {
		return valMid;
	}
	public void setValMid(double valMid) {
		this.valMid = valMid;
	}
	public double getValSell() {
		return valSell;
	}
	public void setValSell(double valSell) {
		this.valSell = valSell;
	}
	public double getVersion() {
		return version;
	}
	public void setVersion(double version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Currency [shortName=" + shortName + ", validFrom=" + validFrom + ", name=" + name + ", country="
				+ country + ", amount=" + amount + ", cnbMid=" + cnbMid + ", currencyBuy=" + currencyBuy + ", currMid="
				+ currMid + ", currencySell=" + currencySell + ", move=" + move + ", valBuy=" + valBuy + ", valMid="
				+ valMid + ", valSell=" + valSell + ", version=" + version + "]";
	}
	

}
