package com.indi.kodt.core.spring.config;

/**
 * Java 상수.
 *
 * @since 2014.1.1
 */
public interface Constant {

	public static final String URL_ROOT_IMAGE = "URL_ROOT_IMAGE";
	public static final String URL_ROOT_FILE = "URL_ROOT_FILE";

	public static final String IMAGE_ROOT_PROPERTY_NAME = "URL_ROOT_PATH_IMAGE";
	public static final String JAVASCRIPT_ROOT_PROPERTY_NAME = "URL_ROOT_PATH_JAVASCRIPT";
	public static final String CSS_ROOT_PROPERTY_NAME = "URL_ROOT_PATH_CSS";
	public static final String DAUMEDITOR_ROOT_PROPERTY_NAME = "URL_ROOT_PATH_DAUMEDITOR";
	public static final String BOOTSTRAP_ROOT_PROPERTY_NAME = "URL_ROOT_PATH_BOOTSTRAP";
	//public static final String UPLOAD_ROOT_PROPERTY_NAME = "URL_ROOT_PATH_UPLOAD";

	public static final String PARAMETER_MAP = "parameterMap";
	public static final String PARAM_FRONT_MAP = "paramFrontMap";
	public static final String PARAM_ADMIN_MAP = "paramAdminMap";
	public static final String RESULT_MAP = "resultMap";

	public static final String BROWSER_IE = "BROWSER_IE";
	public static final String BROWSER_FF = "BROWSER_FF";
	public static final String BROWSER_CR = "BROWSER_CR";
	public static final String BROWSER_OP = "BROWSER_OP";
	public static final String BROWSER_ETC = "BROWSER_ETC";

	public static final String WEB_CRYPTO_HEADER = "■";
	public static final String EXCEL_GROUP_NORMAL = "EXCEL_GROUP_NORMAL";

	public static final String LIST_ORDER_BY_STRING = "listOrderByString";
	public static final String IS_AUTO_RELOAD = "IS_AUTO_RELOAD";

	public static final String WEB_TOP_MENU_ID = "WEB_FRONT";

	public static final String COMC60_FILE_VO_LIST = "comC60FileVOList";

	/**
	 * Layer
	 */
	public static final String LAYER_SERVLET = "LAYER_SERVLET";
	public static final String LAYER_BUSINESS = "LAYER_BUSINESS";
	public static final String LAYER_PERSISTANCE = "LAYER_PERSISTANCE";

	/**
	 * URI Kind
	 */
	public static final String URI_KIND = "uriKind";
	public static final String URI_KIND_DO = "do";
	public static final String URI_KIND_AJAX = "ajax";
	public static final String URI_KIND_DOJAX = "dojax";//do(html)을 ajax로 가져오는 경우
	public static final String URI_KIND_EXCEL = "excel";
	public static final String URI_KIND_POPUP = "popup";
	public static final String URI_PREFIX = "/";
	public static final String URI_PREFIX_ADMIN = "/taiws/admin";
	public static final String URI_PREFIX_FRONT = "/taiws/front";
	public static final String SITE_KIND_ADMIN = "admin";
	public static final String SITE_KIND_FRONT = "front";

	/**
	 * Common Parameter Name
	 */
    public static final String PAGING_PAGE_PER_STRING = "PAGING_PAGE_PER_STRING";
    public static final String PAGING_ROW_PER_PAGE = "PAGING_ROW_PER_PAGE";
    public static final String PAGING_PAGE_PER_STRING_FRONT = "PAGING_PAGE_PER_STRING_FRONT";
    public static final String PAGING_ROW_PER_PAGE_FRONT = "PAGING_ROW_PER_PAGE_FRONT";

	public static final String PARAM_PAGE_PER_STRING = "pagePerString";
	public static final String PARAM_ROW_PER_PAGE = "rowPerPage";
	public static final String PARAM_PAGENUM = "pagenum";
	public static final String PARAM_CURRENT_URI_ID = "currentUriId";
	public static final String PARAM_LANGUAGE = "LANG";
	public static final String SESSION_LANGUAGE = "languageInSession";
	public static final String PARAM_THUMBNAIL = "thumbnail";
	public static final String PARAM_THUMBNAIL_Y = "Y";
	public static final String PARAM_THUMBNAIL_N = "N";
	public static final String PARAM_THUMBNAIL_EXT = ".thumb.png";
	public static final String PARAM_FILE_ID_LIST = "fileIdList";
	public static final String PARAM_CMD = "CMD";
	public static final String PARAM_RSA_SUFFIX = "[RSA]";
	public static final String PARAM_IS_JOIN = "IS_JOIN";

