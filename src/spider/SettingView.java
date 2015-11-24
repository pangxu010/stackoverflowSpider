package spider;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JButton;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mysql.jdbc.Constants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

public class SettingView extends JFrame {

	private JPanel contentPane;
	private JTextField key_TextField;
	private JTextField outputFilePath_TextField;
	private JSpinner threadcount_spinner;
	JButton start_Button = null;
	private static Context context;
	private JComboBox tagBox;
	private boolean isRunned = false;
	
	String[] tagContent = {"newest","featured","frequent","votes","active","unanswered"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		context = new Context();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingView frame = new SettingView();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			
		});
	}

	/**
	 * Create the frame.
	 */
	public SettingView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel head_Panel = new JPanel();
		head_Panel.setBounds(284, 10, 158, 35);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.darkShadow"));
		panel.setToolTipText("");
		panel.setForeground(Color.GRAY);
		head_Panel.add(panel);
		contentPane.add(head_Panel);
		
		JLabel lblStackoverflow = new JLabel("StackOverFlow\u5173\u952E\u5B57\u722C\u866B");
		panel.add(lblStackoverflow);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 48, 721, 65);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 20, 1026, 35);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u5173\u952E\u5B57");
		label.setBounds(10, 10, 43, 15);
		panel_1.add(label);
		
		key_TextField = new JTextField();
		key_TextField.setColumns(12);
		key_TextField.setBounds(54, 7, 149, 21);
		panel_1.add(key_TextField);
		key_TextField.setColumns(10);
		
		
		JLabel label_1 = new JLabel("\u7C7B\u578B");
		label_1.setBounds(228, 10, 33, 15);
		panel_1.add(label_1);
		
		
		
		tagBox = new JComboBox(tagContent);
		tagBox.setBounds(278, 10, 65, 20);
		panel_1.add(tagBox);
