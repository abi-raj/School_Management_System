package models;

public class Marks {
    private String student_id;
    private  String exam_title;
    private  int sub1;
    private  int sub2;
    private  int sub3;

    public String getStudent_id() {
        return student_id;
    }

    public int getSub3() {
        return sub3;
    }

    public void setSub3(int sub3) {
        this.sub3 = sub3;
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

    public int getSub1() {
        return sub1;
    }

    public void setSub1(int sub1) {
        this.sub1 = sub1;
    }

    public int getSub2() {
        return sub2;
    }

    public void setSub2(int sub2) {
        this.sub2 = sub2;
    }

    public Marks(String id,String exam_title,int m1,int m2,int m3){
        this.student_id=id;
        this.exam_title=exam_title;
        this.sub1=m1;
        this.sub2=m2;
        this.sub3=m3;

    }
}
