package com.jvdkolk.wickettest.resources.external;

import de.agilecoders.wicket.webjars.request.resource.WebjarsJavaScriptResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class BootstrapJsResource extends WebjarsJavaScriptResourceReference {

    private static JavaScriptResourceReference INSTANCE;

    private BootstrapJsResource() {
        super("bootstrap/4.1.3/js/bootstrap.min.js");
    }

    public static JavaScriptResourceReference get() {
        if (INSTANCE == null) {
            INSTANCE = new BootstrapJsResource();
        }
        return INSTANCE;
    }
}
