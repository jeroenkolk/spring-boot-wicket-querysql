package com.jvdkolk.wickettest.config;

import com.giffing.wicket.spring.boot.context.extensions.ApplicationInitExtension;
import com.jvdkolk.wickettest.pages.exceptions.NotFound;
import com.jvdkolk.wickettest.pages.home.HomePage;
import com.jvdkolk.wickettest.pages.login.LoginPage;
import com.jvdkolk.wickettest.resources.external.BootstrapCssResource;
import com.jvdkolk.wickettest.resources.external.BootstrapJsResource;
import com.jvdkolk.wickettest.resources.external.JQueryJsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * The main wicket configuration
 */
@ApplicationInitExtension
public class WicketConfig extends AbstractWicketConfiguration {

    @Autowired
    public WicketConfig(final Environment environment) {
        super(environment);
    }

    @Override
    public void mountPages() {
        mountPage("/", HomePage.class);
        mountPage("/notfound", NotFound.class);
        mountPage("/login", LoginPage.class);
    }

    @Override
    public void mountResources() {
        mountResource("/css/bootstrap.css", BootstrapCssResource.get());
        mountResource("/js/jquery.js", JQueryJsResource.get());
        mountResource("/js/bootstrap.js", BootstrapJsResource.get());
    }
}
