package fr.program;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		// convertion de fichier en DrivingConverter
		DrivingConverter drivingConverter = new FileToMowerDrivingConverter(new File("ressource/commandes.txt"));

		// initialisation de Pelouse
		Lawn lawn = new Lawn(drivingConverter.getCornerX(),	drivingConverter.getCornerY());

		// parcourir la liste des positions
		int index = 0;
		for (String positionAndDirection : drivingConverter.getStartPositions()) {

			Mower mower = new Mower(Integer.parseInt(positionAndDirection.charAt(0) + ""),
					Integer.parseInt(positionAndDirection.charAt(2) + ""), 
					Direction.valueOf(positionAndDirection.charAt(4)+""), lawn);

			lawn.add(mower);

			String commandes = drivingConverter.getMowerDriving().get(index);
			for (char commande : commandes.toCharArray()) {
				if (commande == 'A') {
					mower.avancer();
				} else {
					mower.tourner(commande);
				}
				if (mower.isBlocked())
					break;
			}

			index++;
		}

		// affichage des positions finaux
		for (Mower tondeuse : lawn.getLstTendeuse()) {
			System.out.println(tondeuse);
		}
	}
}
