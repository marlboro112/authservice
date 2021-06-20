package service.security.auth.request;

import org.springframework.stereotype.Component;

@Component
public class RoleRequest {

	private String role;
	private Boolean enabled;
	private String description;
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		RoleRequest other = (RoleRequest) obj;
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
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RoleRequest [role=" + role + ", enabled=" + enabled + ", description=" + description + "]";
	}
	public RoleRequest(String role, Boolean enabled, String description) {
		super();
		this.role = role;
		this.enabled = enabled;
		this.description = description;
	}
	public RoleRequest() {
		super();
	}
	
	
	
}
