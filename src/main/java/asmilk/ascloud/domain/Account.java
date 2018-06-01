package asmilk.ascloud.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import asmilk.ascloud.data.cloudant.model.Document;

@Entity
public class Account extends Document implements Serializable {

	private static final long serialVersionUID = 3329478488819188394L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long pk;

	@Version
	private Long version;

	private String name;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{_id=" + getId() + ", _rev=" + getRevision() + "}; @" + this.getClass().getName() + " [pk=" + pk
				+ ", version=" + version + ", name=" + name + "]";
	}

}
