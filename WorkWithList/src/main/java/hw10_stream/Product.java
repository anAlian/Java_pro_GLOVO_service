package hw10_stream;

import java.time.LocalDate;

public class Product {
    private final String type;
    private final double price;
    private final boolean discount;
    private final java.time.LocalDate creationDate;


    public Product(String type, double price, boolean discount, LocalDate creationDate) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.creationDate = creationDate;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", creationDate=" + creationDate +
                '}';
    }
}
