/*
 * Scala.js (https://www.scala-js.org/)
 *
 * Copyright EPFL.
 *
 * Licensed under Apache License 2.0
 * (https://www.apache.org/licenses/LICENSE-2.0).
 *
 * See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 */

package org.scalajs.testsuite.javalib.lang

import java.lang.{Long => JLong}

import org.junit.Test
import org.junit.Assert._

import org.scalajs.testsuite.utils.AssertThrows.assertThrows

/** Tests the implementation of the java standard library Long
 *  requires jsinterop/LongTest to work to make sense
 */
class LongTest {

  final val MinRadix = Character.MIN_RADIX
  final val MaxRadix = Character.MAX_RADIX

  @noinline def hideFromOptimizer(x: Long): Long = x

  @Test def reverseBytes(): Unit = {
    assertEquals(0x14ff01d49c68abf5L, JLong.reverseBytes(0xf5ab689cd401ff14L))
    assertEquals(0x780176af73b18fc7L, JLong.reverseBytes(0xc78fb173af760178L))
    assertEquals(0x361d65c5b948d4d6L, JLong.reverseBytes(0xd6d448b9c5651d36L))
    assertEquals(0xf7a1ef821b8f4864L, JLong.reverseBytes(0x64488f1b82efa1f7L))
    assertEquals(0xddc509a6de8e44c5L, JLong.reverseBytes(0xc5448edea609c5ddL))
    assertEquals(0x288824701c0a5355L, JLong.reverseBytes(0x55530a1c70248828L))
    assertEquals(0x8bf3fed839300267L, JLong.reverseBytes(0x67023039d8fef38bL))
    assertEquals(0x44c9ade0187f253eL, JLong.reverseBytes(0x3e257f18e0adc944L))
    assertEquals(0x79a345f33753c217L, JLong.reverseBytes(0x17c25337f345a379L))
    assertEquals(0x52934dd800c7e57eL, JLong.reverseBytes(0x7ee5c700d84d9352L))
    assertEquals(0xc60434cd3ee0d783L, JLong.reverseBytes(0x83d7e03ecd3404c6L))
    assertEquals(0xe35901c3015a16a0L, JLong.reverseBytes(0xa0165a01c30159e3L))
    assertEquals(0x3b6967d70dbed537L, JLong.reverseBytes(0x37d5be0dd767693bL))
    assertEquals(0xc64eec7456b1d217L, JLong.reverseBytes(0x17d2b15674ec4ec6L))
    assertEquals(0xcd82e5c594a61174L, JLong.reverseBytes(0x7411a694c5e582cdL))
    assertEquals(0xd5f85c6a11888b2aL, JLong.reverseBytes(0x2a8b88116a5cf8d5L))
    assertEquals(0xa8c6597640b32446L, JLong.reverseBytes(0x4624b3407659c6a8L))
    assertEquals(0x61aa72555ec08d2dL, JLong.reverseBytes(0x2d8dc05e5572aa61L))
    assertEquals(0xd506860a916bb2d5L, JLong.reverseBytes(0xd5b26b910a8606d5L))
    assertEquals(0xa5b42bd78ecda8f1L, JLong.reverseBytes(0xf1a8cd8ed72bb4a5L))
    assertEquals(0xe7cb5958d4f41bfaL, JLong.reverseBytes(0xfa1bf4d45859cbe7L))
  }

  @Test def reverse(): Unit = {
    assertEquals(0x28ff802b3916d5afL, JLong.reverse(0xf5ab689cd401ff14L))
    assertEquals(0x0000000000000001L, JLong.reverse(0x8000000000000000L))
    assertEquals(0xc72a7066e1350f40L, JLong.reverse(0x02f0ac87660e54e3L))
    assertEquals(0x4455b80802f29f69L, JLong.reverse(0x96f94f40101daa22L))
    assertEquals(0xf8174394b3aaf2e6L, JLong.reverse(0x674f55cd29c2e81fL))
    assertEquals(0x9c6f15743242b439L, JLong.reverse(0x9c2d424c2ea8f639L))
    assertEquals(0x8ef01f0551b80ab0L, JLong.reverse(0x0d501d8aa0f80f71L))
    assertEquals(0xaeb088220ac8cf31L, JLong.reverse(0x8cf3135044110d75L))
    assertEquals(0x247e286155da22c9L, JLong.reverse(0x93445baa86147e24L))
    assertEquals(0xa45c9f296362d10cL, JLong.reverse(0x308b46c694f93a25L))
    assertEquals(0x16ca602244d14b85L, JLong.reverse(0xa1d28b2244065368L))
    assertEquals(0x878acb85b7fe40c5L, JLong.reverse(0xa3027feda1d351e1L))
    assertEquals(0xb8d996565b3f28d8L, JLong.reverse(0x1b14fcda6a699b1dL))
    assertEquals(0xc84e6c88148a6a27L, JLong.reverse(0xe456512811367213L))
    assertEquals(0x6bac67a3e7a7450cL, JLong.reverse(0x30a2e5e7c5e635d6L))
    assertEquals(0x2f17be6d95d551a5L, JLong.reverse(0xa58aaba9b67de8f4L))
    assertEquals(0x9ed3868d46155aaeL, JLong.reverse(0x755aa862b161cb79L))
    assertEquals(0x2de28f4e6b239166L, JLong.reverse(0x6689c4d672f147b4L))
    assertEquals(0x1528d4f46d89c9c9L, JLong.reverse(0x939391b62f2b14a8L))
    assertEquals(0xaca0de3697c073a4L, JLong.reverse(0x25ce03e96c7b0535L))
    assertEquals(0xe44211dee49bac56L, JLong.reverse(0x6a35d9277b884227L))
    assertEquals(0x438dc899d9c4de36L, JLong.reverse(0x6c7b239b9913b1c2L))
  }

  @Test def rotateLeft(): Unit = {
    assertEquals(0xf5ab689cd401ff14L, JLong.rotateLeft(0xf5ab689cd401ff14L, 0))
    assertEquals(0xeb56d139a803fe29L, JLong.rotateLeft(0xf5ab689cd401ff14L, 1))
    assertEquals(0xab689cd401ff14f5L, JLong.rotateLeft(0xf5ab689cd401ff14L, 8))
    assertEquals(0x6d139a803fe29eb5L, JLong.rotateLeft(0xf5ab689cd401ff14L, 13))
    assertEquals(0xf5ab689cd401ff14L, JLong.rotateLeft(0xf5ab689cd401ff14L, 64))
    assertEquals(0xeb56d139a803fe29L, JLong.rotateLeft(0xf5ab689cd401ff14L, 65))
    assertEquals(0x689cd401ff14f5abL, JLong.rotateLeft(0xf5ab689cd401ff14L, 80))
    assertEquals(0x7ad5b44e6a00ff8aL, JLong.rotateLeft(0xf5ab689cd401ff14L, -1))
    assertEquals(0xab689cd401ff14f5L, JLong.rotateLeft(0xf5ab689cd401ff14L, -56))
    assertEquals(0x53d6ada2735007fcL, JLong.rotateLeft(0xf5ab689cd401ff14L, -70))
  }

