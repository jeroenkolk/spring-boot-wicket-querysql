package com.jvdkolk.wickettest.resources.external;

import de.agilecoders.wicket.webjars.request.resource.WebjarsCssResourceReference;
import org.apache.wicket.request.resource.CssResourceReference;

public class BootstrapCssResource extends WebjarsCssResourceReference {

    private static CssResourceReference INSTANCE;

    private BootstrapCssResource() {
        super("bootstrap/4.1.3/css/bootstrap.min.css");
    }

    public static CssResourceReference get() {
        if (INSTANCE == null) {
            INSTANCE = new BootstrapCssResource();
        }
        return INSTANCE;
    }
}
