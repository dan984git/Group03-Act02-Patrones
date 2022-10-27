package ec.edu.ups.demo;

import ec.edu.ups.patron.adapter.temperatura.dto.EdificioDTO;
import ec.edu.ups.patron.adapter.temperatura.AdaptadorFahrenheitCelcius;
import ec.edu.ups.patron.adapter.temperatura.SensorCelcius;
import ec.edu.ups.patron.adapter.temperatura.SensorFahrenheit;
import ec.edu.ups.patron.adapter.temperatura.TemperaturaEdificio;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ksimaliza
 */
@Controller
public class MedidorTemperaturaController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private TemperaturaEdificio servicioEdificio;
    private boolean isInicializarData;

    public MedidorTemperaturaController() {
        servicioEdificio = new TemperaturaEdificio();
        isInicializarData = true;
    }

    @GetMapping(value = "/medidorTemperatura")
    public String getListEdificio(Model model) {
        LOGGER.info("OBTENIENDO INFORMACION BLOQUE EDIFICIO");
        EdificioDTO edificio = new EdificioDTO();
        edificio.setFecRegistro(new Date());
        if (isInicializarData) {
            servicioEdificio.addSensor("BODEGA", new SensorCelcius(), edificio)
                    .addSensor("RECEPCION", new AdaptadorFahrenheitCelcius(new SensorFahrenheit()), edificio)
                    .addSensor("COMEDOR", new SensorCelcius(), edificio)
                    .addSensor("PLANTA 1", new AdaptadorFahrenheitCelcius(new SensorFahrenheit()), edificio);
            isInicializarData = false;
        }
        model.addAttribute("listEdificio", servicioEdificio.getMedicionBloques());
        return "medidorTemperatura";
    }

    @GetMapping("/temperatura/new")
    public String mostrarFormularioDeRegistroTemperatura(Model modelo) {
        LOGGER.info("MOSTRANDO INFORMACION BLOQUE EDIFICIO");
        EdificioDTO edificio = new EdificioDTO();
        modelo.addAttribute("edificio", edificio);
        return "registrar";
    }

    @PostMapping("/medidorTemperatura")
    public String guardarBloqueTemperatura(@ModelAttribute("edificio") EdificioDTO edificio) {
        LOGGER.info("GUARDANDO INFORMACION BLOQUE EDIFICIO");
        edificio.setFecRegistro(new Date());
        servicioEdificio.addSensor(edificio.getBloque(), edificio.getArea() > 500 ? new AdaptadorFahrenheitCelcius(new SensorFahrenheit()) : new SensorCelcius(), edificio);
        return "redirect:/medidorTemperatura";
    }

}
