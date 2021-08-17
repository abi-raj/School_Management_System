package models;

public class Attendance {


    private String student_id;
    private String std;
    private String date;

    public Attendance(String student_id, String std, String date) {
        this.student_id = student_id;
        this.std = std;
        this.date = date;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
