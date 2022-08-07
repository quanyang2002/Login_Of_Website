package LoGinDataPreprocessing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class getRequestData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get请求将请求体内容串在请求url的后面 不安全
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 不论是get请求还是post请求 都执行post请求业务逻辑

        // 解决用户名中文乱码问题(编解码不一致 统一即可)
        req.setCharacterEncoding("UTF-8");

        // 测试
        //System.out.println("Post请求逻辑执行了");

        // 获取请求体数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 测试是否获取成功
        // System.out.println("账号：" + username + "密码：" + password);

        // 将获取的用户信息存入Request域中
        req.setAttribute("username",username);
        req.setAttribute("password",password);

        // 请求转发给数据库数据提取Servlet
        // 获取转发器对象
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/responseToWeb");
        requestDispatcher.forward(req,resp);


    }
}
