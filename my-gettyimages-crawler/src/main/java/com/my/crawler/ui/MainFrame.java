package com.my.crawler.ui;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.my.crawler.model.Downloader;

public class MainFrame {
	private Shell parentShell;

	private Text urlText;
	private Text pathText;

	private Text consoleText;
	private Button okButton;

	public MainFrame(Shell shell) {
		this.parentShell = shell;
	}

	public void createContent() {
		parentShell.setText("Getty Images下载器");

		ImageDescriptor imageDescriptor = ImageDescriptor.createFromFile(MainFrame.class, "/group_5_copy.png");
		parentShell.setImage(imageDescriptor.createImage());
		GridLayout shellLayout = new GridLayout();
		shellLayout.marginHeight = 0;
		shellLayout.marginWidth = 0;
		parentShell.setLayout(shellLayout);

		Composite mainComposite = new Composite(parentShell, SWT.NONE);
		mainComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout mainLayout = new GridLayout();
		mainLayout.marginHeight = 0;
		mainLayout.marginWidth = 0;
		mainComposite.setLayout(mainLayout);

		createDialogArea(mainComposite);
		createButtonBar(mainComposite);
	}

	protected void createDialogArea(Composite parent) {
		Composite mainComposite = new Composite(parent, SWT.NONE);
		mainComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		mainComposite.setLayout(new GridLayout(3, false));

		new Label(mainComposite, SWT.NONE).setText("Douban Url: ");
		this.urlText = new Text(mainComposite, SWT.SINGLE | SWT.BORDER);
		GridData urlGD = new GridData(SWT.FILL, SWT.CENTER, true, false);
		urlGD.minimumWidth = 800;
		urlText.setLayoutData(urlGD);
		new Label(mainComposite, SWT.NONE);
		urlText.addModifyListener((e) -> {
			validOk();
		});

		new Label(mainComposite, SWT.NONE).setText("Save Path: ");
		pathText = new Text(mainComposite, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
		pathText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Button browserBtn = new Button(mainComposite, SWT.PUSH);
		browserBtn.setText("Browser");
		browserBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dialog = new DirectoryDialog(e.widget.getDisplay().getActiveShell());
				dialog.setText("选择文件夹");
				dialog.setMessage("选择下载图片保存路径");
				dialog.setFilterPath(new File("").getAbsolutePath());
				String path = dialog.open();
				if (path != null) {
					pathText.setText(path);
					validOk();
				}
			}
		});
		createConsole(mainComposite);
	}

	private void createConsole(Composite mainComposite) {
		Group group = new Group(mainComposite, SWT.SHADOW_OUT);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		group.setLayout(new GridLayout());
		group.setText("Console");
		consoleText = new Text(group, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.H_SCROLL);
		GridData consoleGD = new GridData(SWT.FILL, SWT.FILL, true, true);
		consoleGD.minimumHeight = 400;
		consoleText.setLayoutData(consoleGD);

//		System.setOut(new CommonPrintStream(System.out, consoleText));
//		System.setErr(new ErrorPrintStream(System.err, consoleText));
	}

	private boolean validOk() {
		if (urlText.getText().isEmpty() || pathText.getText().isEmpty()) {
			okButton.setEnabled(false);
			return false;
		} else {
			okButton.setEnabled(true);
			return true;
//			try {
//				if (new URL(urlText.getText()).getHost().equals("www.gettyimages.fr")) {
//					okButton.setEnabled(true);
//					return true;
//				} else {
//					okButton.setEnabled(false);
//					return false;
//				}
//			} catch (Exception e) {
//				okButton.setEnabled(false);
//				return false;
//			}
		}
	}

	protected Control createButtonBar(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
		composite.setLayout(new GridLayout(2, false));

		new Label(composite, SWT.NONE).setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		okButton = new Button(composite, SWT.PUSH);
		okButton.setText("Download");
		GridData okGD = new GridData(GridData.END, GridData.END, false, false);
		okGD.minimumWidth = 100;
		okButton.setLayoutData(okGD);
		validOk();
		okButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!validOk()) {
					return;
				}
				startDownload();
			}
		});

		return composite;
	}

	private void startDownload() {
		this.consoleText.setText("");

		String urlStr = urlText.getText();
		String outputPath = pathText.getText();

		okButton.setEnabled(false);
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(parentShell);
		try {
			dialog.run(true, true, (monitor) -> {
				try {
					URL url = new URL(urlStr);
					File outputFolder = new File(outputPath);
					Downloader downloader = new Downloader(url, outputFolder);
					downloader.startDownload(monitor);
				} catch (MalformedURLException e) {
					System.err.println(e.getMessage());
				}
			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		okButton.setEnabled(true);
	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		MainFrame mainFrame = new MainFrame(shell);
		mainFrame.createContent();

		shell.pack();
		int x = (display.getClientArea().width - shell.getSize().x) / 2;
		int y = (display.getClientArea().height - shell.getSize().y) / 2;
		shell.setLocation(x, y);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

}
