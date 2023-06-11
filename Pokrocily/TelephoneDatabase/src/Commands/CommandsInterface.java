package Commands;

import Contacts.Contact;

public interface CommandsInterface {
    void showCommands();
    void loadContacts() throws Exception;
    void addContact(Contact contact);
    void findContact(String name);
    void printContacts();
}
