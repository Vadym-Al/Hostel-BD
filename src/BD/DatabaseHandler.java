package BD;

import java.sql.*;

public class DatabaseHandler {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://localhost:3306/hostel";



        dbConnection = DriverManager.getConnection(connectionString, "root","2209856456123");
        return dbConnection;
    }
    public void fillInPrivilege(String type, int discount){
        String insert = "INSERT INTO priveleges (privelege_type,discount)"+" VALUES(?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,type);
            prSt.setInt(2,discount);

            prSt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void fillInRoom(int number, int value, int amount, String tools, String flour){
        String insert = "INSERT INTO rooms (room_n,value,ammount,tools,flour)"+" VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1,number);
            prSt.setInt(2,value);
            prSt.setInt(3,amount);
            prSt.setString(4, tools);
            prSt.setString(5,flour);

            prSt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void fillInStudents(String SNP, String birth_year, String gender, String adress, String group, int code, String passport, int room, String colonize_date){
        String insert = "INSERT INTO students (snp,birth_year,gender,adress,groupe,privelege_code,passport,room,colonize_date)"+" VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,SNP);
            prSt.setString(2,birth_year);
            prSt.setString(3,gender);
            prSt.setString(4,adress);
            prSt.setString(5,group);
            prSt.setInt(6,code);
            prSt.setString(7,passport);
            prSt.setInt(8,room);
            prSt.setString(9,colonize_date);

            prSt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public StringBuilder getInfoPriv(){
        ResultSet resultSet = null;
        StringBuilder str = new StringBuilder();
        String select = "SELECT * FROM privileges";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resultSet = prSt.executeQuery();
            while (resultSet.next()){
                str.append(resultSet.getString("privelege_code")).append(" ");
                str.append(resultSet.getString("privelege_type")).append(" ");
                str.append(resultSet.getString("discount")).append("\n");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return str;
    }
    public StringBuilder getInfoRoom(){
        ResultSet resultSet = null;
        String select = "SELECT * FROM rooms";
        StringBuilder str = new StringBuilder();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resultSet = prSt.executeQuery();
            while (resultSet.next()){
                str.append(resultSet.getString("room_n")).append(" ");
                str.append(resultSet.getString("value")).append(" ");
                str.append(resultSet.getString("ammount")).append(" ");
                str.append(resultSet.getString("tools")).append(" ");
                str.append(resultSet.getString("flour")).append("\n");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return str;
    }
    public StringBuilder getInfoStudents(){
        ResultSet resultSet = null;
        String select = "SELECT * FROM students";
        StringBuilder str = new StringBuilder();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resultSet = prSt.executeQuery();
            while (resultSet.next()){
                str.append(resultSet.getString("student_code")).append(" ");
                str.append(resultSet.getString("snp")).append(" ");
                str.append(resultSet.getString("birth_year")).append(" ");
                str.append(resultSet.getString("gender")).append(" ");
                str.append(resultSet.getString("adress")).append(" ");
                str.append(resultSet.getString("groupe")).append(" ");
                str.append(resultSet.getString("privelege_code")).append(" ");
                str.append(resultSet.getString("passport")).append(" ");
                str.append(resultSet.getString("room")).append(" ");
                str.append(resultSet.getString("colonize_date")).append("\n");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return str;
    }
    public void ClearTable(String table_name){
        String delete = "TRUNCATE TABLE "+table_name;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(delete);

            prSt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void SQL(String insert){
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
