package asmilk.ascloud.domain;

import java.io.Serializable;

import com.cloudant.client.api.model.Document;

public class Book extends Document implements Serializable {

	private static final long serialVersionUID = 158223506149006607L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{_id=" + getId() + ", _rev=" + getRevision() + "}; @Book [name=" + name;
	}

}
