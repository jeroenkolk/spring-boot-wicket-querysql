package com.jvdkolk.wickettest.pages.base;

import com.jvdkolk.wickettest.components.navbar.NavBar;
import com.jvdkolk.wickettest.resources.MainCssResource;
import com.jvdkolk.wickettest.resources.MainJsResource;
import com.jvdkolk.wickettest.resources.external.BootstrapCssResource;
import com.jvdkolk.wickettest.resources.external.BootstrapJsResource;
import com.jvdkolk.wickettest.resources.external.JQueryJsResource;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.filter.HeaderResponseContainer;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Simple base page that adds all the css and js resources
 * @param <T> (page model)
 */
public class BasePage<T> extends GenericWebPage<T> {

    public BasePage() {
    }

    public BasePage(final IModel<T> model) {
        super(model);
    }

    public BasePage(final PageParameters parameters) {
        super(parameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new HeaderResponseContainer("footer-container", "footer-container"));
        add(new NavBar("navbar"));
    }

    @Override
    public void renderHead(final IHeaderResponse response) {
        super.renderHead(response);

        response.render(CssReferenceHeaderItem.forReference(MainCssResource.get()));
        response.render(CssReferenceHeaderItem.forReference(BootstrapCssResource.get()));
        response.render(JavaScriptHeaderItem.forReference(JQueryJsResource.get()));
        response.render(JavaScriptHeaderItem.forReference(BootstrapJsResource.get()));
        response.render(JavaScriptHeaderItem.forReference(MainJsResource.get()));
    }
}
