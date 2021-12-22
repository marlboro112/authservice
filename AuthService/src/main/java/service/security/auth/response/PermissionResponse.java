package service.security.auth.response;

import org.springframework.stereotype.Component;

@Component
public class PermissionResponse {

	private String publicId;
	private String permission;
	private String description;
	
	public String getPublicId() {
		return publicId;
	}
	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
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
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((permission == null) ? 0 : permission.hashCode());
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
		PermissionResponse other = (PermissionResponse) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (permission == null) {
			if (other.permission != null)
				return false;
		} else if (!permission.equals(other.permission))
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
		return "PermissionResponse [publicId=" + publicId + ", permission=" + permission + ", description="
				+ description + "]";
	}
	public PermissionResponse(String publicId, String permission, String description) {
		super();
		this.publicId = publicId;
		this.permission = permission;
		this.description = description;
	}
	public PermissionResponse() {
		super();

	}
	
	
	
}
