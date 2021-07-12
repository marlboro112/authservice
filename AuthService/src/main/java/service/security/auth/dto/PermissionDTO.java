package service.security.auth.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class PermissionDTO extends BaseDTO {

	private static final long serialVersionUID = -8725078928892706610L;
	
	private String permission;
	
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((permission == null) ? 0 : permission.hashCode());
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
		PermissionDTO other = (PermissionDTO) obj;
		if (permission == null) {
			if (other.permission != null)
				return false;
		} else if (!permission.equals(other.permission))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PermissionDTO [permission=" + permission + "]";
	}
	public PermissionDTO(Long id, String publicId, String description, String createdBy, Date created,
			String modifiedBy, Date modified, Boolean deleted, String deletedBy, Boolean enabled, Long version,
			String permission) {
		super(id, publicId, description, createdBy, created, modifiedBy, modified, deleted, deletedBy, enabled,
				version);
		this.permission = permission;
	}
	public PermissionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PermissionDTO(Long id, String publicId, String description, String createdBy, Date created,
			String modifiedBy, Date modified, Boolean deleted, String deletedBy, Boolean enabled, Long version) {
		super(id, publicId, description, createdBy, created, modifiedBy, modified, deleted, deletedBy, enabled, version);
		// TODO Auto-generated constructor stub
	}
	
	

}
