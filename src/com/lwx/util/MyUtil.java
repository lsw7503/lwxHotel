package com.lwx.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class MyUtil {
	//定义一些全局变量
	public String myEmail ="q750311841@163.com";		//发件人的邮箱
	public String smtpHost="smtp.163.com";				//有建筑及地址
	public String myPwd="NMDATIOUDZTAGFZJ";				//这个密码，不是163邮箱的登录密码，是授权码
	
	private Thread thread = null; // 播放线程
	private boolean startStatus = true; // 启动状态
	private AudioInputStream ais;
	private AudioFormat format;
	private long timeLength = 0; // 总时长
	private long time = 0; // 当前播放时间
	
	//停止播放
	public void stop(){
		if(Data.clip==null){
			return;
		}
		//一系列的关闭
		Data.clip.close();
		Data.clip=null;
		startStatus=false;
		Data.playFlag=false;
		thread.stop();
	}
	
	//暂停
	public void pause(){
		Data.clip.stop();
		Data.playFlag=false;
		new Thread(new Runnable(){

			@Override
			public void run() {
				synchronized (thread){
					try {
					thread.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
			}
			
		}).start();
	}
	
	//继续播放
	public void continues(){
		Data.clip.start();
		Data.playFlag=true;
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				synchronized (thread){
					thread.notify();//唤醒等待的线程
				}
				
			}
			
		}).start();
	}
	
	
	//弹框的方法
	/**
	 * 方法注释
	 * @param shell    shell对象
	 * @param title    弹框的标题
	 * @param message  弹框的内容
	 */
	public void alter(Shell shell,String title,String message){
		MessageBox mb=new MessageBox(shell,SWT.NONE);
		mb.setMessage(message);
		mb.setText(title);
		mb.open();
	}
	
	
	/**
	 * 发送邮箱的方法
	 * @param email		收件人的邮箱地址 
	 */
	public void sendMail(String email){

		
		
		
		//发邮件，首先，先随机出验证码
		Random r=new Random();
		String code="";
		for(int i=0;i<6;i++){
			code += r.nextInt(10);
		}
		//存一下验证码，方便用户注册的时候来验证
		Data.code=code;
		
		try {
			//开始发送邮件
			Properties props=new Properties();		//创建参数配置
			props.setProperty("mail.transport.protocol", "smtp");		//定义传输协议
			props.setProperty("mail.smtp.host", smtpHost);				//定义主机地址
			props.setProperty("mail.smtp.auth", "true");				//授权验证
			//根据配置，来得到会话对象
			Session session=Session.getInstance(props);			//从你发送邮件开始，到发送成功，是一次会话
			//通过会话对象，来得到邮件对象
			MimeMessage message=new MimeMessage(session);
			//设置一下发件人
			message.setFrom(new InternetAddress(myEmail,"LWX团队","UTF-8"));
			//设置一下收件人
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email,"用户","UTF-8"));
			//设置邮件的主题
			message.setSubject("欢迎使用lwx酒店管理系统","UTF-8");
			//设置内容
			message.setContent("尊敬的用户，您好！您的注册码为：" + code ,"text/html;charset=UTF-8");
			//设置发件时间
			message.setSentDate(new Date());		//现在发
			message.saveChanges();
			//开始发送邮件
			Transport transport=session.getTransport();
			transport.connect(myEmail, myPwd);
			transport.sendMessage(message, message.getAllRecipients());
			//发送成功，关闭连接
			transport.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 
	 * @param is			要播放歌曲的io流
	 * @param progressBar	进度条
	 */
	public void start(AudioInputStream is,ProgressBar progressBar,Label label){
		// 先结束以前的歌曲
		if (Data.clip != null) {
			Data.clip.close();
			Data.clip = null;
		}

		if (thread != null) {
			startStatus = false;
			thread.stop();
		}
		
		//进度条归0
		progressBar.setSelection(0);
		//设置播放
		Data.playFlag=true;
		
		try {
			ais = AudioSystem.getAudioInputStream(is); // 获取音频流
			format = ais.getFormat(); // 获得此音频输入流中声音数据的音频格式
			
			// 获取此格式声音的编码类型 如果不是  有符号的线性 PCM 数据
			if(format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
				format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,  // 音频编码技术
						format.getSampleRate(), // 每秒的样本数
						16, // 每个样本中的位数
						format.getChannels(), // 声道数（单声道 1 个，立体声 2 个，等等）
						format.getChannels() * 2, // 每帧中的字节数
						format.getSampleRate(), // 每秒的帧数
						false // 指示是否以 big-endian 字节顺序存储单个样本中的数据（false 意味着 little-endian）
						);
				ais = AudioSystem.getAudioInputStream(format, ais);
				
			}
			
			//初始化Clip
			Data.clip = AudioSystem.getClip();
			Data.clip.open(ais);

			timeLength = Data.clip.getMicrosecondLength() / 1000; // 获取音频文件的时长
			
			//开始播放
			Data.clip.start();
			
			//同步进度条
			thread = new Thread() {
				@Override
				public void run() {
					boolean end = false; // 歌曲播放是否结束
					startStatus = true;


					synchronized(thread) {
						while (startStatus) {
							//得到当前的时间
							time = Data.clip.getMicrosecondPosition() / 1000;
							
							// 进度条
							Display.getDefault().asyncExec(new Runnable(){
								@Override
								public void run() {
									//                      00:01 / 04:35
									label.setText(showTime(time, timeLength));
									progressBar.setSelection( (int)( (float) time / timeLength * 100) );
								}
							});

							// 说明这首歌曲已经播完了
							if (time == timeLength) {
								Display.getDefault().asyncExec(new Runnable(){
									@Override
									public void run() {
										progressBar.setSelection(100);
										label.setText(showTime(timeLength, timeLength));
									}
								});

								startStatus = false;
								Data.playFlag=false;
								break;
							} else {
								try {
									sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
						
						//播放完了
						System.out.println("播放玩了");
					}
				}
			};

			thread.start();
			
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 时间调整
	 * @param time
	 * @param timeLength
	 * @return
	 */
	private String showTime(long time, long timeLength) {
		long temp = 0;
		String str = "";
		if (time < 60000) {
			str = "00:";
			temp = time / 1000;
			str += temp >= 10 ? String.valueOf(temp) : "0" + temp;
		} else {
			temp = time / 60000;
			str = temp >= 10 ? String.valueOf(temp) : "0" + temp;
			temp = time % 60000 / 1000;
			str += ":";
			str += temp >= 10 ? String.valueOf(temp) : "0" + temp;
		}

		str += " / ";
		temp = timeLength / 60000;
		str += temp >= 10 ? String.valueOf(temp) : "0" + temp;
		temp = timeLength % 60000 / 1000;
		str += ":";
		str += temp >= 10 ? String.valueOf(temp) : "0" + temp;
		return str;
	}
	
	
	/**
	 * 居中shell窗口
	 * @param shell
	 */
	public void centerShell(Shell shell){
		int screenWidth=Display.getCurrent().getClientArea().width;
		int shellWidth=shell.getShell().getSize().x;
		shell.setLocation((screenWidth-shellWidth)/2,
				(Display.getCurrent().getClientArea().height-shell.getShell().getSize().y)/2);
	}
	
	
}
