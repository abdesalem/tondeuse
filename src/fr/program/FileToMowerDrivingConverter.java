package fr.program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileToMowerDrivingConverter implements DrivingConverter {

	private int cornerX;

	private int cornerY;

	private List<String> startPositions ;

	private List<String> mowerDriving;

	public FileToMowerDrivingConverter(File fo) {
		parse(fo);
	}

	
	private void parse(File file) {
		
		startPositions =  new ArrayList<>();
		mowerDriving = new ArrayList<>();
		
		// file parsing
		int index = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}

				if (index == 0) {
					cornerX  = Integer.parseInt(line.split(" ")[0]);
					cornerY = Integer.parseInt(line.split(" ")[1]);
				} else if (index % 2 == 0) {
					mowerDriving.add(line);
				} else {
					startPositions.add(line);
				}

				index++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getCornerX() {
		return cornerX;
	}

	public int getCornerY() {
		return cornerY;
	}

	public List<String> getStartPositions() {
		return startPositions;
	}

	public List<String> getMowerDriving() {
		return mowerDriving;
	}
}