	/**
	 * Session Key
	 */
	public static final String SESSION_HEAD = "SESSION.com.tacss.";
	public static final String ATTRIBUTE_HEAD = "ATTRIBUTE.com.tacss.";

	public static final String PARAMETER_HEADER_HOST = "PARAMETER_HEADER_HOST";
	public static final String PARAMETER_REQUEST_URI = "PARAMETER_REQUEST_URI";
	public static final String PARAMETER_REQUEST_URI_ID = "PARAMETER_REQUEST_URI_ID";
	public static final String PARAMETER_REQUEST_URI_KEY = "PARAMETER_REQUEST_URI_KEY";
	public static final String PARAMETER_REMOTE_ADDR = "PARAMETER_REMOTE_ADDR";
	public static final String PARAMETER_REMOTE_HOST = "PARAMETER_REMOTE_HOST";
	public static final String PARAMETER_SKINID = "PARAMETER_SKINID";
	public static final String BROWSER_KIND = "BROWSER_KIND";
	public static final String CURRENT_SESSION_ID = "CURRENT_SESSION_ID";
	public static final String DATA_CRYPTO = "DATA_CRYPTO";

	public static final String JSON_INTERFACE_VO = ATTRIBUTE_HEAD+"JSON_INTERFACE_VO";
	public static final String JSONP_NAME = "JSONP_NAME";

	public static final String RESULT_INFO_VO = ATTRIBUTE_HEAD+"RESULT_INFO_VO";
    public static final String RESULT_CODE = "RESULT_CODE";
    public static final String RESULT_MESSAGE = "RESULT_MESSAGE";
    public static final String RESULT_REDIRECT_URL = "RESULT_REDIRECT_URL";
    public static final String RESULT_CODE_NORMAL = "0000"; //결과 정상
    public static final String RESULT_CODE_ERROR = "9999"; //결과 오류 (오류 코드를 특정하지 않는 경우 9999가 된다)

    public static final String EXCEPTION_VO = "EXCEPTION_VO";

	public static final String SESSION_USER_FRONT_VO = SESSION_HEAD+"USER_FRONT_VO";
	public static final String SESSION_USER_ADMIN_VO = SESSION_HEAD+"USER_ADMIN_VO";
	public static final String SESSION_TEMP_INFO = SESSION_HEAD+"TEMP_INFO";
	public static final String SESSION_TEMP_INFO_ATTACH = "ATTACH";

	public static final String SESSION_TRACK_HEAD = "sessionTrack_";

	public static final String BEFORE_REQUEST_URI = "beforeRequestURI";

	/**
	 * Properties Key.
	 * config-common.properties
	 */
	public static final String PROJECT = "PROJECT";
	public static final String SERVER = "SERVER";

	public static final String SERVER_LOCAL = "local";
	public static final String SERVER_DEV = "dev";
	public static final String SERVER_STG = "stg";
	public static final String SERVER_REAL = "real";

	public static final String TASK_IS_LOG = "TASK_IS_LOG";
	public static final String TASK_IS_LOG_Y = "Y";
	public static final String TASK_IS_LOG_N = "N";
	public static final String TASK_IS_RUN = "TASK_IS_RUN";
	public static final String TASK_IS_RUN_Y = "Y";
	public static final String TASK_IS_RUN_N = "N";

	public static final String SESSION_TRACK_RUN_FRONT = "SESSION_TRACK_RUN_FRONT";
	public static final String SESSION_TRACK_RUN_FRONT_Y = "Y";
	public static final String SESSION_TRACK_RUN_FRONT_N = "N";
	public static final String SESSION_TRACK_RUN_ADMIN = "SESSION_TRACK_RUN_ADMIN";
	public static final String SESSION_TRACK_RUN_ADMIN_Y = "Y";
	public static final String SESSION_TRACK_RUN_ADMIN_N = "N";

