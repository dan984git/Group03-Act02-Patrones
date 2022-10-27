package ec.edu.ups.patron.composite.archivos;

public class DOCXFile extends FileObject {
	int size;

	public DOCXFile(String name, int size) {
		super(name);
		this.size = size;
	}
	@Override
	public int getSize() {
		return size;
	}
}
