package main.java.com.company.Exeptions_3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReportMaker {
    public static void makePDFReport(String path, String data) {
        try {
            FileOutputStream out = new FileOutputStream(path); // тут может быть ошибка, что путь к файлу невозможно найти
                                                                // но мы ее перехватим и сделаем в консоль печать стектрейс
            out.write(data.getBytes());
            out.close();
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

    public static void makePDFReportCorrect(String path, String data) throws IOException{
        FileOutputStream out = new FileOutputStream(path);
        out.write(data.getBytes());
        out.close();
    }
}
