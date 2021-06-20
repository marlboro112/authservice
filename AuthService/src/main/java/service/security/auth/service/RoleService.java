package service.security.auth.service;

import service.security.auth.dto.RoleDTO;
import service.security.auth.request.PermissionsForRoleRequest;
import service.security.auth.request.RoleRequest;

public interface RoleService {

	RoleDTO getRole(String role);
	Iterable<RoleDTO> getRoleList();
	RoleDTO createRole(RoleDTO role);
	RoleDTO updateRole(RoleRequest role, String publicId);
	RoleDTO updateRolePermissions(PermissionsForRoleRequest role, String publicId);
	void deleteRole(String publicId);
}
