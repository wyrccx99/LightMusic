package com.brins.lightmusic.common;

import android.content.Context;

import com.brins.lightmusic.model.userlogin.UserAccountBean;
import com.brins.lightmusic.model.userlogin.UserProfileBean;

public class AppConfig {
    public static boolean isLogin = false;
    public static final String BASEURL = "保密";


    /**
     * 登录
     */
    public static final String LOGIN_EMAIL = "/login";
    public static final String USER = "/user/detail";
    public static final String DEFAULT_ID = "490583871";


    /**
     * 用户歌单
     */
    public static final String USER_PLAYLIST = "/user/playlist";



    /**
     * 轮播图
     */
    public static final String BANNER = "/banner";


    /**
     * 心动模式
     */
    public static final String INTELLIGENCE = "/playmode/intelligence/list";

    /**
     * 歌单
     */
    public static final String PLAYLIST = "/top/playlist";
    public static final String PLAYLISTDETAIL = "/playlist/detail";

    /**
     * 精选歌单
     */
    public static final String MUSICLIST_HIGHQUALITY = "/top/playlist/highquality";

    /**
     * 歌手
     */
    public static final String ARTISTS = "/top/artists";

    /**
     * 歌手分类
     */
    public static final String ARTISTS_CATEGORY = "/artist/list";


    /**
     * 歌手音乐
     */
    public static final String ARTISTS_MUSIC = "artists";

    /**
     * 歌手MV
     */
    public static final String ARTISTS_MV = "artists";
    /**
     * 音乐链接
     */
    public static final String SONG = "/song/url";


    /**
     * 最新MV
     */
    public static final String LASTESTMUSICVIDEO = "/mv/first";

    public static final String MVURL = "/mv/url";
    /**
     * 音乐封面
     */
    public static final String ALBUM = "/song/detail";

    public static final String RECOMMEND_MV = "/personalized/mv";

    public static final String VIDEO = "/video/url";
    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";

    public static String USERNAME = "";
    public static String PASSWORD = "";

    /**
     * 包名相关常量
     */
    public static class Package {

        /**
         * 包名
         */
        public static final String PACKAGE_NAME = "com.brins.lightmusic";

        /**
         * 主进程名
         */
        public static final String MAIN_PROCESS_NAME = PACKAGE_NAME;

    }

    public static class DisplayUtil {

        /*手柄起始角度*/
        public static final float ROTATION_INIT_NEEDLE = -30;

        /*截图屏幕宽高*/
        private static final float BASE_SCREEN_WIDTH = (float) 1080.0;
        private static final float BASE_SCREEN_HEIGHT = (float) 1920.0;

        /*唱针宽高、距离等比例*/
        public static final float SCALE_NEEDLE_WIDTH = (float) (276.0 / BASE_SCREEN_WIDTH);
        public static final float SCALE_NEEDLE_MARGIN_LEFT = (float) (500.0 / BASE_SCREEN_WIDTH);
        public static final float SCALE_NEEDLE_PIVOT_X = (float) (43.0 / BASE_SCREEN_WIDTH);
        public static final float SCALE_NEEDLE_PIVOT_Y = (float) (43.0 / BASE_SCREEN_WIDTH);
        public static final float SCALE_NEEDLE_HEIGHT = (float) (413.0 / BASE_SCREEN_HEIGHT);
        public static final float SCALE_NEEDLE_MARGIN_TOP = (float) (43.0 / BASE_SCREEN_HEIGHT);

        /*唱盘比例*/
        public static final float SCALE_DISC_SIZE = (float) (813.0 / BASE_SCREEN_WIDTH);
        public static final float SCALE_DISC_MARGIN_TOP = (float) (190 / BASE_SCREEN_HEIGHT);

        /*专辑图片比例*/
        public static final float SCALE_MUSIC_PIC_SIZE = (float) (533.0 / BASE_SCREEN_WIDTH);

        /*设备屏幕宽度*/
        public static int getScreenWidth(Context context) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }

        /*设备屏幕高度*/
        public static int getScreenHeight(Context context) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
    }


    public static final int NEXT_MUSIC = 0;
    public static final int PRE_MUSIC = 1;

    /**
     * 用户信息，缓存，方便调用
     */
    public static UserAccountBean userAccount;
    /**
     * 用户画像，缓存，方便调用
     */
    public static UserProfileBean userProfile;
}
