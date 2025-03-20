import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void calcPrice() {
        assertEquals(20.0, Main.calcPrice(10.0, 2.0));
        assertEquals(0.0, Main.calcPrice(0.0, 5.0));
        assertEquals(15.75, Main.calcPrice(3.15, 5.0));
    }

    @org.junit.jupiter.api.Test
    void calcTotalCartCost(){
        double[] prices = {10.0, 20.0, 30.0};
        int[] quantities = {1, 2, 3};
        assertEquals(140.0, Main.calcTotalCartCost(prices, quantities));

        double[] prices2 = {5.0, 15.0};
        int[] quantities2 = {2, 4};
        assertEquals(70.0, Main.calcTotalCartCost(prices2, quantities2));
    }
}