package service.security.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import service.security.auth.entity.RoleEntity;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
	
	RoleEntity findByRole (String role);
	RoleEntity findByRolePublicId(String publicId);

}
