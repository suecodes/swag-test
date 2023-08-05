package utils;

import model.Product;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class ProductDataProvider {

    @DataProvider(name = "productData")
    public static Object[][] getProductData() throws IOException {
        List<Product> productsList = CSVDataReader.readProductsFromCSV();

        Object[][] data = new Object[productsList.size()][1];
        for (int i = 0; i < productsList.size(); i++){
            data[i][0] = productsList.get(i);
        }
        return data;
    }

    public static void printProductDataToConsole() throws IOException {
        List<Product> productsList = CSVDataReader.readProductsFromCSV();

        for (Product product : productsList){
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Description: " + product.getDescription());
        }
    }
}
