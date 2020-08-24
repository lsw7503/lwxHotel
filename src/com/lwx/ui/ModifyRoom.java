package com.lwx.ui;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.lwx.dao.DBHelper;
import com.lwx.util.Data;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Combo;

public class ModifyRoom {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	//数据库帮助类 
	private DBHelper db = new DBHelper();
	//房间类型编号
	private String typeid = "";
	//房间类型
	private String roomtype = ""; 
	//选择房间类型的combo
	private Combo combo = null;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ModifyRoom window = new ModifyRoom();
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
		shell.setSize(370, 628);
		shell.setText("修改房间信息");
		// 居中
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		label.setBounds(118, 10, 152, 22);
		label.setText("请修改相关信息");
		
		Label lblid = new Label(shell, SWT.NONE);
		lblid.setBounds(39, 51, 60, 20);
		lblid.setText("房间ID：");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("房间号：");
		label_1.setBounds(39, 113, 60, 20);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(39, 166, 76, 20);
		label_2.setText("房间电话：");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(39, 226, 76, 20);
		label_3.setText("房间床位：");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(39, 278, 76, 20);
		label_4.setText("房间价格：");
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setBounds(39, 332, 76, 20);
		label_5.setText("押金：");
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(39, 390, 76, 20);
		label_6.setText("房间描述：");
		
		text = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text.setBounds(118, 49, 152, 26);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(118, 109, 152, 26);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(118, 163, 152, 26);
		
		text_3 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_3.setBounds(118, 223, 152, 26);
		
		text_4 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_4.setBounds(118, 275, 152, 26);
		
		text_5 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_5.setBounds(118, 329, 152, 26);
		
		text_6 = new Text(shell, SWT.BORDER | SWT.READ_ONLY );
		text_6.setBounds(118, 387, 152, 26);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(118, 536, 98, 30);
		button.setText("确认修改");
		
		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setBounds(39, 444, 76, 20);
		label_7.setText("房间类型：");
		
		combo = new Combo(shell, SWT.NONE);
		combo.setBounds(118, 438, 152, 28);
		
		Label label_8 = new Label(shell, SWT.NONE);
		label_8.setText("房间状态：");
		label_8.setBounds(39, 497, 76, 20);
		
		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setBounds(118, 493, 142, 28);
		
		
		//确认修改按钮的点击事件
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//任意一个修改后的数据都不能为空
				if( "".equals(text_1.getText()) || "".equals(text_2.getText()) || "".equals(text_3.getText())
						|| "".equals(text_4.getText()) || "".equals(text_5.getText())
						|| "".equals(text_6.getText()) || "".equals(combo.getText()))
				{
					MessageDialog.openInformation(shell, "提示", "您所输入的信息不正确,请重新输入");
					return;
				}
				
				
				//先得到点击该按钮时各个列表中的数据
				String roomid = text.getText();//
				String r_number = text_1.getText();//
				String r_call = text_2.getText();//
				String r_bed = text_3.getText();////
				String r_price = text_4.getText();////
				String r_foregift = text_5.getText();////
				String r_remark = text_6.getText();//
				String rtype = combo.getText();
				String typeid = getTypeid(rtype);
				
				//sql语句
				String sql = "update roominfo set r_number = ?, r_call = ?, r_remark = ?, r_type_id = ? where roomid = ?";
				String sql2 = "update roomtype set r_bed = ?, r_price = ?, r_foregift=? where roomtypeid = ?";
				//执行sql语句  
				int result = db.doUpdate(sql, r_number, r_call, r_remark, typeid, roomid);
				int result2 = db.doUpdate(sql2, r_bed, r_price, r_foregift, typeid);
				if(result > 0 && result2 >0){
					MessageDialog.openInformation(shell, "提示", "修改成功");
					Data.modifyRoomID = "";
					shell.dispose();
				}else{
					MessageDialog.openInformation(shell, "提示", "修改失败");
					return;
				}
				
			}
		});
		
		
		//text的获得焦点事件  用于实现在启动窗口时直接通过Data.modifyRoomID得到数据
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//先得到所有数据
				//执行sql语句
				String sql = "select roomid,r_number,r_call,r_bed,r_price,r_foregift,roominfo.r_remark,r_state,r_type,roomtypeid "
						+ " from roominfo,roomtype" 
                             +" where roomid = ? and r_type_id = roomtypeid ";
				List<Map<String, String>> list= db.queryAll(sql, Data.modifyRoomID);
				//如果查询失败
				if(list == null || list.size() <= 0){
					MessageDialog.openInformation(shell, "提示", "");
				}
			
				// 将数据存入文本框中
				text.setText(list.get(0).get("roomid"));
				text_1.setText(list.get(0).get("r_number"));
				text_2.setText(list.get(0).get("r_call"));
				text_3.setText(list.get(0).get("r_bed"));
				text_4.setText(list.get(0).get("r_price"));
				text_5.setText(list.get(0).get("r_foregift"));
				text_6.setText(list.get(0).get("r_remark"));
				typeid = list.get(0).get("roomtypeid");
				
				//将房间类型名字存入到combo中
				String sql2 = "select * from roomtype";
				List<Map<String, String>> list2 = db.queryAll(sql2);
				//数组  存放类型名 
				String[] str = new String[list2.size()];//+1 加一个默认的类型
	
				//循环  添加内容
				for(int i = 0; i<list2.size(); i++){
					str[i] = list2.get(i).get("r_type");
				}
				combo.setItems(str);

			}
		});
	}
	
	//通过类型名得到类型编号
	protected String getTypeid(String typeName){
		//sql语句
		String sql = "select roomtypeid from roomtype where r_type = ?";
		List<Map<String, String>> list = db.queryAll(sql, typeName);
		String typeid = list.get(0).get("roomtypeid");
		return typeid;
	}
	
}













