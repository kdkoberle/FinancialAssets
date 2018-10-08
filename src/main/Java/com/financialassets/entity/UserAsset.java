package com.financialassets.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "UserAsset")
@Table(name = "user_asset")
public class UserAsset {

    @Column(name = "user_asset_id")
    private int userAssetId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "buy_price")
    private BigDecimal buyPrice;

    @Column(name = "sell_price")
    private BigDecimal sellPrice;

    @Column(name = "buy_date")
    private LocalDate buyDate;

    @Column(name = "sell_date")
    private LocalDate sellDate;
    private int qty;

    @Column(name = "asset_name")
    private String assetName;


    /**
     * Gets user asset id.
     *
     * @return the user asset id
     */
    public int getUserAssetId() {
        return userAssetId;
    }

    /**
     * Sets user asset id.
     *
     * @param userAssetId the user asset id
     */
    public void setUserAssetId(int userAssetId) {
        this.userAssetId = userAssetId;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets buy price.
     *
     * @return the buy price
     */
    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    /**
     * Sets buy price.
     *
     * @param buyPrice the buy price
     */
    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * Gets sell price.
     *
     * @return the sell price
     */
    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    /**
     * Sets sell price.
     *
     * @param sellPrice the sell price
     */
    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * Gets buy date.
     *
     * @return the buy date
     */
    public LocalDate getBuyDate() {
        return buyDate;
    }

    /**
     * Sets buy date.
     *
     * @param buyDate the buy date
     */
    public void setBuyDate(LocalDate buyDate) {
        this.buyDate = buyDate;
    }

    /**
     * Gets sell date.
     *
     * @return the sell date
     */
    public LocalDate getSellDate() {
        return sellDate;
    }

    /**
     * Sets sell date.
     *
     * @param sellDate the sell date
     */
    public void setSellDate(LocalDate sellDate) {
        this.sellDate = sellDate;
    }

    /**
     * Gets qty.
     *
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * Sets qty.
     *
     * @param qty the qty
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * Gets asset name.
     *
     * @return the asset name
     */
    public String getAssetName() {
        return assetName;
    }

    /**
     * Sets asset name.
     *
     * @param assetName the asset name
     */
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }



}
