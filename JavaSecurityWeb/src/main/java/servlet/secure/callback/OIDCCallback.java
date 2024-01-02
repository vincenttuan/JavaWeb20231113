package servlet.secure.callback;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nimbusds.jwt.JWTClaimsSet;

/**
 * 此 Servlet 處理從 Google OAuth 2.0 服務重定向回的 OAuth 2.0 回調。
 * 它將解析授權碼，獲取ID令牌，然後驗證令牌的有效性。
 * 如果令牌有效，它將從ID令牌中提取用戶信息，並將令牌發送到報告服務。
 */
@WebServlet("/secure/callback/oidc")
public class OIDCCallback extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		// 取得授權碼
		String code = req.getParameter("code");
		resp.getWriter().println("code: " + code);
	}
}