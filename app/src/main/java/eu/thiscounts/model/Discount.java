package eu.thiscounts.model;

/**
 * Created by xPku on 7/21/16.
 */
public class Discount {

    private Integer imageId;
    private String businessName;
    private String productName;
    private String currentPrice;
    private String formerPrice;


    public Discount(Integer imageId, String businessName, String productName, String currentPrice, String formerPrice) {
        this.imageId = imageId;
        this.businessName = businessName;
        this.productName = productName;
        this.currentPrice = currentPrice;
        this.formerPrice = formerPrice;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getFormerPrice() {
        return formerPrice;
    }

    public void setFormerPrice(String formerPrice) {
        this.formerPrice = formerPrice;
    }
}
