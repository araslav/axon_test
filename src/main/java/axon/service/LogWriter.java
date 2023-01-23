package axon.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {
    private File file;
    private BufferedWriter bufferedWriter;

    public LogWriter(String fileName) {
        file = new File(fileName);
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            throw new RuntimeException("Can't wrote to file: logFile" + fileName, e);
        }
    }

    public void writeData(String data) {
        try {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't wrote to file data: " + data, e);
        }
    }

    public void closeBuffered() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Buffer didn't close", e);
        }
    }
}
