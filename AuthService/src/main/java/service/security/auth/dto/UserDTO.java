package service.security.auth.dto;

import java.util.Date;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class UserDTO extends BaseDTO {

	private static final long serialVersionUID = -572821373232376970L;
	
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String encryptedPassword;
	private String emailVerificationToken;
	private Boolean emailVerificationStatus;
	private String tokenSecret;
	private String organization;
	private String mobilePhone;
    private RoleDTO role;
    private Set<PermissionDTO> permissions;
    
    
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}
	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}
	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}
	public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}
	public String getTokenSecret() {
		return tokenSecret;
	}
	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
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
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emailVerificationStatus == null) ? 0 : emailVerificationStatus.hashCode());
		result = prime * result + ((emailVerificationToken == null) ? 0 : emailVerificationToken.hashCode());
		result = prime * result + ((encryptedPassword == null) ? 0 : encryptedPassword.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((tokenSecret == null) ? 0 : tokenSecret.hashCode());
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
		UserDTO other = (UserDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailVerificationStatus == null) {
			if (other.emailVerificationStatus != null)
				return false;
		} else if (!emailVerificationStatus.equals(other.emailVerificationStatus))
			return false;
		if (emailVerificationToken == null) {
			if (other.emailVerificationToken != null)
				return false;
		} else if (!emailVerificationToken.equals(other.emailVerificationToken))
			return false;
		if (encryptedPassword == null) {
			if (other.encryptedPassword != null)
				return false;
		} else if (!encryptedPassword.equals(other.encryptedPassword))
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		if (tokenSecret == null) {
			if (other.tokenSecret != null)
				return false;
		} else if (!tokenSecret.equals(other.tokenSecret))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", email="
				+ email + ", encryptedPassword=" + encryptedPassword + ", emailVerificationToken="
				+ emailVerificationToken + ", emailVerificationStatus=" + emailVerificationStatus + ", tokenSecret="
				+ tokenSecret + ", organization=" + organization + ", mobilePhone=" + mobilePhone + ", role=" + role
				+ ", permissions=" + permissions + "]";
	}
	public UserDTO(Long id, String publicId, String description, String createdBy, Date created, String modifiedBy,
			Date modified, Boolean deleted, String deletedBy, Boolean enabled, Long version, String firstName,
			String lastName, String password, String email, String encryptedPassword, String emailVerificationToken,
			Boolean emailVerificationStatus, String tokenSecret, String organization, String mobilePhone, RoleDTO role,
			Set<PermissionDTO> permissions) {
		super(id, publicId, description, createdBy, created, modifiedBy, modified, deleted, deletedBy, enabled,
				version);
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.encryptedPassword = encryptedPassword;
		this.emailVerificationToken = emailVerificationToken;
		this.emailVerificationStatus = emailVerificationStatus;
		this.tokenSecret = tokenSecret;
		this.organization = organization;
		this.mobilePhone = mobilePhone;
		this.role = role;
		this.permissions = permissions;
	}
	public UserDTO() {
		super();

	}
	public UserDTO(Long id, String publicId, String description, String createdBy, Date created, String modifiedBy,
			Date modified, Boolean deleted, String deletedBy, Boolean enabled, Long version) {
		super(id, publicId, description, createdBy, created, modifiedBy, modified, deleted, deletedBy, enabled, version);

	}
    
    

}
