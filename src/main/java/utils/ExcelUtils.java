package utils;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static void main(String[] args) {

        writeNewUserToExcel();
    }

    public static ArrayList<ArrayList<String>> readRows(String sheetName, String fileName) {

        ArrayList<ArrayList<String>> rowsList = new ArrayList<>();
        String patch = "src/main/resources/data/" + fileName;

        try {
            File file = new File(patch);
            FileInputStream fileInputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet(sheetName);

//            getting each row and storing in a users list
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {

                ArrayList<String> rowCells = new ArrayList<>();
                Row row = sheet.getRow(i);

//                getting each cell and storing in a rowCells list
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    rowCells.add(cell.toString());
                }

                rowsList.add(rowCells);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return rowsList;
    }

    public static List<String> createNewUser() {

        List<String> user = new ArrayList<>();
        Faker faker = new Faker();

        String[] roles = {"Instructor", "Mentor", "Student"};
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        user.add(firstName);
        user.add(lastName);
        user.add(faker.phoneNumber().phoneNumber());
        user.add(firstName + lastName + "@gmail.com");
        user.add(roles[(int)(Math.random() * 3)]);

        return user;
    }

    public static void writeNewUserToExcel() {

        String path = "src/main/resources/data/newUsers.xlsx";
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Test Users");
        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("firstName");
        header.createCell(1).setCellValue("lastName");
        header.createCell(2).setCellValue("phoneNumber");
        header.createCell(3).setCellValue("email");
        header.createCell(4).setCellValue("role");

        for (int i = 1; i < 20; i++) {
            Row row = sheet.createRow(i);

            List<String> userData = createNewUser();
            for (int j = 0; j < userData.size(); j++) {
                row.createCell(j).setCellValue(userData.get(j));
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(path)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//        String patch = "src/main/resources/data/Users.xlsx";
//        File file = new File(patch);
//        FileInputStream fileInputStream = new FileInputStream(file);
//
//        Workbook workbook = new XSSFWorkbook(fileInputStream);
//        Sheet sheet = workbook.getSheet("User 1");
//        Row row = sheet.getRow(0);
//        Cell cell = row.getCell(0);
//
//        System.out.println(cell.toString());
//        System.out.println(sheet.getRow(2).getCell(1).toString());


//    public static void main(String[] args) {
//
//        ArrayList<ArrayList<String>> allData = readRows("Sheet 1", "Users.xlsx");
//        for (ArrayList<String> each : allData) {
//            System.out.println(each);

//        String path = "src/main/resources/data/test.xlsx";
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("Test Users");
//
//        Row firstRow = sheet.getRow(0);
//        firstRow.createCell(0).setCellValue("Alice");
//
//        try (FileOutputStream outputStream = new FileOutputStream(path)) {
//            workbook.write(outputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }