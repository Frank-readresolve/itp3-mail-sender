package co.simplon.itp3.mailsender.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.itp3.mailsender.dtos.CreateContactRoleDto;
import co.simplon.itp3.mailsender.entities.ContactRole;
import co.simplon.itp3.mailsender.repositories.ContactRoleRepository;

@Service
@Transactional(readOnly = true)
public class ContactRoleServiceImpl
	implements ContactRoleService {

    private final ContactRoleRepository contactRolesRepo;

    public ContactRoleServiceImpl(
	    ContactRoleRepository contactRolesRepo) {
	this.contactRolesRepo = contactRolesRepo;
    }

    @Transactional
    @Override
    public void create(CreateContactRoleDto inputs) {
	ContactRole contactRole = new ContactRole();
	contactRole.setContactName(inputs.getContactName());
	contactRole.setContactRole(inputs.getContactRole());
	this.contactRolesRepo.save(contactRole);
    }

}
