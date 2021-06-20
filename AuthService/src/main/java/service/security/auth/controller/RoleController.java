package service.security.auth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.security.auth.dto.RoleDTO;
import service.security.auth.repository.RoleRepository;
import service.security.auth.request.PermissionsForRoleRequest;
import service.security.auth.request.RoleRequest;
import service.security.auth.response.RoleResponse;
import service.security.auth.service.RoleService;

@RestController
@RequestMapping("roles")
@PreAuthorize("denyAll")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	RoleRepository roleRepository;
	
	// Get Role List
	@PreAuthorize("hasAuthority('PERM_ROLE_LIST_GET')")
	@GetMapping(path ="/" , produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })	
	public Iterable<RoleResponse> getRoleList() {
		Iterable<RoleDTO> roleDTOS = roleService.getRoleList();
		List<RoleResponse> listRoles = new ArrayList<RoleResponse>();
		for (RoleDTO roleDTO : roleDTOS) {
			RoleResponse returnValue = new RoleResponse();
			BeanUtils.copyProperties(roleDTO, returnValue);
			listRoles.add(returnValue);
		}
		
		return listRoles;
	}	
	
	// Create new Role
	@PreAuthorize("hasAuthority('PERM_CREATE_ROLE_POST')")
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public RoleResponse createRole(@RequestBody RoleRequest role ) throws Exception {
		
		RoleResponse returnValue = new RoleResponse();
		RoleDTO roleDTO = new RoleDTO();		
		BeanUtils.copyProperties(role, roleDTO);		
		RoleDTO createRole  = roleService.createRole(roleDTO);		
		BeanUtils.copyProperties(createRole, returnValue);		
		return returnValue;
	}
	
	// Update Role Info
	@PreAuthorize("hasAuthority('PERM_UPDATE_ROLE_PUT')")
	@PutMapping(path ="/{id}",
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public RoleResponse updateRole(@RequestBody RoleRequest role, @PathVariable String id ) {
		RoleResponse returnValue = new RoleResponse();
		RoleDTO updateRole = roleService.updateRole(role, id);
		BeanUtils.copyProperties(updateRole, returnValue);
		return returnValue;
	}
	
	//Update Role Permissions
	@PreAuthorize("hasAuthority('PERM_UPDATE_ROLE_PERMISSIONS_PUT')")
	@PutMapping(path ="/permissions/{id}",
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public RoleResponse updateRole(@RequestBody PermissionsForRoleRequest role, @PathVariable String id ) {
		RoleResponse returnValue = new RoleResponse();
		RoleDTO updateRole = roleService.updateRolePermissions(role, id);
		BeanUtils.copyProperties(updateRole, returnValue);
		return returnValue;
	}
	
	//Delete Role
	@PreAuthorize("hasAuthority('PERM_DELETE_ROLE_DELETE')")
	@DeleteMapping(path ="/{id}")
	public String deleteRole(@PathVariable String id) {
		roleService.deleteRole(id);
		return "Delete Role";
	}
	

}
