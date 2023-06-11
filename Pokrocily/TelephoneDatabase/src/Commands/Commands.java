package Commands;

import Contacts.Contact;
import Exceptions.BadContactFormatException;
import Exceptions.BadMailFormatException;
import Exceptions.BadNumberFormatException;
import Exceptions.BadPhoneFormatException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Commands implements CommandsInterface{

    Path registerPath = Paths.get("C:\\Users\\user\\OneDrive\\Počítač\\Learn2Code\\Java\\Pokrocily\\TelephoneDatabase\\src\\Register.txt");
    ArrayList<Contact> contacts = new ArrayList<>();
    int numberOfContacts = 0;

    @Override
    public void showCommands() {
        System.out.println("1 : Show contacts");
        System.out.println("2 : Find contact -> Enter substring of its name");
        System.out.println("3 : Add contact -> Enter : Name,number,phone,email (Must include name and 1 mobile contact)");
        System.out.println("0 : Exit");
    }

    public void loadContacts() throws Exception{
        String record;
        try(Scanner scanner = new Scanner(Files.newBufferedReader(registerPath))) {
            scanner.nextLine();
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNextLine()){
                record = scanner.nextLine();
                try {
                    numberOfContacts = numberOfContacts + 1;
                    checkRecord(record);
                    addRecordToContacts(record);
                } catch (BadContactFormatException | BadNumberFormatException |
                        BadMailFormatException | BadPhoneFormatException exception){
                    numberOfContacts = numberOfContacts - 1;
                    exception.printStackTrace();
                }
            }
        } catch (IOException | InputMismatchException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
        numberOfContacts = numberOfContacts + 1;

        try (BufferedWriter writer = Files.newBufferedWriter(registerPath)){
            writer.write("MY PHONE NUMBERS\n");
            writer.write(numberOfContacts+"\n");
            writer.write("Meno; Telefon; Mobil; Email");

            for(Contact record : contacts) {
                writer.write("\n" + record.getName() + "; " + record.getNumber() + "; " + record.getPhone() + "; " + record.getMail());
            }

        } catch (IOException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void printContacts() {
        for(Contact record : contacts){
            record.showContact();
        }
    }

    @Override
    public void findContact(String name) {
        for(Contact record : contacts){
            if(record.getName().contains(name))
                record.showContact();
        }
    }

    private void checkRecord(String record) throws Exception{
        if(!record.matches(".+; .*; .+;( .*|)|.+; .+; .*;( .*|)")){
            throw new BadContactFormatException("Zly vstup zo suboru");
        }
    }

    private void addRecordToContacts(String record) throws Exception{
        String[] records;
        records = record.split(";");
        for(int i = 0; i < records.length; i++){
            if(records[i].startsWith(" ")){
                records[i] = records[i].replace(" ","");
            }
        }
        Contact contact;
        if(records.length == 3){
            contact = new Contact(records[0], records[1], records[2], "");
        }
        else {
            contact = new Contact(records[0], records[1], records[2], records[3]);
        }
        contacts.add(contact);

    }
}
