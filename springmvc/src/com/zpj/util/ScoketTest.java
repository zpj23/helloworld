package com.zpj.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class ScoketTest {
	public static void main(String[] args) {
		ScoketTest st= new ScoketTest();
		st.test1();
	}
	
	public void test1(){
		try {
			ServerSocket serverSocket=new ServerSocket(10086);
			while(true){
				Socket socket=serverSocket.accept();
				new Thread(new Task(socket)).start();
			}
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static class Task implements Runnable{

		private Socket socket;
		
		public Task(Socket socket){
			this.socket=socket;
		}
		@Override
		public void run() {
			handlesocket();
		}
		public void handlesocket(){
			try{
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
		         char chars[] = new char[64];  
		         int len;  
		         StringBuilder sb = new StringBuilder();  
		         String temp;  
		         int index;  
		         while ((temp=reader.readLine()) !=null) {  
		            if ((index = temp.indexOf("eof")) != -1) {//遇到eof时就结束接收  
		             sb.append(temp.substring(0, index));  
		                break;  
		            }  
		            sb.append(temp);  
		         }  
		         System.out.println("from client: " + sb);  
		         //读完后写一句  
		         PrintWriter writer = new PrintWriter(socket.getOutputStream());  
		         writer.write("Hello Client.");  
		         writer.write("eof\n");  
		         writer.flush();  
		         writer.close();  
		         reader.close();  
		         socket.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			 
		}
		
	}
	public void  test(){
		try {
			ServerSocket serverSocket=new ServerSocket(10086);
			Socket socket=serverSocket.accept();
			InputStream is=socket.getInputStream();
			Reader br=new BufferedReader(new InputStreamReader(is));
			StringBuffer info=new StringBuffer();
			char chars[] = new char[64];  
			int len;
			String temp;
			int index;
			while((len=br.read(chars))!=-1){
				temp = new String(chars, 0, len);
				if((index=temp.indexOf("eof"))!=-1){
					info.append(temp.substring(0, index));
					break;
				}
					info.append(temp);
			}
			System.out.println("客户端说："+info.toString());
			socket.shutdownInput();
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			pw.write("好的，我已接收到");
			pw.flush();
			
			pw.close();
			os.close();
			br.close();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
