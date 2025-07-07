package com.Ml;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
public class CSVToDatabase {

	public static void main(String[] args) {
        String csvFile = "C:\\Users\\vertijava\\Desktop\\Chronic-Kidney-Disease-Prediction-Project-main\\Kidney_data.csv"; // Path to the CSV file
        String jdbcURL = "jdbc:mysql://localhost:3306/datastorage";
        String jdbcUsername = "root";
        String jdbcPassword = "root";

        try  {

            Class.forName("com.mysql.jdbc.Driver");

            // Establish the connection to the database
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            // SQL query to insert data into the database
            String sql = "INSERT INTO users  VALUES (?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            CSVReader csvReader = new CSVReader(new FileReader(csvFile));
            String[] nextRecord;

            // Skip the header row
            csvReader.skip(1);

            // Prepare statement to insert data into database
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            while ((nextRecord = csvReader.readNext()) != null) {
                // Assuming CSV columns are in the order: id, age, bp, sug, al, su, etc.
                int id = Integer.parseInt(nextRecord[0]);
                int age = Integer.parseInt(nextRecord[1]);
                String bp = nextRecord[2];
                double sug = Double.parseDouble(nextRecord[3]); // Parse as double
                int al = Integer.parseInt(nextRecord[4]);
                int su = Integer.parseInt(nextRecord[5]);
                String rbc = nextRecord[6];
                String pc = nextRecord[7];
                String pcc = nextRecord[8];
                String ba = nextRecord[9];
                String bgr = nextRecord[10];
                String bu = nextRecord[11];
                String sc = nextRecord[12]; // Parse as double
                String sod = nextRecord[13];
                String pot = nextRecord[14]; // Parse as double
                String hemo = nextRecord[15]; // Parse as double
                String pcv = nextRecord[16];
                String wc = nextRecord[17];
                String rc = nextRecord[18]; // Parse as double
                String htn = nextRecord[19];
                String dm = nextRecord[20];
                String cad = nextRecord[21];
                String appet = nextRecord[22];
                String pe = nextRecord[23];
                String ane = nextRecord[24];
                String clasifcation = nextRecord[25];

                // Set parameters and execute update
                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, age);
                preparedStatement.setString(3, bp);
                preparedStatement.setDouble(4, sug);
                preparedStatement.setInt(5, al);
                preparedStatement.setInt(6, su);
                preparedStatement.setString(7, rbc);
                preparedStatement.setString(8, pc);
                preparedStatement.setString(9, pcc);
                preparedStatement.setString(10, ba);
                preparedStatement.setString(11, bgr);
                preparedStatement.setString(12, bu);
                preparedStatement.setString(13, sc);
                preparedStatement.setString(14, sod);
                preparedStatement.setString(15, pot);
                preparedStatement.setString(16, hemo);
                preparedStatement.setString(17, pcv);
                preparedStatement.setString(18, wc);
                preparedStatement.setString(19, rc);
                preparedStatement.setString(20, htn);
                preparedStatement.setString(21, dm);
                preparedStatement.setString(22, cad);
                preparedStatement.setString(23, appet);
                preparedStatement.setString(24, pe);
                preparedStatement.setString(25, ane);
                preparedStatement.setString(26, clasifcation);

                // Execute insert
                preparedStatement.executeUpdate();
            }
            System.out.println("Data imported successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
