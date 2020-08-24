package com.lwx.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;


import com.lwx.dao.DBHelper;
import com.lwx.util.Data;
import com.lwx.util.MyUtil;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;

public class RegUI {

	protected Shell shlLwx;
	private Text text;
	private Label label;
	private Text text_1;
	private DBHelper db = new DBHelper();
	private  static MyUtil mu = new MyUtil();
	private Label label_1;
	private Label lblNewLabel_1;
	private Label label_2;
	private Text text_2;
	private Text text_3;
	private Label label_3;
	private Label label_4;
	private Label label_5;
	private Text text_4;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RegUI window = new RegUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlLwx.open();
		shlLwx.layout();
		while (!shlLwx.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLwx = new Shell();
		shlLwx.setImage(SWTResourceManager.getImage(RegUI.class, "/image/酒店.png"));
		shlLwx.setSize(696, 477);
		shlLwx.setText("LWX酒店管理系统注册界面");
		shlLwx.setLayout(new FillLayout(SWT.HORIZONTAL));
		mu.centerShell(shlLwx);
		Composite composite = new Composite(shlLwx, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setBackgroundImage(SWTResourceManager.getImage(RegUI.class, "/image/timg.png"));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(RegUI.class, "/image/请输入用户名.png"));
		lblNewLabel.setBounds(200, 88, 32, 32);
		
		text = new Text(composite, SWT.BORDER);
		
		text.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		text.setText("请输入账号");
		
		text.setBounds(247, 94, 165, 26);
		
		label = new Label(composite, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(RegUI.class, "/image/请输入密码.png"));
		label.setBounds(200, 149, 32, 32);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		text_1.setText("请输入密码");
		text_1.setBounds(247, 155, 165, 26);
		
		label_1 = new Label(composite, SWT.NONE);
		
		
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_1.setImage(SWTResourceManager.getImage(RegUI.class, "/image/返回1.png"));
		label_1.setBounds(405, 360, 48, 48);
		
		lblNewLabel_1 = new Label(composite, SWT.NONE);
		
		lblNewLabel_1.setImage(SWTResourceManager.getImage(RegUI.class, "/image/返回按钮(4).png"));
		lblNewLabel_1.setBounds(162, 360, 48, 48);
		
		label_2 = new Label(composite, SWT.NONE);
		label_2.setImage(SWTResourceManager.getImage(RegUI.class, "/image/邮箱(3).png"));
		label_2.setBounds(193, 207, 48, 48);
		
		text_2 = new Text(composite, SWT.BORDER);
		
		text_2.setText("请输入您的邮箱");
		text_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		text_2.setBounds(247, 215, 165, 26);
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setText("请输入验证码");
		text_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		text_3.setBounds(315, 277, 99, 32);
		
		label_3 = new Label(composite, SWT.NONE);
		
		label_3.setImage(SWTResourceManager.getImage(RegUI.class, "/image/获取验证码.png"));
		label_3.setBounds(193, 280, 107, 32);
		
		label_4 = new Label(composite, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont("华文新魏", 9, SWT.NORMAL));
		label_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_4.setBounds(362, 129, 136, 20);
		
		label_5 = new Label(composite, SWT.NONE);
		label_5.setFont(SWTResourceManager.getFont("华文新魏", 9, SWT.NORMAL));
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_5.setBounds(362, 189, 136, 20);
		
		text_4 = new Text(composite, SWT.BORDER);
		text_4.setText("请再次输入密码");
		text_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		text_4.setBounds(437, 155, 165, 26);
		
		text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if("请输入账号".equals(text.getText())){
			 	
			 	text.setText("");
			 	text.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
			 	text.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
         
				}
			}
			
		});
		//注册返回
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shlLwx.dispose();
				LoginUI login = new LoginUI();
				login.open();
			}
		});
		
		text_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if("请输入密码".equals(text_1.getText())){
			 	
			 	text_1.setText("");
			 	text_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
			 	text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				
				}
			}
			
		});
		text_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if("请输入您的邮箱".equals(text_2.getText())){
			 	
					text_2.setText("");
					text_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
					text_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				
				}
			}
			
		});
		text_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if("请输入验证码".equals(text_3.getText())){
			 	
					text_3.setText("");
					text_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
					text_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				
				}
			}
			
		});
		text_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if("请再次输入密码".equals(text_4.getText())){
			 	
					text_4.setText("");
					text_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 9, SWT.BOLD));
					text_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
				
				}
			}
			
		});
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String mail = text_2.getText();
				mu.sendMail(mail);
			}
		});
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if("".equals(text.getText()) || text.getText() == null){
					label_4.setText("账户名不能为空");
				}else{
					label_4.setText("");
				}
			}
		});
		text_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if("".equals(text.getText()) || text.getText() == null){
					label_4.setText("账户名不能为空");
				}else{
					label_4.setText("");
				}
			}
		});
		text_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if("".equals(text_4.getText()) || text_4.getText() == null){
					label_5.setText("密码不能为空");
				}else if(!text_4.getText().equals(text_1.getText())){
					label_5.setText("两次密码不一致");
				}else{
					label_5.setText("");
					return;
				}
			}
		});
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String code = text_3.getText();
				if(!code.equals(  Data.code  )){
					   mu.alter(shlLwx, "提示信息", "验证码错误");
					   return;
				   }else{
					String lwsusername=text.getText();
				    String lwspwd = text_1.getText();
				    String mail = text_2.getText();
					String sql = "insert into lwsUser values(lwsUser_lwsuserid.nextval,?,?,?,'0')";
				    int result = db.doUpdate(sql, lwsusername,lwspwd,mail);
				    if(result >0){
				    	mu.alter(shlLwx, "提示信息", "注册成功，即将跳转登陆界面。。。");
				    	shlLwx.dispose();
				    	LoginUI login = new LoginUI();
				    	login.open();
				    }else{
				    	mu.alter(shlLwx, "提示信息", "注册失败，请联系管理员。。。");
				    }
				    }
		}
		});

	}

}
