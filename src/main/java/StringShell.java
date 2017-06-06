import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 用于操作字符串的Shell控制台
 *
 * @author Bullet
 * @time 2017-06-06 14:41
 */
public class StringShell {

  Scanner sc = new Scanner(System.in);
  String str = "";
  StringProcesser sp = new StringProcesser();

  public static void main(String[] args) {
    new StringShell().run();
  }

  /**
   * 执行一个shell
   */
  public void run() {
    System.out.print(" > ");
    while (true) {
      if (sc.hasNext()) {
        String line = sc.nextLine();
        doCommand(line);
      }
      System.out.print(" > ");
    }
  }

  private void doCommand(String line) {
    String[] args = line.split(" ");
    if ((args.length > 1) && (args[1].charAt(args[1].length() - 1) == '"') && (args[1].charAt(0)
        == '"')) {
      args[1] = args[1].substring(1, args[1].length() - 1);
    }
    switch (args[0]) {          // JDK1.7 后支持String语法糖
      case "build":
        doBuild(args);
        break;
      case "help":
        doHelp(args);
        break;
      case "exit":
        doExit(args);
        break;
      case "find":
        doFind(args);
        break;
      case "count_char":
        doCountChar(args);
        break;
      case "reverse":
        doReverse(args);
        break;
      case "count_sub":
        doCountSub(args);
        break;
      case "delete":
        doDelete(args);
        break;
      case "show":
        doShow(args);
        break;
      default:
        doHelp(args);
        break;
    }

  }

  private void doDelete(String[] args) {
    str = sp.deleteAllSubString(str, args[1]);
    System.out.println("删除子串后的字符串: " + str);
  }

  private void doCountSub(String[] args) {
    System.out.println("该子串在给定字符串中出现的次数: " + sp.countSubString(str, args[1]));
  }

  private void doReverse(String[] args) {
    str = sp.reverse(str);
    System.out.println("新的字符串: " + str);
  }

  private void doCountChar(String[] args) {
    Map<Character, Integer> map = sp.countCharacter(str);
    System.out.println("各个字符字符串中出现的次数：");
    for (Entry<Character, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }

  private void doFind(String[] args) {
    if (args.length != 2) {
      System.out.println("参数个数必须为2!");
    } else {
      List<Integer> list = sp.findSubStringIndex(str, args[1]);
      System.out.print("此字符串所在下标：");
      for (int a : list) {
        System.out.print(a + ",");
      }
      System.out.println();
    }
  }

  private void doExit(String[] args) {
    System.exit(0);
  }

  private void doHelp(String[] args) {
    System.out.println("这里是帮助:");
    System.out.println("build: usage: build string. 建立一个密码字符串，并检查是否合理");
    System.out.println("help: usage: help. 打印此帮助信息");
    System.out.println("reverse: usage: reserve. 将字符串进行反转");
    System.out.println("exit: usage: exit. 退出此程序");
    System.out.println("count_char: usage: count_char. 统计各单词个数");
    System.out.println("count_sub: usage: count_sub sub. 统计此sub词项在该字符串中的次数");
    System.out.println("find: usage: find sub. 查找sub子串在该字符串中出现的位置");
    System.out.println("delete: usage: delete sub. 从该字符串中递归删除sub子串");
  }

  private void doBuild(String[] args) {
    if (!sp.isOnlyContainsNumberAndCharacter(args[1])) {
      System.out.println("字符串必须且只包含数字和字母！");
    } else {
      str = args[1];
    }
  }

  private void doShow(String[] args) {
    System.out.println(str);
  }

}
