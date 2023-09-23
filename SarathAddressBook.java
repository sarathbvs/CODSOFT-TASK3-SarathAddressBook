import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ContactDetails {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public ContactDetails(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email Address: " + emailAddress;
    }
}

class AddressBook {
    private List<ContactDetails> connections;

    public AddressBook() {
        connections = new ArrayList<>();
    }

    public void addContact(ContactDetails contact) {
        connections.add(contact);
    }

    public void removeContact(String name) {
        connections.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
    }

    public ContactDetails searchContact(String name) {
        for (ContactDetails contact : connections) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void displayAllContacts() {
        for (ContactDetails contact : connections) {
            System.out.println(contact);
        }
    }
}

public class SarathAddressBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        int choice;
        do {
            System.out.println("Sarath's-Address Book System Menu");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search for Contact");
            System.out.println("4. Display All Connections");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email Address: ");
                    String emailAddress = scanner.nextLine();

                    if (!name.isEmpty() && !phoneNumber.isEmpty() && !emailAddress.isEmpty()) {
                        ContactDetails contact = new ContactDetails(name, phoneNumber, emailAddress);
                        addressBook.addContact(contact);
                        System.out.println("Contact added successfully!");
                    } else {
                        System.out.println("Error: Name, Phone Number, and Email Address cannot be empty.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Name of the contact to remove: ");
                    String nameToRemove = scanner.nextLine();
                    addressBook.removeContact(nameToRemove);
                    System.out.println("Contact removed successfully!");
                    break;

                case 3:
                    System.out.print("Enter Name of the contact to search: ");
                    String nameToSearch = scanner.nextLine();
                    ContactDetails searchedContact = addressBook.searchContact(nameToSearch);
                    if (searchedContact != null) {
                        System.out.println("Contact found: " + searchedContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    addressBook.displayAllContacts();
                    break;

                case 5:
                    System.out.println("Exiting the operation.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
