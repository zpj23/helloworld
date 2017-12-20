package com.zpj.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class SocketClient {
	public static void main(String[] args) {
		SocketClient sc = new SocketClient();
		sc.test();
	}
	public void test(){
		try {
			Socket socket=new Socket("127.0.0.1",10086);
			OutputStream os=socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("用户名:admin;密码:admin");
			pw.write("eof\n");
			pw.flush();
			socket.shutdownOutput();
			InputStream is =socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			StringBuffer info=new StringBuffer();
			char chars[] = new char[64];  
			int len;
			String temp;
			int index;
			socket.setSoTimeout(10*1000);
			
			try{
				while((temp=br.readLine())!=null){
					if((index=temp.indexOf("eof"))!=-1){
						info.append(temp.substring(0, index));
						break;
					}
					info.append(temp);
				}
			}catch (SocketTimeoutException  e) {
				System.out.println("超时。。。");
			}
			System.out.println("服务端说："+info.toString());
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
