package com.financialassets.apiclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class IEXChartResponse {

    @JsonProperty("date")
    private String date;

    @JsonProperty("volume")
    private int volume;

    @JsonProperty("high")
    private double high;

    @JsonProperty("unadjustedVolume")
    private int unadjustedVolume;

    @JsonProperty("low")
    private double low;

    @JsonProperty("changeOverTime")
    private int changeOverTime;

    @JsonProperty("change")
    private double change;

    @JsonProperty("vwap")
    private double vwap;

    @JsonProperty("changePercent")
    private double changePercent;

    @JsonProperty("label")
    private String label;

    @JsonProperty("close")
    private double close;

    @JsonProperty("open")
    private double open;

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    public int getVolume(){
        return volume;
    }

    public void setHigh(double high){
        this.high = high;
    }

    public double getHigh(){
        return high;
    }

    public void setUnadjustedVolume(int unadjustedVolume){
        this.unadjustedVolume = unadjustedVolume;
    }

    public int getUnadjustedVolume(){
        return unadjustedVolume;
    }

    public void setLow(double low){
        this.low = low;
    }

    public double getLow(){
        return low;
    }

    public void setChangeOverTime(int changeOverTime){
        this.changeOverTime = changeOverTime;
    }

    public int getChangeOverTime(){
        return changeOverTime;
    }

    public void setChange(double change){
        this.change = change;
    }

    public double getChange(){
        return change;
    }

    public void setVwap(double vwap){
        this.vwap = vwap;
    }

    public double getVwap(){
        return vwap;
    }

    public void setChangePercent(double changePercent){
        this.changePercent = changePercent;
    }

    public double getChangePercent(){
        return changePercent;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

    public void setClose(double close){
        this.close = close;
    }

    public double getClose(){
        return close;
    }

    public void setOpen(double open){
        this.open = open;
    }

    public double getOpen(){
        return open;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "date = '" + date + '\'' +
                        ",volume = '" + volume + '\'' +
                        ",high = '" + high + '\'' +
                        ",unadjustedVolume = '" + unadjustedVolume + '\'' +
                        ",low = '" + low + '\'' +
                        ",changeOverTime = '" + changeOverTime + '\'' +
                        ",change = '" + change + '\'' +
                        ",vwap = '" + vwap + '\'' +
                        ",changePercent = '" + changePercent + '\'' +
                        ",label = '" + label + '\'' +
                        ",close = '" + close + '\'' +
                        ",open = '" + open + '\'' +
                        "}";
    }
}