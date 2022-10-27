package archivos;

/**
 * Esta clase permite manejar los documentos de una forma màs versatil
 * en una sola estructura solo cambiando el tipo
 */
public class DocumentFile extends FileObject {
	int size;
	FileType type;

	public DocumentFile(FileType type, int size, String name) {
		super(name);
		this.size = size;
		this.type = type;
	}

	public FileType getType() {
		return type;
	}

	@Override
	public int getSize() {
		return size;
	}
}
