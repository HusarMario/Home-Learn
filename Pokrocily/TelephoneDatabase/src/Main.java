import Commands.Commands;
import Contacts.Contact;
import Exceptions.BadMailFormatException;
import Exceptions.BadNumberFormatException;
import Exceptions.BadPhoneFormatException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

    	Commands commands = new Commands();
		Scanner scanner = new Scanner(System.in);
		boolean run = true;

		commands.loadContacts();
    	while(run) {
			commands.showCommands();

			try {
				switch (scanner.nextInt()) {
					case 0 -> {
						run = false;
					}
					case 1 -> {
						commands.printContacts();
					}
					case 2 -> {
						System.out.println("Vlozte hladany kontakt");
						commands.findContact(scanner.next());
					}
					case 3 -> {
						System.out.println("Vlozte novy kontakt vo formate:");
						System.out.println("Meno;Telefon;Mobil;E-mail");
						String input = scanner.next();

						String[] inputs = input.split(";");

						for(int i = 0; i < inputs.length; i++){
							if(inputs[i].startsWith(" ")){
								inputs[i] = inputs[i].replace(" ","");
							}
						}

						try {
							if(inputs.length == 4) {
								Contact contact = new Contact(inputs[0], inputs[1], inputs[2], inputs[3]);
								commands.addContact(contact);
							}
							if(inputs.length == 3) {
								Contact contact = new Contact(inputs[0], inputs[1], inputs[2], "");
								commands.addContact(contact);
							}
						} catch (BadPhoneFormatException | BadNumberFormatException | BadMailFormatException exception) {
							System.out.println(exception.getMessage());
							System.out.println();
						}
					}
					default -> throw new Exception("Vyber si z urcenych moznosti");
				}
			} catch (Exception  exception){
				exception.printStackTrace();
				scanner.nextLine();
			}
		}
    }



}
