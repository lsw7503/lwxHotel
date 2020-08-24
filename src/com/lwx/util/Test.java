package com.lwx.util;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

import com.lwx.dao.DBHelper;

import org.eclipse.swt.widgets.Label;

public class Test {

	protected Shell shell;
	private String filePath ;
	private Text text;
	private Text text_1;
	private static DBHelper db = new DBHelper();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Test window = new Test();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnXuanzhetupian = new Button(shell, SWT.NONE);
		
		btnXuanzhetupian.setBounds(301, 186, 98, 30);
		btnXuanzhetupian.setText("xuanzhetupian");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(301, 110, 98, 30);
		btnNewButton.setText("New Button");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(32, 41, 73, 26);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(32, 94, 73, 26);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(32, 162, 73, 39);
		btnXuanzhetupian.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell);
				//对选择文件后缀名进行设定
				fd.setFilterExtensions(new String[]{"*"});
				//打开文件选择框
				fd.open();
				
				//得到选中的文件  判断文件选择框是否没打开  是否有选择文件
				if( fd != null && !"".equals(fd.getFileName())){
					filePath = fd.getFilterPath() + "\\" + fd.getFileName();
				}
			}
		});
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//判断文件是否为空
				if( filePath == null || "".equals(filePath)){
					return; 
				}
				
				//得到数据
			
				String p_state = text_1.getText();
				
				//通过路径得到io流 
				File f = new File(filePath);
				if(f.exists()){
					//得到文件大小
					//格式化文件大小 
					DecimalFormat df = new DecimalFormat("0.00");//如3.45m
					String size = df.format(f.length()/1024/1024.0);//最后一定要除以1024.0 
					
					//得到io流
					try {
						InputStream is = new FileInputStream(f);
						byte[] bs = new byte[is.available()];
						
						//开始读取数据
						is.read(bs);	//将数据读进bs
						is.close();
						
						//执行sql语句
						String sql = "insert into picroom values(?,picroom_picid.nextval,'空房')";
						int result = db.doUpdate(sql,bs);
						
						if(result > 0){
							MessageDialog.openInformation(shell, "提示", "添加成功");
						}
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
