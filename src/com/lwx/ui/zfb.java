package com.lwx.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.lwx.util.Data;
import com.lwx.util.MyUtil;


public class zfb {

	protected Shell shell;
public static MyUtil mu = new MyUtil();
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			zfb window = new zfb();
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
		shell = new Shell(SWT.NO_TRIM | SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM);
		shell.setBackgroundImage(SWTResourceManager.getImage(zfb.class, "/image/zfb.jpg"));
		shell.setImage(SWTResourceManager.getImage(zfb.class, "/image/zfb.jpg"));
		shell.setSize(511, 707);
		mu.centerShell(shell);
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Display.getDefault().asyncExec(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Data.flag = true;
						shell.dispose();
					}});
			}}).start();

	}

}