//		JRadioButton newestRadioButton = new JRadioButton("newest");
//		newestRadioButton.setBounds(268, 6, 121, 23);
//		panel_1.add(newestRadioButton);
//		
//		JRadioButton featuredRadioButton = new JRadioButton("featured");
//		featuredRadioButton.setBounds(392, 6, 121, 23);
//		panel_1.add(featuredRadioButton);
//		
//		JRadioButton frequentRadioButton = new JRadioButton("frequent");
//		frequentRadioButton.setBounds(530, 6, 121, 23);
//		panel_1.add(frequentRadioButton);
//		
//		JRadioButton votesRadioButton = new JRadioButton("votes");
//		votesRadioButton.setBounds(654, 6, 121, 23);
//		panel_1.add(votesRadioButton);
//		
//		JRadioButton activeRadioButton = new JRadioButton("active");
//		activeRadioButton.setBounds(778, 6, 121, 23);
//		panel_1.add(activeRadioButton);
//		
//		JRadioButton unansweredRadioButton = new JRadioButton("unanswered");
//		unansweredRadioButton.setBounds(902, 6, 121, 23);
//		panel_1.add(unansweredRadioButton);
//		
		JLabel label_2 = new JLabel("\u6293\u53D6\u9009\u9879");
		label_2.setBounds(0, 0, 54, 15);
		panel_2.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(10, 123, 721, 65);
		contentPane.add(panel_3);
		
		JLabel label_5 = new JLabel("\u5E76\u53D1\u9009\u9879");
		label_5.setBounds(0, 0, 54, 15);
		panel_3.add(label_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(21, 20, 690, 35);
		panel_3.add(panel_4);
		
		JLabel label_3 = new JLabel("\u7EBF\u7A0B\u6570");
		label_3.setBounds(10, 10, 43, 15);
		panel_4.add(label_3);
		
		threadcount_spinner = new JSpinner();
		
		threadcount_spinner.setBounds(55, 7, 43, 22);
		threadcount_spinner.setValue(50);
		panel_4.add(threadcount_spinner);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(10, 200, 721, 65);
		contentPane.add(panel_5);
		
		JLabel label_4 = new JLabel("\u6587\u4EF6\u9009\u9879");
		label_4.setBounds(0, 0, 54, 15);
		panel_5.add(label_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(21, 20, 690, 35);
		panel_5.add(panel_6);
		
		JLabel label_6 = new JLabel("\u8F93\u51FA\u6587\u4EF6\u8DEF\u5F84");
		label_6.setBounds(10, 10, 77, 15);
		panel_6.add(label_6);


		outputFilePath_TextField = new JTextField();
		outputFilePath_TextField.setBounds(97, 7, 270, 21);
		panel_6.add(outputFilePath_TextField);
		outputFilePath_TextField.setColumns(10);
		
		JButton chooseOutputFilePath_Button = new JButton("选择输出文件路径");
		chooseOutputFilePath_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO chooseOutputFilePath_Button的事件响应
				FileFilter fileFilter = new FileFilter() {

					@Override
					public boolean accept(File f) {
						if (f.isDirectory())
							return true;
						else
							return false;
					}

					@Override
					public String getDescription() {
						return "文件路径";
					}

				};
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(fileFilter);
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.setVisible(true);

				int i = fileChooser.showOpenDialog(getContentPane());
				if (i == fileChooser.APPROVE_OPTION) {
					outputFilePath_TextField.setText(fileChooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		chooseOutputFilePath_Button.setBounds(377, 6, 181, 23);
		
		panel_6.add(chooseOutputFilePath_Button);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(10, 275, 893, 65);
		contentPane.add(panel_7);
		
		
		if(!isRunned){
		start_Button = new JButton("开始抓取");
		start_Button.addActionListener(new StartRunningListener());
		}
		
		start_Button.setBounds(10, 10, 172, 45);
		panel_7.add(start_Button);
		
		JButton gitHub_Button = new JButton("作者GitHub");
		gitHub_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				java.net.URI uri = null;
				try {
					uri = new java.net.URI("https://github.com/Bruce-Du/");
					java.awt.Desktop.getDesktop().browse(uri);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		gitHub_Button.setBounds(374, 10, 172, 45);
		panel_7.add(gitHub_Button);
		
		JButton blog_Button = new JButton("作者博客");
		blog_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				java.net.URI uri = null;
				try {
					uri = new java.net.URI("http://blog.csdn.net/qq_25715511");
					java.awt.Desktop.getDesktop().browse(uri);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		blog_Button.setBounds(192, 10, 172, 45);
		panel_7.add(blog_Button);
		
		JButton advertise_Button = new JButton("反馈建议");
		advertise_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				java.net.URI uri = null;
				try {
					uri = new java.net.URI("http://blog.csdn.net/qq_25715511/article/details/45334429");
					java.awt.Desktop.getDesktop().browse(uri);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
				advertise_Button.setBounds(549, 10, 172, 45);
		panel_7.add(advertise_Button);


		JButton databaseConfig_Button = new JButton("配置数据库");
		databaseConfig_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO 数据库
				new DataBaseConfig(context).setVisible(true);
			}
		});
		databaseConfig_Button.setBounds(721, 10, 172, 45);
		panel_7.add(databaseConfig_Button);


		databaseConfig_Button.setBounds(721, 10, 172, 45);
		panel_7.add(databaseConfig_Button);
		initView();
	}
	class StopRunningListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			context.onStopRunning();
			
			start_Button.removeActionListener(this);
			

			start_Button.addActionListener(new StartRunningListener());
		}
		
	}
	class StartRunningListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				
				if(!key_TextField.getText().trim().equals("") 
						&& key_TextField.getText().trim() != null){
					context.setKeyWord(key_TextField.getText().trim());
				}else{
					new ErrorDialog("关键字不能为空").setVisible(true);
					return;
				}
				
				if(!outputFilePath_TextField.getText().trim().equals("") 
						&& outputFilePath_TextField.getText().trim() != null){
					context.setOutputFilePath(outputFilePath_TextField.getText().trim());
				}else{
					new ErrorDialog("输出文件路径不能为空").setVisible(true);
					return;
				}
				
				if(((Integer)threadcount_spinner.getValue()) < 1){
					new ErrorDialog("线程数不能小于1").setVisible(true);
				}else if(((Integer)threadcount_spinner.getValue()) >100){
					new ErrorDialog("线程数不能大于100").setVisible(true);
					return;
				}else{
					context.setMaxThreadNumber((Integer) threadcount_spinner.getValue());
				}

				if(!"true".equals(context.getDataBasePass())){
					new ErrorDialog("数据库连接错误，请确认“创建.sql”成功导入数据库中与用户名、密码配置正确").setVisible(true);
					return;
				}
				//TODO Tag处理
				saveConfig();
				initRunningConfig();
				context.onStartRunning();
				
				start_Button.removeActionListener(this);
				
				start_Button.setText("停止运行");
				start_Button.addActionListener(new StopRunningListener());
			}

			

		}
	
	private void initRunningConfig() {
		context.setKeyWord(key_TextField.getText());
		
		context.setTag(tagContent[tagBox.getSelectedIndex()]);
		
		context.setOutputFilePath(outputFilePath_TextField.getText());
		
		context.setMaxThreadNumber((Integer)threadcount_spinner.getValue());
	}
	private void saveConfig() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Element root=null,
				keyword=null,
				type=null,
				threadNum=null,
				filepath=null,
				db_usernam=null,
				db_passwd=null,
				db_pass = null;
		factory.setIgnoringElementContentWhitespace(true);
          
          DocumentBuilder db;
		try {
			db = factory.newDocumentBuilder();
			File configFile = new File(Constant.applicationPath + "config.xml");
			Document xmldoc = null;
			
			if(!configFile.exists()){
				xmldoc = db.newDocument();
			}else{
				configFile.delete();
				xmldoc = db.newDocument();
			}
			
			root = (Element) xmldoc.createElement("config");
			
			keyword = xmldoc.createElement("keyword");
			keyword.setTextContent(key_TextField.getText());
			
			type = xmldoc.createElement("type");
			type.setTextContent((Integer)tagBox.getSelectedIndex() + "");
			
			threadNum = xmldoc.createElement("threadnumber");
			threadNum.setTextContent((Integer)threadcount_spinner.getValue() + "");
			
			filepath = xmldoc.createElement("filepath");
			filepath.setTextContent(outputFilePath_TextField.getText());
			System.out.println("databaseUserName \t" + context.getDataBaseUsername() + "\n" + "databasePassWord \t" + context.getDataBasePasswd() + "\ndatabasePass\t" + context.getDataBasePass());

			if(context.getDataBasePass().equals("true")) {
				db_usernam = xmldoc.createElement("databaseUserName");
				db_usernam.setTextContent(context.getDataBaseUsername());
				db_passwd = xmldoc.createElement("databasePassWord");
				db_passwd.setTextContent(context.getDataBasePasswd());

				root.appendChild(db_usernam);
				root.appendChild(db_passwd);

				db_pass = xmldoc.createElement("databasePassOrNot");
				db_pass.setTextContent(context.getDataBasePass());

				root.appendChild(db_pass);
			}else{
				db_pass = xmldoc.createElement("databasePassOrNot");
				db_pass.setTextContent(context.getDataBasePass());

				root.appendChild(db_pass);
			}


			root.appendChild(keyword);
			root.appendChild(type);
			root.appendChild(threadNum);
			root.appendChild(filepath);



			xmldoc.appendChild(root);
			
			 TransformerFactory transFactory=TransformerFactory.newInstance();
		        try {
		            Transformer transformer = transFactory.newTransformer();
		            transformer.setOutputProperty("encoding", "utf-8");
		            transformer.setOutputProperty("indent", "yes");
		           
		            DOMSource source=new DOMSource(xmldoc);
		            
		            StreamResult result = null;
		            
		            result = new StreamResult(new PrintWriter(new FileOutputStream(configFile)));
			        
		            transformer.transform(source, result);
		          
		        } catch (TransformerConfigurationException e) {
		            e.printStackTrace();
		        } catch (TransformerException e) {
		            e.printStackTrace();
		        }   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("保存配置文件失败");
			e.printStackTrace();
		}	
	}
	
	private void initView() {
		// TODO 配置文件解析
		
	        try {
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();
	            Document document = db.parse(Constant.applicationPath + "config.xml");
	             
	            NodeList list = document.getChildNodes();
	            
	                Node root = document.getChildNodes().item(0);
	                NodeList configs = root.getChildNodes();
	                for (int j = 0; j < configs.getLength(); j++) {
	                    Node node = configs.item(j);
	                    if(node.getNodeName() == "keyword"){
	                    	key_TextField.setText(node.getTextContent());
	                    }else if(node.getNodeName() == "type"){
	                    	tagBox.setSelectedIndex(Integer.parseInt(node.getTextContent()));
	                    }else if(node.getNodeName() == "threadnumber"){
	                    	threadcount_spinner.setValue(Integer.parseInt(node.getTextContent()));
	                    }else if(node.getNodeName() == "filepath"){
	                    	outputFilePath_TextField.setText(node.getTextContent());
	                    }else if(node.getNodeName() == "databaseUserName"){
	                    	context.setDataBaseUsername(node.getTextContent());
						}else if(node.getNodeName() == "databasePassWord"){
							context.setDataBasePasswd(node.getTextContent());
						}else if(node.getNodeName() == "databasePassOrNot"){
							context.setDataBasePass(node.getTextContent());
						}
	            }
	           
	        } catch (FileNotFoundException e) {
	            System.out.println(e.getMessage());
	        } catch (ParserConfigurationException e) {
	            System.out.println(e.getMessage());
	        } catch (SAXException e) {
	            System.out.println(e.getMessage());
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	}
}
	
	


