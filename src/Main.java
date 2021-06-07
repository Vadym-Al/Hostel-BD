import GUI.Menu;
import GUI.Privileges;
import GUI.Rooms;
import GUI.Students;
import Interface.FormManager;

import javax.swing.*;

public class Main implements FormManager {
    private final Menu menu;
    private final Privileges privileges;
    private final Rooms rooms;
    private Students students;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public Main() {
        menu = new Menu(this);
        menu.setVisible(true);
        privileges = new Privileges(this);
        rooms = new Rooms(this);
        students = new Students(this);
    }

    @Override
    public void swapPrivileges() {
        menu.setVisible(!menu.isVisible());
        privileges.setVisible(!privileges.isVisible());
    }

    @Override
    public void swapRooms() {
        menu.setVisible(!menu.isVisible());
        rooms.setVisible(!rooms.isVisible());
    }

    @Override
    public void swapStudents() {
        menu.setVisible(!menu.isVisible());
        students.setVisible(!students.isVisible());
    }
}