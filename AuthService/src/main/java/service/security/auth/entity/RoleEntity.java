package service.security.auth.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class RoleEntity extends BaseEntity {

	private static final long serialVersionUID = -438765684336800137L;
	
    @Column(name = "role", length = 50,nullable = false,unique = true)
    private String role;
         
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permissions",
        joinColumns        = { @JoinColumn(name = "role_id",       referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "id") }
    ) 
    
    private Set<PermissionEntity> permissions;


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	public Set<PermissionEntity> getPermissions() {
		return permissions;
	}


	public void setPermissions(Set<PermissionEntity> permissions) {
		this.permissions = permissions;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		RoleEntity other = (RoleEntity) obj;
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
		return "RoleEntity [role=" + role + ", permissions=" + permissions + "]";
	}


	public RoleEntity(Long id, String publicId, String description, String createdBy, Date created, String modifiedBy,
			Date modified, Boolean deleted, String deletedBy, Boolean enabled, Long version, String role,
			Set<PermissionEntity> permissions) {
		super(id, publicId, description, createdBy, created, modifiedBy, modified, deleted, deletedBy, enabled,
				version);
		this.role = role;
		this.permissions = permissions;
	}


	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RoleEntity(Long id, String publicId, String description, String createdBy, Date created, String modifiedBy,
			Date modified, Boolean deleted, String deletedBy, Boolean enabled, Long version) {
		super(id, publicId, description, createdBy, created, modifiedBy, modified, deleted, deletedBy, enabled, version);
		// TODO Auto-generated constructor stub
	}



}
