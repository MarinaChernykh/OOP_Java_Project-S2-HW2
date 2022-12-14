package ru.gb.oseminar.controller;

import ru.gb.oseminar.data.Student;
import ru.gb.oseminar.data.StudyGroup;
import ru.gb.oseminar.data.Teacher;
import ru.gb.oseminar.data.User;
import ru.gb.oseminar.service.StudyGroupService;
import ru.gb.oseminar.service.UserService;
import ru.gb.oseminar.view.StudentView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final UserService userService = new UserService();
    private final StudyGroupService studyGroupService = new StudyGroupService();
    private final StudentView studentView = new StudentView();

    public void createUser(String firstName, String lastName, String patronymic) {
        userService.createUser(firstName, lastName, patronymic);
        List<User> students = userService.getAll();
        studentView.sendOnConsole(students);
    }

    public void createStudyGroup() {
        List<User> users = this.userService.getAll();
        Teacher teacher = null;
        List<Student> students = new ArrayList<>();

        for (User user : users) {
            if (user instanceof Teacher) {
                teacher = (Teacher) user;
            } else if (user instanceof Student) {
                students.add((Student) user);
            }
        }
        this.studyGroupService.createStudyGroup(teacher, students);
        StudyGroup studyGroup = this.studyGroupService.getStudyGroup();
    }
}
