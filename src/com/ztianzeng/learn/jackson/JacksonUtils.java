package com.ztianzeng.learn.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.CollectionUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author zhaotianzeng
 * @date 2019-07-30 21:27
 * @version V1.0
 */
public class JacksonUtils {
    private JacksonUtils() {
    }

    private static final ObjectMapper defaultMapper = defaultMapper();
    public static final TypeReference<Map<String, Object>> mapOfObj = new TypeReference<Map<String, Object>>() {
    };

    public static final TypeReference<List<Object>> listOfObj = new TypeReference<List<Object>>() {
    };

    /**
     * default mapper
     *
     * @return
     */
    public static ObjectMapper defaultMapper() {
        return defaultMapper(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * default mapper
     *
     * @return
     */
    public static ObjectMapper defaultMapper(DateFormat dateFormat) {
        final ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        om.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        om.setDateFormat(dateFormat);
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        om.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return om;
    }

    public static <T, O> T convertValue(O fromValue, Class<T> toValueType) {
        return defaultMapper.convertValue(fromValue, toValueType);
    }

    /**
     * See {@link #convertValue(Object, Class)}
     */
    public static <T, O> T convertValue(O fromValue, TypeReference<?> toValueTypeRef) {
        return defaultMapper.convertValue(fromValue, toValueTypeRef);
    }

    /**
     * See {@link #convertValue(Object, Class)}
     */
    public static <T, O> T convertValue(O fromValue, JavaType toValueType) {
        return defaultMapper.convertValue(fromValue, toValueType);
    }

    /**
     * 转换
     *
     * @param fromValue
     * @param toValueType
     * @param toTransform
     * @param <T>
     * @param <O>
     * @return
     */
    public static <T, O> T convertValue(O fromValue, Class<T> toValueType, BiConsumer<O, T> toTransform) {
        T t = defaultMapper.convertValue(fromValue, toValueType);
        if (toTransform != null) {
            toTransform.accept(fromValue, t);
        }
        return t;
    }

    public static <T, O> T convertValue(O fromValue, TypeReference<?> toValueType, BiConsumer<O, T> toTransform) {
        T t = defaultMapper.convertValue(fromValue, toValueType);
        if (toTransform != null) {
            toTransform.accept(fromValue, t);
        }
        return t;
    }

    public static <T, O> T convertValue(O fromValue, JavaType toValueType, BiConsumer<O, T> toTransform) {
        T t = defaultMapper.convertValue(fromValue, toValueType);
        if (toTransform != null) {
            toTransform.accept(fromValue, t);
        }
        return t;
    }


    public static <T, O> List<O> convertList(Collection<T> source, Class<O> c, BiConsumer<T, O> toTransform) {
        List<O> list = new LinkedList<>();
        if (CollectionUtils.isEmpty(source)) {
            return new LinkedList<>();
        }
        for (T t : source) {
            if (t == null) {
                continue;
            }
            O o = convertValue(t, c);
            if (toTransform != null) {
                toTransform.accept(t, o);
            }
            list.add(o);
        }
        return list;
    }

    public static <T, O> List<O> convertList(Collection<T> source, Class<O> c) {
        List<O> list = new LinkedList<>();
        if (CollectionUtils.isEmpty(source)) {
            return new LinkedList<>();
        }
        for (T t : source) {
            if (t == null) {
                continue;
            }
            O o = convertValue(t, c);
            list.add(o);
        }
        return list;
    }
}