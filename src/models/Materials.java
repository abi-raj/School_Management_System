package models;

public class Materials {
    private String teacher_id;
    private String materialText;
    private String std;

    public Materials(String teacher_id, String materialText, String std) {
        this.teacher_id = teacher_id;
        this.materialText = materialText;
        this.std = std;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getMaterialText() {
        return materialText;
    }

    public void setMaterialText(String materialText) {
        this.materialText = materialText;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }


}
