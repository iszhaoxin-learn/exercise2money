import java.util.*;

/**
 * https://leetcode.com/problems/open-the-lock/
 */

class Solution {
    public int openLock(String[] deadends, String target) {
        int level = 0;
        int size;
        Queue<String> status_queue = new LinkedList<String>();
        Set<String> deads = new HashSet<String>(Arrays.asList(deadends));
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        status_queue.offer("0000");
        visited.put("0000", true);
        while(!status_queue.isEmpty()){
            size = status_queue.size();
            while (size>0){
                String current = status_queue.poll();
                if (current.equals(target)) return level;
                if(deads.contains(current)){
                    size --;
                    continue;
                }
                else{
                    size --;
                    visited.put(current, true);
                    for(int i=0; i<4; i++){
                        char c = current.charAt(i);
                        String next = current.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + current.substring(i+1);
                        String prev = current.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + current.substring(i+1);
                        if (!visited.containsKey(next) && !deads.contains(next)){
                            status_queue.offer(next);
                            visited.put(next, true);
                        }
                        if (!visited.containsKey(prev) && !deads.contains(prev)){
                            status_queue.offer(prev);
                            visited.put(prev, true);
                        }
                    }
                }
            }
            level += 1;
        }
        return -1;
    }

};

/**
 * 关键点1：使用BFS
 * Here is the Pesudocode:
 * 1. Let Q be the status queue
 * 2. Let H be the historical visited nodes
 * 3. Put root node into Q, mark root node as visited
 * 4. While Q is not empty:
 * 5.     Poll Q as node v
 * 6.     if v not goal:
 * 7.          return
 * 8.     else:
 * 9.         for w in v's neighbourhood:
 * 10.             put w into Q
 * 11.             mark w as visited
 */

/**
 * 1. 一个需要注意的点，java中的字符相等的判断，不能用==， 必须用 equals function.
 */

// Still need work