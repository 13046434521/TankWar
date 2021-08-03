import com.jtl.tank.PropertyManager;

/**
 * @author jtl
 * @date 2021/8/3 16:34
 */

class ProTest {
    public static void main(String[] args) {
        System.out.println(PropertyManager.getInstance().getString("initEnemyCount"));
    }
}
