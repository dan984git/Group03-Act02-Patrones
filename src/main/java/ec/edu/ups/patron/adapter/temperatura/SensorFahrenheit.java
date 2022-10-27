package ec.edu.ups.patron.adapter.temperatura;

/**
 * Este dispositivo tiene una interfaz diferente de lo que se espera
 */
public class SensorFahrenheit {

	public float realizarMedicion() {

		return MockTemperatura.temperaturaRandom(30, 80);
	}

}

