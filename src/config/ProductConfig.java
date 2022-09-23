package config;

/**
 *
 * @author quocb
 */
public class ProductConfig {
     public static final Integer MIN_UNIT_PRICE = 0;
    public static final Integer MAX_UNIT_PRICE = 10000;
    public static final Integer MIN_QUANTITY = 0;
    public static final Integer MAX_QUANTITY = 1000;
    public static final String ID_REGEX = "\\W*(PRD|prd)\\d{5}\\W*$";
}
