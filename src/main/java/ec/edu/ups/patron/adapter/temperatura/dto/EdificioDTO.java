package ec.edu.ups.patron.adapter.temperatura.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ksimaliza
 */
public class EdificioDTO implements Serializable {

    private String bloque;
    private int tipoSensor;
    private int area;
    private int numDepartamento;
    private int numNivel;
    private Date fecRegistro;

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public int getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(int tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getNumDepartamento() {
        return numDepartamento;
    }

    public void setNumDepartamento(int numDepartamento) {
        this.numDepartamento = numDepartamento;
    }

    public int getNumNivel() {
        return numNivel;
    }

    public void setNumNivel(int numNivel) {
        this.numNivel = numNivel;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

}
