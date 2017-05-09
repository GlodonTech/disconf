package com.baidu.disconf.web.service.config.service;

/**
 * Created by zhaoyun on 17/5/9.
 */
public interface CodeService {

    /**
     * unicode to utf8
     */
    String encode(String strIn, String fileName);

    /**
     * utf8 to unicode
     */
    String decode(String strIn, String fileName);

}