  @Test def rotateRight(): Unit = {
    assertEquals(0xf5ab689cd401ff14L, JLong.rotateRight(0xf5ab689cd401ff14L, 0))
    assertEquals(0x7ad5b44e6a00ff8aL, JLong.rotateRight(0xf5ab689cd401ff14L, 1))
    assertEquals(0x14f5ab689cd401ffL, JLong.rotateRight(0xf5ab689cd401ff14L, 8))
    assertEquals(0xf8a7ad5b44e6a00fL, JLong.rotateRight(0xf5ab689cd401ff14L, 13))
    assertEquals(0xf5ab689cd401ff14L, JLong.rotateRight(0xf5ab689cd401ff14L, 64))
    assertEquals(0x7ad5b44e6a00ff8aL, JLong.rotateRight(0xf5ab689cd401ff14L, 65))
    assertEquals(0xff14f5ab689cd401L, JLong.rotateRight(0xf5ab689cd401ff14L, 80))
    assertEquals(0xeb56d139a803fe29L, JLong.rotateRight(0xf5ab689cd401ff14L, -1))
    assertEquals(0x14f5ab689cd401ffL, JLong.rotateRight(0xf5ab689cd401ff14L, -56))
    assertEquals(0x6ada2735007fc53dL, JLong.rotateRight(0xf5ab689cd401ff14L, -70))
  }

  @Test def bitCount(): Unit = {
    assertEquals(0, JLong.bitCount(0L))
    assertEquals(26, JLong.bitCount(35763829229342837L))
    assertEquals(32, JLong.bitCount(-350003829229342837L))
  }

  @Test def compareToJavaLong(): Unit = {
    def compare(x: Long, y: Long): Int =
      new JLong(x).compareTo(new JLong(y))

    assertTrue(compare(0L, 5L) < 0)
    assertTrue(compare(10L, 9L) > 0)
    assertTrue(compare(-2L, -1L) < 0)
    assertEquals(0, compare(3L, 3L))
  }

  @Test def compareTo(): Unit = {
    def compare(x: Any, y: Any): Int =
      x.asInstanceOf[Comparable[Any]].compareTo(y)

    assertTrue(compare(0L, 5L) < 0)
    assertTrue(compare(10L, 9L) > 0)
    assertTrue(compare(-2L, -1L) < 0)
    assertEquals(0, compare(3L, 3L))
  }

  @Test def parseString(): Unit = {
    def test(s: String, v: Long): Unit = {
      assertEquals(v, JLong.parseLong(s))
      assertEquals(v, JLong.valueOf(s).longValue())
      assertEquals(v, new JLong(s).longValue())
      assertEquals(v, JLong.decode(s))
    }

    test("0", 0L)
    test("5", 5L)
    test("127", 127L)
    test("-100", -100L)
    test("30000", 30000L)
    test("-90000", -90000L)
    test("4", 4L)
    test("-4", -4L)
    test("4000000000", 4000000000L)
    test("-18014398509482040", -18014398509482040L)

    test("\u19d9\u0f24\u0c6f\u1c47\ua623\u19d9\u0f24\u0c6f\u1c47\ua623",
        9497394973L)
    test("\u19d0" * 50 + "\u19d9\u0f24\u0c6f\u1c47\ua623\u19d9\u0f24\u0c6f\u1c47\ua623",
        9497394973L)
  }

  @Test def parseStringInvalidThrows(): Unit = {
    def test(s: String): Unit =
      assertThrows(classOf[NumberFormatException], JLong.parseLong(s))

    test("abc")
    test("asdf")
    test("")
  }

  @Test def parseStringBase16(): Unit = {
    def test(s: String, v: Long): Unit = {
      assertEquals(v, JLong.parseLong(s, 16))
      assertEquals(v, JLong.valueOf(s, 16).longValue())
      assertEquals(v, JLong.decode(IntegerTest.insertAfterSign("0x", s)))
      assertEquals(v, JLong.decode(IntegerTest.insertAfterSign("0X", s)))
      assertEquals(v, JLong.decode(IntegerTest.insertAfterSign("#", s)))
    }

    test("0", 0x0L)
    test("5", 0x5L)
    test("ff", 0xffL)
    test("-24", -0x24L)
    test("30000", 0x30000L)
    test("-90000", -0x90000L)
    test("bfc94973", 3217639795L)
    test("bfc949733", 51482236723L)

    test("\uff22\uff26\uff23\u19d9\u0f24\u0c6f\u1c47\ua623", 3217639795L)
    test("\uff42\uff46\uff43\u19d9\u0f24\u0c6f\u1c47\ua6233", 51482236723L)
  }

  @Test def parseStringBase2To36(): Unit = {
    def test(radix: Int, s: String, v: Long): Unit = {
      assertEquals(v, JLong.parseLong(s, radix))
      assertEquals(v, JLong.valueOf(s, radix).longValue())
    }

    def genTestValue(i: Int): Long = {
      val result = Long.MaxValue / (1L << i)
      if (i > 63) -result
      else result
    }

    for {
      radix <- 2 to 36
      i <- 0 until 128
    } {
      val n = genTestValue(i)
      test(radix, JLong.toString(n, radix), n)
    }
  }

  @Test def parseStringsBaseLessThanTwoOrBaseLargerThan36Throws(): Unit = {
    def test(s: String, radix: Int): Unit = {
      assertThrows(classOf[NumberFormatException], JLong.parseLong(s, radix))
      assertThrows(classOf[NumberFormatException], JLong.valueOf(s, radix).longValue())
    }

    List[Int](-10, -5, 0, 1, 37, 38, 50, 100).foreach(test("5", _))
  }

  @Test def testDecodeBase8(): Unit = {
    def test(s: String, v: Long): Unit = {
      assertEquals(v, JLong.decode(s))
    }

    test("00", 0L)
    test("012345670", 2739128L)
    test("-012", -10L)
  }

  @Test def decodeStringInvalidThrows(): Unit = {
    def test(s: String): Unit =
      assertThrows(classOf[NumberFormatException], JLong.decode(s))

    // sign after another sign or after a base prefix
    test("++0")
    test("--0")
    test("0x+1")
    test("0X-1")
    test("#-1")
    test("0-1")

    // empty string after sign or after base prefix
    test("")
    test("+")
    test("-")
    test("-0x")
    test("+0X")
    test("#")

    // integer too large
    test("0x8000000000000000")
    test("-0x80000000000000001")
    test("01000000000000000000000")
    test("-01000000000000000000001")
  }

