package Test;

import DataBaseQueryData.getDatabaseData;

public class testGetDatabaseData {
    public static void main(String[] args) {

        getDatabaseData getdbd = new getDatabaseData("zhangsan","zs123");
        String url = "jdbc:mysql://192.168.232.146:3306/users";
        String user = "root";
        String passwd = "Password123$";
        boolean stat = false;
        try {
            stat = getdbd.GetData(url,user,passwd);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            System.out.println(stat);
        }
        if (stat){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
