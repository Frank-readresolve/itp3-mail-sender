DELETE FROM contact_roles;
DELETE FROM email_templates;

INSERT INTO contact_roles 
	(role_code, contact_role_name)
	VALUES 
	('OTHER','Other');
	
INSERT INTO email_templates
	(template_identifier, template_subject, template_body)
	VALUES
	('CUSTOMER', 'Welcome onboard ${cDear ${contact_firstname} \n\nYour API key is: ${api_key} \n\nEnjoy using our services!\nMailSenderAPI team\n\nThis is an automatic mail, please to not reply.ustomer_name}', ''),
	('FREE_MAIL', '[MailSenderAPI] - ${client_subject}', '${client_body} \n\n*****************************\n\nThis is a free limited and anonymous mail\nMailSenderAPI team\n\nThis is an automatic mail, please to not reply.');
