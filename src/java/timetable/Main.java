package timetable;

import timetable.screens.MainMenuFrame;

import javax.ejb.EJB;
import javax.swing.*;

public class Main {

    @EJB
    public static CourseBeanRemote courseDAO;

    @EJB
    public static TimetableBeanRemote timetableDAO;

    private static JFrame currentFrame;

    public static void navigate(JFrame frame) {
        if (currentFrame != null) {
            currentFrame.setVisible(false);
        }
        currentFrame = frame;
        currentFrame.setVisible(true);
    }

    public static void main(String[] args) {
        navigate(new MainMenuFrame());
    }
}
