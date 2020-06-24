package at.varga.java.welt_der_aquaristik.db;

import java.util.ArrayList;
import java.util.List;

import at.varga.java.welt_der_aquaristik.model.AQ;
import at.varga.java.welt_der_aquaristik.model.Cast;
import at.varga.java.welt_der_aquaristik.model.FishType;
import at.varga.java.welt_der_aquaristik.model.FishTypeInAQ;
import at.varga.java.welt_der_aquaristik.model.Socialization;
import at.varga.java.welt_der_aquaristik.repository.AQRepositoryJPA;
import at.varga.java.welt_der_aquaristik.repository.FishTypeInAQRepositoryJPA;
import at.varga.java.welt_der_aquaristik.repository.FishTypeRepositoryJPA;

public class FillTestDB {
	
	//FishType Objects for DB

	public static void main(String[] args) {
		
		FishTypeRepositoryJPA repo = new FishTypeRepositoryJPA();

		//LabyrintFische
		FishType fish26 = new FishType(0, "Zwergfadenfisch ", 5, 85, 350, 22, 28, 6.5f, 7.5f, 4, 10, "", Socialization.AGRESSIV,
				Cast.LABYRINTHFISCH);
		FishType fish1 = new FishType(0, "Gurami", 30, 180, 1000, 22, 28, 6.5f, 8.2f, 5, 20, "", Socialization.GRUPPENFISH,
				Cast.LABYRINTHFISCH);
		FishType fish3 = new FishType(0, "Betta", 7, 30, 100, 24, 30, 6.5f, 8f, 5, 15, "",Socialization.EINZELHALTUNG, 
				Cast.LABYRINTHFISCH);
		//Barsche
		FishType fish4 = new FishType(0, "Skalar", 15, 150, 5000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.AGRESSIV,
				Cast.BARSCH);
		FishType fish5 = new FishType(0, "Afrikanischer Schmetterlingsbuntbarsch", 6, 150, 5000, 24, 28, 5.5f, 7.2f, 2, 15, "", Socialization.GRUPPENFISH,
				Cast.BARSCH);
		FishType fish6 = new FishType(0, "Cichlide", 16, 300, 5000, 24, 27, 7.5f, 8.2f, 5, 20, "", Socialization.AGRESSIV,
				Cast.BARSCH);
		FishType fish7 = new FishType(0, "Maulbrüter", 25, 800, 5000, 24, 27, 7.5f, 8.2f, 2, 10, "", Socialization.AGRESSIV,
				Cast.BARSCH);
		//Bärblinge
		FishType fish8 = new FishType(0, "Goldfleck-Zwergbärbling", 3, 30, 300, 24, 28, 6f, 7.5f, 3, 12, "", Socialization.GRUPPENFISH,
				Cast.BAERBLING);
		FishType fish9 = new FishType(0, "Leuchtaugenbärbling", 3.5, 150, 300, 23, 28, 6.5f, 7.5f, 2, 20, "", Socialization.GRUPPENFISH,
				Cast.BAERBLING);
		FishType fish10 = new FishType(0, "Perlhuhnbärbling", 3, 50, 300, 18, 26, 7.5f, 8.2f, 5, 25, "", Socialization.GRUPPENFISH,
				Cast.BAERBLING);
		//Kaltwasserfische
		FishType fish11 = new FishType(0, "Goldfisch ", 35, 600, 10000, 4, 24, 6.5f, 7.5f, 2, 30, "", Socialization.GRUPPENFISH,
				Cast.KALTWASSERFISCH);
		FishType fish12 = new FishType(0, "Goldschleie", 60, 3000, 20000, 4, 28, 6.5f, 7.2f, 2, 15, "", Socialization.GRUPPENFISH,
				Cast.KALTWASSERFISCH);
		FishType fish13 = new FishType(0, "Koi", 55, 3000, 30000, 5, 23, 6.5f, 7.2f, 2, 15, "", Socialization.GRUPPENFISH,
				Cast.KALTWASSERFISCH);
		//Lebendgebärende
		FishType fish14 = new FishType(0, "Schwertträger", 9, 180, 1000, 24, 28, 7f, 8f, 5, 30, "", Socialization.GRUPPENFISH,
				Cast.LEBENDGEBAERENDE);
		FishType fish15 = new FishType(0, "Black Mollyh", 12, 120, 1000, 24, 30, 6.5f, 8f, 10, 30, "", Socialization.AGRESSIV,
				Cast.LEBENDGEBAERENDE);
		FishType fish16 = new FishType(0, "Endler Guppy", 3, 45, 1000, 18, 28, 6.5f, 8.2f, 2, 30, "", Socialization.AGRESSIV,
				Cast.LEBENDGEBAERENDE);
		//Salmler
		FishType fish2 = new FishType(0, "Neon", 6, 120, 5000, 23, 28, 6.5f, 7.5f, 2, 20, "", Socialization.GRUPPENFISH,
				Cast.SALMLER);
		FishType fish17 = new FishType(0, "Rotkopfsalmler", 5, 150, 5000, 22, 31, 6.5f, 7.0f, 2, 15, "", Socialization.GRUPPENFISH,
				Cast.SALMLER);
		FishType fish18 = new FishType(0, "Blutsalmler", 4, 180, 5000, 24, 28, 6.5f, 7.2f, 2, 25, "", Socialization.GRUPPENFISH,
				Cast.SALMLER);
		FishType fish19 = new FishType(0, "Beilbauchfisch", 5, 150, 1000, 24, 28, 6.5f, 7.5f, 5, 15, "", Socialization.GRUPPENFISH,
				Cast.SALMLER);
		//Welse
		FishType fish20 = new FishType(0, "Antennenwels ", 18, 120, 10000, 24, 28, 6.5f, 7.5f, 2, 20, "", Socialization.GRUPPENFISH,
				Cast.WELS);
		FishType fish21 = new FishType(0, "Ohrgitterharnischwels", 4, 50, 1000, 20, 26, 6.5f, 7.5f, 2, 20, "", Socialization.GRUPPENFISH,
				Cast.WELS);
		FishType fish22 = new FishType(0, "Panzerwels", 7, 80, 1000, 24, 28, 6.5f, 7f, 2, 30, "", Socialization.GRUPPENFISH,
				Cast.WELS);
		//EigeneFische
		FishType fish23 = new FishType(0, "Weißstirn-Messerfisch", 20, 650, 10000, 22, 28, 6.5f, 7.2f, 5, 6, "", Socialization.AGRESSIV,
				Cast.ANDERE_FISCH);
		FishType fish24 = new FishType(0, "Grüner Kugelfisch", 17, 250, 1000, 24, 28, 6.5f, 7.8f, 8, 25, "", Socialization.EINZELHALTUNG,
				Cast.ANDERE_FISCH);
		FishType fish25 = new FishType(0, "Goldringelgrundel", 4.5, 80, 350, 24, 30, 7.5f, 8.2f, 2, 15, "", Socialization.AGRESSIV,
				Cast.ANDERE_FISCH);
		
		List<FishType> types = new ArrayList<FishType>(List.of(fish1,fish2, fish3, fish4, fish5, fish6, fish7, fish8, fish9, fish10,
				fish11, fish12, fish13, fish14, fish15, fish16, fish17, fish18, fish19, fish20,
				fish21, fish22, fish23, fish24, fish25, fish26));
		
		for (FishType t : types) {
			
			repo.add(t);
		}
		
		//AQ objects for DB
//		AQ a = new AQ(aqId, titel, sizeWidth, sizeLength, sizeHeight, temperatur, gH, ph, listOfFishes);
		AQRepositoryJPA aqRepo = new AQRepositoryJPA();
		AQ aq1 = new AQ(0, "Garnelen Aquarium", 30, 30, 30, 25, 15, 7.6, null);
		AQ aq2 = new AQ(0, "Grösses Aquarium", 180, 60, 60, 27, 22, 7.2, null);
		AQ aq3 = new AQ(0, "Predators Aq", 40, 32, 28, 26, 18, 6.9, null);
		AQ aq4 = new AQ(0, "Algen Land", 100, 30, 30, 22, 22, 7.7, null);
		
		
		
		
		List<AQ> aqs = new ArrayList<AQ>(List.of(aq1, aq2, aq3, aq4));
		
		for (AQ a : aqs) {
			aqRepo.add(a);
		}
		FishTypeInAQRepositoryJPA ftinaqRepo = new FishTypeInAQRepositoryJPA();
		FishTypeInAQ ftia = new FishTypeInAQ(fish25, aq4, 6);
		List <FishTypeInAQ> fishTypeInAQList = new ArrayList<FishTypeInAQ>(List.of(ftia));
		for (FishTypeInAQ ft : fishTypeInAQList) {
			ftinaqRepo.add(ft);
		}

	}

}
