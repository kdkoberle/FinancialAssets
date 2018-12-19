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

    /**
     *
     * @param date
     */
    public void setDate(String date){
        this.date = date;
    }

    /**
     *
     * @return date
     */
    public String getDate(){
        return date;
    }

    /**
     *
     * @param volume
     */
    public void setVolume(int volume){
        this.volume = volume;
    }

    /**
     *
     * @return trade volume
     */
    public int getVolume(){
        return volume;
    }

    /**
     *
     * @param price high
     */
    public void setHigh(double high){
        this.high = high;
    }

    /**
     *
     * @return price high
     */
    public double getHigh(){
        return high;
    }

    /**
     *
     * @param unadjustedVolume
     */
    public void setUnadjustedVolume(int unadjustedVolume){
        this.unadjustedVolume = unadjustedVolume;
    }

    /**
     *
     * @return unadjustedvolume
     */
    public int getUnadjustedVolume(){
        return unadjustedVolume;
    }

    /**
     *
     * @param low
     */
    public void setLow(double low){
        this.low = low;
    }

    /**
     *
     * @return low
     */
    public double getLow(){
        return low;
    }

    /**
     *
     * @param changeOverTime
     */
    public void setChangeOverTime(int changeOverTime){
        this.changeOverTime = changeOverTime;
    }

    /**
     *
     * @return change over time
     */
    public int getChangeOverTime(){
        return changeOverTime;
    }

    /**
     *
     * @param change
     */
    public void setChange(double change){
        this.change = change;
    }

    /**
     *
     * @return change
     */
    public double getChange(){
        return change;
    }

    /**
     *
     * @param vwap
     */
    public void setVwap(double vwap){
        this.vwap = vwap;
    }

    /**
     *
     * @return vwap
     */
    public double getVwap(){
        return vwap;
    }

    /**
     *
     * @param changePercent
     */
    public void setChangePercent(double changePercent){
        this.changePercent = changePercent;
    }

    /**
     *
     * @return changePercent
     */
    public double getChangePercent(){
        return changePercent;
    }

    /**
     *
     * @param label
     */
    public void setLabel(String label){
        this.label = label;
    }

    /**
     *
     * @return label
     */
    public String getLabel(){
        return label;
    }

    /**
     *
     * @param close
     */
    public void setClose(double close){
        this.close = close;
    }

    /**
     *
     * @return close
     */
    public double getClose(){
        return close;
    }

    /**
     *
     * @param open
     */
    public void setOpen(double open){
        this.open = open;
    }

    /**
     *
     * @return open
     */
    public double getOpen(){
        return open;
    }

    /**
     *
     * @return toString
     */
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