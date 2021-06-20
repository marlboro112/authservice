package service.security.auth.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BaseDTO implements Serializable {

	private static final long serialVersionUID = -375233029207038155L;
	
	private Long id;
	private String publicId;
	private String description;
	private String createdBy;
	private Date created;
	private String modifiedBy;
	private Date modified;
	private Boolean deleted;
	private String deletedBy;
	private Boolean enabled;
	private Long version;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPublicId() {
		return publicId;
	}
	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public String getDeletedBy() {
		return deletedBy;
	}
	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
		result = prime * result + ((deletedBy == null) ? 0 : deletedBy.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((modified == null) ? 0 : modified.hashCode());
		result = prime * result + ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
		result = prime * result + ((publicId == null) ? 0 : publicId.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseDTO other = (BaseDTO) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (deleted == null) {
			if (other.deleted != null)
				return false;
		} else if (!deleted.equals(other.deleted))
			return false;
		if (deletedBy == null) {
			if (other.deletedBy != null)
				return false;
		} else if (!deletedBy.equals(other.deletedBy))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (modified == null) {
			if (other.modified != null)
				return false;
		} else if (!modified.equals(other.modified))
			return false;
		if (modifiedBy == null) {
			if (other.modifiedBy != null)
				return false;
		} else if (!modifiedBy.equals(other.modifiedBy))
			return false;
		if (publicId == null) {
			if (other.publicId != null)
				return false;
		} else if (!publicId.equals(other.publicId))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BaseDTO [id=" + id + ", publicId=" + publicId + ", description=" + description + ", createdBy="
				+ createdBy + ", created=" + created + ", modifiedBy=" + modifiedBy + ", modified=" + modified
				+ ", deleted=" + deleted + ", deletedBy=" + deletedBy + ", enabled=" + enabled + ", version=" + version
				+ "]";
	}
	public BaseDTO(Long id, String publicId, String description, String createdBy, Date created, String modifiedBy,
			Date modified, Boolean deleted, String deletedBy, Boolean enabled, Long version) {
		super();
		this.id = id;
		this.publicId = publicId;
		this.description = description;
		this.createdBy = createdBy;
		this.created = created;
		this.modifiedBy = modifiedBy;
		this.modified = modified;
		this.deleted = deleted;
		this.deletedBy = deletedBy;
		this.enabled = enabled;
		this.version = version;
	}
	public BaseDTO() {
		super();
	}
	
	

}
