package constants;

import java.time.Duration;

/**
 * Class with project constants
 */
public class Constant {
    /**
     * Internal class with timeout variables
     */
    public static class TimeoutVariables {
        public static final int IMPLICIT_WAIT = 4;
        public static final int EXCLICIT_WAIT = 10;
    }

    /**
     * Internal class with urls assigned to Allo.ua
     */
    public static class AlloUrls {
        public static final String ALLO_HOME_PAGE_URL = "https://allo.ua/";
    }

    /**
     * Internal class with all search queries
     */
    public static class SearchQueries {
        public static final String IPHONE_QUERY = "iPhone";
    }

    /**
     * Array with browser allowed combinations
     */
    public static class BrowserCombinations {
        public static final String PLATFORM_AND_BROWSER = "linux_chrome";
        public static final String[] OS_AND_BROWSER_COMBINATIONS = {"linux_chrome", "windows_chrome", "linux_firefox", "windows_firefox"};
    }

    /**
     * Error messages for project
     */
    public static class ErrorMessages{
        public static final String WRONG_OS_BROWSER_COMBINATION_MESSAGE = " is not allowed combination. Now allowed only (linux_chrome, windows_chrome, linux_firefox, windows_firefox) combinations";
    }
}
