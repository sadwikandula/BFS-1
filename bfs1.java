# BFS-1
# Problem 1
Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int s=q.size();
            List<Integer> l= new ArrayList<>();
            for(int i=0;i<s;i++)
            {
                TreeNode curr=q.poll();
                l.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);

            }
            res.add(l);
        }
        return res;  
    }
}

*********DFS************

// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res= new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        dfs(root,0);
        System.out.println(res);
        return res;


    }
    public void dfs(TreeNode root,int level)
    {
        if(root==null)
        {
            return;
        }
        if(res.size()==level)
        {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}



# Problem 2
Course Schedule (https://leetcode.com/problems/course-schedule/)

// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes 



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        int[] indegree=new int[numCourses];
        for(int edge[]:prerequisites)
        {
            int in=edge[0];
            int out=edge[1];
            indegree[in]++;
            if(!map.containsKey(out))
            {
                map.put(out,new ArrayList<Integer>());
            }
            map.get(out).add(in);
        }
        Queue<Integer> q=new LinkedList<>();
        int count=0;
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
                count++;
            } 
        }
        if(count==numCourses)
            return true;
        while(!q.isEmpty())
        {
            List<Integer> l=map.get(q.poll());
            if(l!=null)
            {
                for(int j:l)
                {
                    indegree[j]--;
                    if(indegree[j]==0){
                        count++;
                        q.add(j);
                    }
                }
            }
        }
        return count==numCourses;    
    }
}
