package com.lgh.lixiang.common;

/**
 * todo 相对路径存在问题
 * Created by lenovo on 2015/7/11.
 */
public class StringHelper {
    public static String getPagebar(long count, long page, long pageSize, String url) {
        StringBuilder strB = new StringBuilder();
        if (count <= 0) return "";
        long totalPage = count % pageSize == 0 ? count / pageSize : (count / pageSize + 1);
        if (page <= 1) page = 1;
        if (page >= totalPage) page = totalPage;

        StringBuilder mid = new StringBuilder();
        for (long m = page - 4; m <= page + 4; m++) {
            if (m > 0 && m <= totalPage)
                mid.append(page == m ? " <span class=\"cur\" title=\"第" + m + "页\">" + m + "</span>"
                        : " <a href=\"" + url + m + "\" title=\"第" + m + "页\">" + m + "</a>");
        }
        strB.append(mid);

        return strB.toString();

    }

    public static String getManagerPagebar(long count, long page, long pageSize, String url) {
        StringBuilder strB = new StringBuilder();
        if (count <= 0) return "";
        long totalPage = count % pageSize == 0 ? count / pageSize : (count / pageSize + 1);
        if (page <= 1) page = 1;
        if (page >= totalPage) page = totalPage;

        if (page > 1)
            strB.append(" <a href=\"" + url + "\" title=\"首页\">首页</a> <a href=\"" + url + (page - 1) + "\" title=\"上一页\">上一页</a>");

        StringBuilder mid = new StringBuilder();
        for (long m = page - 4; m <= page + 4; m++) {
            if (m > 0 && m <= totalPage)
                mid.append(page == m ? " <span class=\"this-page\" title=\"第" + m + "页\">" + m + "</span>"
                        : " <a href=\"" + url + m + "\" title=\"第" + m + "页\">" + m + "</a>");
        }
        strB.append(mid);

        if (page < totalPage)
            strB.append(" <a href=\"" + url + (page + 1) + "\" title=\"下一页\">下一页</a>");

        return strB.toString();

    }
}
