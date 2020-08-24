package com.lwx.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.lwx.ui.zfb;
import com.lwx.dao.DBHelper;
import com.lwx.util.Data;
import com.lwx.util.MyUtil;

import org.eclipse.swt.layout.FillLayout;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;

public class Index {

	protected Shell shlLwx;
	private Table table_2;
	private StackLayout stackLayout= new StackLayout();
	private Table table;
	private Table table_1;
	private String r_state;
	private int r_number;
	private String in_time;
	public  DBHelper db = new DBHelper();
	public  MyUtil mu = new MyUtil();
    private TableColumn tableColumn ;
    private TableColumn tableColumn_1;
    private TableColumn tableColumn_2;
    private TableColumn tableColumn_3 ;
    private TableColumn tableColumn_4 ;
    private TableColumn tableColumn_5 ;
    private TableColumn tblclmnid ;
    private TableColumn tableColumn_7 ;
    private TableColumn tableColumn_8 ;
    private TableColumn tableColumn_9;
    private TableColumn tableColumn_10;
    private TableColumn tableColumn_11 ;
    private TableColumn tableColumn_12 ;
    private TableColumn tableColumn_13 ;
    private TableColumn tblclmnPic ;
    private TableColumn tableColumn_15;
    private TableColumn tableColumn_16 ;
    private Composite composite_6;
    private Label label_11;
    private List<Map<String, String>> bhotels;
    private int roomid;
    private String in_sfz;
    private String in_name ;
    private String in_sex ;
    private String out_time;
    private String r_type;
    private int in_pnumber;
    public Thread dd;
    private int in_day ;
    private int in_room ;
    private int roomtypeid = Data.roomtypeid; ;
    private double r_price;
    
    private Combo combo ;
    private Composite composite_7;
    private Label lblNewLabel_2;
    private Label label_13;
    private Label label_14;
    private Label label_15;
    private Label label_16;
    private Label label_18;
    private Label label_17;
    private Text text_1;
    private Text text_2;
    private Text text_3;
    private Text text_4;
    private Text text_5;
    private Text text_6;
    private Button button_2;
    private Button btnNewButton_1;
    private TableColumn tableColumn_6;
    private TableColumn tableColumn_21;
    private TableColumn tblclmnNewColumn;
    private TableColumn tblclmnNewColumn_1;
    private TableColumn tableColumn_22;
    private Label label_7;
    private TableColumn tblclmnNewColumn_2;
    private String choosenType = "";
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Index window = new Index();
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
		
		shlLwx.setImage(SWTResourceManager.getImage(Index.class, "/image/酒店.png"));
		shlLwx.setSize(1034, 646);
		shlLwx.setText("LWX酒店管理系统");
		shlLwx.setLayout(new FillLayout(SWT.HORIZONTAL));
		mu.centerShell(shlLwx);
		SashForm sashForm = new SashForm(shlLwx, SWT.NONE);
		sashForm.setBackgroundMode(SWT.INHERIT_FORCE);
		sashForm.setBackgroundImage(SWTResourceManager.getImage(Index.class, "/image/主界面.jpg"));
		sashForm.setOrientation(SWT.VERTICAL);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setBackgroundMode(SWT.INHERIT_FORCE);
		composite_1.setLayout(stackLayout);
		Composite composite_3 = new Composite(composite_1, SWT.NONE);
		composite_6 = new Composite(composite_1, SWT.NONE);
		//设置顶层
		stackLayout.topControl = composite_6;
		
