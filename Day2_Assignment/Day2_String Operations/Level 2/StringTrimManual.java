public class StringTrimManual {
    public static int[] getTrimBounds(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start <= end && text.charAt(start) == ' ') start++;
        while (end >= start && text.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }
    public static String manualSub(String text, int start, int end) {
        if (start > end) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String input = "   Hello Java   ";
        int[] bounds = getTrimBounds(input);
        String manualTrimmed = manualSub(input, bounds[0], bounds[1]);
        String builtInTrimmed = input.trim();
        System.out.println("Manual: [" + manualTrimmed + "]");
        System.out.println("Match Built-in: " + manualTrimmed.equals(builtInTrimmed));
    }
}