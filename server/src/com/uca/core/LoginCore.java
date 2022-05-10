package com.uca.core;

import spark.*;

public class LoginCore {
    public static boolean isUserLog(Request request) {
	return (request.session().attribute("user") != null);
    }
}
