package az.code.model;

public enum ProductType {
    FRUITS, //"Fruits", "Apples, bananas, grapes, oranges, strawberries, avocados, peaches, etc.
    VEGETABLES, //"Vegetables", "Potatoes, onions, carrots, salad greens, broccoli, peppers, tomatoes, cucumbers, etc."),
    CANNED_GOODS, //"Canned Goods", "Soup, tuna, fruit, beans, vegetables, pasta sauce, etc."),
    DAIRY, //"Dairy", "Butter, cheese, eggs, milk, yogurt, etc."),
    MEAT, //"Meat", "Chicken, beef, pork, sausage, bacon etc."),
    FISH_SEAFOOD, //"Fish & Seafood", "Shrimp, crab, cod, tuna, salmon, etc."),
    DELI, //"Deli", "Cheese, salami, ham, turkey, etc."),
    CONDIMENTS_SPICES, //"Condiments & Spices", "Black pepper, oregano, cinnamon, sugar, olive oil, ketchup, mayonnaise, etc."),
    SNACKS, //"Snacks", "Chips, pretzels, popcorn, crackers, nuts, etc."),
    BREAD_BAKERY, //"Bread & Bakery", "Bread, tortillas, pies, muffins, bagels, cookies, etc."),
    BEVERAGES, //"Beverages", "Coffee, teabags, milk, juice, soda, beer, wine, etc."),
    PASTA_RICE_CEREAL, //"Pasta, Rice & Cereal", "Oats, granola, brown rice, white rice, macaroni, noodles, etc."),
    BAKING; //"Baking", "Flour, powdered sugar, baking powder, cocoa etc."),

    private String categoryName = "";
    private String description = "";

    void ProductCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }
}
