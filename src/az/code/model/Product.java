package az.code.model;

public class Product {
    private long code;
    private String name;
    private ProductType category;
    private int count;
    private double price;

    public Product(long code, String name, ProductType category, int count, double price) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.count = count;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getName() + " category: " + category + " code: " + this.getCode() + " with price: " + this.getPrice() + " ₼";
    }

    public long getCode() {
        return this.code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getCategory() {
        return this.category;
    }

    public void setCategory(ProductType category) {
        this.category = category;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
