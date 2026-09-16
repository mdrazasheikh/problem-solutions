package validparenthesis

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidParenthesisTest {

    @Test
    fun `accepts every bracket type on its own`() {
        assertTrue(isValidString("()"))
        assertTrue(isValidString("{}"))
        assertTrue(isValidString("[]"))
    }

    @Test
    fun `accepts nested and sequenced brackets`() {
        assertTrue(isValidString("([]{})"))
        assertTrue(isValidString("{[()]}"))
        assertTrue(isValidString("()[]{}"))
    }

    @Test
    fun `accepts the empty string`() {
        assertTrue(isValidString(""))
    }

    @Test
    fun `rejects mismatched pairs`() {
        assertFalse(isValidString("(]"))
        assertFalse(isValidString("{)"))
        assertFalse(isValidString("[}"))
    }

    @Test
    fun `rejects wrongly ordered brackets`() {
        assertFalse(isValidString("([)]"))
        assertFalse(isValidString("}{"))
    }

    @Test
    fun `rejects unclosed and unopened brackets`() {
        assertFalse(isValidString("("))
        assertFalse(isValidString("{{"))
        assertFalse(isValidString(")"))
        assertFalse(isValidString("(){"))
    }
}