		Composite composite_4 = new Composite(composite_1, SWT.NONE);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		
		
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Index.class, "/image/入住.png"));
		lblNewLabel_1.setBounds(81, 10, 54, 48);
		
		Label label = new Label(composite, SWT.NONE);
		
		label.setImage(SWTResourceManager.getImage(Index.class, "/image/查询(1).png"));
		label.setBounds(692, 10, 54, 48);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("华文行楷", 10, SWT.NORMAL));
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_1.setBounds(138, 41, 76, 20);
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_2.setFont(SWTResourceManager.getFont("华文行楷", 10, SWT.NORMAL));
		label_2.setBounds(755, 38, 76, 20);
		
		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setImage(SWTResourceManager.getImage(Index.class, "/image/离店.png"));
		label_3.setBounds(391, 10, 63, 48);
		
		
		table = new Table(composite_3, SWT.BORDER | SWT.FULL_SELECTION);
		//创建Menu
		Menu m = new Menu(table);
		//为房间信息表格设置Menu
		table.setMenu(m);
		//创建Menu列表
		MenuItem mi1 = new MenuItem(m, SWT.NONE);
		
		mi1.setText("查看详细信息");
		MenuItem mi2 = new MenuItem(m, SWT.NONE);
		mi2.setText("取消");
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(21, 41, 969, 317);
		
		tableColumn_7 = new TableColumn(table, SWT.NONE);
		tableColumn_7.setWidth(123);
		tableColumn_7.setText("房间ID");
		
		 tableColumn_8 = new TableColumn(table, SWT.NONE);
		tableColumn_8.setWidth(112);
		tableColumn_8.setText("房间类型");
		
		tableColumn_9 = new TableColumn(table, SWT.NONE);
		tableColumn_9.setWidth(100);
		tableColumn_9.setText("房间号");
		
		 tableColumn_10 = new TableColumn(table, SWT.NONE);
		tableColumn_10.setWidth(100);
		tableColumn_10.setText("房间位置");
		
		 tableColumn_11 = new TableColumn(table, SWT.NONE);
		tableColumn_11.setWidth(115);
		tableColumn_11.setText("房间状态");
		
		 tableColumn_12 = new TableColumn(table, SWT.NONE);
		tableColumn_12.setWidth(136);
		tableColumn_12.setText("房间电话");
		
		 tableColumn_13 = new TableColumn(table, SWT.NONE);
		tableColumn_13.setWidth(183);
		tableColumn_13.setText("备注");
		
		tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(96);
		tblclmnNewColumn_2.setText("房间状态");
		
		Label label_5 = new Label(composite_3, SWT.NONE);
		label_5.setFont(SWTResourceManager.getFont("华文行楷", 11, SWT.NORMAL));
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_5.setBounds(10, 10, 78, 20);
		label_5.setText("欢迎用户:");
		
		Label label_6 = new Label(composite_3, SWT.NONE);
		label_6.setFont(SWTResourceManager.getFont("华文行楷", 11, SWT.NORMAL));
		label_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_6.setBounds(94, 10, 36, 20);
		label_6.setText(Data.lwsusername);
		
		Label lbllwx = new Label(composite_3, SWT.NONE);
		lbllwx.setFont(SWTResourceManager.getFont("华文行楷", 11, SWT.NORMAL));
		lbllwx.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		lbllwx.setBounds(136, 10, 223, 20);
		lbllwx.setText("使用LWX酒店管理系统。");
		
		Button button_1 = new Button(composite_3, SWT.NONE);
		
		
		button_1.setBounds(614, 395, 98, 30);
		button_1.setText("选 择");
		
		Label label_12 = new Label(composite_3, SWT.NONE);
		label_12.setBounds(165, 400, 76, 20);
		table_2 = new Table(composite_4, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setLinesVisible(true);
		table_2.setHeaderVisible(true);
		table_2.setBounds(10, 41, 986, 317);
		
		 tableColumn = new TableColumn(table_2, SWT.NONE);
		tableColumn.setWidth(74);
		tableColumn.setText("用户编号");
		
		tableColumn_1 = new TableColumn(table_2, SWT.NONE);
		tableColumn_1.setWidth(189);
		tableColumn_1.setText("身份证号");
		
		tableColumn_2 = new TableColumn(table_2, SWT.NONE);
		tableColumn_2.setWidth(93);
		tableColumn_2.setText("姓名");
		
		 tableColumn_3 = new TableColumn(table_2, SWT.NONE);
		tableColumn_3.setWidth(58);
		tableColumn_3.setText("性别");
		
		 tableColumn_4 = new TableColumn(table_2, SWT.NONE);
		tableColumn_4.setWidth(84);
		tableColumn_4.setText("入住人数");
		
		 tableColumn_5 = new TableColumn(table_2, SWT.NONE);
		tableColumn_5.setWidth(79);
		tableColumn_5.setText("预住天数");
		
		tblclmnid = new TableColumn(table_2, SWT.NONE);
		tblclmnid.setText("房间id号");
		tblclmnid.setWidth(75);
		
		tableColumn_6 = new TableColumn(table_2, SWT.NONE);
		tableColumn_6.setWidth(138);
		tableColumn_6.setText("入住时间");
		
		tableColumn_21 = new TableColumn(table_2, SWT.NONE);
		tableColumn_21.setWidth(126);
		tableColumn_21.setText("退房时间");
		
		tblclmnNewColumn = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn.setWidth(84);
		tblclmnNewColumn.setText("押金");
		
		tblclmnNewColumn_1 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_1.setWidth(91);
		tblclmnNewColumn_1.setText("状态");
		
		tableColumn_22 = new TableColumn(table_2, SWT.NONE);
		tableColumn_22.setWidth(83);
		tableColumn_22.setText("总价");
		
		Button button = new Button(composite_4, SWT.NONE);
		
		button.setBounds(855, 401, 98, 30);
		button.setText("结 账");
		
		label_17 = new Label(composite_4, SWT.NONE);
		label_17.setBounds(129, 411, 76, 20);
		
		DateTime dateTime = new DateTime(composite_4, SWT.BORDER);
		dateTime.setBounds(804, 7, 149, 28);
		
		Composite composite_5 = new Composite(composite_1, SWT.NONE);
		
		combo = new Combo(composite_3, SWT.NONE);
		combo.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		combo.setBounds(741, 10, 120, 28);
		combo.setText("类型");
		
		Button btnNewButton = new Button(composite_3, SWT.NONE);
		
		btnNewButton.setBounds(856, 395, 98, 30);
		btnNewButton.setText("查 询");
		
		table_1 = new Table(composite_5, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		table_1.setBounds(27, 38, 941, 389);
		
	   tblclmnPic = new TableColumn(table_1, SWT.NONE);
	   tblclmnPic.setText("房间");
		tblclmnPic.setWidth(325);
		
		tableColumn_15 = new TableColumn(table_1, SWT.NONE);
		tableColumn_15.setWidth(378);
		tableColumn_15.setText("房间号");
		
		 tableColumn_16 = new TableColumn(table_1, SWT.NONE);
		tableColumn_16.setWidth(229);
		tableColumn_16.setText("房间状态");
		
		
		composite_6.setBackgroundMode(SWT.INHERIT_FORCE);
		
		Label label_10 = new Label(composite_6, SWT.NONE);
		label_10.setFont(SWTResourceManager.getFont("华文楷体", 15, SWT.NORMAL));
		label_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_10.setText("尊敬的用户您好：\r\n1.请各位客人尽量自带洗漱用具。\r\n2.外出请清点自我的物品，随时欢迎您回家。\r\n3.欢迎光临，请注意保管好你的随身物品，请不好随地乱扔垃圾。\r\n4.为了您的健康和安全，请不好在客房进行黄赌毒。\r\n5.外出请清点自我的物品。\r\n6.为了您的财产安全，请自行妥善保管好您随身的贵重物品，如有遗失，本酒店概不负责!\r\n7.请勿在床上吸烟，注意防火防盗。爱护房间设施，损坏赔偿!\r\n8.为了您的财产安全，请自行妥善保管好您随身的贵重物品。\r\n9.为了您的健康和安全，请不好在客房进行黄赌毒等违法活动。\r\n\r\n\r\n");
		label_10.setBounds(76, 41, 726, 284);
		
		composite_7 = new Composite(composite_1, SWT.NONE);
		
		lblNewLabel_2 = new Label(composite_7, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("华文楷体", 12, SWT.NORMAL));
		lblNewLabel_2.setBounds(80, 39, 113, 20);
		lblNewLabel_2.setText("本人身份证：");
		
		label_13 = new Label(composite_7, SWT.NONE);
		label_13.setText("本人姓名：");
		label_13.setFont(SWTResourceManager.getFont("华文楷体", 12, SWT.NORMAL));
		label_13.setBounds(80, 90, 113, 20);
		
		label_14 = new Label(composite_7, SWT.NONE);
		label_14.setText("性别：");
		label_14.setFont(SWTResourceManager.getFont("华文楷体", 12, SWT.NORMAL));
		label_14.setBounds(80, 143, 113, 20);
		
		label_15 = new Label(composite_7, SWT.NONE);
		label_15.setText("入住人数：");
		label_15.setFont(SWTResourceManager.getFont("华文楷体", 12, SWT.NORMAL));
		label_15.setBounds(80, 196, 113, 20);
		
		label_16 = new Label(composite_7, SWT.NONE);
		label_16.setText("预住天数：");
		label_16.setFont(SWTResourceManager.getFont("华文楷体", 12, SWT.NORMAL));
		label_16.setBounds(81, 294, 113, 20);
		
		label_18 = new Label(composite_7, SWT.NONE);
		label_18.setText("入住房间号：");
		label_18.setFont(SWTResourceManager.getFont("华文楷体", 12, SWT.NORMAL));
		label_18.setBounds(78, 246, 113, 20);
		
		text_1 = new Text(composite_7, SWT.BORDER);
		text_1.setBounds(200, 39, 173, 26);
		
		text_2 = new Text(composite_7, SWT.BORDER);
		text_2.setBounds(200, 84, 173, 26);
		
		text_3 = new Text(composite_7, SWT.BORDER);
		text_3.setText("男");
		text_3.setBounds(199, 137, 44, 26);
		
		text_4 = new Text(composite_7, SWT.BORDER);
		text_4.setText("1");
		text_4.setBounds(199, 196, 173, 26);
		
		text_5 = new Text(composite_7, SWT.BORDER);
		text_5.setBounds(197, 240, 173, 26);
		
		text_6 = new Text(composite_7, SWT.BORDER);
		text_6.setText("1");
		text_6.setBounds(200, 288, 173, 26);
		
		button_2 = new Button(composite_7, SWT.NONE);
		
		button_2.setBounds(653, 90, 98, 30);
		button_2.setText("返回主菜单");
		
		btnNewButton_1 = new Button(composite_7, SWT.NONE);
		
		btnNewButton_1.setBounds(653, 290, 98, 30);
		btnNewButton_1.setText("确认入住");
		
		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont("华文行楷", 10, SWT.NORMAL));
		label_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_4.setBounds(460, 38, 76, 20);
		
		label_7 = new Label(composite, SWT.NONE);
		
		label_7.setBounds(916, 52, 76, 20);
		label_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		label_7.setText("注销用户");
		Composite composite_2 = new Composite(sashForm, SWT.NONE);
		composite_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		
		Label lblNewLabel = new Label(composite_2, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		lblNewLabel.setFont(SWTResourceManager.getFont("华文行楷", 15, SWT.NORMAL));
		lblNewLabel.setBounds(351, 10, 184, 20);
		lblNewLabel.setText("@ LWX版权所有");
		
		label_11 = new Label(composite_2, SWT.NONE);
		
		label_11.setFont(SWTResourceManager.getFont("华文楷体", 13, SWT.NORMAL));
		label_11.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_11.setBounds(38, 10, 113, 20);
		label_11.setText("温馨提示");
		
		sashForm.setWeights(new int[] {82, 461, 50});
		//未登录不能进入界面
		if("".equals(Data.lwsusername)){
			shlLwx.dispose();
			LoginUI login =new LoginUI();
			login.open();
		}
		//点击表格事件
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem ti = (TableItem)e.item;
				//将数据显示下去
				r_number = Integer.parseInt(ti.getText(2));
				r_state  = ti.getText(4);	
				roomid = Integer.parseInt(ti.getText(0));
				text_5.setText(ti.getText(0));
				
				choosenType = ti.getText(1);
			}
		});
		table_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem ti = (TableItem)e.item;
				//将数据显示下去
				roomid= Integer.parseInt(ti.getText(6));
				in_room = Integer.parseInt(ti.getText(6));
				out_time = ti.getText(8);
				label_17.setText(ti.getText(11));
			}
		});
		       
		//温馨提示
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				stackLayout.topControl = composite_6;
				composite_5.setVisible(false);
			    composite_4.setVisible(false);
			    composite_3.setVisible(false);
			    composite_6.setVisible(true);
			    composite_7.setVisible(false);
			}
		});
		
		
		
		//入住label变色
		lblNewLabel_1.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				lblNewLabel_1.setImage(SWTResourceManager.getImage(Index.class, "/image/入住(1).png"));
				label_1.setText("入住");			}
			@Override
			public void mouseExit(MouseEvent e) {
				lblNewLabel_1.setImage(SWTResourceManager.getImage(Index.class, "/image/入住.png"));
			    label_1.setText("");
			}
		});
		//查询label变色
		label.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label.setImage(SWTResourceManager.getImage(Index.class, "/image/查询.png"));
			    
			    label_2.setText("查询");
			}
			@Override
			public void mouseExit(MouseEvent e) {
				label.setImage(SWTResourceManager.getImage(Index.class, "/image/查询(1).png"));
				  label_2.setText("");
			}
		});
		//离店label变色
		label_3.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				label_3.setImage(SWTResourceManager.getImage(Index.class, "/image/离店(2).png"));
				label_4.setText("离店");
			}
			@Override
			public void mouseExit(MouseEvent e) {
				label_3.setImage(SWTResourceManager.getImage(Index.class, "/image/离店.png"));
				label_4.setText("");
			}
		});
		//		stackLayout.topControl = composite_3;
		//		composite_5.setVisible(false);
		//		composite_4.setVisible(false);
		//		composite_3.setVisible(true);
		 //点击入住label事件
				lblNewLabel_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						stackLayout.topControl = composite_3;
						composite_5.setVisible(false);
					    composite_4.setVisible(false);
					    composite_3.setVisible(true);
					    composite_6.setVisible(false);
					    composite_7.setVisible(false);
					    addCombo();
					    showRoom();
					}
				});
				//点击离店label事件
				label_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						stackLayout.topControl = composite_4;
						composite_5.setVisible(false);
					    composite_4.setVisible(true);
					    composite_3.setVisible(false);
					    composite_6.setVisible(false);
					    composite_7.setVisible(false);
					    
					    leaveHotel();
					    
					    
					}
				});
				//查询label点击事件
				label.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						stackLayout.topControl = composite_5;
						composite_5.setVisible(true);
					    composite_4.setVisible(false);
					    composite_3.setVisible(false);
					    composite_6.setVisible(false);
					    composite_7.setVisible(false);
					    
					    
					    //sql语句
					    String sql = "select * from roominfo";
					    //执行
					    List<Map<String,String>> list = db.queryAll(sql);
					    
					    for(int i = 0; i<list.size(); i++){
					    	TableItem ti = new TableItem(table_1,SWT.NONE);
					    	
					    	ti.setText(new String[]{
					    			list.get(i).get("roomid"),list.get(i).get("r_number"),
					    			list.get(i).get("r_state")
					    	});
					    }
					    
					}
				});
				//选择点击事件
				button_1.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						
						
						stackLayout.topControl = composite_7;
						composite_5.setVisible(false);
					    composite_4.setVisible(false);
					    composite_3.setVisible(false);
					    composite_6.setVisible(false);
					    composite_7.setVisible(true);
					}
				});
				/**
				 * 返回主菜单
				 */
				button_2.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						stackLayout.topControl = composite_3;
						composite_5.setVisible(false);
					    composite_4.setVisible(false);
					    composite_3.setVisible(true);
					    composite_6.setVisible(false);
					    composite_7.setVisible(false);
						
					}
				});
				/**
				 * 确认入住按钮
				 */
				btnNewButton_1.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						in_sfz = text_1.getText();
						in_sex = text_3.getText();
						in_pnumber=Integer.parseInt(text_4.getText());
						in_day = Integer.parseInt(text_6.getText());
						in_room = Integer.parseInt(text_5.getText());
						in_name  = text_2.getText();
						
						//sql
						String sql1 = "select * from roomtype where r_type = ?";
						List<Map<String, String>> list = db.queryAll(sql1, choosenType);
						String status = list.get(0).get("status");
						System.out.println(status);
						
						
						if(text_1.getText().equals("")){
							mu.alter(shlLwx, "提示信息", "身份证不能为空");
							return;
						}else if(in_sfz.length()<18){
							mu.alter(shlLwx, "提示信息", "请输入正确的身份证");
							return;
						}else{
						
						
						if(text_2.getText().equals("")){
							mu.alter(shlLwx, "提示信息", "姓名不能为空");
							return;
						}else if(in_name.length()<2){
							mu.alter(shlLwx, "提示信息", "请输入正确的姓名");
							return;
						}else{
						if( "".equals(r_number)){
							mu.alter (shlLwx,"提示信息", "请先选择您要入住的房间");
							return;
						}
						if("已入住".equals(r_state)){
							mu.alter(shlLwx, "提示信息","抱歉，已被其他人抢先一步");
							return;
						}
						if(!"男".equals(in_sex) && !"女".equals(in_sex) ){
							mu.alter(shlLwx, "提示信息","请输入正确的性别。。。");
							return;
						}
						if("3".equals(status) || "2".equals(status) ){
							mu.alter(shlLwx, "提示信息","该房间暂时不可用。。。");
							return;	
						}
						
						SimpleDateFormat sdf=new SimpleDateFormat ("YYYY-MM-dd") ;
						String times=sdf.format (new Date()) ;
						
						String sql = "insert into innerinfo values(innerinfo_in_number.nextval,?,?,?,?,?,?,to_date(?,'yyyy-mm-dd '),null,100,'已入住')";
					int result =db.doUpdate(sql,in_sfz,in_name,in_sex,in_pnumber,in_day,roomid,times);
						if(result>0){
							mu.alter(shlLwx, "提示信息", "入住成功");
							String sql2 = "update roominfo  set r_state ='已入住'  where roomid =?";
							db.doUpdate(sql2, roomid);
							mu.alter(shlLwx, "提示信息", "请扫码支付押金100元");
							zfb zfb =new zfb();
							zfb.open();
							mu.alter(shlLwx, "提示信息", "已支付押金");
							showRoom();
							composite_5.setVisible(false);
						    composite_4.setVisible(false);
						    composite_3.setVisible(true);
						    composite_6.setVisible(false);
						    composite_7.setVisible(false);
                            
						}else{
							mu.alter(shlLwx, "提示信息", "请稍后再试");
						}
						}
					}
				}
				});
				//结账按钮
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						Closing();
				  
					}
				});
				//查看房间详细信息点击事件
				mi1.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						RoomInfo roominfo = new RoomInfo();
						shlLwx.dispose();
						roominfo.open();
					}
					
				});
				btnNewButton.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						query();
					
					}
				});
				
				//注销登录
				label_7.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						LoginUI login = new LoginUI();
						mu.alter(shlLwx, "提示信息","您正在退出登录。。。" );
						try {
							Thread.sleep(3000);
						
						shlLwx.dispose();
						login.open();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
	
	}

	
	   
	

	//查询
	protected void query() {
		table.removeAll();
		r_type = combo.getText();
		String sql = "select * from roominfo ,roomtype  where roominfo.r_type_id= roomtype.roomtypeid  ";
		
		if(!"所有类别".equals(r_type)){
			sql+=" and r_type ='"+r_type+"'";
		}
		List<Map<String, String>> list = db.queryAll(sql);
		if(list.size()>0){
			for(int i = 0;i<list.size();i++){
				TableItem ti = new TableItem(table,SWT.NONE);
				String status = "";
				if(list.get(i).get("status").equals("1")){
					status = "可用";
				}else if(list.get(i).get("status").equals("2")){
					status = "升级中";
				}else{
					status = "不可用";
				}
			
				ti.setText(new String[]{
						list.get(i).get("roomid"),list.get(i).get("r_type"),
						list.get(i).get("r_number"),list.get(i).get("r_location"),
						list.get(i).get("r_state"),list.get(i).get("r_call"),
						list.get(i).get("r_remark"),status+""
				});
		}
				
		}
		}
		
	

	//combo添加类别
	protected void addCombo() {
		String sql = "select * from roomtype";
		List<Map<String, String>> list = db.queryAll(sql);
		String[] str = new String[list.size() + 1];
		//给combo添加一个查询所有类的选项
		str[0]="所有类别";
		for(int i = 0;i<list.size();i++){
		str[i+1] = list.get(i).get("r_type");
		}
		combo.setItems(str);
		combo.select(0);
		
	}
