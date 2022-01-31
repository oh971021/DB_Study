package file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FileDAO {

	public int upload(String fileName, String fileRealName) {

		Connection con = null;
		PreparedStatement pstmt = null;
	
		String sql = "insert into fileup values (?, ?, 0)";
		
		try {

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, fileName);
			pstmt.setString(2, fileRealName);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int hit(String fileRealName) {
		Connection con = null;
		PreparedStatement pstmt = null;
	
		String sql = "update fileup set downloadcount = downloadcount + 1 where fileRealname = ?";
		
		try {

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, fileRealName);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<FileDTO> getList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from fileup";
		ArrayList<FileDTO> list = new ArrayList<FileDTO>();
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				FileDTO file = new FileDTO();
				
				file.setFileName(rs.getString(1));
				file.setFileRealName(rs.getString(2));
				file.setDownloadCount(rs.getInt(3));
				
				list.add(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
