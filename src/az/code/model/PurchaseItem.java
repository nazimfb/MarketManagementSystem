package az.code.model;

public class PurchaseItem {
    private Long id;
    private long productCode;
    private int count;

    public PurchaseItem(Long id, long productCode, int count) {
        this.id = id;
        this.productCode = productCode;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getProductCode() {
        return productCode;
    }

    public void setProductCode(long productCode) {
        this.productCode = productCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
