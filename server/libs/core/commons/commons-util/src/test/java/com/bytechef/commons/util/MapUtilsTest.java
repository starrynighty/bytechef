/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.commons.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class MapUtilsTest {

    @Test
    public void testSimpleMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("a", 10);
        map.put("b", true);
        map.put("c", "test");
        String result = MapUtils.toString(map);

        assertEquals("{a=10, b=true, c=test}", result);
    }

    @Test
    public void testMapArray() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("key1", 10);
        map.put("key2", true);
        map.put("key3", new int[] {
            10, 20, 30
        });
        String result = MapUtils.toString(map);

        assertEquals("{key1=10, key2=true, key3=[10, 20, 30]}", result);
    }

    @Test
    public void testMapList() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("key1", 10);
        map.put("key2", true);
        map.put("key3", List.of(10, 20, 30));
        String result = MapUtils.toString(map);

        assertEquals("{key1=10, key2=true, key3=[10, 20, 30]}", result);
    }
}
