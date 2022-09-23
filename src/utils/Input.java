package utils;

import java.util.Scanner;

/**
 * Version 1.0.3
 * @author Bao Phan
 */
public class Input {
    private final static Scanner sc = new Scanner(System.in);
    
    public static String getString(String label, String name, int minLength) {
        boolean isValid = false;
        String result;
        
        do {
            System.out.print(label);
            result = sc.nextLine();
            result = result.trim();
            if (result.length() < minLength) {
                System.out.println(name + " must longer than " + minLength + " characters");
            } else {
                isValid = true;
            }
            
        } while (isValid == false);
        
        return result;
    }
    
    public static String getString() {
        return sc.nextLine();
    }
    
    public static String getString(String label) {
        System.out.print(label);
        return sc.nextLine();
    }
    
    public static String getStringReg(String label, String name, String pattern) {
        boolean isValid = false;
        String result;
        
        do {
            System.out.print(label);
            result = sc.nextLine();
            result = result.trim();
            
            if (result.isEmpty()) {
                System.out.println(name + " can not be empty");
            } else if (!result.matches(pattern)) {
                System.out.println(name + " have invalid format");
            } else {
                            isValid = true;
            }
        } while (isValid == false);
        
        return result;
    }
    
    public static Integer getInt(String label, String name, int minValue) {
        boolean isValid = false;
        Integer result = null;
        
        do {
            try {
                System.out.print(label);
                result = Integer.parseInt(sc.nextLine());
                if (result == null) {
                    System.out.println(name + " cannot be empty");
                } else if (result < minValue) {
                    System.out.println(name + " must larger than " + minValue);
                } else {
                    isValid = true;
                }
            
            } catch (NumberFormatException numEx) {
                System.out.println(name + " must be an integer.");
            }
        } while (isValid == false);
        
        return result;
    }
    
        public static Integer getInt(String label, String name, int minValue, int maxValue) {
        boolean isValid = false;
        Integer result = null;
        
        do {
            try {
                System.out.print(label);
                result = Integer.parseInt(sc.nextLine());
                if (result == null) {
                    System.out.println(name + " cannot be empty");
                } else if (result < minValue) {
                    System.out.println(name + " must larger than " + minValue);
                } else if (maxValue != -1 && result > maxValue) {
                    System.out.println(name + " must smaller than " + minValue);
                } else {
                    isValid = true;
                }
            
            } catch (NumberFormatException numEx) {
                System.out.println(name + " must be an integer.");
            }
        } while (isValid == false);
        return result;
    }
    
    public static Float getFloat(String label, String name, float minValue, float maxValue) {
        boolean isValid = false;
        Float result = null;
        
        do {
            try {
                System.out.print(label);
                result = Float.parseFloat(sc.nextLine());
                if (result == null) {
                   System.out.println(name + " cannot be empty");
                } else if (result < minValue) {
                   System.out.println(name + " must larger than " + minValue);
                } else if (result > maxValue) {
                   System.out.println(name + " must smaller than " + maxValue);
                } else {
                    isValid = true;
                }
            } catch (NumberFormatException numEx) {
                isValid = false;

               System.out.println(name + " must be an float number.");
            }
        } while (isValid == false);
        
        return result;
    }
    
        
    public static Double getDouble(String label, String name, double minValue, double maxValue) {
        boolean isValid = false;
        Double result = null;
        
        do {
            try {
                System.out.print(label);
                result = Double.parseDouble(sc.nextLine());
                
               if (result < minValue) {
                   System.out.println(name + " must larger than " + minValue);
                } else if (result > maxValue) {
                   System.out.println(name + " must smaller than " + maxValue);
                } else {
                    isValid = true;
                }
            } catch (NumberFormatException numEx) {
                isValid = false;

               System.out.println(name + " must be an float number.");
            }
        } while (isValid == false);
        
        return result;
    }
}
