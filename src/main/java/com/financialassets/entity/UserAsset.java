package com.financialassets.entity;


import com.financialassets.apiclient.IEXQuoteClient;
import com.financialassets.apiclient.IEXQuoteResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Entity(name = "UserAsset")
@Table(name = "user_asset")
public class UserAsset {
    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Column(name = "user_asset_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int userAssetId;

    @Column(name = "buy_price")
    private double buyPrice;

    @Column(name = "sell_price")
    private BigDecimal sellPrice;

    @Column(name = "buy_date")
    private LocalDate buyDate;

    @Column(name = "sell_date")
    private LocalDate sellDate;
    private Integer qty;

    @Column(name = "asset_name")
    private String assetName;

    private double fees;



    @ManyToOne
    @JoinColumn(name = "user_id",
    foreignKey = @ForeignKey(name = "user_asset_id_fk"))
    private User user;

    @Column(name = "asset_id")
    private int assetId;

    @Transient
    private double gainOrLossDollar;
    @Transient
    private double gainOrLossPercent;

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getQty() {
        return qty;
    }



    public double getGainOrLossDollar() {
        return gainOrLossDollar;
    }

    public double getGainOrLossPercent() {
        return gainOrLossPercent;
    }

    //TODO figure in commisions, fees
    public void setUnsoldGainOrLoss(String name) {
        IEXQuoteClient quoteClient = new IEXQuoteClient();
        DecimalFormat dollarFormat = new DecimalFormat("#.####");
        DecimalFormat percentFormat = new DecimalFormat("#.##");
        double longDollar;
        double longPercent;

        // If unsold
        if (sellPrice == null) {
            try {
                IEXQuoteResponse quote = quoteClient.getJSONResults(this.assetName);
                longDollar = (quote.getLatestPrice() - buyPrice - fees)  * qty;
                longPercent = (longDollar / (buyPrice * qty)) * 100;

                this.gainOrLossDollar = Double.parseDouble(dollarFormat.format(longDollar));
                this.gainOrLossPercent = Double.parseDouble(percentFormat.format(longPercent));

            } catch (Exception e) {
                logger.error(e);
            }

        // If sold
        } else {
            longDollar = (sellPrice.doubleValue() - buyPrice - fees)  * qty;
            longPercent = (longDollar / (buyPrice * qty)) * 100;

            this.gainOrLossDollar = Double.parseDouble(dollarFormat.format(longDollar));
            this.gainOrLossPercent = Double.parseDouble(percentFormat.format(longPercent));
        }


    }


    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

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
     * Gets buy price.
     *
     * @return the buy price
     */
    public double getBuyPrice() {
        return buyPrice;
    }

    /**
     * Sets buy price.
     *
     * @param buyPrice the buy price
     */
    public void setBuyPrice(double buyPrice) {
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

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    /**
     * No arg constructor
     */
    public UserAsset() {
    }

    /**
     * Instantiates a new User asset.
     *
     * @param buyPrice  the buy price
     * @param buyDate   the buy date
     * @param qty       the qty
     * @param assetName the asset name
     */
    public UserAsset(User user, double buyPrice, LocalDate buyDate, Integer qty, String assetName) {
        this.buyPrice = buyPrice;
        this.buyDate = buyDate;
        this.qty = qty;
        this.assetName = assetName;
        this.user = user;


    }






}
