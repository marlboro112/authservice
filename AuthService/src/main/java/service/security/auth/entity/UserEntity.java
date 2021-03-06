package service.security.auth.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "USERS")
public class UserEntity extends BaseEntity implements UserDetails {

	private static final long serialVersionUID = -2772425305600798219L;
	
   
	    @Column(name = "firstName", length = 30,nullable = false)
		private String firstName;
	    
	    @Column(name = "lastName", length = 30,nullable = false)
		private String lastName;
	    
	    @Column(name = "email", length = 100,nullable = false,unique = true)
		private String email;
	    
	    @Column(name = "encryptedPassword", length = 255,nullable = false)
		private String encryptedPassword;
	    
	    @Column(name = "tokenSecret", length = 255,nullable = false,unique = true)
	    private String tokenSecret;
	    
	    @Column(name = "organization", length = 150,nullable = false)
	    private String organization;
	    
	    @Column(name = "mobilePhone", length = 15,nullable = false)
	    private String mobilePhone;

		@Column(name = "emailVerificationToken", length = 255,nullable = false,unique = true)
		private String emailVerificationToken;
	    
	    @Column(name = "emailVerificationStatus", length = 10,nullable = false, columnDefinition = "BOOLEAN")
		private Boolean emailVerificationStatus = false;
	    
	    @OneToOne(fetch = FetchType.EAGER)  
	    @JoinTable(name = "user_roles",  
	        joinColumns        = {@JoinColumn(name = "user_id", referencedColumnName = "id")},  
	        inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}  
	    )
	    private RoleEntity role;
	    
	    
		@ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "user_permissions",
	        joinColumns        = { @JoinColumn(name = "user_id",       referencedColumnName = "id") },
	        inverseJoinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "id") }
	    ) 
	    private Set<PermissionEntity> permissions;
	       

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

		public String getEncryptedPassword() {
			return encryptedPassword;
		}

		public void setEncryptedPassword(String encryptedPassword) {
			this.encryptedPassword = encryptedPassword;
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

		public RoleEntity getRole() {
			return role;
		}

		public void setRole(RoleEntity role) {
			this.role = role;
		}

		@Transient
		public Set<PermissionEntity> getPermissions() {
			Set<PermissionEntity> perms = new HashSet<PermissionEntity>();
			 perms.addAll(role.getPermissions()); 
			 perms.addAll(permissions);
			return perms;
		}

		public void setPermissions(Set<PermissionEntity> permissions) {
			this.permissions = permissions;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
			Set<PermissionEntity> perms = getPermissions();
			for (PermissionEntity perm :perms) {
				authorities.add(new SimpleGrantedAuthority(perm.getPermission()));
			}
			return authorities;
		}

		@Override
		public String getPassword() {

			return null;
		}

		@Override
		public String getUsername() {

			return null;
		}

		@Override
		public boolean isAccountNonExpired() {

			return false;
		}

		@Override
		public boolean isAccountNonLocked() {

			return false;
		}

		@Override
		public boolean isCredentialsNonExpired() {

			return false;
		}

		@Override
		public boolean isEnabled() {

			return false;
		}
		
		

}
