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
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                CSVdata csvData = new CSVdata(
                        values[0].trim(),
                        values[1].trim(),
                        values[2].trim()
                );

                dataList.add(csvData);

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
        String filePath = "D:\\INTELLIJ\\laborator_java\\lab5\\src\\classes\\Trans_dim.csv";

        CSV csvReader = new CSV(filePath);

        Thread csvThread = new Thread(csvReader);

        csvThread.start();

        try {

            csvThread.join();

            List<CSVdata> dataList = csvReader.getDataList();

            Collections.sort(dataList);

            for (CSVdata data : dataList) {
                System.out.println(data);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
