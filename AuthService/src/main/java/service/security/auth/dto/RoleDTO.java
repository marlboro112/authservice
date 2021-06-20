package service.security.auth.dto;

import java.util.Date;
import java.util.Set;

import org.springframework.stereotype.Component;


@Component
public class RoleDTO extends BaseDTO {

	private static final long serialVersionUID = -3578366636353644870L;

	private String role;
	private Set<PermissionDTO> permissions;
	private Boolean enabled;
	private String description;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<PermissionDTO> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<PermissionDTO> permissions) {
		this.permissions = permissions;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleDTO other = (RoleDTO) obj;
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
		if (permissions == null) {
			if (other.permissions != null)
				return false;
		} else if (!permissions.equals(other.permissions))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RoleDTO [role=" + role + ", permissions=" + permissions + ", enabled=" + enabled + ", description="
				+ description + "]";
	}
	public RoleDTO(Long id, String publicId, String description, String createdBy, Date created, String modifiedBy,
			Date modified, Boolean deleted, String deletedBy, Boolean enabled, Long version, String role,
			Set<PermissionDTO> permissions, Boolean enabled2, String description2) {
		super(id, publicId, description, createdBy, created, modifiedBy, modified, deleted, deletedBy, enabled,
				version);
		this.role = role;
		this.permissions = permissions;
		enabled = enabled2;
		description = description2;
	}
	public RoleDTO() {
		super();

	}
	public RoleDTO(Long id, String publicId, String description, String createdBy, Date created, String modifiedBy,
			Date modified, Boolean deleted, String deletedBy, Boolean enabled, Long version) {
		super(id, publicId, description, createdBy, created, modifiedBy, modified, deleted, deletedBy, enabled, version);

	}
	
	
}
