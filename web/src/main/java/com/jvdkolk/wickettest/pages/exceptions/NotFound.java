package com.jvdkolk.wickettest.pages.exceptions;

import com.giffing.wicket.spring.boot.context.scan.WicketAccessDeniedPage;
import com.giffing.wicket.spring.boot.context.scan.WicketExpiredPage;
import com.giffing.wicket.spring.boot.context.scan.WicketInternalErrorPage;
import com.jvdkolk.wickettest.pages.base.BasePage;

/**
 * Page where the user will be redirected to when
 * one of the following annotations are true
 *
 * These can be split up into different pages
 */
@WicketAccessDeniedPage
@WicketExpiredPage
@WicketInternalErrorPage
public class NotFound extends BasePage<Void> {

}
