package com.js.m3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.js.main.DBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MovieDAO {

	// static �� �پ����� ���� �ǰ�,
	// ���� �� �Ǵµ� ��?
		// JVM�� �ڹٸ� ������ ��, ����ƽ ������ �������� �����Ѵ�.
		// ����ƽ ���� ���°� �޸𸮺κе� ����. ��? �������÷��� ������ ���� ���°� ����
		// ���� ������ ��ü�����ؾ���.
	
	// ��ü�� �ϳ��� ���� ���� (�̱��� ����)	
	private static final MovieDAO MDAO = new MovieDAO();
	
	private MovieDAO() {}
	
	// �ٸ� ��Ʈ�ѷ����� ��ü�� ���鶧 ���͸� �̿��ؼ� ����Ѵ�
	public static MovieDAO getMdao() {
		return MDAO;
	}



	// �ʵ念��
		// ����ƽ�������� �ϸ� �ٷ� ��� ����
	private ArrayList<Movie> movies;
	
	public void getAllmovie(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from movie_test";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			movies = new ArrayList<Movie>();
			
			Movie m = null;
			
			while (rs.next()) {
				m = new Movie();

				m.setNo(rs.getInt("m_no"));
				m.setTitle(rs.getString("m_title"));
				m.setActor(rs.getString("m_actor"));
				m.setImg(rs.getString("m_img"));
				m.setStory(rs.getString("m_story"));
				
				movies.add(m);
			}
			
			
			request.setAttribute("movies", movies);
			request.setAttribute("basicImg", request.getParameter("basicImg"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public void setMovie(HttpServletRequest request) throws IOException {
		
		String path = request.getSession().getServletContext().getRealPath("img");
		System.out.println(path);
		
		MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());			
		
		String title = mr.getParameter("title");
		String actor = mr.getParameter("actor");		
		String img = mr.getFilesystemName("img"); 
		String story = mr.getParameter("story");
		
		System.out.println(title);
		System.out.println(actor);
		System.out.println(img);
		System.out.println(story);
		
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into movie_test values(movie_test_seq.nextval, ?, ?, ?, ?)";
		
		try {
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, actor);
			pstmt.setString(3, img);
			pstmt.setString(4, story);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "��� ����!");
			} else {
				request.setAttribute("r", "��� ����!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public void delMovie(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete movie_test where m_no = ?";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
		
			int no = Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "���� ����!");
			} else {
				request.setAttribute("r", "���� ����!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB���� ����!");
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}

	public void updateMovie(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "update movie_test set m_title = ?, m_actor = ?, m_story = ? where m_no = ?";
		try {	
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String title = request.getParameter("title");
			String actor = request.getParameter("actor");
			String story = request.getParameter("story");
			int no = Integer.parseInt(request.getParameter("no"));
			
			System.out.println(title);
			System.out.println(actor);
			System.out.println(story);
			System.out.println(no);
			
			pstmt.setString(1, title);
			pstmt.setString(2, actor);
			pstmt.setString(3, story);
			pstmt.setInt(4, no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "���� ����!");
			} else {
				request.setAttribute("r", "���� ����!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB ���� ����..");
		} finally {
			DBManager.close(con, pstmt, null);
		}
				
	}
	
	public void getMovie(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		request.setAttribute("basicImg", request.getParameter("basicImg"));
		
		String sql = "select * from movie_test where m_no=?";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
		
			pstmt.setInt(1, Integer.parseInt(request.getParameter("num")));

			// ����ǥ�� ä��� �����ؾߵȴ�.
			rs = pstmt.executeQuery();

			Movie m = null;
			
			if (rs.next()) {
				m = new Movie();
				m.setNo(rs.getInt("m_no"));
				m.setTitle(rs.getString("m_title"));
				m.setActor(rs.getString("m_actor"));
				m.setImg(rs.getString("m_img"));
				m.setStory(rs.getString("m_story"));
				request.setAttribute("movie", m);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public void updateMovie2(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String basicImg = (String)request.getAttribute("basicImg");
		System.out.println("img Log : " + basicImg);
		
		String sql = "update movie_test set m_title = ?, m_actor = ?, m_img = ?, m_story = ? where m_no = ?";
		try {	
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String path = request.getSession().getServletContext().getRealPath("img");
			System.out.println(path);
			
			MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());		
			
			String title = mr.getParameter("title");
			String actor = mr.getParameter("actor");
			String story = mr.getParameter("story");
			String img = mr.getFilesystemName("img");
			int no = Integer.parseInt(mr.getParameter("no"));
			
			System.out.println(title);
			System.out.println(actor);
			System.out.println(story);
			System.out.println(img);
			System.out.println("img Log : " + basicImg);
			System.out.println(no);
			
			pstmt.setString(1, title);
			pstmt.setString(2, actor);
			if(img != null) {
				pstmt.setString(3, img);
			} else {
				pstmt.setString(3, basicImg);
			}
			pstmt.setString(4, story);
			pstmt.setInt(5, no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "���� ����!");
			} else {
				request.setAttribute("r", "���� ����!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "DB ���� ����..");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public void paging(int page, HttpServletRequest request) {
	
		// page : ���� ������ ��ȣ
		request.setAttribute("curPageNo", page);

		int cnt = 3;	// �� �������� ������ ����
		// size = �迭 length
		int total = movies.size();	// ��ü ������ ����
		
		// �� ������ �� ���
		int pageCount = (int)Math.ceil((double)total / cnt);
		request.setAttribute("pageCount", pageCount);
		
		// �������� ���� ������ ��ȣ ���
		int start = total - (cnt * (page - 1));
		
		// �������� �� ������ ��ȣ ���
		int end = (page == pageCount) ? -1 : start - (cnt + 1);
		
		ArrayList<Movie> items = new ArrayList<Movie>();
		for (int i = start-1; i > end; i--) {
			// movies�� �ε�����ȣ�� ���缭 ������ �´�
				// movies = ��� �����Ͱ� ����ִ� �迭
			items.add(movies.get(i));
		}
		
		// ������ ��ȣ�� �´� �����ͷ��� �����ش�.
		request.setAttribute("movies", items);
		
	}
	
}
