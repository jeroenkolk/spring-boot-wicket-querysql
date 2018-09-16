package com.jvdkolk.wickettest.resources;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class MainJsResource extends JavaScriptResourceReference {

    private static JavaScriptResourceReference INSTANCE;

    private MainJsResource() {
        super(MainJsResource.class, "main.js");
    }

    public static JavaScriptResourceReference get() {
        if (INSTANCE == null) {
            INSTANCE = new MainJsResource();
        }
        return INSTANCE;
    }
}
