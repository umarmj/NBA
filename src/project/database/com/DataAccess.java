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
	
	//team roasters
	@Path("/teamroster")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String ReturnTeamRoster(@QueryParam("team") String team,@QueryParam("season") String season) throws Exception {
		String returnString = null;
		Connection conn = null;
		
		System.out.println("team:" + team);
		
		try{
			conn = OracleConnection.OracleConnectionConn().getConnection();
			
			System.out.println("team: "+team);
			System.out.println("season: "+season);
			String getteams = "{call PKG_TEAMDATA.Get_Team_Roster(?,?,?)}";
			CallableStatement callableStatement = conn.prepareCall(getteams);
			callableStatement.setString(1, team);
			callableStatement.setString(2, season);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			
			callableStatement.executeUpdate();
			
			ResultSet rs = (ResultSet)callableStatement.getObject(3);
			
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
	@Path("/topten")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String ReturnTopTen(@QueryParam("season") String season,@QueryParam("section") String section) throws Exception {
		String returnString = null;
		Connection conn = null;
		
		//System.out.println("team:" + team);
		
		try{
			conn = OracleConnection.OracleConnectionConn().getConnection();
			
			//System.out.println("team: "+team);
			//System.out.println("season: "+season);
			String getteams = "{call PKG_PLAYERDATA.Get_Top_Ten(?,?,?)}";
			CallableStatement callableStatement = conn.prepareCall(getteams);
			callableStatement.setString(1, season);
			callableStatement.setString(2, section);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			
			callableStatement.executeUpdate();
			
			ResultSet rs = (ResultSet)callableStatement.getObject(3);
			
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
	@Path("/game")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String ReturnGame(@QueryParam("date") String date) throws Exception {
		String returnString = null;
		Connection conn = null;
		
		//System.out.println("team:" + team);
		
		try{
			conn = OracleConnection.OracleConnectionConn().getConnection();
			
			//System.out.println("team: "+team);
			//System.out.println("season: "+season);
			String getteams = "{call PKG_GAME.Get_Game(?,?)}";
			CallableStatement callableStatement = conn.prepareCall(getteams);
			callableStatement.setString(1, date);
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
	
	@Path("/gameTeamStats")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String ReturnGameTeamStats(@QueryParam("gameId") String game,@QueryParam("team") String team) throws Exception {
		String returnString = null;
		Connection conn = null;
		
		//System.out.println("team:" + team);
		
		try{
			conn = OracleConnection.OracleConnectionConn().getConnection();
			
			//System.out.println("team: "+team);
			//System.out.println("season: "+season);
			String getteams = "{call PKG_GAME.Get_Game_TeamStats(?,?,?)}";
			CallableStatement callableStatement = conn.prepareCall(getteams);
			callableStatement.setString(1, game);
			callableStatement.setString(2, team);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			
			callableStatement.executeUpdate();
			
			ResultSet rs = (ResultSet)callableStatement.getObject(3);
			
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
	
	@Path("/gamePlayerStats")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String ReturnGameplayerStats(@QueryParam("gameId") String game,@QueryParam("team") String team) throws Exception {
		String returnString = null;
		Connection conn = null;
		
		//System.out.println("team:" + team);
		
		try{
			conn = OracleConnection.OracleConnectionConn().getConnection();
			
			//System.out.println("team: "+team);
			//System.out.println("season: "+season);
			String getteams = "{call PKG_GAME.Get_Game_PlayerStats(?,?,?)}";
			CallableStatement callableStatement = conn.prepareCall(getteams);
			callableStatement.setString(1, game);
			callableStatement.setString(2, team);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			
			callableStatement.executeUpdate();
			
			ResultSet rs = (ResultSet)callableStatement.getObject(3);
			
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
	
	@Path("/compare")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String Compare(@QueryParam("playerOne") String playerOne,@QueryParam("playerTwo") String playerTwo) throws Exception {
		String returnString = null;
		Connection conn = null;
		
		//System.out.println("team:" + team);
		
		try{
			conn = OracleConnection.OracleConnectionConn().getConnection();
			
			System.out.println(playerOne);
			System.out.println(playerTwo);
			String comparePlayers = "{call PKG_PLAYERDATA.Compare(?,?,?)}";
			CallableStatement callableStatement = conn.prepareCall(comparePlayers);
			callableStatement.setString(1, playerOne);
			callableStatement.setString(2, playerTwo);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			
			callableStatement.executeUpdate();
			
			ResultSet rs = (ResultSet)callableStatement.getObject(3);
			
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
