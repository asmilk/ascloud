package asmilk.ascloud.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@Entity
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Account implements Serializable {

	private static final long serialVersionUID = 8186933733104007451L;

	@SerializedName("_id")
	private String docId;

	@SerializedName("_rev")
	private String docRev;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@Version
	private Long rev;

	private String name;

	@JsonProperty("_id")
	public String getDocId() {
		return docId;
	}

	@JsonProperty("_rev")
	public String getDocRev() {
		return docRev;
	}

	public Long getId() {
		return id;
	}

	public Long getRev() {
		return rev;
	}

	public String getName() {
		return name;
	}

	@JsonProperty("_id")
	public void setDocId(String docId) {
		this.docId = docId;
	}

	@JsonProperty("_rev")
	public void setDocRev(String docRev) {
		this.docRev = docRev;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRev(Long rev) {
		this.rev = rev;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [docId=" + docId + ", docRev=" + docRev + ", id=" + id + ", rev=" + rev + ", name=" + name
				+ "]";
	}

}
