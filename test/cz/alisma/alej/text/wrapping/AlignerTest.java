/*
 * MIT License
 * Copyright (c) 2019 Gymnazium Nad Aleji
 * Copyright (c) 2019 Ivo Korinek
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package cz.alisma.alej.text.wrapping;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AlignerTest {

    @Before
    String testString = "One fish two fish red fish blue fish";
    Aligner aligner;

    @Test
    public void leftTest() {
        aligner = new LeftAligner();
        assertEquals(
            "One fish two fish red fish blue fish",
            leftAligner.format(Arrays.asList(testString.split(" ")), 40)
        );
    }

    @Test
    public void rightTest() {
        aligner = new RightAligner();
        assertEquals(
            "    One fish two fish red fish blue fish",
            rightAligner.format(Arrays.asList(testString.split(" ")), 40)
        );
    }

    @Test
    public void centerTest() {
        aligner = new CenterAligner();
        assertEquals(
            "  One fish two fish red fish blue fish",
            centerAligner.format(Arrays.asList(testString.split(" ")), 40)
        );
    }

    @Test
    public void justifyTest() {
        aligner = new JustifyAligner();
        assertEquals(
            "One  fish  two  fish  red fish blue fish",
            justifyAligner.format(Arrays.asList(testString.split(" ")), 40)
        );
    }


}
