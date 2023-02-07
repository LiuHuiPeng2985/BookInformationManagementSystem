package controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateCodeController",urlPatterns = "/createCode")
public class CreateCodeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建验证码
        ValidateCode validateCode = new ValidateCode(200,30,4,20);
        //拿到输入的字符串
        String codes = validateCode.getCode();
        //把验证码存到session中
        HttpSession session = req.getSession();
        session.setAttribute("codes",codes);
        System.out.println(codes);
        validateCode.write(resp.getOutputStream());
    }
}
