package service.security.auth.response;

import java.util.Set;

import org.springframework.stereotype.Component;

import service.security.auth.dto.PermissionDTO;
import service.security.auth.dto.RoleDTO;

@Component
public class UserResponse {
	
	private String publicId;
	private String firstName;
	private String lastName;
	private String email;
	private String organization;
	private String mobilePhone;
	private RoleDTO role;

	private Set<PermissionDTO> permissions;
	
	public String getPublicId() {
		return publicId;
	}
	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public RoleDTO getRole() {
		return role;
	}
	public void setRole(RoleDTO role) {
		this.role = role;
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
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
		result = prime * result + ((publicId == null) ? 0 : publicId.hashCode());
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
		UserResponse other = (UserResponse) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobilePhone == null) {
			if (other.mobilePhone != null)
				return false;
		} else if (!mobilePhone.equals(other.mobilePhone))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
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
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserResponse [publicId=" + publicId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", organization=" + organization + ", mobilePhone=" + mobilePhone + ", role=" + role
				+ ", permissions=" + permissions + "]";
	}
	public UserResponse(String publicId, String firstName, String lastName, String email, String organization,
			String mobilePhone, RoleDTO role, Set<PermissionDTO> permissions) {
		super();
		this.publicId = publicId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.organization = organization;
		this.mobilePhone = mobilePhone;
		this.role = role;
		this.permissions = permissions;
	}
	public UserResponse() {
		super();
	}
	
	
	

}
