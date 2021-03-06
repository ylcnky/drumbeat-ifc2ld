package fi.aalto.cs.drumbeat.common.string;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.RuntimeErrorException;

/**
 * Regular Expression Utils
 * 
 * @see <a href=
 *      "http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html">
 *      Class Pattern's documentation</a>
 * @see <a href="http://www.zytrax.com/tech/web/regex.htm">Regular Expression -
 *      User Guide</a>
 * 
 * @author Nam Vu
 *
 */
public class RegexUtils {

	public static final Pattern WHITE_SPACE = Pattern.compile("\\s");
	public static final Pattern NON_WORD_CHARACTERS = Pattern.compile("\\W");
	public static final Pattern INTEGER = Pattern.compile("\\p{Digit}+"); // or
																			// \\p{Digit}+
	public static final Pattern DOUBLE = Pattern.compile("[+-]?\\p{Digit}+(\\.)?\\p{Digit}*([eE][+-]?\\p{Digit}+)?");
	public static final Pattern STRING_BETWEEN_APOSTROPHES = Pattern.compile("^\\'([^\\']|(\\'\\'))*\\'");
	public static final Pattern COLON = Pattern.compile(":");
	public static final Pattern COMMA = Pattern.compile(",");
	public static final Pattern COMMA_OR_SEMICOLON = Pattern.compile("[,;]");
	public static final Pattern DOT = Pattern.compile(".");
	public static final Pattern OPENING_CURLY_BRACKET = Pattern.compile("\\{");
	public static final Pattern CLOSING_CURLY_BRACKET = Pattern.compile("\\}");

	public static String getSafeUrl(String s) {
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeErrorException(null, "Unsupported encoding: UTF-8");
		}
	}

	public static String removeNonSafeUrlSymbols(String s) {
		return RegexUtils.NON_WORD_CHARACTERS.matcher(s).replaceAll(StringUtils.EMPTY);
	}

	/**
	 * Splits a string to two parts by splitter
	 * 
	 * @param string
	 *            The string to split
	 * @param splitterRegex
	 *            The regular expression of the splitter
	 * @return An array of two strings (before and after a splitter if it was
	 *         found) or one string (if no splitter was found)
	 */
	public static String[] split2(String string, String splitterRegex) {
		return split2(string, Pattern.compile(splitterRegex));
	}

	/**
	 * Splits a string to two parts by splitter
	 * 
	 * @param string
	 *            The string to split
	 * @param splitterPattern
	 *            The splitter's pattern
	 * @return An array of two strings (before and after a splitter if it was
	 *         found) or one string (if no splitter was found)
	 */
	public static String[] split2(String string, Pattern splitterPattern) {
		return splitterPattern.split(string, 2);
	}

	/**
	 * Splits a string to two parts by splitter
	 * 
	 * @param string
	 *            The string to split
	 * @param splitterRegex
	 *            The regular expression of the splitter
	 * @return An array of strings
	 */
	public static String[] splitAll(String string, String splitterRegex) {
		return splitAll(string, Pattern.compile(splitterRegex));
	}

	/**
	 * Splits a string to two parts by splitter
	 * 
	 * @param string
	 *            The string to split
	 * @param splitterPattern
	 *            The splitter's pattern
	 * @return An array of strings
	 */
	public static String[] splitAll(String string, Pattern splitterPattern) {
		return splitterPattern.split(string, 0);
	}

	/**
	 * Finds the first substring that matches to the specified pattern inside
	 * the string.
	 * 
	 * @param string
	 *            The original string to find in
	 * @param pattern
	 *            The {@link Pattern} of the substring
	 * 
	 * @return A string array that contains either two strings (the founded
	 *         substring and the tail) or one string (the whole string if no
	 *         substring found).
	 * 
	 */
	public static String[] findFirstMatch(String string, Pattern pattern) {
		Matcher matcher = pattern.matcher(string);
		if (matcher.find()) {
			return new String[] { string.substring(matcher.start(), matcher.end()), string.substring(matcher.end()), };
		} else {
			return new String[] { string };
		}
	}

	/**
	 * Finds the first substring that matches to the specified pattern inside
	 * the string.
	 * 
	 * @param string
	 *            The original string to find in
	 * @param regex
	 *            The regular expression of the substring
	 * 
	 * @return A string array that contains either two strings (the founded
	 *         substring and the tail) or one string (the whole string if no
	 *         substring found).
	 * 
	 */
	public static String[] findFirstMatch(String string, String regex) {
		Pattern pattern = Pattern.compile(regex);
		return findFirstMatch(string, pattern);
	}

}
