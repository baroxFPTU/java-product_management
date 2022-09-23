package entities;


/**
 *
 * @author quocb
 */
public class ProductEntity {
    private String productID;
    private String productName;
    private Double unitPrice;
    private Integer quantity;
    private String status;

    public ProductEntity() {
        this.productID = null;
        this.productName = null;
        this.unitPrice = null;
        this.quantity = null;
        this.status = null;
    }

    public ProductEntity(String productID, String productName, Double unitPrice, Integer quantity, String status) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.status = status;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "productID=" + productID + ", productName=" + productName + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", status=" + status;
    }

    @Override
    public ProductEntity clone() throws CloneNotSupportedException {
        return (ProductEntity) super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
