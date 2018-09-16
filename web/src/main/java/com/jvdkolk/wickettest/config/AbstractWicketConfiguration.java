package com.jvdkolk.wickettest.config;

import com.giffing.wicket.spring.boot.context.extensions.WicketApplicationInitConfiguration;
import de.agilecoders.wicket.webjars.WicketWebjars;
import lombok.RequiredArgsConstructor;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.markup.head.filter.JavaScriptFilteredIntoFooterHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.ResourceReference;
import org.springframework.core.env.Environment;

@RequiredArgsConstructor
public abstract class AbstractWicketConfiguration implements WicketApplicationInitConfiguration {

    private static final String DEV_PROFILE = "development";

    private WebApplication application;

    private final Environment environment;

    @Override
    public final void init(final WebApplication application) {
        this.application = application;

        //Add the webjars
        WicketWebjars.install(application);

        //Mount pages and resources
        mountPages();
        mountResources();


        if (environment.acceptsProfiles(DEV_PROFILE)) {
            application.setConfigurationType(RuntimeConfigurationType.DEVELOPMENT);
        }

        //Make sure all the javascript files are put in the body instead of the header
        //for faster page loading
        application.setHeaderResponseDecorator(response -> new JavaScriptFilteredIntoFooterHeaderResponse(response, "footer-container"));
    }

    /**
     * Use to mount a resource
     * @param path the path to the resource
     * @param resourceReference the resource that should be put on the path location
     */
    protected final void mountResource(final String path, final ResourceReference resourceReference) {
        application.mountResource(path, resourceReference);
    }

    /**
     * Use to mount a page
     * @param path the path to the page
     * @param pageClass the page class
     */
    protected final void mountPage(final String path, final Class<? extends WebPage> pageClass) {
        application.mountPage(path, pageClass);
    }

    /**
     * Called in the init phase
     * override this method and use the mountPage method
     */
    protected void mountPages() {}

    /**
     * Called in the init phase
     * override this method and use the mountResource method
     */
    protected void mountResources() {}
}
