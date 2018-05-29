/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.project.zaixianjiaoyu.util;


import com.project.zaixianjiaoyu.exception.FaceException;

public interface OnResultListener<T> {
    void onResult(T result);

    void onError(FaceException error);
}
