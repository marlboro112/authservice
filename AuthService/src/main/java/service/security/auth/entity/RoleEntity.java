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
	
    @Column(name = "rolePublicId", length = 255,nullable = false,unique = true)
    private String rolePublicId;
	
    @Column(name = "role", length = 50,nullable = false,unique = true)
    private String role;
    
    @Column(name = "enabled", length = 10,nullable = false, columnDefinition = "BOOLEAN")
    private Boolean enabled;
    
    @Column(name = "description", length = 250)
    private String description;
    
    
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permissions",
        joinColumns        = { @JoinColumn(name = "role_id",       referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "id") }
    ) 
    
    private Set<PermissionEntity> permissions;


	public String getRolePublicId() {
		return rolePublicId;
	}


	public void setRolePublicId(String rolePublicId) {
		this.rolePublicId = rolePublicId;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((rolePublicId == null) ? 0 : rolePublicId.hashCode());
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
		if (rolePublicId == null) {
			if (other.rolePublicId != null)
				return false;
		} else if (!rolePublicId.equals(other.rolePublicId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "RoleEntity [rolePublicId=" + rolePublicId + ", role=" + role + ", enabled=" + enabled + ", description="
				+ description + ", permissions=" + permissions + "]";
	}


	public RoleEntity(Long id, String publicId, String description, String createdBy, Date created, String modifiedBy,
			Date modified, Boolean deleted, String deletedBy, Boolean enabled, Long version, String rolePublicId,
			String role, Boolean enabled2, String description2, Set<PermissionEntity> permissions) {
		super(id, publicId, description, createdBy, created, modifiedBy, modified, deleted, deletedBy, enabled,
				version);
		this.rolePublicId = rolePublicId;
		this.role = role;
		enabled = enabled2;
		description = description2;
		this.permissions = permissions;
	}


	public RoleEntity() {
		super();
	}


	public RoleEntity(Long id, String publicId, String description, String createdBy, Date created, String modifiedBy,
			Date modified, Boolean deleted, String deletedBy, Boolean enabled, Long version) {
		super(id, publicId, description, createdBy, created, modifiedBy, modified, deleted, deletedBy, enabled, version);
	}	
	
	
	
	
	
    

}
