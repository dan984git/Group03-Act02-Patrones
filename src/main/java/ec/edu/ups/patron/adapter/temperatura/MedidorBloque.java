package ec.edu.ups.patron.adapter.temperatura;

import ec.edu.ups.patron.adapter.temperatura.dto.EdificioDTO;

public class MedidorBloque {

    private String bloque;
    private SensorTemperatura medidor;
    private EdificioDTO edificioDTO;

    public MedidorBloque(String bloque, SensorTemperatura medidor, EdificioDTO edificioDTO) {
        this.bloque = bloque;
        this.medidor = medidor;
        this.edificioDTO = edificioDTO;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public SensorTemperatura getMedidor() {
        return medidor;
    }

    public void setMedidor(SensorTemperatura medidor) {
        this.medidor = medidor;
    }

    public EdificioDTO getEdificioDTO() {
        return edificioDTO;
    }

    public void setEdificioDTO(EdificioDTO edificioDTO) {
        this.edificioDTO = edificioDTO;
    }

}
