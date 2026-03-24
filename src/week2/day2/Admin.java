package week2.day2;

class Admin extends UserAccount {
    Admin(int id, String name, String pass) {
        super(id, name, pass, UserType.ADMIN);
    }
}



