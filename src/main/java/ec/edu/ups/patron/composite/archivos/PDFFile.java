package ec.edu.ups.patron.composite.archivos;

public class PDFFile extends FileObject {
	int size;

	public PDFFile(String name, int size) {
		super(name);
		this.size = size;
	}

	@Override
	public int getSize() {
		return size;
	}
}
