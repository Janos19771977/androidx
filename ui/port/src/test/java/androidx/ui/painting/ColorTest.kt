/*
 * Copyright 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Copyright 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.ui.painting

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ColorTest {

    @Test
    fun `color accessors should work`() {
        val color = Color(0x12345678)
        assertEquals(0x12, color.alpha)
        assertEquals(0x34, color.red)
        assertEquals(0x56, color.green)
        assertEquals(0x78, color.blue)
    }

    @Test
    fun `paint set to black`() {
        val c = Color(0x00000000)
        val p = Paint()
        p.color = c
        assertEquals("Color(0x00000000)", c.toString())
    }

    @Test
    fun `blend at 0% returns start color`() {
        val start = Color(android.graphics.Color.RED)
        val end = Color(android.graphics.Color.BLUE)
        assertEquals(start, Color.blend(start, end, 0.0f))
    }

    @Test
    fun `blend at 100% returns end color`() {
        val start = Color(android.graphics.Color.RED)
        val end = Color(android.graphics.Color.BLUE)
        assertEquals(end, Color.blend(start, end, 1.0f))
    }

    @Test
    fun `blend 50% returns purple`() {
        val start = Color(android.graphics.Color.RED)
        val end = Color(android.graphics.Color.BLUE)
        assertEquals(Color(0xffba00ba.toInt()), Color.blend(start, end, 0.5f))
    }

    // TODO(Migration/Andrey): In Flutter setting a color into Paint will throw an Exception
    // if the color int will not be in the range of Int32. To discuss do we need such behaviour
    // with our Paint object
//    @Test
//    fun `color created with out of bounds value`() {
//        try {
//            val c = Color(0x100 shl 24)
//            val p = Paint()
//            p.color = c
//        } catch (e: Exception) {
//            assertEquals(true, e != null)
//        }
//    }
//
//    @Test
//    fun `color created with wildly out of bounds value`() {
//        try {
//            val c = Color(1 shl 1000000)
//            val p = Paint()
//            p.color = c
//        } catch (e: Exception) {
//            assertEquals(true, e != null)
//        }
//    }
}