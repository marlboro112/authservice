package service.security.auth.service;

import org.springframework.stereotype.Service;

import service.security.auth.dto.RoleDTO;
import service.security.auth.request.PermissionsForRoleRequest;
import service.security.auth.request.RoleRequest;

@Service
public class RoleServiceImpl implements RoleService {

	@Override
	public RoleDTO getRole(String role) {

		return null;
	}

	@Override
	public Iterable<RoleDTO> getRoleList() {

		return null;
	}

	@Override
	public RoleDTO createRole(RoleDTO role) {

		return null;
	}

	@Override
	public RoleDTO updateRole(RoleRequest role, String publicId) {

		return null;
	}

	@Override
	public RoleDTO updateRolePermissions(PermissionsForRoleRequest role, String publicId) {

		return null;
	}

	@Override
	public void deleteRole(String publicId) {


	}

}
