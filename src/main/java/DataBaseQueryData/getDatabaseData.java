package DataBaseQueryData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getDatabaseData {

    public String name;
    public String pwd;
    public getDatabaseData(String name,String pwd){

        this.name = name;
        this.pwd = pwd;
    }

    public boolean GetData(String url,String user,String passwd) throws Exception{

        // 获取数据库连接对象
        Connection connection = DriverManager.getConnection(url, user, passwd);
        // 获取sql语句预执行对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from accounts where username=? and password=?;");
        // 设置预执行sql中的参数值
        preparedStatement.setString(1,this.name);
        preparedStatement.setString(2,this.pwd);
        // 执行sql语句 返回结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        // 根据结果集中是否存在数据 判断能否登录成功
        if(resultSet.next()){
            return true;
        }else{
            return false;
        }

    }

}