  @Test def testToString(): Unit = {
    assertEquals("2147483647", Int.MaxValue.toLong.toString)
    assertEquals("-50", (-50L).toString)
    assertEquals("-1000000000", (-1000000000L).toString)
    assertEquals("2147483648", (Int.MaxValue.toLong+1L).toString)
    assertEquals("-2147483648", Int.MinValue.toLong.toString)

    /* Ported from
     * https://github.com/gwtproject/gwt/blob/master/user/test/com/google/gwt/emultest/java/lang/JLongTest.java
     */
    assertEquals("89000000005", new JLong(89000000005L).toString)
    assertEquals("-9223372036854775808", new JLong(JLong.MIN_VALUE).toString)
    assertEquals("9223372036854775807", new JLong(JLong.MAX_VALUE).toString)
    assertEquals("-80765", JLong.toString(-80765L))
    assertEquals("80765", JLong.toString(80765L))
    assertEquals("-2147483648", JLong.toString(Integer.MIN_VALUE.toLong))
    assertEquals("2147483647", JLong.toString(Integer.MAX_VALUE.toLong))
    assertEquals("-89000000005", JLong.toString(-89000000005L))
    assertEquals("89000000005", JLong.toString(89000000005L))
    assertEquals("-9223372036854775808", JLong.toString(JLong.MIN_VALUE))
    assertEquals("9223372036854775807", JLong.toString(JLong.MAX_VALUE))

    // Corner cases of the approximation inside RuntimeLong.toUnsignedString

    // Approximated quotient is too high
    assertEquals("2777572447999999934", JLong.toString(0x268beb6cdcf3bfbeL))
    assertEquals("3611603422999999979", JLong.toString(0x321efe2d997ff5ebL))
    assertEquals("7742984029999999701", JLong.toString(0x6b749af381ac2ad5L))
    assertEquals("2161767614999999954", JLong.toString(0x1e0024313b04b5d2L))
    assertEquals("5388513109999999953", JLong.toString(0x4ac7d81fbd15dbd1L))
    assertEquals("3713052774999999769", JLong.toString(0x338769d386274519L))
    assertEquals("-5647508785999999800", JLong.toString(0xb1a004ae50928cc8L))
    assertEquals("-1406561754999999938", JLong.toString(0xec7ae3893e93323eL))
    assertEquals("-8621287367999999564", JLong.toString(0x885b08d0fbcc31b4L))
    assertEquals("-8876380314999999920", JLong.toString(0x84d0c321f127b250L))
    assertEquals("-5002322935999999598", JLong.toString(0xba942dcb0bee5192L))
    assertEquals("-4971399139999999950", JLong.toString(0xbb020ad25f9e1832L))
    assertEquals("-8515854999999999733", JLong.toString(0x89d19aff1644110bL))
    assertEquals("-4806014223999999712", JLong.toString(0xbd4d9b86d1016120L))
    assertEquals("-9133328502999999878", JLong.toString(0x813fe61df1bc1a7aL))
    assertEquals("-7816299703999999849", JLong.toString(0x9386ecd4ed16d097L))
    assertEquals("-7259227631999999909", JLong.toString(0x9b420aee02f0a05bL))
    assertEquals("-2526704305999999860", JLong.toString(0xdcef57d21c6b8c8cL))
    assertEquals("-1100666257999999982", JLong.toString(0xf0b9a5deb3a6cc12L))

    // Approximated quotient is too low
    assertEquals("7346875325000000000", JLong.toString(0x65f5582ec3b52200L))
    assertEquals("-7993685585000000000", JLong.toString(0x9110b95013ea1600L))
  }

  @Test def toStringRadix(): Unit = {
    /* Ported from
     * https://github.com/gwtproject/gwt/blob/master/user/test/com/google/gwt/emultest/java/lang/JLongTest.java
     */
    assertEquals("100000000", JLong.toString(100000000L, 10))
    assertEquals("77777777777", JLong.toString(8589934591L, 8))
    assertEquals("fffffffff", JLong.toString(68719476735L, 16))
    assertEquals("1111111111111111111111111111111111111111111", JLong.toString(8796093022207L, 2))
    assertEquals("-9223372036854775808", JLong.toString(0x8000000000000000L, 10))
    assertEquals("9223372036854775807", JLong.toString(0x7fffffffffffffffL, 10))
    assertEquals("-8000000000000000", JLong.toString(0x8000000000000000L, 16))
    assertEquals("7fffffffffffffff", JLong.toString(0x7fffffffffffffffL, 16))
  }

  @Test def highestOneBit(): Unit = {
    assertEquals(0L, JLong.highestOneBit(0L))
    assertEquals(Long.MinValue, JLong.highestOneBit(-1L))
    assertEquals(Long.MinValue, JLong.highestOneBit(-256L))
    assertEquals(1L, JLong.highestOneBit(1L))
    assertEquals(0x80L, JLong.highestOneBit(0x88L))
    assertEquals(0x4000000000000000L, JLong.highestOneBit(Long.MaxValue))
    assertEquals(Long.MinValue, JLong.highestOneBit(Long.MinValue))
    assertEquals(0x20000000000L, JLong.highestOneBit(0x32100012300L))
  }

  @Test def lowestOneBit(): Unit = {
    assertEquals(0L, JLong.lowestOneBit(0L))
    assertEquals(1L, JLong.lowestOneBit(-1L))
    assertEquals(256L, JLong.lowestOneBit(-256L))
    assertEquals(4L, JLong.lowestOneBit(12L))
    assertEquals(0x8L, JLong.lowestOneBit(0x88L))
    assertEquals(1L, JLong.lowestOneBit(Long.MaxValue))
    assertEquals(Long.MinValue, JLong.lowestOneBit(Long.MinValue))
    assertEquals(0x100L, JLong.lowestOneBit(0x32100012300L))
  }

  @Test def toBinaryString(): Unit = {
    assertEquals("0", JLong.toBinaryString(0L))
    assertEquals("1111111111111111111111111111111111111111111111111111111111111111",
        JLong.toBinaryString(-1L))
    assertEquals("11011001100101111010101100110", JLong.toBinaryString(456324454L))
    assertEquals("1111111111111111111111111111111111100100110011010000101010011010",
        JLong.toBinaryString(-456324454L))
    assertEquals("10110011101001110011110011111111111101001111101",
        JLong.toBinaryString(98765432158845L))
    assertEquals("1111111111111111110100101110100101011001100101101001000111001100",
        JLong.toBinaryString(-49575304457780L))
    assertEquals("1000000000000000000000000000000000000000000000000000000000000000",
        JLong.toBinaryString(Long.MinValue))
    assertEquals("111111111111111111111111111111111111111111111111111111111111111",
        JLong.toBinaryString(Long.MaxValue))
  }

  @Test def toHexString(): Unit = {
    assertEquals("0", JLong.toHexString(0L))
    assertEquals("ffffffffffffffff", JLong.toHexString(-1L))
    assertEquals("1b32f566", JLong.toHexString(456324454L))
    assertEquals("ffffffffe4cd0a9a", JLong.toHexString(-456324454L))
    assertEquals("59d39e7ffa7d", JLong.toHexString(98765432158845L))
    assertEquals("ffffd2e9599691cc", JLong.toHexString(-49575304457780L))
    assertEquals("8000000000000000", JLong.toHexString(Long.MinValue))
    assertEquals("7fffffffffffffff", JLong.toHexString(Long.MaxValue))
  }

  @Test def toOctalString(): Unit = {
    assertEquals("0", JLong.toOctalString(0L))
    assertEquals("1777777777777777777777", JLong.toOctalString(-1L))
    assertEquals("3314572546", JLong.toOctalString(456324454L))
    assertEquals("1777777777774463205232", JLong.toOctalString(-456324454L))
    assertEquals("2635163637775175", JLong.toOctalString(98765432158845L))
    assertEquals("1777776456453145510714", JLong.toOctalString(-49575304457780L))
    assertEquals("1000000000000000000000", JLong.toOctalString(Long.MinValue))
    assertEquals("777777777777777777777", JLong.toOctalString(Long.MaxValue))
  }

