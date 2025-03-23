package com.example.tax;

public class PropertyTax implements Tax{
    /*
    1. This class has the following attributes.
        a. taxableAmount (double)
        b. taxAmount (double)
        c. isTaxPayed (boolean)
    2. This class implements Tax interface and override the interface methods.
    3. Using constructor initialize the isTaxPayed boolean false.
     */
    double taxableAmount;
    double taxAmount;
    boolean isTaxPayed;

    public PropertyTax(){
        this.isTaxPayed = false;
    }
    @Override
    public void setTaxableAmount(double amount){
        this.taxableAmount = amount;
    }

    @Override
    public void calculateTaxAmount(){
        this.taxAmount = this.taxableAmount * 0.05;
    }

    @Override
    public double getTaxAmount(){
        return this.taxAmount;
    }

    @Override
    public String getTaxType(){
        return "property";
    }

    @Override
    public void payTax(){
        System.out.println("Hi, your property tax is paid!");
        this.isTaxPayed = true;
    }

    @Override
    public boolean isTaxPayed(){
        return this.isTaxPayed;
    }
}
