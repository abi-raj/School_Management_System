package models;

public class Marks {

    private String student_id;
    private String exam_title;
    private String sub1;
    private String sub2;
    private String sub3;
    private String grade_type;

    public Marks(String student_id, String exam_title, String sub1, String sub2, String sub3, String grade_type) {
        this.student_id = student_id;
        this.exam_title = exam_title;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.grade_type = this.calcGrade();
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getExam_title() {
        return exam_title;
    }

    public void setExam_title(String exam_title) {
        this.exam_title = exam_title;
    }

    public String getSub1() {
        return sub1;
    }

    public void setSub1(String sub1) {
        this.sub1 = sub1;
    }

    public String getSub2() {
        return sub2;
    }

    public void setSub2(String sub2) {
        this.sub2 = sub2;
    }

    public String getSub3() {
        return sub3;
    }

    public void setSub3(String sub3) {
        this.sub3 = sub3;
    }

    public String getGrade_type() {
        return calcGrade();
    }

    public void setGrade_type(String grade_type) {
        this.grade_type = grade_type;
    }

    public String calcGrade() {
        int total = Integer.parseInt(this.sub1) + Integer.parseInt(this.sub2) + Integer.parseInt(this.sub3);
        String result = "F";
        int res = total / 3;
        if (res >= 90) {
            result = "S";
        } else if (res >= 80) {
            result = "A";
        } else if (res >= 70) {
            result = "B";
        } else if (res >= 50) {
            result = "C";
        }

        return result;
    }
}
