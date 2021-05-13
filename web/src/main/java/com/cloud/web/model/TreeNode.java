package com.cloud.web.model;

import java.util.Arrays;

public class TreeNode {

    //经过这个节点的字符串的个数（以这个节点为前缀的字符串的个数）
    public int path;
    //以这个节点结束的字符串的个数（有多少个字符串有这条路径的char组成）
    public int end;
    //对应着小写的a-z的26个字母（如果要更多可以使用hashmap<char,Node>
    public TreeNode[] next;

    public TreeNode(){
        path=0;
        end=0;
        next=new TreeNode[26];
    }

    @Override
    public String toString() {
        return "TreeNode [path=" + path + ", end=" + end + ", next=" + Arrays.toString(next) + "]";
    }
}
