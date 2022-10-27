package ec.edu.ups.patron.composite.archivos;

public abstract class FileObject {
	String name;

	public FileObject(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract int getSize();
}

