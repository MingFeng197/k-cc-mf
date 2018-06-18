package com.zy.qrcode.web.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

public class QrCodeService {

	public void getQrCode(String str, String author, String down, HttpServletResponse response) throws Exception {
		if(str==null||str.equals("")){
			throw new Exception();
		}
		if(down==null||down.equals("")){
			response.setDateHeader("expries", -1);
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
		}else{
			response.setContentType("image/jpeg");
			String date=new SimpleDateFormat("HHmmss").format(new Date());
			response.setHeader("content-disposition","attachment;filename=qrcode"+date+".jpg");
		}
		ImageIO.write(QrCode.getQrCode(str), "jpg", response.getOutputStream());
	}
}
