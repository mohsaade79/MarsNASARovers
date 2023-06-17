import org.alaf.model.Direction;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DirectionTest {

    private Direction direction;

    @Before
    public void init(){
        direction=Direction.N;
    }
    @Test
    public void testToLeft(){
        Direction direction1=direction.toLeft();
        Assert.assertEquals(direction1.getName(),"West");
    }

    @Test
    public void testToRight(){
        Direction direction1=direction.toRight();
        Assert.assertEquals(direction1.getName(),"Est");
    }
}
