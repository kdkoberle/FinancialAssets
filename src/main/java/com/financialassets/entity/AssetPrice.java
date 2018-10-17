package com.financialassets.entity;
import javax.persistence.Entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;
import javax.ejb.Local;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "AssetPrice")
@Table(name = "asset_price")

public class AssetPrice {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "asset_id")
    private int assetId;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "asset_id",
            foreignKey = @ForeignKey(name = "asset_asset_id_fk"))


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets date time.
     *
     * @return the date time
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Sets date time.
     *
     * @param dateTime the date time
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

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
     * Gets price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }



}
