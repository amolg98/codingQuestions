package CTCI;

public class IsUnique {
    
    public boolean isUnique(String s) {

        boolean[] bitMap = new boolean[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        
        for (char c: s.toCharArray()) {
            int charValue = Character.getNumericValue(c);
            int baseValue = Character.getNumericValue('a');
            int index = charValue - baseValue;
            // System.out.println("Index is " + index);
            if (bitMap[index])  
                return false;
            else 
                bitMap[index] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "Uniqueal";
        IsUnique isUnique = new IsUnique();
        System.out.println("Output of first String is " + isUnique.isUnique(s));

        s = "Uniqeal";
        System.out.println("Output of second String is " + isUnique.isUnique(s));
    }
}
