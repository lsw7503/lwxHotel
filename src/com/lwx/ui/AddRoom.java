package com.lwx.ui;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.lwx.dao.DBHelper;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AddRoom {

	protected Shell shell;
	//数据库帮助对象
	private DBHelper db = new DBHelper();
	//存放房间类型的combo
	private Combo combo = null;
	private Text text;
	//存放楼层的combo
	private Combo combo_1 = null;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AddRoom window = new AddRoom();
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
		shell.setImage(SWTResourceManager.getImage(AddRoom.class, "/image/酒店.png"));
		shell.setSize(428, 542);
		shell.setText("新建房间");
		// 居中
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(28, 33, 100, 20);
		label.setText("房间类型：");
		
		combo = new Combo(shell, SWT.NONE);
		combo.setBounds(134, 27, 195, 28);
		
		combo.setItems( getRname());
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("房间号：");
		label_1.setBounds(28, 98, 100, 20);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(134, 94, 195, 26);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(28, 167, 76, 20);
		label_2.setText("楼层：");
		
		combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setBounds(134, 160, 195, 28);
		
		combo_1.setItems(new String[]{
				"一楼","二楼","三楼","四楼","五楼","六楼"
		});
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("房间状态：");
		label_3.setBounds(28, 231, 76, 20);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_1.setBounds(134, 227, 195, 26);
		
		text_1.setText("空房");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("房间电话：");
		label_4.setBounds(28, 294, 76, 20);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(134, 289, 195, 26);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("房间描述：");
		label_5.setBounds(28, 354, 76, 20);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(134, 349, 195, 26);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(143, 429, 98, 30);
		button.setText("确认添加");
		
		
		//确认添加按钮的点击事件
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//先判断数据是否合法
				if("".equals(combo.getText()) || "".equals(combo_1.getText())
						|| "".equals(text.getText()) || "".equals(text_2.getText())
						|| "".equals(text_3.getText()))
				{
					MessageDialog.openInformation(shell, "提示", "输入的信息不能为空");
					return;
				}
				
				//得到数据
				String rid = getRid(combo.getText());
				String rnumber = text.getText();
				String r_location = combo_1.getText();
				String status = text_1.getText();
				String call = text_2.getText();
				String remark = text_3.getText();
				
				
				//sql语句
				String sql = "insert into roominfo values(roominfo_roomid.nextval, ?, ?, ?, ?,?, ?)";
				//执行sql语句
				int result = db.doUpdate(sql, rid,rnumber,r_location,status,call,remark);
				if( result > 0){
					MessageDialog.openInformation(shell, "提示", "房间添加成功");
					shell.dispose();
				}else{
					MessageDialog.openInformation(shell, "提示", "房间添加失败");
					return;
				}
			}
		});
		
		
		
	}
	
	
	//得到类型名的方法
	protected String[] getRname(){
		//sql语句
		String sql = "select * from roomtype";
		List<Map<String, String>> list = db.queryAll(sql);
		
		if(list == null || list.size() <= 0 ){
			MessageDialog.openInformation(shell, "提示", "数据类型添加失败");
			return null;
		}
		
		String[] str = new String[list.size()];
		for(int i = 0; i<list.size();i++){
			str[i] = list.get(i).get("r_type");
		}
		return str;
	}
	
	
	//根据类型名得到id的方法
	protected String getRid(String rname){
		//sql语句
		String sql = "select * from roomtype where r_type = ?";
		//执行
		List<Map<String, String>> list = db.queryAll(sql, rname);
		return list.get(0).get("roomtypeid");
	}
}













