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
    private int assetId;
    private String assetType;
    private String assetName;
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




    
}
