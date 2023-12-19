package az.code.model;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {
    private long id;
    private double totalPrice;
    List<PurchaseItem> purchaseItems;
    LocalDateTime creationDate;

    public Purchase(long id, double totalPrice, List<PurchaseItem> purchaseItems, LocalDateTime creationDate) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.purchaseItems = purchaseItems;
        this.creationDate = creationDate;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<PurchaseItem> getPurchaseItems() {
        return purchaseItems;
    }
    public int getPurchaseItemsCount() {
        return this.purchaseItems.toArray().length;
    }

    public void setPurchaseItems(List<PurchaseItem> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
