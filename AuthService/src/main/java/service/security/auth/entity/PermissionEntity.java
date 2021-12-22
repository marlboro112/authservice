package service.security.auth.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PERMISSIONS")
public class PermissionEntity extends BaseEntity {

	private static final long serialVersionUID = 8424851443971419602L;
	
    @Column(name = "permission", length = 255)
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
		PermissionEntity other = (PermissionEntity) obj;
		if (permission == null) {
			if (other.permission != null)
				return false;
		} else if (!permission.equals(other.permission))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PermissionEntity [permission=" + permission + "]";
	}

	public PermissionEntity(Long id, String publicId, String description, String createdBy, Date created,
			String modifiedBy, Date modified, Boolean deleted, String deletedBy, Boolean enabled, Long version,
			String permission) {
		super(id, publicId, description, createdBy, created, modifiedBy, modified, deleted, deletedBy, enabled,
				version);
		this.permission = permission;
	}

	public PermissionEntity() {
		super();

	}

	public PermissionEntity(Long id, String publicId, String description, String createdBy, Date created,
			String modifiedBy, Date modified, Boolean deleted, String deletedBy, Boolean enabled, Long version) {
		super(id, publicId, description, createdBy, created, modifiedBy, modified, deleted, deletedBy, enabled, version);

	}

	
}
