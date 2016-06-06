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
	//数据库驱动、访问地址、用户名、密码
	public String DRIVER = "";
	public String URL    = "";
	public String DBNAME = "";
	public String DBPASS = "";
	
	public DBData(){
		String properties = "db216.properties";
		if (base.indexURL.contains("inclient")) {
			properties = "db213.properties";
		}
		String curPath = new File("").getAbsolutePath();//当前路径
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
	
	/********************************本地_213服务器*******************************************/
	
	//213本地环境主库
	public static final String URL_INCLIENT="jdbc:mysql://192.168.1.213:3306/eloan_db";
	//读权限
	public static final String DBNAME_INCLIENT="select_all";
	public static final String DBPASS_INCLIENT="378fhawkj90w";
	//写权限
	public static final String DBNAME_INCLIENT_WRITE="update_all";
	public static final String DBPASS_INCLIENT_WRITE="oasdh";
	
	/********************************集成_216服务器*******************************************/
	//写权限
	//绑定IP10.0.6.238
	public static final String DBNAME_CLIENT_JBY="jiangby";
	public static final String DBPASS_CLIENT_JBY="jiangby123";
	
	//绑定IP:10.0.6.242
	public static final String DBNAME_CLIENT_XTY="xuty";
	public static final String DBPASS_CLIENT_XTY="xuty123";

	//绑定IP:10.0.5.234
	public static final String DBNAME_CLIENT_LJ="liuj";
	public static final String DBPASS_CLIENT_LJ="liuj123";
	
	//绑定IP:192.168.2.113--执行注册、发布借款工具
	public static final String DBNAME_CLIENT_AUTO="auto";
	public static final String DBPASS_CLIENT_AUTO="auto123";
	
	//绑定IP:192.168.2.72--执行P1、P2
	public static final String DBNAME_CLIENT_AUTOAT="autoat";
	public static final String DBPASS_CLIENT_AUTOAT="autoat123";
	
	//216集成环境从库
	
	//225集成环境非核心库
	public static final String URL_NonCORE="jdbc:mysql://192.168.1.225:3306/eloan_db";//集成环境非核心库
	
	//225集成环境非核心库，有写权限
	//绑定IP10.0.1.239
	public static final String DBNAME_NonCORE_JBY="update_all";
	public static final String DBPASS_NonCORE_JBY="oasdh";
	
	/********************************test_XXX服务器*******************************************/
	
	
	/**
	 * 得到数据库连接
	 * @return 数据库连接对象
	 * @author 江渤洋 2015-4-24
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
	 * 释放连接数据库资源
	 * @param connection 数据库连接
	 * @param statement
	 * @param resultSet 结果集
	 * @author 江渤洋 2015-4-24
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
	 * 获得验证码
	 * 徐天元 拆分
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
	 * 获取用户手机号
	 * @param email 邮箱
	 * @return 手机号
	 * @author 江渤洋 2015-12-11
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
	 * 获得手机验证码
	 * @param phoneNum 手机号码
	 * @return 手机验证码
	 * @author 江渤洋 2015-4-24
	 */
	public String getPhoneCode(String phoneNum){
		String phoneCode = getCode(phoneNum);
		//截取字符串，内容如下：“本次验证码是：531498。若非本人操作请忽略此条信息，给您带来不便，望请见谅。【翼龙贷】”
		//您通过手机13111111150添加卡号，本次验证码是：899226。【翼龙贷】
		//phoneCode = phoneCode.substring(7, 13);
		phoneCode = phoneCode.substring(phoneCode.indexOf('：')+1,phoneCode.indexOf('：')+7);
		return phoneCode;
	}
	
	/**
	 * 获得邮箱验证码
	 * @author 徐天元
	 */
	public String getEmailCode(String email){
		String emailCode = getCode(email);
		//截取字符串，内容如下：“您通过邮箱：15847123674@qq.com绑定或重置邮箱，本次验证码为：<font color="red">FcIrgQrNxuFgjvVPHe7I</font><br><br>为了确保您的帐号安全，该验证码仅<font color="red">30分钟内</font>有效。<br><br>您在翼龙贷网络借贷平台可以享受到以下服务：<br><br>1、如果您正在寻找资金，可以向众多的网络投资者发布消息，方便快捷的借到所需资金。<br><br>2、如果您在找理财投资渠道，请把资金借给正在需要的人，稳定的回收本金和利息，创新高效安全的理财投资模式，期望收益高于银行定期利息。<br><br>希望您在翼龙贷网络借贷平台上得到更多人的帮助，也希望您能在翼龙贷网络借贷平台上帮助更多的人，并从中获得乐趣！ <br><br>”
		int startIndex = emailCode.indexOf("本次验证码为：<font color=\"red\">")+25;
		emailCode = emailCode.substring(startIndex,startIndex+20);
		return emailCode;
	}
	
	/**
	 * 获得邀请码
	 * @author 徐天元 2015-5-26
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
	 * 徐天元
	 * 根据真实姓名获取uid
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
	 * 徐天元
	 * 根据uid更该状态  开通手机快捷还款
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
	 * 获取用户创建时间
	 * @param phoneNumber 手机号(需经过DES加密)
	 * @return 用户创建时间
	 * @author 江渤洋 2015-8-31
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
	
	/********************************翼存宝*******************************************/
	
	/**
	 * 发布翼存宝
	 * @param eCunBaoName	翼存宝名称（名称+本地时间，例如：auto0104161935）
	 * @param amount		购买金额（最大金额，例如：10000）
	 * @param rate			购买利率（例如：0.125）
	 * @param validity		购买有效期（单位小时，例如：1）
	 * @param limit			合约期限（锁定期限，。如7/30/90/365/720）
	 * @param createData 	创建日期（例如：1451911350）
	 * @param publishedDate	发布日期
	 * @param accrualData	计息日期（发布日期 + 购买有效期）
	 * @param repaymentData 还本日期（计息日期 + 合约期限）
	 * @return 是否插入成功（true：成功，false：失败）
	 * @author 江渤洋 2016-1-4
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
	 * 获得翼存宝排序后的前四条标题
	 * @return 四条数据的标题
	 * @author 江渤洋 2015-5-6
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
	 * 获取翼存宝的相关数据
	 * @param uid 用户ID
	 * @return 加入金额，年化收益率，合约期限，计息时间，到期时间
	 * @author 江渤洋 2015-10-20
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
	
	/********************************翼企贷P1*******************************************/
	
	/**
	 * 获取uID
	 * @param email 邮箱
	 * @return 用户ID
	 * @author 江渤洋 2015-8-7
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
	 * 从标记录表查询最新的标ID
	 * @param uid 用户ID
	 * @return 标ID
	 * @author 江渤洋 2015-8-7
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
	 * 从标记录表查询最新的标ID
	 * @param uid 用户ID
	 * @param amount 借款金额
	 * @return 标ID
	 * @author 江渤洋 2015-8-19
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
	 * 根据产品ID，用户ID 向标确认视频记录表插入数据
	 * @param tid 产品ID
	 * @param uid 用户ID
	 * @return 执行是否成功
	 * @author 江渤洋 2015-8-7
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
	
	/********************************翼企贷P1_前台_检查借款人服务费*******************************************/
	
	/**
	 * 获取上次还款标的信息
	 * 备注：根据当前标所属人(ownerid)，获取期数(phases)为6期、状态(STATUS)为结束（已还清）、类型(TYPE)为翼企贷标、按标ID进行倒序排序
	 * @param uid 用户ID
	 * @return HashMap:“当前标的发布时间的毫秒数”(publishedDate),“标ID”(tenderId)
	 * @author 江渤洋 2015-8-12
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
	 * 明细表去查询逾期状态是否优惠，status为1，表示5.5%（未优惠）；为2，表示3.25%（优惠）
	 * @param tenderId 标ID
	 * @return true：非空，false:空
	 * @author 江渤洋 2015-8-12
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
	 * 修改优惠状态，改为1，即不优惠
	 * @param tenderId 标ID
	 * @return
	 * @author 江渤洋 2015-8-19
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
	 * 查询当前标的“当前期数”是否为6，即6个月
	 * @param tenderId 标ID
	 * @return HashMap:“实际还款时间”(realdate),“应还款时间”(cdate)
	 * @author 江渤洋 2015-8-12
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
	 * 将标状态改为“逾期还款”（通过修改“实际还款日期”= 创建日期  + 40~41天）
	 * 目的：借款6个月逾期40~41天
	 * @param tenderId 标ID
	 * @param overdueDay 逾期日期
	 * @return true：修改成功，false：修改失败
	 * @author 江渤洋 2015-8-18
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
	 * 修改“发布日期”(通过上一个标的实际还款日期(realdate) + 91天)
	 * 目的：还清的90天后继续借款
	 * @param oldTenderId 上次还款标的ID
	 * @param newTenderId 当前标的ID
	 * @param publishedDate 标的发布日期增加相应天数
	 * @return true:成功，false:失败
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
	
	/********************************体验期的翼存宝P1_前台*******************************************/
	
	/**
	 * 获取“年化收益”、“锁定期限”、“已募集金额”
	 * @return “id(产品id)、“已募集金额”(amount)、“年化收益”(interestrate)、“锁定期限”(phases)
	 * @author 江渤洋 2015-9-1
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
	 * 获取站内信总数
	 * @param uid 用户id
	 * @param status 站内信状态（已读、未读、全部）
	 * @return 站内信总数
	 */
	public String getInsideLetterNum(String uid, String status){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String receiverstatus = "";
		String count = "";
		if(status.equals("全部")){
			receiverstatus = "";
		}
		else if(status.equals("已读")){
			receiverstatus = " AND receiverstatus = 2";
		}
		else if(status.equals("未读")){
			receiverstatus = " AND receiverstatus = 1";
		}
		else{
			System.out.println("您输入的状态有误，无法修改。");
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
	 * 获取站内信的信息（发送者ID、标题，内容，发送时间，站内信状态：1为未读，2为已读）
	 * @param insideLetterID 站内信ID
	 * @return 站内信的信息
	 * @author 江渤洋 2015-10-21
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
	 * 修改站内信状态
	 * @param insideLetterID 站内信ID（可从页面获取）
	 * @param status 站内信状态：1为未读，2为已读
	 * @return 是否修改成功
	 * @author 江渤洋 2015-10-16
	 */
	public boolean updateReceiverStatus(String insideLetterID, String status){
		boolean result = false;
		Connection connection = null;
		Statement statement = null;
		int flag = 0;
		if(status.equals("已读")){
			status = "2";
		}
		else if(status.equals("未读")){
			status = "1";
		}
		else{
			System.out.println("您输入的状态有误，无法修改。");
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
	
	/********************************我的账户P2_申请借款*******************************************/
	
	/**
	 * 删除手机注册的记录，使其成为只有邮箱注册的账户，即老账户。
	 * @param UId 用户ID
	 * @return true：删除成功，false：删除失败
	 * @author 江渤洋 2015-8-19
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
	
	/********************************我的账户P2_安全认证_修改手机号*******************************************/
	
	/**
	 * 获取手机更改历史次数
	 * @param UId 用户ID
	 * @return：更改次数
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
			resultSet.last();             //移动到最后一行
			result = resultSet.getRow();  //得到当前行号
			resultSet.beforeFirst();      //如果还用结果集，就把指针再移动至初始化位置
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBData.closeAll(connection, statement, resultSet);
		}
		return result;
	}

	/**
	 * 删除手机更改历史记录
	 * @param UId 用户ID
	 * @return：是否删除成功
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
	 * 徐天元
	 * 散标列表已投金额
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
	//执行sql查询的操作
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
	//执行sql增删改的操作
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
	 * 徐天元
	 * 审核新手标
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