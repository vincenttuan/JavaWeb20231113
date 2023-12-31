package guestbook.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.model.Guestbook;
import guestbook.model.GuestbookDao;
import guestbook.model.GuestbookDaoInMemory;
import guestbook.model.GuestbookDaoMySQL;

@WebServlet("/guestbook")
public class GuestbookServlet extends HttpServlet {
	
	//private GuestbookDao guestbookDao = new GuestbookDaoInMemory();
	private GuestbookDao guestbookDao = new GuestbookDaoMySQL();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得所有留言紀錄
		List<Guestbook> guestbooks = guestbookDao.readAll();
		
		// 重導到 /WEB-INF/view/guestbook/guestbook.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/guestbook/guestbook.jsp");
		req.setAttribute("guestbooks", guestbooks); // 傳遞參數給 jsp
		rd.forward(req, resp);
	}
	
	// 給表單新增使用
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nickname = req.getParameter("nickname");
		Integer age = Integer.parseInt(req.getParameter("age")); // String 直接轉型 int, 自動裝箱 Integer
		String sex = req.getParameter("sex");
		String message = req.getParameter("message");
		
		// 建立 GuestBook 物件
		Guestbook guestbook = new Guestbook();
		int maxId = guestbookDao.readAll() // 取得所有 guestbook 集合
								.stream()  // 轉為 stream 串流, 以利後續分析
								//.mapToInt(gb -> gb.getId())
								.mapToInt(Guestbook::getId)
								.max()
								.orElse(0);
		
		guestbook.setId(maxId + 1);
		guestbook.setNickname(nickname);
		guestbook.setAge(age);
		guestbook.setSex(sex);
		guestbook.setDate(new Date());
		guestbook.setMessage(message.trim());
		// 加入到資料庫中
		guestbookDao.create(guestbook);
		
		// 重導到新增完成頁面 /WEB-INF/view/guestbook/guestbook_result.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/guestbook/guestbook_result.jsp");
		rd.forward(req, resp);
		
		// 請瀏覽器根據下面的網址自行重導
		//resp.sendRedirect("./guestbook");
		//resp.sendRedirect("/JavaWeb20231113/guestbook");
		//resp.sendRedirect("http://localhost:8080/JavaWeb20231113/guestbook");
		//resp.sendRedirect("https://tw.yahoo.com");
		
	}
	
}
