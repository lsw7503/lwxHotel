package com.lwx.ui;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.lwx.dao.DBHelper;
import com.lwx.util.Data;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;

public class ModifyRoomType {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Combo combo = null;
	//数据库操作帮助对象
	private DBHelper db = new DBHelper();
	private Text text_6;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ModifyRoomType window = new ModifyRoomType();
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
		shell.setSize(410, 586);
		shell.setText("修改房间类型信息");

		// 居中
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);

		Label lblid = new Label(shell, SWT.NONE);
		lblid.setBounds(10, 43, 120, 20);
		lblid.setText("房间类型ID：");
		
		Label label = new Label(shell, SWT.NONE);
		label.setText("房间类型名：");
		label.setBounds(10, 118, 120, 20);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("该类型床位数：");
		label_1.setBounds(10, 190, 120, 20);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("该类型房间价格：");
		label_2.setBounds(10, 259, 120, 20);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("该类型房间押金：");
		label_3.setBounds(10, 330, 120, 20);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("房间类型描述：");
		label_4.setBounds(10, 423, 120, 20);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(136, 42, 258, 26);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(136, 114, 258, 26);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(136, 187, 258, 26);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(136, 256, 258, 26);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(136, 328, 258, 26);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(136, 420, 258, 26);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(136, 511, 98, 30);
		button.setText("确认修改");
		
		combo = new Combo(shell, SWT.NONE);
		combo.setBounds(135, 472, 135, 28);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("房间类型状态：");
		label_5.setBounds(10, 475, 120, 20);
		
		
		//为combo赋值
		String[] str = new String[]{
				"可用","升级中","暂停使用"
		};
		
		combo.setItems(str);
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(10, 381, 120, 20);
		label_6.setText("改类型房间总数：");
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(136, 376, 258, 26);
		
		//因为当打开该窗口是会默认将光标移至text内
		//所以将text 的focus事件用来作为窗口初始化时间
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//sql语句 
				String sql = "select * from roomtype where roomtypeid = ?";
				//执行
				List<Map<String, String>> list = db.queryAll(sql, Data.modifyRoomTypeid);
				
				if(list == null || list.size()<=0){
					MessageDialog.openInformation(shell, "提示", "查询出错");
					return;
				}
				
				//设置数据 
				text.setText(Data.modifyRoomTypeid);
				text_1.setText(list.get(0).get("r_type"));
				text_2.setText(list.get(0).get("r_bed"));
				text_3.setText(list.get(0).get("r_price"));
				text_4.setText(list.get(0).get("r_foregift"));
				text_6.setText(list.get(0).get("r_all"));
				text_5.setText(list.get(0).get("r_remark"));
			}
		});
		
		
		//确认修改点击事件
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//先判断数据是否正确 
				if( "".equals(text.getText()) || "".equals(text_1.getText()) || "".equals(text_2.getText())
						|| "".equals(text_3.getText()) || "".equals(text_4.getText()) || "".equals(text_5.getText()))
				{
					MessageDialog.openInformation(shell, "提示", "您输入的信息有误");
					return;
				}
				
				//得到数据
				String id = text.getText();
				String name = text_1.getText();
				String bed = text_2.getText();
				String price = text_3.getText();
				String foregift = text_4.getText();
				String all = text_4.getText();
				String remark = text_5.getText();
				int status;
				if( "可用".equals(combo.getText())){
					status = 1;
				}else if("升级中".equals(combo.getText())){
					status = 2;
				}else{
					//暂停服务
					status= 3;
				}
				//sql语句
				String sql = "update roomtype set r_type=?, r_price=?, r_foregift=?, r_all = ? , r_remark=?, status = ? where roomtypeid = ?";
				int result = db.doUpdate(sql,name,price,foregift,all,remark,status,id);
				if(result > 0){
					MessageDialog.openInformation(shell, "提示 ", "信息先修改成功");
					shell.dispose();
				}else{
					MessageDialog.openInformation(shell, "提示", "信息修改失败");
					return;
				}
			}
		});
	}
}














