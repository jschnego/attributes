package com.js;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class ConcurrencyTest {

    @Test
    public void shouldTeachMeSomething() throws IOException {
	ServerSocket socket = new ServerSocket();
	Socket conn = socket.accept();
    }
}
