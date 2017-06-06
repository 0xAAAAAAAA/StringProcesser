import com.sun.istack.internal.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字符串处理器
 *
 * @author Bullet
 * @time 2017-06-06 8:33
 */
public class StringProcesser {

  /**
   * 判断给定的字符串中是否必须且只包含字母和数字
   * @param s 待检查的字符串
   * @return 必须且只包含字母和数字返回true，否则返回false
   */
  public boolean isOnlyContainsNumberAndCharacter(@NotNull String s) {
    boolean containsNumber = false;
    boolean containsCharacter = false;
    boolean containsOthers = false;
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        containsNumber = true;
      } else if (Character.isAlphabetic(c)) {
        containsCharacter = true;
      } else {
        containsOthers = true;
      }
    }
    return containsCharacter && containsNumber && !containsOthers;

  }

  /**
   * 返回反转后字符串
   * @param s 待反转的字符串
   * @return 反转后字符串
   */
  public String reverse(@NotNull String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
    }
    return sb.toString();
  }

  /**
   * 对字符串中的字符进行计数
   * @param s 给定的字符串
   * @return key为字符，value为计数的Map
   */
  public Map<Character, Integer> countCharacter(@NotNull String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for(char c: s.toCharArray()) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    return map;
  }

  /**
   * 查找在s字符串中的所有found子串的首位置
   * @param s 在该串中进行查找
   * @param found 要找到的字符串
   * @return 包含所有找到的子串的首位置的list
   */
  public List<Integer> findSubStringIndex(@NotNull String s, @NotNull String found) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i <= s.length() - found.length(); i++) {
      if (s.substring(i, i + found.length()).equals(found)) {
        list.add(i);
      }
    }
    return list;
  }

  /**
   * 在指定字符串中查找给定子串出现的次数
   * @param s 在该串中进行查找
   * @param subString 要找到的字符串
   * @return 子串的个数
   */
  public int countSubString(@NotNull String s, @NotNull String subString) {
    return findSubStringIndex(s, subString).size();
  }

  /**
   * 递归删除子串，直到不在出现子串
   * @param s 在该串中进行删除
   * @param subString 要删除的子串
   * @return 递归删除后的子串
   */
  public String deleteAllSubString(@NotNull String s, @NotNull String subString) {
    String temp = s;
    while (countSubString(temp, subString) != 0) {
      int index = findSubStringIndex(temp, subString).get(0);
      temp = temp.substring(0, index) + temp.substring(index + subString.length());
    }
    return temp;
  }

  /**
   * 在给定字符串的[1/2]处插入
   * @param s 在该串中进行插入
   * @param subString 要插入的字符串
   * @return 插入后的字符串
   */
  public String insertInHalf(@NotNull String s, @NotNull String subString) {
    return s.substring(0, s.length() / 2) + subString + s.substring(s.length() / 2);
  }


}
