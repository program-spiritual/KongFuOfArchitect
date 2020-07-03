package com.itranswarp.learnjava.framework;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/favicon.ico", "/static/*" })
public class FileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext ctx = req.getServletContext();
		// RequestURI包含ContextPath,需要去掉:
		String urlPath = req.getRequestURI().substring(ctx.getContextPath().length());
		// 获取真实文件路径:
		String filepath = ctx.getRealPath(urlPath);
		if (filepath == null) {
			// 无法获取到路径:
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		Path path = Paths.get(filepath);
		if (!path.toFile().isFile()) {
			// 文件不存在:
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		// 根据文件名猜测Content-Type:
		String mime = Files.probeContentType(path);
		if (mime == null) {
			mime = "application/octet-stream";
		}
		resp.setContentType(mime);
		// 读取文件并写入Response:
		OutputStream output = resp.getOutputStream();
		try (InputStream input = new BufferedInputStream(new FileInputStream(filepath))) {
			input.transferTo(output);
		}
		output.flush();
	}
}