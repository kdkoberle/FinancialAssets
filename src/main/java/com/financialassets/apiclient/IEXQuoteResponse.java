package com.financialassets.apiclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class IEXQuoteResponse{

	@JsonProperty("symbol")
	private String symbol;

	@JsonProperty("avgTotalVolume")
	private int avgTotalVolume;

	@JsonProperty("companyName")
	private String companyName;

	@JsonProperty("iexRealtimePrice")
	private Object iexRealtimePrice;

	@JsonProperty("delayedPrice")
	private double delayedPrice;

	@JsonProperty("iexMarketPercent")
	private Object iexMarketPercent;

	@JsonProperty("calculationPrice")
	private String calculationPrice;

	@JsonProperty("extendedChangePercent")
	private double extendedChangePercent;

	@JsonProperty("latestSource")
	private String latestSource;

	@JsonProperty("primaryExchange")
	private String primaryExchange;

	@JsonProperty("latestUpdate")
	private long latestUpdate;

	@JsonProperty("iexBidPrice")
	private Object iexBidPrice;

	@JsonProperty("previousClose")
	private double previousClose;

	@JsonProperty("high")
	private double high;

	@JsonProperty("peRatio")
	private int peRatio;

	@JsonProperty("low")
	private double low;

	@JsonProperty("delayedPriceTime")
	private long delayedPriceTime;

	@JsonProperty("extendedPrice")
	private double extendedPrice;

	@JsonProperty("extendedPriceTime")
	private long extendedPriceTime;

	@JsonProperty("week52Low")
	private double week52Low;

	@JsonProperty("closeTime")
	private long closeTime;

	@JsonProperty("changePercent")
	private double changePercent;

	@JsonProperty("week52High")
	private double week52High;

	@JsonProperty("openTime")
	private long openTime;

	@JsonProperty("sector")
	private String sector;

	@JsonProperty("close")
	private double close;

	@JsonProperty("latestPrice")
	private double latestPrice;

	@JsonProperty("marketCap")
	private long marketCap;

	@JsonProperty("iexRealtimeSize")
	private Object iexRealtimeSize;

	@JsonProperty("iexLastUpdated")
	private Object iexLastUpdated;

	@JsonProperty("change")
	private double change;

	@JsonProperty("latestVolume")
	private int latestVolume;

	@JsonProperty("iexAskPrice")
	private Object iexAskPrice;

	@JsonProperty("ytdChange")
	private double ytdChange;

	@JsonProperty("iexVolume")
	private Object iexVolume;

	@JsonProperty("iexAskSize")
	private Object iexAskSize;

	@JsonProperty("extendedChange")
	private double extendedChange;

	@JsonProperty("latestTime")
	private String latestTime;

	@JsonProperty("open")
	private int open;

	@JsonProperty("iexBidSize")
	private Object iexBidSize;

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}

	public String getSymbol(){
		return symbol;
	}

	public void setAvgTotalVolume(int avgTotalVolume){
		this.avgTotalVolume = avgTotalVolume;
	}

	public int getAvgTotalVolume(){
		return avgTotalVolume;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return companyName;
	}

	public void setIexRealtimePrice(Object iexRealtimePrice){
		this.iexRealtimePrice = iexRealtimePrice;
	}

	public Object getIexRealtimePrice(){
		return iexRealtimePrice;
	}

	public void setDelayedPrice(double delayedPrice){
		this.delayedPrice = delayedPrice;
	}

	public double getDelayedPrice(){
		return delayedPrice;
	}

	public void setIexMarketPercent(Object iexMarketPercent){
		this.iexMarketPercent = iexMarketPercent;
	}

	public Object getIexMarketPercent(){
		return iexMarketPercent;
	}

	public void setCalculationPrice(String calculationPrice){
		this.calculationPrice = calculationPrice;
	}

	public String getCalculationPrice(){
		return calculationPrice;
	}

	public void setExtendedChangePercent(double extendedChangePercent){
		this.extendedChangePercent = extendedChangePercent;
	}

	public double getExtendedChangePercent(){
		return extendedChangePercent;
	}

	public void setLatestSource(String latestSource){
		this.latestSource = latestSource;
	}

	public String getLatestSource(){
		return latestSource;
	}

	public void setPrimaryExchange(String primaryExchange){
		this.primaryExchange = primaryExchange;
	}

	public String getPrimaryExchange(){
		return primaryExchange;
	}

	public void setLatestUpdate(long latestUpdate){
		this.latestUpdate = latestUpdate;
	}

	public long getLatestUpdate(){
		return latestUpdate;
	}

	public void setIexBidPrice(Object iexBidPrice){
		this.iexBidPrice = iexBidPrice;
	}

	public Object getIexBidPrice(){
		return iexBidPrice;
	}

	public void setPreviousClose(double previousClose){
		this.previousClose = previousClose;
	}

	public double getPreviousClose(){
		return previousClose;
	}

	public void setHigh(double high){
		this.high = high;
	}

	public double getHigh(){
		return high;
	}

	public void setPeRatio(int peRatio){
		this.peRatio = peRatio;
	}

	public int getPeRatio(){
		return peRatio;
	}

	public void setLow(double low){
		this.low = low;
	}

	public double getLow(){
		return low;
	}

	public void setDelayedPriceTime(long delayedPriceTime){
		this.delayedPriceTime = delayedPriceTime;
	}

	public long getDelayedPriceTime(){
		return delayedPriceTime;
	}

	public void setExtendedPrice(double extendedPrice){
		this.extendedPrice = extendedPrice;
	}

	public double getExtendedPrice(){
		return extendedPrice;
	}

	public void setExtendedPriceTime(long extendedPriceTime){
		this.extendedPriceTime = extendedPriceTime;
	}

	public long getExtendedPriceTime(){
		return extendedPriceTime;
	}

	public void setWeek52Low(double week52Low){
		this.week52Low = week52Low;
	}

	public double getWeek52Low(){
		return week52Low;
	}

	public void setCloseTime(long closeTime){
		this.closeTime = closeTime;
	}

	public long getCloseTime(){
		return closeTime;
	}

	public void setChangePercent(double changePercent){
		this.changePercent = changePercent;
	}

	public double getChangePercent(){
		return changePercent;
	}

	public void setWeek52High(double week52High){
		this.week52High = week52High;
	}

	public double getWeek52High(){
		return week52High;
	}

	public void setOpenTime(long openTime){
		this.openTime = openTime;
	}

	public long getOpenTime(){
		return openTime;
	}

	public void setSector(String sector){
		this.sector = sector;
	}

	public String getSector(){
		return sector;
	}

	public void setClose(double close){
		this.close = close;
	}

	public double getClose(){
		return close;
	}

	public void setLatestPrice(double latestPrice){
		this.latestPrice = latestPrice;
	}

	public double getLatestPrice(){
		return latestPrice;
	}

	public void setMarketCap(long marketCap){
		this.marketCap = marketCap;
	}

	public long getMarketCap(){
		return marketCap;
	}

	public void setIexRealtimeSize(Object iexRealtimeSize){
		this.iexRealtimeSize = iexRealtimeSize;
	}

	public Object getIexRealtimeSize(){
		return iexRealtimeSize;
	}

	public void setIexLastUpdated(Object iexLastUpdated){
		this.iexLastUpdated = iexLastUpdated;
	}

	public Object getIexLastUpdated(){
		return iexLastUpdated;
	}

	public void setChange(double change){
		this.change = change;
	}

	public double getChange(){
		return change;
	}

	public void setLatestVolume(int latestVolume){
		this.latestVolume = latestVolume;
	}

	public int getLatestVolume(){
		return latestVolume;
	}

	public void setIexAskPrice(Object iexAskPrice){
		this.iexAskPrice = iexAskPrice;
	}

	public Object getIexAskPrice(){
		return iexAskPrice;
	}

	public void setYtdChange(double ytdChange){
		this.ytdChange = ytdChange;
	}

	public double getYtdChange(){
		return ytdChange;
	}

	public void setIexVolume(Object iexVolume){
		this.iexVolume = iexVolume;
	}

	public Object getIexVolume(){
		return iexVolume;
	}

	public void setIexAskSize(Object iexAskSize){
		this.iexAskSize = iexAskSize;
	}

	public Object getIexAskSize(){
		return iexAskSize;
	}

	public void setExtendedChange(double extendedChange){
		this.extendedChange = extendedChange;
	}

	public double getExtendedChange(){
		return extendedChange;
	}

	public void setLatestTime(String latestTime){
		this.latestTime = latestTime;
	}

	public String getLatestTime(){
		return latestTime;
	}

	public void setOpen(int open){
		this.open = open;
	}

	public int getOpen(){
		return open;
	}

	public void setIexBidSize(Object iexBidSize){
		this.iexBidSize = iexBidSize;
	}

	public Object getIexBidSize(){
		return iexBidSize;
	}

	@Override
 	public String toString(){
		return 
			"IEXQuoteResponse{" + 
			"symbol = '" + symbol + '\'' + 
			",avgTotalVolume = '" + avgTotalVolume + '\'' + 
			",companyName = '" + companyName + '\'' + 
			",iexRealtimePrice = '" + iexRealtimePrice + '\'' + 
			",delayedPrice = '" + delayedPrice + '\'' + 
			",iexMarketPercent = '" + iexMarketPercent + '\'' + 
			",calculationPrice = '" + calculationPrice + '\'' + 
			",extendedChangePercent = '" + extendedChangePercent + '\'' + 
			",latestSource = '" + latestSource + '\'' + 
			",primaryExchange = '" + primaryExchange + '\'' + 
			",latestUpdate = '" + latestUpdate + '\'' + 
			",iexBidPrice = '" + iexBidPrice + '\'' + 
			",previousClose = '" + previousClose + '\'' + 
			",high = '" + high + '\'' + 
			",peRatio = '" + peRatio + '\'' + 
			",low = '" + low + '\'' + 
			",delayedPriceTime = '" + delayedPriceTime + '\'' + 
			",extendedPrice = '" + extendedPrice + '\'' + 
			",extendedPriceTime = '" + extendedPriceTime + '\'' + 
			",week52Low = '" + week52Low + '\'' + 
			",closeTime = '" + closeTime + '\'' + 
			",changePercent = '" + changePercent + '\'' + 
			",week52High = '" + week52High + '\'' + 
			",openTime = '" + openTime + '\'' + 
			",sector = '" + sector + '\'' + 
			",close = '" + close + '\'' + 
			",latestPrice = '" + latestPrice + '\'' + 
			",marketCap = '" + marketCap + '\'' + 
			",iexRealtimeSize = '" + iexRealtimeSize + '\'' + 
			",iexLastUpdated = '" + iexLastUpdated + '\'' + 
			",change = '" + change + '\'' + 
			",latestVolume = '" + latestVolume + '\'' + 
			",iexAskPrice = '" + iexAskPrice + '\'' + 
			",ytdChange = '" + ytdChange + '\'' + 
			",iexVolume = '" + iexVolume + '\'' + 
			",iexAskSize = '" + iexAskSize + '\'' + 
			",extendedChange = '" + extendedChange + '\'' + 
			",latestTime = '" + latestTime + '\'' + 
			",open = '" + open + '\'' + 
			",iexBidSize = '" + iexBidSize + '\'' + 
			"}";
		}
}