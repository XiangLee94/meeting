package com.meeting.datastructure.tree.trie;

public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addStr("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.prefixNumber("app"));
        trie.addStr("app");
        System.out.println(trie.search("app"));
    }


    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void addStr(String string) {
        TrieNode node = root;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.path++;
        }
        node.end++;
    }

    public boolean search(String string) {
        TrieNode node = root;
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            TrieNode child = node.children[index];
            if (child == null) {
                return false;
            }
            node = child;
        }
        return node.end != 0;
    }

    public void deleteStr(String string) {
        if (search(string)) {
            TrieNode node = root;
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (node.children[index].path-- == 1) {
                    node.children[index] = null;
                    return;
                }
                node = node.children[index];
            }
            node.end--;
        }
    }

    public int prefixNumber(String string) {
        char[] chars = string.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (node.children[index] == null) {
                return 0;
            }
            node = node.children[index];
        }
        return node.path;
    }


    static class TrieNode {
        //经过这个节点的路径计数
        int path;
        //以这个节点为终点的路径计数
        int end;
        //该节点的孩子，本应该为map，这里仅考虑小写字母，可以使用数组替换map
        public TrieNode[] children;

        public TrieNode() {
            path = 0;
            end = 0;
            children = new TrieNode[26];
        }
    }

}
