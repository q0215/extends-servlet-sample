package com.github.q9029.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	/** 直列化バージョンID. */
	private static final long serialVersionUID = -2911458555197950564L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// リクエストボディ取得.
		ServletInputStream is = req.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		System.out.println("This is TestServlet request.");
		System.out.println(sb.toString());

		// レスポンス書き込み.
		PrintWriter writer = resp.getWriter();
		writer.print("This is TestServlet response.");
		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
