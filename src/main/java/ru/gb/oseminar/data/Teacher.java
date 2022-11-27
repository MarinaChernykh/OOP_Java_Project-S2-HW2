package ru.gb.oseminar.data;

public class Teacher extends User{
    private Long teacherID;

    public Teacher(String firstName, String lastName, String patronymic, Long teacherID) {
        super(firstName, lastName, patronymic);
        this.teacherID = teacherID;
    }

    public Long getStudentID() {
        return teacherID;
    }

    public void setStudentID(Long studentID) {
        this.teacherID = studentID;
    }
}
