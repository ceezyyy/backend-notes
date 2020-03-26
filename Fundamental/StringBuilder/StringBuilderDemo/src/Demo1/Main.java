package Demo1;

//String cannot be modified, while StringBuilder can be modified
//
//    private final byte[] value;
//
//
//    public final class StringBuilder extends AbstractStringBuilder implements Serializable, Comparable<java.lang.StringBuilder>, CharSequence {
//        static final long serialVersionUID = 4383685877147921099L;
//
//        @HotSpotIntrinsicCandidate
//        public StringBuilder() {
//            super(16);
//        }
//
//        @HotSpotIntrinsicCandidate
//        public StringBuilder(int capacity) {
//            super(capacity);
//        }
//
//        @HotSpotIntrinsicCandidate
//        public StringBuilder(java.lang.String str) {
//            super(str.length() + 16);
//            this.append(str);
//        }

public class Main {
    public static void main(String[] args) {

        StringBuilder string = new StringBuilder("abc");
        System.out.println(string);
        StringBuilder string1 = string.append("abc");
        System.out.println(string1);

        // the same address
        System.out.println(string == string1);
        System.out.println(string);
        System.out.println(string1);
        System.out.println(string.hashCode());  // 1607521710
        System.out.println(string1.hashCode());  // 1607521710

        // StringBuilder -> String
        String newString = string1.toString();
        System.out.println(newString);
    }


}