//支付结账
	protected void Closing() {
       
		if( "".equals(roomid)){
			mu.alter (shlLwx,"提示信息", "请先选择您要离开的房间");
			return;
		}
		
		String sql1 = "select in_time,roomid,out_time,r_price,sysdate-in_time as distime from roomtype ,innerinfo,roominfo "
				+ "where  roominfo.r_type_id = roomtype.roomtypeid and innerinfo.in_room=roominfo.roomid and roomtypeid= ?";
		List<Map<String, String>> list =  db.queryAll(sql1,Data.roomtypeid);
		for(int i = 0;i<list.size();i++){
			TableItem ti = new TableItem(table_2,SWT.NONE);
			//开始设值
			ti.setText(6,list.get(i).get("roomid"));
			 String btime= list.get(i).get("in_time");
			  btime = btime.substring(0,btime.indexOf(" "));
			  String rtime= list.get(i).get("out_time");
			  rtime = rtime.substring(0,rtime.indexOf(" "));
			  String money = list.get(i).get("r_price");
			  String distime = list.get(i).get("distime");
			  if(Double.parseDouble(distime)<=1){
				  distime = "1";
			  }else{
				  distime =(int)(Double.parseDouble(distime) * 100 )/100.0+"";
				  
			  }
			  BigDecimal b1 = new BigDecimal(money);
			  BigDecimal b2 = new BigDecimal(distime);
	          ti.setText(11,b1.multiply(b2).doubleValue()+"");
		    }     
		double moneys =Double.parseDouble(label_17.getText());
		double m = moneys-100;
		if(m>=0){
			mu.alter(shlLwx, "提示信息", "请扫码支付"+m+"元。。。");
		}else{
			double a = 0-m;
			mu.alter(shlLwx, "提示信息", "退还押金100元，减去房费还给您"+a+"元。。。");
		}
		
		//打开zfb界面
		zfb zfb =new zfb();
		zfb.open();
		Runnable rr = new Runnable(){
             
			@Override
			public void run() {
				
				while (true){
					Display.getDefault().asyncExec(new Runnable(){
 
						@Override
						public void run() {
							// TODO Auto-generated method stub
							if(Data.flag){
								
								Data.flag = false;
								String sql = "update innerinfo set in_state='已结账' ,out_time = to_date(?,'yyyy-mm-dd ') where in_room = ? ";
							
								SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
								String times = sdf.format(new Date());
								int result = db.doUpdate(sql,times,in_room);
								
								if(result>0  ){
									mu.alter(shlLwx, "提示信息", "支付成功");
									outinnerinfo();
									leaveHotel();
								}else{
									mu.alter(shlLwx, "提示信息", "支付失败");
								}
								
							   dd.stop();
							}
						}
						});
				}
			}
			 
		 };
		 dd = new Thread(rr);
		 dd.start();
		
	    
		
	}
