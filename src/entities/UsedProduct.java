package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
    private LocalDate manufactureDate;

    public UsedProduct() {
        super();
    }

    public UsedProduct(String productName, Double productPrice, LocalDate manufactureDate) {
        super(productName, productPrice);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    @Override
    public final String priceTag() {
        return super.getProductName() + " (used) " +  " $ " + getProductPrice() + " (Manufacture Date: " + getManufactureDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")";
    }
}