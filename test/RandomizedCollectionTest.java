import common.RandomizedCollection;
import org.junit.Test;

/**
 * @author Hujf
 * @title: RandomizedCollectionTest
 * @date 2020/10/31 0031上午 9:10
 * @description: TODO
 */
public class RandomizedCollectionTest {

    @Test
    public void t(){
        RandomizedCollection r = new RandomizedCollection();
        r.insert(1);
        r.insert(1);
        r.insert(2);
        r.getRandom();
        r.remove(1);
        r.getRandom();

    }
}
