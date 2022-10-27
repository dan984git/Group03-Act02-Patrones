package archivos;

public class XLSXFile extends FileObject {
	int size;

	public XLSXFile(String name, int size) {
		super(name);
		this.size = size;
	}

	@Override
	public int getSize() {
		return size;
	}
}
