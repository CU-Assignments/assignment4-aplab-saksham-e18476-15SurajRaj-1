class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        
        while (result.size() < n) {
            List<Integer> temp = new ArrayList<>();
            
            for (int num : result) {
                if (num * 2 - 1 <= n) temp.add(num * 2 - 1);
            }

            for (int num : result) {
                if (num * 2 <= n) temp.add(num * 2);
            }

            result = temp;
        }  

        return result.stream().mapToInt(i -> i).toArray();
    }
}
/*
OUTPUT:
Input
n =
4
Output
[1,3,2,4]
Expected
[2,1,4,3]*/
