/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.project.zaixianjiaoyu.model;


import com.project.zaixianjiaoyu.exception.FaceException;

/**
 * JSON解析
 * @param <T>
 */
public interface Parser<T> {
    T parse(String json) throws FaceException;
}
