package com.zy.qrcode.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.qrcode.web.service.QrCodeService;

@WebServlet("/GetQrCode")
public class QrCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String str = request.getParameter("text");//获取二维码内容
		String author=request.getParameter("author");
		if(!author.equals("张闫")){
			str = new String(str.getBytes("ISO8859-1"),"UTF-8");//可能存在的get请求中文乱码问题
		}
		String down = request.getParameter("down");
		
		QrCodeService service=new QrCodeService();
		try {
			service.getQrCode(str,author,down,response);
		} catch (Exception e) {
			response.sendRedirect("/QrCode");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
