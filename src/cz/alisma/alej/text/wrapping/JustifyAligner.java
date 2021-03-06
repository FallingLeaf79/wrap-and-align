/*
 * MIT License
 * Copyright (c) 2017-2019 Gymnazium Nad Aleji
 * Copyright (c) 2017 Vojtech Horky
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

import java.util.List;
import java.util.Scanner;

/** Justifies a line. */
public class JustifyAligner implements Aligner {

    @Override
    public String format(List<String> words, int lineWidth) {

        int spaceCount = words.size() - 1;
        int wordsLength = 0;
        for (String w : words) {
          wordsLength += w.length();
        }

        StringBuilder result = new StringBuilder();
        int uniformSpaces = 0;
        int remainderSpaces = 0;
        if (spaceCount != 0) {
            uniformSpaces = (lineWidth - wordsLength) / spaceCount;
            remainderSpaces = (lineWidth - wordsLength) % spaceCount;
        }

        for (String w : words) {
            result.append(w);
            if (spaceCount > 0) {
                for (int i = uniformSpaces; i > 0; i--) {
                    result.append(" ");
                }
                if (remainderSpaces > 0) {
                    result.append(" ");
                    remainderSpaces--;
                }
                spaceCount--;
            }
        }
        return result.toString();
    }

}
