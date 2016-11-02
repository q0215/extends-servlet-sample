package com.github.q9029.servlet.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

public class ExtendOutputStream extends ServletOutputStream {

    private ByteArrayOutputStream os;

    public ExtendOutputStream() {
        this.os = new ByteArrayOutputStream();
    }

    @Override
    public void write(int b) throws IOException {
        os.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        os.write(b);
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setWriteListener(WriteListener arg0) {
    }

    @Override
    public String toString() {
        try {
            return new String(os.toByteArray(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
