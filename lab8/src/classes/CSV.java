package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSV implements Runnable {

    private String filePath;
    private List<CSVdata> dataList;

    public CSV(String filePath) {
        this.filePath = filePath;
        this.dataList = new ArrayList<>();
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header line

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                CSVdata csvData = new CSVdata(
                        values[0].trim(),
                        values[1].trim(),
                        values[2].trim()
                );

                dataList.add(csvData);

                // You can also print the data here if needed
                System.out.println(csvData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CSVdata> getDataList() {
        return dataList;
    }

    public static void main(String[] args) {
        String filePath = "D:\\INTELLIJ\\laborator_java\\lab6\\src\\classes\\Trans_dim.csv";

        // Create a CSV object with the file path
        CSV csvReader = new CSV(filePath);

        // Create a thread for reading the CSV file
        Thread csvThread = new Thread(csvReader);

        // Start the thread
        csvThread.start();

        try {
            // Wait for the thread to finish
            csvThread.join();

            // Get the data list from the CSV object
            List<CSVdata> dataList = csvReader.getDataList();

            // Sorting and printing based on bank names
            Collections.sort(dataList);

            for (CSVdata data : dataList) {
                System.out.println(data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
