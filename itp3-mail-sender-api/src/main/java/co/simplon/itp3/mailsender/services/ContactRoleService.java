package co.simplon.itp3.mailsender.services;

import co.simplon.itp3.mailsender.dtos.CreateContactRoleDto;

public interface ContactRoleService {

    void create(CreateContactRoleDto inputs);

    public boolean roleCodeValueExists(String roleCode);

    public boolean contactRoleNameValueExists(
	    String contactRoleName);

}
