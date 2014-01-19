package fr.xebia;

import java.util.List;

public interface DrivingConverter {

	int getCornerX();
	
	int getCornerY();
	
	List<String> getStartPositions ();
	
	List<String> getMowerDriving ();
}
