package timetable.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.*;
import timetable.Main;
import timetable.dto.Course;

public class CodeComboController implements ActionListener {

    JComboBox<String> codeCombo, typeCombo;

    public CodeComboController(JComboBox<String> cc, JComboBox<String> tc) {
        codeCombo = cc;
        typeCombo = tc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        typeCombo.removeAllItems();
        Course[] courses = Main.courseDAO.getCourses();

        // update type combo
        ArrayList<String> selected = new ArrayList<>();
        Arrays.sort(courses, Comparator.comparing(Course::getTypes));
        for (Course c : courses) {
            if (codeCombo.getSelectedItem() != null
                    && c.getCode().equals(codeCombo.getSelectedItem().toString())
                    && !selected.contains(c.getTypes())) {
                typeCombo.addItem(c.getTypes());
                selected.add(c.getTypes());
            }
        }
    }
}
