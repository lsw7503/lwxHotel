package com.lwx.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import com.lwx.dao.DBHelper;
import com.lwx.util.Data;
import com.lwx.util.MyUtil;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AdminUI {

	protected Shell shell;
	//创建堆栈式布局对象
	private StackLayout stackLayout = new StackLayout();
	private Table table;
	//创建数据库帮助对象
	private DBHelper db = new DBHelper();
	//创建帮助库对象
	private MyUtil mu = new MyUtil();
	//用户信息集合
	private List<Map<String, String>> roomList = null;
	//修改用户信息权限窗口
	private ModifyIdentity modifyUser = new ModifyIdentity();
	//修改房间信息窗口
	private ModifyRoom modifyRoom = new ModifyRoom();
	//修改房间类型信息窗口
	private ModifyRoomType modifyType = new ModifyRoomType();
	private Table table_1;
	private Table table_2;
	//添加房间
	private AddRoom add = new AddRoom();
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AdminUI window = new AdminUI();
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
		shell = new Shell(SWT.MIN);
		shell.setImage(SWTResourceManager.getImage(AdminUI.class, "/image/酒店.png"));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		shell.setSize(1254, 814);
		shell.setText("LWX酒店系统管理系统");

		// 居中
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(shell, SWT.VERTICAL);
		
		Composite composite = new Composite(sashForm, SWT.BORDER);
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setText("@ LWX版权所有");
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		label_2.setFont(SWTResourceManager.getFont("华文行楷", 15, SWT.NORMAL));
		label_2.setBounds(1050, 112, 184, 20);
		
		Label lbllwx_1 = new Label(composite, SWT.NONE);
		lbllwx_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		lbllwx_1.setFont(SWTResourceManager.getFont("华文行楷", 27, SWT.NORMAL));
		lbllwx_1.setBounds(308, 70, 555, 47);
		lbllwx_1.setText("欢迎使用LWX酒店管理系统");
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_1 = new SashForm(composite_1, SWT.VERTICAL);
		
		Composite composite_2 = new Composite(sashForm_1, SWT.BORDER);
		
		Button button = new Button(composite_2, SWT.NONE);
		button.setBounds(54, 26, 98, 30);
		button.setText("用户管理");
		
		Button button_1 = new Button(composite_2, SWT.NONE);
		button_1.setBounds(351, 26, 98, 30);
		button_1.setText("房间管理");
		
		Button button_2 = new Button(composite_2, SWT.NONE);
		
		button_2.setBounds(1028, 26, 98, 30);
		button_2.setText("业绩查询");
		
		Button button_9 = new Button(composite_2, SWT.NONE);
		
		button_9.setBounds(712, 26, 98, 30);
		button_9.setText("房间类型管理");
		
		Label label_1 = new Label(composite_2, SWT.NONE);
		
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		label_1.setBounds(1164, 61, 80, 20);
		label_1.setText("注销用户");
		
		Composite composite_3 = new Composite(sashForm_1, SWT.NONE);
		
		composite_3.setLayout(stackLayout);		//将最底下的面板设置为堆栈式布局
		
		Composite userAdmin = new Composite(composite_3, SWT.BORDER);
		userAdmin.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table = new Table(userAdmin, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnid = new TableColumn(table, SWT.NONE);
		tblclmnid.setWidth(100);
		tblclmnid.setText("用户ID");
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(313);
		tableColumn.setText("用户名称");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(299);
		tableColumn_1.setText("用户邮箱");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(303);
		tableColumn_2.setText("用户身份");
		
		Composite Welcome = new Composite(composite_3, SWT.BORDER);
		
		Label lbllwx = new Label(Welcome, SWT.NONE);
		lbllwx.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.BOLD | SWT.ITALIC));
		lbllwx.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		lbllwx.setBounds(324, 178, 611, 41);
		lbllwx.setText("欢迎使用LWX酒店系统");
		
		Label label = new Label(Welcome, SWT.NONE);
		label.setText("管理系统");
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.BOLD | SWT.ITALIC));
		label.setBounds(637, 225, 349, 41);
		
		sashForm_1.setWeights(new int[] {86, 541});
		sashForm.setWeights(new int[] {146, 630});
		
		setTop(Welcome, composite_3, stackLayout);
		
		Composite roomAdmin = new Composite(composite_3, SWT.BORDER);
		roomAdmin.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_2 = new SashForm(roomAdmin, SWT.NONE);
		
		Composite composite_4 = new Composite(sashForm_2, SWT.NONE);
		
		Button button_3 = new Button(composite_4, SWT.NONE);
		button_3.setBounds(41, 24, 98, 30);
		button_3.setText("一楼");
		
		Button button_4 = new Button(composite_4, SWT.NONE);
		button_4.setText("二楼");
		button_4.setBounds(41, 106, 98, 30);
		
		Button button_5 = new Button(composite_4, SWT.NONE);
		button_5.setText("三楼");
		button_5.setBounds(41, 189, 98, 30);
		
		Button button_6 = new Button(composite_4, SWT.NONE);
		button_6.setText("四楼");
		button_6.setBounds(41, 269, 98, 30);
		
		Button button_7 = new Button(composite_4, SWT.NONE);
		button_7.setText("五楼");
		button_7.setBounds(41, 354, 98, 30);
		
		Button button_8 = new Button(composite_4, SWT.NONE);
		button_8.setText("六楼");
		button_8.setBounds(41, 431, 98, 30);
		
		Composite composite_5 = new Composite(sashForm_2, SWT.NONE);
		composite_5.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table_1 = new Table(composite_5, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tableColumn_3 = new TableColumn(table_1, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("房间编号");
		
		TableColumn tableColumn_4 = new TableColumn(table_1, SWT.NONE);
		tableColumn_4.setWidth(109);
		tableColumn_4.setText("房间号");
		
		TableColumn tableColumn_11 = new TableColumn(table_1, SWT.NONE);
		tableColumn_11.setWidth(163);
		tableColumn_11.setText("房间类型");
		
		TableColumn tableColumn_5 = new TableColumn(table_1, SWT.NONE);
		tableColumn_5.setWidth(111);
		tableColumn_5.setText("房间电话");
		
		TableColumn tableColumn_10 = new TableColumn(table_1, SWT.NONE);
		tableColumn_10.setWidth(96);
		tableColumn_10.setText("房间床位");
		
		TableColumn tableColumn_6 = new TableColumn(table_1, SWT.NONE);
		tableColumn_6.setWidth(79);
		tableColumn_6.setText("房间价格");
		
		TableColumn tableColumn_7 = new TableColumn(table_1, SWT.NONE);
		tableColumn_7.setWidth(105);
		tableColumn_7.setText("押金");
		
		TableColumn tableColumn_8 = new TableColumn(table_1, SWT.NONE);
		tableColumn_8.setWidth(206);
		tableColumn_8.setText("房间描述");
		
		TableColumn tableColumn_9 = new TableColumn(table_1, SWT.NONE);
		tableColumn_9.setWidth(100);
		tableColumn_9.setText("状态");
		sashForm_2.setWeights(new int[] {189, 1052});
		
		Composite roomtypeAdmin = new Composite(composite_3, SWT.NONE);
		roomtypeAdmin.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		table_2 = new Table(roomtypeAdmin, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);
		
		TableColumn tableColumn_12 = new TableColumn(table_2, SWT.NONE);
		tableColumn_12.setWidth(100);
		tableColumn_12.setText("类型编号");
		
		TableColumn tableColumn_13 = new TableColumn(table_2, SWT.NONE);
		tableColumn_13.setWidth(144);
		tableColumn_13.setText("类型名称");
		
		TableColumn tableColumn_14 = new TableColumn(table_2, SWT.NONE);
		tableColumn_14.setWidth(100);
		tableColumn_14.setText("床位数");
		
		TableColumn tableColumn_15 = new TableColumn(table_2, SWT.NONE);
		tableColumn_15.setWidth(100);
		tableColumn_15.setText("价格");
		
		TableColumn tableColumn_16 = new TableColumn(table_2, SWT.NONE);
		tableColumn_16.setWidth(100);
		tableColumn_16.setText("押金");
		
		TableColumn tableColumn_17 = new TableColumn(table_2, SWT.NONE);
		tableColumn_17.setWidth(133);
		tableColumn_17.setText("该类房间总数");
		
		TableColumn tableColumn_18 = new TableColumn(table_2, SWT.NONE);
		tableColumn_18.setWidth(246);
		tableColumn_18.setText("该类房间描述");
		
		TableColumn tableColumn_19 = new TableColumn(table_2, SWT.NONE);
		tableColumn_19.setWidth(100);
		tableColumn_19.setText("房型状态");
        //未登录不能进入管理界面
		if("".equals(Data.lwsusername)){
			shell.dispose();
			LoginUI login =new LoginUI();
			login.open();
		}
		// 显示房间信息的表格的右键点击事件
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				// 先判断如果右键选中的为空 则返回
				if (table_1.getSelection().length == 0) {
					return;
				}
				
				// 创建Menu
				Menu m = new Menu(table_1);
				// 为房间管理表格设置Menu
				table_1.setMenu(m);

				// 创建Menu列表
				MenuItem mi1 = new MenuItem(m, SWT.NONE);
				mi1.setText("修改信息");
				MenuItem mi2 = new MenuItem(m, SWT.NONE);
				mi2.setText("删除房间");
				MenuItem mi3 = new MenuItem(m, SWT.NONE);
				mi3.setText("新建房间");
				
				
				// 创建与选中的一行对应的行对象
				TableItem ti = table_1.getSelection()[0];

				// 右键后左键点击菜单修改信息选项的点击事件
				mi1.addListener(SWT.Selection, new Listener() {

					@Override
					public void handleEvent(Event arg0) {
						// 判断颜色
						if (determineColorGray(ti)) {
							MessageDialog.openInformation(shell, "提示", "该类型的房间暂时不可用");
							return;
						}

						if (determineColorRed(ti)) {
							MessageDialog.openInformation(shell, "提示", "该房间暂时不可用");
							return;
						}
						// 将选中的房间roomid存入到静态数据中 以便在另一个窗口使用
						Data.modifyRoomID = ti.getText(0);
						modifyRoom.open();
						showRoominfo(Data.floor);
					}

				});

				// 右键后左键点击菜单删除房间选项的点击事件
				mi2.addListener(SWT.Selection, new Listener() {

					@Override
					public void handleEvent(Event arg0) {

						// 先得到所选中行的房间id
						String roomid = ti.getText(0);
						// sql语句
						String sql = "delete from roominfo where roomid = ?";
						// 执行sql语句
						int result = db.doUpdate(sql, roomid);
						if (result > 0) {
							MessageDialog.openInformation(shell, "提示", "删除成功");
							showRoominfo(0);
						}
					}

				});
				
				//右击后选择新建列表选项
				mi3.addListener(SWT.Selection,  new Listener(){
					@Override
					public void handleEvent(Event arg0){
						add.open();
						showRoominfo(Data.floor);
						
					}
				});
			}
		});
		
		
		//房间管理点一楼按钮后的点击事件
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Data.floor = 1;
				showRoominfo(1);
			}
		});
		
		//房间管理点二楼按钮后的点击事件
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Data.floor = 2;
				showRoominfo(2);
			}
		});
		
		//房间管理点三楼按钮后的点击事件
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Data.floor = 3;
				showRoominfo(3);
			}
		});
		
		//房间管理点四楼按钮后的点击事件
		button_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Data.floor = 4;
				showRoominfo(4);
			}
		});
		
		//房间管理点五楼按钮后的点击事件
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Data.floor = 5;
				showRoominfo(5);
			}
		});
		
		//房间管理点楼按钮后的点击事件
		button_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Data.floor = 6;
				showRoominfo(6);
			}
		});
		
		
		//用户管理表格的右键点击事件
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				//先判断如果右键选中的为空  则返回
				if( table.getSelection().length == 0){
					return;
				}
				
				//创建Menu
				Menu m = new Menu(table);
				//为用户管理表格设置Menu
				table.setMenu(m);
				
				
				//创建Menu列表
				MenuItem mi1 = new MenuItem(m, SWT.NONE);
				mi1.setText("锁定用户");
				MenuItem mi2 = new MenuItem(m, SWT.NONE);
				mi2.setText("修改权限");
				MenuItem mi3 = new MenuItem(m, SWT.NONE);
				mi3.setText("删除用户");
				//创建与选中的一行对应的行对象
				TableItem ti = table.getSelection()[0];
				
				//如果用户已经被锁定	那么将Menu的第一个选项改为  解锁	
				if(  "锁定".equals(ti.getText(3)) ){
					mi1.setText("解锁用户");
				}
				
				//右键菜单第一个选项的点击事件
				mi1.addListener(SWT.Selection, new Listener() {

					@Override
					public void handleEvent(Event arg0) {
						if("锁定用户".equals(mi1.getText())){
							//如果右键所选择的用户尚未被锁定
							//那么锁定用户
							
							//先得到所选用户的用户编号
							String lwsuserid = ti.getText(0);
							//sql语句
							String sql = "update lwsUser set status = 3 where lwsuserid = ?";
							//执行sql语句
							int result = db.doUpdate(sql, lwsuserid);
							//修改结果判断
							if(result > 0){
								mu.alter(shell, "提示", "修改成功");
								//重新加载用户列表
								showUserInfo();
							}else{
								mu.alter(shell, "提示", "修改失败,请检查......");
							}
							
						}else if("解锁用户".equals(mi1.getText())){
							//选中的用户是已经被锁定的用户
							//先得到所选用户的用户编号
							String lwsuserid = ti.getText(0);
							//sql语句
							String sql = "update lwsUser set status = 0 where lwsuserid = ?";
							//执行sql语句
							int result = db.doUpdate(sql,lwsuserid);
							//修改结果判断
							if(result > 0){
								mu.alter(shell, "提示", "修改成功");
								//重新加载用户列表
								showUserInfo();
							}else{
								mu.alter(shell, "提示", "修改失败,请检查......");
							}
							
						}
						
					}
					
				});
				
				
				//右键菜单修改权限选项的点击事件
				mi2.addListener(SWT.Selection, new Listener() {

					@Override
					public void handleEvent(Event arg0) {
						//将选中的用户id存入到静态数据中  以便在另一个窗口使用
						Data.modifyUserID = ti.getText(0);
						modifyUser.open();
						showUserInfo();
					}
					
				});
				
				//右键菜单删除用户选项的点击事件
				mi3.addListener(SWT.Selection, new Listener() {

					@Override
					public void handleEvent(Event arg0) {
						//先得到选中用户的编号
						String userid = ti.getText(0);
						//sql语句
						String sql = "delete from lwsuser where lwsuserid = ?";
						//执行sql语句
						int result = db.doUpdate(sql, userid);
						if( result > 0){
							MessageDialog.openInformation(shell, "提示", "删除成功");
							showUserInfo();
						}
					}
					
				});
			}
		});
		
		//用户管理按钮点击事件
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//将用户管理面板设置为顶层
				setTop(userAdmin, composite_3, stackLayout);
				showUserInfo();
				
			}
		});
		
		
		//房间管理按钮点击事件
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Data.floor = 0;
				//将房间管理设置为顶层
				setTop(roomAdmin, composite_3, stackLayout);
				//默认显示所有房间
				showRoominfo(0);
				
				
			}
		});
		
		
		//房间类型管理点击事件
		button_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setTop(roomtypeAdmin, composite_3, stackLayout);
				showRoomType();
			}
		});
		
		
		//房间类型表格的鼠标点击事件
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//先判断如果右键选中的为空  则返回
				if( table_2.getSelection().length == 0){
					return;
				}
				
				//创建Menu
				Menu m = new Menu(table_2);
				//为用户管理表格设置Menu
				table_2.setMenu(m);
				
				
				//创建Menu列表
				MenuItem mi1 = new MenuItem(m, SWT.NONE);
				mi1.setText("修改信息");
				
				//创建与选中的一行对应的行对象
				TableItem ti = table_2.getSelection()[0];
				
				
				//右键菜单修改信息选项的点击事件
				mi1.addListener(SWT.Selection, new Listener() {

					@Override
					public void handleEvent(Event arg0) {
						//先得到选择的房间类型的id
						Data.modifyRoomTypeid= ti.getText(0);
						modifyType.open();
						showRoomType();
					}
					
				});
			}
		});
		//注销按钮 返回登陆界面
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				LoginUI login = new LoginUI();
				mu.alter(shell, "提示信息","您正在退出登录。。。" );
				try {
					Thread.sleep(3000);
				
				shell.dispose();
				login.open();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		//业绩
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				CategoryTest c =new CategoryTest();
				      c.openByYear();
			}
		});
	}
	
	
	
	
	
	
	//设置最底层堆栈式面板的顶层面板的方法
	protected void setTop(Composite c , Composite fatherS ,StackLayout s){
		//将选择面板设置为等层面板 
		s.topControl = c;
		//(一定要)刷新顶层面板
		fatherS.layout();		
		
	}
	
	
	//查询并显示用户数据的方法
	protected void showUserInfo(){
		/*
		 * 在表格中显示数据
		 */
		//首先将列表清空
		table.removeAll();
		//查询房间信息表的sql语句 
		String sql = "select * from lwsUser";
		//将查到的数据存放到roomList中
		roomList = db.queryAll(sql);
		
		//如果没有查到用户
		if( roomList == null || roomList.size() == 0){
			mu.alter(shell, "提示", "没有查到用户......");
			return;
		}
		//如果查到用户 便会继续执行
		//循环  用于将数据读取到表格中
		for(int i = 0; i<roomList.size(); i++){
			TableItem ti = new TableItem(table, SWT.NONE);
			//用户身份判断
			String identity = "";
			
			if( Integer.parseInt(roomList.get(i).get("status")) == 0){
				//如果数据库中的状态为0  那么该用户为普通用户
				identity = "用户";
			}else if (Integer.parseInt(roomList.get(i).get("status")) == 1){
				//如果数据库中的状态为1  那么该用户为管理员
				identity = "管理员";
			}else if (Integer.parseInt(roomList.get(i).get("status")) == 3){
				identity = "锁定";
			}
			
			ti.setText(new String[]{
					roomList.get(i).get("lwsuserid"),roomList.get(i).get("lwsusername"),
					roomList.get(i).get("mail"),identity
			});
			
			//如果用户的状态为锁定的  那么该行显示为红色
			if( "锁定".equals(identity)){
				ti.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
			}
		}
	}
	
	
	//查询并显示房间信息的方法
	protected void showRoominfo(int floor){
		//先清空
		table_1.removeAll();
		//得到对应数据  房间编号  房间号  房间电话  房间价格  押金  房间描述  状态
		//sql语句
		String sql = "select roomid,r_number,r_call,r_bed,r_price,r_foregift,roominfo.r_remark,r_state,r_type"
				+ " from roominfo,roomtype where r_type_id = roomtypeid and r_location = ";
		String sf = "";
		switch (floor) {
		case 1:
			sf="'一楼'";
			break;
		case 2:
			sf="'二楼'";
			break;
		case 3:
			sf="'三楼'";
			break;
		case 4:
			sf="'四楼'";
			break;
		case 5:
			sf="'五楼'";
			break;
		case 6 :
			sf="'六楼'";
			break;
		default:
			//用于初识显示所有房间信息
			sql = "select roomid,r_number,r_call,r_bed,r_price,r_foregift,roomtype.r_remark,r_state,r_type"
					+ " from roominfo,roomtype where r_type_id = roomtypeid ";
			break;
		}
		sql = sql + sf +" order by r_state asc ,r_number asc";
		//执行sql语句
		List<Map<String, String>> list = db.queryAll(sql);
		//如果执行失败
		if(list == null || list.size()<=0){
			return;
		}
		//循环  添加数据 
		for(int i = 0; i<list.size(); i++){
			TableItem ti = new TableItem(table_1, SWT.NONE);
			
			ti.setText(new String[]{
					list.get(i).get("roomid"),list.get(i).get("r_number"),
					list.get(i).get("r_type"),list.get(i).get("r_call"),
					list.get(i).get("r_bed"),list.get(i).get("r_price"),list.get(i).get("r_foregift"),
					list.get(i).get("r_remark"),list.get(i).get("r_state")
			});
			
			//sql语句
			String sql2 = "select * from roomtype where r_type = ?";
			//执行sql语句
			List<Map<String, String >> list2 = db.queryAll(sql2, list.get(i).get("r_type"));
			
			//如果房间是维护或停用状态
			if( "维护中".equals(list.get(i).get("r_state")) || "停用".equals(list.get(i).get("r_state"))){
				ti.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
			}
			
			
			//如果所查询到的房间类型是不可用的
			if( !"1".equals(list2.get(0).get("status"))){
				ti.setForeground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
			}
			
		}
		
	}
	
	//根据类型编号得到类型名的方法
	protected String getTypeName(String tNum){
		//sql语句
		String sql = "select * from roomtype where roomtypid = ?";
		//执行sql 语句
		List<Map<String, String>> list = db.queryAll(sql, tNum);
		String tName = list.get(0).get("r_type");
		return tName;
	}
	
	
	//查询并显示房间类型信息的方法
	protected void showRoomType(){
		//先清空所有
		table_2.removeAll();
		//sql语句
		String sql = "select * from roomtype";
		//执行
		List<Map<String, String>> list = db.queryAll(sql);
		
		if( list == null || list.size()<=0){
			MessageDialog.openInformation(shell, "提示", "查询出错");
			return;
		}
		
		
		
		for(int i = 0; i<list.size(); i++){
			TableItem ti = new TableItem(table_2,SWT.NONE);
			String status = "";
			if("1".equals(list.get(i).get("status"))){
				status = "可用";
			}else if("2".equals(list.get(i).get("status"))){
				status = "升级中";
			}else{
				status = "暂停使用";
			}
			ti.setText(new String[]{
				list.get(i).get("roomtypeid"),list.get(i).get("r_type"),
				list.get(i).get("r_bed"),list.get(i).get("r_price"),
				list.get(i).get("r_foregift"),list.get(i).get("r_all"),
				list.get(i).get("r_remark"),status
			});
			
			//如果该房间类型的状态为不可用  那么该行为红色
			if( "不可用".equals(status)){
				ti.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
				
			}
			
		}
	}
	
	//判断背景色是否为红色的方法
	protected boolean determineColorRed(TableItem ti){
		boolean flag = false;
		Color color = new Color(null,255,0,0,255);
		if(ti.getForeground().equals(color)){
			flag = true;
		}
		return flag;
	}
	
	//判断背景色是否为灰色的方法
		protected boolean determineColorGray(TableItem ti){
			boolean flag = false;
			Color color = new Color(null,192,192,192,255);
			if(ti.getForeground().equals(color)){
				flag = true;
			}
			return flag;
		}
}













