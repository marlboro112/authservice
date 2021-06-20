package service.security.auth.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "service.auth")
@Configuration
public class SecurityConstants {

	private int expirationTime;
	private String tokenPrefix;
	private int tokenSecretIdLength;
	private String headerString;
	private int generateUserIdLength;
	private int generateRoleIdLength;
	private int generateEmailVerificationTokenLength;
	
	
	public int getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(int expirationTime) {
		this.expirationTime = expirationTime;
	}
	public String getTokenPrefix() {
		return tokenPrefix;
	}
	public void setTokenPrefix(String tokenPrefix) {
		this.tokenPrefix = tokenPrefix;
	}
	public int getTokenSecretIdLength() {
		return tokenSecretIdLength;
	}
	public void setTokenSecretIdLength(int tokenSecretIdLength) {
		this.tokenSecretIdLength = tokenSecretIdLength;
	}
	public String getHeaderString() {
		return headerString;
	}
	public void setHeaderString(String headerString) {
		this.headerString = headerString;
	}
	public int getGenerateUserIdLength() {
		return generateUserIdLength;
	}
	public void setGenerateUserIdLength(int generateUserIdLength) {
		this.generateUserIdLength = generateUserIdLength;
	}
	public int getGenerateRoleIdLength() {
		return generateRoleIdLength;
	}
	public void setGenerateRoleIdLength(int generateRoleIdLength) {
		this.generateRoleIdLength = generateRoleIdLength;
	}
	public int getGenerateEmailVerificationTokenLength() {
		return generateEmailVerificationTokenLength;
	}
	public void setGenerateEmailVerificationTokenLength(int generateEmailVerificationTokenLength) {
		this.generateEmailVerificationTokenLength = generateEmailVerificationTokenLength;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + expirationTime;
		result = prime * result + generateEmailVerificationTokenLength;
		result = prime * result + generateRoleIdLength;
		result = prime * result + generateUserIdLength;
		result = prime * result + ((headerString == null) ? 0 : headerString.hashCode());
		result = prime * result + ((tokenPrefix == null) ? 0 : tokenPrefix.hashCode());
		result = prime * result + tokenSecretIdLength;
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
		SecurityConstants other = (SecurityConstants) obj;
		if (expirationTime != other.expirationTime)
			return false;
		if (generateEmailVerificationTokenLength != other.generateEmailVerificationTokenLength)
			return false;
		if (generateRoleIdLength != other.generateRoleIdLength)
			return false;
		if (generateUserIdLength != other.generateUserIdLength)
			return false;
		if (headerString == null) {
			if (other.headerString != null)
				return false;
		} else if (!headerString.equals(other.headerString))
			return false;
		if (tokenPrefix == null) {
			if (other.tokenPrefix != null)
				return false;
		} else if (!tokenPrefix.equals(other.tokenPrefix))
			return false;
		if (tokenSecretIdLength != other.tokenSecretIdLength)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SecurityConstants [expitarionTime=" + expirationTime + ", tokenPrefix=" + tokenPrefix
				+ ", tokenSecretIdLength=" + tokenSecretIdLength + ", headerString=" + headerString
				+ ", generateUserIdLength=" + generateUserIdLength + ", generateRoleIdLength=" + generateRoleIdLength
				+ ", generateEmailVerificationTokenLength=" + generateEmailVerificationTokenLength + "]";
	}
	public SecurityConstants(int expitarionTime, String tokenPrefix, int tokenSecretIdLength, String headerString,
			int generateUserIdLength, int generateRoleIdLength, int generateEmailVerificationTokenLength) {
		super();
		this.expirationTime = expitarionTime;
		this.tokenPrefix = tokenPrefix;
		this.tokenSecretIdLength = tokenSecretIdLength;
		this.headerString = headerString;
		this.generateUserIdLength = generateUserIdLength;
		this.generateRoleIdLength = generateRoleIdLength;
		this.generateEmailVerificationTokenLength = generateEmailVerificationTokenLength;
	}
	public SecurityConstants() {
		super();
	}
	
	
	

}
