package com.github.q9029.servlet.wrapper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.github.q9029.servlet.io.ExtendOutputStream;
import com.github.q9029.servlet.io.ExtendPrintWriter;

public class HttpResponseWrapper extends HttpServletResponseWrapper {

    ExtendPrintWriter pw;

    public HttpResponseWrapper(HttpServletResponse response) {
        super(response);

        pw = new ExtendPrintWriter(new ExtendOutputStream());
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return pw;
    }

    @Override
    public String toString() {
        return pw.toString();
    }
}
