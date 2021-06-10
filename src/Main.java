import GUI.*;
import Interface.FormManager;

import javax.swing.*;

public class Main implements FormManager {
    private final Menu menu;
    private final Privileges privileges;
    private final Rooms rooms;
    private final Students students;
    private final SQL sql;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    public Main() {
        menu = new Menu(this);
        menu.setVisible(true);
        privileges = new Privileges(this);
        rooms = new Rooms(this);
        students = new Students(this);
        sql = new SQL(this);
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

    @Override
    public void swapSQL() {
        menu.setVisible(!menu.isVisible());
        sql.setVisible(!sql.isVisible());
    }
}