  @Test def numberOfLeadingZeros(): Unit = {
    /* This method contains an IR node subject to constant folding.
     * Test with and without inlining.
     */

    @noinline def nlzNoInline(x: Long): Long = JLong.numberOfLeadingZeros(x)

    @inline def test(expected: Int, x: Long): Unit = {
      assertEquals(expected, JLong.numberOfLeadingZeros(x))
      assertEquals(expected, nlzNoInline(x))
    }

    test(0, 0x9876543210abcdefL)
    test(64, 0x0L)

    test(6, 0x272d130652a160fL)
    test(61, 0x4L)
    test(13, 0x645d32476a42aL)
    test(31, 0x19b8ed092L)
    test(8, 0xdc2d80fe481e77L)
    test(2, 0x3af189a5d0dfae26L)
    test(23, 0x151dc269439L)
    test(9, 0x60e7be653be060L)
    test(52, 0xe39L)
    test(61, 0x6L)
    test(37, 0x7ea26e0L)
    test(12, 0x882fb98ec313bL)
    test(11, 0x136efd8f1beebaL)
    test(58, 0x3aL)
    test(4, 0xc3c7ecf1e25f4b4L)
    test(57, 0x48L)
    test(21, 0x63c51c723a8L)
    test(50, 0x2742L)
    test(39, 0x10630c7L)
  }

  @Test def numberOfTrailingZeros(): Unit = {
    assertEquals(64, JLong.numberOfTrailingZeros(0x0000000000000000L))
    assertEquals(63, JLong.numberOfTrailingZeros(0x8000000000000000L))

    assertEquals(52, JLong.numberOfTrailingZeros(0xff10000000000000L))
    assertEquals(53, JLong.numberOfTrailingZeros(0xff20000000000000L))
    assertEquals(54, JLong.numberOfTrailingZeros(0xff40000000000000L))
    assertEquals(55, JLong.numberOfTrailingZeros(0xff80000000000000L))

    assertEquals(40, JLong.numberOfTrailingZeros(0x0000010000000000L))
    assertEquals(41, JLong.numberOfTrailingZeros(0x0000020000000000L))
    assertEquals(42, JLong.numberOfTrailingZeros(0x0000040000000000L))
    assertEquals(43, JLong.numberOfTrailingZeros(0x0000080000000000L))

    assertEquals(16, JLong.numberOfTrailingZeros(0x0000000000010000L))
    assertEquals(17, JLong.numberOfTrailingZeros(0x0000000000020000L))
    assertEquals(18, JLong.numberOfTrailingZeros(0x0000000000040000L))
    assertEquals(19, JLong.numberOfTrailingZeros(0x0000000000080000L))

    assertEquals(0, JLong.numberOfTrailingZeros(0xff100c0000500005L))
  }

  @Test def signum(): Unit = {
    //check a few ints
    assertEquals(-1, JLong.signum(-11))
    assertEquals(-1, JLong.signum(-1))
    assertEquals(0, JLong.signum(0))
    assertEquals(1, JLong.signum(1))
    assertEquals(1, JLong.signum(11))

    //check a few longs
    assertEquals(-1, JLong.signum(Long.MinValue))
    assertEquals(-1, JLong.signum(-98765432158845L))
    assertEquals(-1, JLong.signum(-49575304457780L))
    assertEquals(-1, JLong.signum(-11L))
    assertEquals(-1, JLong.signum(-1L))
    assertEquals(0, JLong.signum(0L))
    assertEquals(1, JLong.signum(1L))
    assertEquals(1, JLong.signum(11L))
    assertEquals(1, JLong.signum(49575304457780L))
    assertEquals(1, JLong.signum(98765432158845L))
    assertEquals(1, JLong.signum(Long.MaxValue))
  }

