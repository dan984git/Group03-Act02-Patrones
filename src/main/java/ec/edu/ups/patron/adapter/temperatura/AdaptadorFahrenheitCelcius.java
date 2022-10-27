package ec.edu.ups.patron.adapter.temperatura;

public class AdaptadorFahrenheitCelcius implements SensorTemperatura {

	private SensorFahrenheit sensorAdaptado;

	public AdaptadorFahrenheitCelcius(SensorFahrenheit sensorAdaptado) {
		this.sensorAdaptado = sensorAdaptado;
	}

	@Override
	public float medirTemperatura() {
		// ºC = (ºF -32) / 1,8
		float tempFar = sensorAdaptado.realizarMedicion();
		// retorno transformado a celcius
		return (float) ((tempFar - 32) / 1.8);
	}

    @Override
    public String unidadMedida() {
        return "°F";
    }
}
