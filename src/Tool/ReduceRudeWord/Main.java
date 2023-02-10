package Tool.ReduceRudeWord;

/**
 * @author Justice_wby
 * @create 2023-02-03 2:41
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 创建 AC 自动机
        ACAutomaton ac = new ACAutomaton();
        // 添加敏感字符
        ac.addKeyword("色情");
        ac.addKeyword("赌博");
        ac.addKeyword("炸学校");
        // 构建失配指针
        ac.buildFailPointer();
        // 在文本中匹配模式串
        String text = "我喜欢色情的东西，我想要炸学校，然后去赌博";
        String filteredText = ac.filter(text);
        System.out.println(filteredText);
    }
}
class ACAutomaton {

    private ACNode root = new ACNode('/'); // AC自动机的根节点

    // 将一个敏感词添加到AC自动机中
    public void addKeyword(String keyword) {
        ACNode p = root;
        for (int i = 0; i < keyword.length(); i++) {
            char c = keyword.charAt(i);
            ACNode child = p.children.get(c);
            if (child == null) {
                child = new ACNode(c);
                p.children.put(c, child);
            }
            p = child;
        }
        p.isEndingChar = true;
    }

    // 在AC自动机中匹配文本
    public String filter(String text) {
        StringBuilder sb = new StringBuilder();
        ACNode p = root;
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            p = p.children.get(c);
            if (p == null) {
                // 不匹配, 将字符加入结果, 重新从根开始匹配
                sb.append(c);
                p = root;
            } else if (p.isEndingChar) {
                // 匹配, 将替换字符加入结果, 重新从根开始匹配
                sb.append("***");
                p = root;
            }
        }
        // 将剩余的字符加入结果
        if(length <= p.length) {
            sb.append(text.substring(length - p.length));
        }
        return sb.toString();
    }

    public void buildFailPointer() {
        LinkedList<ACNode> queue = new LinkedList<>();
        // 将每一个非根节点的 fail 指针指向根节点
        for (ACNode child : root.children.values()) {
            child.fail = root;
            queue.add(child);
        }
        // BFS 遍历整棵 Trie 树
        while (!queue.isEmpty()) {
            ACNode p = queue.poll();
            // 将 p 的子节点的 fail 指针都指向 p 的 fail 指针指向的节点的对应子节点
            for (ACNode child : p.children.values()) {
                ACNode q = p.fail;
                while (q != null) {
                    ACNode temp = q.children.get(child.data);
                    if (temp != null) {
                        child.fail = temp;
                        break;
                    }
                    q = q.fail;
                }
                // 如果找不到匹配的节点，就将 fail 指针指向根节点
                if (q == null) {
                    child.fail = root;
                }
                queue.add(child);
            }
        }
    }

    private class ACNode {
        char data;
        Map<Character, ACNode> children = new HashMap<>();
        int length = -1; // 当isEndingChar=true时, 记录模式串长度
        boolean isEndingChar = false; // 结束字符为true
        ACNode fail; // 失配指针

        ACNode(char data) {
            this.data = data;
        }
    }
}



