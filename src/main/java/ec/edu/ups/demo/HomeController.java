package ec.edu.ups.demo;

import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author ksimaliza
 */
@Controller
@SessionScope
public class HomeController {
    
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @GetMapping(value = "/home")
    public String getListRoot(Model model) {
        LOGGER.info("INICIANDO PAGINA PRINCIPAL");
        return "home";
    }
    
}