	public static final String LGUPLUS_XPAY_CONF_PATH = "LGUPLUS_XPAY_CONF_PATH";
	public static final String LGUPLUS_XPAY_SHOP_ID = "LGUPLUS_XPAY_SHOP_ID";

	/**
	 * UserVO
	 */
	public static final String USER_ADMIN_VO_USER_ID_IN_SESSION = "userIdInSession";
	public static final String USER_ADMIN_VO_LOGIN_ID_IN_SESSION = "loginIdInSession";
	public static final String USER_ADMIN_VO_USER_GRP_ID_IN_SESSION = "userGrpIdInSession";
	public static final String USER_FRONT_VO_USER_ID_IN_SESSION = "userIdInSession";
	public static final String USER_FRONT_VO_LOGIN_ID_IN_SESSION = "loginIdInSession";
	public static final String USER_FRONT_VO_USER_GRP_ID_IN_SESSION = "userGrpIdInSession";

	public static final String CURRENT_URI_KEY_AUTH = "currentURIKeyAuth";

	/**
	 * File Category
	 */
	public static final String PARAM_CATEGORY_FILE = "CATEGORY_FILE";
	public static final String PARAM_CATEGORY_IMAGE = "CATEGORY_IMAGE";
	public static final String CATEGORY_FILE_SYSA11 = "sysA11";//공지사항
	public static final String CATEGORY_FILE_SYSA10 = "sysA10";//게시판
	public static final String CATEGORY_FILE_EMLA10 = "emlA10";

	/**
	 * File Server
	 */
	public static final String IMAGE_SERVER_ID_1 = "IS1";
	public static final String FILE_SERVER_ID_1 = "FS1";

	/**
	 * Attribute - RSA
	 */
	public static final String ATTR_RSA_PRIVATE_KEY = Constant.SESSION_HEAD + "RSA_CONFIRM_PRIVATE_KEY"; //to session
	public static final String ATTR_RSA_PUBLIC_KEY_MODULUS = "RSA_PUBLIC_KEY_MODULUS"; //to browser
	public static final String ATTR_RSA_PUBLIC_KEY_EXPONENT = "RSA_PUBLIC_KEY_EXPONENT"; //to browser

	/**
	* FEED
	*/
	public static final String SELECT_FEED = "selectFeed";
	public static final String PICKUP_FEED = "pickupFeed";
	public static final String FEED_SEQ = "FEED_SEQ"; // 피드를 스크롤 할 때 사용
	public static final String SUB_FEED_SEQ = "SUB_FEED_SEQ"; // 팝업 피드를 스크롤 할 때
	// 사용
	public static final String FEED_ALL_SEQ = "FEED_ALL_SEQ"; // 피드 모아보기를 스크롤 할
	// 때 사용 (FEED
	// MAP 의
	// FEED_SEQ 와
	// 겹치므로 이름을 ALL
	// 붙임)
	public static final String FEED_DATE_SEQ = "FEED_DATE_SEQ"; // 피드 시퀀스가 날짜형태
	public static final String FEED_SEQ_TO_PICKUP = "FEED_SEQ_TO_PICKUP"; // 피드
	// 모아보기에서
	// 쿼리가
	// 복수
	// 형태이므로
	// 한개만
	// 찝을
	// KEY
	public static final String FEED_URI_ID = "FEED_URI_ID"; // Tag Library 에서 어떤
	// 피드를 찍을지 KEY = URI
	// ID
	public static final String CURRENT_LAST_FEED_SEQ = "CURRENT_LAST_FEED_SEQ"; // 위FEED_SEQ
	// 의
	// 마지막
	// 출력
	// KEY

	public static final String SELECT_SUB_FEED = "selectSubFeed";
	public static final String PICKUP_SUB_FEED = "pickupSubFeed";
	public static final String CURRENT_LAST_SUB_FEED_SEQ = "CURRENT_LAST_SUB_FEED_SEQ";
	public static final String SUB_FEED_DIRECTION = "SUB_FEED_DIRECTION";

}