package com.github.q9029.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.q9029.servlet.wrapper.HttpRequestWrapper;
import com.github.q9029.servlet.wrapper.HttpResponseWrapper;

public class CustomTestServlet extends TestServlet {

    /** 直列化バージョンID. */
    private static final long serialVersionUID = 6644290695449836753L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // リクエストのカスタマイズ.
        req = new HttpRequestWrapper(req);

        // レスポンスのカスタマイズ.
        resp = new HttpResponseWrapper(resp);

        // リクエストボディ取得.
        ServletInputStream is = req.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        System.out.println("This is CustmizeTestServlet request.");
        System.out.println(sb.toString());

        // TestServlet.doGetの実行.
        super.doGet(req, resp);

        // TODO 実際にレスポンスボディに書き込むメソッドの作成.
        PrintWriter pw = resp.getWriter();
        System.out.println(pw.toString());
        pw.write("This is CustmizeTestServlet response.");
        pw.close();
        System.out.println(pw.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
