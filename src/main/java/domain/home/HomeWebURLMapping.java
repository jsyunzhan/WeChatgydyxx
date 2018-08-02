package domain.home;

public final class HomeWebURLMapping {
    private HomeWebURLMapping(){
    }

    public static final String HOME_ROOT = "/home/";

    /*******************通知管理*************************/
    /**
     * 去通知管理页面
     */
    public static final String NOTICE_MANAGEMENT_PAGE = HOME_ROOT + "noticemanpage";

    /**
     * 通知管理分页
     */
    public static final String NOTICE_MANAGEMENT_LIST = NOTICE_MANAGEMENT_PAGE + "/list";

    /**
     * 通知管理新增
     */
    public static final String NOTICE_MANAGEMENT_ADD = NOTICE_MANAGEMENT_PAGE + "/add";

    /**
     * 通知管理修改
     */
    public static final String NOTICE_MANAGEMENT_EDIT = NOTICE_MANAGEMENT_PAGE + "/edit";

    /**
     * 通知管理删除
     */
    public static final String NOTICE_MANAGEMENT_DELETE = NOTICE_MANAGEMENT_PAGE + "/delete/{id}";

    /**
     * 文件上传回显
     */
    public static final String NOTICE_MANAGEMENT_PICTURE_DETAIL = NOTICE_MANAGEMENT_PAGE + "/pictureDetail";

    /**
     * 根据文件路径显示
     */
    public static final String NOTICE_MANAGEMENT_PICTURE_SHOW = HOME_ROOT + "picture/show";

    /**
     * 通知管理图上传
     */
    public static final String NOTICE_MANAGEMENT_PICTURE_UPLOAD = NOTICE_MANAGEMENT_PAGE + "/pictureUpload/{name}";

}
