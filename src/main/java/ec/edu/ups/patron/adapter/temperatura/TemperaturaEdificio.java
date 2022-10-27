package ec.edu.ups.patron.adapter.temperatura;

import ec.edu.ups.patron.adapter.temperatura.dto.EdificioDTO;
import java.util.ArrayList;

public class TemperaturaEdificio {

    private ArrayList<MedidorBloque> medicionBloques;

    public TemperaturaEdificio() {
        medicionBloques = new ArrayList<MedidorBloque>();
    }

    public TemperaturaEdificio addSensor(String bloque, SensorTemperatura sensor, EdificioDTO edificioDTO) {
        MedidorBloque registro = new MedidorBloque(bloque, sensor, edificioDTO);
        medicionBloques.add(registro);
        return this;
    }

    public void imprimirMediciones() {
        System.out.println("TEMPERATURAS REGISTRADAS (grados celcius)");
        for (MedidorBloque m : medicionBloques) {
            float tempCelcius = m.getMedidor().medirTemperatura();
            System.out.printf("Bloque: %s, Temperatura: %s\n", m.getBloque(), tempCelcius);
        }

    }

    public ArrayList<MedidorBloque> getMedicionBloques() {
        return medicionBloques;
    }

    public void setMedicionBloques(ArrayList<MedidorBloque> medicionBloques) {
        this.medicionBloques = medicionBloques;
    }

}
