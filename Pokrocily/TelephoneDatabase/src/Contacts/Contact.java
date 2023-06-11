package Contacts;

import Exceptions.BadMailFormatException;
import Exceptions.BadNumberFormatException;
import Exceptions.BadPhoneFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private final String name;
    private final String number;
    private final String phone;
    private final String mail;

    public Contact(String name, String number, String phone, String mail) throws Exception{
        this.name = name;

        Pattern numberRegex = Pattern.compile("0[0-9]{2}/[0-9]{7}|");
        if(checkPatterns(number, numberRegex))
            this.number = number;
        else
            throw new BadNumberFormatException("Zly format number");

        Pattern phoneRegex = Pattern.compile("09[0-9]{8}|");
        if(checkPatterns(phone, phoneRegex))
            this.phone = phone;
        else
            throw new BadPhoneFormatException("Zly format phone");

        Pattern mailRegex = Pattern.compile("[\\S[^@]]+@[\\w[^@]]+\\.[a-z]+|");
        if(checkPatterns(mail, mailRegex))
            this.mail = mail;
        else
            throw new BadMailFormatException("Zly format email");
    }

    public void showContact(){
        System.out.println("Name : "+name);
        System.out.println("Phone : "+phone);
        System.out.println("Number : "+number);
        System.out.println("E-mail : "+mail);
        System.out.println();
    }

    private boolean checkPatterns(String check,Pattern pattern){
        Matcher matcher = pattern.matcher(check);
        return matcher.matches();
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }
}
