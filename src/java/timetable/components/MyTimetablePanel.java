package timetable.components;

import javax.swing.*;
import java.awt.*;
import timetable.Main;

public class MyTimetablePanel extends JPanel {

    public MyTimetablePanel() {
        super();
        setLayout(new BorderLayout());
        ViewTimetable viewTimetable = new ViewTimetable();
        viewTimetable.update(Main.timetableDAO.getTimetable());
        add(viewTimetable, BorderLayout.CENTER);
    }
}
