//풀이수준 : A-
//구현수준 : B
class Solution {
    public String solution(String new_id) {
        //level1
        new_id = new_id.toLowerCase();

        //level2
        new_id = new_id.replaceAll("[[^a-z0-9\\-_.]]", "");

        //level3
        while (true) {
            if (new_id.contains("..")) {
                new_id = new_id.replaceAll("\\.\\.", ".");
            } else {
                break;
            }
        }

        //level4
        new_id = new_id.charAt(new_id.length() - 1) == '.' ? new_id.substring(0, new_id.length() - 1) : new_id;
        if (!new_id.isEmpty()) {
            new_id = new_id.charAt(0) == '.' ? new_id.substring(1) : new_id;
        }

        //level5
        new_id = new_id.isEmpty() ? "a" : new_id;

        //level6
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }

        //level7
        char c = new_id.charAt(new_id.length() - 1);
        while (true) {
            if (new_id.length() <= 2) {
                new_id += c;
            }else{
                break;

            }
        }
        new_id = new_id.charAt(new_id.length() - 1) == '.' ? new_id.substring(0, new_id.length() - 1) : new_id;

        return new_id;
    }
}