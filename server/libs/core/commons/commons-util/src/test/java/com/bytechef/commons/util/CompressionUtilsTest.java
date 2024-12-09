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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HexFormat;
import org.junit.jupiter.api.Test;

public class CompressionUtilsTest {

    private static final String testFile =
        "this is a test file for compression owo this is a test file for compression uwu this is a test file for compression vwv this is a test file for compression xwx this is a test file for compression this is a test file for compression nWn";
    private final byte[] testFileBytes = HexFormat.ofDelimiter(" ")
        .parseHex(
            "74 68 69 73 20 69 73 20 61 20 74 65 73 74 20 66 69 6C 65 20 66 6F 72 20 63 6F 6D 70 72 65 73 73 69 6F 6E 20 6F 77 6F 20 74 68 69 73 20 69 73 20 61 20 74 65 73 74 20 66 69 6C 65 20 66 6F 72 20 63 6F 6D 70 72 65 73 73 69 6F 6E 20 75 77 75 20 74 68 69 73 20 69 73 20 61 20 74 65 73 74 20 66 69 6C 65 20 66 6F 72 20 63 6F 6D 70 72 65 73 73 69 6F 6E 20 76 77 76 20 74 68 69 73 20 69 73 20 61 20 74 65 73 74 20 66 69 6C 65 20 66 6F 72 20 63 6F 6D 70 72 65 73 73 69 6F 6E 20 78 77 78 20 74 68 69 73 20 69 73 20 61 20 74 65 73 74 20 66 69 6C 65 20 66 6F 72 20 63 6F 6D 70 72 65 73 73 69 6F 6E 20 74 68 69 73 20 69 73 20 61 20 74 65 73 74 20 66 69 6C 65 20 66 6F 72 20 63 6F 6D 70 72 65 73 73 69 6F 6E 20 6E 57 6E");
    private final byte[] compressed = HexFormat.ofDelimiter(" ")
        .parseHex(
            "1F 8B 08 00 00 00 00 00 00 FF 8D CA 41 0A 80 30 0C 04 C0 AF EC AF 3C 8B A4 18 A8 59 69 D2 A6 CF D7 27 04 E6 38 71 AB E3 77 22 C4 03 4D BB A0 71 E0 E2 F3 0E 71 57 1A 98 44 14 DE CC 59 7A 2B 57 E9 ED DC A5 57 39 76 D8 07 CA 5D 4F 6A EB 00 00 00");

    @Test
    public void testCompress() {
        byte[] result = CompressionUtils.compress(testFile);
        byte[] resultFromBytes = CompressionUtils.compress(testFileBytes);

        assertArrayEquals(compressed, resultFromBytes);
        assertArrayEquals(compressed, result);
    }

    @Test
    public void testDecompress() {
        assertEquals(testFile, CompressionUtils.decompressToString(compressed));
        assertArrayEquals(testFileBytes, CompressionUtils.decompress(compressed));
    }
}
