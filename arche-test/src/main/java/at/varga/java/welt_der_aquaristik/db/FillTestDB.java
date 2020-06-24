package at.varga.java.welt_der_aquaristik.db;

import java.util.ArrayList;
import java.util.List;

import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.model.Cast;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.model.Socialization;
import at.varga.java.welt_der_aquaristik.repository.AQRepositoryJPA;
import at.varga.java.welt_der_aquaristik.repository.FishTypeRepositoryJPA;

public class FillTestDB {
	
	// jprie: Testdaten in die Datenbank einfÃ¼gen als extra Java-Programm

	public static void main(String[] args) {
		
		FishTypeRepositoryJPA repo = new FishTypeRepositoryJPA();
		
		FishType fishFirst = new FishType(0, "Neon", 5, 120, 1000, 23, 28, 5f, 7.5f, 2, 20, "", Socialization.GRUPPENFISH,
				Cast.SALMLER);
		FishType fishSecond = new FishType(0, "Betta", 7, 30, 100, 24, 30, 5.5f, 7.5f, 2, 20, "",
				Socialization.EINZELHALTUNG, Cast.LABYRINTHFISCH);
		FishType fishThird = new FishType(0, "Skalar", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
				Cast.BARSCH);
		FishType fish5 = new FishType(0, "fish1", 15, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
				Cast.ANDERE_FISCH);
		FishType fish6 = new FishType(0, "fish2", 115, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
				Cast.BARSCH);
		FishType fish7 = new FishType(0, "fish3", 1115, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
				Cast.BAERBLING);
		FishType fish8 = new FishType(0, "fish4", 11115, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
				Cast.KALTWASSERFISCH);
		FishType fish9 = new FishType(0, "fish5", 155, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
				Cast.LABYRINTHFISCH);
		FishType fish10 = new FishType(0, "fish6", 22, 1500, 10000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
				Cast.LABYRINTHFISCH);
		FishType fish11 = new FishType(0, "fish7", 35, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.GRUPPENFISH,
				Cast.LEBENDGEBAERENDE);
		FishType fish12 = new FishType(0, "fish8", 45, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
				Cast.SALMLER);
		FishType fish13 = new FishType(0, "fish9", 55, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.GRUPPENFISH,
				Cast.WELS);
		FishType fish14 = new FishType(0, "fish10", 175, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
				Cast.LABYRINTHFISCH);
		FishType fish15 = new FishType(0, "fish11", 1, 150, 1000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
				Cast.LABYRINTHFISCH);
		
		
		List<FishType> types = new ArrayList<FishType>(List.of(fishFirst, fishSecond, fish5, fish6, fish7, fish8, fish9, fish10, fish11, fish12, fish13, fish14,fish15));
		
		for (FishType t : types) {
			
			repo.add(t);
		}
		
		AQRepositoryJPA aqRepo = new AQRepositoryJPA();
		AQ aq1 = new AQ(0, "Garnelen Aquarium", 30, 30, 30, 25, 15, 7.6, null);
		AQ aq2 = new AQ(0, "Grösses Aquarium", 180, 60, 60, 27, 22, 7.2, null);
		AQ aq3 = new AQ(0, "Predators Aq", 40, 32, 28, 26, 18, 6.9, null);
		AQ aq4 = new AQ(0, "titel", 100, 30, 30, 22, 22, 7.7, null);
		
		
		List<AQ> aqs = new ArrayList<AQ>(List.of(aq1, aq2, aq3, aq4));
		
		for (AQ a : aqs) {
			aqRepo.add(a);
		}

	}

}
