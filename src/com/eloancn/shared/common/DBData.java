package com.eloancn.shared.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.eloancn.shared.until.DESUtils;

public class DBData {
	Base base = new Base();
	//���ݿ����������ʵ�ַ���û���������
	public String DRIVER = "";
	public String URL    = "";
	public String DBNAME = "";
	public String DBPASS = "";
	
	public DBData(){
		String properties = "db216.properties";
		if (base.indexURL.contains("inclient")) {
			properties = "db213.properties";
		}
		String curPath = new File("").getAbsolutePath();//��ǰ·��
     	InputStream is = null;
		try {
			is = new FileInputStream(curPath+File.separator+properties);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties property = new Properties();
		try {
			property.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DRIVER = property.getProperty("jdbc.driverClassName");
		URL = property.getProperty("jdbc.url");
		DBNAME = property.getProperty("jdbc.username");
		DBPASS = property.getProperty("jdbc.password");
	}
	
	/********************************����_213������*******************************************/
	
	//213���ػ�������
	public static final String URL_INCLIENT="jdbc:mysql://192.168.1.213:3306/eloan_db";
	//��Ȩ��
	public static final String DBNAME_INCLIENT="select_all";
	public static final String DBPASS_INCLIENT="378fhawkj90w";
	//дȨ��
	public static final String DBNAME_INCLIENT_WRITE="update_all";
	public static final String DBPASS_INCLIENT_WRITE="oasdh";
	
	/********************************����_216������*******************************************/
	//дȨ��
	//��IP10.0.6.238
	public static final String DBNAME_CLIENT_JBY="jiangby";
	public static final String DBPASS_CLIENT_JBY="jiangby123";
	
	//��IP:10.0.6.242
	public static final String DBNAME_CLIENT_XTY="xuty";
	public static final String DBPASS_CLIENT_XTY="xuty123";

	//��IP:10.0.5.234
	public static final String DBNAME_CLIENT_LJ="liuj";
	public static final String DBPASS_CLIENT_LJ="liuj123";
	
	//��IP:192.168.2.113--ִ��ע�ᡢ��������
	public static final String DBNAME_CLIENT_AUTO="auto";
	public static final String DBPASS_CLIENT_AUTO="auto123";
	
	//��IP:192.168.2.72--ִ��P1��P2
	public static final String DBNAME_CLIENT_AUTOAT="autoat";
	public static final String DBPASS_CLIENT_AUTOAT="autoat123";
	
	//216���ɻ����ӿ�
	
	//225���ɻ����Ǻ��Ŀ�
	public static final String URL_NonCORE="jdbc:mysql://192.168.1.225:3306/eloan_db";//���ɻ����Ǻ��Ŀ�
	
	//225���ɻ����Ǻ��Ŀ⣬��дȨ��
	//��IP10.0.1.239
	public static final String DBNAME_NonCORE_JBY="update_all";
	public static final String DBPASS_NonCORE_JBY="oasdh";
	
	/********************************test_XXX������*******************************************/
	
	
	/**
	 * �õ����ݿ�����
	 * @return ���ݿ����Ӷ���
	 * @author ������ 2015-4-24
	 */
	public Connection getConnection(String dbURL, String dbName, String dbPass){
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(dbURL, dbName, dbPass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * �ͷ��������ݿ���Դ
	 * @param connection ���ݿ�����
	 * @param statement
	 * @param resultSet �����
	 * @author ������ 2015-4-24
	 */
	public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
		if((resultSet!=null)&&(statement!=null)&&(connection!=null)){
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �����֤��
	 * ����Ԫ ���
	 */
	public String getCode(String num){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT content FROM d_cache_msg WHERE destination = '" + num + "' ORDER BY id DESC LIMIT 1";
		String code = "";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				code = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return code;
	}
	
	/**
	 * ��ȡ�û��ֻ���
	 * @param email ����
	 * @return �ֻ���
	 * @author ������ 2015-12-11
	 */
	public String getPhoneNum(String email){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT mobile FROM d_user WHERE 1 = 1 AND email = '" + email + "'";
		String code = "";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				code = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		code = DESUtils.getDecryptString(code);
		return code;
	}
	
	
	/**
	 * ����ֻ���֤��
	 * @param phoneNum �ֻ�����
	 * @return �ֻ���֤��
	 * @author ������ 2015-4-24
	 */
	public String getPhoneCode(String phoneNum){
		String phoneCode = getCode(phoneNum);
		//��ȡ�ַ������������£���������֤���ǣ�531498�����Ǳ��˲�������Դ�����Ϣ�������������㣬������¡�������������
		//��ͨ���ֻ�13111111150��ӿ��ţ�������֤���ǣ�899226������������
		//phoneCode = phoneCode.substring(7, 13);
		phoneCode = phoneCode.substring(phoneCode.indexOf('��')+1,phoneCode.indexOf('��')+7);
		return phoneCode;
	}
	
	/**
	 * ���������֤��
	 * @author ����Ԫ
	 */
	public String getEmailCode(String email){
		String emailCode = getCode(email);
		//��ȡ�ַ������������£�����ͨ�����䣺15847123674@qq.com�󶨻��������䣬������֤��Ϊ��<font color="red">FcIrgQrNxuFgjvVPHe7I</font><br><br>Ϊ��ȷ�������ʺŰ�ȫ������֤���<font color="red">30������</font>��Ч��<br><br>����������������ƽ̨�������ܵ����·���<br><br>1�����������Ѱ���ʽ𣬿������ڶ������Ͷ���߷�����Ϣ�������ݵĽ赽�����ʽ�<br><br>2��������������Ͷ������������ʽ���������Ҫ���ˣ��ȶ��Ļ��ձ������Ϣ�����¸�Ч��ȫ�����Ͷ��ģʽ����������������ж�����Ϣ��<br><br>ϣ������������������ƽ̨�ϵõ������˵İ�����Ҳϣ��������������������ƽ̨�ϰ���������ˣ������л����Ȥ�� <br><br>��
		int startIndex = emailCode.indexOf("������֤��Ϊ��<font color=\"red\">")+25;
		emailCode = emailCode.substring(startIndex,startIndex+20);
		return emailCode;
	}
	
	/**
	 * ���������
	 * @author ����Ԫ 2015-5-26
	 */
	public String getVoucherCode(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT code FROM d_wut_handler";
		String code = "";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				code = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return code;
	}
	
	public static void main(String args[]){
		System.out.print(new DBData().getVoucherCode());
	}
	
	/**
	 * ����Ԫ
	 * ������ʵ������ȡuid
	 */
	public String getUidByRealname(String realName){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT id FROM d_user where realname = '" + realName +"'";
		String uid = "";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				uid = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return uid;
	}
	
	/**
	 * ����Ԫ
	 * ����uid����״̬  ��ͨ�ֻ���ݻ���
	 */
	public Boolean updateOpenMobliePayStatusByUid(int uid){
		Boolean result = false;
		Connection connection = null;
		Statement statement = null;
		int flag = 0;
		String sql = "UPDATE d_ump_sms_user SET status = 1  WHERE  uid = " + uid;
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			flag = statement.executeUpdate(sql);
			if (flag != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, null);
		}
		return result;
	}
	
	/**
	 * ��ȡ�û�����ʱ��
	 * @param phoneNumber �ֻ���(�辭��DES����)
	 * @return �û�����ʱ��
	 * @author ������ 2015-8-31
	 */
	public String selectUserCreateTime(String phoneNumber){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT cdate FROM d_user WHERE mobile = '" + phoneNumber +"'";
		String createDate = "";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				createDate = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return createDate;
	}
	
	/********************************��汦*******************************************/
	
	/**
	 * ������汦
	 * @param eCunBaoName	��汦���ƣ�����+����ʱ�䣬���磺auto0104161935��
	 * @param amount		������������磺10000��
	 * @param rate			�������ʣ����磺0.125��
	 * @param validity		������Ч�ڣ���λСʱ�����磺1��
	 * @param limit			��Լ���ޣ��������ޣ�����7/30/90/365/720��
	 * @param createData 	�������ڣ����磺1451911350��
	 * @param publishedDate	��������
	 * @param accrualData	��Ϣ���ڣ��������� + ������Ч�ڣ�
	 * @param repaymentData �������ڣ���Ϣ���� + ��Լ���ޣ�
	 * @return �Ƿ����ɹ���true���ɹ���false��ʧ�ܣ�
	 * @author ������ 2016-1-4
	 */
	public boolean publishECaoBao(String eCunBaoName, String amount, String rate, String validity, String limit, String createData, String publishedDate, String accrualData, String repaymentData){
		boolean result = false;
		Connection connection = null;
		Statement statement = null;
		int flag = 0;
		String sql = "INSERT INTO d_wmps_record "
				+ "(wid, title, amount, maxAmount, interestrate, valitime, status, type, phasesType, phases, buyType, cdate, publisheddate, finisheddate, interdate, enddate, progress, description, chirldType, firstInter, secInter, effectAmount, experience, version) "
				+ "VALUES('0','" + eCunBaoName + "',NULL,'" + amount + ".00','" + rate + "','" + validity + "','1','2','1','" + limit + "','2','" + createData + "','" + publishedDate + "',NULL,'" + accrualData + "','" + repaymentData + "',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0')";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			flag = statement.executeUpdate(sql);
			if (flag != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, null);
		}
		return result;
	}
	
	/**
	 * �����汦������ǰ��������
	 * @return �������ݵı���
	 * @author ������ 2015-5-6
	 */
	public List<String> getECunBaoTitleTopFour(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT title FROM d_wmps_record WHERE STATUS != 0 ORDER BY STATUS ASC,publisheddate DESC LIMIT 4";
		List<String> titleList = new ArrayList<String>();
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columns = resultSetMetaData.getColumnCount();
			while(resultSet.next()) {
				for(int i=1; i<=columns; i++){
					titleList.add(resultSet.getString(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return titleList;
	}
	
	/**
	 * ��ȡ��汦���������
	 * @param uid �û�ID
	 * @return ������껯�����ʣ���Լ���ޣ���Ϣʱ�䣬����ʱ��
	 * @author ������ 2015-10-20
	 */
	public HashMap<String, String> getD_wmps_recordTable(String uid){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		String sql = "SELECT amount, interestrate, phases, interdate, enddate FROM d_wmps_record WHERE id IN (SELECT wid FROM d_wmps_buy_record WHERE uid = '" + uid + "')  AND interdate = '1444892400'";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				hashMap.put("amount", resultSet.getString("amount"));
				hashMap.put("interestrate", resultSet.getString("interestrate"));
				hashMap.put("phases", resultSet.getString("phases"));
				hashMap.put("interdate", resultSet.getString("interdate"));
				hashMap.put("enddate", resultSet.getString("enddate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return hashMap;
	}
	
	/********************************�����P1*******************************************/
	
	/**
	 * ��ȡuID
	 * @param email ����
	 * @return �û�ID
	 * @author ������ 2015-8-7
	 */
	public String getUID(String email){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT id FROM d_user WHERE 1 = 1 AND email = '" + email +"'";
		String uID = "";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				uID = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return uID;
	}
	
	/**
	 * �ӱ��¼���ѯ���µı�ID
	 * @param uid �û�ID
	 * @return ��ID
	 * @author ������ 2015-8-7
	 */
	public String getTenderId(String uid){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT id FROM d_tender WHERE 1 = 1 AND ownerid = '" + uid + "' ORDER BY id DESC LIMIT 1";
		String tenderID = "";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				tenderID = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return tenderID;
	}
	
	/**
	 * �ӱ��¼���ѯ���µı�ID
	 * @param uid �û�ID
	 * @param amount �����
	 * @return ��ID
	 * @author ������ 2015-8-19
	 */
	public String getTenderId(String uid, String amount){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT id FROM d_tender WHERE 1 = 1 AND ownerid = " + uid + " AND amount = " + amount + " ORDER BY id DESC LIMIT 1";
		String tenderID = "";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				tenderID = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return tenderID;
	}
	
	/**
	 * ���ݲ�ƷID���û�ID ���ȷ����Ƶ��¼���������
	 * @param tid ��ƷID
	 * @param uid �û�ID
	 * @return ִ���Ƿ�ɹ�
	 * @author ������ 2015-8-7
	 */
	public boolean insertEnsureVideo(String tid, String uid){
		boolean result = false;
		Connection connection = null;
		Statement statement = null;
		int flag = 0;
		String sql = "INSERT INTO d_tender_ensure_video(tid,uid,STATUS, resultobj, cdate, TYPE) VALUE ('" + tid + "','" + uid + "',1,'1382937739081.flv',1382938744,1)";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			flag = statement.executeUpdate(sql);
			if (flag != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, null);
		}
		return result;
	}
	
	/********************************�����P1_ǰ̨_������˷����*******************************************/
	
	/**
	 * ��ȡ�ϴλ�������Ϣ
	 * ��ע�����ݵ�ǰ��������(ownerid)����ȡ����(phases)Ϊ6�ڡ�״̬(STATUS)Ϊ�������ѻ��壩������(TYPE)Ϊ������ꡢ����ID���е�������
	 * @param uid �û�ID
	 * @return HashMap:����ǰ��ķ���ʱ��ĺ�������(publishedDate),����ID��(tenderId)
	 * @author ������ 2015-8-12
	 */
	public HashMap<String, String> getD_TenderTable(String uid){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		HashMap<String, String> hashMap = new HashMap<String, String>();
//		String sql = "SELECT * FROM d_tender WHERE 1 = 1 AND ownerid = '" + uid + "' AND phases = 6 AND TYPE = 22 ORDER BY id DESC LIMIT 1";
		String sql = "SELECT * FROM d_tender WHERE 1 = 1 AND ownerid = '" + uid + "' AND phases = 6 AND TYPE = 22 AND STATUS = 7 ORDER BY id DESC LIMIT 1";
		String tenderID = "";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				hashMap.put("tenderId", resultSet.getString("id"));
				hashMap.put("publishedDate", resultSet.getString("publisheddate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return hashMap;
	}
	
	/**
	 * ��ϸ��ȥ��ѯ����״̬�Ƿ��Żݣ�statusΪ1����ʾ5.5%��δ�Żݣ���Ϊ2����ʾ3.25%���Żݣ�
	 * @param tenderId ��ID
	 * @return true���ǿգ�false:��
	 * @author ������ 2015-8-12
	 */
	public boolean isEmptyByDetailsTable(String tenderId){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM d_tender_yqd_fencheng_details WHERE tenderId = '" + tenderId + "' AND STATUS = 1";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return false;
	}
	
	/**
	 * �޸��Ż�״̬����Ϊ1�������Ż�
	 * @param tenderId ��ID
	 * @return
	 * @author ������ 2015-8-19
	 */
	public boolean updatePreferentialState(String tenderId){
			boolean result = false;
			Connection connection = null;
			Statement statement = null;
			int flag = 0;
			String sql = "UPDATE d_tender_yqd_fencheng_details SET STATUS = 1 WHERE tenderId = " + tenderId;
			try {
				connection = new DBData().getConnection(URL, DBNAME, DBPASS);
				statement = connection.createStatement();
				flag = statement.executeUpdate(sql);
				if (flag != 0) {
					result = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBData.closeAll(connection, statement, null);
			}
			return result;
	}
	
	/**
	 * ��ѯ��ǰ��ġ���ǰ�������Ƿ�Ϊ6����6����
	 * @param tenderId ��ID
	 * @return HashMap:��ʵ�ʻ���ʱ�䡱(realdate),��Ӧ����ʱ�䡱(cdate)
	 * @author ������ 2015-8-12
	 */
	public HashMap<String, String> getD_Tender_Repayment_DetailTable(String tenderId){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		String sql = "SELECT * FROM d_tender_repayment_detail WHERE tenderId = '" + tenderId + "' AND instalment = 6";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				hashMap.put("realdate", resultSet.getString("realdate"));
				hashMap.put("cdate", resultSet.getString("cdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return hashMap;
	}
	
	/**
	 * ����״̬��Ϊ�����ڻ����ͨ���޸ġ�ʵ�ʻ������ڡ�= ��������  + 40~41�죩
	 * Ŀ�ģ����6��������40~41��
	 * @param tenderId ��ID
	 * @param overdueDay ��������
	 * @return true���޸ĳɹ���false���޸�ʧ��
	 * @author ������ 2015-8-18
	 */
	public boolean updateRealDate(String tenderId, String overdueDay){
		boolean result = false;
		Connection connection = null;
		Statement statement = null;
		int flag = 0;
		String sql = "UPDATE d_tender_repayment_detail " +
						"SET realdate = " +
							"(SELECT a.cdate FROM " +
								"(SELECT cdate FROM d_tender_repayment_detail WHERE tenderId = " + tenderId + " ORDER BY id DESC LIMIT 1) AS a) + CONVERT('" + overdueDay + "',SIGNED) " +
					"WHERE tenderId = " + tenderId + " AND STATUS = 5";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			flag = statement.executeUpdate(sql);
			if (flag != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, null);
		}
		return result;
	}
	
	/**
	 * �޸ġ��������ڡ�(ͨ����һ�����ʵ�ʻ�������(realdate) + 91��)
	 * Ŀ�ģ������90���������
	 * @param oldTenderId �ϴλ�����ID
	 * @param newTenderId ��ǰ���ID
	 * @param publishedDate ��ķ�������������Ӧ����
	 * @return true:�ɹ���false:ʧ��
	 */
	public boolean updatePublishedDate(String oldTenderId, String newTenderId, String publishedDate){
		Boolean result = false;
		Connection connection = null;
		Statement statement = null;
		int flag = 0;
		String sql = "UPDATE d_tender " + 
						"SET publisheddate = " +
							"(SELECT a.realdate FROM " +
								"(SELECT realdate FROM d_tender_repayment_detail WHERE tenderId = " + oldTenderId + " GROUP BY id DESC LIMIT 1) AS a) + CONVERT('" + publishedDate + "',SIGNED) " +
					"WHERE id = " + newTenderId;
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			flag = statement.executeUpdate(sql);
			if (flag != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, null);
		}
		return result;
	}
	
	/********************************�����ڵ���汦P1_ǰ̨*******************************************/
	
	/**
	 * ��ȡ���껯���桱�����������ޡ�������ļ����
	 * @return ��id(��Ʒid)������ļ����(amount)�����껯���桱(interestrate)�����������ޡ�(phases)
	 * @author ������ 2015-9-1
	 */
	public HashMap<String, String> getExperiencePeriodECunBao(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		String sql = "SELECT id, amount, interestrate, phases FROM d_wmps_record WHERE experience = 1 ORDER BY id DESC LIMIT 1";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				hashMap.put("id", resultSet.getString("id"));
				hashMap.put("amount", resultSet.getString("amount"));
				hashMap.put("interestrate", resultSet.getString("interestrate"));
				hashMap.put("phases", resultSet.getString("phases"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return hashMap;
	}
	
	/**
	 * ��ȡվ��������
	 * @param uid �û�id
	 * @param status վ����״̬���Ѷ���δ����ȫ����
	 * @return վ��������
	 */
	public String getInsideLetterNum(String uid, String status){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String receiverstatus = "";
		String count = "";
		if(status.equals("ȫ��")){
			receiverstatus = "";
		}
		else if(status.equals("�Ѷ�")){
			receiverstatus = " AND receiverstatus = 2";
		}
		else if(status.equals("δ��")){
			receiverstatus = " AND receiverstatus = 1";
		}
		else{
			System.out.println("�������״̬�����޷��޸ġ�");
			return null;
		}
		String sql = "SELECT COUNT(*) FROM d_instation_message WHERE receiverid = "+ uid + receiverstatus;
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				count = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return count;
	}
	
	/**
	 * ��ȡվ���ŵ���Ϣ��������ID�����⣬���ݣ�����ʱ�䣬վ����״̬��1Ϊδ����2Ϊ�Ѷ���
	 * @param insideLetterID վ����ID
	 * @return վ���ŵ���Ϣ
	 * @author ������ 2015-10-21
	 */
	public HashMap<String, String> getInsideLetterInfo(String insideLetterID){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		String sql = "SELECT senderid, title, content, cdate, receiverstatus FROM d_instation_message WHERE id = " + insideLetterID;
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				hashMap.put("senderid", resultSet.getString("senderid"));
				hashMap.put("title", resultSet.getString("title"));
				hashMap.put("content", resultSet.getString("content"));
				hashMap.put("cdate", resultSet.getString("cdate"));
				hashMap.put("receiverstatus", resultSet.getString("receiverstatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return hashMap;
	}
	
	/**
	 * �޸�վ����״̬
	 * @param insideLetterID վ����ID���ɴ�ҳ���ȡ��
	 * @param status վ����״̬��1Ϊδ����2Ϊ�Ѷ�
	 * @return �Ƿ��޸ĳɹ�
	 * @author ������ 2015-10-16
	 */
	public boolean updateReceiverStatus(String insideLetterID, String status){
		boolean result = false;
		Connection connection = null;
		Statement statement = null;
		int flag = 0;
		if(status.equals("�Ѷ�")){
			status = "2";
		}
		else if(status.equals("δ��")){
			status = "1";
		}
		else{
			System.out.println("�������״̬�����޷��޸ġ�");
			return false;
		}
		String sql = "UPDATE d_instation_message SET receiverstatus = " + status + " WHERE id = " + insideLetterID;
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			flag = statement.executeUpdate(sql);
			if (flag != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, null);
		}
		return result;
	}
	
	/********************************�ҵ��˻�P2_������*******************************************/
	
	/**
	 * ɾ���ֻ�ע��ļ�¼��ʹ���Ϊֻ������ע����˻��������˻���
	 * @param UId �û�ID
	 * @return true��ɾ���ɹ���false��ɾ��ʧ��
	 * @author ������ 2015-8-19
	 */
	public boolean deletePhoneRegeditRecords(String UId){
			boolean result = false;
			Connection connection = null;
			Statement statement = null;
			int flag1,flag2,flag3 = 0;
			String sql1 = "UPDATE d_user SET mobile = NULL, encodePassworType = 0 WHERE id = " + UId;
			String sql2 = "UPDATE d_user_verifyinfo SET mobile = NULL, ismobileverified = 0 WHERE uid = " + UId;
			String sql3 = "DELETE FROM d_authentication WHERE nid = 2 AND uid = " + UId;
			try {
				connection = new DBData().getConnection(URL, DBNAME, DBPASS);
				statement = connection.createStatement();
				flag1 = statement.executeUpdate(sql1);
				flag2 = statement.executeUpdate(sql2);
				flag3 = statement.executeUpdate(sql3);
				if (flag1 != 0 && flag2 != 0 && flag3 != 0) {
					result = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBData.closeAll(connection, statement, null);
			}
			return result;
	}
	
	/********************************�ҵ��˻�P2_��ȫ��֤_�޸��ֻ���*******************************************/
	
	/**
	 * ��ȡ�ֻ�������ʷ����
	 * @param UId �û�ID
	 * @return�����Ĵ���
	 */
	public int selectMobileChangeNum(String UId){
		int result = 0;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT id FROM d_mobile_changehistory WHERE userid = " + UId;
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			resultSet.last();             //�ƶ������һ��
			result = resultSet.getRow();  //�õ���ǰ�к�
			resultSet.beforeFirst();      //������ý�������Ͱ�ָ�����ƶ�����ʼ��λ��
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return result;
	}

	/**
	 * ɾ���ֻ�������ʷ��¼
	 * @param UId �û�ID
	 * @return���Ƿ�ɾ���ɹ�
	 */
	public boolean deleteMobileChangeInfos(String UId){
		boolean result = false;
		Connection connection = null;
		Statement statement = null;
		int flag = 0;
		String sql = "DELETE FROM d_mobile_changehistory WHERE userid = " + UId;
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			flag = statement.executeUpdate(sql);
			if (flag != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, null);
		}
		return result;
	}
	
	/**
	 * ����Ԫ
	 * ɢ���б���Ͷ���
	 */
	public double getAlreadyMoney(String title){
		double result = 0;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT SUM(effectiveamount) AS effectiveamount FROM d_tender_record r,d_tender t WHERE r.tenderid = t.id and t.title like '"+title+"%'";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				result = resultSet.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return result;
	}
	
	public int getTenderID(String id,String search){
		int result = 0;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "select "+search+" from d_wut_tender where id="+id;
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				result = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return result;
	}
	//ִ��sql��ѯ�Ĳ���
	public int ExecuteSelect(String sql){
		int result = 0;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				result = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return result;
	}
	//ִ��sql��ɾ�ĵĲ���
	public boolean UpdateLoanStatus(String sql){
		Boolean result = false;
		Connection connection = null;
		Statement statement = null;
		int flag = 0;
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			flag = statement.executeUpdate(sql);
			if (flag != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, null);
		}
		return result;
	}
	
	/**
	 * ����Ԫ
	 * ������ֱ�
	 */
	public Boolean updateNewUserBid(String title){
		Boolean result = false;
		Connection connection = null;
		Statement statement = null;
		int flag = 0;
		String sql = "update d_tender set status =1,type=18 where title='"+title+"' and status=9";
		try {
			connection = new DBData().getConnection(URL, DBNAME, DBPASS);
			statement = connection.createStatement();
			flag = statement.executeUpdate(sql);
			if (flag != 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, null);
		}
		return result;
	}
}