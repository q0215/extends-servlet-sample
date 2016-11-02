package com.github.q9029.servlet.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

public class ExtendInputStream extends ServletInputStream {

    private ByteArrayInputStream is;

    public ExtendInputStream(byte[] buffer) {
        this.is = new ByteArrayInputStream(buffer);
    }

    @Override
    public int read() throws IOException {
        return is.read();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setReadListener(ReadListener arg0) {
    }
}
