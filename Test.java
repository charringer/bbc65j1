import static java.lang.System.out;

public class Test {
	public static void main(String[] args) {
		out.println("------------------------------------------------------------------");	
		out.println("Teste allgemeine Funktionalität und Sonderfälle mittels UnitTests:");	
		out.println("------------------------------------------------------------------\n");	
		TestRunner.main(
			ElectroCarTest.class,
			FuhrparkTest.class,
			GasolineCarTest.class,
			PurposeTest.class,
			SpecialIterTest.class,
			VehicleTest.class,
			FuhrparkSetTest.class);

		out.println("\n-----------------------------------");	
		out.println(  "Führe Testscenario laut Angabe aus:");	
		out.println(  "-----------------------------------\n");	

		out.println("Erstelle Menge von Fuhrpärken.");
		FuhrparkSet fuhrparkSet = new FuhrparkSet();

		out.println("\nFüge 10 Fuhrpärke zu der Furhparkmenge hinzu.");
		for(int i=1; i<=10; i++) {
			Fuhrpark f = new Fuhrpark("Fuhrpark"+i);
			if(fuhrparkSet.insert(f))
				out.println("Habe Fuhrpark"+i+" hinzu gefügt.");
		}

		out.println("\nFüge zu den ersten 3 Fuhrpärken jeweils 3 Fahrzeuge hinzu");
		for(int i=1; i<=3; i++) {
			ElectroCar ecar = new ElectroCar(10*i+1);
			PassengerTransportation p = new PassengerTransportation(4);	
			ecar.setPurpose(p);
			ecar.incrementMileage(100*i+10);
			ecar.incrementPowerConsumption(1000*i+1);
			fuhrparkSet.get("Fuhrpark"+i).InsertVehicle(ecar);
			ecar = new ElectroCar(10*i+2);
			GoodsTransportation g = new GoodsTransportation(5, 10);
			ecar.setPurpose(g);
			ecar.incrementMileage(100*i+20);
			ecar.incrementPowerConsumption(1000*i+2);
			fuhrparkSet.get("Fuhrpark"+i).InsertVehicle(ecar);
			GasolineCar gcar = new GasolineCar(10*i+3);
			p = new PassengerTransportation(6);	
			gcar.incrementMileage(100*i+30);
			gcar.incrementFuelConsumption(1000*i+3);
			gcar.setPurpose(p);
			fuhrparkSet.get("Fuhrpark"+i).InsertVehicle(gcar);
		}

		out.println("\nEntferne aus dem 2. Fuhrpark das 3. Fahrzeug");
		fuhrparkSet.get("Fuhrpark2").RemoveVehicle(23);
		if(!fuhrparkSet.get("Fuhrpark2").has(23))
			out.println("\tDas Fahrzeug wurde erfolgreich entfernt!");
		else {
			out.println("\tError: Das Fahrzeug wurde nicht entfernt!");
			return;
		}

		out.println("\nErhöhe die zurück gelegte Strecke vom 1. Fahrzeug im 3. Fuhrpark.");
		out.println("\tBisherige Strecke: "+fuhrparkSet.get("Fuhrpark3").get(31).getMileage());
		fuhrparkSet.get("Fuhrpark3").get(31).incrementMileage(40);
		out.println("\tErhöte Strecke: "+fuhrparkSet.get("Fuhrpark3").get(31).getMileage());

		out.println("\nErhöhe den Stromverbrauch vom 2. Fahrzeug im 3. Fuhrpark.");
		out.println("\tBisheriger Verbrauch: "+((ElectroCar)fuhrparkSet.get("Fuhrpark3").get(32)).getPowerConsumption());
		((ElectroCar)fuhrparkSet.get("Fuhrpark3").get(32)).incrementPowerConsumption(50);
		out.println("\tErhöter Verbrauch: "+((ElectroCar)fuhrparkSet.get("Fuhrpark3").get(32)).getPowerConsumption());

		out.println("\nÄndere den Zweck vom 3. Fahrzeug im 3. Fuhrpark.");
		PassengerTransportation p = new PassengerTransportation(8);
		fuhrparkSet.get("Fuhrpark3").get(33).setPurpose(p);
		if(fuhrparkSet.get("Fuhrpark3").get(33).getPurpose() instanceof PassengerTransportation)
			out.println("\tDas Fahrzeug wird nun als Passergiertransporter eingesetzt.");

		out.println("\nStatistiken:");
		for(int i=1; i<=10; i++) {
			out.println("\tStatistik für Fuhrpark"+i+" :");
			Fuhrpark f = fuhrparkSet.get("Fuhrpark"+i);

			out.println("\t\tDurchschnittlicher Treibstoffverbrauch: "+f.averageFuelConsumption());
			out.println("\t\tDurchschnittlicher Treibstoffverbrauch (nur Passagierfahrzeuge): "
					+f.averageFuelConsumptionPassengerTransport());
			out.println("\t\tDurchschnittlicher Treibstoffverbrauch (nur Transportfahrzeuge): "
					+f.averageFuelConsumptionGoodsTransport());

			out.println("\t\tDurchschnittlicher Stromverbrauch: "+f.averagePowerConsumption());
			out.println("\t\tDurchschnittlicher Stromverbrauch (nur Passagierfahrzeuge): "
					+f.averagePowerConsumptionPassengerTransport());
			out.println("\t\tDurchschnittlicher Stromverbrauch (nur Transportfahrzeuge): "
					+f.averagePowerConsumptionGoodsTransport());

			out.println("\t\tDurchschnittlicher Sitzanzahl: "+f.averageSeats());
			out.println("\t\tDurchschnittlicher Sitzanzahl (nur Elektroautos): "
					+f.averageSeatsOnElectroCars());
			out.println("\t\tDurchschnittlicher Sitzanzahl (nur Fahrzeuge mit Verbrennungsmotor): "
					+f.averageSeatsOnGasolineCars());

			out.println("\t\tDurchschnittlicher Ladefläche: "+f.averageCargoArea());
			out.println("\t\tDurchschnittlicher Ladefläche (nur Elektroautos): "
					+f.averageCargoAreaOnElectroCars());
			out.println("\t\tDurchschnittlicher Ladefläche (nur Fahrzeuge mit Verbrennungsmotor): "
					+f.averageCargoAreaOnGasolineCars());
		}
	}
}
