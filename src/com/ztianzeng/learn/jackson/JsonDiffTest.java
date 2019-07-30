package com.ztianzeng.learn.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonDiff;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaotianzeng
 * @date 2019-07-30 21:13
 * @version V1.0
 */
public class JsonDiffTest {
    private static final String beforeJsonString = "{\"name\":{\"first\":\"John\",\"last\":\"Doe\"},\"address\":null,\"birthday\":\"1980-01-01\",\"company\":\"Acme\",\"occupation\":\"Software engineer\",\"phones\":[{\"number\":\"000000000\",\"type\":\"home\"},{\"number\":\"999999999\",\"type\":\"mobile\"}]}";
    private static final String afterJsonString = "{\"name\":{\"first\":\"Jane\",\"last\":\"Doe\",\"nickname\":\"Jenny\"},\"birthday\":\"1990-01-01\",\"occupation\":null,\"phones\":[{\"number\":\"111111111\",\"type\":\"mobile\"}],\"favorite\":true,\"groups\":[\"close-friends\",\"gym\"]}";

    @Test
    public void diffJson() throws IOException {

        JsonNode beforeNode = JacksonUtils.defaultMapper().readTree(beforeJsonString);
        JsonNode afterNode = JacksonUtils.defaultMapper().readTree(afterJsonString);
        JsonNode patch = JsonDiff.asJson(beforeNode, afterNode);
        String diffs = patch.toString();
        System.out.println(diffs);
    }

    @Test
    public void diffJson2() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, Object>> type =
                new TypeReference<HashMap<String, Object>>() {
                };

        Map<String, Object> leftMap = mapper.readValue(beforeJsonString, type);
        Map<String, Object> rightMap = mapper.readValue(afterJsonString, type);

        Map<String, Object> leftFlatMap = FlatMapUtil.flatten(leftMap);
        Map<String, Object> rightFlatMap = FlatMapUtil.flatten(rightMap);

        MapDifference<String, Object> difference = Maps.difference(leftFlatMap, rightFlatMap);

        System.out.println("Entries only on the left\n--------------------------");
        difference.entriesOnlyOnLeft()
                .forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("\n\nEntries only on the right\n--------------------------");
        difference.entriesOnlyOnRight()
                .forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("\n\nEntries differing\n--------------------------");
        difference.entriesDiffering()
                .forEach((key, value) -> System.out.println(key + ": " + value.leftValue() + " => " + value.rightValue()));
    }
}