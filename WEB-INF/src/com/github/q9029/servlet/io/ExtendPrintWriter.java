package com.github.q9029.servlet.io;

import java.io.IOException;
import java.io.PrintWriter;

public class ExtendPrintWriter extends PrintWriter {

    ExtendOutputStream os;

    public ExtendPrintWriter(ExtendOutputStream out) {
        super(out);

        this.os = out;
    }

    @Override
    public void write(String s) {
        try {
            os.write(s.getBytes("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void flush() {
        try {
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return os.toString();
    }
}
