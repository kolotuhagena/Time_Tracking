package edu.time_tracker.java_external.web.controller.controller_util;

import java.util.ResourceBundle;

public class MessageUtil {
    private static MessageUtil INSTANCE;
    private static ResourceBundle resourceBundle;


    public static final String SERVLET_EXCEPTION = "messageHelper.servlet";
    public static final String USERNAME_EXCEPTION = "messageHelper.username";
    public static final String PASSWORD_EXCEPTION = "messageHelper.password";
    public static final String EMAIL_EXCEPTION = "messageHelper.email";
    public static final String EXIST_USERNAME = "messageHelper.existUsername";



    private MessageUtil() {
        //сукупність ресурсів
        resourceBundle = ResourceBundle.getBundle("language");
    }

    /**
     * Singleton
     *
     * @return INSTANCE
     */
    public static MessageUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (MessageUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MessageUtil();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Method which return message from bungle
     *
     * @return INSTANCE
     */
    public String getMessageException(String messageException) {
        return resourceBundle.getString(messageException);
    }
}
