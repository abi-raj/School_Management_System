package models;

public class Leave {
    private String student_id;
    private String date;
    private String reason;
    private String status;

    public Leave(String student_id, String date, String reason, String status) {
        this.student_id = student_id;
        this.date = date;
        this.reason = reason;
        this.status = status;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
