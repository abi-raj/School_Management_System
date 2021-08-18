package models;

public class Student {
    public Student(String id, String password, String name, String std, String email, String gender, String dob, String phone, int fees) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.std = std;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.fees = fees;
    }


    public String getId() {
        return id;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }


    private  String id;
    private String password;
    private String name;
    private String std;
    private String email;
    private String gender;
    private String dob;
    private String phone;
    private int fees;

}
