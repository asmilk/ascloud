package asmilk.ascloud.domain;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Book implements Serializable {

	private static final long serialVersionUID = 158223506149006607L;

	@SerializedName("_id")
	private String id;

	@SerializedName("_rev")
	private String rev;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRev() {
		return rev;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", rev=" + rev + ", name=" + name + "]";
	}

}
