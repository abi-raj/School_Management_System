package models;

public class Forum {
    private String student_id;
    private String description;
    private String response;

    public Forum(String student_id, String description, String response) {
        this.student_id = student_id;
        this.description = description;
        this.response = response;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
