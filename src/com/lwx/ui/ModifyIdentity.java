package com.lwx.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import com.lwx.dao.DBHelper;
import com.lwx.util.Data;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ModifyIdentity {

	protected Shell shell;
	//数据库操作帮助对象
	private DBHelper db = new DBHelper();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ModifyIdentity window = new ModifyIdentity();
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
		shell.setSize(484, 250);
		shell.setText("修改权限");
		// 居中
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		label.setBounds(142, 46, 201, 22);
		label.setText("请选择将要修改成的权限");
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(117, 139, 98, 30);
		button.setText("用户");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setText("管理员");
		button_1.setBounds(262, 139, 98, 30);
		
		
		//修改成用户的按钮的点击事件
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//sql语句
				String sql = "update lwsUser set status = 0 where lwsuserid = ?";
				//执行sql语句
				int result = db.doUpdate(sql, Data.modifyUserID);
				if(result > 0){
					MessageDialog.openInformation(shell, "提示", "修改权限成功");
					Data.modifyUserID = "";
					shell.dispose();
					
				}
			}
		});
		
		//修改为管理员的点击事件
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//sql语句
				String sql = "update lwsUser set status = 1 where lwsuserid = ?";
				int result = db.doUpdate(sql, Data.modifyUserID);
				if(result > 0){
					MessageDialog.openInformation(shell, "提示", "修改权限成功");
					shell.dispose();
					
				}
			}
		});

	}
}

























