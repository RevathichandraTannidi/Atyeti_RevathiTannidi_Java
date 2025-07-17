package service;

import controller.TrafficLightController;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileInput implements Runnable {
    private final TrafficLightController controller;
    private final File file;
    private int LineCount = 0;

    public FileInput(String path, TrafficLightController controller) {
        this.file = new File(path);
        this.controller = controller;
    }

    @Override
    public void run() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        for (int i = LineCount; i < lines.size(); i++) {
            processLine(lines.get(i));
        }
        LineCount = lines.size();
    }

    private void processLine(String line) {
        if (line.startsWith("DENSITY")) {
            String[] parts = line.split("\\s+");
            if (parts.length == 3) {
                controller.updateTrafficDensity(parts[1], parts[2]);
            }
        } else if (line.startsWith("EMERGENCY")) {
            String[] parts = line.split("\\s+");
            if (parts.length == 2) {
                controller.reportEmergency(parts[1]);
            }
        }
    }
}
