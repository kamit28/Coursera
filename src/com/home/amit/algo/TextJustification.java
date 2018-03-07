package com.home.amit.algo;

public class TextJustification {

	public static String justify(String[] words, int maxWidth, int index) {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < words.length;) {
			int length = 0;
			int offset = i;
			int end = offset;
			while (i < words.length && length + words[i].length() < maxWidth) {
				length += words[i].length() + 1;
				end++;
				i++;
			}

			length--;
			int remaining = maxWidth - length;
			int numWordsInLine = end - offset;
			int justificationWidth = 0;
			int remainingWidth = 0;
			if (numWordsInLine > 1) {
				justificationWidth = (remaining / (numWordsInLine - 1)) + 1;
				remainingWidth = remaining % (numWordsInLine - 1);
			} else {
				justificationWidth = remaining - 1;
			}
			for (int start = offset; start < end; start++) {
				buf.append(words[start]);
				if (numWordsInLine == 1) {
					for (int k = 0; k < remaining; k++) {
						buf.append(" ");
					}
				} else {
					for (int k = 0; k < justificationWidth && end - start > 1; k++) {
						buf.append(" ");
					}
					if (remainingWidth > 0) {
						buf.append(" ");
						remainingWidth--;
					}
				}
			}
			buf.append("\n");
		}

		return buf.toString();
	}

	public static void main(String[] args) {
		String[] words = { "This", "is", "a", "text", "justification", "problem", "in", "tutorial", "horizon" };

		System.out.println(justify(words, 20, 0));
	}

}
