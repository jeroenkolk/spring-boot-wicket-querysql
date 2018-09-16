package com.jvdkolk.wickettest.resources;

import org.apache.wicket.request.resource.CssResourceReference;

public class MainCssResource extends CssResourceReference {

    private static CssResourceReference INSTANCE;

    private MainCssResource() {
        super(MainCssResource.class, "main.css");
    }

    public static CssResourceReference get() {
        if (INSTANCE == null) {
            INSTANCE = new MainCssResource();
        }
        return INSTANCE;
    }
}
