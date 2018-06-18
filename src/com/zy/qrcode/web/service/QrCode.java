package com.zy.qrcode.web.service;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.swetake.util.Qrcode;

public class QrCode {

	public static BufferedImage getQrCode (String content) throws Exception{//,String c
		int width=235;
		int height=235;
		boolean a=false;
		
		Qrcode qrcode=new Qrcode();
		//二维码排错率  L(7%) M(15%) Q(25%) H(30%)
		qrcode.setQrcodeErrorCorrect('M');
		qrcode.setQrcodeEncodeMode('B');
		qrcode.setQrcodeVersion(15);
		
		BufferedImage img=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		Graphics2D grap=img.createGraphics();
		grap.setBackground(Color.WHITE);
		grap.clearRect(0, 0, width, height);
		grap.setColor(Color.BLACK);
		
		try {
			byte[] cont=content.getBytes("utf-8");
			boolean[][] codeOut =qrcode.calQrcode(cont);
			
			int z=2;
			for(int i=0;i<codeOut.length;i++){
				for(int j=0;j<codeOut.length;j++){
					if(codeOut[i][j]){
						grap.fillRect(j*3+z, i*3+z, 3, 3);
					}
				}
			}
			
			grap.dispose();
			img.flush();
			
			return img;
			
		} catch (Exception e) {
			throw new Exception("二维码生成失败!");
		}finally{
			if(grap!=null){
				grap.dispose();
			}else if(img!=null){
				img.flush();
			}
		}
	}
}