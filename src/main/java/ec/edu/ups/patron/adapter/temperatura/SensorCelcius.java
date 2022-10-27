package ec.edu.ups.patron.adapter.temperatura;

public class SensorCelcius implements SensorTemperatura {

	@Override
	public float medirTemperatura() {
		return MockTemperatura.temperaturaRandom(10, 30);
	}

    @Override
    public String unidadMedida() {
        return "°C";
    }
}
