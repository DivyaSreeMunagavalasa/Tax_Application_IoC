# Tax Collection Application

## Overview
This application is a government tax collection system built using **Spring Boot** and follows the **Inversion of Control (IoC)** principle. Users can pay **Income Tax** and **Property Tax**, with tax calculations based on government guidelines.

## Features
- Supports **Income Tax** and **Property Tax** payments.
- Ensures that tax can only be paid once.
- Uses **Spring IoC** for managing dependencies.
- Implements a **Tax Interface** for better maintainability.

## Tax Calculation Rules

### 1. **Income Tax**
Income tax is calculated based on the following slab rates:

| Taxable Income Range | Tax Rate |
|----------------------|----------|
| Rs 0 to Rs 3 lakh  | 0%  |
| Rs 3 lakh to Rs 6 lakh  | 5%  |
| Rs 6 lakh to Rs 9 lakh  | 10%  |
| Rs 9 lakh to Rs 12 lakh  | 15%  |
| Rs 12 lakh to Rs 15 lakh  | 20%  |
| Above Rs 15 lakh  | 30%  |

### 2. **Property Tax**
- Property tax is **5% of the property value**.

## Implementation

### 1. **Tax Interface**
The application defines a `Tax` interface with the following methods:

```java
public interface Tax {
    void setTaxableAmount(double amount);
    void calculateTaxAmount();
    double getTaxAmount();
    String getTaxType();
    boolean isTaxPayed();
    void payTax();
}
```
### 2. **IncomeTax and PropertyTax Classes**
- Implement the Tax interface.
- Contain attributes:
   - `taxableAmount (double)` - Amount on which tax is applied.
   - `taxAmount (double)` - Calculated tax.
   - `isTaxPayed (boolean)` - Tracks tax payment status.

### 3. **Spring IoC Configuration**
- Define **beans** in applicationContext.xml using camel case convention.
- Load the context using ClassPathXmlApplicationContext.

## Setup & Running the Application

### Prerequisites
- Java 
- Spring Boot
- Maven

## Steps to Run

1. Clone the repository:

```
git clone https://github.com/DivyaSreeMunagavalasa/Tax_Application_IoC.git
```
2. Navigate to the project directory:
```   
cd Tax_Application_IoC
```
3. Build and run the application:
```
mvn spring-boot:run
```
4. Follow the on-screen prompts to choose and pay taxes. The application will prompt the user to select Income Tax or Property Tax, enter the taxable amount, and process the payment.

## Project Structure

```css
tax-collection-app
│── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.example.tax
│   │   │   │   ├── Tax.java
│   │   │   │   ├── IncomeTax.java
│   │   │   │   ├── PropertyTax.java
│   │   │   │   ├── MainApplication.java
│   │   ├── resources
│   │   │   ├── applicationContext.xml
│── pom.xml
│── README.md
```