  @Test def parseUnsignedLong(): Unit = {
    def test(s: String, v: Long, radix: Int = 10): Unit = {
      assertEquals(v, JLong.parseUnsignedLong(s, radix))
      if (radix == 10)
        assertEquals(v, JLong.parseUnsignedLong(s))
    }

    for (radix <- MinRadix to MaxRadix) {
      test("0", 0L, radix)
      test("000", 0L, radix)
      test("1", 1L, radix)
      test("0001", 1L, radix)
      test("+001", 1L, radix)
      test("0000000000000000000000000000000000000000000000001", 1L, radix)

      test("10", radix, radix)
      test("101", radix * radix + 1, radix)
    }

    test("16124664", 16124664L)
    test("7813704539", 7813704539L)
    test("18443850133137351140", -2893940572200476L)
    test("46", 46L)
    test("513", 513L)
    test("18446733424676845844", -10649032705772L)
    test("18446744073709534122", -17494L)
    test("18429837294589420452", -16906779120131164L)
    test("584580761116924", 584580761116924L)
    test("18253337814340096130", -193406259369455486L)
    test("18446744073709551615", -1L)
    test("18446740969617105003", -3104092446613L)
    test("18438258069731489767", -8486003978061849L)
    test("1524089988584", 1524089988584L)
    test("94766618917465", 94766618917465L)
    test("314141", 314141L)
    test("18446744073709551609", -7L)
    test("13193366656598575", 13193366656598575L)
    test("4463540626035", 4463540626035L)
    test("18298390975510103704", -148353098199447912L)

    test("1111111111111111111111111111111111111111111111111100001010001110", -15730L, 2)
    test("1", 1L, 2)
    test("1010100111010010101111", 2782383L, 2)
    test("1111111111110110111101111100010001011001011000101100011001110001", -2542327081810319L, 2)
    test("10100101000101111111011010011100000010001011", 11345146265739L, 2)
    test("10101100110100101111000010101111100011001", 1484546727705L, 2)
    test("1111111111111111111111111111111101000110101111110001010010001010", -3108039542L, 2)
    test("1111111100001011010010000011101100010001010100001011100111001101", -68881950763337267L, 2)
    test("11110110010101000011100111001010101111001111100101100101", 69335451462072677L, 2)
    test("1111111111110110000100011101111010100011100011001111100010100101", -2795101842769755L, 2)
    test("1111111111111111111111111111111001110101111011101111000011110110", -6611341066L, 2)
    test("1111111111101001010110011111100100111101111000110101111001101100", -6374997444305300L, 2)
    test("11011001111100000001111101011101001111", 234009122639L, 2)
    test("1111111111111111111111111111111111111111111111111111111111111111", -1L, 2)
    test("110000100001111110111100001011010111000111000010011111110", 109282077117220094L, 2)
    test("1111111111111111111111111111111111111111111111111111111111111111", -1L, 2)
    test("1110001010101110110011011101011111100100001101000011100101", 255222175400775909L, 2)
    test("1111111111111111111111111111111111111100001010110100011101010111", -64272553L, 2)
    test("110101111110110001010001010111100", 7245177532L, 2)
    test("10011001", 153L, 2)

    test("200211110221201221210010000", 5318877800511L, 3)
    test("10011222211122", 1692620L, 3)
    test("0", 0L, 3)
    test("11112220022122120100212220211121021210222", -9811040948L, 3)
    test("1002010011021001201122", 11280505706L, 3)
    test("2", 2L, 3)
    test("11112220022001122120020111020121211211020", -121398502086964L, 3)
    test("10012012221212211102001", 33403661659L, 3)
    test("21200210221002210210212221201222220122", 1155240683994130541L, 3)
    test("10", 3L, 3)
    test("102120221010020222120020", 121235647029L, 3)
    test("11112211011111202001020122221212112211121", -11970876082467195L, 3)
    test("11112220022122120101211010112211210202110", -43558546L, 3)
    test("1002102022021022001002010022", 8308724522201L, 3)
    test("11112210211202201212122211102212200102211", -13770565064757777L, 3)
    test("112", 14L, 3)
    test("11112220022121002121102200122110022110111", -11238507902541L, 3)
    test("12", 5L, 3)
    test("11112220022121120102021112200021121021002", -7620832333175L, 3)
    test("1000220121210201201020111010", 7883156492814L, 3)

    test("1777777777777777777762", -14L, 8)
    test("1777722114411211624374", -1613222832035588L, 8)
    test("1777777777777777135670", -214088L, 8)
    test("464740417152634471316", 5565341876836528846L, 8)
    test("1777777754101551501500", -1365570583744L, 8)
    test("30", 24L, 8)
    test("157213", 56971L, 8)
    test("536576570024", 47076536340L, 8)
    test("1777777777777777764364", -5900L, 8)
    test("32237547616", 3531526030L, 8)
    test("3353", 1771L, 8)
    test("1777762116341254074135", -487190845949859L, 8)
    test("1777726420307676564726", -1459025103623722L, 8)
    test("13242465556754", 777738706412L, 8)
    test("1777777777777777777411", -247L, 8)
    test("0", 0L, 8)
    test("1777777777777254065014", -89101812L, 8)
    test("1777777777777320632772", -79481350L, 8)
    test("1777777777777777777776", -2L, 8)
    test("1777777777777777777766", -10L, 8)

    test("73812287a", 1573340218L, 11)
    test("335500516a429053598", -26243L, 11)
    test("335500516a429062021", -13622L, 11)
    test("312", 376L, 11)
    test("335500516a429061708", -14121L, 11)
    test("229756417915596", 858932854143348L, 11)
    test("3355004983921a79a72", -819506552439L, 11)
    test("198695532584133a64", 955018988500957362L, 11)
    test("5780a1969981", 1627182100523L, 11)
    test("3561a235764", 90925741922L, 11)
    test("297875481a8255913", 132452642378195494L, 11)
    test("334a484647617358052", -23270078397575056L, 11)
    test("3355005126988240740", -111994265894L, 11)
    test("5765470a653153124a", 2876005824227907304L, 11)
    test("486", 578L, 11)
    test("3355003a8a4725aaa91", -3657090971681L, 11)
    test("47a6230140", 11138170197L, 11)
    test("335462546185a683040", -1828868111493813L, 11)
    test("3355003897814276041", -4208107209420L, 11)
    test("335500516a428114a75", -1693406L, 11)

    test("1e2bcbffd845d6", 8492404472038870L, 16)
    test("66f761dd4c921f", 28982447321158175L, 16)
    test("fffffffffffffffe", -2L, 16)
    test("fffffffcb5a5abea", -14132335638L, 16)
    test("0", 0L, 16)
    test("fff9f86c6e302757", -1697180248168617L, 16)
    test("0", 0L, 16)
    test("2ade893e1", 11507635169L, 16)
    test("ffffffffffffffee", -18L, 16)
    test("1c58", 7256L, 16)
    test("ffe43906a76a1f29", -7818598606561495L, 16)
    test("ed644c4cec7b9b", 66819848351284123L, 16)
    test("9af86720e", 41599529486L, 16)
    test("36836e3", 57161443L, 16)
    test("5aaa3e0f", 1521106447L, 16)
    test("e21", 3617L, 16)
    test("12f6e4ce79c19e0b", 1366531112410652171L, 16)
    test("fffffffffffffff1", -15L, 16)
    test("a81311af1", 45117151985L, 16)
    test("666fb96", 107412374L, 16)

    test("1ddh888c674hceb", -670904533769L, 23)
    test("1ddh88h2782i3k6", -621L, 23)
    test("1am8del2jfd860a", -1323234499202024296L, 23)
    test("1ddh88alahf47gd", -482979709715L, 23)
    test("1ddh88h27821h4f", -200413L, 23)
    test("1ddh0k87fc28f3d", -310484822595773L, 23)
    test("1", 1L, 23)
    test("f", 15L, 23)
    test("7", 7L, 23)
    test("1ddh88h2782fi4a", -29551L, 23)
    test("6dl16", 1848355L, 23)
    test("3ghbmg", 23999665L, 23)
    test("1fhcc9jgbli", 69817785666461L, 23)
    test("b3m0gd691d76", 10644868672075877L, 23)
    test("1ddh88h1k812ffi", -1480827779L, 23)
    test("gagf7k5f92", 29658300901905L, 23)
    test("c0malk7", 1782720416L, 23)
    test("1dc70ba68516heg", -31769265072171901L, 23)
    test("1ddh88h2707a4je", -50188982L, 23)
    test("1ddh88h2782i447", -459L, 23)

    test("3w5e11264firt", -603959L, 36)
    test("3w5e0yjkf4hjp", -197223309099L, 36)
    test("0", 0L, 36)
    test("257", 2779L, 36)
    test("3w5e11264q5eh", -108071L, 36)
    test("6q", 242L, 36)
    test("78fn5vcsnav", 26449720538029303L, 36)
    test("34i2bnbwv", 8816108957455L, 36)
    test("nety", 1092310L, 36)
    test("zqhbq", 60022070L, 36)
    test("3w5e11264sb85", -7211L, 36)
    test("4qavwrd2rhzf", 622652556001597899L, 36)
    test("14abs", 1879624L, 36)
    test("3w5dzjo0ypgtf", -4184088198301L, 36)
    test("3w5e11264sc8g", -5904L, 36)
    test("1cajn3", 81113583L, 36)
    test("3w5e11264s8i0", -10744L, 36)
    test("ox", 897L, 36)
    test("gm0bq", 27900710L, 36)
    test("3w5e0eru6osu5", -1746501839363L, 36)
  }

  @Test def parseUnsignedLongFailureCases(): Unit = {
    def test(s: String, radix: Int = 10): Unit =
      assertThrows(classOf[NumberFormatException], JLong.parseUnsignedLong(s, radix))

    // Bad radix
    test("0", MinRadix - 1)
    test("0", MaxRadix + 1)

    // Format
    test("abc")
    test("5a")
    test("99", 8)
    test("-30000")
    test("+")
    test("-")
    test("-0")
    test("0.0")

    // Value out of range
    test("18446744073709551616")
    test("11111111111111111111111111111111111111111111111111111111111111111", 2)
    test("2214220303114400424121122431", 5)
    test("3w5e11264sgsg", 36)
    test("18446744073709551616654831357465413214984684321486984")
    test("3w5e11264sgsgvmqoijs34qsdf1ssfmlkjesl", 36)
  }

  @Test def hashCodeTest(): Unit = {
    assertEquals(0, JLong.hashCode(0L))
    assertEquals(1, JLong.hashCode(1L))
    assertEquals(0, JLong.hashCode(-1L))

    assertEquals(-1746700373, JLong.hashCode(4203407456681260900L))
    assertEquals(1834237377, JLong.hashCode(-4533628472446063315L))
    assertEquals(1917535332, JLong.hashCode(-8078028383605336161L))
    assertEquals(1962981592, JLong.hashCode(-1395767907951999837L))
    assertEquals(1771769687, JLong.hashCode(4226100786750107409L))
    assertEquals(-1655946833, JLong.hashCode(8283069451989884520L))
    assertEquals(969818862, JLong.hashCode(-4956907030691723841L))
    assertEquals(-614637591, JLong.hashCode(7053247622210876606L))
    assertEquals(1345794172, JLong.hashCode(4113526825251053222L))
    assertEquals(-575359500, JLong.hashCode(7285869072471305893L))
  }

