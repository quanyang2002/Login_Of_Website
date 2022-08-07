package ResponseToIndex;

import DataBaseQueryData.getDatabaseData;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseToWeb extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

        // 从请求域中取出数据 得到用户名和密码
        String username = (String)req.getAttribute("username");
        String password = (String)req.getAttribute("password");

        // 通过用户名和密码新建对象
        getDatabaseData getdbd = new getDatabaseData(username,password);
        // 设置数据库连接的参数
        String url = "jdbc:mysql://192.168.232.146:3306/users";
        String user = "root";
        String passwd = "Password123$";
        // 设置状态码 true:表示登录成功 false:表示登录失败
        // 这部分有错误：servlet抛出异常服务器报错，没有找到适合的异常处理办法
        // 该异常来自于jdbc(必须抛出异常)
        Boolean state = false;
        try {
            state = getdbd.GetData(url,user,passwd);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            System.out.println(state);
        }
        // 设置要向页面响应的内容
        String respcontent;
        if(state){
            respcontent = "login sucess!";
        }else{
            respcontent = "failure login!";
        }
        // 获取 向页面响应对象
        PrintWriter writer = resp.getWriter();
        // 响应内容
        writer.write(respcontent);
        // 关闭资源
        writer.close();
    }



}
