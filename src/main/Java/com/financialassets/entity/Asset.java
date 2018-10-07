package com.financialassets.entity;
import javax.persistence.Entity;
import org.hibernate.annotations.GenericGenerator;
import javax.ejb.Local;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The type Asset.
 */
@Entity(name = "Asset")
@Table(name = "asset")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "asset_id")
    private int assetId;

    @Column(name = "asset_type")
    private String assetType;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "current_price")
    private BigDecimal currentPrice;


    /**
     * Gets asset id.
     *
     * @return the asset id
     */
    public int getAssetId() {
        return assetId;
    }

    /**
     * Sets asset id.
     *
     * @param assetId the asset id
     */
    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    /**
     * Gets asset type.
     *
     * @return the asset type
     */
    public String getAssetType() {
        return assetType;
    }

    /**
     * Sets asset type.
     *
     * @param assetType the asset type
     */
    public void setAssetType(String assetType) {
        this.assetType = assetType;
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
     * Gets current price.
     *
     * @return the current price
     */
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    /**
     * Sets current price.
     *
     * @param currentPrice the current price
     */
    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }


    /**
     * Instantiates a new Asset.
     * No arg
     */
    public Asset() {
    }

    /**
     * Instantiates a new Asset.
     *
     * @param assetType    the asset type
     * @param assetName    the asset name
     * @param currentPrice the current price
     */
    public Asset(String assetType, String assetName, BigDecimal currentPrice) {
        this.assetType = assetType;
        this.assetName = assetName;
        this.currentPrice = currentPrice;
    }
}