  @Test def compareUnsigned(): Unit = {
    def compare(x: Long, y: Long): Int =
      JLong.compareUnsigned(x, y)

    assertTrue(compare(0, 5) < 0)
    assertTrue(compare(10, 9) > 0)
    assertEquals(0, compare(3, 3))
    assertEquals(0, compare(-1L, -1L))
    assertTrue(compare(0xe6b28004865df12L, -1L) < 0)
    assertTrue(compare(-1L, 0xe6b28004865df12L) > 0)
    assertTrue(compare(0xe6b28004865df12L, 3) > 0)
    assertTrue(compare(3, 0xe6b28004865df12L) < 0)
  }

  @Test def divideUnsigned(): Unit = {
    @inline def test(x: Long, y: Long, result: Long): Unit = {
      assertEquals(result, JLong.divideUnsigned(x, y))
      assertEquals(result, JLong.divideUnsigned(hideFromOptimizer(x), y))
      assertEquals(result, JLong.divideUnsigned(x, hideFromOptimizer(y)))
      assertEquals(result, JLong.divideUnsigned(hideFromOptimizer(x), hideFromOptimizer(y)))
    }

    test(-9223372034182170740L, 53886L, 171164533265177L)
    test(-9223372036854775807L, 1L, -9223372036854775807L)
    test(1L, 1L, 1L)
    test(-9223372028033273801L, 1093832863L, 8432158474L)
    test(3L, 1L, 3L)
    test(-9152576797767832099L, 1831882805942L, 5073559L)
    test(143L, 1L, 143L)
    test(-9223372036785876966L, 67L, 137662269207816039L)
    test(409670828687897L, 41239724459L, 9933L)
    test(-9223372036854571433L, 405L, 22773758115691309L)
    test(-9223372036786133323L, 684L, 13484462042285699L)
    test(1011212285034L, 1L, 1011212285034L)
    test(-9223372036854052446L, 14386L, 641135272963679L)
    test(-9223372036854775794L, 1L, -9223372036854775794L)
    test(-9223372036854769295L, 29L, 318047311615682149L)
    test(-9223372026307494597L, 58L, 159023655989690638L)
    test(329537042584197319L, 3386229L, 97316821332L)
    test(-9223372036853925905L, 2789311L, 3306684710616L)
    test(184910967393761L, 612461458L, 301914L)
    test(-9220748194206666929L, 30344662L, 304040159666L)
    test(2710297051L, 488660775L, 5L)
    test(-9223372036854444961L, 106367L, 86712721397191L)
    test(-9223372036644696595L, 125978L, 73214148796336L)
    test(0L, 16L, 0L)
    test(34727385263708L, 1726L, 20120153686L)
    test(24538L, 214L, 114L)
    test(3441692738180855L, 2922016232L, 1177848L)
    test(-9223372036854573063L, 2065L, 4466523988791757L)
    test(-9223372036854738811L, 4532L, 2035165939288352L)
    test(25392410921644L, 27738L, 915437699L)
    test(-9223371993563946637L, 371818L, 24806147309021L)
    test(226905L, 12L, 18908L)
    test(-9223187071501586227L, 5436611L, 1696563723652L)
    test(62324594094L, 62L, 1005235388L)
    test(-9147191206118290885L, 1934532429910965L, 4807L)
    test(-9172283274772171204L, 556443731116414L, 16667L)
    test(-9223372036854775477L, 106L, 87012943743912982L)
    test(60485531945L, 12L, 5040460995L)
    test(-9223372036854598147L, 2L, 4611686018427476734L)
    test(31834147648L, 14719L, 2162792L)
    test(58014L, 1L, 58014L)
    test(-9223372036854775733L, 6L, 1537228672809129313L)
    test(3L, 1L, 3L)
    test(-7905579639447511885L, 747885734L, 14094618943L)
    test(14346885725L, 29005921L, 494L)
    test(13672312178L, 6L, 2278718696L)
    test(-9223371657435410050L, 5901282L, 1562943851229L)
    test(-9223372036389851141L, 1055121L, 8741530153716L)
    test(1149586100416530720L, 564L, 2038273227688884L)
    test(1L, 1L, 1L)
    test(-9223372036854385180L, 8663L, 1064685678962849L)
    test(89731974104L, 1173247030L, 76L)
    test(385847542338318L, 7846L, 49177611819L)
    test(-9223372026066135207L, 480301980L, 19203277170L)

    assertThrows(classOf[ArithmeticException], JLong.divideUnsigned(5L, 0L))
  }

  @Test def remainderUnsigned(): Unit = {
    @inline def test(x: Long, y: Long, result: Long): Unit = {
      assertEquals(result, JLong.remainderUnsigned(x, y))
      assertEquals(result, JLong.remainderUnsigned(hideFromOptimizer(x), y))
      assertEquals(result, JLong.remainderUnsigned(x, hideFromOptimizer(y)))
      assertEquals(result, JLong.remainderUnsigned(hideFromOptimizer(x), hideFromOptimizer(y)))
    }

    test(97062081516L, 772L, 668L)
    test(-9223372036854775472L, 49L, 43L)
    test(-9223372036854775756L, 17L, 10L)
    test(270261062411L, 19L, 13L)
    test(654151050L, 1293L, 369L)
    test(252077906700L, 5147561526L, 4994953452L)
    test(131302394690918280L, 45672263L, 32871850L)
    test(6861002361535L, 5306169939241L, 1554832422294L)
    test(-9221700602589689139L, 1L, 0L)
    test(-9223355302048330857L, 616921560624L, 570573045175L)
    test(7L, 387L, 7L)
    test(57025455556036L, 5340L, 2296L)
    test(118837327813611L, 30L, 21L)
    test(87L, 909L, 87L)
    test(272013095293278842L, 29839452324246875L, 3458024375056967L)
    test(1434L, 3L, 0L)
    test(22980297L, 475870L, 138537L)
    test(10410504L, 56605L, 51789L)
    test(-9223365332599000086L, 37509837810312L, 9702257313226L)
    test(-9223372036851205117L, 120L, 99L)
    test(-9223372036854772689L, 62L, 27L)
    test(-9223369370621240354L, 8761020421L, 6409028421L)
    test(-9223371153085904549L, 942378L, 421655L)
    test(1357532983495L, 28618L, 5701L)
    test(2578981576162L, 2884L, 334L)
    test(-9216746775620579770L, 57399743689L, 39826797750L)
    test(-9223372036854775593L, 2L, 1L)
    test(35146338041774819L, 479358464104950L, 153170162113469L)
    test(28855L, 6436L, 3111L)
    test(1115645622608748416L, 2L, 0L)
    test(39928234567786375L, 225464372977360L, 21040550793655L)
    test(198628052L, 954693145L, 198628052L)
    test(3022077378019577L, 7545L, 6647L)
    test(-9223372036854775808L, 1L, 0L)
    test(16L, 93L, 16L)
    test(-9223372036854775804L, 12L, 0L)
    test(-9223372036854775718L, 1L, 0L)
    test(433297497717789L, 793815867L, 251058642L)
    test(55412933435948L, 13494776387L, 3381590926L)
    test(1652351527406382L, 20225334L, 8793636L)
    test(7L, 364L, 7L)
    test(1125379509822519L, 41077089453701L, 16298094572592L)
    test(7677989811350377624L, 513072419162588473L, 494975943074139002L)
    test(525899929L, 16536035226L, 525899929L)
    test(2353013018L, 53739171823L, 2353013018L)
    test(3L, 18L, 3L)
    test(-9223372036853809229L, 11838317L, 6492461L)
    test(-9223371335502904413L, 247005757438L, 158332129281L)
    test(-9209220612812195231L, 2L, 1L)
    test(-9223372036684983395L, 1017L, 662L)
    test(-9223372036625677948L, 1L, 0L)
    test(39608677L, 5L, 2L)
    test(-9223372022281433992L, 16359L, 15357L)
    test(54651001988172L, 4463729541L, 1561217709L)
    test(-9223372036846154797L, 11L, 0L)
    test(-9212519596031121696L, 1L, 0L)
    test(0L, 2L, 0L)

    assertThrows(classOf[ArithmeticException], JLong.remainderUnsigned(5L, 0L))
  }

