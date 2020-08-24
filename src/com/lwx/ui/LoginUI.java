package com.lwx.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.lwx.util.Data;
import com.lwx.ui.AdminUI;
import com.lwx.ui.Index;
import com.lwx.dao.DBHelper;
import com.lwx.util.MyUtil;

import org.eclipse.swt.layout.FillLayout;

import java.util.List;
import java.util.Map;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.MouseTrackAdapter;

public class LoginUI {
    private Preferences pre1 = Preferences.userNodeForPackage(LoginUI.class);

	protected Shell shell;
	private Text text_1;
	private Label lblNewLabel;
	private Label lbllwx;
	private Label label_1;
	private Label label;
	private Label lblNewLabel_1;
	private Label label_2;
	private Label label_3;
	private Label label_4;
	private DBHelper db = new DBHelper();
	private MyUtil mu = new MyUtil();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginUI window = new LoginUI();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setText("酒店登录界面");
		shell.setImage(SWTResourceManager.getImage(LoginUI.class, "/image/酒店.png"));
		shell.setSize(669, 398);
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		mu.centerShell(shell);
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_FORCE);
		composite.setBackgroundImage(SWTResourceManager.getImage(LoginUI.class, "/image/timg.png"));
		
		label = new Label(composite, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(LoginUI.class, "/image/账号.png"));
		label.setBounds(184, 75, 32, 32);
		
		label_1 = new Label(composite, SWT.NONE);
		label_1.setImage(SWTResourceManager.getImage(LoginUI.class, "/image/密码.png"));
		label_1.setBounds(184, 128, 32, 32);
		
		
		text_1 = new Text(composite, SWT.BORDER | SWT.PASSWORD );
		text_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		text_1.setBounds(240, 133, 144, 27);
		
		label_2 = new Label(composite, SWT.NONE);
		label_2.setImage(SWTResourceManager.getImage(LoginUI.class, "/image/登录(8).png"));
		label_2.setBounds(398, 241, 32, 32);
		
		lblNewLabel = new Label(composite, SWT.NONE);
		
		
		
		lblNewLabel.setImage(SWTResourceManager.getImage(LoginUI.class, "/image/注册(4).png"));
		lblNewLabel.setBounds(184, 241, 32, 32);
		
		lbllwx = new Label(composite, SWT.NONE);
		lbllwx.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		lbllwx.setFont(SWTResourceManager.getFont("华文行楷", 14, SWT.NORMAL));
		lbllwx.setBounds(164, 38, 332, 26);
		lbllwx.setText("欢迎使用LWX酒店管理系统");
		
		lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("华文行楷", 11, SWT.NORMAL));
		lblNewLabel_1.setBounds(166, 321, 256, 20);
		lblNewLabel_1.setText("                   @ LWX版权所有");
		
		label_3 = new Label(composite, SWT.NONE);
		label_3.setBounds(10, 39, 32, 277);
		
		label_4 = new Label(composite, SWT.NONE);
		label_4.setBounds(609, 39, 32, 277);
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBounds(240, 85, 144, 28);
		
		Button button = new Button(composite, SWT.CHECK);
		button.setSelection(true);
		button.setBounds(346, 185, 84, 20);
		button.setText("记住密码");
		
		Button button_1 = new Button(composite, SWT.RADIO);
		button_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		button_1.setBounds(431, 88, 119, 20);
		button_1.setText("管理员登录");
		
		Button button_2 = new Button(composite, SWT.RADIO);
		button_2.setSelection(true);
		button_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		button_2.setBounds(431, 140, 119, 20);
		button_2.setText("用户登录");
		try {
			String[] keys =pre1.keys();
			for(int i = 0;i<keys.length;i++){
				combo.setItems(keys);
				combo.select(0);
				//将密码放上去
				text_1.setText(pre1.get(keys[0], ""));
			}
		} catch (BackingStoreException e2) {
			// TODO Auto-generated catch block
			
		}
		//注册按钮
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.dispose();
				RegUI reg = new RegUI();
				reg.open();
			}
		});
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String lwsusername = combo.getText();
				String lwspwd = text_1.getText();
				
				
				String sql = "";

				if(button_2.getSelection()){
	        		sql = "select * from lwsUser where lwsusername = ? and lwspwd =? and status = 0";
	        	}else{
	        		sql = "select * from lwsUser where lwsusername = ? and lwspwd =? and status = 1";
	        	}
				List<Map<String, String>> list = db.queryAll(sql, lwsusername,lwspwd);
				if(list.size()>0){
					Data.lwsusername = lwsusername;
	        		Data.lwsuserid = Integer.parseInt(list.get(0).get("lwsuserid"));
					if(button.getSelection()){
	        			//密码是存在本地的
	        		try {
						
						pre1.put(lwsusername, lwspwd);
						pre1.flush();
					} catch (BackingStoreException e1) {
						
						e1.printStackTrace();
					}
	            	}else{
	            		//没有记住密码 删除
	            		pre1.remove(lwsusername);
	            	}
					shell.dispose();
					if(list.get(0).get("status").equals("0")){
	        			Index index = new Index();
	        			index.open();
	        		}else if(list.get(0).get("status").equals("1")){
	        			AdminUI admin = new AdminUI();
	        			admin.open();
	        		}else if(list.get(0).get("status").equals("3")){
	        			mu.alter(shell, "提示信息 ","用户已被锁定");
	        		}else{
	        			mu.alter(shell, "提示信息 ","用户或密码错误");
	        		}
	        	}
				
					
				
			}
		});
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			String name = combo.getText();
			text_1.setText(pre1.get(name, ""));
			}
		});
		//注册按钮变色
		lblNewLabel.addMouseTrackListener(new MouseTrackAdapter() {
			
				@Override
				public void mouseEnter(MouseEvent e) {
					lblNewLabel.setImage(SWTResourceManager.getImage(LoginUI.class, "/image/注册(3).png"));
				    
				   
				}
				@Override
				public void mouseExit(MouseEvent e) {
					lblNewLabel.setImage(SWTResourceManager.getImage(LoginUI.class, "/image/注册(4).png"));
					  
				}
			
		});
		//登录按钮变色
		label_2.addMouseTrackListener(new MouseTrackAdapter() {
			
			@Override
			public void mouseEnter(MouseEvent e) {
				label_2.setImage(SWTResourceManager.getImage(LoginUI.class, "/image/登录(7).png"));
			    
			   
			}
			@Override
			public void mouseExit(MouseEvent e) {
				label_2.setImage(SWTResourceManager.getImage(LoginUI.class, "/image/登录(8).png"));
				  
			}
		
	});
	}
}
