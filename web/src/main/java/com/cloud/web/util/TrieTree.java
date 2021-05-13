package com.cloud.web.util;

import com.cloud.web.model.TreeNode;

public class TrieTree {

    public TreeNode root;

    public TrieTree(){
        root=new TreeNode();
    }


    /**在前缀树中插入字符串
     * 这种++的方法，导致，一个node，有多少个end，就有多少个相同的字符串
     * 一个node，有多少个path，就有多少个字符串经过（root的path代表有多少个字符串）（字符串末尾的node的path也会++）
     * @param string 被插入的字符串（以前插入过的也可以插入）
     */
    public void insertString(String string){
        if(string==null||string.length()==0){
            return;
        }
        int length=string.length();
        TreeNode nowNode=root;
        for(int i=0;i<length;i++){
            char now=string.charAt(i);
            int index=now-'a';
            //index为字符now所处的位置
            if(nowNode.next[index]==null){
                nowNode.next[index]=new TreeNode();
            }
            //先对当前node的path++，再转移到下一个node
            nowNode.path++;
            nowNode=nowNode.next[index];

        }
        //在最后的node，path和end++
        nowNode.path++;
        nowNode.end++;
    }


    /**返回这个前缀树总共插入了多少个字符串
     * @return
     */
    public int size(){
        return root.path;
    }


    /**前缀树查询总共插入这个字符串多少次，如果没插入过，则返回0
     * @param string
     * @return
     */
    public int getStringNum(String string){
        if(string==null||string.length()==0){
            return 0;
        }
        int length=string.length();
        TreeNode nowNode=root;
        for(int i=0;i<length;i++){
            char now=string.charAt(i);
            int index=now-'a';
            //如果没有这个节点，说明不存在，直接返回0
            if(nowNode.next[index]==null){
                return 0;
            }
            nowNode=nowNode.next[index];
        }
        //此时nowNode已经处于最后一个节点
        return nowNode.end;
    }

    /**前缀树查询以这个字符串为前缀的字符串总共多少个（包括以他为结尾的）
     * @param string 前缀
     * @return
     */
    public int getPrefixNum(String string){
        if(string==null||string.length()==0){
            return 0;
        }
        int length=string.length();
        TreeNode nowNode=root;
        for(int i=0;i<length;i++){
            char now=string.charAt(i);
            int index=now-'a';
            //如果没有这个节点，说明前缀不存在，直接返回0
            if(nowNode.next[index]==null){
                return 0;
            }
            nowNode=nowNode.next[index];
        }
        //此时nowNode已经处于前缀的最后一个节点
        return nowNode.path;
    }

    public static void main(String[] args) {
        TrieTree tree=new TrieTree();
        tree.insertString("aa");
        tree.insertString("aa");
        tree.insertString("ab");
        tree.insertString("ba");
        //System.out.println(tree.root);
        //System.out.println(tree.size());
        //System.out.println(tree.getStringNum("aa"));
        //System.out.println(tree.getStringNum("ab"));
        //System.out.println(tree.getStringNum("ac"));
        System.out.println(tree.getPrefixNum("a"));
        System.out.println(tree.getPrefixNum("b"));
        System.out.println(tree.getPrefixNum("c"));
    }
}