  @Test def toUnsignedString(): Unit = {
    def test(x: Long, s: String, radix: Int = 10): Unit = {
      assertEquals(s, JLong.toUnsignedString(x, radix))
      if (radix == 10) {
        assertEquals(s, JLong.toUnsignedString(x))
        assertEquals(s, JLong.toUnsignedString(x, MinRadix - 1))
        assertEquals(s, JLong.toUnsignedString(x, MaxRadix + 1))
      }
    }

    for (radix <- MinRadix to MaxRadix) {
      test(0L, "0", radix)
      test(1L, "1", radix)
      test(radix * radix + 1, "101", radix)
    }

    test(-111L, "1111111111111111111111111111111111111111111111111111111110010001", 2)
    test(-841L, "1111111111111111111111111111111111111111111111111111110010110111", 2)
    test(-48L, "1111111111111111111111111111111111111111111111111111111111010000", 2)
    test(11568553533L, "1010110001100010100001111000111101", 2)
    test(1448703278415412L, "101001001011001011010000100010010110111111000110100", 2)
    test(-78600467092795L, "1111111111111111101110001000001101100111000101000110101011000101", 2)
    test(97785243187L, "1011011000100011101000110011000110011", 2)
    test(-16595422816873L, "1111111111111111111100001110100000010011101101111101010110010111", 2)
    test(-8L, "1111111111111111111111111111111111111111111111111111111111111000", 2)
    test(1423166986L, "1010100110100111100111000001010", 2)
    test(528027512103548939L, "11101010011111011100011100110000010100100001011100000001011", 2)
    test(581852302953L, "1000011101111001000110011000111001101001", 2)
    test(-1L, "1111111111111111111111111111111111111111111111111111111111111111", 2)
    test(-1117567308L, "1111111111111111111111111111111110111101011000110100011010110100", 2)
    test(-10067395877878416L, "1111111111011100001110111100000110111100111000101100010101110000", 2)
    test(-3070582626L, "1111111111111111111111111111111101001000111110101010000010011110", 2)
    test(220037L, "110101101110000101", 2)
    test(-952L, "1111111111111111111111111111111111111111111111111111110001001000", 2)
    test(9266140931L, "1000101000010011100001011100000011", 2)
    test(-1356784282352L, "1111111111111111111111101100010000011001010110101101010100010000", 2)

    test(-301667321L, "11112220022122120101210110120011112002012", 3)
    test(-488003L, "11112220022122120101211020112220000102202", 3)
    test(56833883717507265L, "101020001001002012222002210022020210", 3)
    test(-59926140798833700L, "11112111112121000112201020201201222210221", 3)
    test(5L, "12", 3)
    test(50979L, "2120221010", 3)
    test(-1L, "11112220022122120101211020120210210211220", 3)
    test(-776392750L, "11112220022122120101202020110212222012220", 3)
    test(-4286476522150321L, "11112212112211110020200002200122122012210", 3)
    test(-1020566053765181881L, "11022002201211022212220222122112012002120", 3)
    test(9987889L, "200210102210211", 3)
    test(-3596895307268158L, "11112212200011212211222202012112212011110", 3)
    test(-2487431L, "11112220022122120101211020102010102201212", 3)
    test(3976408776971345954L, "222111022011101001112122222011212212012", 3)
    test(-4568571L, "11112220022122120101211020021012200221121", 3)
    test(545827038361L, "1221011212121212110122121", 3)
    test(364L, "111111", 3)
    test(886519L, "1200001002001", 3)
    test(-15052851071645379L, "11112210121112120200022111212222012020101", 3)
    test(-458371549386951L, "11112220020102110102221011012021112202101", 3)

    test(-1027601908345L, "1777777761027611636607", 8)
    test(28293264763580L, "633561177565274", 8)
    test(3743895037392734L, "152320657561733536", 8)
    test(-2129L, "1777777777777777773657", 8)
    test(1474403050396020748L, "121661034147246670014", 8)
    test(-40350517067559L, "1777776664645160700331", 8)
    test(-24378485730495L, "1777777235176101111501", 8)
    test(4051870L, "17351636", 8)
    test(-29624021L, "1777777777777616774453", 8)
    test(-175144656567263367L, "1766216055634100017571", 8)
    test(-474156057855165229L, "1745533531173334276323", 8)
    test(-37642598850426L, "1777776734164621060206", 8)
    test(79825011L, "460404163", 8)
    test(1026636894728412L, "35133420733070334", 8)
    test(323L, "503", 8)
    test(-5733135571000769476L, "1301576371133125742074", 8)
    test(169058178437096559L, "11304730220007422157", 8)
    test(16160605658002878L, "713237606746332676", 8)
    test(236007877229443L, "6552273553735603", 8)
    test(29373675467L, "332663533713", 8)

    test(-10630694120372L, "18446733443015431244", 10)
    test(59996L, "59996", 10)
    test(40422871616L, "40422871616", 10)
    test(-1L, "18446744073709551615", 10)
    test(-494906997247357617L, "17951837076462193999", 10)
    test(2094704541963722604L, "2094704541963722604", 10)
    test(-9143375L, "18446744073700408241", 10)
    test(-369000878580850L, "18446375072830970766", 10)
    test(-190028L, "18446744073709361588", 10)
    test(10710L, "10710", 10)
    test(1309381L, "1309381", 10)
    test(-251430906237896L, "18446492642803313720", 10)
    test(-6956615040474786610L, "11490129033234765006", 10)
    test(1053197837512127521L, "1053197837512127521", 10)
    test(32634423842079867L, "32634423842079867", 10)
    test(15845997546210L, "15845997546210", 10)
    test(366L, "366", 10)
    test(78019L, "78019", 10)
    test(67583790597992934L, "67583790597992934", 10)
    test(-2142564L, "18446744073707409052", 10)

    test(-3851L, "335500516a4290693a4", 11)
    test(-317L, "335500516a429071017", 11)
    test(2696544171243224829L, "53759308a9512a651a", 11)
    test(19187171L, "a915673", 11)
    test(-1435523339405L, "3355004766648615354", 11)
    test(-1047026437385872L, "3354831595a72093aa7", 11)
    test(3172942606031698L, "839aa7447730925", 11)
    test(11919217347L, "50670a6454", 11)
    test(413563597L, "1a249a4a7", 11)
    test(10669052023994L, "34437a07a9241", 11)
    test(2207571452769701770L, "44052532a563493294", 11)
    test(-5448833177050732L, "3353776a89239446519", 11)
    test(-7L, "335500516a429071279", 11)
    test(-137L, "335500516a429071170", 11)
    test(1067L, "890", 11)
    test(32077898L, "1711a666", 11)
    test(-305293149315285551L, "3298a12384947623923", 11)
    test(-4174600L, "335500516a42677a8a4", 11)
    test(-59105L, "335500516a429030933", 11)
    test(17379L, "1206a", 11)

    test(-290L, "fffffffffffffede", 16)
    test(31782L, "7c26", 16)
    test(150502870782171L, "88e1ae2690db", 16)
    test(400034567014840L, "16bd44e43c9b8", 16)
    test(65L, "41", 16)
    test(-79L, "ffffffffffffffb1", 16)
    test(-525928399581224L, "fffe21abc090cfd8", 16)
    test(-761491114358094656L, "f56ea3ddb511c4c0", 16)
    test(14207017882L, "34ecde39a", 16)
    test(1548087L, "179f37", 16)
    test(-2L, "fffffffffffffffe", 16)
    test(-4476778436479056L, "fff01864cb8e37b0", 16)
    test(1806L, "70e", 16)
    test(-97927L, "fffffffffffe8179", 16)
    test(-70947362492231344L, "ff03f1bfece65150", 16)
    test(1524862009L, "5ae38c39", 16)
    test(-86488940923772L, "ffffb156b9663484", 16)
    test(-655893195L, "ffffffffd8e7dd35", 16)
    test(21L, "15", 16)
    test(-2161087123997L, "fffffe08d52b6de3", 16)

    test(-5713122L, "1ddh88h27758f4f", 23)
    test(-7874718946L, "1ddh88h003eihkf", 23)
    test(-1347L, "1ddh88h2782i2bg", 23)
    test(2070942075280570L, "23mi28bh29f9", 23)
    test(-6832029644011364L, "1dda4adif5c7m69", 23)
    test(-4913545743348979L, "1ddc4hh1lfib20e", 23)
    test(-91416800L, "1ddh88h26gl2gai", 23)
    test(491457862L, "3784fk3", 23)
    test(4035521741L, "145mhec0", 23)
    test(-106795716L, "1ddh88h26ec3gi6", 23)
    test(24363083L, "3i18mb", 23)
    test(13910775L, "23g787", 23)
    test(-2L, "1ddh88h2782i514", 23)
    test(43224536139L, "cfmg1645", 23)
    test(-76910L, "1ddh88h2782bkf8", 23)
    test(-2395654L, "1ddh88h277h5799", 23)
    test(0L, "0", 23)
    test(16714141436088029L, "hcafkl33emlh", 23)
    test(-55339524590L, "1ddh88g91c37h8h", 23)
    test(1961423L, "704i6", 23)

    test(1L, "1", 36)
    test(-1L, "3w5e11264sgsf", 36)
    test(323385309041262901L, "2gg6iw29x3jp", 36)
    test(7L, "7", 36)
    test(33613L, "pxp", 36)
    test(11L, "b", 36)
    test(-173365910560L, "3w5e0yuiz7c2o", 36)
    test(16690491997L, "7o1361p", 36)
    test(7674L, "5x6", 36)
    test(5100325896106887L, "1e7wxdc12mf", 36)
    test(35651078165696286L, "9r1937kam8u", 36)
    test(-5896L, "3w5e11264sc8o", 36)
    test(-7L, "3w5e11264sgs9", 36)
    test(-765241254L, "3w5e111th6ouy", 36)
    test(174025356202421L, "1poq57vq9h", 36)
    test(-9655682L, "3w5e1125z1if2", 36)
    test(-8418216826200L, "3w5dy1mw7ue94", 36)
    test(325L, "91", 36)
    test(-5110L, "3w5e11264scui", 36)
    test(156326L, "3cme", 36)
  }

