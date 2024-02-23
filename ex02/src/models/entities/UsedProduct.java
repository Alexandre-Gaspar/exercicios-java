package models.entities;

import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
    
    private LocalDate manufactureDate;
    // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // public UsedProduct(LocalDate manufactureDate) {
    //     this.manufactureDate = manufactureDate;
    // }

    public UsedProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        return "Manufacture date: " + manufactureDate;
    }

}
