package service.security.auth.response;

import java.util.Set;

import org.springframework.stereotype.Component;

import service.security.auth.dto.PermissionDTO;

@Component
public class RoleResponse {
	
	private String publicId;
	private String role;
	private String description;
    private Set<PermissionDTO> permissions;
    
	public String getPublicId() {
		return publicId;
	}
	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<PermissionDTO> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<PermissionDTO> permissions) {
		this.permissions = permissions;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((publicId == null) ? 0 : publicId.hashCode());
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
		RoleResponse other = (RoleResponse) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
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
		if (publicId == null) {
			if (other.publicId != null)
				return false;
		} else if (!publicId.equals(other.publicId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RoleResponse [publicId=" + publicId + ", role=" + role + ", description=" + description
				+ ", permissions=" + permissions + "]";
	}
	public RoleResponse(String publicId, String role, String description, Set<PermissionDTO> permissions) {
		super();
		this.publicId = publicId;
		this.role = role;
		this.description = description;
		this.permissions = permissions;
	}
	public RoleResponse() {
		super();
	}	
    
    
    

}