  @Test def sum(): Unit = {
    assertEquals(6122341414771019357L, JLong.sum(1740786198414632467L, 4381555216356386890L))
    assertEquals(-4889886762367205395L, JLong.sum(-8830279253260439247L, 3940392490893233852L))
    assertEquals(-6367464149838633528L, JLong.sum(5060120328358716131L, 7019159595512201957L))
    assertEquals(7750674555797733770L, JLong.sum(-127945470420596269L, 7878620026218330039L))
    assertEquals(2292511418697124720L, JLong.sum(-113914894846178357L, 2406426313543303077L))
    assertEquals(4144908605866946455L, JLong.sum(-452451471404092861L, 4597360077271039316L))
    assertEquals(1518415622600251340L, JLong.sum(-2542679049991328710L, 4061094672591580050L))
    assertEquals(-6696926488229344817L, JLong.sum(9029073781662275913L, 2720743803817930886L))
    assertEquals(3975409760170992157L, JLong.sum(1334542450932789748L, 2640867309238202409L))
    assertEquals(-2306898384481193161L, JLong.sum(-1061157332600512189L, -1245741051880680972L))
  }

  @Test def max(): Unit = {
    assertEquals(1956883243420738449L, JLong.max(1956883243420738449L, -1904419562216591909L))
    assertEquals(117913687706178681L, JLong.max(-2988219415364960605L, 117913687706178681L))
    assertEquals(388198710879184635L, JLong.max(388198710879184635L, -3756230577463777653L))
    assertEquals(1115394631509995426L, JLong.max(-2217311876090452370L, 1115394631509995426L))
    assertEquals(7453888341191743476L, JLong.max(7453888341191743476L, -740740721564600300L))
    assertEquals(4752011173900225726L, JLong.max(4752011173900225726L, -948011379670482381L))
    assertEquals(4871675157821875905L, JLong.max(-7122494041885380978L, 4871675157821875905L))
    assertEquals(-3089564107971808446L, JLong.max(-3089564107971808446L, -5806674784462125918L))
    assertEquals(1144435567075440595L, JLong.max(-9074221864918600272L, 1144435567075440595L))
    assertEquals(7404961600946325433L, JLong.max(7404961600946325433L, -8938012685848048741L))
  }

  @Test def min(): Unit = {
    assertEquals(-5271417849589228545L, JLong.min(8336468579144700312L, -5271417849589228545L))
    assertEquals(-3894917472223405446L, JLong.min(3940913818812912251L, -3894917472223405446L))
    assertEquals(693040957319768557L, JLong.min(737425499269142100L, 693040957319768557L))
    assertEquals(-1286568351539001900L, JLong.min(8057854573479802096L, -1286568351539001900L))
    assertEquals(-6881230620207534521L, JLong.min(-6881230620207534521L, 1889738661329119418L))
    assertEquals(2719089703966352878L, JLong.min(6000452428926957590L, 2719089703966352878L))
    assertEquals(7751460768676751991L, JLong.min(8489331160950182059L, 7751460768676751991L))
    assertEquals(-6645668421002962620L, JLong.min(7942023199169866495L, -6645668421002962620L))
    assertEquals(-1221988382269503479L, JLong.min(-1221988382269503479L, 8379347185457460903L))
    assertEquals(-354972413230950652L, JLong.min(5755640173859541328L, -354972413230950652L))
  }
}
