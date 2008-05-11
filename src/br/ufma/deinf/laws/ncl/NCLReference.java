package br.ufma.deinf.laws.ncl;

public class NCLReference {
	private String tagname;
	private String attribute;
	private String refTagname;
	private String refAttribute;
	
	public NCLReference() {
		// TODO Auto-generated constructor stub
	}

	public NCLReference(String tagname, String attribute, String refTagname,
			String refAttribute) {
		super();
		this.tagname = tagname;
		this.attribute = attribute;
		this.refTagname = refTagname;
		this.refAttribute = refAttribute;
	}	

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getRefTagname() {
		return refTagname;
	}

	public void setRefTagname(String refTagname) {
		this.refTagname = refTagname;
	}

	public String getRefAttribute() {
		return refAttribute;
	}

	public void setRefAttribute(String refAttribute) {
		this.refAttribute = refAttribute;
	}	
}
