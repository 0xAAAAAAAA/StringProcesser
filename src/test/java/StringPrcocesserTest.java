import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * StringProcesser的测试类
 *
 * @author Bullet
 * @time 2017-06-06 8:38
 */
public class StringPrcocesserTest {

  StringProcesser sp = new StringProcesser();

  @Test
  public void testIscContaninsNumberOrCharacter() {
    Assertions.assertEquals(true, sp.isOnlyContainsNumberAndCharacter("123456asdsddsfgdfg"));
    Assertions.assertEquals(false, sp.isOnlyContainsNumberAndCharacter("sd,df.gsfgkf"));
    Assertions.assertEquals(false, sp.isOnlyContainsNumberAndCharacter("111"));
    Assertions.assertEquals(false, sp.isOnlyContainsNumberAndCharacter("aaa"));
  }

  @Test
  public void testReverse() {
    Assertions.assertEquals("321", sp.reverse("123"));
    Assertions.assertEquals("abf123", sp.reverse("321fba"));
  }

  @Test
  public void testCountCharacter() {
    HashMap<Character, Integer> map = new HashMap<>();
    map.put('a', 1);
    map.put('b', 2);
    map.put('1', 1);
    Assertions.assertEquals(map, sp.countCharacter("b1ab"));
  }

  @Test
  public void testFindSubStringIndex() {
    List<Integer> list = new ArrayList<>();
    list.add(0);
    list.add(3);
    Assertions.assertEquals(list, sp.findSubStringIndex("abcabc", "abc"));
  }

  @Test
  public void testCountSubString() {
    Assertions.assertEquals(3, sp.countSubString("abcabcabc", "abc"));
  }

  @Test
  public void testDeleteAllSubString() {
    Assertions.assertEquals("a", sp.deleteAllSubString("abcaabcabc", "abc"));
  }

  @Test
  public void testInsertInHalf() {
    Assertions.assertEquals("abcdabc", sp.insertInHalf("abcabc", "d"));
    Assertions.assertEquals("abcdabca", sp.insertInHalf("abcabca", "d"));
  }

}
