
import ec.edu.ups.patron.composite.archivos.DocumentFile;
import ec.edu.ups.patron.composite.archivos.FileType;
import ec.edu.ups.patron.composite.archivos.Folder;
import ec.edu.ups.patron.composite.archivos.XLSXFile;

//import archivos.DocumentFile;
//import archivos.FileType;
//import archivos.Folder;
//import archivos.XLSXFile;
//import temperatura.AdaptadorFahrenheitCelcius;
//import temperatura.SensorCelcius;
//import temperatura.SensorFahrenheit;
//import temperatura.TemperaturaEdificio;

public class Main {
	public static void main(String[] args) {
		System.out.println("PATRONES DE DISEÑO");
		//demoAdapter();
		demoComposite();
	}

//	public static void demoAdapter() {
//		TemperaturaEdificio edificio = new TemperaturaEdificio();
//		edificio.addSensor("BODEGA", new SensorCelcius())
//				.addSensor("RECEPCION", new AdaptadorFahrenheitCelcius(new SensorFahrenheit()))
//				.addSensor("COMEDOR", new SensorCelcius())
//				.addSensor("PLANTA 1", new AdaptadorFahrenheitCelcius(new SensorFahrenheit()));
//		edificio.imprimirMediciones();
//	}

	public static void demoComposite() {
		var root = new Folder("/");
		root.add(new DocumentFile(FileType.DOCX, 150, "tesis.docx"));
		root.add(new DocumentFile(FileType.XLSX, 500, "presupuesto.xlsx"));
		root.add(new XLSXFile("activos.xlsx", 256));

		var subfolder = new Folder("/documentos");
		subfolder.add(new DocumentFile(FileType.PDF, 200, "cv.pdf"));
		subfolder.add(new DocumentFile(FileType.PDF, 300, "copia-cedula.pdf"));
		subfolder.add(new DocumentFile(FileType.PDF, 400, "papeleta.pdf"));

		root.add(subfolder);

		System.out.println("FOLDER / DETAILS:");
		root.listFiles();
		System.out.println();
		System.out.println("FOLDER /documentos DETAILS:");
		subfolder.listFiles();

		System.out.println();
		System.out.printf("Folder '%s' size: %sKB\n", subfolder.getName(), subfolder.getSize());
		System.out.printf("Folder '%s' size: %sKB\n", root.getName(), root.getSize());


	}
}