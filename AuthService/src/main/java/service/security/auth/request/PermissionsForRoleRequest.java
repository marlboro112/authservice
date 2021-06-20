package service.security.auth.request;

import java.util.Set;

import org.springframework.stereotype.Component;

import service.security.auth.dto.PermissionDTO;


@Component
public class PermissionsForRoleRequest {
	
	private String publicId;	
	private Set<PermissionDTO> permissions;
	
	public String getpublicId() {
		return publicId;
	}
	public void setpublicId(String publicId) {
		this.publicId = publicId;
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
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
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
		PermissionsForRoleRequest other = (PermissionsForRoleRequest) obj;
		if (permissions == null) {
			if (other.permissions != null)
				return false;
		} else if (!permissions.equals(other.permissions))
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
		return "PermissionsForRoleRequest [publicId=" + publicId + ", permissions=" + permissions + "]";
	}
	public PermissionsForRoleRequest(String publicId, Set<PermissionDTO> permissions) {
		super();
		this.publicId = publicId;
		this.permissions = permissions;
	}
	public PermissionsForRoleRequest() {
		super();
	}
	
	
	

}
