package ec.edu.ups.demo;

import ec.edu.ups.patron.composite.archivos.DocumentFile;
import ec.edu.ups.patron.composite.archivos.FileObject;
import ec.edu.ups.patron.composite.archivos.FileType;
import ec.edu.ups.patron.composite.archivos.Folder;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author ksimaliza
 */
@Controller
@SessionScope
public class ArchivoController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private Folder root;
    private boolean isInicializarData;
    private String nameRoot;

    public ArchivoController() {
        root = new Folder("/");
        isInicializarData = true;
    }

    @GetMapping(value = "/root")
    public String getListRoot(Model model) {
        LOGGER.info("INICIALIZANDO INFORMACION ARCHIVOS");
        if (isInicializarData) {
            var documentos = new Folder("DOCUMENTOS");
            var descarga = new Folder("DESCARGA");
            var tesis = new Folder("TESIS");
            root.add(documentos);
            root.add(descarga);
            root.add(tesis);
            isInicializarData = false;
        }
        model.addAttribute("listRoot", root.getList());
        return "root";
    }

    public Folder folderByName(String name) {
        Folder folder = null;
        for (FileObject obj : root.getList()) {
            if (obj instanceof Folder && obj.getName().equals(name)) {
                folder = (Folder) obj;
                System.out.printf("%s <folder>\n", obj.getName());
                continue;
            }

            System.out.printf("%s : %sKB\n", obj.getName(), obj.getSize());
        }
        return folder;
    }

    @GetMapping("/listSubFolder/view/{name}")
    public String viewRoot(@PathVariable String name, Model modelo) {
        Folder subFolderHijo = this.folderByName(name);
        this.nameRoot = subFolderHijo.getName();
        modelo.addAttribute("subFolderName", subFolderHijo.getName());
        modelo.addAttribute("nameRoot", this.nameRoot);
        modelo.addAttribute("listSubFolder", subFolderHijo.getList());
        return "viewRoot";
    }

    @PostMapping("/root")
    public String saveFolder(@RequestParam(value = "nombre", defaultValue = "") String nombre) {
        LOGGER.info("GUARDANDO INFORMACION ARCHIVO");
        var carpetaPrincipal = new Folder(nombre);
        root.add(carpetaPrincipal);
        return "redirect:/root";
    }

    @GetMapping("/root/view/{name}")
    public String deleteFolder(@PathVariable String name) {
        Folder folderPrincipal = this.folderByName(name);
        if (folderPrincipal != null) {
            root.delete(folderPrincipal);
        }
        return "redirect:/root";
    }

    @GetMapping("/subFolder/view/{name}")
    public String deleteSubFolder(@PathVariable String name, @ModelAttribute("subFolder") Folder folder, Model modelo) {
        if (folder != null) {
            folder.delete(folder);
        }
        modelo.addAttribute("subFolderName", folder.getName());
        modelo.addAttribute("nameRoot", this.nameRoot);
        modelo.addAttribute("listSubFolder", folder.getList());
        return "redirect:/listSubFolder/view/" + this.nameRoot;
    }

    @PostMapping("/subFolder/view/{name}")
    public String addSubFolder(@PathVariable String name, @RequestParam(value = "nombre", defaultValue = "") String nombre, @RequestParam(value = "tipoArchivo", defaultValue = "") String tipoArchivo, @ModelAttribute("folder") Folder subFolder, Model modelo) {
        Folder subFolderHijo = this.folderByName(name);
        agregarSubFolder(tipoArchivo, subFolderHijo, nombre);
        modelo.addAttribute("subFolderName", subFolderHijo.getName());
        modelo.addAttribute("nameRoot", this.nameRoot);
        modelo.addAttribute("listSubFolder", subFolderHijo.getList());
        return "redirect:/listSubFolder/view/" + this.nameRoot;
    }

    private void agregarSubFolder(String tipoArchivo, Folder subFolderHijo, String nombre) {
        if (tipoArchivo.equals(FileType.PDF.name())) {
            subFolderHijo.add(new DocumentFile(FileType.PDF, 200, nombre + ".pdf"));
        } else if (tipoArchivo.equals(FileType.DOCX.name())) {
            subFolderHijo.add(new DocumentFile(FileType.DOCX, 300, nombre + ".docx"));
        } else if (tipoArchivo.equals(FileType.XLSX.name())) {
            subFolderHijo.add(new DocumentFile(FileType.XLSX, 150, nombre + ".xlsx"));
        } else {
            var folderHijo = new Folder(nombre);
            subFolderHijo.add(folderHijo);
        }
    }

}