//离店
	protected void leaveHotel() {
		table_2.removeAll();
		String sql = "select * from roominfo ,roomtype ,innerinfo where roominfo.r_type_id= roomtype.roomtypeid  and innerinfo.in_room = roominfo.roomid";
				
		List<Map<String, String>> list = db.queryAll(sql);
		if(list.size()>0){
			for(int i = 0;i<list.size();i++){
				TableItem ti = new TableItem(table_2,SWT.NONE);
			   
				ti.setText(new String[]{
						list.get(i).get("in_number"),list.get(i).get("in_sfz"),
						list.get(i).get("in_name"),list.get(i).get("in_sex"),
						list.get(i).get("in_pnumber"),list.get(i).get("in_day"),
						list.get(i).get("in_room"),list.get(i).get("in_time"),
						list.get(i).get("out_time"),list.get(i).get("in_foregift"),
						list.get(i).get("in_state"),list.get(i).get("r_price")+""
				});
//				Double money = Double.parseDouble(list.get(i).get("r_price"));
//				  //天数 
//				  String distime = list.get(i).get("distime");
//				  if(Double.parseDouble(distime)<=1){
//					  distime = "1";
//				  }else{
//					  distime =(int)(Double.parseDouble(distime) * 100 )/100.0+"";
//					  
//				  }
			
				
		}
		}
		
	}


   //结账之后信息变回
   protected void outinnerinfo() {
	   table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem ti = (TableItem)e.item;
				//将数据显示下去
				roomid= Integer.parseInt(ti.getText(0));
				
			}
		});
		String sql = "update roominfo set r_state='空房' where roomid = ?  ";
	          db.doUpdate(sql, roomid);
	
	}
	//房间信息录入
	protected void showRoom(){
		table.removeAll();
		String sql = "select * from roominfo ,roomtype where roominfo.r_type_id= roomtype.roomtypeid ";
				
		List<Map<String, String>> list =   db.queryAll(sql);
		if(list.size()>0){
			for(int i = 0;i<list.size();i++){
				TableItem ti = new TableItem(table,SWT.NONE);
				String status = "";
				if(list.get(i).get("status").equals("1")){
					status = "可用";
				}else if(list.get(i).get("status").equals("2")){
					status = "升级中";
				}else{
					status = "不可用";
				}
				ti.setText(new String[]{
						list.get(i).get("roomid"),list.get(i).get("r_type"),
						list.get(i).get("r_number"),list.get(i).get("r_location"),
						list.get(i).get("r_state"),list.get(i).get("r_call"),
						list.get(i).get("r_remark"),status+""
				});
		}
		}
		
	}
	}

