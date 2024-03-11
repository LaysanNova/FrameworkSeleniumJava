package helper;

import java.util.List;

public class TestUtils {

    public static void printTable(List<String> table) {

        for (String row : table) {
            String[] rowValues = row.split("\n");

            for (String value: rowValues) {
                String s = String.format("%-32s", value);
                System.out.print(s);
            }
            System.out.println();
        }
    }

    public static void printTable(List<List<String>> table, boolean list) {

        for (List<String> row : table) {
            for (int y = 0; y < row.size() - 1; y++) {
                String s = String.format("%-20s", row.get(y));
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
