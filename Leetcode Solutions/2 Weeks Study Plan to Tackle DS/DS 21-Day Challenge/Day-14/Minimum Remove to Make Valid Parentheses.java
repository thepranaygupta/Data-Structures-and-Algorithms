class Solution {
    public String minRemoveToMakeValid(String s) {
		int openCloseCount = 0;
		int close = 0;
		for (int i = 0; i < s.length(); i++)  if (s.charAt(i) == ')') close++;
        StringBuilder sb = new StringBuilder();
		for (char c: s.toCharArray()) {
			if (c == '(') {
				if (openCloseCount == close) continue;
				openCloseCount++;
			} else if (c == ')') {
				close--;
				if (openCloseCount == 0) continue;
				openCloseCount--;
			}
				sb.append(c);
		}
		return sb.toString();
    }
}