package asmilk.ascloud.data.cloudant.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.cloudant.client.org.lightcouch.Attachment;
import com.google.gson.annotations.SerializedName;

public class Document implements Serializable {

	private static final long serialVersionUID = -2599154277286186856L;

	@SerializedName("_id")
	private String id;
	@SerializedName("_rev")
	private String revision;
	@SerializedName("_attachments")
	private Map<String, Attachment> attachments;

	public String getId() {
		return id;
	}

	public String getRevision() {
		return revision;
	}

	public Map<String, Attachment> getAttachments() {
		return attachments;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public void setAttachments(Map<String, Attachment> attachments) {
		this.attachments = attachments;
	}

	/**
	 * Adds an in-line document attachment.
	 *
	 * @param name
	 *            The attachment file name
	 * @param attachment
	 */
	public void addAttachment(String name, Attachment attachment) {
		if (attachments == null) {
			attachments = new HashMap<String, Attachment>();
		}
		attachments.put(name, attachment);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Document document = (Document) o;

		if (id != null ? !id.equals(document.id) : document.id != null) {
			return false;
		}
		if (revision != null ? !revision.equals(document.revision) : document.revision != null) {
			return false;
		}
		return !(attachments != null ? !attachments.equals(document.attachments) : document.attachments != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (revision != null ? revision.hashCode() : 0);
		result = 31 * result + (attachments != null ? attachments.hashCode() : 0);
		return result;
	}

}
