package com.jvdkolk.wickettest.resources.external;

import de.agilecoders.wicket.webjars.request.resource.WebjarsJavaScriptResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class JQueryJsResource extends WebjarsJavaScriptResourceReference {

    private static JavaScriptResourceReference INSTANCE;

    private JQueryJsResource() {
        super("jquery/3.0.0/jquery.min.js");
    }

    public static JavaScriptResourceReference get() {
        if (INSTANCE == null) {
            INSTANCE = new JQueryJsResource();
        }
        return INSTANCE;
    }
}
