package models;

public class Teacher {
    private String teacher_id;
    private String password;
    private String name;
    private String email;
    private int experience;
    private String phone;
    private int salary;

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public Teacher(String id, String pwd, String name, String email, int experience, String phone, int salary){
        this.teacher_id=id;
        this.password=pwd;
        this.name=name;
        this.email=email;
        this.experience=experience;
        this.phone=phone;
        this.salary=salary;
    }
}
