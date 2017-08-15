package datasource;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;



public class MyConnection implements Connection {

	private Connection realConnection;
	private MyDataSource myDataSource;
	
	public MyConnection(Connection realConnection, MyDataSource myDataSource) {
		 //传入具体Connection与具体数据库有关，如MYSQL,ORACLE等
		this.realConnection = realConnection;
		this.myDataSource = myDataSource;
	}


	@Override
	public void close() throws SQLException {
		// 修改close能在调用该方法时放回连接池，注意是放MyConnection，因为它处理了close()方法，取出后还是该方法
		this.myDataSource.connectionsPool.addLast(this);
	}
	
	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		//一般实现的方法交给realConnection实现
		return this.realConnection.unwrap(iface);
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public Statement createStatement() throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String nativeSQL(String sql) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void commit() throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void rollback() throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean isClosed() throws SQLException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void setCatalog(String catalog) throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public String getCatalog() throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void setTransactionIsolation(int level) throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void clearWarnings() throws SQLException {
		// TODO 自动生成的方法存根
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void setHoldability(int holdability) throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int getHoldability() throws SQLException {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Clob createClob() throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Blob createBlob() throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public NClob createNClob() throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void setSchema(String schema) throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public String getSchema() throws SQLException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void abort(Executor executor) throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		// TODO 自动生成的方法存根
		return 0;
	}
	
}
