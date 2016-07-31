package projectkan.constants;

/**
 * Created by willlobato on 29/07/16.
 */
public final class Constants {

    public final class Database {

        public static final String CATALOG = "willlobato";
        public static final String SCHEMA = "public";
        public static final String PK_SEQUENCE = "PK_SEQUENCE";

        /**
         * Table User
         */
        public static final String USER = "USER";
        public static final String USER_ID_SEQ = "USER_ID_SEQ";
        public static final String USER_ID_USER = "ID_USER";
        public static final String USER_USERNAME = "USERNAME";
        public static final String USER_PASSWORD = "PASSWORD";
        public static final String USER_EMAIL = "EMAIL";

        /**
         * Table Role
         */
        public static final String ROLE = "ROLE";
        public static final String ROLE_ID_SEQ = "ROLE_ID_SEQ";
        public static final String ROLE_ID_ROLE = "ID_ROLE";
        public static final String ROLE_DESCRIPTION = "DESCRIPTION";

        /**
         * Table Role_User
         */
        public static final String ROLE_USER = "ROLE_USER";
        public static final String ROLE_USER_ID_ROLE = "ID_ROLE";
        public static final String ROLE_USER_ID_USER = "ID_USER";

        /**
         * Table Project
         */
        public static final String PROJECT = "PROJECT";
        public static final String PROJECT_ID_SEQ = "PROJECT_ID_SEQ";
        public static final String PROJECT_ID_PROJECT = "id_project";
        public static final String PROJECT_ID_PROJECT_PARENT = "ID_PROJECT_PARENT";
        public static final String PROJECT_CODE = "CODE";
        public static final String PROJECT_NAME = "NAME";
        public static final String PROJECT_DESCRIPTION = "DESCRIPTION";
        public static final String PROJECT_INITIAL_DATE = "INITIAL_DATE";
        public static final String PROJECT_FINISH_DATE = "FINISH_DATE";

    }

}
