package edu.time_tracker.java_external.web.controller.controller_util;

import java.util.ResourceBundle;

public class PageConfiguration {
    private static PageConfiguration INSTANCE;
    private static ResourceBundle resourceBundle;
    private static final String NAME_OF_BUNDLE = "pageConfiguration";

    public static final String HOME_PAGE = "pageConfiguration.homePage";
    public static final String MAIN_PAGE = "pageConfiguration.mainPage";
    public static final String ERROR_PAGE = "pageConfiguration.errorPage";
    public static final String ACCOUNT_PAGE = "pageConfiguration.account_page";
    public static final String ADMIN_PAGE = "pageConfiguration.adminPage";
    public static final String REGISTRATION_PAGE = "pageConfiguration.registrationPage";



    private PageConfiguration() {
        resourceBundle = ResourceBundle.getBundle(NAME_OF_BUNDLE);
    }

    /**
     * Singleton
     *
     * @return INSTANCE
     */
    public static PageConfiguration getInstance() {
        if (INSTANCE == null) {
            synchronized (PageConfiguration.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PageConfiguration();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Method which return message from bungle (page)
     *
     * @return INSTANCE
     */
    public String getPageConfiguration(String pageConfigurationMessage) {
        return resourceBundle.getString(pageConfigurationMessage);
    }
}
