package service.security.auth.service;

import org.springframework.stereotype.Service;

import service.security.auth.dto.RoleDTO;
import service.security.auth.request.PermissionsForRoleRequest;
import service.security.auth.request.RoleRequest;

@Service
public class RoleServiceImpl implements RoleService {

	@Override
	public RoleDTO getRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<RoleDTO> getRoleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDTO createRole(RoleDTO role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDTO updateRole(RoleRequest role, String publicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDTO updateRolePermissions(PermissionsForRoleRequest role, String publicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRole(String publicId) {
		// TODO Auto-generated method stub

	}

}
