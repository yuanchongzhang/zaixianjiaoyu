/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.project.zaixianjiaoyu.model;

import com.baidu.ocr.sdk.model.RequestParams;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DynamicParams implements RequestParams {

    private Map<String, String> params = new HashMap<>();
    private Map<String, File> fileMap = new HashMap<>();


    @Override
    public Map<String, File> getFileParams() {
        return fileMap;
    }

    @Override
    public Map<String, String> getStringParams() {
        return params;
    }

    public void putParam(String key, String value) {
        if (value != null) {
            params.put(key, value);
        }
    }

    public void putParam(String key, int value) {

        params.put(key, String.valueOf(value));
    }

    public void putFile(String key, File file) {
        fileMap.put(key, file);
    }

    public void putParam(String key, boolean value) {
        if (value) {
            putParam(key, "true");
        } else {
            putParam(key, "false");
        }
    }
}
