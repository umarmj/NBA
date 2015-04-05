package project.database.com;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import oracle.jdbc.internal.OracleTypes;

import org.codehaus.jettison.json.JSONArray;
import java.sql.*;

import project.dao.*;
import project.util.ToJSON;


@Path("/DataAccess")
public class DataAccess {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Welcome to the DataAccess Class, <br>You can call several API's to access Data</p>";
	}
	
	@Path("/playerinformation")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String ReturnPlayerInformation(@QueryParam("player") String player) throws Exception {
		String returnString = null;
		Connection conn = null;
		
		System.out.println("player:" + player);
		
		try{
			conn = OracleConnection.OracleConnectionConn().getConnection();
			
			String getplayers = "{call PKG_PLAYERDATA.Get_Players(?,?)}";
			CallableStatement callableStatement = conn.prepareCall(getplayers);
			callableStatement.setString(1, player);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			
			callableStatement.executeUpdate();
			
			ResultSet rs = (ResultSet)callableStatement.getObject(2);
			
			ToJSON converter = new ToJSON();
			JSONArray json = new JSONArray();
			
			json = converter.toJSONArray(rs);
			
			returnString = json.toString();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			if (conn != null) conn.close();
			
		}
		return returnString;
	
	}
	
	@Path("/playerstatistics")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String ReturnPlayerStatistics(@QueryParam("player") String player) throws Exception {
		String returnString = null;
		Connection conn = null;
		
		System.out.println("player:" + player);
		
		try{
			conn = OracleConnection.OracleConnectionConn().getConnection();
			
			String getplayers = "{call PKG_PLAYERDATA.Get_Player_Statistics(?,?)}";
			CallableStatement callableStatement = conn.prepareCall(getplayers);
			callableStatement.setString(1, player);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			
			callableStatement.executeUpdate();
			
			ResultSet rs = (ResultSet)callableStatement.getObject(2);
			
			ToJSON converter = new ToJSON();
			JSONArray json = new JSONArray();
			
			json = converter.toJSONArray(rs);
			
			returnString = json.toString();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			if (conn != null) conn.close();
			
		}
		return returnString;
	
	}
	
	@Path("/teaminformation")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String ReturnTeamInformation(@QueryParam("team") String team) throws Exception {
		String returnString = null;
		Connection conn = null;
		
		System.out.println("team:" + team);
		
		try{
			conn = OracleConnection.OracleConnectionConn().getConnection();
			
			String getteams = "{call PKG_TEAMDATA.Get_Team(?,?)}";
			CallableStatement callableStatement = conn.prepareCall(getteams);
			callableStatement.setString(1, team);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			
			callableStatement.executeUpdate();
			
			ResultSet rs = (ResultSet)callableStatement.getObject(2);
			
			ToJSON converter = new ToJSON();
			JSONArray json = new JSONArray();
			
			json = converter.toJSONArray(rs);
			
			returnString = json.toString();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			if (conn != null) conn.close();
			
		}
		return returnString;
	
	}
	
	@Path("/teamstatistics")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String ReturnTeamStatistics(@QueryParam("team") String team) throws Exception {
		String returnString = null;
		Connection conn = null;
		
		System.out.println("team:" + team);
		
		try{
			conn = OracleConnection.OracleConnectionConn().getConnection();
			
			String getteams = "{call PKG_TEAMDATA.Get_Team_Statistics(?,?)}";
			CallableStatement callableStatement = conn.prepareCall(getteams);
			callableStatement.setString(1, team);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			
			callableStatement.executeUpdate();
			
			ResultSet rs = (ResultSet)callableStatement.getObject(2);
			
			ToJSON converter = new ToJSON();
			JSONArray json = new JSONArray();
			
			json = converter.toJSONArray(rs);
			
			returnString = json.toString();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			if (conn != null) conn.close();
			
		}
		return returnString;
	
	}
}
