package com.baidu.disconf.web.service.config.service.impl;

import com.baidu.disconf.web.service.config.service.CodeService;
import com.baidu.disconf.web.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by zhaoyun on 17/5/9.
 */
@Service
public class CodeServiceImpl implements CodeService {

    @Value("${NO_ENCODE_FILE_NAME_PATTERN:^.*.sh$,^hosts$}")
    private String NO_CODE_FILE_NAME_PATTERN;

    @Override
    public String encode(String strIn, String fileName) {
        if (!isNeedCode(fileName)) {
            return strIn;
        }
        return CodeUtils.unicodeToUtf8(strIn);
    }

    @Override
    public String decode(String strIn, String fileName) {
        if (!isNeedCode(fileName)) {
            return strIn;
        }
        return CodeUtils.utf8ToUnicode(strIn);
    }

    private boolean isNeedCode(String fileName) {
        fileName = fileName.toLowerCase();

        String[] patterns = NO_CODE_FILE_NAME_PATTERN.split(",");

        for (String pattern : patterns) {
            if (fileName.matches(pattern)) {
                return false;
            }
        }
        return true;
    }
}
