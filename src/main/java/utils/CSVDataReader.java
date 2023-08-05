package utils;

import model.Product;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVDataReader {

    enum ProductHeader {
        id,
        name,
        price,
        description
    }

    public static List<Product>readProductsFromCSV() throws IOException {
        List<Product> productList = new ArrayList<>();

        Reader in = new FileReader("src/main/resources/saucedemo-products.csv");

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(ProductHeader.class)
                .setSkipHeaderRecord(true)
                .build();

        Iterable<CSVRecord> records = csvFormat.parse(in);

        for (CSVRecord record : records) {
            Product productData = new Product();
            productData.setId(Integer.parseInt(record.get("id")));
            productData.setName(record.get("name"));
            productData.setPrice(record.get("price"));
            productData.setDescription(record.get("description"));

            productList.add(productData);
        }

        return productList;
    }
}
