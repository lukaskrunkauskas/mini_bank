package com.fleetbankis.fleetbankis;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ToExcel {
    public static void excelGenerator(Long caseForQuery) {
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/fleetbankis", "postgres", "123");
            stmt = c.createStatement();
            ResultSet rs;
            if (caseForQuery == 0) {
                rs = stmt.executeQuery("select * from transactions;");
            }
            else {
                rs = stmt.executeQuery("select * from transactions where transactions.bank_id =" + caseForQuery + ";");
            }

            FileWriter csvWriter = new FileWriter("Report_" + caseForQuery + ".csv");
            csvWriter.append("Id");
            csvWriter.append(",");
            csvWriter.append("Amount");
            csvWriter.append(",");
            csvWriter.append("bank_profit");
            csvWriter.append(",");
            csvWriter.append("tx_time");
            csvWriter.append(",");
            csvWriter.append("bank_id");
            csvWriter.append(",");
            csvWriter.append("receiver_id");
            csvWriter.append(",");
            csvWriter.append("sender_id");
            csvWriter.append("\n");
            while (rs.next()) {
                int id = rs.getInt("id");
                double amount = rs.getDouble("Amount");
                double bankProfit = rs.getDouble("bank_profit");
                String txTime = rs.getString("tx_time");
                long bankId = rs.getLong("bank_id");
                long receiverId = rs.getLong("receiver_id");
                long senderId = rs.getLong("sender_id");
                csvWriter.append(String.join(",", Integer.toString(id), Double.toString(amount), Double.toString(bankProfit), txTime, Long.toString(bankId), Long.toString(receiverId), Long.toString(senderId)));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();
            rs.close();
            stmt.close();
            c.close();
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}

