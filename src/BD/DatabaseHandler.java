package BD;

import java.sql.*;

public class DatabaseHandler {
    Connection dbConnection;
    String name = "priveleges";

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
    public void fillInRoom(int value, int amount, String tools, String flour){
        String insert = "INSERT INTO rooms (value,ammount,tools,flour)"+" VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setInt(1,value);
            prSt.setInt(2,amount);
            prSt.setString(3, tools);
            prSt.setString(4,flour);

            prSt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void fillInStudents(String SNP, String birth_year, String gender, String adress, String group, String passport, String colonize_date){
        String insert = "INSERT INTO students (snp,birth_year,gender,adress,group,passport,colonize_date)"+" VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,SNP);
            prSt.setString(2,birth_year);
            prSt.setString(3,gender);
            prSt.setString(4,adress);
            prSt.setString(5,group);
            prSt.setString(6,passport);
            prSt.setString(7,colonize_date);

            prSt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public StringBuilder getInfoPriv(){
        ResultSet resultSet = null;
        StringBuilder str = new StringBuilder();
        String select = "SELECT * FROM priveleges";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resultSet = prSt.executeQuery();
            while (resultSet.next()){
                str.append(resultSet.getString("privelege_code")+" ");
                str.append(resultSet.getString("privelege_type")+" ");
                str.append(resultSet.getString("discount")+"\n");
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
                str.append(resultSet.getString("room_n")+" ");
                str.append(resultSet.getString("value")+" ");
                str.append(resultSet.getString("ammount")+" ");
                str.append(resultSet.getString("tools")+" ");
                str.append(resultSet.getString("flour")+"\n");
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
                str.append(resultSet.getString("student_code")+" ");
                str.append(resultSet.getString("snp")+" ");
                str.append(resultSet.getString("birth_year")+" ");
                str.append(resultSet.getString("gender")+" ");
                str.append(resultSet.getString("adress")+" ");
                str.append(resultSet.getString("group")+" ");
                str.append(resultSet.getString("privelege_code")+" ");
                str.append(resultSet.getString("passport")+" ");
                str.append(resultSet.getString("room")+" ");
                str.append(resultSet.getString("colonize_date")+"\n");
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return str;
    }

}
