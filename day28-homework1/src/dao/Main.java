package dao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
           boolean b = Decide.decide("zhangsan","123");
            System.out.println(b);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
