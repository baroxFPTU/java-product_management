package dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import dao.exceptions.IOValidationException;

import entities.ProductEntity;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utils.Formater;

/**
 *
 * @author quocb
 */
public class ProductDao implements IDao<ArrayList<ProductEntity>> {
    String path = "storage.csv";
    
    @Override
    public ArrayList<ProductEntity> read() throws IOValidationException {
        File file = new File(path);
        ArrayList<ProductEntity> lsProduct = new ArrayList<>();
        if (!file.exists()) {
            System.out.println("return");
            return lsProduct; // Return empty list
        }

        try {
            FileReader fileReader = new FileReader(file);
            try (CSVReader csvReader = new CSVReader(fileReader)) {
                String[] nextRecord;
                
                while ((nextRecord = csvReader.readNext()) != null) {
                    ProductEntity convertedProduct = Formater.convertToEntity(nextRecord);
                    lsProduct.add(convertedProduct);
                }
            }
        } catch (IOException | CsvValidationException ex) {
            throw new IOValidationException("Cannot read file");
        }

        return lsProduct;
    }

    public void write(ArrayList<ProductEntity> lsProduct) throws IOValidationException {
        try {
            FileWriter fileWriter = new FileWriter(new File(path));
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            ArrayList<String[]> data = Formater.convertToCSVString(lsProduct);
            csvWriter.writeAll(data);
            fileWriter.close();
        } catch (IOException ex) {
            throw new IOValidationException("Cannot read file");
        }
    }

    // Not use
    @Override
    public boolean write() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
