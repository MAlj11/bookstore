package MA.entity;

public class types {
	private String id;
	private String NAME;
	private String descr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public String toString() {
		return "types [id=" + id + ", NAME=" + NAME + ", descr=" + descr + "]";
	}

}
