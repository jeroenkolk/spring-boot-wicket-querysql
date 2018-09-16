package com.jvdkolk.wickettest.pages.home;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.jvdkolk.wickettest.pages.base.BasePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.springframework.security.core.context.SecurityContextHolder;

@WicketHomePage
public class HomePage extends BasePage<Void> {

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new Label("bla", Model.of(SecurityContextHolder.getContext().getAuthentication().getName())));
    }
}
